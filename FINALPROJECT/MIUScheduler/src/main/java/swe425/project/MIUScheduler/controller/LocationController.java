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

import swe425.project.MIUScheduler.model.Location;
import swe425.project.MIUScheduler.service.LocationService;


@Controller
public class LocationController {
	
	@Autowired
	private LocationService locationService;

	@RequestMapping(value="/locations", method = RequestMethod.GET)
	public ModelAndView locations(){		
		List<Location> locations = locationService.findAll();		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("locations", locations);
		modelAndView.setViewName("location/list");
		return modelAndView;
	}
	
	@RequestMapping(value="/location", method = RequestMethod.GET)
	public String create(Model model){			
		model.addAttribute("location", new Location());
		return "location/edit";
	}
	
	@RequestMapping(value = "/location", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("location") Location location, 
			BindingResult result, Model model)  {

		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "location/edit";
		}
		location = locationService.save(location);
		return "redirect:/locations";
	}	
	
	@RequestMapping(value="/location/{id}", method = RequestMethod.GET)
	public String view(@PathVariable Integer id, Model model){	
		model.addAttribute("location", locationService.findOne(id));
		return "location/edit";
	}
	
	@RequestMapping(value="/location/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Integer id, Model model){		
		locationService.delete(id);
		return "redirect:/locations";
	}	
}
