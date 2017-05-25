package com.karpov.commom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping(value = { "/employees", "/" })
	public String employeeList(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		model.addAttribute("employees", employeeRepository.findAll());

		return "employee";
	}

	/*
	 * @RequestMapping(value = "new", method = RequestMethod.GET) public
	 * ModelAndView newContact(ModelAndView model) { Employee employee = new
	 * Employee(); model.addObject("employee", employee);
	 * model.setViewName("redirect:/employees"); return model; }
	 */

	@PostMapping(value = "save")
	public String saveEmployee(Model model, @Valid Employee employee, BindingResult results,
			RedirectAttributes redirect) {

		if (results.hasErrors()) {
			model.addAttribute("employees", employeeRepository.findAll());
			return "employee";
		}

		employeeRepository.save(employee);

		redirect.addFlashAttribute("success", "Saved contact successfully!");

		return "redirect:/employees";

	}

	@RequestMapping(value = "/edit/{Id}")
	public String editContact(Model model, @PathVariable Long Id) {
		Employee employee = employeeRepository.findOne(Id);
		model.addAttribute("employees", employeeService.getAllEmployees());
		model.addAttribute("employee", employee);
		return "employee";
	}

	@RequestMapping(value = "/delete/{Id}")
	public ModelAndView delete(@PathVariable Long Id, RedirectAttributes redirect) {
		employeeRepository.delete(Id);

		redirect.addFlashAttribute("success", "Emp ID " + Id + " Deleted successfully!");
		return new ModelAndView("redirect:/employees");
	}

}
