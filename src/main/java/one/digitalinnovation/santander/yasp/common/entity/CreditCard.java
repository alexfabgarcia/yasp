package one.digitalinnovation.santander.yasp.common.entity;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.Month;

@Slf4j
public class CreditCard extends BankCard implements TaxableCard {


    @Builder(setterPrefix = "with")
    public CreditCard(Long id, double monthlyTax, boolean taxFreeForRelationShip) {
        super(id, BankCardTypeEnum.CREDIT, monthlyTax, taxFreeForRelationShip);
    }

    @Override
    public Double getCalculatedTax() {
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

    private boolean hasEntriesThisMonth() {
        final Month month = LocalDateTime.now().getMonth();
        return entries.stream().anyMatch(entry -> entry.getDateTime().getMonth().equals(month));
    }
}
