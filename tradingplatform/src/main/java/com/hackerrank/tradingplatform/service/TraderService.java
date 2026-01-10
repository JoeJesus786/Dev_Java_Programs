package com.hackerrank.tradingplatform.service;

import com.hackerrank.tradingplatform.dto.AddMoneyTraderDTO;
import com.hackerrank.tradingplatform.dto.UpdateTraderDTO;
import com.hackerrank.tradingplatform.model.Trader;
import com.hackerrank.tradingplatform.repository.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service
public class TraderService {
    @Autowired
    private TraderRepository traderRepository;

    public Trader registerTrader(Trader trader) {
        return traderRepository.save(trader);
    }

    public Trader getTraderById(Long id) {
        return traderRepository.findById(id).get();
    }

    public Trader getTraderByEmail(String email) {
        return traderRepository.findByEmail(email).orElse(null);
    }
    public Optional<Trader> traderExistsByEmail(String email)
    {
        return traderRepository.findByEmail(email);
    }
    public List<Trader> getAllTraders() {
        return traderRepository.findAll();
    }

    public void updateTrader(UpdateTraderDTO trader) {
        Trader existingTrader = 
        		traderRepository.findByEmail(trader.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("Trader not found with email: " + trader.getEmail()));
    existingTrader.setName(trader.getName());
    existingTrader.setEmail(trader.getEmail());  

        traderRepository.save(existingTrader);
    }

    public void addMoney(AddMoneyTraderDTO trader) {
        Trader existingTrader = traderRepository
.findByEmail(trader.getEmail())
                .orElseThrow(() -> new RuntimeException("Trader not found with email: " + trader.getEmail()));

        double newBalance = existingTrader.getBalance() + trader.getAmount();
        existingTrader.setBalance(newBalance);

        traderRepository.save(existingTrader);
    }
}
