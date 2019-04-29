package student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class School {
  public static void showAll(List<Student> ls) {
    for (Student s : ls) {
      System.out.println("> " + s);
    }
    System.out.println("------------------------------");
  }

  public static List<Student> getSmartStudents(List<Student> ls) {
    List<Student> out = new ArrayList<>();
    for (Student s : ls) {
      if (s.getGpa() > 3) {
        out.add(s);
      }
    }
    return out;
  }

  public static void main(String[] args) {
    List<Student> school = Arrays.asList(
        Student.of("Fred", 3.4, "Math", "Art"),
        Student.of("Fred", 2.7, "Geography"),
        Student.of("Fred", 3.7, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
    );
    showAll(school);
    showAll(getSmartStudents(school));
  }
}
