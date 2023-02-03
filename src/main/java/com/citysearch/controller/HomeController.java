package com.citysearch.controller;


import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.citysearch.entities.AdminClassified;
import com.citysearch.entities.CityClassified;
import com.citysearch.entities.CityUser;
import com.citysearch.helper.Message;
import com.citysearch.repository.AdminClassifiedRepo;
import com.citysearch.repository.CityClassifiedRepo;
import com.citysearch.repository.CityUserRepo;




@Controller
public class HomeController {
	
@Autowired
private BCryptPasswordEncoder passwordEncoder;



@Autowired
private CityUserRepo cityuserRepo;

@Autowired
private CityClassifiedRepo cityclassifiedRepo;

//@Autowired
//private AdminClassifiedService service;

@Autowired
private AdminClassifiedRepo adminclassifiedRepo;

@RequestMapping("/")
public String home(Model model) {
	 
	model.addAttribute("title", "Home - City Search");
	return "home";
}


	@RequestMapping("/search")
	public String search(Model model,@Param("keyword") String keyword) {
		  List<AdminClassified> listPosters = adminclassifiedRepo.search(keyword);
	        model.addAttribute("listPosters", listPosters);
	        model.addAttribute("keyword", keyword);
		model.addAttribute("title", "Home - City Search");
		return "search";
	}
	
	
	@RequestMapping("/register")
	public String register(Model model) {
		
		model.addAttribute("title", "Register - City Search");
		model.addAttribute("cityuser",new CityUser());
		return "register";
	}
	
	//handler for user register
	@PostMapping("/process_register")
	public String processRegister( @ModelAttribute("cityuser") CityUser cityuser,Model model,HttpSession session) {
		
		try {
		//cityuser.setRole("ROLE_USER");
		String encodedPassword = passwordEncoder.encode(cityuser.getPassword());
		cityuser.setPassword(encodedPassword);
		
		cityuserRepo.save(cityuser);
		session.setAttribute("message", new Message("registeration successfull", "success"));
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			model.addAttribute("user",cityuser);
			session.setAttribute("message", new  Message("Email Already Registered!! ", "danger"));
			
	}	
		return "register";
		
	}
	
	// handler for the custom login
	@GetMapping("/login")
	public String customLogin(Model model)
	{
		model.addAttribute("title", "Login Page");
		return "login";
	}

	
	@GetMapping("/homeviewclassified/{page}")
	public String listclassified(@ModelAttribute CityClassified cityclassified,@PathVariable("page") Integer page,Model model,Principal principal) {
		Pageable pageable=PageRequest.of(page, 8);
		Page<CityClassified> listPosters = cityclassifiedRepo.findAll(pageable);
		model.addAttribute("listPosters", listPosters);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages",listPosters.getTotalPages());
		
		return "homeviewclassified";
	}
}
