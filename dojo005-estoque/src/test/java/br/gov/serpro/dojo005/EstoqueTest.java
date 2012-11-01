package br.gov.serpro.dojo005;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class EstoqueTest {
	
	@Test
	public void deveIncluirPerecivelEmCD() {
		Material material = criaMaterial("Perecivel", "Paulo César");
		CentralDistribuicao cd = new CentralDistribuicao();
		cd.inclui(material);
		
		assertThat(cd.getQuantidade(material)).isEqualTo(1);
	}
	
	@Test
	public void deveBaixarPerecivelDoCD() throws MaterialInexistenteException {
		Material material = criaMaterial("Perecivel 0", "Paulo César");
		
		CentralDistribuicao cd = new CentralDistribuicao();
		cd.inclui(material);
		
		assertThat(cd.getQuantidade(material)).isEqualTo(1);
		
		cd.baixa(material);

		assertThat(cd.getQuantidade(material)).isEqualTo(0);
	}

	@Test
	public void deveAdicionarDoisPereciveisIguais() {
		Material material = criaMaterial("Perecivel 1", "Paulo César");
		
		CentralDistribuicao cd = new CentralDistribuicao();
		cd.inclui(material, 2);
			
		assertThat(cd.getQuantidade(material)).isEqualTo(2);
	}
	
	@Test
	public void deveTrocarResponsavelPerecivel() {
		Material material = criaMaterial("Perecivel 1", "Paulo César");
		
		CentralDistribuicao cd = new CentralDistribuicao();
		cd.inclui(material, 2);
		assertThat(cd.getQuantidade(material)).isEqualTo(2);
		
		cd.transfere(material, "Paulo César Tinga", 1);
		Material materialTransferido = criaMaterial("Perecivel 1", "Paulo César Tinga");
		
		assertThat(cd.getQuantidade(material)).isEqualTo(1);
		assertThat(cd.getQuantidade(materialTransferido)).isEqualTo(1);
	}
	
	@Test
	public void deveTransferirMaterialParaOutraCD() {
		CentralDistribuicao matriz = new CentralDistribuicao("Matriz");
		Material materialDaMatriz = criaMaterial("Material da Matriz", "Sérgio");
		
		matriz.inclui(materialDaMatriz, 1);
		assertThat(matriz.getQuantidade(materialDaMatriz)).isEqualTo(1);
		
		CentralDistribuicao filial = new CentralDistribuicao("Filial 1");
		matriz.transfere(materialDaMatriz, filial, "Artur", 1);
		
		Material materialDaFilial = criaMaterial("Material da Matriz", "Artur");		
		assertThat(matriz.getQuantidade(materialDaMatriz)).isEqualTo(0);
		assertThat(filial.getQuantidade(materialDaFilial)).isEqualTo(1);
	}
	
	@Test
	(expected=MaterialInexistenteException.class)
	public void deveDarErroAoBaixarMaterialDaFilialSemEstoque() throws MaterialInexistenteException {
		CentralDistribuicao filial = new CentralDistribuicao("Filial 2");
		
		Material material = criaMaterial("Balde de tinta", "Antonio da Costaneira");
		
		filial.baixa(material);
	}
	
	@Test
	(expected=MaterialInexistenteException.class)
	public void deveDarErroAoTentarBaixarMaterialDuasVezes() throws MaterialInexistenteException {
		CentralDistribuicao filial = new CentralDistribuicao("Filial 2");
		
		Material material = criaMaterial("Balde de tinta", "Antonio da Costaneira");
		
		try {
			filial.baixa(material);
		} catch (MaterialInexistenteException e) {
			// TODO Auto-generated catch block
			System.out.print("Ocorreu um erro esperado!");
		}
		filial.baixa(material);
	}

	
	private Material criaMaterial(String nome, String responsavel) {
		Material material = new Material();
		material.setNome(nome);
		material.setResponsavel(new Responsavel(responsavel));
		
		return material;
	}

}
