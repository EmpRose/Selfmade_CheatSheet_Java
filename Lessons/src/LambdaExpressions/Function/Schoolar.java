package LambdaExpressions.Function;

public class Schoolar {
    String name;
    String sex;
    int age;
    int course;
    Double avgGrade;

    public Schoolar(String name, String sex, int age, int course, Double avgGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "name: " + name + '\'' +
                ", sex: '" + sex + '\'' +
                ", age: " + age +
                ", course: " + course +
                ", avgGrade: " + avgGrade;
    }
}
