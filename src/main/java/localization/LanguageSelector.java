package localization;

import java.util.Locale;
import java.util.Scanner;

public class LanguageSelector {

    public static Locale selectLanguage() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Select language:");
        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Swedish");
        System.out.println("4. Japanese");

        int lang = sc.nextInt();
        return getLocaleByChoice(lang);
    }

    public static Locale getLocaleByChoice(int lang) {
        switch (lang) {
            case 2: return new Locale("fi", "FI");
            case 3: return new Locale("sv", "SE");
            case 4: return new Locale("ja", "JP");
            default: return new Locale("en", "US");
        }
    }
}
