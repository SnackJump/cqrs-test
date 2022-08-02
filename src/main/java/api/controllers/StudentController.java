package api.controllers;

import api.dtos.StudentDto;
import java.util.List;
import logic.students.Course;
import logic.students.CourseRepository;
import logic.students.Student;
import logic.students.StudentRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: StudentController<br> Description:<br>
 *
 * @author 2920
 * @version 修訂記錄:<br>
 * @since 2022/8/1
 */
@RestController
@RequestMapping("api/students")
public class StudentController {

  private UnitOfWork unitOfWork;
  private StudentRepository studentRepository;
  private CourseRepository courseRepository;

  public StudentController(UnitOfWork unitOfWork) {
    this.unitOfWork = unitOfWork;
    studentRepository = new StudentRepository(unitOfWork);
    courseRepository = new CourseRepository(unitOfWork);
  }

  @GetMapping()
  public List<StudentDto> GetList(String enrolled, int number) {
    return convertToDto(studentRepository.getList(enrolled, number));
  }

  private List<StudentDto> convertToDto(List<Student> list) {
    // convert student to studentDto
    return null;
  }

  @PostMapping()
  public void create(@RequestBody StudentDto dto) {
    Student student = new Student(dto.getName(), dto.getEmail());
    if (dto.getCourse1() != null && dto.getCourse1Grade() != null) {
      Course course = courseRepository.getByName(dto.getCourse1());
      student.enroll(course, dto.getCourse1Grade());
    }
    if (dto.getCourse2() != null && dto.getCourse2Grade() != null) {
      Course course = courseRepository.getByName(dto.getCourse2());
      student.enroll(course, dto.getCourse2Grade());
    }
    studentRepository.save(student);
    unitOfWork.commit();
  }

  @DeleteMapping("{id}")
  public void delete(long id) {
    Student student = studentRepository.getById(id);
    if (student == null) {
      return new Error("No student found for id {id}");
    }

  }
}
