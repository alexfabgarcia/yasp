package one.digitalinnovation.santander.yasp.common.config;

import one.digitalinnovation.santander.yasp.repository.BankCardRepository;
import one.digitalinnovation.santander.yasp.repository.BankCardRepositoryInMemory;
import one.digitalinnovation.santander.yasp.service.BankCardService;
import one.digitalinnovation.santander.yasp.service.BankCardServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YaspConfiguration {
    @Bean
    public BankCardService bankCardService(BankCardRepository bankCardRepository) {
        return new BankCardServiceImpl(bankCardRepository);
    }

    @Bean
    public BankCardRepository bankCardRepository() {
        return new BankCardRepositoryInMemory();
    }
}
