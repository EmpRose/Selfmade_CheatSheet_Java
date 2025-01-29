package Multithreading.Exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/*
Exchanger ist ein Synchronizator, der dafür sorgt, dass zwei Threads die Informationen austauschen können.
Beide Threads erhalten die Informationen von einander gleichzeitig.
Der Austausch erfolgt nur, wenn beide Threads ihre Informationen über den Exchange"r" teilen.
Wenn ein Thread seine Information teilt, wird der Thread gehalten, bis ein weiterer Thread seine Informationen auch teilt.

Beispiel: Schere, Stein, Papier.

 */
public class ExchangerExample {

    public static void main(String[] args) {
        Exchanger<Action> exchanger = new Exchanger<>();
        List<Action> myAction = new ArrayList<>();
        myAction.add(Action.SCHERE);
        myAction.add(Action.STEIN);
        myAction.add(Action.PAPIER);

        List<Action> friendsAction = new ArrayList<>();
        friendsAction.add(Action.PAPIER);
        friendsAction.add(Action.PAPIER);
        friendsAction.add(Action.PAPIER);

        new BestFriend("Matvej", exchanger, myAction);
        new BestFriend("Artur", exchanger, friendsAction);
    }
}

enum Action {
    SCHERE, STEIN, PAPIER;
}

class BestFriend extends Thread {
    private String name;
    private List<Action> myActions;
    private Exchanger<Action> exchanger;

    public BestFriend(String name, Exchanger<Action> exchanger, List<Action> myActions) {
        this.name = name;
        this.exchanger = exchanger;
        this.myActions = myActions;
        this.start();
    }

    private void WhoWins(Action myAction, Action friendsAction) {
        if ((myAction == Action.STEIN && friendsAction == Action.SCHERE)
                || (myAction == Action.SCHERE && friendsAction == Action.PAPIER)
                || (myAction == Action.PAPIER && friendsAction == Action.STEIN)) {
            System.out.println(name + " Wins!");
        } else if (myAction == friendsAction) {
            System.out.println("Draw");
        }
    }

    public void run() {
        Action reply;
        for (Action action : myActions) {
            try {
                reply = exchanger.exchange(action);
                WhoWins(action, reply);
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}