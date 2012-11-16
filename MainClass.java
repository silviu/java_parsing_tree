import java.io.*;
import java.util.*;

class MainClass
{
	public static void main(String[] argv)
	{
		try
		{
		for( int i = 0; i < argv.length; i++ )
		{
			Parse bla = new Parse(argv[i]);
			bla.readNode();
			SemanticVisitor sv = new SemanticVisitor(bla.parsed_expr);
			sv.semanticEvaluator(argv[i]);
			Error.printMsg(argv[i]);
			if (!Error.semanticError)
			{
				ResultVisitor rv = new ResultVisitor(bla.parsed_expr);
				rv.resultEvaluator();
			}

		}
		}
		catch (Exception e)
		{
			e.printStackTrace(System.err);
		}

	}//~ main class endtag
}//~MainClass class endtag
