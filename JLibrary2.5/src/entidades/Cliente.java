package entidades;

/**
 * 
 * @author Bruno Damasceno Martins
 * @version 07/02/2014
 */
public class Cliente {
	
	private int alugueis;

	private int celular;

	private int codigo;
	private String email;
	private String nome;
	private int telefone;
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	public Cliente(String nome, int telefone, int celular,
			String email) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
	}

	public int getAlugueis() {
		return alugueis;
	}

	public int getCelular() {
		return celular;
	}

	public int getCodigo(){
		return codigo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getNome() {
		return nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setAlugueis(int alugueis) {
		this.alugueis = alugueis;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public void setCodigo(int codigo){
		this.codigo = codigo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

}
