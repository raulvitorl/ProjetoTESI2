package br.ufac.academico.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import br.ufac.academico.domain.enums.PerfilAtendente;
import br.ufac.academico.domain.enums.StatusAtendente;

@Entity
@Table(name="atendentes")
//Consultas que ser�o realizadas no reposit�rio

@NamedQueries({
	//Essa named querry retorna todos os Atendentes,
	//e vai ser chamada de dentro do reposit�rio
	@NamedQuery(name="Atendentes.todos", 
		query="SELECT a FROM Atendente a"),
	
	@NamedQuery(name="Atendentes.todosPorNome", 
		query="SELECT a FROM Atendente a ORDER BY a.nome")
})

public class Atendente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	@Column(name="ate_nome",length=50)
	private String nome;
	@Column(name="ate_ulltimo_acesso")
	private Date ultimoAcesso;
	@Column(name="ate_ramal",length=4)
	private String ramal;
	@Column(name="ate_email")
	private String email;
	@Column(name="ate_status")
	private Integer status;
	@Column(name="ate_perfil")
	private Integer perfil;
	@Column(name="ate_cpf")
	private String cpf;

	@OneToMany(mappedBy = "atendente", targetEntity = Venda.class, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Collection<Venda> vendas;
	
	@OneToMany(mappedBy = "atendente", targetEntity = Mensagem.class, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Collection<Mensagem> mensagens;
	
	public Atendente() {}



	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StatusAtendente getStatus() {
		return StatusAtendente.toEnum(status);
	}

	public void setStatus(StatusAtendente status) {
		this.status = status.getCod();
	}

	public PerfilAtendente getPerfil() {
		return PerfilAtendente.toEnum(perfil);
	}

	public void setPerfil(PerfilAtendente perfil) {
		this.perfil = perfil.getCod();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Collection<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(Collection<Venda> vendas) {
		this.vendas = vendas;
	}

	public Collection<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(Collection<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	@Override
	public String toString() {
		return "Atendentes [codigo=" + codigo + ", nome=" + nome + ", ultimoAcesso=" + ultimoAcesso + ", ramal=" + ramal
				+ ", email=" + email + ", status=" + status + ", perfil=" + perfil + ", cpf=" + cpf + ", vendas="
				+ vendas + ", mensagens=" + mensagens + "]";
	}
	
	

	
}