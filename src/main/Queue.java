package main;

import java.util.*;
import java.util.concurrent.*;

public class Queue {
    private Map<Integer, PriorityQueue<Person>> q;

    //create 5 different sets that are the value in a map where the key is the prio, 1, 2, 3, 4 ,5
    //supposed to simulate a matchmaking queue
    public Queue(){
        this.q = new HashMap<>();
        Comparator<Person> cmp = Comparator.comparingLong(p -> -p.timeWaited); //cmp to sort the pq based on time waited
        for(int i = 1; i < 6; i++){
            q.put(i, new PriorityQueue<Person>(cmp));
        }
    }

    //add a person to a queue based on the persons priority
    public void addPerson(Person p){
        if(q.containsKey(p.prio)){
            q.get(p.prio).offer(p);
            p.timeWaited = System.currentTimeMillis();
        }
    }

    public void removePerson(int id, int prio){
        for(Person person : q.get(prio)){
            if(person.equals(new Person(id, prio))){
                q.get(prio).remove(person);
            }
        }
    }

    public void removePeopleSameQueue(int prio, int nbrPeople){
        for(int i = 0; i < nbrPeople; i++){
            q.get(prio).poll();
        }
    }

    //sifts through corresponding queue looking for a match on the person we are after and if match -> return Person obj
    public Person getPersonInQueue(int prio, int id){
        PriorityQueue<Person> people = new PriorityQueue<>();
        people = q.get(prio);
        for(Person person : people){
            if(person.equals(new Person(id, prio))){
                return person;
            }
        }
        return null;
    }

    //returns all the people objects in this prio as a priorityQueue
    public PriorityQueue<Person> getPeopleInQueue(int prio){
        return q.get(prio);
    }

    //1 single prio
    public int getNbrPeopleInQueue(int prio){
        return q.get(prio).size();
    }

    //the entire matchmaking queue
    public int getNbrPeopleInQueue(){
        int nbr = 0;
        for(int i = 1; i < 6; i++){
            if(!q.get(i).isEmpty()){
                nbr += q.get(i).size();
            }
        }
        return nbr;
    }

    public long getTimeWaited(Person p){
        return (System.currentTimeMillis() - p.timeWaited);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, PriorityQueue<Person>> e : q.entrySet()){
            sb.append(e.getKey());
            sb.append(e.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

}
