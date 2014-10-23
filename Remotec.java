import java.io.*;
import java.rmi.*;
import java.lang.String;
import java.net.*;
public class Remotec 
{
	public static void main(String args[])
	{
		int P;
		try
		{		 
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the port address");
		P=Integer.parseInt(br.readLine());
		Socket s=new Socket("localhost",P);
		String cmd;
                DataOutputStream out=new DataOutputStream(s.getOutputStream());
		DataInputStream is1=new DataInputStream(s.getInputStream());
		System.out.println("Enter the command");
		cmd=br.readLine();
		out.writeUTF(cmd);
		cmd=is1.readUTF();
		System.out.println(cmd);
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
		}
	}
}
