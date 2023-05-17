package com.amazon.tests;

/*-
 * #%L
 * Stevia QA Framework - Core
 * %%
 * Copyright (C) 2013 - 2023 Persado Intellectual Property Limited
 * %%
 * Copyright (c) Persado Intellectual Property Limited. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * * Neither the name of the Persado Intellectual Property Limited nor the names
 * of its contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

import com.persado.oss.quality.stevia.annotations.Preconditions;
import com.amazon.pageObjects.amazon.CartPage;
import com.amazon.pageObjects.amazon.GiftCardDesignPage;
import com.amazon.pageObjects.amazon.GiftCardsPage;
import com.amazon.pageObjects.amazon.HomePage;
import com.persado.oss.quality.stevia.selenium.core.SteviaContext;
import com.persado.oss.quality.stevia.selenium.core.controllers.WebDriverWebController;
import com.persado.oss.quality.stevia.spring.SteviaTestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends SteviaTestBase {

    @Autowired
    protected HomePage homePage;

    @Autowired
    protected GiftCardDesignPage giftCardDesignPage;

    @Autowired
    protected GiftCardsPage giftCardsPage;

    @Autowired
    protected CartPage cartPage;

    @Test
    public void test() {
        Double selectedPrice;
        Double finalPrice;

        SteviaContext.getWebController().navigate("https://www.amazon.com");
        homePage.clickGiftCardsNavBarOption();
        giftCardsPage.clickPrintAtHomeOption();
        giftCardDesignPage.selectStandardFormatOption();
        giftCardDesignPage.selectSpecificGiftCardFromTemplateList(3);
        selectedPrice = giftCardDesignPage.getSelectedPrice();
        giftCardDesignPage.clickAddToCartButton();
        finalPrice = cartPage.getCartSubtotalPrice();
        Assert.assertEquals(selectedPrice, finalPrice);


    }
}
