package student;

import java.util.Arrays;
import java.util.List;

public class Student {
  private String name;
  private double gpa;
  private List<String> courses;

  private Student(){}

  public static Student of(String name, double gpa, String ... courses) {
    Student self = new Student();
    self.name = name;
    self.gpa = gpa;
    self.courses = Arrays.asList(courses.clone());
    return self;
  }

  public String getName() {
    return name;
  }

  public double getGpa() {
    return gpa;
  }

  public List<String> getCourses() {
    return courses;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", gpa=" + gpa +
        ", courses=" + courses +
        '}';
  }

  public static StudentCriterion getSmartStudentCriterion(double threshold){
    return new SmartStudentCriterion(threshold);
  }

  private static class SmartStudentCriterion implements StudentCriterion {
    private double threshold;
    public SmartStudentCriterion(double threshold) {
      this.threshold = threshold;
    }
    @Override
    public boolean test(Student s) {
      return s.getGpa() > threshold;
    }
  }

  private static final EnthuiasticStudentCriterion enthuiasticStudentCriterion =
      new EnthuiasticStudentCriterion();

  public static StudentCriterion getEnthusiasticCriterion() {
    return enthuiasticStudentCriterion;
  }

  private static class EnthuiasticStudentCriterion implements StudentCriterion {
    @Override
    public boolean test(Student s) {
      return s.getCourses().size() > 3;
    }
  }
}
