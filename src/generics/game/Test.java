package generics.game;

/* ------------------------------- 3. Generics ----------------------------------- */
/* 7. Пример на generics */
    // 6th class
/**
    ----------
     Generics
    ----------
              Type Safe & Reusable Code
    Parameterized Class         Parameterized Method

    <?> - любой класс
    <? extends X> - класс X или любой его сабкласс
    <? super Y> - класс Y или любой его суперкласс
*/
public class Test {

    public static void main(String[] args) {
        Schoolchild schoolchild1 = new Schoolchild("Ivan", 13);
        Schoolchild schoolchild2 = new Schoolchild("Mariya", 15);

        Student student1 = new Student("Nikolay", 20);
        Student student2 = new Student("Kseniya", 18);

        Employee employee1 = new Employee("Dmitriy", 38);
        Employee employee2 = new Employee("Mikhail", 47);

        // 0
//        Team schoolchildTeam = new Team("Dragons");
        // 1
        Team<Schoolchild> schoolchildTeam = new Team<>("Dragons");
        Team<Student> studentTeam = new Team<>("Forward!");
        Team<Employee> employeeTeam = new Team<>("Hard workers");

        schoolchildTeam.addNewParticipant(schoolchild1);
        schoolchildTeam.addNewParticipant(schoolchild2);
        // 0 - компилятор разрешает // 1 - компилятор не разрешает
//        schoolchildTeam.addNewParticipant(student1); // компилятор не разрешает добавлять студентов в школьную команду
//        schoolchildTeam.addNewParticipant(employee1); // компилятор не разрешает добавлять работников в школьную команду

        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);

        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);

        // 1 - компилятор разрешает // 2 - компилятор не разрешает
//        Team<String> anotherTeam = new Team<>("Fantasy");
//        anotherTeam.addNewParticipant("Hello"); // java.lang.ClassCastException

        Team<Schoolchild> schoolchildTeam2 = new Team<>("Wise men");
        Schoolchild schoolchild3 = new Schoolchild("Sergey", 12);
        Schoolchild schoolchild4 = new Schoolchild("Olya", 14);

        schoolchildTeam2.addNewParticipant(schoolchild3);
        schoolchildTeam2.addNewParticipant(schoolchild4);

        schoolchildTeam.playWith(schoolchildTeam2);
        // 2 - компилятор разрешает // 3 - компилятор не разрешает
//        schoolchildTeam.playWith(employeeTeam);
    }
}
