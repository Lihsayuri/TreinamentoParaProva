package br.edu.insper.desagil.makutastore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AvaliacaoTest {
	private Usuario usuario;
	private Produto produto;
	
	@BeforeEach
	public void setUp() {
		produto = new Produto("BigMac", 10.50);
		usuario = new Usuario("Riquinho");
	}

	@Test
	public void invalido() {
		Usuario usuario1 = new Usuario("Berunarudo");
		Usuario usuario2 = new Usuario("Dantinhas");
		Video video = usuario.postaVideo(0, produto);
		video.adicionaAvaliacao(usuario, 3);
		video.adicionaAvaliacao(usuario1, 0);
		video.adicionaAvaliacao(usuario2, 6);
		assertEquals(0, usuario.totalAvaliacoes());
	}
	
	@Test
	public void avaliarUmVideo() {
		Usuario usuario1 = new Usuario("Berunarudo");
		Video video = usuario.postaVideo(0, produto);
		video.adicionaAvaliacao(usuario1, 3);
		assertEquals(3, usuario.totalAvaliacoes());
	}
	
	@Test
	public void duasAvaliacoesValidasArredondarCima() {
		Usuario usuario1 = new Usuario("Berunarudo");
		Usuario usuario2 = new Usuario("Dantinhas");
		Video video = usuario.postaVideo(0, produto);
		video.adicionaAvaliacao(usuario1, 5);
		video.adicionaAvaliacao(usuario2, 2);
		assertEquals(4, usuario.totalAvaliacoes());
	}
	
	@Test
	public void tresAvaliacoesValidasArredondarBaixo() {
		Usuario usuario1 = new Usuario("Berunarudo");
		Usuario usuario2 = new Usuario("Dantinhas");
		Usuario usuario3 = new Usuario("Henrique"); 
		Video video = usuario.postaVideo(0, produto);
		video.adicionaAvaliacao(usuario1, 5);
		video.adicionaAvaliacao(usuario2, 2);
		video.adicionaAvaliacao(usuario3, 3);
		assertEquals(3, usuario.totalAvaliacoes());
	}
	
	@Test
	public void doisVideosDuasAvaliacoesValidasPraUmEUmaValidaPraOutro() {
		Usuario usuario1 = new Usuario("Berunarudo");
		Usuario usuario2 = new Usuario("Dantinhas");
		
		Usuario usuario3 = new Usuario("Henrique"); 
		Video video1 = usuario.postaVideo(0, produto);
		Video video2 = usuario.postaVideo(1, produto);
		
		video1.adicionaAvaliacao(usuario1, 5);
		video1.adicionaAvaliacao(usuario2, 2);
		video2.adicionaAvaliacao(usuario3, 3);
		assertEquals(7, usuario.totalAvaliacoes());
	}
	

}
