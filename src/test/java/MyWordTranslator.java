import java.util.Scanner;
public class MyWordTranslator {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    HawaiianWord output = new HawaiianWord();
    System.out.println("Enter a Hawaiian Word");
    String newInput = input.nextLine();
    output.setWord(newInput);
    System.out.println(output.createPhoneticVersion());
    //uses HawaiianWord method and turns user input into new output
        //
        //
}
}
