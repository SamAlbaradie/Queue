public class Person {
    int id;
    int prio;
    public Person(int id, int prio){
        this.id = id;
        this.prio = prio;
    }


    public String toString(){
        return id + " " + prio;
    }
}
