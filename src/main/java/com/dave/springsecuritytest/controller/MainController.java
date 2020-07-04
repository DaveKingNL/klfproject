
package com.dave.springsecuritytest.controller;

import com.dave.springsecuritytest.model.User;
import com.dave.springsecuritytest.model.UserActivity;
import com.dave.springsecuritytest.model.dao.UserActivityDao;
import com.dave.springsecuritytest.model.dao.UserDao;
import com.dave.springsecuritytest.service.MailSender;
import java.security.Principal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author davej
 */
@Controller
public class MainController {
    
    @Autowired
    private UserDao dao;
    
    @Autowired
    private UserActivityDao activityDao;
    
    @GetMapping("/")
    public String loadHomePage(){
        return "index";
    }
    
    @GetMapping("/user/profile")
    public ModelAndView loadProfilePage(Principal principal){
        User user = dao.readUser(principal.getName());
        
        return new ModelAndView("profile", "user", user);
    }
    
    @PostMapping("/user/profile")
    public ModelAndView updateProfile(@ModelAttribute("user") @Valid User user, BindingResult binding, Model model, Principal principal){
        if (binding.hasErrors()) {return new ModelAndView("profile", "user", user);}
        
        dao.updateUser(user);
        activityDao.createUserActivity(principal.getName(), 1);
        model.addAttribute("msg", "You have succesfully updated your profile");
        return new ModelAndView("profile", "user", user);
        
    }
    
    @GetMapping("/admin")
    public String loadAdminPage(){
        return "admin";
    }
    
    @GetMapping("/create-user")
    public ModelAndView createUser(){
        return new ModelAndView("createUserForm", "user", new User());
    }
    
    @PostMapping("/creating-user")
    public String creatingUser(@ModelAttribute("user") @Valid User user, BindingResult binding, Model model){
        System.out.println("Errors:" + binding.hasErrors());
        if (binding.hasErrors()) {
            return "createUserForm";
	} else {
            try{
                dao.readUser(user.getUsername());
                model.addAttribute("msg", "There is already someone with the same username in our system");
                return "createUserForm";
            }
            catch(EmptyResultDataAccessException e){
                dao.createUser(user);
                model.addAttribute("successMsg", "You have succesfully registered");		
                return "success";
                
            }
        }
    }
    
    
    
    
    @GetMapping("/about")
    public String loadAboutPage(){
        return "about";
    }
    
    @GetMapping("statistics")
    public ModelAndView loadStatisticsPage(){
        LocalDate currentdate = LocalDate.now();
        Month month = currentdate.getMonth();
        List<UserActivity> activities = activityDao.listUserActivity(month);
        return new ModelAndView("statistics", "activities", activities);
    }
    
    @PostMapping("pressing-button")
    public String pressButton(Principal principal){
        activityDao.createUserActivity(principal.getName(), 3);
        return "redirect:/statistics";
    }
    
    
    
    @GetMapping("/contact-form")
    public ModelAndView loadContactForm(Principal principal){
        User user = new User();
        try{ user = dao.readUser(principal.getName());
        } catch(NullPointerException e){System.out.println("User doesn't exist yet");}
        
        return new ModelAndView("contactForm", "user", user);
             
    }
    
    
    @PostMapping("/send-mail")
    public String sendingEmail(@ModelAttribute("user") @Valid User user, BindingResult binding, Model model, Principal principal){
        String senderName = user.getUsername(); 
        String mailMessage = user.getMessage();
        
        MailSender.sendEmail(senderName, mailMessage);
        try{ user = dao.readUser(principal.getName());
        activityDao.createUserActivity(principal.getName(), 2);
        } catch(NullPointerException e){System.out.println("User doesn't exist yet");}
        model.addAttribute("successMsg", "You have succesfully send a message");
        
        return "success";
    }
    
    
}
