package one.digitalinnovation.santander.yasp.common.entity;

import lombok.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

@Builder(setterPrefix = "with")
public class BankCard {
    
    private static final Logger log = LoggerFactory.getLogger(BankCard.class);

    private final Long id;
    private final BankCardTypeEnum type;
    private final double monthlyTax;
    private final boolean taxFreeForRelationShip;
    private final Set<BankCardEntry> entries = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void addEntry(final LocalDateTime dateTime, final double value) {
        entries.add(BankCardEntry.builder().withDateTime(dateTime).withValue(value).build());
    }

    public Double getCalculatedTax() {
        if (BankCardTypeEnum.DEBIT == this.type) {
            log.debug("Cartão de débito, taxa zerada.");
            return 0D;
        }

        if (BankCardTypeEnum.CREDIT == this.type) {
            if (taxFreeForRelationShip) {
                log.debug("Cartão de crédito, taxa zerada por bom relacionamento.");
                return 0D;
            }
            if (hasEntriesThisMonth()) {
                log.debug("Cartão de crédito, taxa zerada por haver lançamento este mês.");
                return 0D;
            }
            log.debug("Cartão de crédito, taxa padrão: {}.", monthlyTax);
            return this.monthlyTax;
        }
        return 0D;
    }

    private boolean hasEntriesThisMonth() {
        final Month month = LocalDateTime.now().getMonth();
        return entries.stream().anyMatch(entry -> entry.getDateTime().getMonth().equals(month));
    }
}
