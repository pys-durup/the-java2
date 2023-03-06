import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void getterSetter() {
        Member member = new Member();
        member.setName("boook");
        Assert.assertEquals(member.getName(), "boook");
    }

}