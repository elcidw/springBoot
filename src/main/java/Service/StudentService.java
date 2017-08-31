package Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.StudentDao;
import Entity.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public Collection<Student> getAllStudent() {
		return studentDao.getAllStudent();
	}
	
	public Student getStudentById(int id) {
		return this.studentDao.getStudentById(id);
	}

	public String login(String username, String password) {
		// TODO Auto-generated method stub
		return this.studentDao.login(username, password);
	}
}
