package javaApplication;
import java.util.*;
import java.io.*;

public class File_Reader {
	
    public static List<Integer> main(String args[])
    {
        List<Integer> list = new ArrayList<Integer>();
	
	BufferedReader reader = null;

	try {
	    reader = new BufferedReader(new FileReader("50k.txt"));
	    String text = null;

	    while ((text = reader.readLine()) != null) {
                String[] strs = text.trim().split("\\s+");
                for (int i = 0; i < strs.length; i++) {
                list.add(Integer.parseInt(strs[i]));
                }
	        
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
	//System.out.println(list.size());
	//Integer[] array = list.toArray(new Integer[list.size()]);
	//System.out.println(array[0]);
        return list;
        
    }
    
}