package br.com.zup.cardTransaction.transaction;

import javax.persistence.*;

@Entity
@Table(name = "tb_card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardNumber;
    private String email;

    @Deprecated
    public Card() {
    }

    public Card(String cardNumber, String email) {
        this.cardNumber = cardNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getEmail() {
        return email;
    }
}
