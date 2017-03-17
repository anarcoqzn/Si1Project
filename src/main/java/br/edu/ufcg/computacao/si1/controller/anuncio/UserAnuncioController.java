package br.edu.ufcg.computacao.si1.controller.anuncio;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ufcg.computacao.si1.model.Anuncio;
import br.edu.ufcg.computacao.si1.model.form.AnuncioForm;

@Controller
@RequestMapping(value="/user")
public class UserAnuncioController extends AnuncioAbstractController {
  
  @Override
  @RequestMapping(value = "/cadastrar/anuncio", method = RequestMethod.GET)
  public ModelAndView getPageCadastrarAnuncio(AnuncioForm anuncioForm){
      ModelAndView model = new ModelAndView();

      model.addObject("tipos", anuncioForm.getTipos());
      model.setViewName("user/cadastrar_anuncio");

      return model;
}
 
  @Override
  @RequestMapping(value = "/cadastrar/anuncio", method = RequestMethod.POST)
  public ModelAndView cadastroAnuncio(@Valid AnuncioForm anuncioForm, BindingResult result, RedirectAttributes attributes){
      if(result.hasErrors()){
          return getPageCadastrarAnuncio(anuncioForm);
      }

      Anuncio anuncio = new Anuncio();
      anuncio.setTitulo(anuncioForm.getTitulo());
      anuncio.setPreco(anuncioForm.getPreco());
      anuncio.setTipo(anuncioForm.getTipo());
      anuncio.setCategoria(anuncioForm.getCategoria());
      //TODO Solução temporária, ainda é necessário criar uma ligação entre usuário e anúncio criado
      anuncio.setAvaliacao("");
      anuncioService.create(anuncio);

      attributes.addFlashAttribute("mensagem", "Anúncio cadastrado com sucesso!");
      return new ModelAndView("redirect:/user/cadastrar/anuncio");
  }
  
//  @RequestMapping(value = "/saldos", method = RequestMethod.GET)
//  public ModelAndView getPageListarSaldos() {
//    ModelAndView model = new ModelAndView();
//
//    model.setViewName("sharedProfile/listar_saldos");
//    model.addObject("saldos", "Em Construção");
//
//    return model;
//  }

}
