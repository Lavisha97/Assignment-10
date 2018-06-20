import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

class ListFilesUtil
{   
	static int i = 0 ;
	public void listFiles(String directoryName , ArrayList al) throws IOException
	{
		File directory = new File(directoryName);
		File[] fList = directory.listFiles();

		for (File file : fList)
		{
			String a = file.toString();
			if(file.isDirectory()==true)
			{
				listFiles(a,al);
			}
			else if (file.isFile())
			{
				try {
					//System.out.println(file.getName());

					String c = (file.getName()).toString();
					String d = file.toString();

					al.add(c);
					al.add(d);
					
					i = i + 2;

				}

				finally 
				{

				}
			}
		}
	}

	public static void main (String[] args) throws IOException
	{

		File fout = new File("E:\\Java1\\file.csv");
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(fos));

		ListFilesUtil LF = new ListFilesUtil();
		Scanner sc = new Scanner(System.in);
		//String path ="E://Assignment 9";
		System.out.println("Enter a path.. Eg: E:\\Assignment 9");
		String path = sc.nextLine();
		ArrayList<String> al=new ArrayList<String>();



		try 
		{
			LF.listFiles(path , al);
		}
		catch(Exception e)
		{
			System.out.println("Wrong Input");
		}
		finally
		{
			System.out.println("Thank you. Please see the CSV File");
		}

		buffer.write("Filename" +" , " + "Filepath");
		buffer.newLine();
		for(int j = 0 ; j < i ; j = j +2)
		{
			buffer.write(al.get(j) +" , " + al.get(j+1));
			buffer.newLine();
		}
		buffer.close();
	}
}