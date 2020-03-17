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

import swe425.project.MIUScheduler.model.Block;
import swe425.project.MIUScheduler.service.BlockService;


@Controller
public class BlockController {
	
	@Autowired
	private BlockService blockService;

	@RequestMapping(value="/blocks", method = RequestMethod.GET)
	public ModelAndView blocks(){		
		List<Block> blocks = blockService.findAll();		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("blocks", blocks);
		modelAndView.setViewName("block/list");
		return modelAndView;
	}
	
	@RequestMapping(value="/block", method = RequestMethod.GET)
	public String create(Model model){			
		model.addAttribute("block", new Block());
		return "block/edit";
	}
	
	@RequestMapping(value = "/block", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("block") Block block, 
			BindingResult result, Model model)  {

		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "block/edit";
		}
		block = blockService.save(block);
		return "redirect:/blocks";
	}	
	
	@RequestMapping(value="/block/{id}", method = RequestMethod.GET)
	public String view(@PathVariable Integer id, Model model){	
		model.addAttribute("block", blockService.findOne(id));
		return "block/edit";
	}
	
	@RequestMapping(value="/block/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Integer id, Model model){		
		blockService.delete(id);
		return "redirect:/blocks";
	}	
}
