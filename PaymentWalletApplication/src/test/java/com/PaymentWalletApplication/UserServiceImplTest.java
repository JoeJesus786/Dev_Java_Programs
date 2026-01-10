package com.PaymentWalletApplication;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
import com.PaymentWalletApplication.Repository.CurrencyRepository;
import com.PaymentWalletApplication.Repository.TransactionRepository;
import com.PaymentWalletApplication.Repository.UserRepository;
import com.PaymentWalletApplication.Repository.WalletRepository;
import com.PaymentWalletApplication.ServiceImpl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	

	@InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepo;

    @Mock
    private WalletRepository walletRepo;

    @Mock
    private CurrencyRepository currencyRepo;

    @Mock
    private TransactionRepository transactionRepo;

    private User user;
    private Wallet wallet;
    private Currency currency;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1);
        user.setUsername("John");
        user.setEmail("john@example.com");
        user.setPassword("password");

        currency = new Currency();
        currency.setName("INR");
        currency.setAbbreviation("₹");

        wallet = new Wallet();
        wallet.setId(1);
        wallet.setUser(user);
        wallet.setCurrency(currency);
        wallet.setBalance(1000.0);
    }

    @Test
    void testRegisterUser_Success() {
        UserRequest request = new UserRequest("John", "john@example.com", "password");

        when(userRepo.findByEmail(request.getEmailId())).thenReturn(Optional.empty());
        when(userRepo.save(any(User.class))).thenReturn(user);
        when(currencyRepo.findByName("INR")).thenReturn(Optional.of(currency));
        when(walletRepo.save(any(Wallet.class))).thenReturn(wallet);

        UserResponse response = userService.registerUser(request);

        assertEquals("User registered successfully", response.getMessage());
        assertEquals("john@example.com", response.getEmailId());
    }

    @Test
    void testAddAmount_Success() {
        AddAmountDTO dto = new AddAmountDTO("john@example.com", 500.0);

        when(userRepo.findByEmail(dto.getEmailId())).thenReturn(Optional.of(user));
        when(walletRepo.findByUser(user)).thenReturn(Optional.of(wallet));
        when(walletRepo.save(any(Wallet.class))).thenReturn(wallet);

        WalletResponse response = userService.addAmount(dto);

        assertEquals(1500.0, response.getBalance());
    }

    @Test
    void testGetBalance_Success() {
        when(userRepo.findByEmail("john@example.com")).thenReturn(Optional.of(user));
        when(walletRepo.findByUser(user)).thenReturn(Optional.of(wallet));

        WalletResponse response = userService.getBalance("john@example.com");

        assertEquals(1000.0, response.getBalance());
    }

    @Test
    void testTransferAmount_Success() {
        Wallet toWallet = new Wallet();
        toWallet.setId(2);
        toWallet.setBalance(500.0);
        toWallet.setCurrency(currency);

        TransferDTO dto = new TransferDTO(1, 2, 200.0);

        when(walletRepo.findById(1)).thenReturn(Optional.of(wallet));
        when(walletRepo.findById(2)).thenReturn(Optional.of(toWallet));
        when(walletRepo.save(any(Wallet.class))).thenReturn(wallet);
        when(transactionRepo.save(any(Transaction.class))).thenAnswer(invocation -> {
            Transaction t = invocation.getArgument(0);
            t.setId(1);
            t.setDate(LocalDate.now());
            t.setTime(LocalTime.now());
            return t;
        });

        TransactionResponse response = userService.transferAmount(dto);

        assertEquals("SUCCESS", response.getStatus());
        assertEquals(200.0, response.getAmount());
    }

    @Test
    void testGetUserByEmail_Success() {
        when(userRepo.findByEmail("john@example.com")).thenReturn(Optional.of(user));

        UserResponse response = userService.getUserByEmail("john@example.com");

        assertEquals("User found", response.getMessage());
        assertEquals("john@example.com", response.getEmailId());
    }


}
