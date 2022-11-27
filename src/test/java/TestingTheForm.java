import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class TestingTheForm {
    private SelenideElement form;
    private String validName = "Петр Аркадьевич";
    private String validPhone = "+79106697097";


    @Test
    public void shouldSendForm() {
        open("http://localhost:9999");
        form = $("form");
        form.$("[data-test-id=name] input").setValue(validName);
        form.$("[data-test-id=phone] input").setValue(validPhone);
        form.$("[data-test-id=agreement]").click();
        form.$("button").click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";

        $("[data-test-id=order-success]").shouldHave(exactText(expected));
    }

}
