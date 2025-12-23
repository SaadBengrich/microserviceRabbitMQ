package com.tp31.microservicesmessagingproducer.messaging.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Component
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    private String accountId;
    private String accountName;

    public Account() {
    }

    public Account(String accountId, String accountName) {
        this.accountId = accountId;
        this.accountName = accountName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;
        return Objects.equals(accountId, account.accountId) &&
                Objects.equals(accountName, account.accountName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountName);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", accountName='" + accountName + '\'' +
                '}';
    }
}

