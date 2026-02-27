package test;
import main.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class queueTests {

    @Test
    public void testEnterQCorrectly(){
        Person Sam = new Person(1001, 1);
        Queue q = new Queue();
        q.addPerson(Sam);
        assertEquals(Sam, q.getPersonInQueue(1, 1001));
    }

}
