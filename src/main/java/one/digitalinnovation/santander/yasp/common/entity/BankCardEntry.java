package one.digitalinnovation.santander.yasp.common.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder(setterPrefix = "with")
@Getter
@EqualsAndHashCode(of = "dateTime")
public class BankCardEntry {
    private final LocalDateTime dateTime;
    private final double value;
}
