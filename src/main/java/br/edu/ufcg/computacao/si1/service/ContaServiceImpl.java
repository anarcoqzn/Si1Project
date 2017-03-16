package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.Conta;
import br.edu.ufcg.computacao.si1.model.Usuario;
import br.edu.ufcg.computacao.si1.model.form.UsuarioForm;
import br.edu.ufcg.computacao.si1.repository.ContaRepository;
import br.edu.ufcg.computacao.si1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ContaServiceImpl implements ContaService{

	@Autowired
    private ContaRepository contaRepository;

    @Autowired
    public void setContaRepository(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

	@Override
	public boolean update(Conta conta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long numero_conta) {
		// TODO Auto-generated method stub
		return false;
	}

}
