package bd.dbos;

public class Fez implements Cloneable
{
		  private int ra;
		  private int cod;
		  private double nota;
		  private int frequencia;

		  public int getRa()
		  {
			  return this.ra;
		  }
		  public int getCodigo()
		  {
		  	return this.cod;
		  }
		  public double getNota()
		  {
			 return this.nota;
		  }
		  public int getFrequencia()
		  {
			 return this.frequencia;
		  }

		  public void setRa (int ra) throws Exception
		  {
			  if (ra <= 0)
				  throw new Exception ("Ra invalido");

				 this.ra = ra;
		  }
		  public void setCodigo (int codigo) throws Exception
		  {
			if (codigo <= 0)
				throw new Exception ("Codigo invalido");

				this.cod = codigo;
		  }
		  public void setNota(double nota) throws Exception
		  {
			  if (nota < 0)
				 throw new Exception ("Nota invalido");

				 this.nota = nota;
		  }
		  public void setFrequencia(int frequencia) throws Exception
		  {
			if (frequencia < 0)
			   throw new Exception ("frequencia invalido");

				this.frequencia = frequencia;
		  }


		  public Fez(int ra,int cod, double nota, int frequencia)throws Exception
		  {
			 this.setRa  (ra);
			 this.setCodigo (cod);
			 this.setNota (nota);
			 this.setFrequencia (frequencia);
		  }
		  public String toString ()
		  {
			  String ret="";

			  ret +="Ra : " + this.ra +"\n";
			  ret +="Codigo : " + this.cod +"\n";
			  ret +="Nota : " + this.nota+"\n";
			  ret +="Frequencia : " + this.frequencia+"\n";

			  return ret;
		}
		public int hashCode ()
		{
			int ret=666;

			ret = ret + new Integer(this.ra).hashCode();
			ret = ret + new Integer(this.cod).hashCode();
			ret = ret + new Double(this.nota).hashCode();
			ret = ret + new Integer(this.frequencia).hashCode();


			return ret;
		}
	   public Fez (Fez modelo) throws Exception
	   {
		    this.ra = modelo.ra;
			this.cod = modelo.cod; // nao clono, pq nao eh objeto
			this.nota = modelo.nota;
			this.frequencia = modelo.frequencia;
	  }
	  public Object clone ()
	  {
	     Fez ret=null;

	     try
	     {
	        ret = new Fez (this);
	     }
	     catch (Exception erro)
	     {} // nao trato, pq this nunca é null e construtor de
	           // copia da excecao qdo seu parametro for null

	        return ret;
    }
 }