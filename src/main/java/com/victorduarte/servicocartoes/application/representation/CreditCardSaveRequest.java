package com.victorduarte.servicocartoes.application.representation;

import com.victorduarte.servicocartoes.domain.CreditCard;
import com.victorduarte.servicocartoes.domain.enums.CreditCardBrand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardSaveRequest implements Serializable {
    private String name;
    private CreditCardBrand cardBrand;
    private BigDecimal minimumIncome;
    private BigDecimal creditLimit;

    public CreditCard toModel() {
        return new CreditCard(name, cardBrand, minimumIncome, creditLimit);
    }
}
