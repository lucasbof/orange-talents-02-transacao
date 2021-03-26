package br.com.zup.cardTransaction.transaction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transactionNumber;
    
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime createdAt;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "establishment_id")
    private  Establishment  establishment;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "card_id")
    private Card card;

    @Deprecated
    public Transaction() {
    }

    public Transaction(String transactionNumber, LocalDateTime createdAt, Establishment establishment, Card card) {
        this.transactionNumber = transactionNumber;
        this.createdAt = createdAt;
        this.establishment = establishment;
        this.card = card;
    }

    public Long getId() {
        return id;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public Card getCard() {
        return card;
    }
}
