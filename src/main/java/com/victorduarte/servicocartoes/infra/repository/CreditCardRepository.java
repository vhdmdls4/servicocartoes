package com.victorduarte.servicocartoes.infra.repository;

import com.victorduarte.servicocartoes.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    List<CreditCard> findByMinimumIncomeLessThanEqual(BigDecimal minimumIncome);
}
