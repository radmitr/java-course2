package generics.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* ------------------------------- 3. Generics ----------------------------------- */
/* 7. Пример на generics */
    // 5th class
/**
    ----------
     Generics
    ----------
              Type Safe & Reusable Code
    Parameterized Class         Parameterized Method

    <?> - любой класс
    <? extends X> - класс X или любой его сабкласс
    <? super Y> - класс Y или любой его суперкласс
    --------------------------------------------------------------------
    The most commonly used type parameter names are:
        E - Element (used extensively by the Java Collections Framework)
        K - Key
        N - Number
        T - Type
        V - Value
        S, U, V etc. - 2nd, 3rd, 4th types
*/

    // 0
//public class Team {
    // 1
//public class Team <T> {
    // 2
public class Team <T extends Participant> {

    private String name;
    private List<T> participants = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    // 0
//    public void addNewParticipant(Participant participant) {
    // 1 // 2
    public void addNewParticipant(T participant) {
        participants.add(participant);
        // 0
//        System.out.println("A new member named " + participant.getName() + " was added to the team " + name);
        // 1
//        System.out.println("A new member named " + ((Participant)participant).getName() + " was added to the team " + name);
        // 2
        System.out.println("A new member named " + participant.getName() + " was added to the team " + name);
    }

    // 0 // 1 // 2
//    public void playWith(Team team) {
    // 3
    public void playWith(Team<T> team) {
        String winnerName;
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 0) {
            winnerName = this.name;
        } else {
            winnerName = team.name;
        }
        System.out.println("The " + winnerName + " team won");
    }
}
