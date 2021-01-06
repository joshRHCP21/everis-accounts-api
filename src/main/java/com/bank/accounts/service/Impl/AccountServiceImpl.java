package com.bank.accounts.service.Impl;

import com.bank.accounts.entity.AccountResponse;
import com.bank.accounts.service.AccountService;
import io.reactivex.Single;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService
{
    @SneakyThrows
    @Override
    public Single<AccountResponse> getAccountByCardNumber(String cardNumber)
    {
        AccountResponse accountResponse1 = new AccountResponse("1111222233334441", 1000.0);
        AccountResponse accountResponse2 = new AccountResponse("1111222233334442", 500.0);
        AccountResponse accountResponse3 = new AccountResponse("1111222233334443", 1500.0);

        List<AccountResponse> accountResponses = Arrays.asList(accountResponse1, accountResponse2, accountResponse3);

        AccountResponse accountResponse = accountResponses.stream()
                                                          .filter(account -> account.getAccountNumber().equals(cardNumber))
                                                          .findFirst()
                                                          .map(accountR -> {
                                                                accountR.setAccountNumber(accountR.getAccountNumber()+"XXX");
                                                                return accountR;
                                                            })
                                                          .get();

        Thread.sleep(5000);
        return Single.just(accountResponse);
    }
}
