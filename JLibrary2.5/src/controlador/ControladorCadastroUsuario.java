package controlador;


import javax.swing.JOptionPane;

import bancoDados.controlador.GerenciaTBUsuario;
import entidades.Usuario;

public class ControladorCadastroUsuario{
	
	/**
	 * Controla o cadastro de um novo Usuário
	 * 
	 * @param nome
	 * @param email
	 * @param login
	 * @param senha
	 * @param palavra
	 * @since 22/03/2014
	 * @author Bruno
	 */
	public void controlaUsuario(String nome, String email, String login,
			String senha, String palavra) {
		
		
		Usuario user = new Usuario();
		user.setNome(nome);
		user.setEmail(email);
		user.setLogin(login);
		user.setSenha(senha);
		user.setPalavra(palavra);
		
		GerenciaTBUsuario gerenciaTBUsuario = new GerenciaTBUsuario();
		if(gerenciaTBUsuario.insert(user)) {
			JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!", "Cadastro com sucesso", JOptionPane.DEFAULT_OPTION, GUI.Icones.check);
		} else {
			JOptionPane.showMessageDialog(null, "Falha no cadastro do usuario!", "Falha!", JOptionPane.DEFAULT_OPTION, GUI.Icones.error);
		}
		
		
	}

	/**
	 * Valida um usuário a ser cadastrado
	 * 
	 * @param nome
	 * @return true, se não existir / false, se existir
	 */
	public boolean validaUsuario(String nome) {
		GerenciaTBUsuario gerencia = new GerenciaTBUsuario();
		return gerencia.validaUsuario(nome);
	}


}
