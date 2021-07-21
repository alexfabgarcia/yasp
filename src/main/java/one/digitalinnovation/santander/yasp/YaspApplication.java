package one.digitalinnovation.santander.yasp;

import one.digitalinnovation.santander.yasp.common.entity.DebitCard;
import one.digitalinnovation.santander.yasp.common.entity.MealCard;
import one.digitalinnovation.santander.yasp.repository.BankCardRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YaspApplication implements InitializingBean {

	public static void main(String[] args) {
		SpringApplication.run(YaspApplication.class, args);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		BankCardRepository.get().create(DebitCard.builder().withId(1L).build());
		BankCardRepository.get().create(MealCard.builder().withId(2L).build());
	}


}
