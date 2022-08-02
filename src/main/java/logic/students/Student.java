package logic.students;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.NoArgsConstructor;

/**
 * Title: Student<br>
 * Description:<br>
 *
 * @author 2920
 * @version 修訂記錄:<br>
 * @since 2022/7/22
 */
@Entity
@NoArgsConstructor
public class Student {
  @Id @GeneratedValue private long id;
  private String name;
  private String email;
  private List<Enrollment> enrollments = new ArrayList<>();
  private List<Disenrollment> disenrollments = new ArrayList<>();

  public Student(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public Enrollment getEnrollments(int index) {
    if (enrollments.size() > index) {
      return enrollments.get(index);
    }
    return null;
  }

  public void removeEnrollment(Enrollment enrollment) {
    enrollments.remove(enrollment);
  }

  public void addDisenrollmentComment(Enrollment enrollment, String comment) {

    Disenrollment disenrollment =
        new Disenrollment(enrollment.getStudent(), enrollment.getCourse(), comment);

    disenrollments.add(disenrollment);
  }

  public void enroll(Course course, Grade grade) throws RuntimeException {
    if (enrollments.size() >= 2) {
      throw new RuntimeException("Cannot have more then 2 enrollments");
    }
    Enrollment enrollment = new Enrollment(this, course, grade);
    enrollments.add(enrollment);
  }
}
