package one.digitalinnovation.santander.yasp.repository;

import one.digitalinnovation.santander.yasp.common.entity.BankCard;
import one.digitalinnovation.santander.yasp.common.entity.TaxableCard;

import java.time.LocalDateTime;
import java.util.Optional;

public interface BankCardRepository {
    Optional<BankCard> getBankCardById(Long id);

    void create(BankCard bankCard);

    void clear();

    void addEntry(Long id, LocalDateTime date, double value);

    Optional<TaxableCard> getTaxableCardById(Long id);
}
