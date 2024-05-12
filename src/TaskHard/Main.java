package TaskHard;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Укажите путь к файлу. Верный путь: src/TaskHard/docs.txt");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        try (FileReader stream = new FileReader(path)) {
            int i;
            StringBuilder txtDocs = new StringBuilder();
            while ((i = stream.read()) != -1) {
                txtDocs.append((char) i);
            }
            String[] arrDocs = txtDocs.toString().split("\n");
            for (int j = 0; j < arrDocs.length; j++) {
                String[] oneDoc = arrDocs[j].trim().split(" ");
                if ((oneDoc[0].equals("docnum") || oneDoc[0].equals("contract")) && oneDoc[1].length() == 15){
                    //System.out.println(oneDoc[0] + " " + oneDoc[1]);
                    try (FileWriter validfile = new FileWriter("src/TaskHard/validDocs.txt", true)){
                        validfile.write(oneDoc[0] + " " + oneDoc[1] + "\n");
                        validfile.flush();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
                else {
                    //System.out.println("Doc not val " + oneDoc[0] + " " + oneDoc[1]);
                    try (FileWriter novalidfile = new FileWriter("src/TaskHard/noValidDocs.txt", true)){
                        novalidfile.write(oneDoc[0] + " " + oneDoc[1] + "\n");
                        novalidfile.flush();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
                /*for (int k = 0; k < oneDoc.length; k++) {
                    System.out.println(oneDoc[k]);
                }*/
            }


        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            ;
        } catch (IOException e) {
            System.out.println(e);
            ;
        }
    }
}
