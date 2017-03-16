package br.edu.ufcg.computacao.si1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufcg.computacao.si1.model.Conta;
import br.edu.ufcg.computacao.si1.model.Usuario;

@Repository
public interface ContaRepository extends JpaRepository<Usuario,Long>{

    Conta findByNumeroConta(Long numeroConta);
    double getSaldoByNumeroConta(Long numeroConta);
}
