package main;

public class Person {
    int id;
    int prio;
    long timeWaited;

    public Person(int id, int prio){
        this.id = id;
        this.prio = prio;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Person)) return false;
        Person other = (Person) obj;
        return (this.id == other.id);
    }

    public String toString(){
        return id + " " + prio;
    }
}
