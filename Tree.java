class Tree
{
	Tree left, right;
	Operator op;
	Operand val;
	public Tree( Tree st, Tree dr, Operator op)
	{
		this.left = st;
		this.right = dr;
		this.op = op;
	}
	public Tree(Operand val)
	{
		this.left = null;
		this.right = null;
		this.val = val;
	}

	public Tree getLeft()
	{
		return left;
	}
	public Tree getRight()
	{
		return right;
	}


	public Object accept(Visitor v)
	{
		return v.check(this);
	}
	public String Tabs(int tabs)
	{
		String ret = "";
		for (int i = 0 ; i < tabs; i++)
			ret += "\t";
		return ret;
	}
	public String toString1(int depth)
	{
		String tabs = Tabs(depth);
		if (left == null && right == null)
			return (tabs + val.getName() );
		else	
			return (tabs + op.getName() + "\n" + 
				    left.toString1(depth+1) + "\n" + 
					right.toString1(depth+1));
	}
	public String caca()
	{
		if (left == null && right == null)
			return val.getName();
		else
			return "(" + op.getName() + " " + left.caca() + " " + right.caca() + ")";
	}
	public String toString()
	{
		return toString1(0) + "\n";
	}

	public static void main(String[] args)
	{
		Tree st = new Tree(new Value("5"));
		Tree dr = new Tree(new Variable("a"));
		Tree t = new Tree(st, dr, new OperatorPlus("+"));

		Tree a = new Tree(new Value("a"));
		Tree b = new Tree(new Value("b"));
		Tree c = new Tree(new Value("c"));
		Tree cinci = new Tree(new Value("5"));
		Tree c5 = new Tree(cinci, c, new OperatorStar("*"));
		Tree b5c = new Tree(b, c5, new OperatorPlus("+"));
		Tree expr = new Tree(a, b5c, new OperatorEqual("="));
		System.out.println(expr.toString());
	}
}
