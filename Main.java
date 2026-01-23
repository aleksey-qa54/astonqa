import java.util.*;
class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> grades;

    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new HashMap<>();
    }

    public void addGrade(String subject, int grade) {
        grades.put(subject, grade);
    }

    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int grade : grades.values()) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", grades=" + grades +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
    List<Student> students = new ArrayList<>();

        Student student1 = new Student("Иван", "Группа-101", 1);
        student1.addGrade("Математика", 5);
        student1.addGrade("Физика", 4);
        student1.addGrade("Информатика", 5);

        Student student2 = new Student("Мария", "Группа-101", 1);
        student2.addGrade("Математика", 2);
        student2.addGrade("Физика", 3);
        student2.addGrade("Информатика", 2);

        Student student3 = new Student("Алексей", "Группа-201", 2);
        student3.addGrade("Математика", 4);
        student3.addGrade("Физика", 4);
        student3.addGrade("Информатика", 5);

        Student student4 = new Student("Елена", "Группа-301", 3);
        student4.addGrade("Математика", 3);
        student4.addGrade("Физика", 3);
        student4.addGrade("Информатика", 3);

        students.add(student1);  
        students.add(student2);  
        students.add(student3);  
        students.add(student4);  

        System.out.println("Все студенты (в порядке добавления):");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\n--- Удаление студентов со средним баллом < 3 ---");
        removeFailedStudents(students);

        System.out.println("\nСтуденты после удаления неуспевающих:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\n--- Перевод студентов на следующий курс ---");
        promoteStudents(students);

        System.out.println("\nСтуденты после перевода:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\n--- Вывод студентов по курсу ---");
        System.out.println("Студенты 2 курса:");
        printStudents(students, 2);

        System.out.println("\nСтуденты 1 курса:");
        printStudents(students, 1);

        System.out.println("\nСтуденты 4 курса:");
        printStudents(students, 4);
    }

        public static void removeFailedStudents(List<Student> students) {
        
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            double averageGrade = student.calculateAverageGrade();

            if (averageGrade < 3.0) {
                System.out.println("Удаляем студента: " + student.getName() +
                        ", средний балл: " + averageGrade);
                iterator.remove();
            }
        }
    }

      public static void promoteStudents(List<Student> students) {
        for (Student student : students) {
            double averageGrade = student.calculateAverageGrade();

            if (averageGrade >= 3.0) {
                int currentCourse = student.getCourse();
                student.setCourse(currentCourse + 1);
                System.out.println("Переводим студента " + student.getName() +
                        " с " + currentCourse + " на " + (currentCourse + 1) +
                        " курс. Средний балл: " + averageGrade);
            }
        }
    }

       public static void printStudents(List<Student> students, int course) {
        boolean found = false;

        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("Имя: " + student.getName() +
                        ", Группа: " + student.getGroup() +
                        ", Средний балл: " + student.calculateAverageGrade());
                found = true;
            }
        }

        if (!found) {
            System.out.println("На " + course + " курсе нет студентов.");
        }
    }
}
