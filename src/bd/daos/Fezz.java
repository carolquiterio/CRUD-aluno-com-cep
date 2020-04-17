package bd.daos;


import java.sql.SQLException;

import bd.BDSQLServer;
import bd.core.MeuResultSet;
import bd.dbos.Fez;

public class Fezz
{
	public static boolean cadastrado (int ra, int cod) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM FEZ " +
                  "WHERE (RA = ? AND COD = ?)";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, ra);
            BDSQLServer.COMANDO.setInt (2, cod);


            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            retorno = resultado.first(); 
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao verificar se o registro existe!");
        }

        return retorno;
    }
	
	public static void incluir (Fez fez) throws Exception 
    {
        if (fez == null)
            throw new Exception ("Preencha todos os campos!");
        
        if (cadastrado(fez.getRa(), fez.getCodigo()))
            throw new Exception ("Esse registro ja existe!");
        
        try
        {
            String sql;

            sql = "INSERT INTO FEZ " +
                  "(RA,COD,NOTA,FREQUENCIA) " +
                  "VALUES " +
                  "(?,?,?,?)";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt    (1, fez.getRa ());
            BDSQLServer.COMANDO.setInt    (2, fez.getCodigo ());
            BDSQLServer.COMANDO.setDouble (3, fez.getNota ());
            BDSQLServer.COMANDO.setInt    (4, fez.getFrequencia ());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir");
        }
    }
	
	public static void excluir (int ra, int cod) throws Exception  
    {
		if(ra <= 0 || cod <= 0)
			throw new Exception("Digite um código e um ra validos!");
		
        if (!cadastrado (ra,cod))
            throw new Exception ("Este registro não existe");

        try
        {
            String sql;

            sql = "DELETE FROM FEZ " +
                  "WHERE (RA= ? AND COD = ?)";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, ra);
            BDSQLServer.COMANDO.setInt (2, cod);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao excluir o registro!");
        }
    }
	
	public static void atualiza(Fez fez) throws Exception  
    {
        if (fez==null)
            throw new Exception ("Preencha todos os campos");

		if (!cadastrado (fez.getRa(), fez.getCodigo()))
			throw new Exception ("Este registro não existe!");

        try
        {
            String sql;

            sql = "UPDATE FEZ " +
                  "SET NOTA=? ," + 
                  "FREQUENCIA=? " + 
                  "WHERE ( RA= ? AND COD = ?)";

            BDSQLServer.COMANDO.prepareStatement (sql);

         
            BDSQLServer.COMANDO.setDouble (1, fez.getNota ());
            BDSQLServer.COMANDO.setInt    (2, fez.getFrequencia ());
            BDSQLServer.COMANDO.setInt    (3, fez.getRa ());
            BDSQLServer.COMANDO.setInt    (4, fez.getCodigo ());
            
            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados");
        }
    }
	
	public static Fez getFez (int ra, int cod) throws Exception
    {
		if(ra <= 0 || cod <= 0)
			throw new Exception("Digite um código e um ra validos!");
		
        if (!cadastrado (ra,cod))
            throw new Exception ("Este registro não existe");
        
		Fez fez = null;
        
        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM FEZ " +
                  "WHERE (RA = ? AND COD=?)";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, ra);
            BDSQLServer.COMANDO.setInt (2, cod);


            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao ");

            fez = new Fez (resultado.getInt("ra"),
                           resultado.getInt("cod"),
                           resultado.getFloat("nota"),
                           resultado.getInt("frequencia"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar dados");
        }

        return fez;
    }
	

}
