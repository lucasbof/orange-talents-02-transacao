package br.com.zup.cardTransaction.transaction.kafka;

import br.com.zup.cardTransaction.transaction.Card;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CardEvent {

    @JsonProperty("id")
    private String cardNumber;
    private String email;

    public CardEvent() {
    }

    public CardEvent(String cardNumber, String email) {
        this.cardNumber = cardNumber;
        this.email = email;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getEmail() {
        return email;
    }
    public Card toModel() {
        return new Card(cardNumber, email);
    }

}
