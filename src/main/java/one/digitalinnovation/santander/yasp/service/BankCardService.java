package one.digitalinnovation.santander.yasp.service;

import one.digitalinnovation.santander.yasp.common.entity.BankCard;
import one.digitalinnovation.santander.yasp.common.exception.CardNotFoundException;
import one.digitalinnovation.santander.yasp.repository.BankCardRepository;

public class BankCardService {
    public Double getCardTax(final Long id) {
        final BankCardRepository bankCardRepository = BankCardRepository.get();
        final BankCard bankCard = bankCardRepository.getBankCardById(id)
                .orElseThrow(CardNotFoundException::new);
        return bankCard.getCalculatedTax();
    }
}
