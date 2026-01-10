package com.PaymentWalletApplication.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PaymentWalletApplication.Entity.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Integer>{

	Optional<Currency> findByName(String name);

}
