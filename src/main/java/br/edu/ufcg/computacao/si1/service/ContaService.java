package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.Conta;

public interface ContaService {

    boolean update(Conta conta);

    boolean delete(Long numero_conta);
}
