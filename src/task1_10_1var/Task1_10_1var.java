package task1_10_1var;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

//минус проги.Если новый файл имеет такое же название где будет записываеться, то он его перезаписывашет.
public class Task1_10_1var {

    public static void main(String[] args) {
        System.out.print("Hohlov Andrey RIBO-03-22");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Получаем количество файлов для склейки
            System.out.println("Введите количество файлов для склейки: ");
            int numFiles = Integer.parseInt(reader.readLine());

            // Создаем массив для хранения файлов
            File[] files = new File[numFiles];

            // Считываем пути к файлам от пользователя и проверяем их существование
            for (int i = 0; i < numFiles; i++) {
                System.out.print("Введите путь к файлу " + (i + 1) + ": ");
                String filePath = reader.readLine();
                files[i] = new File(filePath);

                if (!files[i].exists()) {
                    System.out.println("Файл не найден: " + filePath);
                    return;
                }
            }
            
            // Определяем путь для сохранения результирующего файла
            String parentDir = files[0].getParent();
            String resultFilePath = parentDir + File.separator + "result.txt";
            File resultFile = new File(resultFilePath);

            // Склеиваем содержимое файлов
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile))) {
                for (File file : files) {
                    try (BufferedReader readerFromFile = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = readerFromFile.readLine()) != null) {
                            writer.write(line);
                            writer.newLine();
                        }
                    }
                }
            }

            System.out.println("Файлы успешно склеены. Результат сохранен в: " + resultFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



