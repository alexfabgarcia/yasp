package one.digitalinnovation.santander.yasp.common.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

@Builder(setterPrefix = "with")
@Getter
public class BankCard {
    private final Long id;
    private final BankCardTypeEnum type;
    private final double monthlyTax;
    private final boolean taxFreeForRelationShip;
    private final Set<BankCardEntry> entries = new HashSet<>();

    public boolean isTaxFreeForRelationship() {
        return taxFreeForRelationShip;
    }

    public void addEntry(final LocalDateTime dateTime, final double value) {
        entries.add(BankCardEntry.builder().withDateTime(dateTime).withValue(value).build());
    }

    public boolean hasEntryThisMonth() {
        final Month month = LocalDateTime.now().getMonth();
        return entries.stream().anyMatch(entry -> entry.getDateTime().getMonth().equals(month));
    }
}
