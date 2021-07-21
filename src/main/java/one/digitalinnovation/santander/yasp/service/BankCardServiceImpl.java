package one.digitalinnovation.santander.yasp.service;

import one.digitalinnovation.santander.yasp.common.entity.TaxableCard;
import one.digitalinnovation.santander.yasp.common.exception.TaxableCardNotFoundException;
import one.digitalinnovation.santander.yasp.repository.BankCardRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankCardServiceImpl implements BankCardService {
    private final BankCardRepository bankCardRepository;

    public BankCardServiceImpl(BankCardRepository bankCardRepository) {
        this.bankCardRepository = bankCardRepository;
    }

    @Override
    public Double getCardTax(final Long id) {
        final Optional<TaxableCard> taxableCardById = bankCardRepository.getTaxableCardById(id);
        return taxableCardById.map(TaxableCard::getCalculatedTax).orElseThrow(TaxableCardNotFoundException::new);
    }
}
