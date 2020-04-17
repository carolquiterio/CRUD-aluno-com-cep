package programa;

import bd.daos.*;
import bd.dbos.*;

public class Programa
{

    public static void main (String[] args)
    {
        try
        {
           //Alunos.incluir (new Aluno (18, "GFDG", "@DSFGD"));
        //	Aluno aluno = new Aluno(5,"carolina","carolina@carolina");
      // System.out.println(Materias.materiasOrdenadasPelaMediaDosAlunos());
           
         // if(Fezz.cadastrado(1,3))
        	 //  System.out.println("sim");
           
          // if(!Fezz.cadastrado(1,4))
        	 //  System.out.println("nao");
        	//Aluno aluno = new Aluno(1, "Latoya", "@latoya");
        	//Alunos.alunosOrdenadosPelaMediaDasMaterias();
        	
        	//Livros.getLivro(1);
        	//Fez fez = new Fez(3,2,10.0,5);
        	//Fezz.(1,2);
        	//Materia materia = new Materia();
        	//Fezz.getFez(5,3);
        	System.out.println(Alunos.alunosOrdenadosPelaMediaDasMaterias());

        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }

}
