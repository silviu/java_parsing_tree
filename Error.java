import java.io.*;
public class Error
{
	public static boolean semanticError;
	public static String msg = "";
	public static void add(String err)
	{
		msg += err + "\n";
		semanticError = true;
	}
	public static void printMsg(String fileName) throws Exception
	{
		PrintStream out = new PrintStream(new FileOutputStream(fileName + "_sv"));
		out.println(msg);
	}
}
