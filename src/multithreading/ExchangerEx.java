package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 20. Синхронизатор Exchanger */
/**
    -----------
     Exchanger
    -----------
    Exchanger – это синхронизатор, позволяющий обмениваться данными между двумя потоками,
    обеспечивает то, что оба потока получат информацию друг от друга одновременно.

    Метод: exchange().
*/
public class ExchangerEx {

    public static void main(String[] args) {
        Exchanger<Action> exchanger = new Exchanger<>();

        List<Action> friend1Action = new ArrayList<>();
        friend1Action.add(Action.SCISSORS);
        friend1Action.add(Action.PAPER);
        friend1Action.add(Action.SCISSORS);

        List<Action> friend2Action = new ArrayList<>();
        friend2Action.add(Action.PAPER);
        friend2Action.add(Action.ROCK);
        friend2Action.add(Action.ROCK);

        new BestFriend("Vanya", friend1Action, exchanger);
        new BestFriend("Petya", friend2Action, exchanger);
    }
}

enum Action {
    ROCK, SCISSORS, PAPER;
}

class BestFriend extends Thread {
    private String name;
    private List<Action> ownActions;
    private Exchanger<Action> exchanger;

    public BestFriend(String name, List<Action> ownActions, Exchanger<Action> exchanger) {
        this.name = name;
        this.ownActions = ownActions;
        this.exchanger = exchanger;
        this.start();
    }

    private void whoWins(Action ownAction, Action friendAction) {
        if ((ownAction == Action.ROCK && friendAction == Action.SCISSORS) ||
                (ownAction == Action.SCISSORS && friendAction == Action.PAPER) ||
                (ownAction == Action.PAPER && friendAction == Action.ROCK)) {
            System.out.println(name + " WINS!!!");
        }
    }

    @Override
    public void run() {
        Action reply;

        for (Action action : ownActions) {
            try {
                /* Waits for another thread to arrive at this exchange point
                   (unless the current thread is interrupted), and then transfers
                   the given object to it, receiving its object in return. */
                reply = exchanger.exchange(action);
                whoWins(action, reply);
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
