package main;

//the idea of this class is to have a monitor entity that scans the queue looking for a viable combination of Person Objects.
//It will do so based on criteria such as time waited, priority compatibility, and of course party size.
//Instead of having the queue object to decide, it seems as a better design to have an outside monitor class to do so.

import java.util.Objects;

public class MatchMaker  {


    public MatchMaker(Queue q){
        int count = 0;
        while(q.getNbrPeopleInQueue() != 0 && count != 3){

            for(int i = 1; i < 6; i++){
                matchMake(q, i);
            }
            count++;

        }

    }

    private void matchMake(Queue q, int prio){
        int nbrInPrio = q.getNbrPeopleInQueue(prio);
        int qDiffDown = prio - 1;
        int qDiffUp = prio + 1;
        if(qDiffDown == 0){
            qDiffDown = prio;
        }
        if(qDiffUp == 6){
            qDiffUp = prio;
        }

        switch(nbrInPrio){
            case 5: q.removePeopleSameQueue(prio, 5);
                    break;
            case 4: matchMakeDecided(q, prio, qDiffUp, qDiffDown, 1000, 4, 1);
                    break;
            case 3: matchMakeDecided(q, prio, qDiffUp, qDiffDown, 2000, 3, 2);
                    break;
            case 2: matchMakeDecided(q, prio, qDiffUp, qDiffDown, 3000, 2, 3);
                    break;
            case 1: matchMakeDecided(q, prio, qDiffUp, qDiffDown, 4000, 1, 4);
                    break;
            default: break;
        }
    }

    private void matchMakeDecided(Queue q, int prio, int qDiffUp, int qDiffDown, int time, int samePrioR, int diffPrioR){
        //if the person with the longest waitTime has waited long enough
        if(q.getTimeWaited(q.getPeopleInQueue(prio).peek()) > time){
            //if there are people who are waiting n-1 prio
            if(q.getNbrPeopleInQueue(qDiffDown) == diffPrioR && qDiffDown != prio){
                //remove correct nr of people in the original prio and the n-1 prio
                q.removePeopleSameQueue(qDiffDown, diffPrioR);
                q.removePeopleSameQueue(prio, samePrioR);
                //if there are people who are waiting n+1 prio
            } else if (q.getNbrPeopleInQueue(qDiffUp) == diffPrioR && qDiffUp != prio) {
                //remove correct nr of people in the original prio and the n+1 prio
                q.removePeopleSameQueue(qDiffUp, diffPrioR);
                q.removePeopleSameQueue(prio, samePrioR);
            }
        }
    }

}
