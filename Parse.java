import java.io.*;
import java.util.*;
import java.lang.*;
class Parse
{

	private Stack<Tree> operand;
	private Stack<Operator> operator;
	private ExprReader ex;
	ArrayList<Tree> parsed_expr = new ArrayList<Tree>();
	public Parse(String fileName) throws IOException
	{
		this.operator = new Stack<Operator>();
		this.operand = new Stack<Tree>();
		this.ex = new ExprReader(fileName);
	}
	public void readNode() throws IOException
	{
		String expr;
		while ((expr = ex.Read()) != null)
		{
			StringTokenizer st = new StringTokenizer(expr);
			while (st.hasMoreTokens())
			{
				expr = st.nextToken();
				if (expr.equals("="))
					operator.push(new OperatorEqual("=") );
				if (expr.equals("+"))
					operator.push(new OperatorPlus("+") );
				if (expr.equals("*"))
					operator.push( new OperatorStar("*") );
				if ((Character.isLetter(expr.toCharArray()[0])) && (!expr.equals("true") && !expr.equals("false")))
					operand.push( new Tree( new Variable(expr)) );
				if (Character.isDigit(expr.toCharArray()[0]))
					operand.push( new Tree(new Value(expr)) );
				if (expr.equals("true"))
					operand.push( new Tree(new Value(expr)) );
				if (expr.equals("false"))
					operand.push(new Tree (new Value(expr)) );
			}

		makeTree(operand, operator);

		treetoArray();

	}
	}


	public void treetoArray()
	{
		while (!operand.empty())
			parsed_expr.add(operand.pop());	
	}
	
	public static void makeTree(Stack<Tree> operand, 
								Stack<Operator> operator)
	{
		while(!operator.empty())
		{
			Tree val = operand.pop();
			Operator op = operator.pop();
			if (!operator.empty() && 
				(op.getPriority() <	operator.peek().getPriority()))
			{
					Tree dr = operand.pop();
					Tree st = operand.pop();
					Operator subop = operator.pop();
					Tree newNode = new Tree(st, dr, subop);
					operand.push(newNode);
					operand.push(val);
					operator.push(op);
			}
			else
			{
					Tree st = operand.pop();
					Tree newNode = new Tree(st, val , op);
					operand.push(newNode);
			}
		}
	}
}
