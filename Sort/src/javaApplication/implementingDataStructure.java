package javaApplication;

import java.util.*;


public class implementingDataStructure {
	
    
    public static int[] extractionArray= new int[Integer.SIZE-1];
    
    
    public static int ExtractionCount=extractionArray.length-1;
    public static void main(String argv[])
    {
    	
        implementingDataStructure obj=new implementingDataStructure();
        for(int j=0;j<extractionArray.length;j++)
        {
        	extractionArray[j]=(int)Math.pow(2, j);
        }
        
        List<Integer> arr= new ArrayList<Integer>();
        arr=File_Reader.main(null);
        System.out.println(arr.size());
        System.out.println("Before -> "+arr);
        long start = System.currentTimeMillis( );
        arr= obj.sort(arr,ExtractionCount);
        long end = System.currentTimeMillis( );
        System.out.println("After -> "+arr);
        System.out.println(end-start);
        //System.out.println(arr.size());
     }

  
    public List<Integer> sort(List<Integer> input,int ec)
    {
        Bucket bucket0=new Bucket();
        Bucket bucket1=new Bucket();
        int bucketsize0=0;
        int bucketsize1=0;
        if(input.size()== 1 || ec==-1)
        {
        	//System.out.println("Returning Input");
            return input;
        }
        else
        { 
        for(int i=0;i<input.size();i++)
        {
            if(extractionArray[ec] !=(extractionArray[ec]& input.get(i))) 
            {
                    bucket0.arr.add(input.get(i));
                    bucketsize0=bucket0.arr.size();
            }
            
            else
            {
                    bucket1.arr.add(input.get(i));
                    bucketsize1=bucket1.arr.size();       
            }
         
        }
        ec--;
        if(bucket0.arr.size()!=0)
        {
            bucket0.arr=sort(bucket0.arr,ec);
        }     
        if(bucket1.arr.size()!=0)
        {
        	bucket1.arr=sort(bucket1.arr,ec);
        }
       
        input.clear();
           for(int i=0;i<bucketsize0;i++)
           {
               input.add(i,bucket0.arr.get(i));
               
           }
           for(int i=bucketsize0;i<bucketsize0+bucketsize1;i++)
           {
               input.add(i,bucket1.arr.get(i-bucketsize0));
           }
           return input;
    
        }
    }
}