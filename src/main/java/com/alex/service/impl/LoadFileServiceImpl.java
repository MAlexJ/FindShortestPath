package com.alex.service.impl;

import com.alex.exception.AppException;
import com.alex.exception.FileDataNotFoundException;
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
        File file;
        try {
            file = new File(classLoader.getResource(pathFile).getFile());
        } catch (NullPointerException e) {
            throw new FileDataNotFoundException("File not found: " + pathFile);
        }

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String resultString = result.toString();
        if( resultString.equals("")){
            throw new AppException("File is empty");
        }
        return resultString;
    }

}
