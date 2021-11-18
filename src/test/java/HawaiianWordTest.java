import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import org.junit.jupiter.api.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HawaiianWordTest {
    private static HawaiianWord[] testWordsValid;
    private static HawaiianWord[] testWordsInvalid;
    private static HawaiianWord[] testWordsMixed;
    private HawaiianWord word;

    @BeforeAll
    static void setUp () {
        testWordsValid = new HawaiianWord[] {
                new HawaiianWord("humuhumunukunukuapuaa"),
                new HawaiianWord("kane"),
                new HawaiianWord("moana"),
                new HawaiianWord("mahalo"),
                new HawaiianWord("kakahiaka"),
                new HawaiianWord("aloha"),
                new HawaiianWord("ohana"),
                new HawaiianWord("hoaloha"),
                new HawaiianWord("mauna"),
                new HawaiianWord("wailele"),
                new HawaiianWord("pali")
        };

        testWordsInvalid = new HawaiianWord[] {
                new HawaiianWord("python"),
                new HawaiianWord("mountain"),
                new HawaiianWord("design"),
                new HawaiianWord("tiger"),
                new HawaiianWord("ocean"),
                new HawaiianWord("pineapples"),
                new HawaiianWord("hut"),
                new HawaiianWord("sand"),
                new HawaiianWord("fire"),
                new HawaiianWord("how are you")
        };

        testWordsMixed = new HawaiianWord[] {
                new HawaiianWord("ohana"),
                new HawaiianWord("mountain"),
                new HawaiianWord("fire"),
                new HawaiianWord("kakahiaka")
        };
    }

    private static Stream<Arguments> provideWords_allValid() {
        return Stream.of(
                Arguments.of(testWordsValid[0], "hoo-moo-hoo-moo-noo-koo-noo-koo-ah-poo-ah-ah"),
                Arguments.of(testWordsValid[1], "kah-neh"),
                Arguments.of(testWordsValid[2], "moh-ah-nah"),
                Arguments.of(testWordsValid[3], "mah-hah-loh"),
                Arguments.of(testWordsValid[4], "kah-kah-hee-ah-kah"),
                Arguments.of(testWordsValid[5], "ah-loh-hah"),
                Arguments.of(testWordsValid[6], "oh-hah-nah"),
                Arguments.of(testWordsValid[7], "hoh-ah-loh-hah"),
                Arguments.of(testWordsValid[8], "mow-nah"),
                Arguments.of(testWordsValid[9], "weye-leh-leh"),
                Arguments.of(testWordsValid[10], "pah-lee")
        );
    }

    private static Stream<Arguments> provideWords_allValid_Syllables() {
        return Stream.of(
                Arguments.of(testWordsValid[0], 12),
                Arguments.of(testWordsValid[1], 2),
                Arguments.of(testWordsValid[2], 3),
                Arguments.of(testWordsValid[3], 3),
                Arguments.of(testWordsValid[4], 5),
                Arguments.of(testWordsValid[5], 3),
                Arguments.of(testWordsValid[6], 3),
                Arguments.of(testWordsValid[7], 4),
                Arguments.of(testWordsValid[8], 2),
                Arguments.of(testWordsValid[9], 3),
                Arguments.of(testWordsValid[10], 2)
        );
    }

    @DisplayName("Check phonetic spelling of valid words")
    @ParameterizedTest
    @MethodSource("provideWords_allValid")
    void createPhoneticVersion_allValidWords_returnPhoneticWord (HawaiianWord word,
                                                                 String phonetic) {
        assertEquals(phonetic, word.createPhoneticVersion());
    }

    @DisplayName("Check syllables of valid words")
    @ParameterizedTest
    @MethodSource("provideWords_allValid_Syllables")
    void createPhoneticVersion_allValidWords_returnSyllables (HawaiianWord word,
                                                                 int syllables) {
        int syll = word.countSyllables();
        assertEquals(syllables, syll);
    }

    private static Stream<Arguments> provideWords_allInvalid () {
        return Stream.of(
                Arguments.of(testWordsInvalid[0], 1),
                Arguments.of(testWordsInvalid[1], 1),
                Arguments.of(testWordsInvalid[2], 1),
                Arguments.of(testWordsInvalid[3], 1),
                Arguments.of(testWordsInvalid[4], 1),
                Arguments.of(testWordsInvalid[5], 1),
                Arguments.of(testWordsInvalid[6], 1),
                Arguments.of(testWordsInvalid[7], 1),
                Arguments.of(testWordsInvalid[8], 1),
                Arguments.of(testWordsInvalid[9], 1)
        );
    }

    @DisplayName("Check syllables of invalid words")
    @ParameterizedTest
    @MethodSource("provideWords_allValid_Syllables")
    void createPhoneticVersion_allInValidWords_returnSyllables (HawaiianWord word,
                                                                 int syllables) {
        int syll = word.countSyllables();
        assertEquals(syllables, syll);
    }

    private static Stream<Arguments> provideWords_allInvalid_syllables () {
        return Stream.of(
                Arguments.of(testWordsInvalid[0], "python"),
                Arguments.of(testWordsInvalid[1], "mountain"),
                Arguments.of(testWordsInvalid[2], "design"),
                Arguments.of(testWordsInvalid[3], "tiger"),
                Arguments.of(testWordsInvalid[4], "ocean"),
                Arguments.of(testWordsInvalid[5], "pineapples"),
                Arguments.of(testWordsInvalid[6], "hut"),
                Arguments.of(testWordsInvalid[7], "sand"),
                Arguments.of(testWordsInvalid[8], "fire"),
                Arguments.of(testWordsInvalid[9], "how are you")
        );
    }

    @DisplayName("Check phonetic spelling of invalid words")
    @ParameterizedTest
    @MethodSource("provideWords_allInvalid")
    void createPhoneticVersion_allInvalidWords_returnSameWord (HawaiianWord word,
                                                               String phonetic) {
        assertEquals(phonetic, word.createPhoneticVersion());
    }

    @DisplayName("Set a word and create phonetic version")
    @Test
    void setWord_ValidWord_returnPhoneticVersion () {
        word = new HawaiianWord();
        word.setWord("aloha");
        assertEquals("ah-loh-hah", word.createPhoneticVersion());
    }

    @DisplayName("Set a word and return same word back")
    @Test
    void setWord_InvalidWord_returnSameWord () {
        word = new HawaiianWord();
        word.setWord("baseball");
        assertEquals("baseball", word.createPhoneticVersion());
    }

    @DisplayName("Set a word and retireve it via getter")
    @Test
    void getWord_returnWord () {
        word = new HawaiianWord();
        word.setWord("moana");
        assertEquals("moana", word.getWord());
    }

    private static Stream<Arguments> provideWords_mixed () {
        return Stream.of(
                Arguments.of(testWordsMixed[0], "Word: ohana has a phonetic spelling of: oh-hah-nah"),
                Arguments.of(testWordsMixed[1], "Word: mountain has a phonetic spelling of: " +
                        "mountain"),
                Arguments.of(testWordsMixed[2], "Word: fire has a phonetic spelling of: " +
                        "fire"),
                Arguments.of(testWordsMixed[3], "Word: kakahiaka has a phonetic spelling of: " +
                        "kah-kah-hee-ah-kah")
        );
    }

    @DisplayName("Check toString of mixed words")
    @ParameterizedTest
    @MethodSource("provideWords_mixed")
    void toString_returnOutput (HawaiianWord word, String output) {
        assertEquals(output, word.toString());
    }

}//end of class