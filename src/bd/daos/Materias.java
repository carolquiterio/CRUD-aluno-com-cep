package bd.daos;

import java.sql.SQLException;

import bd.BDSQLServer;
import bd.core.MeuResultSet;
import bd.dbos.Materia;

public class Materias {

	public static boolean cadastrado (int cod) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MATERIAS " +
                  "WHERE COD = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, cod);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            retorno = resultado.first(); 
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar materias");
        }

        return retorno;
    }
	
	public static void incluir (Materia materia) throws Exception //funcionando
    {
        if (materia == null)
            throw new Exception ("Preencha todos os campos!"); 
        
        if (cadastrado(materia.getCodigo()))
            throw new Exception ("Esta materia já existe!");
      
        try
        {
        	  String sql;

            sql = "INSERT INTO MATERIAS " + 
                  "(COD,NOME) " +
                  "VALUES " +
                  "(?,?)";
            
           
            BDSQLServer.COMANDO.prepareStatement (sql);
            System.out.println("oi");
            BDSQLServer.COMANDO.setInt    (1, materia.getCodigo ());
            BDSQLServer.COMANDO.setString (2, materia.getNome ());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir materia");
        }
    }
	
	public static void excluir (int cod) throws Exception  
	{
            if (!cadastrado (cod))
                throw new Exception ("Esta materia não esta cadastrada!");

        try
        {
            String sql;

            sql = "if exists(select cod from fez where cod = ?)BEGIN DELETE FROM FEZ WHERE cod = ? DELETE FROM materias WHERE cod = ? END else DELETE FROM materias WHERE cod = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, cod);
            BDSQLServer.COMANDO.setInt (2, cod);
            BDSQLServer.COMANDO.setInt (3, cod);
            BDSQLServer.COMANDO.setInt (4, cod);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao excluir materia");
        }
    }
	
	public static void atualizar (Materia materia) throws Exception  
    {
		if (materia == null)
            throw new Exception ("Preencha todos os campos!"); 

        if (!cadastrado (materia.getCodigo()))
               throw new Exception ("Esta materia não esta cadastrada!");

        try
        {
            String sql;

            sql = "UPDATE MATERIAS SET NOME =?  WHERE COD = ?" ;
            		

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString  (1, materia.getNome ());
            BDSQLServer.COMANDO.setInt (2, materia.getCodigo ());
            
   
            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
            
         
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados da materia");
        }
    }
	
	public static Materia getMateria (int cod) throws Exception
    {
		if (cod <= 0)
            throw new Exception ("Digite um código válido!");
		
		 if (!cadastrado(cod))
	            throw new Exception ("Esta materia não esta cadastrada!");
		 
		Materia materia = null;
        
        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MATERIAS " +
                  "WHERE COD = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, cod);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Esta materia não esta cadastrada!");

            materia = new Materia (resultado.getInt("cod"),
                               resultado.getString("nome"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar materia");
        }

        return materia;
    }
	
	public static String materiasOrdenadasPelaMediaDosAlunos() throws Exception
	{		
		String ret = null;  
		
		try
		{
			String sql = "SELECT MATERIAS.NOME FROM MATERIAS, FEZ, alunos WHERE fez.cod = Materias.cod and ALUNOS.RA = FEZ.RA order by fez.nota";
			BDSQLServer.COMANDO.prepareStatement (sql);
			
		    MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
               throw new Exception ("Não existem alunos cursando esta matéria!");
   
            ret = resultado.getString("nome")+ ",  ";
            
           while(resultado.next())
           {
        	   ret+= resultado.getString("nome") + ", ";                           
           }
         
	            
		}
		catch(SQLException erro)
		{
			throw new Exception("Erro ao achar máterias ordenadas pela médias dos alunos!");
		}
		
		return 	ret;
	}
	
	public static String materiaSemReprovacao() throws Exception
	{		
		String ret = null;  
		
		try
		{
			String sql = "SELECT NOME FROM MATERIAS, FEZ WHERE MATERIAS.COD = Fez.cod and FEZ.NOTA >= 5";
			BDSQLServer.COMANDO.prepareStatement (sql);
			
		    MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
               throw new Exception ("Não existem matérias sem reprovação!");
   
            ret = resultado.getString("nome") + ",  ";
            
           while(resultado.next())
           {
        	   ret+= resultado.getString("nome") + ", ";         		   
           }
         
	            
		}
		catch(SQLException erro)
		{
			throw new Exception("Erro ao achar máterias sem reprovação!");
		}
		
		return 	ret;
	}
	
}
