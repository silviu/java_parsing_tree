import java.io.*;
class ExprReader
{
	private BufferedReader in;
	private static final char[] ws = {'\t', '\n', ' ', '\r'};
	ExprReader(String fileName) throws IOException
	{
		this.in = new BufferedReader(new FileReader(fileName));
	}

	public String Read() throws IOException
	{
		String expr = "null";
		expr = in.readLine();
		return expr;
	}
}
