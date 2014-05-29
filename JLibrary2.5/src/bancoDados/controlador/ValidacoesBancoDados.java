package bancoDados.controlador;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JTextField;

import bancoDados.conexaoBD.Conexao;


public abstract class ValidacoesBancoDados {
	
	/**
	 * Valida a existência de um dado duplicado no banco de dados
	 * 
	 * @param busca
	 *            Dado a ser buscado
	 * @param tabela
	 *            Tabela onde o dado será buscado
	 * @param campo
	 *            Campo onde o dado será buscado
	 * @return Verdadeiro se o dado é novo ou Falso se é duplicado
	 * 
	 * @since 16/11/2013
	 * @version 23/03/2014
	 */
	public boolean validaCampo(String busca, String tabela,
			String campo) {
		Conexao con = new Conexao();
		try {
			Connection conexao = con.conecta();
			con.setComando(conexao.createStatement());
			con.setSQL("SELECT * FROM " + tabela
					+ " WHERE " + campo + " = '" + busca + "'");
			con.setRegistro(
					con.getComando().executeQuery(con.getSql())
					);
			if(con.getRegistro().next())
				return false;
			return true;
		} catch (SQLException ex) {
			System.out.println(con.erro);
			System.out.println(ex.getMessage());
		}
		return false;
	}

	
	/**
	 * Valida a exitência de números em um texto
	 * 
	 * @param texto
	 *            Texto à ser validado
	 * @return Verdadeiro se o texto possuir letras ou Falso se só possuir
	 *         números ou esta vazio
	 * 
	 * @since 26/12/2013
	 */
	public boolean validaCampo(JTextField campo) {
		String texto = campo.getText();
		if (texto == null) {
			return false;
		}
		for (char letra : texto.toCharArray()) {
			if (letra < '0' || letra > '9') {
				return false;
			}
		}
		return true;

	}

	public String buscaReferencia(int chave, String tabela, String campo) {
		Conexao con = new Conexao();
		try {
			Connection conexao = con.conecta();
			con.setComando(conexao.createStatement());
			con.setSQL("select " + campo + " from " + tabela + " where ID=" + chave);
			con.setRegistro(con.getComando().executeQuery(con.getSql()));
			
			if(con.getRegistro().next())
				return con.getRegistro().getString(1);
			
		} catch (SQLException e){
			System.out.println(con.erro);
			System.out.println(e.getMessage());
		}
		
		return null;
	}

}
