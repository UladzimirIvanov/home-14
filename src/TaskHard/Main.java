package TaskHard;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Укажите путь к файлу. Верный путь: src/TaskHard/docs.txt");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        try (FileReader stream = new FileReader(path)){
            int i;
            StringBuilder txtDocs = new StringBuilder();
            while ((i = stream.read()) != -1){
                txtDocs.append((char) i);
            }
            //System.out.println(txtDocs);
            //System.out.println();
            String[] arrDocs = txtDocs.toString().split("\n");
            for (int j = 0; j < arrDocs.length; j++) {
                //System.out.println("Doc number " + (j+1) + " " + arrDocs[j]);
                String[] oneDoc = arrDocs[j].split(" ");
                for (int k = 0; k < oneDoc.length; k++) {
                    System.out.println("В документе " + (j+1) + " первая ячейка " + oneDoc[k]);
//TODO: Сделать двумерным
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");;
        } catch (IOException e) {
            System.out.println(e);;
        }
    }
}
