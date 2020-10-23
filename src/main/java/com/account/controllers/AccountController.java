package com.account.controllers;

import com.account.models.Account;
import io.reactivex.Single;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/core")
public class AccountController {

  /**
   * cuenta.
   * 
   * @return
   * @throws InterruptedException 
   */
  @GetMapping("/accounts")
  public Single<Account> getCuenta(@RequestParam(value = "cardNumber") String cardNumber) throws InterruptedException {
    if (cardNumber.toString().isEmpty()) {
      return null;
    }
    char digito = cardNumber.charAt(cardNumber.length() - 1);
    Thread.sleep(5000);
    switch (digito) {
      case '1':
       return (Single.just(new Account(cardNumber + "XXX", 1000.00)));
      case '2':
       return (Single.just(new Account(cardNumber + "XXX", 500.00)));
      case '3':
        return (Single.just(new Account(cardNumber + "XXX", 1500.00)));
      default:
        return null;
    }

  }

}
