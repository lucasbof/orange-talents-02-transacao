package br.com.zup.cardTransaction.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findTop10ByCardCardNumberOrderByCreatedAtDesc(String cardNumber);

    boolean existsByCardCardNumber(String cardNumber);
}
