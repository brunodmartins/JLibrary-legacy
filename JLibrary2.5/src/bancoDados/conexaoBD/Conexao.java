package bancoDados.conexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * @author Bruno Damasceno Martins
 * @since 11/11/2013
 */
public class Conexao {

	Connection conexao;
	public final String erro = "---------------ERRO---------------";
	private String sql;
	private String status = "";
	private Statement comando;
	private ResultSet registro;
	private PreparedStatement comandoSQL;
	
	public Conexao() {
		
	}

	public void setSQL(String sql) {
		this.sql = sql;
	}
	
	public String getSql() {
		return sql;
	}

	public Statement getComando() {
		return comando;
	}

	public void setComando(Statement comando) {
		this.comando = comando;
	}

	public ResultSet getRegistro() {
		return registro;
	}

	public void setRegistro(ResultSet registro) {
		this.registro = registro;
	}

	public PreparedStatement getComandoSQL() {
		return comandoSQL;
	}

	public void setComandoSQL(PreparedStatement comandoSQL) {
		this.comandoSQL = comandoSQL;
	}

	/**
	 * Conexao com o Banco de Dados
	 * 
	 * @since 11/11/2013
	 * @version 22/03/2014
	 * @author Bruno
	 */
	public  Connection conecta() {
		Connection com = null;

		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String servidor = "sql5c75a.carrierzone.com";
			String bancoDados = "Biblioteca_migresccom102735";
			String url = "jdbc:mysql://" + servidor + "/" + bancoDados;
			String usuario = "migresccom102735";
			String senha = "122412ab";
			
			com = DriverManager.getConnection(url, usuario, senha);
			

			if (com != null) {
				status = ("STATUS--->Conectado com sucesso!");
			} else {
				status = ("STATUS--->Não foi possivel realizar conexão");
			}

			System.out.println(status);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return com;
	}

	/**
	 * Encerra a conexão com o banco de dados
	 * @param com Conexão ativa
	 * @return true, se fechado, false, se não.
	 * @since 22/03/2014
	 * @author Bruno
	 */
	protected static boolean FecharConexao(Connection com) {
        try {
            com.close();
            return true;
        } catch (SQLException e) {
            return false;
        }

 

    }
	
	
}
