package br.ufac.academico.tests;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import br.ufac.academico.domain.Atendente;
import br.ufac.academico.domain.enums.PerfilAtendente;
import br.ufac.academico.domain.enums.StatusAtendente;
import br.ufac.academico.repositories.AtendenteRepositorio;

public class AtendenteTeste {
	
	public static void main(String[] args) {
		
		AtendenteRepositorio ar = new AtendenteRepositorio();
		List<Atendente> atendentes;
		Atendente a1,a2,a3;
		@SuppressWarnings("unused")
		Date d1,d2,d3;
		
		a1 = new Atendente();
		a1.setCpf("027.725.062-58");
		a1.setEmail("raulawliet@gmail.com");
		a1.setNome("Raul Vitor Lopes da Costa");
		a1.setPerfil(PerfilAtendente.SUPERVISOR);
		a1.setRamal("7034");
		a1.setStatus(StatusAtendente.AUSENTE);
		a1.setUltimoAcesso(d1 = new Date());
		
		a2 = new Atendente();
		a2.setCpf("021.590.732-96");
		a2.setEmail("will_menezes@gmail.com");
		a2.setNome("Jos� William Menezes Ribeiro");
		a2.setPerfil(PerfilAtendente.BALCONISTA);
		a2.setRamal("9735");
		a2.setStatus(StatusAtendente.DISPONIVEL);
		a2.setUltimoAcesso(d2 = new Date());
		
		a3 = new Atendente();
		a3.setCpf("043.892.560-25");
		a3.setEmail("e151845839@mailox.fun");
		a3.setNome("Anderson Thomas Corte Real");
		a3.setPerfil(PerfilAtendente.BALCONISTA);
		a3.setRamal("2845");
		a3.setStatus(StatusAtendente.DISPONIVEL);
		a3.setUltimoAcesso(d3 = new Date());
		
		System.out.println("TESTE DE ADI��O");
		ar.adicionar(a1);
		ar.adicionar(a2);
		ar.adicionar(a3);
		
		atendentes = ar.recuperarTodos();
		System.out.println("TESTE DE LISTAGEM");
		for(Atendente atendente: atendentes){
			System.out.println(atendente);
		}
		
		JOptionPane.showMessageDialog(null, "Confira se os dados foram gerados no banco");
		JOptionPane.showMessageDialog(null, "Agora eles ser�o excluidos");
		atendentes = ar.recuperarTodos();
		System.out.println("TESTE DE EXCLUS�O");
		for(Atendente atendente: atendentes){
			ar.remover(atendente);
		}
		atendentes = ar.recuperarTodos();
		if(atendentes.isEmpty()){
			System.out.println("TODOS OS REGISTROS FORAM EXCLUIDOS");
		}
		ar.encerrar();
	}
	
	

}
