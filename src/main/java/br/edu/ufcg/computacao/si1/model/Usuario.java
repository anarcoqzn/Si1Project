package br.edu.ufcg.computacao.si1.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.authority.AuthorityUtils;

@Entity(name = "Usuario")
@Table(name = "tb_usuario")
public class Usuario extends org.springframework.security.core.userdetails.User {

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

	@Column
	private String saldoCredor;
	

    @Column
	private String saldoDevedor;
    
    @OneToMany(mappedBy = "criador")
	private List<Anuncio> anuncios;

	public List<Anuncio> getAnuncios() {
	  return anuncios;
	}
	
	public void setAnuncios(List<Anuncio> anuncios) {
	  this.anuncios = anuncios;
	}
	
	public String getSaldoCredor() {
		return saldoCredor;
	}

	public void setSaldoCredor(String saldoCredor) {
		this.saldoCredor = saldoCredor;
	}

	public String getSaldoDevedor() {
		return saldoDevedor;
	}

	public void setSaldoDevedor(String saldoDevedor) {
		this.saldoDevedor = saldoDevedor;
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public void setRole(String role) {
		this.role = role;
	}

}
