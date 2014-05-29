package entidades;


public class Usuario{
	
	private int ID;
	private String email;
	private String login;
	private String nome;
	private String palavra;
	private String senha;
	
	public Usuario(String nome, String email, String login, String senha,
			String palavra) {
		super();
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.palavra = palavra;
	}
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getEmail() {
		return email;
	}
	public String getLogin() {
		return login;
	}
	public String getNome() {
		return nome;
	}
	public String getPalavra() {
		return palavra;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}


	
}
