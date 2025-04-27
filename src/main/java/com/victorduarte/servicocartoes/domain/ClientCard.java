package com.victorduarte.servicocartoes.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class ClientCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String cpf;
    @ManyToOne
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;
    private BigDecimal creditLimit;
}
