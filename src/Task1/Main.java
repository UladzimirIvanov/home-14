package Task1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (FileReader stream = new FileReader("src/Task1/romeo-and-juliet.txt")){
            int i;
            StringBuilder txt = new StringBuilder();
            while ((i = stream.read()) != -1){
                txt.append((char)i);
            }
            String[] txtstr = txt.toString().replaceAll("\\W", " ").split(" ");
            int linelen = 0;
            String longline = null;
            for (int j = 0; j < txtstr.length; j++) {
                //System.out.println(txtstr[j] + " " + txtstr[j].length());
                if (txtstr[j].length() > linelen){
                    linelen = txtstr[j].length();
                    longline = txtstr[j];
                }
            }
            //System.out.println("Самое длинное слово " + longline + " его длина " + linelen);

            try (FileWriter longfile = new FileWriter("src/Task1/longline.txt")){
                longfile.write("Самое длинное слово " + longline + " его длина " + linelen);
                longfile.flush();
            } catch (IOException e) {
                System.out.println(e);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}