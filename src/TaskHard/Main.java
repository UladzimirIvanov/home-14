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
            System.out.println(txtDocs);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден" + e);;
        } catch (IOException e) {
            System.out.println(e);;
        }
    }
}
