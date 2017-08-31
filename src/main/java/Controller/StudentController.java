package Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Entity.Student;
import Service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
    
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public Collection<Student> getAllStudents() {
		return studentService.getAllStudent();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Student getStudentById(@PathVariable("id") int id) {
		return this.studentService.getStudentById(id);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return this.studentService.login("xzswang","My3=,wy1");
	}
	
	
}
