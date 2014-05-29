package tabelas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Livro;

/**
 * @author Bruno Damasceno Martins
 * @since 26/12/2013
 */

public class LivroTableModel extends AbstractTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Livro> linhas;

    public LivroTableModel() {
        linhas = new ArrayList<Livro>();
    }

    public LivroTableModel(List<Livro> listaDeLivros) {
        linhas = new ArrayList<>(listaDeLivros);
    }

    private String[] colunas = new String[]{
        "Código", "Livro", "Autor", "Gênero", "Editora", "Quantidade", "Alugado", "Alugados"
    };

    private final int CODIGO = 0;
    private final int LIVRO = 1;
    private final int AUTOR = 2;
    private final int GENERO = 3;
    private final int EDITORA = 4;
    private final int QUANTIDADE = 5;
    private final int ALUGADO = 6;
    private final int ALUGADOS = 7;

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case CODIGO:
                return int.class;
            case LIVRO:
                return String.class;
            case AUTOR:
                return String.class;
            case GENERO:
                return String.class;
            case EDITORA:
                return String.class;
            case QUANTIDADE:
                return int.class;
            case ALUGADO:
                return Boolean.class;
            case ALUGADOS:
                return int.class;
            default:
                throw new IndexOutOfBoundsException("IndexOutOfBounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Livro dadosLivro = linhas.get(rowIndex);

        switch (columnIndex) {
            case CODIGO:
                return dadosLivro.getCodigo();
            case LIVRO:
                return dadosLivro.getLivro();
            case AUTOR:
                return dadosLivro.getAutor();
            case GENERO:
                return dadosLivro.getGenero();
            case EDITORA:
                return dadosLivro.getEditora();
            case QUANTIDADE:
                return dadosLivro.getQuantidade();
            case ALUGADOS:
                return dadosLivro.getAlugados();
            default:
                throw new IndexOutOfBoundsException("IndexOutOfBounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
       Livro dadosLivro = linhas.get(rowIndex);

        switch (columnIndex) {
            case CODIGO:
                dadosLivro.setCodigo((int) aValue);
            case LIVRO:
                dadosLivro.setLivro((String) aValue);
            case AUTOR:
                dadosLivro.setAutor((String) aValue);
            case GENERO:
                dadosLivro.setGenero((String) aValue);
            case EDITORA:
                dadosLivro.setEditora((String) aValue);
            case QUANTIDADE:
                dadosLivro.setQuantidade((int) aValue);
            case ALUGADOS:
                dadosLivro.setAlugados((int) aValue);
            default:
                throw new IndexOutOfBoundsException("IndexOutOfBounds");
        }
    }

    public void removeAluguel(int indiceLinha) {
        // Remove o registro.
        linhas.remove(indiceLinha);

        //Notifica a mudança.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

}
