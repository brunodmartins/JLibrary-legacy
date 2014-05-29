package controlador;

import javax.swing.JOptionPane;

import bancoDados.controlador.GerenciaTBCliente;
import entidades.Cliente;

public class ControladorCadastroCliente{

	
	/**
	 * Chama as funções necessárias para a gravação no banco de dados
	 * 
	 * @param nome
	 *            Nome do cliente
	 * @param telefone
	 *            Telefone do cliente
	 * @param celular
	 *            Celular do cliente
	 * @param email
	 *            Email do cliente
	 * 
	 * @return Verdadeiro para sair ou Falso para continuar outra gravação
	 * 
	 * @since 26/12/2013
	 * @version 07/02/2014
	 */
	public boolean controlaCadastro(String nome, int telefone,
			int celular, String email) {
		
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setTelefone(telefone);
		cliente.setCelular(celular);
		cliente.setEmail(email);
		
		GerenciaTBCliente tbCliente = new GerenciaTBCliente(); 
		String Opçoes[] = { "Novo Cadastro", "Sair" };
		int resp = 0;

		if (tbCliente.validaCampo(cliente.getNome(), "TB_Cliente", "Nome")) {
			
			if(tbCliente.insert(cliente)) {
				resp = JOptionPane.showOptionDialog(null,
						"O cliente foi cadastrado com sucesso!",
						"Cadastro com sucesso", 0, 0, GUI.Icones.check, Opçoes, 0);
			}else {
				resp = JOptionPane.showOptionDialog(null, "Falha na gravação!",
						"Cadastro não efetuado", 0, 0, GUI.Icones.error, Opçoes, 0);
			}
			
		} else {
			resp = JOptionPane.showOptionDialog(null,
					"O cliente " + cliente.getNome() + " já esta cadastrado!",
					"Cadastro não efetuado", 0, 0, GUI.Icones.error, Opçoes, 0);
		}

		if (resp == 0)
			return false;
		return true;

	}



}
