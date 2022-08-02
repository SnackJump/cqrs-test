package logic.students;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * Title: Course<br> Description:.<br>
 *
 * @author 2920
 * @version 修訂記錄:<br>
 * @since 2022/7/22
 */
@Entity
@Getter
@Setter
public class Course {

  @Id
  @GeneratedValue
  private long id;
  private String name;
  private String credits;
}
