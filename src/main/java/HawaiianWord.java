public class HawaiianWord {
    public String word;

    public HawaiianWord() {
        word = "";
        //word initializes
    }


    public HawaiianWord (String hWord) {
        word = hWord;
    }

    public String getWord() {
        return word;
    }
    //getter which returns it

    public void setWord (String hWord) {
        word = hWord;
    }
    //setter which sets word

    boolean isPhonetic = true;

    public String createPhoneticVersion() {
        String tempWord = word;

        for (int i = 0; i <= word.length(); i++) {

            StringBuilder string = new StringBuilder(word);

            //inserts value at the given point

            if (word.charAt(i) != 'p' || word.charAt(i) != 'k' || word.charAt(i) != 'h' || word.charAt(i) != 'l' || word.charAt(i) != 'm' || word.charAt(i) != 'n') {

                if (word.charAt(1) == 'w') {

                    string.setCharAt(1, 'w');

                }

                if (word.length()>=i+2 &&word.charAt(i) == 'a' && word.charAt(i + 1) == 'w') {

                    string.setCharAt(i + 1, 'w');

                }

                if (word.length()>=i+2 && word.charAt(i) == 'i' && word.charAt(i + 1) == 'w') {

                    string.setCharAt(i + 1, 'v');

                }

                if (word.length()>=i+2 && word.charAt(i) == 'e' && word.charAt(i + 1) == 'w') {

                    string.setCharAt(i + 1, 'v');

                }

                if (word.length()>=i+2 && word.charAt(i) == 'u' && word.charAt(i + 1) == 'w') {

                    string.setCharAt(i + 1, 'w');

                }

                if (word.length()>=i+2 && word.charAt(i) == 'o' && word.charAt(i + 1) == 'w') {

                    string.setCharAt(i + 1, 'w');

                }

                if (word.charAt(i) == 'a') {

                    string.setCharAt(i, 'a');

                    string.insert('h', i + 1);

                    string.insert('-', i + 2);

                }

                if (word.charAt(i) == 'e') {

                    string.setCharAt(i, 'e');

                    string.insert('h', i + 1);

                    string.insert('-', i + 2);

                }

                if (word.charAt(i) == 'i') {

                    string.setCharAt(i, 'e');

                    string.insert('e', i + 1);

                    string.insert('-', i + 2);

                }



        }
    }
    public int countSyllables() {
        int dash = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.substring(i,i+1).equals("-")){
                dash = dash + 1;
            }
            dash = dash +1;
        }
        return dash;
    }

    public String toString() {
        String stringFinal = ("Word:" + word + " has a phonetic spelling of:" + createPhoneticVersion());
        return stringFinal;
    }
}