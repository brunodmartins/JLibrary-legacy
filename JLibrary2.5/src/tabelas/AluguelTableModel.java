package tabelas;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Aluguel;

/**
 * @author Bruno Damasceno Martins
 * @since 26/12/2013
 */

public class AluguelTableModel extends AbstractTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Lista de alugueis a serem exibidos na tela
    private List<Aluguel> linhas;

    //Cria um AluguelTableModel sem nenhuma linha
    public AluguelTableModel() {
        linhas = new ArrayList<Aluguel>();
    }

    //Cria um SocioTableModel contendo a lista recebida por parâmetro
    public AluguelTableModel(List<Aluguel> listaDeAlugueis) {
        linhas = new ArrayList<Aluguel>(listaDeAlugueis);
    }

    //Array com os nomes das colunas
    private String[] colunas = new String[]{"Codigo", "Livro", "Cliente",
        "Retirada", "Devolução"};

    //Constantes representando o índice das colunas
    private static final int CODIGO = 0;
    private static final int LIVRO = 1;
    private static final int CLIENTE = 2;
    private static final int RETIRADA = 3;
    private static final int DEVOLUCAO = 4;

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
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case CODIGO:
                return int.class;
            case LIVRO:
                return String.class;
            case CLIENTE:
                return String.class;
            case RETIRADA:
                return String.class;
            case DEVOLUCAO:
                return String.class;
            default:
                // Não deve ocorrer, pois só existem 5 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // apenas o campo "ATIVO" será editável
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Pega o sócio referente a linha especificada.
        Aluguel dadosAluguel = linhas.get(rowIndex);
        switch (columnIndex) {
            case CODIGO:
                return dadosAluguel.getID();
            case LIVRO:
                return dadosAluguel.getLivro();
            case CLIENTE:
                return dadosAluguel.getCliente();
            case RETIRADA:
                return dadosAluguel.getRetirada();
            case DEVOLUCAO:
                return dadosAluguel.getDevolucao();
            default:
                // Não deve ocorrer, pois só existem 5 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Pega o sócio referente a linha especificada.
        Aluguel aluguel = linhas.get(rowIndex);
        switch (columnIndex) {
            case CODIGO:
                aluguel.setID((int) aValue);
                break;
            case LIVRO:
                aluguel.setLivro((String) aValue);
                break;
            case CLIENTE:
                aluguel.setCliente((String) aValue);
                break;
            case RETIRADA:
                aluguel.setRetirada((Date) aValue);
                break;
            case DEVOLUCAO:
                aluguel.setDevolucao((Date) aValue);
                break;
            default:
                // Não deve ocorrer, pois só existem 2 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
    }
  
    public void removeAluguel(int indiceLinha) {
        // Remove o registro.
        linhas.remove(indiceLinha);

        //Notifica a mudança.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
}
