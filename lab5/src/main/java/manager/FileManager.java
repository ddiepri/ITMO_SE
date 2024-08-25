package manager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import models.Flat;

import java.io.*;
import java.util.List;

/**
 * Менеджер файлов.
 */
public class FileManager {
    private final String inputFileName;
    private final ConsoleManager console;
    private final CollectionManager collectionManager;

    public FileManager(String inputFileName, ConsoleManager console, CollectionManager collectionManager) {
        this.inputFileName = inputFileName;
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Проверить, можно ли читать файл.
     *
     * @param file файл
     * @return true, если можно читать файл, иначе false
     */
    public static boolean canRead(File file, ConsoleManager console) {
        if (!file.exists()) {
            console.printError("Файл не найден");
            return false;
        }

        if (!file.canRead()) {
            console.printError("Нет прав на чтение файла");
            return false;
        }

        if (!file.isFile()) {
            console.printError("Указанный путь не является файлом");
            return false;
        }

        return true;
    }

    /**
     * Сохранить коллекцию в файл.
     */
    public void saveCollection() {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JavaTimeModule());
        
            String xmlResult = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(collectionManager.getCollection());
            try (FileOutputStream fos = new FileOutputStream(inputFileName)) {
                fos.write(xmlResult.getBytes());
                fos.flush();
            }
            console.println("Коллекция успешно сохранена в файл.");
        } catch (Exception e) {
            console.printError("Ошибка сохранения коллекции в файл: " + e.getMessage());
        }
    }

    /**
     * Заполнить коллекцию из файла.
     */
    public void fillCollection() {
        File file = new File(inputFileName);
        if (!canRead(file, console)) {
            return;
        }

        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JavaTimeModule());
            String xml = bufferedReaderToString(new BufferedReader(new FileReader(file)));
            List<Flat> flats = xmlMapper.readValue(xml, new TypeReference<List<Flat>>() {});

            for (Flat flat : flats) {
                if (ValidationManager.isValidFlat(flat)) {
                    collectionManager.add(flat.getId(), flat); // Передача id и объекта Flat
                } else {
                    console.printError("Квартира с id " + flat.getId() + " не прошла валидацию");
                }
            }
            console.println("Коллекция успешно загружена из файла.");
        } catch (Exception e) {
            console.printError("Ошибка чтения файла: " + e.getMessage());
        }
    }

    /**
     * Преобразовать BufferedReader в строку.
     *
     * @param br BufferedReader
     * @return строка
     * @throws IOException ошибка ввода/вывода
     */
    public String bufferedReaderToString(BufferedReader br) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = br) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb.toString();
    }
}
