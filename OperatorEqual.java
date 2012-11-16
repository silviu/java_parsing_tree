class OperatorEqual extends Operator
{
	String name;
	public OperatorEqual(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public int getPriority()
	{
		return 0;
	}

	public ExpVal eval(ExpVal exp1, ExpVal exp2)
	{
		return null;
	}
}
