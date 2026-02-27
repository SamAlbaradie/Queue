package test;
import main.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class matchMakerTests {


    //check if a matchmaker can remove 5 People from the same prio queue
    //TODO
    @Test
    public void testMMSamePrio(){
        {
            Person Sam = new Person(1001, 1);
            Person Johanna = new Person(1002, 1);
            Person Aram = new Person(1003, 1);
            Person Anastasia = new Person(1004, 1);
            Person JohnDoe = new Person(1005, 1);
            Queue q = new Queue();
            q.addPerson(Sam);
            q.addPerson(Johanna);
            q.addPerson(Aram);
            q.addPerson(Anastasia);
            q.addPerson(JohnDoe);
        }


    }
}
