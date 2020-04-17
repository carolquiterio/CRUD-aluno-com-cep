package bd.dbos;

public class Materia implements Cloneable
{
		  private int codigo;
		  private String nome;

		  public int getCodigo()
		  {
			  return this.codigo;
		  }
		  
		  public String getNome()
		  {
			 return this.nome;
		  }
		  
		  public void setCodigo (int codigo) throws Exception
		  {
			  if (codigo <= 0)
				  throw new Exception ("Codigo invalido");

				 this.codigo = codigo;
		  }
		  
		  public void setNome (String nome) throws Exception
		  {
			  if (nome==null || nome.equals(""))
				 throw new Exception ("NOME invalido");

				 this.nome = nome;
		  }

		  public Materia(int codigo, String nome)throws Exception
		  {
			 this.setCodigo   (codigo);
			 this.setNome     (nome);
		  }
		  
		  public String toString ()
		  {
			  String ret="";

			  ret +="Codigo : " + this.codigo+"\n";
			  ret +="Nome : " + this.nome+"\n";

			  return ret;
		}
		  
		public int hashCode ()
		{
			int ret=666;

			ret = ret + new Integer(this.codigo).hashCode();
			ret = ret + this.nome.hashCode();

			return ret;
		}
		
	   public Materia (Materia modelo) throws Exception
	   {
			this.codigo = modelo.codigo; // nao clono, pq nao eh objeto
			this.nome = modelo.nome;
	  }
	   
	  public Object clone ()
	  {
	     Materia ret=null;

	     try
	     {
	        ret = new Materia (this);
	     }
	     catch (Exception erro)
	     {} // nao trato, pq this nunca é null e construtor de
	           // copia da excecao qdo seu parametro for null

	        return ret;
    }
 }