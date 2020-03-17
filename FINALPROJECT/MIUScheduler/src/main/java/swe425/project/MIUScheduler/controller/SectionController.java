package swe425.project.MIUScheduler.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import swe425.project.MIUScheduler.model.Section;
import swe425.project.MIUScheduler.service.SectionService;


@Controller
public class SectionController {
	
	@Autowired
	private SectionService sectionService;

	@RequestMapping(value="/sections", method = RequestMethod.GET)
	public ModelAndView sections(){		
		List<Section> sections = sectionService.findAll();		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("sections", sections);
		modelAndView.setViewName("section/list");
		return modelAndView;
	}
	
	@RequestMapping(value="/section", method = RequestMethod.GET)
	public String create(Model model){			
		model.addAttribute("section", new Section());
		return "section/edit";
	}
	
	@RequestMapping(value = "/section", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("section") Section section, 
			BindingResult result, Model model)  {

		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "section/edit";
		}
		section = sectionService.save(section);
		return "redirect:/sections";
	}	
	
	@RequestMapping(value="/section/{id}", method = RequestMethod.GET)
	public String view(@PathVariable Integer id, Model model){	
		model.addAttribute("section", sectionService.findOne(id));
		return "section/edit";
	}
	
	@RequestMapping(value="/section/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Integer id, Model model){		
		sectionService.delete(id);
		return "redirect:/sections";
	}	
}
