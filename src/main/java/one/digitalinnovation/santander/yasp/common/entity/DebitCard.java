package one.digitalinnovation.santander.yasp.common.entity;

import lombok.Builder;

public class DebitCard extends BankCard implements TaxableCard {

    @Builder(setterPrefix = "with")
    public DebitCard(Long id, double monthlyTax, boolean taxFreeForRelationShip) {
        super(id, BankCardTypeEnum.DEBIT, monthlyTax, taxFreeForRelationShip);
    }

    @Override
    public Double getCalculatedTax() {
        return 0D;
    }
}
