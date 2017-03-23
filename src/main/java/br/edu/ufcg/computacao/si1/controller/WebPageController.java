package br.edu.ufcg.computacao.si1.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ufcg.computacao.si1.model.Usuario;
import br.edu.ufcg.computacao.si1.service.UsuarioServiceImpl;

@Controller
public class WebPageController {
  
    @Autowired
    protected UsuarioServiceImpl usuarioService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getPageIndex(){
        ModelAndView model = new ModelAndView();
        model.setViewName("index");

        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getPageLogin(){
        ModelAndView model = new ModelAndView();
        model.setViewName("login");

        return model;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView getPageIndexUser(){
        ModelAndView model = new ModelAndView();

        Usuario user = getUsuarioLogado();
        model.addObject("user", user);
        model.setViewName("sharedProfile/index");

        return model;
    }

    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public ModelAndView getPageIndexCompany(){
        ModelAndView model = new ModelAndView();

        Usuario user = getUsuarioLogado();
        model.addObject("user", user);
       
        model.setViewName("sharedProfile/index");
        
        return model;
    }
    
    @RequestMapping(value = "/about-us", method = RequestMethod.GET)
    public ModelAndView getPageAboutUs(){
        ModelAndView model = new ModelAndView();
        model.setViewName("about_us");

        return model;
    }

    protected Usuario getUsuarioLogado(){
        User springUser =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Usuario> user = usuarioService.getByEmail(springUser.getUsername());
        return user.get();
    }
}
