package programa;

import bd.daos.*;
import bd.dbos.*;

import cep.ClienteWS;
import cep.Logradouro;

public class Programa
{
    public static void main (String[] args)
    {
        try
        {
            Logradouro logradouro =
            (Logradouro)ClienteWS.getObjeto(Logradouro.class, "http://api.postmon.com.br/v1/cep", "13012000");
            System.out.println (logradouro);
        	Aluno al = new Aluno(13, "oi", "campinas", 999, 45, "nao" );
        	System.out.println(al.getCep());
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }
}
