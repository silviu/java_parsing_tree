class ExpType
{
	int tip;
	public final static int invalid_type_val = 0;
	public final static int int_type_val = 1;
	public final static int bool_type_val = 2;
	public final static ExpType invalid_type = new ExpType(invalid_type_val);
	public final static ExpType int_type = new ExpType(int_type_val);
	public final static ExpType bool_type = new ExpType(bool_type_val);
	private ExpType(int tip)
	{
		this.tip = tip;
	}
	public boolean Equals(Object o)
	{
		ExpType lo = (ExpType) o;
		if (!(o instanceof ExpType))
			return false;
		return this.tip == lo.tip;
	}
}
