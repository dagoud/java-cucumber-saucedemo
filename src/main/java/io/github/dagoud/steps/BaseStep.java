package io.github.dagoud.steps;

import io.github.dagoud.pages.LoginPage;
import io.github.dagoud.utils.Hooks;

public abstract class BaseStep {

    protected static final String SAUCE_DEMO_URL = "https://www.saucedemo.com";

    private Hooks hooks;
    private LoginPage loginPage;

    public BaseStep(Hooks hooks) {
        this.hooks = hooks;
        loginPage = new LoginPage(getHooks().getDriver(), SAUCE_DEMO_URL);
    }

    public Hooks getHooks() {
        return hooks;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

}
