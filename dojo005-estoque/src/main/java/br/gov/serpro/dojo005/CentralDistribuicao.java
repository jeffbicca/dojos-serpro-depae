package br.gov.serpro.dojo005;

import java.util.HashMap;
import java.util.Map;

public class CentralDistribuicao {

	private final Map<Material, Integer> materiais;
	private String nome;

	public CentralDistribuicao() {
		materiais = new HashMap<Material, Integer>();
	}

	public CentralDistribuicao(String nome) {
		this();
		this.nome = nome;
	}

	public void inclui(Material material) {
		if (!materiais.containsKey(material)) {
			materiais.put(material, 1);
			return;
		}
		materiais.put(material, materiais.get(material) + 1);
	}

	public void inclui(Material material, int quantidade) {
		for (int i = 0; i < quantidade; i++) {
			inclui(material);
		}
	}

	public void baixa(Material material) throws MaterialInexistenteException {
		
		if (materiais.remove(material) == null) {
			throw new MaterialInexistenteException();
		}
	}

	public Integer getQuantidade(Material material) {
		return materiais.get(material) != null ? materiais.get(material) : 0;
	}

	public void transfere(Material material, String nomeResponsavel,
			int quantidade) {
		baixaEstoquePessoal(material, quantidade);
		inclui(new Material(material.getNome(),
				new Responsavel(nomeResponsavel)), quantidade);
	}

	private void baixaEstoquePessoal(Material material, int quantidade) {
		Integer quantidadeAtualMaterial = getQuantidade(material);
		if (quantidadeAtualMaterial > 0
				&& quantidade <= quantidadeAtualMaterial)
			materiais.put(material, quantidadeAtualMaterial - quantidade);
	}

	public void transfere(Material materialDaMatriz,
			CentralDistribuicao filial, String nomeResponsavel, int quantidade) {
		baixaEstoquePessoal(materialDaMatriz, quantidade);
		filial.inclui(new Material(materialDaMatriz.getNome(), new Responsavel(
				nomeResponsavel)), quantidade);
	}

}
