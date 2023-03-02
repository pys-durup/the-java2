package org.di2;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyContainerServiceTest {

    @Test
    public void getObject_MyBookRepository() {
        MyBookRepository myBookRepository = MyContainerService.getObject(MyBookRepository.class);
        assertNotNull(myBookRepository);
    }

    @Test
    public void getObject_MyBookService() {
        MyBookService myBookService = MyContainerService.getObject(MyBookService.class);
        assertNotNull(myBookService);
        assertNotNull(myBookService.myBookRepository);
    }

}