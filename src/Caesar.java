import java.util.Scanner;

/**
 * Implementiert die Schnittestelle Codec
 * */
public class Caesar{
    /**
     * Klasseninvariant key fuer das Schlusselwort
     * */
    private   String key="TUL";
    /**
     * Das Schlusselwort muss nicht null sein
     * */

    public String code(String clearText){ // Abc123  // E
        StringBuilder hidden_Text=new StringBuilder();
        char letter;
        outer:  for(int i=0;i<clearText.length();i++){
            letter= clearText.charAt(i);

            inner:  for(int count=0; count< key.length();count++){
                if(Character.isLetter(letter)) {
                    if (letter == 'Z') {
                        letter = 'A';
                        continue inner;
                    }
                    if (letter == 'z') {
                        letter = 'a';
                        continue inner;
                    }
                    letter++;
                }
            }
            hidden_Text.append(letter);
        }

        return hidden_Text.toString();
    }
    public String decode(String hiddenText){
        StringBuilder clear_Text=new StringBuilder();

        char letter;
        for(int i=0;i<hiddenText.length();i++){
            letter= hiddenText.charAt(i);

            inner:  for(int count=0; count< key.length();count++){
                if(Character.isLetter(letter)) {
                    if (letter == 'A') {
                        letter = 'Z';
                        continue inner;
                    }
                    if (letter == 'a') {
                        letter = 'z';
                        continue inner;
                    }
                    letter--;

                }

            }
            clear_Text.append(letter);
        }

        return clear_Text.toString();

    }

    public String getSolution() {
        return this.key;
    }
    public void setSolution(String key) throws IllegalArgumentException{
        try {
            this.key = key;
        }catch (IllegalArgumentException e){
            System.out.println("Der Parameter muss ein String Objekt sein");
        }
    }
    public static void main(String[] args) {
        for(char c = 'a'; c < 'z'; c++) {
            System.out.println(c);
        }
        Caesar caesar = new Caesar();
        caesar.setSolution("TUILMENAU");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("KlarText eingeben: ");
            String clearText = scanner.nextLine();
            String hiddenText = caesar.code(clearText);
            System.out.println("Verschlüsselte Text:   "+ hiddenText);
            String encode = caesar.decode(hiddenText);
            System.out.println("Entschlüsselite Text:  " + encode );
        }


    }


}