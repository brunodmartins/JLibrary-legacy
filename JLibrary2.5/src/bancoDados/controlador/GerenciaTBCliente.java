package bancoDados.controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bancoDados.conexaoBD.Conexao;
import entidades.Cliente;

public class GerenciaTBCliente extends ValidacoesBancoDados implements CRUD {

	@Override
	public void create() {
		Conexao con = new Conexao();
		try {
		Connection conexao = con.conecta(); 
		con.setComando(conexao.createStatement());
		con.setSQL("create table TB_Cliente ("
				+ "ID int NOT NULL AUTO_INCREMENT,"
				+ "Nome char(30),"
				+ "Telefone int(7),"
				+ "Celular int(7),"
				+ "Email char(30),"
				+ "PRIMARY KEY (ID)"
				+ ")"
				);
		
		con.getComando().executeUpdate(con.getSql());
		System.out.println("Tabela TB_Cliente foi criada!");
		} catch(SQLException e) {
			System.out.println(con.erro);
			e.getMessage();
		}

		
	}

	/**
	 * Insere clientes no banco de dados
	 * 
	 * @param cliente
	 *            Cliente a ser gravado
	 * 
	 * @return True, se sucesso;False, se falha
	 * @since 26/12/2013
	 * @version 22/03/2014
	 * 
	 */
	@Override
	public boolean insert(Object e) {
		Cliente cliente = (Cliente) e;
		Conexao con = new Conexao();
		int registro=0;
		try {
			Connection conexao = con.conecta();
			con.setComando(conexao.createStatement());
			con.setSQL("INSERT INTO TB_Cliente VALUES("
					+ "null,'"
					+ cliente.getNome()+"',"
					+ cliente.getTelefone()+","
					+ cliente.getCelular() + ",'"
					+ cliente.getEmail() +"')");
			registro = con.getComando().executeUpdate(con.getSql());
			System.out.println("Cliente adicionado com sucesso!");
		} catch(SQLException e1) {
			System.out.println(con.erro);
			System.out.println(e1.getMessage());
		}
		if(registro!=0)
			return true;
		return false;
		
		

	}

	@Override
	public void delete(Object e) {
		// TODO Auto-generated method stub

	}

	
	/**
	 * Forma uma lista com os dados dos Clientes
	 * 
	 * @param lista
	 *            lista vazia
	 * @return Lista carregada
	 * 
	 * @since 26/12/2013
	 * @version 23/03/2014
	 * @author Bruno
	 * 
	 **/
	public List<Cliente> carregaDados(List<Cliente> lista, String sql) {
		Conexao con = new Conexao();
		try {
			Connection conexao =  con.conecta();
			con.setComando(conexao.createStatement());
			con.setSQL(sql);
			con.setRegistro(con.getComando().executeQuery(con.getSql()));
			
			while(con.getRegistro().next()) {
				Cliente dados = new Cliente();
				dados.setCodigo(con.getRegistro().getInt(1));
				dados.setNome(con.getRegistro().getString(2));
				dados.setTelefone(con.getRegistro().getInt(3));
				dados.setCelular(con.getRegistro().getInt(4));
				dados.setEmail(con.getRegistro().getString(5));
				dados.setAlugueis(con.getRegistro().getInt(6));
				lista.add(dados);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return lista;

	}

	/**
	 * Gera um comBox com os dados dos clientes
	 * 
	 * @author Bruno
	 * @since 29/03/2014
	 * @return comboBox
	 */
	public String[] comboBoxCliente() {
        ArrayList<Cliente> arrayCliente = new ArrayList<Cliente>();
        Cliente cliente = new Cliente();
        Conexao con = new Conexao();
        try {
       	 Connection conexao = con.conecta();
       	 con.setComando(conexao.createStatement());
       	 con.setSQL("SELECT Nome from TB_Cliente");
       	 con.setRegistro(con.getComando().executeQuery(con.getSql()));
       	 while(con.getRegistro().next()) {
       		 cliente.setNome(con.getRegistro().getString(1));
       		 arrayCliente.add(cliente);        		 
       	 }
       	 
       	 
        } catch(SQLException e) {
       	 System.out.println(con.erro);
       	 System.out.println(e.getMessage());
        }
        String[] vCliente = arrayCliente.toArray( new String[arrayCliente.size()]);
        return vCliente;
    }


}
