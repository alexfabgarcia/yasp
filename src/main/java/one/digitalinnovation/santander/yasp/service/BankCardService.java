package one.digitalinnovation.santander.yasp.service;

import one.digitalinnovation.santander.yasp.common.entity.BankCard;
import one.digitalinnovation.santander.yasp.common.entity.BankCardTypeEnum;
import one.digitalinnovation.santander.yasp.common.exception.CardNotFoundException;
import one.digitalinnovation.santander.yasp.common.exception.InvalidCardException;
import one.digitalinnovation.santander.yasp.repository.BankCardRepository;

public class BankCardService {
    public Double getCardTax(final Long id) {
        final BankCardRepository bankCardRepository = BankCardRepository.get();
        final BankCard bankCard = bankCardRepository.getBankCardById(id)
                .orElseThrow(CardNotFoundException::new);

        if (BankCardTypeEnum.DEBIT == bankCard.getType()) {
            System.out.println("Cartão de débito, taxa zerada.");
            return 0D;
        }

        if (BankCardTypeEnum.CREDIT == bankCard.getType()) {
            if (bankCard.isTaxFreeForRelationship()) {
                System.out.println("Cartão de crédito, taxa zerada por bom relacionamento.");
                return 0D;
            }
            if (bankCard.hasEntryThisMonth()) {
                System.out.println("Cartão de crédito, taxa zerada por haver lançamento este mês.");
                return 0D;
            }
            System.out.println("Cartão de crédito, taxa padrão.");
            return bankCard.getMonthlyTax();
        }

        throw new InvalidCardException();
    }
}
