import java.io.*;
import java.util.*;
class ResultVisitor implements Visitor
{
	ArrayList<Tree> t;
	HashMap<String, ExpVal> hash= new HashMap<String, ExpVal>();
	ResultVisitor(ArrayList<Tree> t)
	{
		this.t = t;
	}
	public Object check(Tree t)
	{
		if (t.left == null && t.right == null)
		{
			if(t.val instanceof Variable)
			{
				ExpVal varType = hash.get(t.val.getName());
				return varType;
			}
				return ((Value)t.val).getVal();
		}
		else
		{
			if ( t.op instanceof OperatorEqual)
			{
				Operand oper = t.left.val;
				String var_name = oper.getName();
				ExpVal exp_type = (ExpVal) check(t.right);
				hash.put(var_name, exp_type);
				return exp_type;
			}
		
			ExpVal type_left = (ExpVal)check(t.left);
			ExpVal type_right = (ExpVal)check(t.right);
			return t.op.eval(type_left, type_right);
		}

	}

	public void resultEvaluator()
	{
		for (Tree tree : t)
		{
			tree.accept(this);
		}
			
	}
	public void printResult(String fileName) throws Exception
	{
		PrintStream out = new PrintStream(new FileOutputStream(fileName + "_rv"));
		for(Map.Entry<String, ExpVal> entry : hash.entrySet()) 
		{
			out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
}
