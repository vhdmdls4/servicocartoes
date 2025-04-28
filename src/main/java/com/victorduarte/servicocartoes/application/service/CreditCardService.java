package com.victorduarte.servicocartoes.application.service;

import com.victorduarte.servicocartoes.domain.CreditCard;
import com.victorduarte.servicocartoes.infra.repository.CreditCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreditCardService {
    private final CreditCardRepository repository;
    @Transactional
    public CreditCard save(CreditCard card){
        return repository.save(card);
    }

    public List<CreditCard> findByMinimumIncomeLessThanEqual(Long income){
        return repository.findByMinimumIncomeLessThanEqual(BigDecimal.valueOf(income));
    }


}
