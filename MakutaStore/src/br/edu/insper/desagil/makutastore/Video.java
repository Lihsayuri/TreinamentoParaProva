package br.edu.insper.desagil.makutastore;

import java.util.HashMap;
import java.util.Map;

public class Video {
	private Integer id;
	private Usuario usuario;
	private Produto produto;
	private Map<String, Integer> avaliacoes;
	
	public Video(Integer id, Usuario usuario, Produto produto) {
		this.id = id;
		this.usuario = usuario;
		this.produto = produto;
		this.avaliacoes = new HashMap<>();
	}

	public Integer getId() {
		return id;
	}

	public Produto getProduto() {
		return produto;
	}
	
	public void adicionaAvaliacao(Usuario usuario, int avaliacao) {
		if (!usuario.getNome().equals(this.usuario.getNome()) && avaliacao >= 1 && avaliacao <= 5) {
			this.avaliacoes.put(usuario.getNome(), avaliacao);
		}
	}
	
	public int mediaAvaliacoes() {
		double soma = 0;
		for (int avaliacao : this.avaliacoes.values()) {
			soma+= avaliacao;
		} return ((int) Math.round((soma)/this.avaliacoes.size()));
	}
	
	
}
