package br.com.zup.cardTransaction.transaction.kafka;

import br.com.zup.cardTransaction.transaction.Establishment;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EstablishmentEvent {

    @JsonProperty("nome")
    private String name;

    @JsonProperty("cidade")
    private String city;

    @JsonProperty("endereco")
    private String address;

    public EstablishmentEvent() {
    }

    public EstablishmentEvent(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public Establishment toModel() {
        return new Establishment(name, city, address);
    }
}
