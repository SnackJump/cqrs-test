package logic.students;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Title: Enrollment<br>
 * Description:<br>
 *
 * @author 2920
 * @version 修訂記錄:<br>
 * @since 2022/7/22
 */
@Entity
@NoArgsConstructor
@Data
public class Enrollment {
  @Id @GeneratedValue private long id;
  private Student student;
  private Course course;
  private Grade grade;

  public Enrollment(Student student, Course course, Grade grade) {
    this.student = student;
    this.course = course;
    this.grade = grade;
  }

  public void update(Course course, Grade grade) {
    this.course = course;
    this.grade = grade;
  }
}
