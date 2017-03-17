package br.edu.ufcg.computacao.si1.model.comparator;

import java.util.Comparator;

import br.edu.ufcg.computacao.si1.model.Anuncio;

public class CompAnuncioData implements Comparator<Anuncio>{

  @Override
  public int compare(Anuncio o1, Anuncio o2) {
    return o1.getDataDeCriacao().compareTo(o2.getDataDeCriacao());
  }

}

