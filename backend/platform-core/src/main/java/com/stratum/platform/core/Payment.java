package com.stratum.platform.core;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * Canonical payment representation shared across Stratum.
 */
public class Payment {

    private final UUID uetr;

    @NotBlank
    private final String debtorBic;

    @NotBlank
    private final String creditorBic;

    @NotNull
    private final Party debtor;

    @NotNull
    private final Party creditor;

    @Positive
    private final BigDecimal instructedAmount;

    @NotBlank
    private final String currency;

    private final OffsetDateTime requestedExecutionDate;

    public Payment(UUID uetr,
                   String debtorBic,
                   String creditorBic,
                   Party debtor,
                   Party creditor,
                   BigDecimal instructedAmount,
                   String currency,
                   OffsetDateTime requestedExecutionDate) {
        this.uetr = Objects.requireNonNullElseGet(uetr, UUID::randomUUID);
        this.debtorBic = Objects.requireNonNull(debtorBic, "debtorBic");
        this.creditorBic = Objects.requireNonNull(creditorBic, "creditorBic");
        this.debtor = Objects.requireNonNull(debtor, "debtor");
        this.creditor = Objects.requireNonNull(creditor, "creditor");
        this.instructedAmount = Objects.requireNonNull(instructedAmount, "instructedAmount");
        this.currency = Objects.requireNonNull(currency, "currency");
        this.requestedExecutionDate = requestedExecutionDate;
    }

    public UUID getUetr() {
        return uetr;
    }

    public String getDebtorBic() {
        return debtorBic;
    }

    public String getCreditorBic() {
        return creditorBic;
    }

    public Party getDebtor() {
        return debtor;
    }

    public Party getCreditor() {
        return creditor;
    }

    public BigDecimal getInstructedAmount() {
        return instructedAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public OffsetDateTime getRequestedExecutionDate() {
        return requestedExecutionDate;
    }
}
