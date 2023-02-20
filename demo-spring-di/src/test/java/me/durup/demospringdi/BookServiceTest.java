package me.durup.demospringdi;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookServiceTest {

    @Autowired BookService bookService;

    @Test
    public void di() {
        Assert.assertNotNull(bookService);
        Assert.assertNotNull(bookService.bookRepository);
        // Spring이 BookRepository라는 bean을 만들어서 BookService에 넣어줬다는 것을 알 수 있다
        // 원래는 null 이어야하는 필드들이 어떻게 null이 아닌지?
    }

}