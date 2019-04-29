package student;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface StudentCriterion {
  boolean test(Student s);
}

interface Silly {
  boolean doStuff(Student s);
}

//class SmartStudentCriterion implements StudentCriterion {
//  private double threshold;
//  public SmartStudentCriterion(double threshold) {
//    this.threshold = threshold;
//  }
//  @Override
//  public boolean test(Student s) {
//    return s.getGpa() > threshold;
//  }
//}
//
//class EnthuiasticStudentCriterion implements StudentCriterion {
//
//  @Override
//  public boolean test(Student s) {
//    return s.getCourses().size() > 3;
//  }
//}

public class School {
  public static void showAll(List<Student> ls) {
    for (Student s : ls) {
      System.out.println("> " + s);
    }
    System.out.println("------------------------------");
  }

  public static List<Student> getStudentsByCriterion(List<Student> ls,
                                               StudentCriterion crit) {
    List<Student> out = new ArrayList<>();
    for (Student s : ls) {
      if (crit.test(s)) {
        out.add(s);
      }
    }
    return out;
  }

//  public static List<Student> getSmartStudents(List<Student> ls,
//                                               double threshold) {
//    List<Student> out = new ArrayList<>();
//    for (Student s : ls) {
//      if (s.getGpa() > threshold) {
//        out.add(s);
//      }
//    }
//    return out;
//  }
//
//  public static List<Student> getEnthusiasticStudents(List<Student> ls,
//                                                      int threshold) {
//    List<Student> out = new ArrayList<>();
//    for (Student s : ls) {
//      if (s.getCourses().size() > threshold) {
//        out.add(s);
//      }
//    }
//    return out;
//  }
//
  public static void main(String[] args) {
    List<Student> school = Arrays.asList(
        Student.of("Fred", 3.4, "Math", "Art"),
        Student.of("Jim", 2.7, "Geography"),
        Student.of("Sheila", 3.7, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
    );
    System.out.println("All students:");
    showAll(school);
//    System.out.println("Smart students:");
//    showAll(getSmartStudents(school, 3.0));
//    System.out.println("Fairly smart students:");
//    showAll(getSmartStudents(school, 2.5));
//    System.out.println("Enthusiastic students:");
//    showAll(getEnthusiasticStudents(school, 3));

    System.out.println("Smart students:");
    showAll(getStudentsByCriterion(school,
        Student.getSmartStudentCriterion(3)));
    System.out.println("Fairly smart students:");
    showAll(getStudentsByCriterion(school,
        Student.getSmartStudentCriterion(2.5)));
    System.out.println("Enthusiastic students:");
    showAll(getStudentsByCriterion(school,
        Student.getEnthusiasticCriterion()));

//    Object obj = ((Silly)(s -> s.getGpa() > 3));
//    System.out.println("Class of obj is " + obj.getClass().getName());
//    Method [] methods = obj.getClass().getMethods();
//    for (Method m : methods) {
//      System.out.println("> " + m);
//    }
//        .doStuff(Student.of("Alice", 3.9, "Security")) ;
  }
}
