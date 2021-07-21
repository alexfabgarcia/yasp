package one.digitalinnovation.santander.yasp.repository;

import one.digitalinnovation.santander.yasp.common.entity.BankCard;
import one.digitalinnovation.santander.yasp.common.entity.TaxableCard;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class BankCardRepositoryInMemory implements BankCardRepository {

    private static final Map<Long, BankCard> CARD_MAP = new HashMap<>();

    @Override
    public Optional<BankCard> getBankCardById(final Long id) {
        return Optional.ofNullable(CARD_MAP.get(id));
    }

    @Override
    public void create(BankCard bankCard) {
        CARD_MAP.putIfAbsent(bankCard.getId(), bankCard);
    }

    @Override
    public void clear() {
        CARD_MAP.clear();
    }

    @Override
    public void addEntry(final Long id, final LocalDateTime date, final double value) {
        Optional.ofNullable(CARD_MAP.get(id)).ifPresent(card -> card.addEntry(date, value));
    }

    @Override
    public Optional<TaxableCard> getTaxableCardById(final Long id) {
        return getBankCardById(id)
                .map(card -> {
                    if (card instanceof TaxableCard) {
                        return ((TaxableCard) card);
                    }
                    return null;
                });
    }
}
