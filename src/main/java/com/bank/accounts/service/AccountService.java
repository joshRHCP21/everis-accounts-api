package com.bank.accounts.service;

import com.bank.accounts.entity.AccountResponse;
import io.reactivex.Single;

public interface AccountService
{
    Single<AccountResponse> getAccountByCardNumber(String cardNumber);
}
