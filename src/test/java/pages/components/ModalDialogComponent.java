package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ModalDialogComponent {
    public void modalDialog(String value){

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(value));

    }

}
