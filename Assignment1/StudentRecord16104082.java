package assignment1;

import java.io.BufferedReader;
import java.io.*;


public class StudentRecord16104082 {
	 
	String print(String s[],int l) {
		//UTILITY FUNCTION TO GET THE ARRAY TO BE OUTPUT TO RESULT FILE
		int total=0;
		String res=s[0] +"  ";
		
		for(int i=1;i<l;i++) {
			if(Integer.parseInt(s[i])<10) {
				res=res+" " +s[i] + "  ";
			}
			else res=res+s[i]+"  ";
			if(i>=2 && i<12) {
				//CALCULATE TOTALMARKS OF ALL ASSIGNMENTS
				total+=Integer.parseInt(s[i]);
			}
			//ADD TOTAL MARKS OF ASSIGNMENTS IN OUTPUT STRING
			if(i==11)
				res=res+total+"  ";
		}
		total=total+Integer.parseInt(s[1])+Integer.parseInt(s[12])+ Integer.parseInt(s[13])+ Integer.parseInt(s[14]);
		res=res+total+ "  ";
		//ADD PERCENTAGE IN OUTPUT STRING
		int percentage= getPercent(total-Integer.parseInt(s[14]));
		res=res + percentage+"  ";
		//CALL TO GRADE FUNCTION TO APPEND GRADE IN STRING
		res=res + grade(percentage) + "\n";
		return res;
	}
	
     int getPercent(int marks) {
    	 //UTILITY FUNCTION TO CONVERT PERCENTAGE TO INTEGER BY ROUNDOF
		float percentage= (float)(((float)marks/420.0)*100.0);
		float y=percentage - (int)percentage;
		int result;
		if(y>=0.5) {
			result=(int)percentage+1;
		}
		else result=(int)percentage;
		return result;
	}
	
	
    String grade(int percentage) {
    	//UTILITY FUNCTION TO CALCULATE GRADE
		if(percentage >=90) 
			return "A";
		else if(percentage>=78)
			return "B";
		else if(percentage>=62)
			return "C";
		else if(percentage>=46)
			return "D";
		else return "E";
	}
	
	
	public static void main(String args[]) throws IOException,Exception{
		
		StudentRecord16104082 record=new StudentRecord16104082();
		
		//I/O FILE READER OBJECT TO READ INPUT FILE
		File input=new File("C:\\Users\\hp\\workspace\\Assignments\\src\\assignment1\\HW1-data.txt");
		BufferedReader bf=new BufferedReader(new FileReader(input));
		File result=new File("C:\\Users\\hp\\workspace\\Assignments\\src\\assignment1\\ResultFile.txt");
		
		//CHECK FOR SUCCESSFUL OPEN OF INPUT FILE
		if(!input.exists()) {
			System.out.print(" ERROR!!! INPUT FILE DOESNOT EXISTS");
		}
		
		//TO CHECK EXISTENCE OF OUTPUT FILE
		if(!result.exists()) {
			result.createNewFile();
		}
	
		//FILE WRITER OBJECTS TO WRITE INTO OUTPUT RESULT FILE
		FileWriter fileWriter =new FileWriter(result);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		String str;
		String pre="Stdnt ID  Ex  ---------------Assignments------------  Tot  Mi Fin  CL  Pts Pct  Gr \n";
		String pre2="--------  --  --------------------------------------  ---  -- ---  --  --- ---  -- \n";
		bufferedWriter.write(pre);
		bufferedWriter.write(pre2);
		
		//READING INPUT FILE LINE BY LINE
		while((str =bf.readLine())!=null) {
			
			String s[]=str.split("\\s+");
			//UTILITY FUNCTION CALL 
			String res=record.print(s,s.length);
			bufferedWriter.write(res);
		}
		
		bufferedWriter.close();
		bf.close();
	}
}
