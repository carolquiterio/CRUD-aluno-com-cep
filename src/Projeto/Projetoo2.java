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

public class Projetoo2 {

	private JFrame frame;
	
	Logradouro logradouro;	
	Alunos  alunos = new Alunos(); 
	private JTextField textField_1;
	private JTextField textField_10;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	
	public void trataIncluirAlunos() //throws Exception
	{
		try
		{
			textField_10.setText("");                         
			int cod =  Integer.parseInt(textField_1.getText());
			String nom = textField.getText();
			String cep = textField_2.getText();
			int telefone = Integer.parseInt(textField_6.getText());
			int numero = Integer.parseInt(textField_8.getText());
			String complemento = textField_9.getText();
			
			Alunos.incluir(new Aluno(cod, nom, cep, telefone, numero, complemento));
			
		}
		catch(Exception err)
		{
			textField_10.setText(err.getMessage());
		}
	}
	
	public void trataExcluirAlunos() throws Exception
	{
		try
		{
			textField_10.setText("");
			int cod =  Integer.parseInt(textField_1.getText());
			Alunos.excluir(cod);
		}
		catch(Exception err)
		{
			textField_10.setText(err.getMessage());
		}
	}
	
	public void trataAtualizarAlunos() throws Exception
	{
		try
		{
			textField_10.setText("");
			int cod =  Integer.parseInt(textField_1.getText());
			String nom = textField.getText();
			String cep = textField_2.getText();
			int telefone = Integer.parseInt(textField_6.getText());
			int numero = Integer.parseInt(textField_8.getText());
			String complemento = textField_9.getText();
			Alunos.atualizar(new Aluno(cod, nom, cep, telefone, numero, complemento));
		}
		catch(Exception err)
		{
			textField_10.setText(err.getMessage());
		}
	}
	
	public void trataGetAlunos() throws Exception
	{
		try
		{
			textField_10.setText("");
			int cod =  Integer.parseInt(textField_1.getText());
			textField_10.setText(Alunos.getAluno(cod) + "\n");
		}
		catch(Exception err)
		{
			textField_10.setText(err.getMessage());
		}
	}
	
	public void trataPreencherEndereco() //throws Exception
	{
		try
		{
			String cep = textField_2.getText();
			
			logradouro = (Logradouro)ClienteWS.getObjeto(Logradouro.class, "http://api.postmon.com.br/v1/cep", cep);
			
			
			textField_5.setText(logradouro.getLogradouro() + "");
		
			textField_3.setText(logradouro.getCidade() + "");
			
			textField_4.setText(logradouro.getBairro() + "");
			
			textField_7.setText(logradouro.getEstado() + "");
			
		}
		catch(Exception err)
		{
			textField_10.setText(err.getMessage());
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
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(75, 22, 118, 30);
		panel_4.add(textField_1);
		
		JLabel label = new JLabel("RA:");
		label.setBounds(10, 22, 65, 30);
		panel_4.add(label);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setBounds(10, 63, 65, 30);
		panel_4.add(label_1);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(10, 105, 65, 30);
		panel_4.add(lblCep);
		
		JButton button_3 = new JButton("Incluir");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					trataIncluirAlunos();
					textField.setText("");
					textField_2.setText("");
					textField_1.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_7.setText("");
					textField_8.setText("");
					textField_9.setText("");
					
				}
				catch(Exception err)
				{
					textField_10.setText(err.getMessage());
				}
			}
			
		});
		button_3.setBounds(406, 22, 89, 23);
		panel_4.add(button_3);
		
		JButton button_4 = new JButton("Excluir");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					trataExcluirAlunos();
					textField_1.setText("");
				}
				catch(Exception err)
				{}
			}
		});
		button_4.setBounds(406, 80, 89, 23);
		panel_4.add(button_4);
		
		JButton button_5 = new JButton("Atualizar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					trataAtualizarAlunos();
					textField.setText("");
					textField_2.setText("");
					textField_1.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_7.setText("");
					textField_8.setText("");
					textField_9.setText("");
				}
				catch(Exception err)
				{}
			}
		});
		button_5.setBounds(406, 134, 89, 23);
		panel_4.add(button_5);
		
		JButton button_6 = new JButton("Consultar");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					
					trataGetAlunos();
					textField_2.setText("");
					textField_1.setText("");
					textField_3.setText("");
				}
				catch(Exception err)
				{}
			}
		});
		button_6.setBounds(406, 191, 89, 23);
		panel_4.add(button_6);
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setBounds(35, 252, 455, 30);
		panel_4.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel label_9 = new JLabel("Os resultados da consulta apareceram aqui");
		label_9.setBounds(35, 223, 276, 30);
		panel_4.add(label_9);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(75, 63, 118, 30);
		panel_4.add(textField);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(75, 105, 118, 30);
		panel_4.add(textField_2);		
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(203, 22, 65, 30);
		panel_4.add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(203, 63, 65, 30);
		panel_4.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(203, 105, 65, 30);
		panel_4.add(lblCidade);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(268, 105, 118, 30);
		panel_4.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(268, 63, 118, 30);
		panel_4.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(268, 22, 118, 30);
		panel_4.add(textField_5);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 146, 65, 30);
		panel_4.add(lblTelefone);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(75, 146, 118, 30);
		panel_4.add(textField_6);
		textField_6.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseClicked(java.awt.event.MouseEvent evt) {
	            trataPreencherEndereco();
	        }
	    });
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(203, 146, 65, 30);
		panel_4.add(lblEstado);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(268, 146, 118, 30);
		panel_4.add(textField_7);
		
		JLabel lblComplemento = new JLabel("Complto:");
		lblComplemento.setBounds(203, 187, 65, 30);
		panel_4.add(lblComplemento);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(10, 187, 65, 30);
		panel_4.add(lblNmero);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(75, 187, 118, 30);
		panel_4.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(268, 187, 118, 30);
		panel_4.add(textField_9);
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
