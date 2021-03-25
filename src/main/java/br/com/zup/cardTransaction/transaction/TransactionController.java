package br.com.zup.cardTransaction.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository repository;

    @GetMapping("/buys/{cardNumber}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getLatestBuys(@PathVariable("cardNumber") String cardNumber) {
        if (cardNumber == null || !repository.existsByCardCardNumber(cardNumber)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartão informado não existe!");
        }

        List<Transaction> transactions = repository.findTop10ByCardCardNumberOrderByCreatedAtDesc(cardNumber);

        return ResponseEntity.ok().body(transactions);
    }
}
