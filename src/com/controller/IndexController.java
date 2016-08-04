package com.controller;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.entity.UserEntity;

@Controller
@RequestMapping("/index")
public class IndexController {

	@RequestMapping("/index")
	public ModelAndView index() {	
		UserEntity user = new UserEntity("peter", "123456");
		return new ModelAndView("index","user", user);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		try {
			Velocity.init();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		VelocityContext context = new VelocityContext();

		context.put("name", new String("Velocity"));

		Template template = null;

		try {
			template = Velocity.getTemplate("/WEB-INF/mytemplates/login.vm");
		} catch (ResourceNotFoundException rnfe) {
			// couldn't find the template
		} catch (ParseErrorException pee) {
			// syntax error: problem parsing the template
		} catch (MethodInvocationException mie) {
			// something invoked in the template
			// threw an exception
		} catch (Exception e) {
		}

		StringWriter sw = new StringWriter();

		try {
			template.merge(context, sw);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MethodInvocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "login";
	}

}
