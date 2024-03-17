package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoqaFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void FillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Sergey");
        $("#lastName").setValue("Kovalev");
        $("#userEmail").setValue("Test8956Test@test.test");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9111813795");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("October")).click();
        $(".react-datepicker__year-select").$(byText("1993")).click();
        $(".react-datepicker__month").$(byText("4")).click();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("Test.jpg");
        $("#currentAddress").setValue("Saint-Petersburg, Nevskiy 38");
        $("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Sergey"),
                (text("Kovalev")),
                (text("Test8956Test@test.test")),
                (text("Female")),
                (text("9111813795")),
                (text("04 October,1993")),
                (text("Hindi")),
                (text("Sports, Music")),
                (text("Test.jpg")),
                (text("Saint-Petersburg, Nevskiy 38")),
                (text("NCR Delhi")));
    }
}