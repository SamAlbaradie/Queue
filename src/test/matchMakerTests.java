package test;
import main.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class matchMakerTests {


    //check if a matchmaker can remove 5 People from the same prio queue
    @Test
    public void testMMCase1() {
        {
            Queue q = new Queue();
            q.addPerson(new Person(1001, 1));
            q.addPerson(new Person(1002, 1));
            q.addPerson(new Person(1003, 1));
            q.addPerson(new Person(1004, 1));
            q.addPerson(new Person(1005, 1));

            System.out.println("----CASE 1-----" + "\n" +
                    "the Q before :" + "\n" +
                    q.toString());

            MatchMaker m = new MatchMaker(q);

            System.out.println("the Q after :" + "\n" +
                    q.toString() + "\n" +
                    "----CASE 1-----" + "\n" ) ;
            assertEquals(0, q.getNbrPeopleInQueue());
        }


    }

    @Test
    public void testMMCase12() {
        {
            Queue q = new Queue();
            //prio 1
            q.addPerson(new Person(1001, 1));
            q.addPerson(new Person(1002, 1));
            q.addPerson(new Person(1003, 1));
            q.addPerson(new Person(1004, 1));
            q.addPerson(new Person(1005, 1));
            //prio 2
            q.addPerson(new Person(1011, 3));
            q.addPerson(new Person(1012, 3));
            q.addPerson(new Person(1013, 3));
            q.addPerson(new Person(1014, 3));
            q.addPerson(new Person(1015, 3));
            System.out.println("----CASE 1.1-----" + "\n" +
                    "the Q before :" + "\n" +
                    q.toString());

            MatchMaker m = new MatchMaker(q);

            System.out.println("the Q after :" + "\n"
                    + q.toString() + "\n" +
                    "----CASE 1.1-----" + "\n" );
            assertEquals(0, q.getNbrPeopleInQueue());
        }
    }

    @Test
    public void testMMCase2() throws InterruptedException {
        {
            Queue q = new Queue();
            //prio 1
            Person Sam = new Person(1001, 1);
            q.addPerson(Sam);
            q.addPerson(new Person(1002, 1));
            q.addPerson(new Person(1003, 1));
            q.addPerson(new Person(1004, 1));
            //prio 2
            q.addPerson(new Person(1005, 2));

            Thread.sleep(1000);

            System.out.println("----CASE 2-----" + "\n" +
                    "time waited in q for Sam = " +q.getTimeWaited(Sam)/1000 + " sec" + "\n" +
                    "the Q before :" + "\n" +
                    q.toString());

            MatchMaker m = new MatchMaker(q);

            System.out.println("the Q after :" + "\n" +
                    q.toString() + "\n" +
                    "----CASE 2-----" + "\n" );
            assertEquals(0, q.getNbrPeopleInQueue());
        }
    }

    @Test
    public void testMMCase3() throws InterruptedException {
        {
            Queue q = new Queue();
            //prio 1
            Person Sam = new Person(1001, 1);
            q.addPerson(Sam);
            Thread.sleep(2000);
            q.addPerson(new Person(1002, 1));
            q.addPerson(new Person(1003, 1));

            //prio 2
            q.addPerson(new Person(1004, 2));
            q.addPerson(new Person(1005, 2));


            System.out.println("----CASE 3-----" + "\n" +
                    "time waited in q for Sam = " +q.getTimeWaited(Sam)/1000 + " sec" + "\n" +
                    "the Q before :" + "\n" +
                    q.toString());

            MatchMaker m = new MatchMaker(q);

            System.out.println("the Q after :" + "\n" +
                    q.toString() + "\n"
                    + "----CASE 3-----" + "\n" );
            assertEquals(0, q.getNbrPeopleInQueue());
        }
    }

    @Test
    public void testMMCase4() throws InterruptedException {
        {
            Queue q = new Queue();
            //prio 1
            Person Sam = new Person(1001, 1);
            q.addPerson(Sam);
            Thread.sleep(3000);
            q.addPerson(new Person(1002, 1));


            //prio 2
            q.addPerson(new Person(1003, 2));
            q.addPerson(new Person(1004, 2));
            q.addPerson(new Person(1005, 2));


            System.out.println("----CASE 4-----" + "\n" +
                    "time waited in q for Sam = " +q.getTimeWaited(Sam)/1000 + " sec" + "\n" +
                    "the Q before :" + "\n" +
                    q.toString());

            MatchMaker m = new MatchMaker(q);

            System.out.println("the Q after :" + "\n" +
                    q.toString() + "\n" +
                    "----CASE 4-----" + "\n" );
            assertEquals(0, q.getNbrPeopleInQueue());
        }
    }

    @Test
    public void testMMCase5() throws InterruptedException {
        {
            Queue q = new Queue();
            //prio 1
            Person Sam = new Person(1001, 1);
            q.addPerson(Sam);
            Thread.sleep(4000);



            //prio 2
            q.addPerson(new Person(1002, 2));
            q.addPerson(new Person(1003, 2));
            q.addPerson(new Person(1004, 2));
            q.addPerson(new Person(1005, 2));


            System.out.println("----CASE 5-----" + "\n" +
                    "time waited in q for Sam = " +q.getTimeWaited(Sam)/1000 + " sec" + "\n" +
                    "the Q before :" + "\n" +
                    q.toString());

            MatchMaker m = new MatchMaker(q);

            System.out.println("the Q after :" + "\n" +
                    q.toString() + "\n"
                    + "----CASE 5-----" + "\n" );
            assertEquals(0, q.getNbrPeopleInQueue());
        }
    }



}
