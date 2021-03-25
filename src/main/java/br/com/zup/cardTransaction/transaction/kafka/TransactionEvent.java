package br.com.zup.cardTransaction.transaction.kafka;

import br.com.zup.cardTransaction.transaction.Transaction;
import br.com.zup.cardTransaction.transaction.kafka.CardEvent;
import br.com.zup.cardTransaction.transaction.kafka.EstablishmentEvent;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionEvent {

    @JsonProperty("id")
    private String transactionNumber;

    @JsonProperty("valor")
    private BigDecimal value;

    @JsonProperty("estabelecimento")
    private EstablishmentEvent establishment;

    @JsonProperty("cartao")
    private CardEvent card;

    @JsonProperty("efetivadaEm")
    private LocalDateTime createdAt;

    public TransactionEvent() {
    }

    public TransactionEvent(String transactionNumber, BigDecimal value, EstablishmentEvent establishment, CardEvent card, LocalDateTime createdAt) {
        this.transactionNumber = transactionNumber;
        this.value = value;
        this.establishment = establishment;
        this.card = card;
        this.createdAt = createdAt;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public BigDecimal getValue() {
        return value;
    }

    public EstablishmentEvent getEstablishment() {
        return establishment;
    }

    public CardEvent getCard() {
        return card;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Transaction toModel() {
        return new Transaction(transactionNumber, createdAt, establishment.toModel(), card.toModel());
    }
}
