package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class Buscar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton bBuscar;
    private JButton bCancelar;
    private JTextField jPesquisa;
    private JLabel jTexto;
    private JPanel pane;
    private JRadioButton rLivro;
    private JRadioButton rCliente;
    private ButtonGroup grupo;

    public Buscar() {
        super("Buscar");
        initialize();
    }

    private void janela() {
        this.setSize(280, 180);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pane = (JPanel) this.getContentPane();
        pane.setLayout(null);

    }

    private void componentes() {

        //Gerando Objetos
        bBuscar = new JButton("Buscar");
        bCancelar = new JButton("Cancelar");
        jTexto = new JLabel("Digite o nome do item a ser buscado");
        jPesquisa = new JTextField(null);
        rLivro = new JRadioButton("Livro");
        rCliente = new JRadioButton("Cliente");
        grupo = new ButtonGroup();
        grupo.add(rLivro);
        grupo.add(rCliente);

        rLivro.setSelected(true);

        //Adicionando no JPanel
        pane.add(bBuscar);
        pane.add(bCancelar);
        pane.add(jTexto);
        pane.add(jPesquisa);
        pane.add(rLivro);
        pane.add(rCliente);

        //Localização
        jTexto.setBounds(10, 10, 250, 20);
        jPesquisa.setBounds(10, jTexto.getHeight() + 20, 250, 20);
        rLivro.setBounds(10, jPesquisa.getY() + 30, 80, 20);
        rCliente.setBounds(rLivro.getWidth() + 10, jPesquisa.getY() + 30, 80, 20);
        bBuscar.setBounds(10, 100, 120, 30);
        bCancelar.setBounds(bBuscar.getWidth() + 20, 100, 120, 30);

    }

    private void eventos() {
        bBuscar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (jPesquisa.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Digite o nome do livro a ser buscado", "Erro", JOptionPane.ERROR_MESSAGE, GUI.Icones.error);
                } else if (rLivro.isSelected() == true) {
//                   Busca.buscaLivro(jPesquisa.getText());
                } else {
//                    Busca.buscaCliente(jPesquisa.getText());
                }
            }
        });

        bCancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Buscar.this.dispose();
            }
        });
    }

    private void initialize() {
        janela();
        componentes();
        eventos();
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
                new Buscar().setVisible(true);
            }
        });

    }

}
