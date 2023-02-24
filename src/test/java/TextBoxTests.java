import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.textCaseSensitive;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com" ;   }

    @Test
    void fillFormTest(){
        open("/text-box");

        $("#userName").setValue("Vova Bobin");
        $("#userEmail").setValue("Vova@mail.ru");
        $("#currentAddress").setValue("Omsk 19");
        $("#permanentAddress").setValue("Another adress");
        $("#submit").click();


        $("#output").shouldHave(text("Vova Bobin"), text("Vova@mail.ru"),
                text("Omsk 19"), text("Another adress"));
    }
}