package com.hackerrank.tradingplatform.controller;
import com.hackerrank.tradingplatform.dto.AddMoneyTraderDTO;
import com.hackerrank.tradingplatform.dto.TraderDTO;
import com.hackerrank.tradingplatform.dto.UpdateTraderDTO;
import com.hackerrank.tradingplatform.model.Trader;
import com.hackerrank.tradingplatform.service.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(value = "/trading/traders")
public class TraderController {
    @Autowired
    private TraderService traderService;

    //register
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Trader> registerTrader(@RequestBody @Valid Trader trader) {
        //Trader fetchemail = traderService.getTraderByEmail(trader.getEmail());
    	Optional<Trader> existingTrader = traderService.traderExistsByEmail(trader.getEmail());

if (existingTrader.isPresent()) {
        // Trader already exists — return 400 Bad Request
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

//Trader does not exist — proceed with registration
 Trader saved = traderService.registerTrader(trader);
 return ResponseEntity.status(HttpStatus.CREATED).body(saved);

    }

    //get by email
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TraderDTO> getTraderByEmail(@RequestParam("email") String email) {

Trader trader = traderService.getTraderByEmail(email);
    if (trader == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(new TraderDTO(trader));

    }

    //get all
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TraderDTO> getAllTraders() {
        return traderService.getAllTraders()
                .stream()
                .map(TraderDTO::new)
                .collect(toList());
    }

    //update by email
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateTrader(@RequestBody @Valid UpdateTraderDTO trader) {
        traderService.updateTrader(trader);
    }

    //add money
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TraderDTO> addMoney(@RequestBody @Valid AddMoneyTraderDTO trader) {
        traderService.addMoney(trader);
        return ResponseEntity.ok().build();
    }
}
