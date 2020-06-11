package Projeto;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bd.daos.Alunos;
import bd.dbos.Aluno;
import cep.ClienteWS;
import cep.Logradouro;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import java.awt.TextArea;
import java.awt.Toolkit;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.DropMode;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Checkbox;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.JTextArea;

public class Projetoo2 {

	private JFrame frame;
	
	Logradouro logradouro;	
	Alunos  alunos = new Alunos(); 
	private JTextField textField_RA;
	private JTextField textField_nome;
	private JTextField textField_cep;
	private JTextField textField_cidade;
	private JTextField textField_bairro;
	private JTextField textField_rua;
	private JTextField textField_tel;
	private JTextField textField_estado;
	private JTextField textField_num;
	private JTextField textField_complto;
	private JTextArea textArea_resultados;
	
	public void trataIncluirAlunos() throws Exception
	{
		try
		{                        
			int cod =  Integer.parseInt(textField_RA.getText());
			String nom = textField_nome.getText();
			String cep = textField_cep.getText();
			int telefone = Integer.parseInt(textField_tel.getText());
			int numero = Integer.parseInt(textField_num.getText());
			String complemento = textField_complto.getText();
			
			Alunos.incluir(new Aluno(cod, nom, cep, telefone, numero, complemento));
			
		}
		catch(Exception err)
		{
			textArea_resultados.setText(err.getMessage());
		}
	}
	
	public void trataExcluirAlunos() throws Exception
	{
		try
		{
			
			int cod =  Integer.parseInt(textField_RA.getText());
			Alunos.excluir(cod);
		}
		catch(Exception err)
		{
			textArea_resultados.setText(err.getMessage());
		}
	}
	
	public void trataAtualizarAlunos() throws Exception
	{
		try
		{
			textArea_resultados.setText("");
			int cod =  Integer.parseInt(textField_RA.getText());
			String nom = textField_nome.getText();
			String cep = textField_cep.getText();
			int telefone = Integer.parseInt(textField_tel.getText());
			int numero = Integer.parseInt(textField_num.getText());
			String complemento = textField_complto.getText();
			Alunos.atualizar(new Aluno(cod, nom, cep, telefone, numero, complemento));
		}
		catch(Exception err)
		{
			textArea_resultados.setText(err.getMessage());
		}
	}
	
	public void trataGetAlunos() throws Exception
	{
		try
		{
			int cod =  Integer.parseInt(textField_RA.getText());
			textArea_resultados.setText(Alunos.getAluno(cod) + "\n");
		}
		catch(Exception err)
		{
			textArea_resultados.setText(err.getMessage());
		}
	}
	
	public void trataPreencherEndereco() //throws Exception
	{
		try
		{
			String cep = textField_cep.getText();
			
			logradouro = (Logradouro)ClienteWS.getObjeto(Logradouro.class, "http://api.postmon.com.br/v1/cep", cep);
			
			textField_rua.setText(logradouro.getLogradouro() + "");
		
			textField_cidade.setText(logradouro.getCidade() + "");
			 
			textField_bairro.setText(logradouro.getBairro() + "");
			
			textField_estado.setText(logradouro.getEstado() + "");
			
		}
		catch(Exception err)
		{
			textArea_resultados.setText(err.getMessage());
		}
	}
	
