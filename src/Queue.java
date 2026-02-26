import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

public class Queue {
    private final Map<Integer, Set<Person>> q;
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public Queue(){
        this.q = new HashMap<>();
        for(int i = 1; i < 6; i++){
            Set<Person> set = new HashSet<Person>();
            q.put(i, set);
        }
    }

    public void addPerson(Person p){
        if(q.containsKey(p.prio)){
            q.get(p.prio).add(p);

            scheduler.schedule(() -> {

                int oldPrio = p.prio;
                int newPrio = addHelper(oldPrio, p);

                if(oldPrio != newPrio){
                    moveHelper(p, oldPrio, newPrio);
                }
                else{
                    System.out.println("\n" + "All done");
                }

            }, 5, TimeUnit.SECONDS);
        }
        else{
            System.out.println("Doesn't exist");
        }
    }

    private void moveHelper(Person p, int oldPrio, int newPrio) {
        q.get(oldPrio).remove(p);
        q.get(newPrio).add(p);
        System.out.print("\n" + q);
    }

    private int addHelper(int prio, Person p){

        if(q.get(prio).isEmpty() || q.get(prio).size() <= 1 && q.get(prio).contains(p) && prio != 1 ){
            return addHelper(prio - 1, p);
        }
        return prio;
    }

    public void removePerson(int pri){
        
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


}
