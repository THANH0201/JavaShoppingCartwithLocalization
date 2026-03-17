package localization;

import org.junit.jupiter.api.Test;
import java.util.Locale;
import static org.junit.jupiter.api.Assertions.*;

public class LanguageSelectorTest {

    @Test
    void testEnglishLocale() {
        Locale locale = LanguageSelector.getLocaleByChoice(1);
        assertEquals("en", locale.getLanguage());
        assertEquals("US", locale.getCountry());
    }

    @Test
    void testFinnishLocale() {
        Locale locale = LanguageSelector.getLocaleByChoice(2);
        assertEquals("fi", locale.getLanguage());
        assertEquals("FI", locale.getCountry());
    }

    @Test
    void testSwedishLocale() {
        Locale locale = LanguageSelector.getLocaleByChoice(3);
        assertEquals("sv", locale.getLanguage());
        assertEquals("SE", locale.getCountry());
    }

    @Test
    void testJapaneseLocale() {
        Locale locale = LanguageSelector.getLocaleByChoice(4);
        assertEquals("ja", locale.getLanguage());
        assertEquals("JP", locale.getCountry());
    }

    @Test
    void testDefaultLocale() {
        Locale locale = LanguageSelector.getLocaleByChoice(999);
        assertEquals("en", locale.getLanguage());
        assertEquals("US", locale.getCountry());
    }
}
