import java.util.Random;

public static void main(String[] args) throws InterruptedException {

    Random r = new Random();
    Queue q = new Queue();
    for(int i = 0; i < 6; i++){
        int rId = r.nextInt(1000) + 1000;
        int rPrio = r.nextInt(4) + 1;
        q.addPerson(new Person(rId, rPrio));
    }


    System.out.println(q);

}