package controlador;

import java.sql.Date;

import javax.swing.JOptionPane;

import bancoDados.controlador.GerenciaTBAluguel;
import bancoDados.controlador.GerenciaTBCliente;
import bancoDados.controlador.GerenciaTBLivro;
import entidades.Aluguel;

public class ControladorCadastroAluguel extends bancoDados.conexaoBD.Conexao {

	/**
	 * Gera os itens do comboBox cbLivros
	 * 
	 * @return Vetor com os itens
	 */
	public String[] comboBoxLivro() {
		GerenciaTBLivro gerencia = new GerenciaTBLivro();
		return gerencia.comboBoxLivro();
	}

	/**
	 * Gera os itens do comboBox cbClientes
	 * 
	 * @return Vetor com os itens
	 */
	public String[] comboBoxCliente() {
		GerenciaTBCliente gerencia = new GerenciaTBCliente();
		return gerencia.comboBoxCliente();
	}

	/**
	 * Prepara métodos para registrar um aluguel
	 * 
	 * @param livro
	 *            Aluguel feito
	 * @param cliente
	 *            TODO
	 * @param devolucao
	 *            TODO
	 * @param retirada
	 *            TODO
	 * 
	 * @since 26/12/2013
	 * @version 29/03/2014
	 */
	public void controlaAluguel(String livro, String cliente, String retirada,
			String devolucao) {
		Aluguel alu = new Aluguel();
		alu.setLivro(livro);
		alu.setCliente(cliente);
		alu.setRetirada(Date.valueOf(retirada));
		alu.setDevolucao(Date.valueOf(devolucao));
		GerenciaTBAluguel gerencia = new GerenciaTBAluguel();
		if (gerencia.insert(alu)) {
			JOptionPane.showMessageDialog(null, "Aluguel cadastrado com sucesso!",
					"Cadastrado com sucesso", 0, GUI.Icones.check);
		} else {
			JOptionPane.showMessageDialog(null, "Erro no cadastro do aluguel!!",
					"Cadastrado não efetuado", 0, GUI.Icones.error);
		}
	}
}
