package com.bank.accounts.controller;

import com.bank.accounts.entity.AccountResponse;
import com.bank.accounts.service.AccountService;
import io.reactivex.Single;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api("/core/accounts")
public class AccountController
{
    @Autowired
    private final AccountService accountService;

    @GetMapping
    @ApiOperation(value = "Find accounts by Card Number", notes = "Retrieving the collection of accounts", response = AccountResponse.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = AccountResponse.class)
    })
    public Single<AccountResponse> getAccounResponseByCardNumber(@RequestParam(name = "cardNumber") String cardNumber)
    {
        log.info(cardNumber);
        return accountService.getAccountByCardNumber(cardNumber);
    }
}
