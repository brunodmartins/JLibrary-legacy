package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import net.miginfocom.swing.MigLayout;
import controlador.ControladorCadastroUsuario;

public class FormularioUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfEmail;
	private JTextField tfLogin;
	private JPasswordField tfSenha;
	private JPasswordField tfRSenha;
	private JTextField tfPalavra;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JLabel lblRSenha;
	private JLabel lblNome;
	private JLabel lblEmail;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JLabel lblPalavraSecreta;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FormularioUsuario frame = new FormularioUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void janela(){
		setResizable(false);
		setTitle("Cadastrar Usuário");
		setAutoRequestFocus(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 221, 335);
		getContentPane().setLayout(new MigLayout("", "[grow][grow]", "[][][][][][][][][][][][][]"));
		
	}
	
	public void componentes(){
		
		lblNome = new JLabel("Nome");
		getContentPane().add(lblNome, "cell 0 0 2 1,alignx left");
		
		tfNome = new JTextField();
		getContentPane().add(tfNome, "cell 0 1,growx");
		tfNome.setColumns(10);
		
		lblEmail = new JLabel("Email");
		getContentPane().add(lblEmail, "cell 0 2 2 1,alignx left");
		
		tfEmail = new JTextField();
		getContentPane().add(tfEmail, "flowx,cell 0 3,growx");
		tfEmail.setColumns(10);
		
		lblLogin = new JLabel("Login");
		getContentPane().add(lblLogin, "flowy,cell 0 4 2 1,alignx left");
		
		tfLogin = new JTextField();
		getContentPane().add(tfLogin, "cell 0 5,growx");
		tfLogin.setColumns(10);
		
		lblSenha = new JLabel("Senha");
		getContentPane().add(lblSenha, "cell 0 6");
		
		tfSenha = new JPasswordField();
		getContentPane().add(tfSenha, "flowx,cell 0 7,alignx left");
		tfSenha.setColumns(10);
		
		lblRSenha = new JLabel("Confirme sua senha");
		getContentPane().add(lblRSenha, "cell 0 8");
		
		tfRSenha = new JPasswordField();
		getContentPane().add(tfRSenha, "cell 0 9,alignx left");
		tfRSenha.setColumns(10);
		
		lblPalavraSecreta = new JLabel("Palavra secreta");
		getContentPane().add(lblPalavraSecreta, "cell 0 10");
		
		tfPalavra = new JTextField();
		getContentPane().add(tfPalavra, "cell 0 11,growx");
		tfPalavra.setColumns(10);
		
		btnCadastrar = new JButton("Cadastrar");
		getContentPane().add(btnCadastrar, "flowx,cell 0 12,growx,aligny baseline");
		
		btnCancelar = new JButton("Cancelar");
		getContentPane().add(btnCancelar, "cell 0 12,growx");
		
		
	}
	
	public void eventos(){
		btnCadastrar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String nome = tfNome.getText();
				String email = tfEmail.getText();
				String login = tfLogin.getText();
				String senha = String.copyValueOf(tfSenha.getPassword());
				String rSenha = String.copyValueOf(tfRSenha.getPassword()); 
				String palavra = tfPalavra.getText();
				
				ControladorCadastroUsuario cadastro = new ControladorCadastroUsuario();
				if(validaCampos(nome, email, login, senha, palavra) && cadastro.validaUsuario(nome) && validaSenha(senha,rSenha)){
					int sw = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite a senha de adminitrador"));
					if(sw == 19){
						cadastro.controlaUsuario(nome, email, login, senha, palavra);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Senha incorreta");
					}									
				}		
			}	
		});
		
		btnCancelar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();				
			}			
		});
	}
	
	protected boolean validaSenha(String senha, String rSenha) {
		if(senha.equalsIgnoreCase(rSenha))
			return true;
		JOptionPane.showMessageDialog(null, "As senhas estão diferentes!");
		return false;
			
	}

	protected boolean validaCampos(String nome, String email, String login, String senha, String palavra) {
		String erros= "O seguintes campos estão vazios: \n";
		boolean vazio = false;
		
		if(tfNome.getText().isEmpty()){
			erros = erros.concat("-Nome \n");
			vazio = true;
		}
		if(tfEmail.getText().isEmpty()){
			erros = erros.concat("-Email \n");
			vazio = true;
		}
		if(tfLogin.getText().isEmpty()){
			erros = erros.concat("-Login \n");
			vazio = true;
		}
		if(tfSenha.getPassword().length == 0){
			erros = erros.concat("-Senha \n");
			vazio = true;
		}
		if(tfPalavra.getText().isEmpty()){
			erros = erros.concat("-Palavra secreta \n");
			vazio = true;
		}
		if(vazio == true){
			JOptionPane.showMessageDialog(null, erros);
			return false;
		}else{
			return true;
		}
	}

	public FormularioUsuario() {
		janela();
		componentes();
		eventos();		
	}

}
