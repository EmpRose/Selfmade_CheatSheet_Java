package Generics.GenericsExamplePackage;

public class GameTestExample {
    public static void main(String[] args) {
        Schoolar schoolar1 = new Schoolar("Ivan",13);
        Schoolar schoolar2 = new Schoolar("Mariya",15);

        Schoolar schoolar3 = new Schoolar("Sergei",13);
        Schoolar schoolar4 = new Schoolar("Olya",15);

        Students student1 = new Students("Nikolay", 20);
        Students student2 = new Students("Kseniya", 18);

        Employee employee1 = new Employee("Zaur",32);
        Employee employee2 = new Employee("Mikhail",47);

        //addNewParticipant nimmt jeden Participant auf. Daher ist es möglich in das Schüler-Team auch Studierende oder Angestellte hinzuzufügen.
        // Das passt uns natürlich nicht - Daher passen wir den Participant Code an(public class Team <T extends Participant>)
        // , sodass Studierende nicht in die Gruppe der Schüler:innen kommen
        Team <Schoolar> schoolarTeam = new Team("Schoolar_Team");
        schoolarTeam.addNewParticipant(schoolar1);
        schoolarTeam.addNewParticipant(schoolar2);

        Team <Schoolar> schoolarTeam2 = new Team("Schoolar_Team2");
        schoolarTeam2.addNewParticipant(schoolar3);
        schoolarTeam2.addNewParticipant(schoolar4);

        Team <Students> studentsTeam = new Team("Students_Team");
        studentsTeam.addNewParticipant(student1);
        studentsTeam.addNewParticipant(student2);

        Team <Employee> employeeTeam = new Team("Employee_Team");
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);

        schoolarTeam.playWith(schoolarTeam2);





    }
}
