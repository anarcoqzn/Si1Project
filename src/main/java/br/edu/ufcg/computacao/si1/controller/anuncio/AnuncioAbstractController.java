package br.edu.ufcg.computacao.si1.controller.anuncio;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ufcg.computacao.si1.model.form.AnuncioForm;
import br.edu.ufcg.computacao.si1.repository.AnuncioRepository;
import br.edu.ufcg.computacao.si1.service.AnuncioServiceImpl;

@Controller
public abstract class AnuncioAbstractController  {

  @Autowired
  protected AnuncioServiceImpl anuncioService;

  @Autowired
  protected AnuncioRepository anuncioRepository;

  @RequestMapping(value = "/listar/anuncios", method = RequestMethod.GET)
  public ModelAndView getPageListarAnuncios() {
    ModelAndView model = new ModelAndView();

    model.addObject("anuncios", anuncioService.getAnuncioRepository().findAll());

    model.setViewName("sharedProfile/listar_anuncios");

    return model;
  }

  public abstract ModelAndView cadastroAnuncio(@Valid AnuncioForm anuncioForm, BindingResult result,
      RedirectAttributes attributes);
  public abstract ModelAndView getPageCadastrarAnuncio(AnuncioForm anuncioForm);

}
