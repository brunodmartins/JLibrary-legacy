package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import bancoDados.controlador.GerenciaTBCliente;
import entidades.Cliente;


public class GerenciaCliente extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pane;
    private JTable tblCliente;
    private JButton bSair;
    private JButton bAlterar;
    private JScrollPane tabela;
    private tabelas.ClienteTableModel tableModel;

    public GerenciaCliente() {
        super("Gerencia Cliente");
        initialize();

    }

    private void initialize() {
        bSair = new JButton("Sair");
        bAlterar = new JButton("Alterar campo");
        tabela = new JScrollPane(getTblCliente());

        this.setSize(800, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pane = (JPanel) this.getContentPane();
        pane.setLayout(null);

        pane.add(tabela);
        tabela.setBounds(10, 10, 760, 200);

        pane.add(bAlterar);
        bAlterar.setBounds(10, 220, 130, 30);
        

        pane.add(bSair);
        bSair.setBounds(bAlterar.getWidth() + 20, 220, 60, 30);
        bSair.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        });
    }

    private JTable getTblCliente() {
        if (tblCliente == null) {
            tblCliente = new JTable();
            tblCliente.setModel(getTableModel());
        }
        return tblCliente;
    }

    private tabelas.ClienteTableModel getTableModel() {
        if (tableModel == null) {
            tableModel = new tabelas.ClienteTableModel(criaClientes());
        }
        return tableModel;
    }

    private List<Cliente> criaClientes() {
        List<Cliente> lista = new ArrayList<Cliente>();
        String sql = "SELECT * FROM TB_Cliente;";
        GerenciaTBCliente gerencia = new GerenciaTBCliente();
        lista = gerencia.carregaDados(lista, sql);
        return lista;
    }

    private void sair() {
        this.dispose();
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GerenciaCliente().setVisible(true);
            }
        });
    }

}
