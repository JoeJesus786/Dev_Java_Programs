package com.PaymentWalletApplication.Service;

import com.PaymentWalletApplication.DTO.AddAmountDTO;
import com.PaymentWalletApplication.DTO.TransactionResponse;
import com.PaymentWalletApplication.DTO.TransferDTO;
import com.PaymentWalletApplication.DTO.UserRequest;
import com.PaymentWalletApplication.DTO.UserResponse;
import com.PaymentWalletApplication.DTO.WalletResponse;

public interface WalletService {

	UserResponse registerUser(UserRequest request);
    WalletResponse addAmount(AddAmountDTO request);
    WalletResponse getBalance(String emailId);
    TransactionResponse transferAmount(TransferDTO request);
}
