package com.amazon.pageObjects.amazon;

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

import com.persado.oss.quality.stevia.selenium.core.WebComponent;

import java.text.MessageFormat;

public class GiftCardDesignPage extends WebComponent {

    public enum GiftCardDesignPageLocators {

        FORMAT_OPTION_STANDARD("gc-customization-type-button-Designs"),
        GIFT_CART_FROM_LIST("css=.a-spacing-base img"),
        USE_THIS_DESIGN_BUTTON("css=#gc-design-picker-footer [type=\"submit\"]"),
        GIFT_CARD_PRICE("css=#gc-buy-box-text span"),
        ADD_TO_CART_BUTTON("css=#gc-buy-box-atc-button");

        private String myLocator;

        GiftCardDesignPageLocators(String locator) {
            myLocator = locator;
        }

        public String get() {
            return myLocator;
        }

        public String getWithParams(Object... params) {
            return MessageFormat.format(myLocator, params);
        }
    }

    public void selectStandardFormatOption() {
        controller().click(GiftCardDesignPageLocators.FORMAT_OPTION_STANDARD.get());
    }

    public void selectSpecificGiftCardFromTemplateList(int number) {
        controller().findElements(GiftCardDesignPageLocators.GIFT_CART_FROM_LIST.get()).get(number - 1).click();
    }

    public Double getSelectedPrice() {
        return Double.parseDouble(controller().waitForElementPresence(GiftCardDesignPageLocators.GIFT_CARD_PRICE.get()).getText().replace("$", ""));
    }

    public void clickAddToCartButton() {
        controller().click(GiftCardDesignPageLocators.ADD_TO_CART_BUTTON.get());
    }


}
