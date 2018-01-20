package org.evertones.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class DemoSecurityController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home1() {
        return "/home";
    }

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String home() {
        return "/home";
    }

    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    public String admin() {
        return "/admin";
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public String user() {
        return "/user";
    }

    @RequestMapping(path = "/about", method = RequestMethod.GET)
    public String about() {
        return "/about";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login() {
        return "/login";
    }

    @RequestMapping(path = "/403", method = RequestMethod.GET)
    public String error403(Principal principal) {
        System.out.println("User"  + principal.getName());
        return "/error/403";
    }

}
