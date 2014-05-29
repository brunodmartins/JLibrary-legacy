package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import bancoDados.controlador.GerenciaTBAluguel;
import entidades.Aluguel;

public class GerenciaAluguel extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tblAluguel;
    private JButton bEncerrar;
    private JButton bAlterarDado;
    private JButton bSair;
    private tabelas.AluguelTableModel tableModel;
    private JPanel pane;
    private JScrollPane tabela;

    public GerenciaAluguel() {
        super("Gerencia Aluguel");
        initialize();
    }

    private void initialize() {
        bEncerrar = new JButton("Encerrar Aluguel");
        bAlterarDado = new JButton("Alterar Dado");
        bSair = new JButton("Sair");
        tabela = new JScrollPane(getTblAluguel());

        this.setSize(800, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pane = (JPanel) this.getContentPane();
        pane.setLayout(null);

        pane.add(tabela);
        tabela.setBounds(10, 10, 760, 200);

        pane.add(bEncerrar);
        bEncerrar.setBounds(10, 220, 130, 30);
        bEncerrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigo;
                    codigo = (Integer) tblAluguel.getValueAt(tblAluguel.getSelectedRow(), 0);
                    System.out.println(codigo);
                    if (JOptionPane.showConfirmDialog(rootPane, "Deseja realmente deletar o registro " + codigo + "?") == 0) {
                    	GerenciaTBAluguel gerenciador = new GerenciaTBAluguel();
                        gerenciador.delete(codigo);
                    } else {
                        JOptionPane.showMessageDialog(null, "Falha no encerramento", "O aluguel não foi encerrado", JOptionPane.INFORMATION_MESSAGE, GUI.Icones.error);
                    }

                } catch (ArrayIndexOutOfBoundsException error) {
                    JOptionPane.showMessageDialog(rootPane, "Nenhum registro foi selecionado na tabela", "Erro", JOptionPane.ERROR_MESSAGE, GUI.Icones.error);
                }
            }
        });

        pane.add(bAlterarDado);
        bAlterarDado.setBounds(bEncerrar.getWidth() + 20, 220, 120, 30);

        pane.add(bSair);
        bSair.setBounds(bAlterarDado.getWidth() + bEncerrar.getWidth() + 30, 220, 60, 30);
        bSair.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        });

    }

    private JTable getTblAluguel() {
        if (tblAluguel == null) {
            tblAluguel = new JTable();
            tblAluguel.setModel(getTableModel());
        }
        return tblAluguel;
    }

    private tabelas.AluguelTableModel getTableModel() {
        if (tableModel == null) {
            tableModel = new tabelas.AluguelTableModel(criaAlugueis());
        }
        return tableModel;
    }

    private List<Aluguel> criaAlugueis() {
        List<Aluguel> lista = new ArrayList<Aluguel>();
        GerenciaTBAluguel gerenciador = new GerenciaTBAluguel();
        lista = gerenciador.carregaDados(lista);
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
                new GerenciaAluguel().setVisible(true);
            }
        });
    }

}
