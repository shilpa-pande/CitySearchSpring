package com.citysearch.controller;

import java.security.Principal;
//import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.citysearch.entities.CityClassified;
import com.citysearch.entities.CityUser;
import com.citysearch.repository.CityClassifiedRepo;
import com.citysearch.repository.CityUserRepo;

import com.citysearch.helper.Message;


@Controller
@RequestMapping("/cityuser")
public class CityUserController {
	
	

@Autowired
private CityUserRepo cityuserRepo;

@Autowired
private CityClassifiedRepo cityclassifiedRepo;

@ModelAttribute
public void addCommonData(Model model,Principal principal)
{
	String username=principal.getName();
	
	//get the user using username
	CityUser cityuser=cityuserRepo.getUserByUserName(username);
	
	model.addAttribute("cityuser",cityuser);
	
}


	@RequestMapping("/index")
	public String dashboard(Model model,Principal principal) {
		
		
		return "normaluser/cityuser_dashboard";
	}
	
	@GetMapping("/postclassified")
	public String postclassified(Model model) {
		
		model.addAttribute("title", "Post-Classified - SaveClassified");
		model.addAttribute("cityclassified",new CityClassified());
		return "normaluser/postclassified";
	}
	
	@PostMapping("/process_postclassified")
	public String processPostClassified( @ModelAttribute CityClassified cityclassified ,Principal principal,Model model,HttpSession session) {
		try
		{
		String name=principal.getName();
		CityUser cityuser=this.cityuserRepo.getUserByUserName(name);
		cityclassified.setCityuser(cityuser);
		cityuser.getCityclassified().add(cityclassified);
		this.cityuserRepo.save(cityuser);
		System.out.println("Data "+cityclassified);
		System.out.println("Added to database");
		session.setAttribute("message", new Message("Your PostClassified is added !! add more", "success"));
		}catch(Exception e)
		{
			System.out.println("Error"+e.getMessage());
			e.printStackTrace();
			
			session.setAttribute("message", new Message("Something went wrong !!", "danger"));
		}
		
		model.addAttribute("title", "Your Classified Added Add More!!");
		return "normaluser/postclassified";
		
	}
	
	//view classified handler
	//per page=5[n]
	//current page=0[page]
	@GetMapping("/viewclassifieds/{page}")
	public String viewClassifieds(@PathVariable("page") Integer page,Model model,Principal principal) {
		model.addAttribute("title", "citysearch-viewclassified");
		
		String username=principal.getName();
		CityUser cityuser=this.cityuserRepo.getUserByUserName(username);
		//current page
		//record per page
		Pageable pageable=PageRequest.of(page, 6);
		Page<CityClassified> cityclassifieds=this.cityclassifiedRepo.findCityClassifiedByUser(cityuser.getId(),pageable);
		model.addAttribute("cityclassifieds", cityclassifieds);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages",cityclassifieds.getTotalPages());
		
		
		return "normaluser/viewclassifieds";
	}
	
	

}
