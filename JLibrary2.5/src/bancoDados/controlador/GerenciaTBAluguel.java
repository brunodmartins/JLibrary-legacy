package bancoDados.controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import bancoDados.conexaoBD.Conexao;
import entidades.Aluguel;

public class GerenciaTBAluguel extends ValidacoesBancoDados implements CRUD{

	@Override
	public void create() {
		Conexao con = new Conexao();
		try {
			Connection conexao = con.conecta();
			con.setComando(conexao.createStatement());
			con.setSQL("create table TB_Aluguel ("
					+ "ID int NOT NULL AUTO_INCREMENT,"
					+ "ID_Livro int,"
					+ "ID_Cliente int,"
					+ "Retirada date,"
					+ "Devolucao date,"
					+ "PRIMARY KEY(ID)"
					+ ")"
					);
			con.getComando().executeUpdate(con.getSql());
			System.out.println("Tabela TB_Aluguel criada com sucesso");
		} catch(SQLException e) {
			System.out.println(con.erro);
			e.getMessage();
		}
		
	}

	/**
     * Insere o alguel no banco de dados
     *
     * @param livro Código do livro alugado
     * @param cliente Código do cliente que alugou
     * @param aluguel Aluguel feito
     * @since 26/12/2013
     * @version 29/03/2014
     */
	public boolean insert(Object e) {
		Aluguel alu = (Aluguel) e; 
		Conexao con = new Conexao();
		int registro;
	        try {
	        	Connection conexao= con.conecta();
	        	con.setComando(conexao.createStatement());
	        	con.setSQL("INSERT INTO TB_Aluguel(ID_Livro, ID_Cliente, Retirada, Devolucao) "
	        			+ "VALUES ("
		 + "(select ID from TB_Livro where Livro = '" + alu.getLivro() + "',),"
		 + "(select ID from TB_Cliente where Nome = " + alu.getCliente() + "'),"
		 + "('" + alu.getRetirada() + "','" + alu.getDevolucao() + "')");
	            registro = con.getComando().executeUpdate(con.getSql());
	            if(registro != 0)
	            	return true;
	        } catch (Exception error) {
	            error.printStackTrace();
	        }
			return false;
	    }
		

	 /**
     * Procedimento para deletar registro de aluguel no banco de dados
     *
     * @param codigo Codigo do registro a ser deletado
     * 
     * @since 26/12/2013
     */
	@Override
	public void delete(Object e) {
		int codigo =  (int) e;
	    Conexao con = new Conexao();
	    int registro = 0;
	    
	        try {
	        	Connection conexao = con.conecta();
	        	con.setComando(conexao.createStatement());
	        	con.setSQL("DELETE FROM TB_Aluguel WHERE ID=" + codigo + ";");
	        	registro = con.getComando().executeUpdate(con.getSql());
	        } catch (SQLException e1) {
	            System.out.println(con.erro);
	            System.out.println(e1.getMessage());
	        }
	        
	        if (registro != 0) {
                JOptionPane.showMessageDialog(null, "Encerrado com sucesso", "O aluguel foi encerrado com sucesso", JOptionPane.INFORMATION_MESSAGE, GUI.Icones.check);
            } else {
                JOptionPane.showMessageDialog(null, "Falha no encerramento", "O aluguel não foi encerrado", JOptionPane.INFORMATION_MESSAGE, GUI.Icones.error);
            }
		
	}

    /**
     * Carrega dados para a tabela de algueis
     *
     * @param lista Lista à ser carregada
     * @return
     * 
     * @since 26/12/2013
     * @version 29/03/2013
     */
    public List<Aluguel> carregaDados(List<Aluguel> lista) {
        Conexao con = new Conexao();
        Aluguel dados = new Aluguel();
	
        try {
        	Connection conexao = con.conecta();
        	con.setComando(conexao.createStatement());
        	con.setSQL("SELECT * FROM TB_Aluguel;");
        	con.getComando().executeQuery(con.getSql());
        	con.setRegistro(con.getComando().executeQuery(con.getSql()));
        	while(con.getRegistro().next()) {
        		dados.setID(con.getRegistro().getInt(1));
        		dados.setLivro(buscaReferencia(con.getRegistro().getInt(2), "TB_Livro", "Livro"));
        		dados.setCliente(buscaReferencia(con.getRegistro().getInt(3), "TB_Cliente", "Nome"));
        		dados.setRetirada(con.getRegistro().getDate(4));
        		dados.setDevolucao(con.getRegistro().getDate(5));
        		lista.add(dados);		
        	}
        	return lista;        	
        } catch (SQLException e) {
        	System.out.println(con.erro);
        	System.out.println(e.getMessage());
        } catch (NullPointerException e) {
        	System.out.println(con.erro);
        	System.out.println(e.getMessage());
        }
       
        return null;

    }

}
