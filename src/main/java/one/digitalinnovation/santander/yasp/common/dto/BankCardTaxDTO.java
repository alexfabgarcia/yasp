package one.digitalinnovation.santander.yasp.common.dto;

public class BankCardTaxDTO {
    private final Long id;
    private final Double tax;

    public BankCardTaxDTO(final Long id, final Double tax) {
        this.id = id;
        this.tax = tax;
    }

    public Long getId() {
        return id;
    }

    public Double getTax() {
        return tax;
    }
}
