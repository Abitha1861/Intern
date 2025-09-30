package com.hd.controlller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.hd.model.Mymodel;


@Controller
public class Mycontroller 
{
	
    @RequestMapping(value = {"/first_page","/"}, method = RequestMethod.GET)
    public ModelAndView showAddBookPage(HttpServletRequest request,HttpServletResponse response,HttpSession session) 
    {
    	ModelAndView mv = new ModelAndView();

    	mv.setViewName("first_page");
    	
        return mv;
    }
    
    @RequestMapping(value = {"/second_page"}, method = RequestMethod.GET)
    public ModelAndView second(HttpServletRequest request,HttpServletResponse response,HttpSession session) 
    {
    	ModelAndView mv = new ModelAndView();

    	mv.setViewName("Second_page");
    	
        return mv;
    }
    
    
    
    @RequestMapping(value = "/learning_post", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String Test_Service(@RequestBody String Message, HttpServletRequest request,HttpServletResponse response, HttpSession session) throws IOException 
    {
    	JsonObject details = new JsonObject();
    	
    	Mymodel md = new Mymodel();
    	
    	md.user_detail(Message);
    	
    	return details.toString();
    }
    
    
    
}
