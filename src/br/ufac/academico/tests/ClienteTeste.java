package br.ufac.academico.tests;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import br.ufac.academico.domain.Cliente;
import br.ufac.academico.domain.Municipio;
import br.ufac.academico.domain.enums.SexoCliente;
import br.ufac.academico.domain.enums.StatusCliente;
import br.ufac.academico.domain.enums.TipoCliente;
import br.ufac.academico.repositories.ClienteRepositorio;
import br.ufac.academico.repositories.MunicipioRepositorio;

public class ClienteTeste {
	
	public static void main(String[] args) {
		
		ClienteRepositorio cr = new ClienteRepositorio();
		MunicipioRepositorio mr = new MunicipioRepositorio();
		@SuppressWarnings("unused")
		Date d1,d2,d3;
		List<Cliente> clientes;
		
		Municipio m1,m2,m3;
		Cliente c1,c2,c3;
		
		m1 =new Municipio();
		m1.setCep("69911036");
		m1.setNome("Rio Branco");
		m1.setUfEstado("AC");
		
		m2 =new Municipio();
		m2.setCep("69736374");
		m2.setNome("Sea Madureira");
		m2.setUfEstado("AC");
		
		m3 =new Municipio();
		m3.setCep("87299365");
		m3.setNome("Maragogi");
		m3.setUfEstado("PE");
		
		c1= new Cliente();
		c1.setCadastro(d1 = new Date());
		c1.setContato("Francisco H.");
		c1.setCpf("791.886.159-01");
		c1.setEmail("franciscohugorobertogalvao@rodrigofranco.com");
		c1.setEndereco("Rua Catuipe 279 Parque dos Anjos");
		c1.setFone("(51) 99803-6615");
		c1.setNome("Francisco Hugo Roberto Galv�o");
		c1.setSexo(SexoCliente.MASCULINO);
		c1.setStatus(StatusCliente.CREDOR);
		c1.setTipo(TipoCliente.PESSOAFISICA);
		c1.setMunicipio(m1);
		
		c2= new Cliente();
		c2.setCadastro(d2 = new Date());
		c2.setContato("Nat�lia F.");
		c2.setCpf("393.962.574-43");
		c2.setEmail("nnataliaoliviafogaca@alanamaral.com.br");
		c2.setEndereco("Rua Teresinha Lages Visgueira 508 Vale Quem Tem");
		c2.setFone("(86) 98215-5693");
		c2.setNome("Nat�lia Olivia Foga�a");
		c2.setSexo(SexoCliente.FEMININO);
		c2.setStatus(StatusCliente.DEVEDOR);
		c2.setTipo(TipoCliente.PESSOAFISICA);
		c2.setMunicipio(m2);
		
		c3= new Cliente();
		c3.setCadastro(d3 = new Date());
		c3.setContato("Francisco H.");
		c3.setCpf("791.886.159-01");
		c3.setEmail("franciscohugorobertogalvao@rodrigofranco.com");
		c3.setEndereco("Rua Catuipe 279 Parque dos Anjos");
		c3.setFone("(51) 99803-6615");
		c3.setNome("Francisco Hugo Roberto Galv�o");
		c3.setSexo(SexoCliente.MASCULINO);
		c3.setStatus(StatusCliente.QUITADO);
		c3.setTipo(TipoCliente.PESSOAFISICA);
		c3.setMunicipio(m3);
		
		System.out.println("TESTANDO INSER��O");
		cr.adicionar(c1);
		cr.adicionar(c2);
		cr.adicionar(c3);
		
		
		System.out.println("TESTANDO LISTAGEM");
		clientes = cr.recuperarTodos();
		for(Cliente cliente: clientes){
			System.out.println(cliente);
		}
		JOptionPane.showMessageDialog(null, "Confira se os dados foram gerados no banco");
		JOptionPane.showMessageDialog(null, "Agora eles ser�o excluidos");
		System.out.println("TESTANDO EXCLUS�O");
		for(Cliente cliente: clientes){
			cr.remover(cliente);
		}
		clientes = cr.recuperarTodos();
		if(clientes.isEmpty()){
			System.out.println("TODOS OS REGISTRO FORAM REMOVIDOS");
		}
		
		mr.encerrar();
		cr.encerrar();
		
		
		
	}

}
