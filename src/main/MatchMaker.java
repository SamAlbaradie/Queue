package main;

//the idea of this class is to have a monitor entity that scans the queue looking for a viable combination of Person Objects.
//It will do so based on criteria such as time waited, priority compatibility, and of course party size.
//Instead of having the queue object to decide, it seems as a better design to have an outside monitor class to do so.

public class MatchMaker  {

    //TODO
    public MatchMaker(Queue q){
        while(q.getNbrPeopleInQueue() != 0){
            for(int i = 1; i < 6; i++){
                matchMake(q, i);
            }
            //lets scan from top to bottom each queue
            //the person that has waited the longest in that prio gets handled first,
            //condition 1) if said person has waited less than 1 min, and there is no 4 other people with the same prio
            //person gets dropped by the matchmaker
            //we move on to the next person from the top and the same as condition 1)
            //condition 2) if person has waited longer than 1 min, we check for atleast 3 other people with the same prio
            // 1 can be n-1 prio below or n+1 above. if these conditions dont match we drop this person and move on.
            //condition 3) if person has waited longer than 2 min, we check for atleast 2 other people with same prio
            // 2 can be n-1 prio below or n+1 above. if these conditions dont match we drop this person and move on.
            //condition 4) if person has waited longer than 3 min, we check for atleast 1 other person with same prio
            // 3 can be n-1 prio below or n+1. if these conditions dont match we drop this person and move on.
            //condition 5) if person has waited longer than 4 min, we check if there is anyone with same prio, otherwise
            // 4 can be n-1 prio below or n+1. if these conditions dont match we drop this person and move on.
            //condition 6) if person has waited any period longer than 5 min, we check for anyone in between n, to n-2
            //and n+2.
        }

    }
    //TODO
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
            //we have all 5 people in the same queue
            case 5: q.removePeopleSameQueue(prio, 5);
                    break;
                    //maybe we can refactor this big block into another private helper method
                    //since every switchcase will basiclly have the same format
            case 4: if(q.getTimeWaited(q.getPeopleInQueue(prio).peek()) > 1000){
                        if(q.getNbrPeopleInQueue(qDiffDown) > 0 && qDiffDown != prio){
                            q.removePeopleSameQueue(qDiffDown, 1);
                            q.removePeopleSameQueue(prio, 5);
                        } else if (q.getNbrPeopleInQueue(qDiffUp) > 0 && qDiffUp != prio) {
                            q.removePeopleSameQueue(qDiffUp, 1);
                            q.removePeopleSameQueue(prio, 5);
                        }
            }
            default: break;
        }
    }
    //TODO
    private void matchMakeDecided(Queue q, int prio, int qDiffUp, int qDiffDown){

    }

}
