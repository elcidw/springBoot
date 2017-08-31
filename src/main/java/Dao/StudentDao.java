package Dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.apache.tomcat.jni.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ExceptionDepthComparator;
import org.springframework.stereotype.Repository;

import Entity.Student;

@Repository
public class StudentDao {
 
	@Autowired
	private static Map<Integer, Student> students;
	
	static {
		students = new HashMap<Integer,Student>() {
			
			{
				put(1, new Student(1,"Said","Computer Science"));
				put(2, new Student(2,"Alex U","Finance"));
				put(3, new Student(3,"Ana","Maths"));
				
			}
			
			
		};
	}
	
	public Collection getAllStudent() {
		return this.students.values();
		
	}
	public Student getStudentById(int id) {
		return this.students.get(id);
	}
	public String login(String username, String password) {
		// TODO Auto-generated method stub
		try
	    {
	        // Set up the environment for creating the initial context
	        Hashtable<String, String> env = new Hashtable<String, String>();
	        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
	        env.put(Context.PROVIDER_URL, "LDAP://slimadc1:389");
	        // 
	        env.put(Context.SECURITY_AUTHENTICATION, "simple");
	        env.put(Context.SECURITY_PRINCIPAL, "CNPCPE\\" + username); //we have 2 \\ because it's a escape char
	        env.put(Context.SECURITY_CREDENTIALS, password);

	        // Create the initial context

	        DirContext ctx = new InitialDirContext(env);
	        boolean result = ctx != null;

	        if(ctx != null)
	            ctx.close();

	        return "User " + username + "login  " + result;
	    }
	    catch (Exception e)
	    {           
	    	
	        return "Login Falure!" + username + password;
	    }
	}
	
	
}
