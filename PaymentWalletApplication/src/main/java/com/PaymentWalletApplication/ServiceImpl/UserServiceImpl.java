package com.PaymentWalletApplication.ServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PaymentWalletApplication.DTO.AddAmountDTO;
import com.PaymentWalletApplication.DTO.TransactionResponse;
import com.PaymentWalletApplication.DTO.TransferDTO;
import com.PaymentWalletApplication.DTO.UserRequest;
import com.PaymentWalletApplication.DTO.UserResponse;
import com.PaymentWalletApplication.DTO.WalletResponse;
import com.PaymentWalletApplication.Entity.Currency;
import com.PaymentWalletApplication.Entity.Transaction;
import com.PaymentWalletApplication.Entity.User;
import com.PaymentWalletApplication.Entity.Wallet;
import com.PaymentWalletApplication.ExceptionHandler.InsufficientBalanceException;
import com.PaymentWalletApplication.ExceptionHandler.UserNotFoundException;
import com.PaymentWalletApplication.ExceptionHandler.WalletNotFoundException;
import com.PaymentWalletApplication.Repository.CurrencyRepository;
import com.PaymentWalletApplication.Repository.TransactionRepository;
import com.PaymentWalletApplication.Repository.UserRepository;
import com.PaymentWalletApplication.Repository.WalletRepository;
import com.PaymentWalletApplication.Service.UserService;




@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserRepository userRepo;

    @Autowired
    private WalletRepository walletRepo;

    @Autowired
    private CurrencyRepository currencyRepo;

    @Autowired
    private TransactionRepository transactionRepo;
    
    @Override
    public UserResponse registerUser(UserRequest request) {
        if (userRepo.findByEmail(request.getEmailId()).isPresent()) {
            return new UserResponse(0, "", request.getEmailId(), "User with the given email id already exists");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmailId());
        user = userRepo.save(user);

		Currency currency = currencyRepo.findByName("INR")
		    .orElseGet(() -> {
		        Currency newCurrency = new Currency();
		        newCurrency.setName("INR");
		        newCurrency.setAbbreviation("₹");
		        return currencyRepo.save(newCurrency);
		    });

        Wallet wallet = new Wallet();
        wallet.setUser(user);
        wallet.setCurrency(currency);
        wallet.setBalance(0.0);
        walletRepo.save(wallet);

        return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), "User registered successfully");
    }
    
    public WalletResponse addAmount(AddAmountDTO request) {
        User user = userRepo.findByEmail(request.getEmailId()).orElseThrow(() -> new UserNotFoundException("User not found"));
        Wallet wallet = walletRepo.findByUser(user).orElseThrow(() -> new WalletNotFoundException("Wallet not found"));
        wallet.setBalance(wallet.getBalance() + request.getAmount());
        walletRepo.save(wallet);
        return new WalletResponse(wallet.getId(), user.getId(), wallet.getCurrency().getAbbreviation(), wallet.getBalance());
    }

    
    public WalletResponse getBalance(String emailId) {
        User user = userRepo.findByEmail(emailId).orElseThrow(() -> new UserNotFoundException("User not found"));
        Wallet wallet = walletRepo.findByUser(user).orElseThrow(() -> new WalletNotFoundException("Wallet not found"));
        return new WalletResponse(wallet.getId(), user.getId(), wallet.getCurrency().getAbbreviation(), wallet.getBalance());
    }

    public TransactionResponse transferAmount(TransferDTO request) {
        Wallet fromWallet = walletRepo.findById(request.getFromWalletId()).orElseThrow(() -> new WalletNotFoundException("From wallet not found"));
        Wallet toWallet = walletRepo.findById(request.getToWalletId()).orElseThrow(() -> new WalletNotFoundException("To wallet not found"));

        if (fromWallet.getBalance() < request.getAmount()) {
            throw new InsufficientBalanceException("Insufficient balance. You have Rs " + fromWallet.getBalance() + " balance in your wallet" + fromWallet.getId() );
        }

        fromWallet.setBalance(fromWallet.getBalance() - request.getAmount());
        toWallet.setBalance(toWallet.getBalance() + request.getAmount());
        walletRepo.save(fromWallet);
        walletRepo.save(toWallet);

        Transaction transaction = new Transaction();
        transaction.setWallet(fromWallet);
        transaction.setAmount(request.getAmount());
        transaction.setStatus("SUCCESS");
        transaction.setDate(LocalDate.now());
        transaction.setTime(LocalTime.now());
        transaction = transactionRepo.save(transaction);

        return new TransactionResponse(transaction.getId(), fromWallet.getId(), transaction.getStatus(), transaction.getAmount(), transaction.getDate(), transaction.getTime());
    }

		@Override
		public UserResponse getUserByEmail(String emailId) {
		    User user = userRepo.findByEmail(emailId)
		        .orElseThrow(() -> new RuntimeException("User not found with email: " + emailId));
		    return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), "User found");
		}

}
