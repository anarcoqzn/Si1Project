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
	private float saldoCredor;

    @Column
	private float saldoDevedor;
    
    @OneToMany(mappedBy = "criador")
	private List<Anuncio> anuncios;
    
    public Usuario(String nome, String email, String senha, String role) {

      super(email, senha, AuthorityUtils.createAuthorityList(role));

      this.nome = nome;
      this.email = email;
      this.senha = senha;
      this.role = role;

  }
	public Usuario() {
		super("default", "default", AuthorityUtils.createAuthorityList("USER"));

	}

  	public List<Anuncio> getAnuncios() {
	  return anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
	  this.anuncios = anuncios;
	}

	public float getSaldoCredor() {
		return saldoCredor;
	}

	public float getSaldoDevedor() {
		return saldoDevedor;
	}

	public void setSaldoDevedor(float saldoDevedor) {
		this.saldoDevedor = saldoDevedor;
	}

	public void setSaldoCredor(float saldoCredor) {
      this.saldoCredor = saldoCredor;
    }

	public void creditar(float credito){
    	this.saldoCredor += credito;
	}

	public void debitar(float debito){
		this.saldoDevedor -= debito;
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
	

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + ((anuncios == null) ? 0 : anuncios.hashCode());
      result = prime * result + ((email == null) ? 0 : email.hashCode());
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((nome == null) ? 0 : nome.hashCode());
      result = prime * result + ((role == null) ? 0 : role.hashCode());
      result = prime * result + Float.floatToIntBits(saldoCredor);
      result = prime * result + Float.floatToIntBits(saldoDevedor);
      result = prime * result + ((senha == null) ? 0 : senha.hashCode());
      return result;
    }

}
