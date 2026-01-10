package com.PaymentWalletApplication.ServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;

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
import com.PaymentWalletApplication.Repository.CurrencyRepository;
import com.PaymentWalletApplication.Repository.TransactionRepository;
import com.PaymentWalletApplication.Repository.UserRepository;
import com.PaymentWalletApplication.Repository.WalletRepository;
import com.PaymentWalletApplication.Service.WalletService;


@Service
public class WalletServiceImpl implements WalletService{
	
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public UserResponse registerUser(UserRequest request) {
        if (userRepository.findByEmail(request.getEmailId()).isPresent()) {
            return new UserResponse(0, "", request.getEmailId(), "User with the given email id already exists");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmailId());
        user = userRepository.save(user);

        Currency currency = currencyRepository.findById(1).orElseThrow();
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        wallet.setCurrency(currency);
        wallet.setBalance(0.0);
        walletRepository.save(wallet);

        return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), "User registered successfully");
    }

    public WalletResponse addAmount(AddAmountDTO request) {
        User user = userRepository.findByEmail(request.getEmailId())
                .orElseThrow(() -> new RuntimeException("There is no user registered with above email id"));
        Wallet wallet = walletRepository.findByUser(user).orElseThrow();
        wallet.setBalance(wallet.getBalance() + request.getAmount());
        walletRepository.save(wallet);
        return new WalletResponse(wallet.getId(), user.getId(), wallet.getCurrency().getAbbreviation(), wallet.getBalance());
    }

    public WalletResponse getBalance(String emailId) {
        User user = userRepository.findByEmail(emailId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Wallet wallet = walletRepository.findByUser(user).orElseThrow();
        return new WalletResponse(wallet.getId(), user.getId(), wallet.getCurrency().getAbbreviation(), wallet.getBalance());
    }

    @Override
    public TransactionResponse transferAmount(TransferDTO request) {

	if (request.getFromWalletId() == null || request.getToWalletId() == null) {
	        throw new IllegalArgumentException("Wallet IDs must not be null");
	    }


        Wallet fromWallet = walletRepository.findById(request.getFromWalletId())
                .orElseThrow(() -> new RuntimeException("Sender wallet not found"));
        Wallet toWallet = walletRepository.findById(request.getToWalletId())
                .orElseThrow(() -> new RuntimeException("Receiver wallet not found"));

        if (fromWallet.getBalance() < request.getAmount()) {
            throw new InsufficientBalanceException("Insufficient balance. You have Rs " + fromWallet.getBalance() + " balance in your wallet");
        }

        fromWallet.setBalance(fromWallet.getBalance() - request.getAmount());
        toWallet.setBalance(toWallet.getBalance() + request.getAmount());
        walletRepository.save(fromWallet);
        walletRepository.save(toWallet);

        Transaction transaction = new Transaction();
        transaction.setWallet(fromWallet);
        transaction.setAmount(request.getAmount());
        transaction.setStatus("SUCCESS");
        transaction.setDate(LocalDate.now());
        transaction.setTime(LocalTime.now());
        transaction = transactionRepository.save(transaction);

        return new TransactionResponse(transaction.getId(), fromWallet.getId(), transaction.getStatus(),
                transaction.getAmount(), transaction.getDate(), transaction.getTime());
    }

}
