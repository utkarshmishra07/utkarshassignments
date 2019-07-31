package springmvcxmldemo.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
     @RequestMapping("/add")
     public ModelAndView add(@RequestParam("num1") String num1,@RequestParam("num2") String num2)
     {
     System.out.println("add called");
     int sum=Integer.parseInt(num1)+Integer.parseInt(num2);
     ModelAndView mv=new ModelAndView();
     mv.addObject("sum",sum);
     mv.setViewName("welcome");
     return mv;
     }
}
