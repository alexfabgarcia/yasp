package one.digitalinnovation.santander.yasp.service;

import one.digitalinnovation.santander.yasp.common.entity.TaxableCard;
import one.digitalinnovation.santander.yasp.common.exception.TaxableCardNotFoundException;
import one.digitalinnovation.santander.yasp.repository.BankCardRepository;

import java.util.Optional;

public class BankCardService {
    public Double getCardTax(final Long id) {
        final BankCardRepository bankCardRepository = BankCardRepository.get();
        final Optional<TaxableCard> taxableCardById = bankCardRepository.getTaxableCardById(id);
        return taxableCardById.map(TaxableCard::getCalculatedTax).orElseThrow(TaxableCardNotFoundException::new);
    }
}
