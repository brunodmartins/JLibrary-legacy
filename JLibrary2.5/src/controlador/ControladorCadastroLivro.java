package controlador;

import javax.swing.JOptionPane;

import bancoDados.controlador.GerenciaTBLivro;
import entidades.Livro;

public class ControladorCadastroLivro {

	/**
	 * Chamas as funçõs necessárias para a gravação no banco de dados
	 * 
	 * @param livro
	 * @param autor
	 * @param genero
	 * @param editora
	 * @param quantidade
	 * 
	 * @since 12/11/2013
	 * @version 23/03/2014
	 * @return Verdadeiro para sair ou Falso para continuar outra gravação
	 */
	public boolean controlaLivro(String nome, String autor, String genero,
			String editora, int quantidade) {
		Livro livro = new Livro();
		livro.setLivro(nome);
		livro.setAutor(autor);
		livro.setGenero(genero);
		livro.setEditora(editora);
		livro.setQuantidade(quantidade);
		GerenciaTBLivro gerencia = new GerenciaTBLivro();
		String Opcoes[] = { "Cadastrar outro livro", "Sair" };
		boolean sucesso = false;
		int resp = 0;
		if (gerencia.validaCampo(livro.getLivro(), "TB_Livro", "Livro")) {
			sucesso = gerencia.insert(livro);
			if (sucesso) {
				resp = JOptionPane.showOptionDialog(null,
						"O livro foi cadastrado com sucesso!", "Cadastro com sucesso", 0,
						0, GUI.Icones.check, Opcoes, 0);
			} else {
				resp = JOptionPane.showOptionDialog(null, "Falha na gravação!",
						"Cadastro não efetuado", 0, 0, GUI.Icones.check, Opcoes, 0);
			}
		} else {
			resp = JOptionPane.showOptionDialog(null, "O livro " + livro
					+ " já esta cadastrado!", "Cadastro não efetuado", 0, 0,
					GUI.Icones.error, Opcoes, 0);
		}
		if (resp == 0)
			return false;
		return true;
	}
}
