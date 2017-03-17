package br.edu.ufcg.computacao.si1.controller.anuncio;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ufcg.computacao.si1.model.Anuncio;
import br.edu.ufcg.computacao.si1.model.comparator.CompAnuncioData;
import br.edu.ufcg.computacao.si1.model.comparator.CompAnuncioPrecoAsc;
import br.edu.ufcg.computacao.si1.model.comparator.CompAnuncioPrecoDesc;
import br.edu.ufcg.computacao.si1.model.form.AnuncioForm;
import br.edu.ufcg.computacao.si1.repository.AnuncioRepository;
import br.edu.ufcg.computacao.si1.service.AnuncioServiceImpl;

@Controller
public abstract class AnuncioAbstractController {

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

  @RequestMapping(value = "/listar/buscar", method = RequestMethod.GET)
  public ModelAndView getBuscaAnuncios(@RequestParam String chave,
      @RequestParam Optional<String> nome, @RequestParam Optional<String> categoria) {

    Set<Anuncio> anuncios = new LinkedHashSet<Anuncio>();

    if (nome != null) {
      anuncios.addAll(anuncioService.getAnuncioRepository().findByTitulo(chave));
    }

    if (categoria != null) {
      anuncios.addAll(anuncioService.getAnuncioRepository().findByCategoria(chave));
    }

    ModelAndView model = new ModelAndView();
    model.setViewName("sharedProfile/listar_anuncios");

    model.addObject("anuncios", anuncios);

    return model;
  }

  @RequestMapping(value = "/listar/sort", method = RequestMethod.GET)
  public ModelAndView sort(@RequestParam int tipo) {
    List<Anuncio> anuncios = anuncioService.getAnuncioRepository().findAll();

    switch (tipo) {
      case 0:
        Collections.sort(anuncios, new CompAnuncioData());
        break;
      case 1:
        Collections.sort(anuncios, new CompAnuncioPrecoDesc());
        break;
      case 2:
        Collections.sort(anuncios, new CompAnuncioPrecoAsc());
        break;
    }

    ModelAndView model = new ModelAndView();
    model.setViewName("sharedProfile/listar_anuncios");
    model.addObject("anuncios", anuncios);

    return model;
  }

  public abstract ModelAndView cadastroAnuncio(@Valid AnuncioForm anuncioForm, BindingResult result,
      RedirectAttributes attributes);

  public abstract ModelAndView getPageCadastrarAnuncio(AnuncioForm anuncioForm);

}
