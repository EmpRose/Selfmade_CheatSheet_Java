package Generics.GenericsExamplePackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team <T extends Participant>{
    private String name;
    private List<T> participants = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addNewParticipant(T participant) {
        participants.add(participant);
        System.out.println(((Participant) participant).getName() + " has joined the team: " + name);
    }

    // durch <T> können nur Manschaften der zBsp Schüler:innen gegen Manschaften anderer Schüler:innen antretten
    public void playWith(Team<T> team) {
        String winnerName;
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 0) {
            winnerName = this.name;
        } else {
            winnerName = team.name;
        }
        System.out.println(winnerName + " is the Winner Team.");
    }
}
