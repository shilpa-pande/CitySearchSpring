package com.citysearch.controller;

import java.security.Principal;
//import java.util.List;
import java.util.Optional;

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

import com.citysearch.entities.AdminClassified;
import com.citysearch.helper.Message;
import com.citysearch.repository.AdminClassifiedRepo;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	
	@Autowired
	private AdminClassifiedRepo  adminclassifiedRepo;
	
	@RequestMapping("index")
	public String dashboard(Model model,Principal principal) {
		model.addAttribute("title", "Admin DashBoard");
		
		return "admin/admindashboard";
	}
	@RequestMapping("/adminpostclassified")
	public String register(Model model) {
		
		model.addAttribute("title", "Register - City Search");
		model.addAttribute("adminclassified",new AdminClassified());
		return "admin/adminpostclassified";
	}
	@PostMapping("/process_adminpostclassified")
	public String processRegister( @ModelAttribute AdminClassified adminclassified,Model model,HttpSession session) {
		
		try
		{
			adminclassifiedRepo.save(adminclassified);
			System.out.println("Added to database");
			session.setAttribute("message", new Message("Your PostClassified is added !! add more", "success"));
		}catch(Exception e)
		{
			System.out.println("Error"+e.getMessage());
			e.printStackTrace();
			
			session.setAttribute("message", new Message("Something went wrong !!", "danger"));
		}
		
		model.addAttribute("title", "Your Classified Added Add More!!");
		return "admin/adminpostclassified";
		
	}
	@GetMapping("/actionclassified/{page}")
	public String actionclassified(@ModelAttribute AdminClassified adminclassified,@PathVariable("page") Integer page,Model model,Principal principal) {
		
		Pageable pageable=PageRequest.of(page, 5);
		Page<AdminClassified> listPosters = adminclassifiedRepo.findAll(pageable);
		model.addAttribute("listPosters", listPosters);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages",listPosters.getTotalPages());
		
		return "admin/actionclassified";
	}
	
	//delete post classified
	
	@GetMapping("/delete/{id}")
	public String deleteclassified(@PathVariable("id") Integer id,Model model, HttpSession session) {
		
		Optional<AdminClassified> adminclassifiedOptional=this.adminclassifiedRepo.findById(id);
		AdminClassified adminclassified=adminclassifiedOptional.get();
		
		
		
		this.adminclassifiedRepo.delete(adminclassified);
		session.setAttribute("message", new Message("classified deleted successfully.....","success"));
		return "redirect:/admin/actionclassified/0";
		
	}
	
	//update classified
	
	@PostMapping("/update/{id}")
	public String updateclassified(@PathVariable("id") Integer id,Model model, HttpSession session) {
		
		model.addAttribute("title","update classified");
	AdminClassified	adminclassified=this.adminclassifiedRepo.findById(id).get();
	model.addAttribute("adminclassified", adminclassified);
		return "admin/updateclassified";
		
	}
	
	//update process
	
	@PostMapping("/process_update")
	public String updateProcess(@ModelAttribute AdminClassified adminclassified,Model model,HttpSession session) {
		try {
			this.adminclassifiedRepo.save( adminclassified);
			System.out.println("Added to database");
			session.setAttribute("message", new Message("classified updated successfully.....","success"));
		}catch(Exception e)
		{
			System.out.println("Error"+e.getMessage());
			e.printStackTrace();
			
			session.setAttribute("message", new Message("Something went wrong !!", "danger"));
		}
		
		model.addAttribute("title", "Your Classified updated!!");
		return "redirect:/admin/actionclassified/0";
		
		
	}
	
	
	

}
