package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.*;
import utilities.enums.Environment;
import utilities.enums.HandleCollection;
import utilities.handlers.*;
import utilities.interfaces.Navigator;
import utilities.interfaces.Printer;
import utilities.objects.Component;
import utilities.settings.Accounts;

public class Navigation {

    @Given("I Go To The Live Casino")
    public void iGoToMobileSite() {
        Navigator navigator = () -> {
            Accounts.setEnvironment(Environment.PRODUCTION);
            NavigationHandler.goTo(Accounts.getMobileUrl());
            EventHandler.select(Login.Dropdown.Language, "English");
            WaitHandler.waitUrlToBe(Accounts.getMobileUrl(), 5);

            WaitHandler.wait(5);
            EventHandler.click(Login.Thumbnail.LiveCasino);
            WaitHandler.waitVisibility(Login.Container.LoginModal, 5);
            EventHandler.sendKeys(Login.TextBox.Username, Accounts.getUsername());
            EventHandler.sendKeys(Login.TextBox.Password, Accounts.getPassword());
            EventHandler.click(Login.Button.Submit);

            WaitHandler.wait(5);
            if (ConditionHandler.isUrlContains("/sicbo")) {
                EventHandler.click(DealerTable.Button.SkipWelcome, HandleCollection.WithException);
                EventHandler.click(DealerTable.Button.Back, HandleCollection.WithException);
                WaitHandler.waitUrlContains("/dealerPage", 5);
                EventHandler.click(GameLobby.Button.Back, HandleCollection.WithException);
            }
            WaitHandler.waitUrlContains("/CasinoMobile", 5);
        };
        Printer printer = PrintHandler::printWarning;
        retrySteps(navigator, printer, "Go To The Live Casino.");
    }

    @When("I Join Live Sic Bo Revamp")
    public void iJoinLiveRouletteRevamp() {
        Navigator navigator = () -> {
            EventHandler.click(LiveCasino.Button.CloseBanner, HandleCollection.WithException);
            EventHandler.click(LiveCasino.Thumbnail.LiveSicBoRevamp);
            WaitHandler.wait(5);
            WaitHandler.waitUrlContains("/dealerPage", 5);
        };
        Printer printer = PrintHandler::printWarning;
        retrySteps(navigator, printer, "Go To Live Roulette Revamp.");
    }

    @When("I Enter The Dealer Table")
    public void iEnterTheDealerTable() {
        Navigator navigator = () -> {
            Component dealerTables = GameLobby.Container.DealerTables;
            EventHandler.click(dealerTables, GetHandler.getElementByRandom(dealerTables));
            EventHandler.click(DealerTable.Button.SkipWelcome, HandleCollection.WithException);
        };
        Printer printer = PrintHandler::printWarning;
        retrySteps(navigator, printer, "Enter The Dealer Table.");
    }

    @When("I Check The Round Result")
    public void iCheckTheRoundResult() {
        Accounts.setEnvironment(Environment.PRODUCTION);
        NavigationHandler.goTo(Accounts.getMobileUrl());
    }

    private void retrySteps(Navigator navigator, Printer printer, String description) {
        byte count = 0;
        boolean isError = true;
        do {
            try {
                if (count > 0) NavigationHandler.refresh();
                navigator.execute();
                isError = false;
            } catch (Exception e) {
                printer.print((++count) + " Attempt To " + description);
                if (count == 5) throw e;
            }
        } while (isError);
    }

}