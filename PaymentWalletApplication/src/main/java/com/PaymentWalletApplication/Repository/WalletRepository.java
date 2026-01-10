package com.PaymentWalletApplication.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PaymentWalletApplication.Entity.User;
import com.PaymentWalletApplication.Entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Integer>{
	Optional<Wallet> findByUser(User user);
}
