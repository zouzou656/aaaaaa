package com.stratum.platform.core;

import java.util.Objects;

import jakarta.validation.constraints.NotBlank;

/**
 * Party participating in a payment.
 */
public class Party {

    @NotBlank
    private final String name;

    @NotBlank
    private final String account;

    public Party(String name, String account) {
        this.name = Objects.requireNonNull(name, "name");
        this.account = Objects.requireNonNull(account, "account");
    }

    public String getName() {
        return name;
    }

    public String getAccount() {
        return account;
    }
}
