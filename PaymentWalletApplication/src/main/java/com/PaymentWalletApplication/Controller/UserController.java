package com.PaymentWalletApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PaymentWalletApplication.DTO.AddAmountDTO;
import com.PaymentWalletApplication.DTO.TransactionResponse;
import com.PaymentWalletApplication.DTO.TransferDTO;
import com.PaymentWalletApplication.DTO.UserRequest;
import com.PaymentWalletApplication.DTO.UserResponse;
import com.PaymentWalletApplication.DTO.WalletResponse;
import com.PaymentWalletApplication.Service.UserService;



@RestController
@RequestMapping("/api/users")
public class UserController {

		@Autowired
	    private UserService userService;

	    @PostMapping("/register")
	    public UserResponse registerUser(@RequestBody UserRequest request) {
	        return userService.registerUser(request);
	    }

	    @PostMapping("/add-amount")
	    public WalletResponse addAmount(@RequestBody AddAmountDTO request) {
	        return userService.addAmount(request);
	    }

	    @GetMapping("/balance")
	    public WalletResponse getBalance(@RequestParam String emailId) {
	        return userService.getBalance(emailId);
	    }

	    @PostMapping("/transfer")
	    public TransactionResponse transfer(@RequestBody TransferDTO request) {
	        return userService.transferAmount(request);
	    }
}
