package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import bancoDados.controlador.GerenciaTBUsuario;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JTextField		jLogin;
	private JPasswordField	jSenha;
	private JButton			btnEntrar;
	private JButton			btnNovoCadastro;
	private JButton			btnEsqueciASenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void janela() {
		super.setTitle("JLibrary");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 344, 150);
		getContentPane().setLayout(null);
		setResizable(false);
	}

	private void componentes() {
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLogin.setBounds(10, 11, 46, 14);
		getContentPane().add(lblLogin);
		jLogin = new JTextField();
		jLogin.setBounds(66, 9, 128, 20);
		getContentPane().add(jLogin);
		jLogin.setColumns(10);
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(10, 36, 46, 14);
		getContentPane().add(lblSenha);
		jSenha = new JPasswordField();
		jSenha.setBounds(66, 40, 128, 20);
		getContentPane().add(jSenha);
		jSenha.setColumns(10);
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(204, 8, 128, 23);
		getContentPane().add(btnEntrar);
		btnNovoCadastro = new JButton("Novo Cadastro");
		btnNovoCadastro.setBounds(204, 39, 128, 23);
		getContentPane().add(btnNovoCadastro);
		btnEsqueciASenha = new JButton("Esqueci a Senha");
		btnEsqueciASenha.setBounds(66, 71, 128, 23);
		getContentPane().add(btnEsqueciASenha);
	}

	private void eventos() {
		btnEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (jLogin.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Ops! Parece que o campo login esta vazio!");
				} else if (jSenha.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null,
							"Ops! Parece que o campo senha esta vazio!");
				} else {
					GerenciaTBUsuario controle = new GerenciaTBUsuario();
					if (controle.validaLogin(jLogin.getText(), jSenha.getPassword())) {
						controle =null;
						Menu.main(null);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Cadastro não encontrado!");
					}
				}
			}
		});
		btnNovoCadastro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				FormularioUsuario.main(null);
			}
		});
	}

	public Login() {
		janela();
		componentes();
		eventos();
	}
}
