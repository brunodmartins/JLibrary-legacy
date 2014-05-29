package bancoDados.controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bancoDados.conexaoBD.Conexao;
import entidades.Livro;

public class GerenciaTBLivro extends ValidacoesBancoDados implements CRUD{

	@Override
	public void create() {
		Conexao con = new Conexao();
		try {
		Connection conexao = con.conecta(); 
		con.setComando(conexao.createStatement());
		con.setSQL("create table TB_Livro ("
				+ "ID int NOT NULL AUTO_INCREMENT,"
				+ "Livro char(30),"
				+ "Autor char(30),"
				+ "Genero char(30),"
				+ "Editora char(30),"
				+ "Quantidade int,"
				+ "Alugados int,"
				+ "PRIMARY KEY (ID)"
				+ ")"
				);
		
		con.getComando().executeUpdate(con.getSql());
		System.out.println("Tabela TB_Livro foi criada!");
		} catch(SQLException e) {
			System.out.println(con.erro);
			e.getMessage();
		}	
	}
		
	 /**
     * Insere livros no banco de dados
     * @param livro Livro a ser inserido
     *
     * @return True, se sucesso, False, se falha
     * @since 12/11/2013
     * @version 23/03/2014
     */
	@Override
	public boolean insert(Object e) {
		Livro livro = (Livro) e;
		Conexao con = new Conexao();
		int registro = 0;
		try {
	        	Connection conexao = con.conecta();
	        	con.setComando(conexao.createStatement());
	        	con.setSQL("INSERT INTO TB_Livro(Livro, Autor,Genero, Editora,Quantidade) "
	        	+ " VALUES ('" + livro.getLivro() + "','" + livro.getAutor() + "','" + livro.getGenero() + "','" + livro.getEditora() + "'," + livro.getQuantidade() + ")");
	        	registro = con.getComando().executeUpdate(con.getSql());      
	        } catch (SQLException e1) {            
	            System.out.println(con.erro);
	        	System.out.println(e1.getMessage());
	        }
		 if (registro != 0)
             return true;
         return false;
         }
	
	
	 /**
     * Forma uma lista com os Dados dos livros
     * 
     * @param lista Lista vazia
     * @return Lista carregada
     * 
     * @since 26/12/2013
     */
     public List<Livro> carregaDados(List<Livro> lista, String sql) {
        Conexao con = new Conexao();
        try {
        	Connection conexao = con.conecta();
        	con.setComando(conexao.createStatement());
        	con.setSQL(sql);
        	con.setRegistro(con.getComando().executeQuery(con.getSql()));            
           
        	while (con.getRegistro().next()) {                
                Livro dados = new Livro();
                dados.setCodigo(con.getRegistro().getInt(1));
                dados.setLivro(con.getRegistro().getString(2));
                dados.setAutor(con.getRegistro().getString(3));
                dados.setGenero(con.getRegistro().getString(4));
                dados.setEditora(con.getRegistro().getString(5));
                dados.setQuantidade(con.getRegistro().getInt(6));
                dados.setAlugados(con.getRegistro().getInt(7));
                lista.add(dados);                
            }
        } catch (SQLException ex) {
        	System.out.println(con.erro);
            System.out.println(ex.getMessage());
        }
        return lista;

    }
	
     public String[] comboBoxLivro() {
         ArrayList<Livro> arrayLivro = new ArrayList<Livro>();
         Conexao con = new Conexao();
         try {
        	 Connection conexao = con.conecta();
        	 con.setComando(conexao.createStatement());
        	 con.setSQL("SELECT TB_Livro.ID, TB_Livro.Livro, TB_Livro.Quantidade, TB_Livro.Alugados\n"
                 + "FROM TB_Livro\n"
                 + "WHERE (((TB_livro.[Quantidade])<>(TB_Livro.[Alugados]))\n"
                 + "ORDER BY TB_Livro.Livro;");
        	 con.setRegistro(con.getComando().executeQuery(con.getSql()));
        	 
        	 while(con.getRegistro().next()) {
        		 Livro livro = new Livro();
        		 livro.setID(con.getRegistro().getInt(1));
        		 livro.setLivro(con.getRegistro().getString(2));
        		 livro.setAutor(con.getRegistro().getString(3));
        		 livro.setGenero(con.getRegistro().getString(4));
        		 livro.setEditora(con.getRegistro().getString(5));
        		 livro.setQuantidade(con.getRegistro().getInt(6));
        		 livro.setAlugados(con.getRegistro().getInt(7));
        		 arrayLivro.add(livro);        		 
        	 }
        	 
        	 
         } catch(SQLException e) {
        	 System.out.println(con.erro);
        	 System.out.println(e.getMessage());
         }
         String[] vLivro = arrayLivro.toArray( new String[arrayLivro.size()]);
         return vLivro;
     }
     
	@Override
	public void delete(Object e) {
		// TODO Auto-generated method stub
		
	}

}
