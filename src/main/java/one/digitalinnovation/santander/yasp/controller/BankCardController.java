package one.digitalinnovation.santander.yasp.controller;

import one.digitalinnovation.santander.yasp.common.dto.BankCardTaxDTO;
import one.digitalinnovation.santander.yasp.service.BankCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class BankCardController {

    private final BankCardService bankCardService;

    public BankCardController(final BankCardService bankCardService) {
        this.bankCardService = bankCardService;
    }

    @GetMapping("/{id}/tax")
    ResponseEntity<BankCardTaxDTO> getCardTax(@PathVariable("id") final Long id) {
        final Double tax = bankCardService.getCardTax(id);
        return ResponseEntity.ok(new BankCardTaxDTO(id, tax));
    }
}
