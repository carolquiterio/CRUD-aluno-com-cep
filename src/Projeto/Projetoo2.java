package Projeto;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bd.daos.Alunos;
import bd.daos.Fezz;
import bd.daos.Materias;
import bd.dbos.Aluno;
import bd.dbos.Fez;
import bd.dbos.Materia;


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
	Materias materias = new Materias(); 
	Fezz fez = new Fezz(); 
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	
	public void trataFrequenciaZero()
	{
		try
		{
			textField.setText(Alunos.frequenciaZero());
		}
		catch (Exception err)
		{
			textField.setText(err.getMessage());
		}
	}
	
	public void trataAlunosOrdenados()
	{
		try
		{
			textField.setText(Alunos.alunosOrdenadosPelaMediaDasMaterias() + "");
		}
		catch (Exception err)
		{
			textField.setText(err.getMessage());
		}	
	}
	
	public void trataMateriaSemReprovacao()
	{
		try
		{
			textField.setText(Materias.materiaSemReprovacao() + "");
		}
		catch (Exception err)
		{
			textField.setText(err.getMessage());
		}
	}
	
	public void trataMateriasOrdenadas()
	{
		try
		{
			textField.setText(Materias.materiasOrdenadasPelaMediaDosAlunos() + "");
		}
		catch (Exception err)
		{
			textField.setText(err.getMessage());
		}
	}
	
	public void trataIncluirMateria() throws 	Exception
	{   
		try 
		{
			textField_12.setText("");
			int cod =  Integer.parseInt(textField_8.getText());
			String nom = textField_9.getText();
			Materias.incluir(new Materia(cod, nom));
		}
	    catch(Exception err)
		{
			textField_12.setText(err.getMessage());
		}
	}
	public void trataExcluirMaterias() //throws Exception
	{
		try 
		{
			textField_12.setText("");
			int cod =  Integer.parseInt(textField_8.getText());
			Materias.excluir(cod);
		}
		catch(Exception err)
		{
			textField_12.setText(err.getMessage());
		}
		
	}
	
	public void trataAtualizarMaterias() //throws Exception
	{
		try
		{
			textField_12.setText("");
			int cod =  Integer.parseInt(textField_8.getText());
			String nom = textField_9.getText();
			Materias.atualizar(new Materia(cod, nom));
		}
		catch(Exception err)
		{
			textField_12.setText(err.getMessage());
		}
	}
	
	public void trataGetMaterias()// throws Exception
	{
		try
		{
			textField_12.setText("");
			int cod =  Integer.parseInt(textField_8.getText());
			textField_12.setText(Materias.getMateria(cod) + "");
		}
		catch(Exception err)
		{
			textField_12.setText(err.getMessage());
		}
	}
	
	
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
	
	public void trataIncluirFez() //throws Exception
	{
		try
		{
			textField_11.setText("");
			int ra =  Integer.parseInt(textField_6.getText());
			int cod =  Integer.parseInt(textField_5.getText());
			float nota = Float.parseFloat(textField_4.getText());
			int frequencia = Integer.parseInt(textField_7.getText());
			Fezz.incluir(new Fez(ra, cod, nota,frequencia));
		}
		catch(Exception err)
		{
			textField_11.setText(err.getMessage());
		}
	}
	
	public void trataExcluirFez() throws Exception
	{
		try 
		{
			textField_11.setText("");
			int ra =  Integer.parseInt(textField_6.getText());
			int cod =  Integer.parseInt(textField_5.getText());
			Fezz.excluir(ra,cod);
		}
		catch(Exception err)
		{
			textField_11.setText(err.getMessage());
		}
		
	}
	
	public void trataAtualizarFez() throws Exception
	{
		try 
		{
			textField_11.setText("");
			int ra =  Integer.parseInt(textField_6.getText());
			int cod =  Integer.parseInt(textField_5.getText());
			Float nota =Float.parseFloat(textField_4.getText());
			int frequencia = Integer.parseInt( textField_7.getText());
			Fezz.atualiza(new Fez(ra,cod, nota, frequencia));
		}
		catch(Exception err)
		{
			textField_11.setText(err.getMessage());
		}
	}
	
	public void trataGetFez() throws Exception
	{
		try
		{
			textField_11.setText("");
			int ra =  Integer.parseInt(textField_6.getText());
			int cod =  Integer.parseInt(textField_5.getText());
			textField_11.setText(Fezz.getFez(ra,cod) + "");
		}
		catch(Exception err)
		{
			textField_11.setText(err.getMessage());
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
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 175, 175));
		tabbedPane.addTab("Relatorios", null, panel, null);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Frequencia 0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					trataFrequenciaZero();
			
				}
				catch(Exception err)
				{} //Sei que não vai dar erro
			}
		});
		btnNewButton.setBounds(15, 5, 95, 23);
		panel.add(btnNewButton);
		
		JButton button_1 = new JButton("Alunos ordenados");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					trataAlunosOrdenados();
			
				}
				catch(Exception err)
				{} //Sei que não vai dar erro
			}
		});
		button_1.setBounds(115, 5, 119, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Materias s/ reprova\u00E7\u00E3o");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					trataMateriaSemReprovacao();
			
				}
				catch(Exception err)
				{
					
					textField.setText(err.getMessage());
				} //Sei que não vai dar erro
			}
		});
		button_2.setBounds(239, 5, 143, 23);
		panel.add(button_2);
		
		JButton button = new JButton("Materias ordenadas");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					trataMateriasOrdenadas();
			
				}
				catch(Exception err)
				{} //Sei que não vai dar erro
			}
		});
		button.setBounds(387, 5, 127, 23);
		panel.add(button);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setFont(new Font("Arial", Font.BOLD, 16));
		textField.setBounds(12, 33, 502, 260);
		panel.add(textField);
		textField.setColumns(62);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Materias", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(0, 0, 529, 293);
		panel_2.add(panel_5);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(101, 43, 232, 30);
		panel_5.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(101, 84, 232, 31);
		panel_5.add(textField_9);
		
		JLabel label_7 = new JLabel("Codigo:");
		label_7.setBounds(36, 43, 65, 30);
		panel_5.add(label_7);
		
		JLabel label_8 = new JLabel("Nome:");
		label_8.setBounds(36, 84, 65, 30);
		panel_5.add(label_8);
		
		JButton button_11 = new JButton("Incluir");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					trataIncluirMateria();
					textField_8.setText("");
					textField_9.setText("");								
				}
				catch(Exception erro)
				{} //sei que nao vai dar erro
			}
		});
		button_11.setBounds(382, 23, 89, 23);
		panel_5.add(button_11);
		
		JButton button_12 = new JButton("Excluir");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					trataExcluirMaterias();
					textField_8.setText("");
					textField_9.setText("");	
				}
				catch(Exception err)
				{}//sei que não vai dar erro
			}
		});
		button_12.setBounds(382, 57, 89, 23);
		panel_5.add(button_12);
		
		JButton button_13 = new JButton("Atualizar");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
				   trataAtualizarMaterias();
				   textField_8.setText("");
				   textField_9.setText("");
				}
				catch(Exception err)
				{}//sei que não vai dar erro
			}
		});
		button_13.setBounds(382, 91, 89, 23);
		panel_5.add(button_13);
		
		JButton button_14 = new JButton("Consultar");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					trataGetMaterias();
				   textField_8.setText("");
				   textField_9.setText("");
				}
				catch(Exception err)
				{}//sei que não vai dar erro
			}
			
		});
		button_14.setBounds(382, 125, 89, 23);
		panel_5.add(button_14);
		
		textField_12 = new JTextField();
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setColumns(10);
		textField_12.setBounds(36, 184, 455, 98);
		panel_5.add(textField_12);
		
		JLabel label_11 = new JLabel("Os resultados da consulta apareceram aqui");
		label_11.setBounds(36, 150, 276, 30);
		panel_5.add(label_11);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Fez", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel label_3 = new JLabel("RA:");
		label_3.setBounds(22, 21, 65, 30);
		panel_3.add(label_3);
		
		JLabel label_4 = new JLabel("Codigo:");
		label_4.setBounds(22, 55, 65, 30);
		panel_3.add(label_4);
		
		JLabel lblNota = new JLabel("Nota:");
		lblNota.setBounds(22, 89, 65, 30);
		panel_3.add(lblNota);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(130, 96, 232, 23);
		panel_3.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(130, 62, 232, 23);
		panel_3.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(130, 28, 232, 23);
		panel_3.add(textField_6);
		
		JButton button_7 = new JButton("Incluir");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
				  trataIncluirFez();
				   textField_6.setText("");
				   textField_4.setText("");
				   textField_5.setText("");
				   textField_7.setText("");
				}
				catch(Exception err)
				{}//sei que não vai dar erro
			}
		});
		button_7.setBounds(409, 24, 89, 23);
		panel_3.add(button_7);
		
		JButton button_8 = new JButton("Excluir");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
				  trataExcluirFez();
				   textField_6.setText("");
				   textField_4.setText("");
				   textField_5.setText("");
				   textField_7.setText("");
				}
				catch(Exception err)
				{}//sei que não vai dar erro
			}
		});
		button_8.setBounds(409, 58, 89, 23);
		panel_3.add(button_8);
		
		JButton button_9 = new JButton("Atualizar");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
				  trataAtualizarFez();
				   textField_6.setText("");
				   textField_4.setText("");
				   textField_5.setText("");
				   textField_7.setText("");
				}
				catch(Exception err)
				{}//sei que não vai dar erro
			}
		});
		button_9.setBounds(409, 92, 89, 23);
		panel_3.add(button_9);
		
		JButton button_10 = new JButton("Consultar");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					trataGetFez();
				   textField_6.setText("");
				   textField_4.setText("");
				   textField_5.setText("");
				   textField_7.setText("");
				}
				catch(Exception err)
				{}//sei que não vai dar erro
			}
			
		});
		button_10.setBounds(409, 126, 89, 23);
		panel_3.add(button_10);
		
		JLabel label_6 = new JLabel("Frequencia:");
		label_6.setBounds(22, 123, 77, 30);
		panel_3.add(label_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(130, 130, 232, 23);
		panel_3.add(textField_7);
		
		JLabel label_10 = new JLabel("Os resultados da consulta apareceram aqui");
		label_10.setBounds(22, 176, 276, 30);
		panel_3.add(label_10);
		
		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setColumns(10);
		textField_11.setBounds(22, 217, 476, 76);
		panel_3.add(textField_11);
		
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
		
		JLabel label_2 = new JLabel("Email:");
		label_2.setBounds(35, 109, 65, 30);
		panel_4.add(label_2);
		
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
					textField.setText(err.getMessage());
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
