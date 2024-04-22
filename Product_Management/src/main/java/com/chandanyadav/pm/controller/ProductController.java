package com.chandanyadav.pm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.chandanyadav.pm.entity.ProductEnt;
import com.chandanyadav.pm.service.ProductService;

@RestController
public class ProductController 
{
	@Autowired
	private ProductService service;
	
	@RequestMapping({"/","/index"})
	public String home(Model m)
	{
		
		List<ProductEnt> list = service.displayprod();
		m.addAttribute("list",list);
		return "index";
	}
	@GetMapping("/add_form")
	public String loadform()
	{
		return "add";
	}
	@GetMapping("/edit_form")
	public String editform()
	{
		return "edit";
	}
	@PostMapping("/save")
	public String saveProducts(@ModelAttribute ProductEnt p, HttpSession session)
	{
		service.addProduct(p);
		session.setAttribute("msg", "Added Successfully");
		System.out.println(p);
		return "redirect:/add_form";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable long id)
	{
		service.delete(id);
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable long id, Model m)
	{
		ProductEnt e = service.getProdById(id);
		m.addAttribute("pro" , e);
		return "edit";
	}
	@PostMapping("/update")
	public String updateProd(@ModelAttribute ProductEnt e, HttpSession session)
	{
		service.addProduct(e);
		session.setAttribute("msg2","Update Succesfully");
		return "redirect:/";
	}
}
