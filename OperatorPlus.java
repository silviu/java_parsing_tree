class OperatorPlus extends Operator
{
    String name;
    public OperatorPlus(String name)
	{
	    this.name = name;
	}
    public String getName()
	{
	    return this.name;
	}
    public int getPriority()
	{
	    return 1;
	}

    public ExpVal eval(ExpVal a, ExpVal b) 
	{
		if (a instanceof ExpValInt)
		{
			ExpValInt int_a = (ExpValInt) a;
			ExpValInt int_b = (ExpValInt) b;
			return new ExpValInt(int_a.val + int_b.val);
		}
		
			ExpValBool b_a = (ExpValBool) a;
			ExpValBool b_b = (ExpValBool) b;
			return new ExpValBool(b_a.val || b_b.val);
    }

}
