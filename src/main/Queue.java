package main;

import java.util.*;
import java.util.concurrent.*;

public class Queue {
    private final Map<Integer, Set<Person>> q;
    Comparator<Person> cmp = Comparator.comparingInt(p -> p.timeWaited); //cmp to sort the pq based on time waited


    //create 5 different sets that are the value in a map where the key is the prio, 1, 2, 3, 4 ,5
    //supposed to simulate a matchmaking queue
    public Queue(){
        this.q = new HashMap<>();
        for(int i = 1; i < 6; i++){
            Set<Person> set = new HashSet<Person>();
            q.put(i, set);
        }
    }

    //here we add a person to a queue based on the persons priority
    public void addPerson(Person p){
        if(q.containsKey(p.prio)){
            q.get(p.prio).add(p);
        }
    }

    //sifts through corresponding queue looking for a match on the person we are after and if match -> remove from queue,
    //might want to change D-struct for faster look ups but for now this will do
    public void removePerson(int id, int prio){
        for(Person person : q.get(prio)){
            if(person.equals(new Person(id, prio))){
                q.get(prio).remove(person);
            }
        }
    }

    //sifts through corresponding queue looking for a match on the person we are after and if match -> return Person obj
    public Person getPersonInQueue(int prio, int id){
        Set<Person> people = new HashSet<>();
        people = q.get(prio);
        for(Person person : people){
            if(person.equals(new Person(id, prio))){
                return person;
            }
        }
        return null;
    }
    //returns all the people objects in this priority queue as a set
    public Set<Person> getPeopleInQueue(int prio){
        return q.get(prio);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, Set<Person>> e : q.entrySet()){
            sb.append(e.getKey());
            sb.append(e.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }


    public boolean isEmpty() {
        return q.isEmpty();
    }
}
