class ExpValInt extends ExpVal
{
	int val;
	public ExpValInt(Value val) throws Exception
	{
	    this.val = Integer.parseInt(val.getName());
	}
	public ExpValInt(int val)
	{
		this.val = val;
	}
	public ExpValInt(String val)
	{
		this.val = Integer.parseInt(val);
	}
	public String toString()
	{
		return "" + this.val;
	}
}
