import java.io.*;
import java.net.*;
import java.lang.Runtime;
import java.lang.Object;
public class Remotes
{
	public static void main(String args[])
	{
		int P;
		String cmd1[]=new String[3];
		cmd1[0]="/bin/sh";
		cmd1[1]="-c"; 
		try
		{
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the port address");
		P=Integer.parseInt(br.readLine());
		ServerSocket ss=new ServerSocket(P);
		Socket s=ss.accept();
		DataInputStream is1=new DataInputStream(s.getInputStream());
		OutputStream out=s.getOutputStream();
                BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
		cmd1[2]=is1.readUTF();
               	Runtime r=Runtime.getRuntime();
		Process p1=r.exec(cmd1);
		BufferedReader br2=new BufferedReader(new InputStreamReader(p1.getInputStream()));
		String str1,str2="";
		DataOutputStream out1=new DataOutputStream(out);
		while((str1=br2.readLine())!=null)
		str2=str2+str1+"\n"; 
		out1.writeUTF(str2);
		System.out.println("The command is" +cmd1[2]);
		s.close();
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
		}
		
	}
}	

