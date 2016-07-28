package javaApplication;

import java.util.*;
import java.io.*;

public class File_Reader 
{
	public static void main(String[]args)
	{
	List<Integer> list = new ArrayList<Integer>();
	File file = new File("file.txt");
	BufferedReader reader = null;

	try {
	    reader = new BufferedReader(new FileReader(file));
	    String text = null;

	    while ((text = reader.readLine()) != null) {
	        list.add(Integer.parseInt(text));
	    }
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
	        if (reader != null) {
	            reader.close();
	        }
	    } catch (IOException e) {
	    }
	}

	//print out the list
	System.out.println(list);
	Integer[] array = list.toArray(new Integer[list.size()]);
	System.out.println(array[0]);

}
}