package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controlador.ControladorCadastroAluguel;
import entidades.Cliente;
import entidades.Livro;

/**
 * 
 * @author Bruno Damasceno Martins
 * @version 07/02/2014
 */
public class EfetuaAluguel extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JComboBox<Cliente> cbCliente;
	private static JComboBox<Livro> cbLivro;
	private JButton btnEfetuar;
	private JButton btnCancelar;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JTextField jRetirada;
	private JTextField jDevolucao;
	private MaskFormatter retirada;
	private MaskFormatter entrega;

	public EfetuaAluguel() {
		componentes();
		janela();
		eventos();
	}

	private void eventos() {
		btnEfetuar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(validaCampos()){
				String livro;
				String cliente;
				String retirada;
				String devolucao;
				
				livro = (String) cbLivro.getSelectedItem();				
				cliente = (String) cbCliente.getSelectedItem();				
				retirada = jRetirada.getText();
				devolucao = jDevolucao.getText();			
						
				ControladorCadastroAluguel controlador = new ControladorCadastroAluguel();
				
				controlador.controlaAluguel(livro, cliente, retirada, devolucao);
				dispose();
				}

			}
		});

		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}

	private void componentes() {
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jRetirada = new JTextField();
		jDevolucao = new JTextField();
		ControladorCadastroAluguel controlador = new ControladorCadastroAluguel();
		cbLivro = new JComboBox(controlador.comboBoxLivro());
		cbCliente = new JComboBox(controlador.comboBoxCliente());
		controlador = null;
		btnEfetuar = new JButton();
		btnCancelar = new JButton();

		jLabel1.setText("Livro");
		jLabel2.setText("Cliente");
		jLabel3.setText("Data de Retirada");
		jLabel4.setText("Data de Devolução");
		cbCliente.setSelectedItem(null);
		cbLivro.setSelectedItem(null);
		btnEfetuar.setText("Efetuar Aluguel");
		btnCancelar.setText("Cancelar");

		try {
			retirada = new MaskFormatter("##/##/####");
			jRetirada = new JFormattedTextField(retirada);
		} catch (Exception e) {

		}

		try {
			entrega = new MaskFormatter("##/##/####");
			jDevolucao = new JFormattedTextField(entrega);
		} catch (Exception e) {

		}
	}

	private void janela() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
																.addGroup(
																		layout.createSequentialGroup()
																				.addComponent(
																						jLabel2)
																				.addGap(18,
																						18,
																						18)
																				.addComponent(
																						cbCliente,
																						0,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE))
																.addGroup(
																		layout.createSequentialGroup()
																				.addComponent(
																						jLabel1,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						46,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(
																						cbLivro,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						151,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGroup(
																		layout.createSequentialGroup()
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																								.addComponent(
																										jLabel3)
																								.addComponent(
																										jLabel4))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																								.addComponent(
																										jRetirada,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										82,
																										Short.MAX_VALUE)
																								.addComponent(
																										jDevolucao))))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		btnEfetuar)
																.addGap(70, 70,
																		70)
																.addComponent(
																		btnCancelar)))
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														cbLivro,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel1))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel2)
												.addComponent(
														cbCliente,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel3)
												.addComponent(
														jRetirada,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel4)
												.addComponent(
														jDevolucao,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(26, 26, 26)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(btnEfetuar)
												.addComponent(btnCancelar))
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		pack();
		setLocationRelativeTo(null);
	}

	private boolean validaCampos() {
		boolean vazio = false;
		String erros = "Os seguintes campos estão vazios:";

		if (cbLivro.getSelectedItem() == null) {
			erros = erros.concat("-Livro \n");
			vazio = true;
		}

		if (cbCliente.getSelectedItem() == null) {
			erros = erros.concat("-Cliente \n");
			vazio = true;
		}

		if (jDevolucao.getText().equals(entrega)) {
			erros = erros.concat("-Data de Devolução \n");
			vazio = true;
		}

		if (jRetirada.getText().equals(retirada)) {
			erros = erros.concat("-Data de Retirada \n");
			vazio = true;
		}

		if (vazio == true) {
			JOptionPane.showMessageDialog(null, erros);
			return false;
		} else {
			return true;
		}

	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Metal".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(EfetuaAluguel.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(EfetuaAluguel.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(EfetuaAluguel.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(EfetuaAluguel.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new EfetuaAluguel().setVisible(true);
			}
		});
	}

}
