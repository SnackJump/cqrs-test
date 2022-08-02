package api.dtos;

import logic.students.Grade;
import lombok.Getter;
import lombok.Setter;

/**
 * Title: StudentDto<br>
 * Description:<br>
 *
 * @author 2920
 * @version 修訂記錄:<br>
 * @since 2022/8/1
 */
@Getter
@Setter
public class StudentDto {
  private long id;
  private String name;
  private String email;
  private String course1;
  private Grade course1Grade;
  private String course1DisenrollmentComment;
  private String course1Credits;
  private String course2;
  private Grade course2Grade;
  private String course2DisenrollmentComment;
  private String course2Credits;
}
