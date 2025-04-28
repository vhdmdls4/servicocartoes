package com.victorduarte.servicocartoes.application.representation;

import com.victorduarte.servicocartoes.domain.ClientCard;
import com.victorduarte.servicocartoes.domain.enums.CreditCardBrand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardsByClientResponse implements Serializable {
    private String name;
    private CreditCardBrand cardBrand;
    private BigDecimal allowedLimit;

    public static CardsByClientResponse fromModel(ClientCard clientCard){
        return CardsByClientResponse.builder()
                .allowedLimit(clientCard.getCreditLimit())
                .cardBrand(clientCard.getCreditCard().getCardBrand())
                .name(clientCard.getCreditCard().getName())
                .build();
    }
}
