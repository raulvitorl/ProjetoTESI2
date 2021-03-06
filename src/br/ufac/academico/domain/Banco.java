package br.ufac.academico.domain;


import java.util.Collection;
import javax.persistence.*;
@Entity
@NamedQueries({
	@NamedQuery(name="Bancos.todos", 
	query="SELECT b FROM Banco b"),
	@NamedQuery(name="Bancos.todosPorNome", 
	query="SELECT b FROM Banco b ORDER BY b.nome"),
	@NamedQuery(name="Bancos.todosPorNomeContendo",
	query="SELECT b FROM Banco b WHERE b.nome LIKE :termo ORDER BY b.nome")
})
@Table(name="bancos")
//Consultas que ser�o realizadas no reposit�ri
public class Banco {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	@Column(name="nome")
	private String nome;

	@OneToMany(mappedBy = "banco", targetEntity = Venda.class, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Collection<Venda> vendas;

	public Banco(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public Banco(){

	}

	public Integer getCodigo() {
		return codigo;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(Collection<Venda> vendas) {
		this.vendas = vendas;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Banco [codigo=" + codigo + ", nome=" + nome + "]";
	}

	
	

}
