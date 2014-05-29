package tabelas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Cliente;

/**
 * @author Bruno Damasceno Martins
 * @since 26/12/2013
 */

public class ClienteTableModel extends AbstractTableModel {

   private static final long serialVersionUID = 1L;

	private List<Cliente> linhas;

    public ClienteTableModel() {
        linhas = new ArrayList<>();
    }

    public ClienteTableModel(List<Cliente> listaDeClientes) {
        linhas = new ArrayList<>(listaDeClientes);
    }

    private String[] colunas = new String[]{
        "Codigo", "Nome", "Telefone", "Celular","Email","Alugueis"
    };

    private static final int CODIGO = 0;
    private static final int NOME = 1;
    private static final int TELEFONE = 2;
    private static final int CELULAR = 3;
    private static final int EMAIL = 4;
    private static final int ALUGUEIS = 5;

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
            case NOME:
                return String.class;
            case TELEFONE:
                return int.class;
            case CELULAR:
                return int.class;
            case EMAIL:
                return String.class;
            case ALUGUEIS:
                return int.class;
            default:
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

        Cliente dadosCliente = linhas.get(rowIndex);
        switch (columnIndex) {
            case CODIGO:
                return dadosCliente.getCodigo();
            case NOME:
                return dadosCliente.getNome();
            case TELEFONE:
                return dadosCliente.getTelefone();
            case CELULAR:
                return dadosCliente.getCelular();
            case EMAIL:
                return dadosCliente.getEmail();
            case ALUGUEIS:
                return dadosCliente.getAlugueis();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        Cliente dadosCliente = linhas.get(rowIndex);
        switch (columnIndex) {
            case CODIGO:
                dadosCliente.setCodigo((int) aValue);
                break;
            case NOME:
                dadosCliente.setNome((String) aValue);
                break;
            case TELEFONE:
                dadosCliente.setTelefone((int) aValue);
                break;
            case CELULAR:
                dadosCliente.setCelular((int) aValue);
                break;
            case EMAIL:
                dadosCliente.setEmail((String) aValue);
            case ALUGUEIS:
                dadosCliente.setAlugueis((int) aValue);
                break;
            default:
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
