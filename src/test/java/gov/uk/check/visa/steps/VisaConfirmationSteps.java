package gov.uk.check.visa.steps;

import gov.uk.check.visa.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class VisaConfirmationSteps {
    @Given("I am on homepage")
    public void iAmOnHomepage() {
    }

    @When("I click on start button")
    public void iClickOnStartButton() {
        //Click on start button
        new StartPage().clickStartNow();
    }

    @And("I select a Nationality {string}")
    public void iSelectANationality(String nationality) {
        //Select a Nationality 'Australia'
        new SelectNationalityPage().selectNationality(nationality);
    }

    @And("I click On Continue button")
    public void iClickOnContinueButton() {
        //Click on Continue button
        new SelectNationalityPage().clickOnContinue();
    }

    @And("I select reason {string}")
    public void iSelectReason(String reason) {
        //Select reason 'Tourism'
        new ReasonForTravelPage().clickOnTourismOrVisitingFamilyAndFriends();
    }

    @And("I Click on Continue button after reason")
    public void iClickOnContinueButtonAfterReason() {
        //Click on Continue button
        new ReasonForTravelPage().clickOnContinueButton();
    }

    @Then("I should get result that You will not need a visa to come to the UK")
    public void iShouldGetResultThatYouWillNotNeedAVisaToComeToTheUK() {
        //verify result 'You will not need a visa to come to the UK'
        Assert.assertEquals(new ResultPage().getResultMessage(), "You will not need a visa to come to the UK");
    }

    @And("I Select reason  for {string}")
    public void iSelectReasonFor(String reason) {
        //Select reason 'Work, academic visit or business'
        new ReasonForTravelPage().selectReasonForVisit(reason);
    }

    @And("I  Select intended to stay for {string}")
    public void iSelectIntendedToStayFor(String moreOrLess) {
        //Select intendent to stay for 'longer than 6 months'
        new DurationOfStayPage().selectLengthOfStay(moreOrLess);
    }

    @And("I Select have planning to work for Health and care professional")
    public void iSelectHavePlanningToWorkForHealthAndCareProfessional() {
        //Select have planning to work for 'Health and care professional'
        new WorkTypePage().selectJobType();
    }

    @Then("I  should get  result You need a visa to work in health and care")
    public void iShouldGetResultYouNeedAVisaToWorkInHealthAndCare() {
        //verify result 'You need a visa to work in health and care'
        Assert.assertEquals(new ResultPage().getDisplayedText(), "You need a visa to work in health and care");
    }

    @And("I Select reason  for Join partner or family for a long stay")
    public void iSelectReasonForJoinPartnerOrFamilyForALongStay() {
        //Select reason 'Join partner or family for a long stay'
        new ReasonForTravelPage().clickOnJoinPartnerOrFamilyForALongStay();
    }

    @Then("I should get result that You need a visa")
    public void iShouldGetResultThatYouNeedAVisa() {
        //verify result 'You’ll need a visa to join your family or partner in the UK'
        Assert.assertEquals(new ResultPage().getYouNeedVisaText(), "You may need a visa");
    }

}