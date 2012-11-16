class ExpValBool extends ExpVal
{
	boolean val;
	public ExpValBool(boolean val)
	{
		this.val = val;
	}
	public String toString()
	{
		return "" + this.val;
	}
}
