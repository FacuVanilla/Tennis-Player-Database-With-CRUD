package com.oluwaseun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oluwaseun.model.Player;
import com.oluwaseun.services.PlayerServices;


@Controller
public class PlayerController {

	@Autowired
	PlayerServices service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Player> listPlayer = service.listAll();
		model.addAttribute("listPlayer", listPlayer);
		return "index";
	}
	
	@RequestMapping("/new")
	public String newPlayerPage(Model model) {
		Player player = new Player();
		model.addAttribute(player);
		return "new_player";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String savePlayer(@ModelAttribute ("player") Player player) {
		service.save(player);
		return "redirect:/";
	}
	@RequestMapping("edit/{sid}")
	public ModelAndView showEditStudentPage(@PathVariable (name="sid") Long sid) {
		ModelAndView mav=new ModelAndView("edit_player");
		Player player = service.get(sid);
		mav.addObject("player",player);
		return mav;
	}
	@RequestMapping("delete/{sid}")
	public String deletePlayerPage(@PathVariable (name="sid") Long sid) {
		service.delete(sid);
		return "redirect:/";
	}
	
}

