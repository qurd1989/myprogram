package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CashCardController {

    @GetMapping("/cashcard/{requestedId}")
    public ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {
        CashCard cashCard = new CashCard(requestedId, new BigDecimal("100.00"));
        return ResponseEntity.ok(cashCard);
    }
}
