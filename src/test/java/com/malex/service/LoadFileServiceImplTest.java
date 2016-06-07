package com.malex.service;

import com.alex.constant.Constant;
import com.alex.service.LoadFileService;
import com.alex.service.impl.LoadFileServiceImpl;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by malex on 08.06.16.
 */
public class LoadFileServiceImplTest {

    private LoadFileService service;

    @Test
    public  void loadFile_test(){
        //given
        String expectStr = "1 4 gdansk 2 2 1 3 3 bydgoszcz 3 1 1 3 1 4 4 torun 3 1 3 2 1 4 1 warszawa 2 2 4 3 1 2 ";
        service = new LoadFileServiceImpl();

        //when
        String actualStr = service.loadFile(Constant.SOURCE);

        //then
        assertEquals(expectStr,actualStr);

    }
}
