package test;
import main.*;
import java.util.Random;

public class mvp {

    public static void main(String[] args) throws InterruptedException {
        Queue q = new Queue();
        Random rId = new Random();
        Random rPrio = new Random();


        for(int i = 0; i < 100; i++){
            q.addPerson(new Person(rId.nextInt(0, 1000) + 1000, rPrio.nextInt(0, 5) + 1));
            System.out.println("------ROUND : " + i + "---------"+ "\n"  +
                    "Number of People Currently in Queue : " + q.getNbrPeopleInQueue() + "\n" +
                    "---------------------");
            System.out.println(q.toString());
            MatchMaker m = new MatchMaker(q);
            if(i % 5 == 0){
                Thread.sleep(1000);
            }
        }
    }
}
