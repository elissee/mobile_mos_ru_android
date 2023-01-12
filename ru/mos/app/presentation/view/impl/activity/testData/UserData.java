package ru.mos.app.presentation.view.impl.activity.testData;

import java.util.HashMap;
import java.util.Map;

public class UserData {

    public String login;
    public String phone;
    public String pass;
    public String name;
    public String snils;
    public String email;

    public String phone_null;

    public String driverLicenseNumber = "7721533367";

    public String policy1 = "7800004320000013";
    public String birthDate1 = "23-07-1985";

    public String policy2 = "7800004320000012";
    public String birthDate2 = "05-02-1980";

    public String apartmentNumber = "370";
    public String payerCode = "2530399011";

    public UserData(String loginBy) {

        if (loginBy.equals("snils")) {
            this.login = "00099966621";
            this.snils = login;
            this.phone = "89430002995";
            this.pass = "Ae7zETZp";
            this.name = "Сидоров Кирилл";
            this.email = "test21@cptest.ru";
        }
        else if (loginBy.equals("email")) {
            this.email = "test21@cptest.ru";
            this.pass = "Ae7zETZp";
        }
        else if (loginBy.equals("phone_null")) {
            this.login = "89085859912";
            this.phone = login;
            this.pass = "LrEl1005";
            this.name = "Мои данные";
        }
        else {
            this.login = "89430002995";
            this.phone = login;
            this.pass = "Ae7zETZp";
            this.name = "Сидоров Кирилл Тестович";
            this.email = "test21@cptest.ru";
        }
        /*
            this.login = "9217860659";
            this.phone = login;
            this.pass = "2752208j";
            this.name = "Ломоносова Анжелика";
            this.email = "formulaliniy@mail.ru";
             */
         /*

        if (loginBy.equals("snils")) {
            this.login = "12917902472";
            this.snils = login;
            this.phone = "9507372709";
            this.pass = "Creature1985_";
            this.name = "Игорь Елисеев";
            this.email = "elissee@mail.ru";
        }
        else if (loginBy.equals("email")) {
            this.email = "info@eresoolfik.ru";
            this.pass = "eazdm5";
        }

         */
    }
}
