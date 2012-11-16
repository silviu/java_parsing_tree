class Value extends Operand
{
	String name;
	Value(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	public ExpType getType()
	{
		if (this.name.equals("true") || this.name.equals("false"))
			return ExpType.bool_type;
		return ExpType.int_type;
	}
	public ExpVal getVal()
	{
	    if (this.name.equals("true"))
			return new ExpValBool(true);
	    if (this.name.equals("false"))
			return new ExpValBool(false);
	    return new ExpValInt(this.name);
	}
}
