package bd.dbos;

public class Aluno implements Cloneable
{
	private int ra;
	private String nome;
	private String cep;
	private int telefone;
	
	public int getRa()
	{
		return this.ra;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public String getCep()
	{
		 return this.cep;
	}
	
	public int getTelefone()
	{
		return this.telefone;
	}
	
	public void setRa (int ra) throws Exception
	{
		if (ra <= 0)
			throw new Exception ("RA invalido");

		 this.ra = ra;
	}
	
	public void setNome (String nome) throws Exception
	{
		if (nome==null || nome.equals(""))
			 throw new Exception ("NOME invalido");

			 this.nome = nome;
	}
		  
	public void setCep (String cep) throws Exception
	{
		if (cep==null || cep.equals(""))
			 throw new Exception ("Email invalido");

		 this.cep = cep;
	}
	
	public void setTelefone (int telefone) throws Exception
	{
		if (telefone<0)
			throw new Exception ("Telefone inválido!");
		
		this.telefone = telefone;
	}
		  
	public Aluno(int ra, String nome, String cep, int telefone)throws Exception
	{
		this.setRa  (ra);
		this.setNome (nome);
		this.setCep(cep);
		this.setTelefone(telefone);
	}
		  
	public String toString ()
	{
		String ret="";

		ret +="Ra : " + this.ra+"\n";
		ret +="Nome : " + this.nome+"\n";
		ret +="Cep : " + this.cep+"\n";
		ret += "Telefone : " + this.telefone+"\n";
		
		return ret;
	}
		  
	public int hashCode ()
	{
		int ret=666;

		ret = ret + new Integer(this.ra).hashCode();
		ret = ret + this.nome.hashCode();
		ret = ret + this.cep.hashCode();
		ret = ret + new Integer (this.telefone).hashCode();

		return ret;
	}
	 
	public Aluno (Aluno modelo) throws Exception
	{
		this.ra = modelo.ra; // nao clono, pq nao eh objeto
		this.nome = modelo.nome;
		this.cep = modelo.cep;
		this.telefone = modelo.telefone;
	}
	
	public Object clone ()
	{
		Aluno ret=null;

	    try
	    {
	    	ret = new Aluno (this);
	    }
	    catch (Exception erro)
	    {} // nao trato, pq this nunca é null e construtor de
	           // copia da excecao qdo seu parametro for null

	    return ret;
    }

 }