import java.io.*;
import java.util.*;
class SemanticVisitor implements Visitor
{
	ArrayList<Tree> t;
	HashMap<String, ExpType> hash= new HashMap<String, ExpType>();
	SemanticVisitor(ArrayList<Tree> t)
	{
		this.t = t;
	}
	public Object check(Tree t)
	{
		if (t.left == null && t.right == null)
		{
			if(t.val instanceof Variable)
			{
				ExpType varType = hash.get(t.val.getName());
				if (varType == null)
				{
					Error.add("E2: variabila " + t.val.getName() + " nu a fost declarata");
					return ExpType.invalid_type;
				}
			
				else
					return varType;
			}
			if(t.val instanceof Value)
				return ((Value)t.val).getType();
		}
		else
		{
			if ( t.op instanceof OperatorEqual)
			{
				Operand oper = t.left.val;
				String var_name = oper.getName();
				if (!(t.left.val instanceof Variable))
				{
					Error.add("E1: se atribuie continutul unei variabile unei valori");
					return ExpType.invalid_type;
				}
				ExpType exp_type = (ExpType)check(t.right);
				hash.put(var_name, exp_type);
				return exp_type;
			}
			ExpType type_left = (ExpType)check(t.left);
			ExpType type_right = (ExpType)check(t.right);
			if (!type_left.Equals(type_right))
			{
				Error.add("E3: Different types in operand " + t.op.getName());
				return ExpType.invalid_type;
			}
			return type_left;
		}
	return ExpType.invalid_type;	
	}

	public void semanticEvaluator(String fileName) throws Exception
	{
		PrintStream out = new PrintStream(new FileOutputStream(fileName + "_pt"));
		for (Tree tree : t)
		{
			out.println(tree);
			tree.accept(this);
			
		}
		out.close();
	}
}
