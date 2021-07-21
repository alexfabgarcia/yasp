package one.digitalinnovation.santander.yasp.repository;

import one.digitalinnovation.santander.yasp.common.entity.BankCard;
import one.digitalinnovation.santander.yasp.common.entity.TaxableCard;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class BankCardRepository {

    private static final Map<Long, BankCard> CARD_MAP = new HashMap<>();
    private static final BankCardRepository repository = new BankCardRepository();

    private BankCardRepository() {
    }

    public static BankCardRepository get() {
        return repository;
    }

    public Optional<BankCard> getBankCardById(final Long id) {
        return Optional.ofNullable(CARD_MAP.get(id));
    }

    public void create(BankCard bankCard) {
        CARD_MAP.putIfAbsent(bankCard.getId(), bankCard);
    }

    public void clear() {
        CARD_MAP.clear();
    }

    public void addEntry(final Long id, final LocalDateTime date, final double value) {
        Optional.ofNullable(CARD_MAP.get(id)).ifPresent(card -> card.addEntry(date, value));
    }

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
