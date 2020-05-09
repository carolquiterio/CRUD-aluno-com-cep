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
	
	Alunos  alunos = new Alunos(); 
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_10;
	
	public void trataIncluirAlunos() //throws Exception
	{
		try
		{
			textField_10.setText("");
			int cod =  Integer.parseInt(textField_1.getText());
			String nom = textField_2.getText();
			String email = textField_3.getText();
			Alunos.incluir(new Aluno(cod, nom, email));
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
			String nom = textField_2.getText();
			String email = textField_3.getText();
			Alunos.atualizar(new Aluno(cod, nom, email));
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
		textField_1.setBounds(100, 26, 232, 30);
		panel_4.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(100, 67, 232, 31);
		panel_4.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(100, 109, 232, 30);
		panel_4.add(textField_3);
		
		JLabel label = new JLabel("RA:");
		label.setBounds(35, 26, 65, 30);
		panel_4.add(label);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setBounds(35, 67, 65, 30);
		panel_4.add(label_1);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(35, 109, 65, 30);
		panel_4.add(lblCep);
		
		JButton button_3 = new JButton("Incluir");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					trataIncluirAlunos();
					textField_2.setText("");
					textField_1.setText("");
					textField_3.setText("");
				}
				catch(Exception err)
				{
					textField_1.setText(err.getMessage());
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
		button_4.setBounds(406, 56, 89, 23);
		panel_4.add(button_4);
		
		JButton button_5 = new JButton("Atualizar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					trataAtualizarAlunos();
					textField_2.setText("");
					textField_1.setText("");
					textField_3.setText("");
				}
				catch(Exception err)
				{}
			}
		});
		button_5.setBounds(406, 90, 89, 23);
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
		button_6.setBounds(406, 124, 89, 23);
		panel_4.add(button_6);
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setBounds(35, 206, 455, 76);
		panel_4.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel label_9 = new JLabel("Os resultados da consulta apareceram aqui");
		label_9.setBounds(37, 165, 276, 30);
		panel_4.add(label_9);
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
