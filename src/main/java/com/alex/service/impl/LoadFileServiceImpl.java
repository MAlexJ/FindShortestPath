package com.alex.service.impl;

import com.alex.service.LoadFileService;

import java.io.*;
import java.util.Scanner;

/**
 * Created by malex on 07.06.16.
 */
public class LoadFileServiceImpl implements LoadFileService {

    @Override
    public String loadFile(String pathFile) {
        StringBuilder result = new StringBuilder();

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(pathFile).getFile());

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line + " ");
            }
        } catch (IOException e) {
            e.printStackTrace(); //TODO EXCEPTION
        }
        return result.toString();
    }

}
