package entidades;

import java.sql.Date;


/**
 * @author Bruno Damasceno Martins
 * @since 07/02/2014
 * @version 07/02/2014
 */
public class Aluguel{
	
	private String cliente;
	private int ID;
	private Date devolucao;
	private String livro;
	private Date retirada;
	
	
	public Aluguel() {
		// TODO Auto-generated constructor stub
	}
	
	public Aluguel(String cliente, Date devolucao, String livro, Date retirada) {
		super();
		this.cliente = cliente;
		this.devolucao = devolucao;
		this.livro = livro;
		this.retirada = retirada;
	}
	
	
	public String getCliente() {
		return cliente;
	}


	
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	
	public int getID() {
		return ID;
	}


	
	public void setID(int iD) {
		ID = iD;
	}


	
	public Date getDevolucao() {
		return devolucao;
	}


	
	public void setDevolucao(Date devolucao) {
		this.devolucao = devolucao;
	}


	
	public String getLivro() {
		return livro;
	}


	
	public void setLivro(String livro) {
		this.livro = livro;
	}


	
	public Date getRetirada() {
		return retirada;
	}


	
	public void setRetirada(Date retirada) {
		this.retirada = retirada;
	}    
}
