package com.PaymentWalletApplication.ExceptionHandler;

public class WalletNotFoundException extends RuntimeException {
    public WalletNotFoundException(String message) {
        super(message);
    }
}
