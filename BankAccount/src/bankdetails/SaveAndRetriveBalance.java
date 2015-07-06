package bankdetails;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SaveAndRetriveBalance {
	 public SaveAndRetriveBalance(){
	 }
	 
	HashMap<String,String> hm;
    public SaveAndRetriveBalance(int accountnumber, double balance){
        hm=new HashMap<String,String>();
        String stringaccountnumber=String.valueOf(accountnumber);
        String stringbalance=String.valueOf(balance);
        hm.put(stringaccountnumber,stringbalance);
        
        writefile(hm);

    }
    public double depositMoney(int accountNumber){
    	
        String stringaccountnumber=String.valueOf(accountNumber);
       
        readfile(hm);
            if(hm.containsKey(stringaccountnumber))
            {
            	
                Object value=hm.values();
				return (double) value;
            }
            else{
            return 0.0;
            }
    }
    
    public boolean check(int accountNumber){
    	String stringaccountnumber=String.valueOf(accountNumber);
        
        readfile(hm);
            if(hm.containsKey(stringaccountnumber))
            {
            	return true;
            }
            else{
            return false;
            }
	
    	
    }

public void writefile(HashMap<String,String> map){
    //write to file : "fileone"
    try{
    File fileTwo=new File("filetwo.txt");
    FileOutputStream fos=new FileOutputStream(fileTwo, true);
        PrintWriter pw=new PrintWriter(fos);

        for(Map.Entry<String,String> m :map.entrySet()){
            pw.println(m.getKey()+"="+m.getValue());
        }

        pw.flush();
        pw.close();
        fos.close();
    }catch(Exception e){}
}
public void readfile(HashMap<String,String> map){
    //read from file 
    try{
        File toRead=new File("filetwo.txt");
        FileInputStream fis=new FileInputStream(toRead);

        Scanner sc=new Scanner(fis);

        HashMap<String,String> mapInFile=new HashMap<String,String>();

        //read data from file line by line:
        String currentLine;
        while(sc.hasNextLine()){
            currentLine=sc.nextLine();
            //now tokenize the currentLine:
            StringTokenizer st=new StringTokenizer(currentLine,"=",false);
            //put tokens ot currentLine in map
            mapInFile.put(st.nextToken(),st.nextToken());
        }
        fis.close();

        //print All data in MAP
        for(Map.Entry<String,String> m :mapInFile.entrySet()){
            System.out.println(m.getKey()+" : "+m.getValue());
        }
    }catch(Exception e){}
  }

public static void main(String args[]){
        

}
}
