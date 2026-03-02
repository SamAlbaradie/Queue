package test;
import main.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class queueTests {

    @Test
    public void testQEmpty(){
        Queue q = new Queue();
        assertEquals(0, q.getNbrPeopleInQueue());

    }

    @Test
    public void testPersonEnterQCorrectly(){
        Person Sam = new Person(1001, 1);
        Queue q = new Queue();
        q.addPerson(Sam);
        assertEquals(Sam, q.getPersonInQueue(1, 1001));
    }

    @Test
    public void testPeopleEnterQCorrectly(){
        Queue q = new Queue();
        q.addPerson(new Person(1001, 1));
        q.addPerson(new Person(1002, 1));
        q.addPerson(new Person(1003, 1));
        q.addPerson(new Person(1004, 1));
        assertEquals(4, q.getNbrPeopleInQueue(1));
    }

    @Test
    public void testNbrOfPeopleInQ(){
        Queue q = new Queue();
        q.addPerson(new Person(1001, 1));
        q.addPerson(new Person(1011, 1));
        q.addPerson(new Person(1002, 2));
        q.addPerson(new Person(1003, 3));
        q.addPerson(new Person(1004, 4));
        q.addPerson(new Person(1004, 5));
        assertEquals(6, q.getNbrPeopleInQueue());

    }

    @Test
    public void testTimer() throws InterruptedException {
        Queue q = new Queue();
        Person Sam = new Person(1001, 1);
        q.addPerson(Sam);
        Thread.sleep(100);
        assertEquals(true, q.getTimeWaited(Sam) > 0, "Time waited =" + q.getTimeWaited(Sam));
    }

    @Test
    public void testTimerDifference() throws InterruptedException {
        Queue q = new Queue();
        Person SamEarlier = new Person(1001, 1);
        q.addPerson(SamEarlier);
        Thread.sleep(100);
        Person SamLater = new Person(1011, 1);
        q.addPerson(SamLater);
        System.out.println("Time waited SamEarlier = " + q.getTimeWaited(SamEarlier) + "\n"+
                "Time waited SamLater = " + q.getTimeWaited(SamLater));
        assertEquals(true, q.getTimeWaited(SamEarlier) > q.getTimeWaited(SamLater));
    }

    @Test
    public void testPQPop() throws InterruptedException {
        Queue q = new Queue();
        Person Sam = new Person(1001, 1);
        q.addPerson(Sam);
        Thread.sleep(100);
        Person SamLater = new Person(1011, 1);
        q.addPerson(SamLater);


        assertEquals(Sam, q.getPeopleInQueue(1).poll(),
                "Time waited SamEarlier = " + q.getTimeWaited(Sam) +
                "Time waited SamLater = " + q.getTimeWaited(SamLater) + "\n");
    }

}
