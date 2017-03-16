package br.edu.ufcg.computacao.si1.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.authority.AuthorityUtils;

@Entity(name = "Usuario")
@Table(name = "tb_usuario")
public class Usuario extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String nome;

	@Column(unique = true)
	private String email;

	@Column
	private String senha;

	@Column
	private String role;

	// A composição de Conta nesta classse tem relação OneToOne com o usuário.
	private Conta conta = new Conta(1000000);

	public Usuario() {
		super("default", "default", AuthorityUtils.createAuthorityList("USER"));
	}

	public Usuario(String nome, String email, String senha, String role) {

		super(email, senha, AuthorityUtils.createAuthorityList(role));

		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.role = role;
	}

	/**
	 * Recupera valor de relação OneToOne com o usuário.
	 * 
	 * @return O número da conta
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "numero_conta")
	public Long getNumeroConta() {
		return conta.getNumero();
	}

	/**
	 * Recupera o saldo do usuário.
	 * 
	 * @return O saldo da conta deste usuário.
	 */
	public double getSaldoConta() {
		return conta.getSaldo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String n) {
		this.nome = n;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String r) {
		this.role = r;
	}

}
