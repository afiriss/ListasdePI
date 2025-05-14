package controllers;

import java.util.List;

import models.Postagem;
import play.mvc.Controller;

public class Postagens extends Controller{

	public static void form() {
		render();
	}
	public static void listar() {
		List <Postagem> postagens = Postagem.findAll();
		render(postagens);
	}
	
	public static void salvar (Postagem p) {
		if (p.titulo != null) {
			p.titulo = p.titulo.toUpperCase();		
		}
		if (p.conteudo != null) {
			p.conteudo = p.conteudo.toLowerCase();
		}		
		
		if (p.autor != null) {
			p.autor = p.autor.toLowerCase();
		}
		p.save();
		listar();
	}
	public static void remover(Long id) {
		Postagem postagem = Postagem.findById(id);
		postagem.delete();
		listar();
	}
}
