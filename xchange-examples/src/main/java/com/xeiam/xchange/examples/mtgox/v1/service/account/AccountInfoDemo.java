/**
 * Copyright (C) 2012 Xeiam LLC http://xeiam.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.xeiam.xchange.examples.mtgox.v1.service.account;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.dto.account.AccountInfo;
import com.xeiam.xchange.service.account.polling.PollingAccountService;

/**
 * Demo requesting account info at MtGox
 */
public class AccountInfoDemo {

  public static void main(String[] args) {

    ExchangeSpecification exchangeSpecification = new ExchangeSpecification("com.xeiam.xchange.mtgox.v1.MtGoxExchange");
    exchangeSpecification.setApiKey("150c6db9-e5ab-47ac-83d6-4440d1b9ce49");
    exchangeSpecification.setSecretKey("olHM/yl3CAuKMXFS2+xlP/MC0Hs1M9snHpaHwg0UZW52Ni0Tf4FhGFELO9cHcDNGKvFrj8CgyQUA4VsMTZ6dXg==");
    exchangeSpecification.setUri("https://mtgox.com");
    exchangeSpecification.setVersion("1");
    Exchange mtgox = ExchangeFactory.INSTANCE.createExchange(exchangeSpecification);

    // Interested in the private account functionality (authentication)
    PollingAccountService accountService = mtgox.getPollingAccountService();

    // Get the account information
    AccountInfo accountInfo = accountService.getAccountInfo();
    System.out.println("AccountInfo as String: " + accountInfo.toString());
  }
}
