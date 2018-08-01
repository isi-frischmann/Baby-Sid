package com.isabell.authentication.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.isabell.authentication.models.Nanny;
import com.isabell.authentication.models.Parent;
import com.isabell.authentication.services.NannyService;
import com.isabell.authentication.services.ParentService;
import com.isabell.authentication.validation.ParentValidator;

@Controller
public class ParentController {
	private final ParentService ps;
	private final ParentValidator parentValidator;
	private final NannyService ns;

	public ParentController(ParentService ps, ParentValidator parentValidator, NannyService ns) {
        this.ps = ps;
        this.parentValidator = parentValidator;
        this.ns = ns;
    }

	// Registration & Login
	@RequestMapping("/babySid")
	public String registerForm(@ModelAttribute("parent") Parent parent, @ModelAttribute("nanny") Nanny nanny) {
		return "/parent/loginAndReg.jsp";
	}

	@RequestMapping(value = "/parent/registration", method = RequestMethod.POST)
	public String registerParent(@Valid @ModelAttribute("parent") Parent parent, BindingResult result, HttpSession session) {
		parentValidator.validate(parent, result);
		if (result.hasErrors()) {
			return "/parent/loginAndReg.jsp";
		}
		Parent u = ps.registerParent(parent);
		session.setAttribute("parentId", u.getId());
//		System.out.print("-------------------I'm inside the parent");
		return "redirect:/parent/home";
	}

	@RequestMapping(value = "/parent/login", method = RequestMethod.POST)
	public String loginParent(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session) {
		if (ps.authenticateParent(email, password)) {
			session.setAttribute("parentId", ps.findByEmail(email).getId());
			return "redirect:/parent/home";
		} else {
			model.addAttribute("error", "Invalid Login. Please try again.");
			return "/parent/loginAndReg.jsp";
		}
	}

	// index page for the parents!
	@RequestMapping("/parent/home")
	public String home(HttpSession session, Model model) {
		if (session.getAttribute("parentId") != null) {
			Long parent_id = (Long) session.getAttribute("parentId");
			model.addAttribute("parent", ps.findParentById(parent_id)); // parent_id is stored in session;
			return "/parent/index.jsp";
		} else {
			return "redirect:/babySid";
		}
	}
	

//	go to the page to find a Nanny close to you
	@GetMapping("/parent/findNanny")
	public String findNanny(Model model) {
		return "/parent/findNanny.jsp";
	}
	
//	find the nanny's with the searched address
	@PostMapping("/parent/findNannyCity")
	public String findNannyCity(@RequestParam("city") String address, HttpSession session) {
//		find all the nanny's by address
		List<Nanny> allNannies = ns.findNannyByAddress(address);
//		set the find nanny's into session to show them on the page
		session.setAttribute("allNanny", allNannies);
		return "redirect:/parent/findNanny";
	}
	
//	go to the page where you check when the nanny is available
	@GetMapping("/parent/seeAvailable/{nannyId}")
	public String seeAvailable(@PathVariable(value="nannyId") Long nannyId, Model model) {
		Nanny showSpecNanny = ns.findNannyById(nannyId);
		model.addAttribute("showNanny", showSpecNanny);
//		System.out.println(showSpecNanny);
		return "/parent/bookNanny.jsp";
	}
	
//	book a Nanny
	@PostMapping("/parent/bookNanny/{nannyId}")
	public String bookNanny(@PathVariable(value="nannyId") Long nannyId) {
		System.out.print(nannyId); //it's printing 22 so it's not the user and also not the nanny id
		return "redirect:/parent/review/{nannyId}"; //is this really the nanny or the user id
	}
	
	
//	go to the page where you can rate a nanny and also see your previous bookings
	@RequestMapping(value = "/parent/review/{NannyId}")
	public String showAndRateNanny(@PathVariable(value="NannyId") Long nannyId, Model model) {
		Nanny showSpecNanny = ns.findNannyById(nannyId);
		model.addAttribute("showNanny", showSpecNanny);
//		System.out.println(showSpecNanny);
		return "/parent/rateNanny.jsp";
	}
	
//	open the page to edit your profile
	@GetMapping("/parent/edit/{parentId}")
	public String editProfile(@PathVariable(value="parentId") Long id, @ModelAttribute("updateParent") Parent upParent, Model model) {
		Parent specialParent = ps.findParentById(id);
		model.addAttribute("editParent", specialParent);
		return "/parent/editParent.jsp";
	}
	
//	update the parent informations from edit
	@RequestMapping(value = "/parent/update/{parentId}", method = RequestMethod.PUT)
	public String updateProfile(@Valid @PathVariable("parentId") Long id, @ModelAttribute("updateParent") Parent upParent, BindingResult result) {
		if (result.hasErrors()) {
//			System.out.print("I'm inside the update method 1");
			return "/parent/eidtParent.jsp";
		}
		else {
			ps.updateParent(id, upParent);
//			System.out.print("I'm inside the update method");
			return "redirect:/parent/home";
		}
	}
	
	// logout is for the nanny and for parents
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/babySid";
	}
}
