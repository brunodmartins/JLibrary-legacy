package entidades;
/**
 * @author Bruno Damascneo Martins
 * @since 07/02/2014
 * @version 07/02/2014
 * 
 */
public class Livro{

	private int ID;
	private int alugados;
	private String autor;
	private int codigo;
	private String editora;
	private String genero;
	private String livro;
	private int quantidade;
	
	public Livro(){
		
	}
	
	
	public int getID() {
		return ID;
	}

	
	public void setID(int iD) {
		ID = iD;
	}

	public Livro(String livro, String autor, String genero, String editora,
			int quantidade) {
		super();
		this.livro = livro;
		this.autor = autor;
		this.genero = genero;
		this.editora = editora;
		this.quantidade = quantidade;
	}
	
	public int getAlugados() {
		return alugados;
	}


	public String getAutor() {
		return autor;
	}


	public int getCodigo() {
		return codigo;
	}


	public String getEditora() {
		return editora;
	}


	public String getGenero() {
		return genero;
	}


	public String getLivro() {
		return livro;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setAlugados(int alugados) {
		this.alugados = alugados;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public void setLivro(String livro) {
		this.livro = livro;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	


}
