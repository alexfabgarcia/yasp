package one.digitalinnovation.santander.yasp.common.entity;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@AllArgsConstructor
public abstract class BankCard {

    private final Long id;
    private final BankCardTypeEnum type;
    protected final double monthlyTax;
    protected final boolean taxFreeForRelationShip;
    protected final Set<BankCardEntry> entries = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void addEntry(final LocalDateTime dateTime, final double value) {
        entries.add(BankCardEntry.builder().withDateTime(dateTime).withValue(value).build());
    }

}
