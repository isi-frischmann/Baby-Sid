package com.isabell.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.isabell.authentication.models.Nanny;
import com.isabell.authentication.services.NannyService;
import com.isabell.authentication.validation.NannyValidator;

@Controller
public class NannyController {
	private final NannyService ns;
	private final NannyValidator nv;
	
	public NannyController(NannyService ns, NannyValidator nv) {
		this.ns = ns;
		this.nv = nv;
	}
	
  @RequestMapping(value="/nanny/registration", method=RequestMethod.POST)
  public String registerNanny(@Valid @ModelAttribute("nanny") Nanny addNanny, BindingResult result, HttpSession session) {
      nv.validate(addNanny, result);
      if(result.hasErrors()) {
          return "/parent/loginAndReg.jsp";
      }
      Nanny u = ns.registerNanny(addNanny);
      session.setAttribute("nannyId", u.getId());
//      System.out.print("I'm inside the registration");
      return "redirect:/nanny/home";
  }
  
  @RequestMapping(value="/nanny/login", method=RequestMethod.POST)
  public String loginNanny(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
  	if(ns.authenticateNanny(email, password)) {
  		session.setAttribute("nannyId", ns.findByEmail(email).getId());
  		return "redirect:/nanny/home";
  	}
  	else {
  		model.addAttribute("error", "Invalid Login. Please try again.");
  		return "/parent/loginAndReg.jsp";
  		}
  	}
  
//  index page for the nanny
  @RequestMapping("/nanny/home")
  public String home(HttpSession session, Model model) {
  	if(session.getAttribute("nannyId") != null) {
  		Long nanny_id =  (Long) session.getAttribute("nannyId");
      	model.addAttribute("nanny", ns.findNannyById(nanny_id)); //nanny_id is stored in session;
//      	System.out.print("------------------I'm inside the nanny");
      	return "/nanny/nannyIndex.jsp";
  	}
  	else {
  		return "redirect:/babySid";
  	}
  }
}