	public void limpaCampos()
	{
		try
		{
			textField_nome.setText("");
			textField_cep.setText("");
			textField_RA.setText("");
			textField_cidade.setText("");
			textField_bairro.setText("");
			textField_rua.setText("");
			textField_tel.setText("");
			textField_estado.setText("");
			textField_num.setText("");
			textField_complto.setText("");
		}
		catch(Exception err)
		{
			textArea_resultados.setText(err.getMessage());
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Projetoo2 window = new Projetoo2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
 
	/**
	 * Create the application.
	 */
	public Projetoo2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 589, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consulta Escolar : ");
		lblNewLabel.setBounds(183, 11, 197, 14);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 27, 534, 332);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Alunos", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_1.add(panel_4, BorderLayout.CENTER);
		
		textField_RA = new JTextField();
		textField_RA.setColumns(10);
		textField_RA.setBounds(75, 11, 118, 30);
		panel_4.add(textField_RA);
		textField_RA.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseClicked(java.awt.event.MouseEvent evt) {
	        	textArea_resultados.setText("");
	        }
	    });
		
		textField_tel = new JTextField();
		textField_tel.setColumns(10);
		textField_tel.setBounds(75, 135, 118, 30);
		panel_4.add(textField_tel);
		textField_tel.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseClicked(java.awt.event.MouseEvent evt) {
	            trataPreencherEndereco();
	        }
	    });
		
		JLabel label = new JLabel("RA:");
		label.setBounds(10, 11, 65, 30);
		panel_4.add(label);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setBounds(10, 52, 65, 30);
		panel_4.add(label_1);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(10, 94, 65, 30);
		panel_4.add(lblCep);
		
		JButton button_incluir = new JButton("Incluir");
		button_incluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					trataIncluirAlunos();
					limpaCampos();
					
				}
				catch(Exception err)
				{}
			}
			
		});
		button_incluir.setBounds(406, 11, 89, 23);
		panel_4.add(button_incluir);
		
		JButton button_excluir = new JButton("Excluir");
		button_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					trataExcluirAlunos();
					limpaCampos();
				}
				catch(Exception err)
				{}
			}
		});
		button_excluir.setBounds(406, 69, 89, 23);
		panel_4.add(button_excluir);
		
		JButton button_5 = new JButton("Atualizar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					trataAtualizarAlunos();
					limpaCampos();
				}
				catch(Exception err)
				{}
			}
		});
		button_5.setBounds(406, 123, 89, 23);
		panel_4.add(button_5);
		
		JButton button_get = new JButton("Consultar");
		button_get.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					
					trataGetAlunos();
					limpaCampos();
				}
				catch(Exception err)
				{}
			}
		});
		button_get.setBounds(406, 180, 89, 23);
		panel_4.add(button_get);
		
		JLabel label_9 = new JLabel("Os resultados da consulta apareceram aqui");
		label_9.setBounds(35, 211, 276, 30);
		panel_4.add(label_9);
		
		textField_nome = new JTextField();
		textField_nome.setColumns(10);
		textField_nome.setBounds(75, 52, 118, 30);
		panel_4.add(textField_nome);
		
		textField_cep = new JTextField();
		textField_cep.setColumns(10);
		textField_cep.setBounds(75, 94, 118, 30);
		panel_4.add(textField_cep);		
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(203, 11, 65, 30);
		panel_4.add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(203, 52, 65, 30);
		panel_4.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(203, 94, 65, 30);
		panel_4.add(lblCidade);
		
		textField_cidade = new JTextField();
		textField_cidade.setEditable(false);
		textField_cidade.setColumns(10);
		textField_cidade.setBounds(268, 94, 118, 30);
		panel_4.add(textField_cidade);
		
		textField_bairro = new JTextField();
		textField_bairro.setEditable(false);
		textField_bairro.setColumns(10);
		textField_bairro.setBounds(268, 52, 118, 30);
		panel_4.add(textField_bairro);
		
		textField_rua = new JTextField();
		textField_rua.setEditable(false);
		textField_rua.setColumns(10);
		textField_rua.setBounds(268, 11, 118, 30);
		panel_4.add(textField_rua);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 135, 65, 30);
		panel_4.add(lblTelefone);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(203, 135, 65, 30);
		panel_4.add(lblEstado);
		
		textField_estado = new JTextField();
		textField_estado.setEditable(false);
		textField_estado.setColumns(10);
		textField_estado.setBounds(268, 135, 118, 30);
		panel_4.add(textField_estado);
		
		JLabel lblComplemento = new JLabel("Complto:");
		lblComplemento.setBounds(203, 176, 65, 30);
		panel_4.add(lblComplemento);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(10, 176, 65, 30);
		panel_4.add(lblNmero);
		
		textField_num = new JTextField();
		textField_num.setColumns(10);
		textField_num.setBounds(75, 176, 118, 30);
		panel_4.add(textField_num);
		
		textField_complto = new JTextField();
		textField_complto.setColumns(10);
		textField_complto.setBounds(268, 176, 118, 30);
		panel_4.add(textField_complto);
		
		textArea_resultados = new JTextArea();
		textArea_resultados.setColumns(2);
		textArea_resultados.setEditable(false);
		textArea_resultados.setBounds(10, 235, 485, 58);
		panel_4.add(textArea_resultados);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
