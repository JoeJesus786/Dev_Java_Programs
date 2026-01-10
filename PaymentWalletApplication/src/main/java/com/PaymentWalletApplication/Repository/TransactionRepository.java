package com.PaymentWalletApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PaymentWalletApplication.Entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
