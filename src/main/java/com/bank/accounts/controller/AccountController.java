package com.bank.accounts.controller;

import com.bank.accounts.entity.AccountResponse;
import com.bank.accounts.service.AccountService;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Log4j2
@RequestMapping("/core/accounts")
public class AccountController
{
    @Autowired
    private final AccountService accountService;

    @GetMapping
    public Single<AccountResponse> getAccounResponseByCardNumber(@RequestParam(name = "cardNumber") String cardNumber)
    {
        log.info(cardNumber);
        return accountService.getAccountByCardNumber(cardNumber);
    }
}
