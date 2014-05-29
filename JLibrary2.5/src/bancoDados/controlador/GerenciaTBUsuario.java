package bancoDados.controlador;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import bancoDados.conexaoBD.Conexao;
import entidades.Usuario;

public class GerenciaTBUsuario extends ValidacoesBancoDados implements CRUD {

	@Override
	public void create() {
		Conexao con = new Conexao();
		try {
			Connection conexao = con.conecta();
			con.setComando(conexao.createStatement());
			con.setSQL("create table TB_Usuario (" + "Nome char(30)," + "Email char(30),"
					+ "Login char(30)," + "Senha char(30)," + "Palavra char(30)" + ")");
			con.getComando().executeUpdate(con.getSql());
			System.out.println("Tabela TB_Usuario criada com sucesso");
		} catch (SQLException e) {
			System.out.println(con.erro);
			e.getMessage();
		}
	}

	@Override
	public boolean insert(Object e) {
		Usuario user = (Usuario) e;
		Conexao con = new Conexao();
		int registro = 0;
		try {
			Connection conexao = con.conecta();
			con.setComando(conexao.createStatement());
			con.setSQL("INSERT INTO TB_Usuario VALUES('" + user.getNome() + "','"
					+ user.getEmail() + "','" + user.getLogin() + "','" + user.getSenha()
					+ "','" + user.getPalavra() + "')");
			registro = con.getComando().executeUpdate(con.getSql());
		} catch (SQLException exception) {
			System.out.println(con.erro);
			System.out.println(exception.getMessage());
		}

		if (registro != 0)
			return true;
		return false;
	}

	@Override
	public void delete(Object e) {
		// TODO Auto-generated method stub
	}

	/**
	 * Busca um cadastro no banco de dados
	 * 
	 * @param login
	 * @param senha
	 * @return True, se existir, ou False, se não existir
	 * @author Bruno
	 * @since 22/03/2014
	 */
	public boolean validaLogin(String login, char senha[]) {
		Conexao con = new Conexao();
		try {
			Connection conexao = con.conecta();
			con.setComando(conexao.createStatement());
			con.setSQL("SELECT login, senha FROM TB_Usuario WHERE login LIKE \'" + login
					+ "\' AND senha LIKE \'" + String.copyValueOf(senha) + "\';");
			con.setRegistro(con.getComando().executeQuery(con.getSql()));
			if (con.getRegistro().next())
				return true;
		} catch (SQLException e) {
			System.out.println(con.erro);
			System.out.println(e.getMessage());
		}
		return false;
	}

	/**
	 * Valida um usuario a ser cadastrado
	 * 
	 * @param nome
	 * @return True, se ele não existir, False, se ele existir
	 * @since 23/03/2014
	 */
	public  boolean validaUsuario(String nome) {
		Conexao con = new Conexao();
		try {
			Connection conexao = con.conecta();
			con.setComando(conexao.createStatement());
			con.setSQL("SELECT Nome FROM TB_Usuario WHERE Login LIKE \'" + nome
				+ "\';");
			con.setRegistro(
					con.getComando().executeQuery(con.getSql())
					);
			if(!con.getRegistro().next())
				return true;
			JOptionPane.showMessageDialog(null, "O usuário " + nome
					+ " já esta cadastrado");
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
