package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.ControladorCadastroLivro;

/**
 * @author Bruno Damasceno Martins
 * @since 12/11/2013
 * @version 07/02/2014
 */
public class FormularioLivro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JTextField tfAutor;
	private JTextField tfEditora;
	private JTextField tfGenero;
	private JTextField tfLivro;
	private JTextField tfQuantidade;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;

	public FormularioLivro() {
		componentes();
		janela();
		eventos();
	}

	private void eventos() {
    	btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validaCampos() == true){
					 String livro, autor, genero, editora;
				     int quantidade;
				     boolean sair;			     
				     ControladorCadastroLivro controlador = new ControladorCadastroLivro();
				     
				     livro = tfLivro.getText();
				     autor = tfAutor.getText();
				     genero = tfGenero.getText();
				     editora = tfEditora.getText();
				     quantidade = Integer.parseInt(tfQuantidade.getText());
				     
				    sair = controlador.controlaLivro(livro, autor, genero, editora, quantidade);
						if (sair) {
							dispose();
						} else {
							limpaCampos();
						}
				        
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

	private void janela() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Cadastra Livro");
		setLocationByPlatform(true);
		setResizable(false);



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
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
																.addGroup(
																		layout.createSequentialGroup()
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																								.addComponent(
																										jLabel2)
																								.addComponent(
																										jLabel1))
																				.addGap(20,
																						20,
																						20)
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																								.addComponent(
																										tfLivro,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										243,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addComponent(
																										tfAutor,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										243,
																										javax.swing.GroupLayout.PREFERRED_SIZE)))
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
																						javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																								.addComponent(
																										tfEditora)
																								.addComponent(
																										tfGenero)))
																.addGroup(
																		layout.createSequentialGroup()
																				.addComponent(
																						jLabel6)
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(
																						tfQuantidade,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						48,
																						javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		btnCadastrar)
																.addGap(18, 18,
																		18)
																.addComponent(
																		btnCancelar)))
								.addContainerGap(20, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1)
												.addComponent(
														tfLivro,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel2)
												.addComponent(
														tfAutor,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel4)
												.addComponent(
														tfEditora,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(13, 13, 13)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel3)
												.addComponent(
														tfGenero,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel6)
												.addComponent(
														tfQuantidade,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(btnCadastrar)
												.addComponent(btnCancelar))
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));

		pack();
		setLocationRelativeTo(null);
	}

	private void componentes() {
		jLabel1 = new JLabel();		
		jLabel2 = new JLabel();		
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		tfQuantidade = new JTextField();
		tfGenero = new JTextField();
		tfEditora = new JTextField();
		tfLivro = new JTextField();
		tfAutor = new JTextField();
		btnCancelar = new JButton();
		btnCadastrar = new JButton();
		
		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel1.setText("Livro");

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel2.setText("Autor");

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel3.setText("Gênero");

		jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel4.setText("Editora");
		
		jLabel5.setText("jLabel5");

		btnCancelar.setText("Cancelar");		

		btnCadastrar.setText("Cadastrar");
		
		jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel6.setText("Quantidade");
		
	}

	
	/**
	 * Limpa os campos de texto para um novo cadastro
	 * 
	 * @since 12/11/2013
	 */
	private void limpaCampos() {
		tfLivro.setText(null);
		tfAutor.setText(null);
		tfEditora.setText(null);
		tfGenero.setText(null);
		tfQuantidade.setText(null);
	}

	/**
	 * Valida os dados para o cadastro no banco de dados
	 * 
	 * @sice 12/11/2013
	 * @version 07/02/2014
	 */
	 private boolean validaCampos() {    	
	        boolean vazio = false;
	        String erros = "Os seguintes campos estão vazios:";

	        if (tfLivro.getText().isEmpty()) {
	            erros = erros.concat("-Livro \n");
	            vazio = true;
	        }
	        
	        if(tfAutor.getText().isEmpty()) {
	        	erros = erros.concat("-Autor \n");
	        	vazio = true;
	        }
	        
	        if(tfEditora.getText().isEmpty()){
	        	erros = erros.concat("-Editora \n");
	        	vazio = true;
	        }
	        
	        if(tfGenero.getText().isEmpty()){
	        	erros = erros.concat("-Gênero \n");
	        	vazio = true;
	        }
	        
	        if(tfQuantidade.getText().isEmpty() || Integer.parseInt(tfQuantidade.getText()) < 0){
	        	erros = erros.concat("-Quantidade (vazia ou negativa) \n");
	        	vazio = true;
	        }
	        
	        if(vazio == true){
				JOptionPane.showMessageDialog(null, erros);
				return false;
			}else{
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
			java.util.logging.Logger.getLogger(FormularioLivro.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FormularioLivro.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FormularioLivro.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FormularioLivro.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new FormularioLivro().setVisible(true);
			}
		});
	}

}
