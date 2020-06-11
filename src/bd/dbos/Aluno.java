package bd.dbos;

public class Aluno implements Cloneable
{
	private int ra;
	private String nome;
	private String cep;
	private int telefone;
	private int numero;
	private String complemento;
	
	public int getNumero() {
		return numero;
	}

	public String getComplemento() 
	{
		return complemento;
	}
	
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
	
	public void setNumero(int numero) throws Exception 
	{
		if (numero <=0 )
			throw new Exception ("Número inválido!");
		this.numero = numero;
	}
	
	public void setComplemento(String complemento) throws Exception
	{
		if (complemento == "" || complemento == null )
			throw new Exception ("Complemento inválido!");
		this.complemento = complemento;
	}
		  
	public Aluno(int ra, String nome, String cep, int telefone, int numero, String complemento)throws Exception
	{
		this.setRa  (ra);
		this.setNome (nome);
		this.setCep(cep);
		this.setTelefone(telefone);
		this.setNumero(numero);
		this.setComplemento(complemento);
	}
		  
	public String toString ()
	{
		String ret="";

		ret +="Ra : " + this.ra+"\n";
		ret +="Nome : " + this.nome+"\n";
		ret += "Telefone : " + this.telefone+"\n";
		ret +="Cep : " + this.cep+"\n";
		ret += "Número : " + this.numero+"\n";
		ret += "Complemento : " + this.complemento+"\n";
		
		return ret;
	}
		  
	public int hashCode ()
	{
		int ret=666;

		ret = ret + new Integer(this.ra).hashCode();
		ret = ret + this.nome.hashCode();
		ret = ret + this.cep.hashCode();
		ret = ret + new Integer (this.telefone).hashCode();
		ret = ret + new Integer (this.numero).hashCode();
		ret = ret + this.complemento.hashCode();

		return ret;
	}
	 
	public Aluno (Aluno modelo) throws Exception
	{
		this.ra = modelo.ra; // nao clono, pq nao eh objeto
		this.nome = modelo.nome;
		this.cep = modelo.cep;
		this.telefone = modelo.telefone;
		this.numero = modelo.numero;
		this.complemento = modelo.complemento;
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