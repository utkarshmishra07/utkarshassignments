package springmvcxmldemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvcxmldemo.bo.CustomerBo;

import springmvcxmldemo.entities.Customer;

@Controller
public class CustomerController {

	@Autowired
	CustomerBo customerBo;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginpage() {
		return "login";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signuppage() {
		return "signup";
	}


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView getLogin(@RequestParam("email") String email, @RequestParam("pwd") String pass) {
		ModelAndView mv = new ModelAndView();
		Customer customer;
		try {

			customer = customerBo.login(email, pass);
			mv.setViewName("welcome");
			mv.addObject("name", customer.getCname());
		} catch (Exception e) {
			mv.setViewName("login");
			mv.addObject("error", e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView getSignup(@ModelAttribute Customer cu) {
		ModelAndView mv = new ModelAndView();
	
		try {
			customerBo.signup(cu);
			mv.setViewName("login");
			mv.addObject("name", cu.getCname());
		} catch (Exception e) {
			mv.setViewName("signup");
			mv.addObject("error", e.getMessage());
			e.printStackTrace();
		}
		return mv;

	}
	
	@RequestMapping(value = "/update")
	public ModelAndView getUpdate(@RequestParam("phone") String phone, @RequestParam("cid") int cid) {
		ModelAndView mv = new ModelAndView();
		
		try {
			customerBo.editCustomer(Long.parseLong(phone),cid);
			mv.setViewName("login");
			
		} catch (Exception e) {
			mv.setViewName("update");
			mv.addObject("error", e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}
	@RequestMapping(value = "/getall")
	public ModelAndView getAll() {
		ModelAndView mv = new ModelAndView();
	
		try {
			List<Customer> ca=customerBo.getAllCustomers();
			mv.addObject("ca", ca);
			mv.setViewName("getall");
			
		} catch (Exception e) {
			mv.setViewName("welcome");
			mv.addObject("error", e.getMessage());
			e.printStackTrace();
		}
		return mv;

	}
	@RequestMapping("/edit/{cid}")
	public String editPerson(@PathVariable("cid") int id, Model model) {
		model.addAttribute("customer", this.customerBo.getById(id));
		model.addAttribute("customers", this.customerBo.getAllCustomers());
		return "customer";
	}
	@RequestMapping("/remove/{cid}")
	public String removePerson(@PathVariable("cid") int id, Model model) {
		model.addAttribute("remove", this.removePerson(id, model));
		return "remove";
	}
}
