package com.malex.service;

import com.alex.constant.Constant;
import com.alex.service.LoadFileService;
import com.alex.service.impl.LoadFileServiceImpl;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by malex on 08.06.16.
 */
public class LoadFileServiceImplTest {

    private LoadFileService service;

    @Test
    public  void loadFile_test(){
        //given
        String expectStr = getList("data.txt");
        service = new LoadFileServiceImpl();

        //when
        String actualStr = service.loadFile(Constant.SOURCE);

        //then
        assertEquals(expectStr,actualStr);
        System.out.println(actualStr);

    }

    private String getList(String data){
        StringBuilder result = new StringBuilder();
        File file = new File(getClass().getClassLoader().getResource(data).getFile());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line + " ");
            }
        } catch (IOException e) {
            //NON
        }
        return result.toString();
    }
}
