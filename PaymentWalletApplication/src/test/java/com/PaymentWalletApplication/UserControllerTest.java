package com.PaymentWalletApplication;




import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.ArgumentMatchers.any;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.PaymentWalletApplication.Controller.UserController;
import com.PaymentWalletApplication.DTO.AddAmountDTO;
import com.PaymentWalletApplication.DTO.TransactionResponse;
import com.PaymentWalletApplication.DTO.TransferDTO;
import com.PaymentWalletApplication.DTO.UserRequest;
import com.PaymentWalletApplication.DTO.UserResponse;
import com.PaymentWalletApplication.DTO.WalletResponse;
import com.PaymentWalletApplication.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
public class UserControllerTest {
	

	

	@Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testRegisterUser() throws Exception {
        UserRequest request = new UserRequest("John", "password123", "john@example.com");
        UserResponse response = new UserResponse(1, "John", "john@example.com", "User registered successfully");

        when(userService.registerUser(any(UserRequest.class))).thenReturn(response);

        mockMvc.perform(post("/api/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("John"))
                .andExpect(jsonPath("$.emailId").value("john@example.com"))
                .andExpect(jsonPath("$.message").value("User registered successfully"));
    }

    @Test
    void testAddAmount() throws Exception {
        AddAmountDTO request = new AddAmountDTO("john@example.com", 100.0);
        WalletResponse response = new WalletResponse(1, 1, "₹", 100.0);

        when(userService.addAmount(any(AddAmountDTO.class))).thenReturn(response);

        mockMvc.perform(post("/api/users/add-amount")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.balance").value(100.0))
                .andExpect(jsonPath("$.currency").value("₹"));
    }

    @Test
    void testGetBalance() throws Exception {
        WalletResponse response = new WalletResponse(1, 1, "₹", 200.0);

        when(userService.getBalance("john@example.com")).thenReturn(response);

        mockMvc.perform(get("/api/users/balance")
                .param("emailId", "john@example.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.balance").value(200.0))
                .andExpect(jsonPath("$.currency").value("₹"));
    }

    @Test
    void testTransferAmount() throws Exception {
        TransferDTO request = new TransferDTO(1, 2, 50.0);
        TransactionResponse response = new TransactionResponse(1, 1, "SUCCESS", 50.0, java.time.LocalDate.now(), java.time.LocalTime.now());

        when(userService.transferAmount(any(TransferDTO.class))).thenReturn(response);

        mockMvc.perform(post("/api/users/transfer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.amount").value(50.0));
    }



}
