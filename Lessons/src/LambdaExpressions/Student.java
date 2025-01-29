package LambdaExpressions;

public class Student {
    String name;
    String sex;
    int age;
    int course;
    Double avgGrade;

    public Student(String name, String sex, int age, int course, Double avgGrade) {
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

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public int getCourse() {
        return course;
    }

    public Double getAvgGrade() {
        return avgGrade;
    }
}
