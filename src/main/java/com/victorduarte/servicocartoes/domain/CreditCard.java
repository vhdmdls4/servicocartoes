package com.victorduarte.servicocartoes.domain;

import com.victorduarte.servicocartoes.domain.enums.CreditCardBrand;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cartao")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "card_brand", nullable = false)
    private CreditCardBrand cardBrand;
    @Column(name = "minimum_income", nullable = false)
    private BigDecimal minimumIncome;
    @Column(name = "credit_limit", nullable = false)
    private BigDecimal creditLimit;

    public CreditCard(String name, CreditCardBrand cardBrand, BigDecimal minimumIncome, BigDecimal creditLimit) {
        this.name = name;
        this.cardBrand = cardBrand;
        this.minimumIncome = minimumIncome;
        this.creditLimit = creditLimit;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer()
                .getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer()
                .getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CreditCard that = (CreditCard) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer()
                .getPersistentClass()
                .hashCode() : getClass().hashCode();
    }
}
