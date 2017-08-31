package com.elcidw.springBoot.Controller;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elcidw.springBoot.Entity.User;
import com.elcidw.springBoot.Service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/add/{id}/{name}/{course}")
	public User addUser(@PathVariable int id, @PathVariable String name,
	        @PathVariable String course)
	    {
	        User user = new User();
	        user.setId(id);
	        user.setName(name);
	        user.setCourse(course);
	        userService.saveUser(user);
	        return user;
	    }
	@RequestMapping(value = "/delete/{id}")
    public void deleteBook(@PathVariable int id)
    {
        userService.delete(id);
    }

    @RequestMapping(value = "/")
    public List<User> getBooks()
    {
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}")
    public User getUser(@PathVariable int id)
    {
        User user = userService.findOne(id);
        return user;
    }

    @RequestMapping(value = "/search/name/{name}")
    public List<User> getBookByName(@PathVariable String name)
    {
        List<User> users = userService.findByName(name);
        return users;
    }
	
	//add login 
    
    @RequestMapping(value = "/login/{username}/{password}")
    public String login(@PathVariable String username, @PathVariable String password)
    {
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
