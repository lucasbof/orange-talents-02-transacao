package br.com.zup.cardTransaction.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "tb_establishment")
public class Establishment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String address;

    @Deprecated
    public Establishment() {
    }

    public Establishment(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

    public Long getId() {
        return id;
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
}
