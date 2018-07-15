package com.percival.test.controllers;

import com.percival.test.models.CompanyProfile;
import com.percival.test.models.User;
import com.percival.test.services.CompanyProfileService;
import com.percival.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @Autowired
    CompanyProfileService profileService;

    @Autowired
    JavaMailSender mailSender;
    private static final String BASE_URI = "http://localhost:8080";
    String token = UUID.randomUUID().toString();

    String message = "Hello Myself";

    @RequestMapping(value="/")
    public String index(Model model) {
        model.addAttribute("search", "");
        return "search";
    }
    @GetMapping(value="/token/{token}")
    public String notesList(Model model, @PathVariable(required = false, name = "token") String token) {
        if (token != null){
            User user = userService.findByToken(token);
            user.setActivated(true);
            userService.saveUser(user);
        }
        model.addAttribute("search", "");
        return "search";
    }


  @GetMapping(value="/search/{search}")
  public String findByCategory (Model model, @PathVariable(required = true, name = "search") String search) {
        if(search != null) {
            List<CompanyProfile> companyProfile = profileService.findByBusinessCategory(search);

            if (companyProfile != null) {

                model.addAttribute("companyList", companyProfile);
            }
List<CompanyProfile> companyProfileList = new ArrayList<>();
            model.addAttribute("companyList", companyProfileList);
            return "search";
        }

      List<CompanyProfile> companyProfileList = new ArrayList<>();
      model.addAttribute("companyList", companyProfileList);
      model.addAttribute("search", "");

      return "search";


    }



    @GetMapping(value={"/userEdit","/userEdit/{id}"})
    public String notesEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("user", userService.getOne(id));
        } else {
            model.addAttribute("user", new User());
        }
        return "userEdit";
    }

    @GetMapping(value={"/addProfile","/addProfile/{id}"})
    public String addProfile(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("companyProfile", profileService.getOne(id));
        } else {
            model.addAttribute("companyProfile", new CompanyProfile());
        }
        return "addProfile";
    }

    @PostMapping(value="/addProfile")
    public String addProfile(Model model, User u) {
        CompanyProfile companyProfile = u.getCompanyProfile();
       CompanyProfile companyProfile1 = profileService.save(companyProfile);

       User user= userService.getOne(u.getId());
       if (user!= null){
           user.setCompanyProfile(companyProfile1);
           User u1 = userService.saveUser(user);

           model.addAttribute("user", u1);

           return "addProfile";
       }
       else {
           return "search";
       }

    }

    @PostMapping(value="/login")
    public String login(Model model, User user) {
        User u = userService.findByEmailOrUsername(user.getUsername(),user.getUsername());
        if(u == null){
            model.addAttribute("search", "");
            return "search";
        }
        if (u.isActivated() == false){
            model.addAttribute("search", "");
            return "search";
        }
        model.addAttribute("user", u);
        return "addProfile";
    }
    @GetMapping(value="/login")
    public String getlogin(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping(value="/userEdit")
    public String notesEdit(Model model, User user) {
        User user1 = userService.findByEmailOrUsername(user.getEmail(),user.getUsername());
        if (user1 != null){
            return "search";
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                sendSimpleMessage(user.getEmail(), "Percival Confirmation", BASE_URI + "/token/" + token);

            }
        }).start();
user.setToken(token);
        userService.saveUser(user);
        return "ok";
    }


    @GetMapping(value="/userDelete/{id}")
    public String notesDelete(Model model, @PathVariable(required = true, name = "id") Long id) {
        User u = userService.getOne(id);
        if (u != null){
            userService.delete(u);
        }

        model.addAttribute("userList", userService.findAll());
        return "userList";
    }

    @GetMapping(value="/userList")
    public String notesDelete(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "userList";
    }

    private void sendSimpleMessage(String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);

    }





}
