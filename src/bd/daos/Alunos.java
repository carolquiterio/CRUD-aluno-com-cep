package bd.daos;
import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;


public class Alunos 
{
	
	public static boolean cadastrado (int ra) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM ALUNOS " +
                  "WHERE RA = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, ra);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            retorno = resultado.first(); 
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao verificar se o aluno esta cadastrado!");
        }

        return retorno;
    }
	
	public static void incluir (Aluno aluno) throws Exception 
    {
        if (aluno == null)
            throw new Exception ("Forneça um aluno válido!");
        
        if (cadastrado(aluno.getRa()))
            throw new Exception ("Aluno já existe!");
        
        try
        {
            String sql;

            sql = "INSERT INTO ALUNOS " +
                  "(RA,NOME,CEP) " +
                  "VALUES " +
                  "(?,?,?,?)";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt    (1, aluno.getRa ());
            BDSQLServer.COMANDO.setString (2, aluno.getNome ());
            BDSQLServer.COMANDO.setString  (3, aluno.getCep ());
            BDSQLServer.COMANDO.setInt  (3, aluno.getTelefone ());
            
            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir aluno");
        }
    }
	
	public static void excluir (int ra) throws Exception  
    {
		if (!cadastrado (ra))
            throw new Exception ("Este aluno não esta cadastrado!");

        try
        {
            String sql;
           
            sql = "if exists(select ra from fez where ra = ?)BEGIN DELETE FROM FEZ WHERE RA = ? DELETE FROM ALUNOS WHERE RA = ? END else DELETE FROM ALUNOS WHERE RA = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);
     
            BDSQLServer.COMANDO.setInt (1, ra);
            BDSQLServer.COMANDO.setInt (2, ra);
            BDSQLServer.COMANDO.setInt (3, ra);
            BDSQLServer.COMANDO.setInt (4, ra);
           
            BDSQLServer.COMANDO.executeUpdate ();
          
            BDSQLServer.COMANDO.commit        ();
           
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao excluir aluno");
        }
    }
	
	public static void atualizar (Aluno aluno) throws Exception 
    {
        if (aluno==null)
            throw new Exception ("Preencha todos os campos!");

        if (!cadastrado (aluno.getRa()))
            throw new Exception ("Este aluno não esta cadastrado!");

        try
        {
            String sql;

            sql = "UPDATE ALUNOS " +
                  "SET NOME=? " +
                  ", TELEFONE=? " +
                  ", CEP=? " +
                  "WHERE RA = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString (1, aluno.getNome ());
            BDSQLServer.COMANDO.setInt  (2, aluno.getTelefone ());
            BDSQLServer.COMANDO.setString(3, aluno.getCep());
            BDSQLServer.COMANDO.setInt    (4, aluno.getRa ());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados do aluno");
        }
    }
	
	public static Aluno getAluno (int ra) throws Exception
    {
		if (ra <= 0)
            throw new Exception ("Digite um ra válido");
		
		 if (!cadastrado(ra))
	            throw new Exception ("Este Aluno nao esta cadastrado"); 
		 
        Aluno aluno = null;
        
        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM ALUNOS " +
                  "WHERE RA = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);
   
            BDSQLServer.COMANDO.setInt (1, ra); 

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");
           
            aluno = new Aluno (resultado.getInt   ("ra"),
                               resultado.getString("nome"), 
                               resultado.getString ("cep"),
                               resultado.getInt("telefone"));
          
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar aluno");
        }

        return aluno;
    }
	
}
