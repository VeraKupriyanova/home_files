package com.company;

import java.io.*;

public class Main {
    private static final String dirName = "C:\\Users\\Вера\\Games\\";
    private static final StringBuilder log = new StringBuilder();
    private static final String fileLog = dirName + "temp//temp.txt";

    public static void main(String[] args) {
        createDirectory(dirName + "src");
        createDirectory(dirName + "temp");
        createDirectory(dirName + "res");
        createDirectory(dirName + "savegames");
        createDirectory(dirName + "src\\main");
        createDirectory(dirName + "src\\test");
        createFile(dirName + "src\\main\\Main.java");
        createFile(dirName + "src\\main\\Utils.java");
        createDirectory(dirName + "res\\drawables");
        createDirectory(dirName + "res\\vectors");
        createDirectory(dirName + "res\\icons");
        createFile(dirName + "temp\\temp.txt");
        String filesLog = fileLog.toString();
        writeLog(filesLog);
        readLog(filesLog);
    }

    private static void createDirectory(String dirName) {
        if (new File(dirName).mkdir()) {
            log.append(dirName).append(" директория создана\n");
        } else {
            log.append(dirName).append(" директории нет!\n");
        }
    }

    public static void createFile(String fileName) {
        try {
            if (new File(fileName).createNewFile()) {
                log.append(fileName).append(" файл создан\n");
            } else {
                log.append(fileName).append(" файл не найден, попробуйте заново\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void writeLog(String logFileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(logFileName)) {
            fileOutputStream.write(log.toString().getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void readLog(String logFileName) {
        try (FileInputStream fileInputStream = new FileInputStream(logFileName)) {
            int i;
            while ((i = fileInputStream.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}

