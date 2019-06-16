package employeeApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class testEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> emplist = readDataFromCSV("src/us-500.csv");
		int num;
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter your choice, 1.read csv, 2.sort firtst name, 3. find new york city");
		num=scanner.nextInt();
		
		switch(num)
		{
			
			case 1:
				
	        for (Employee b : emplist) 
	        {
	        	
	            System.out.println(b);
	        }
	        break;
	        
			case 2:
	        for (Employee c : emplist)
	        	
	        {
	    		if(c.getCity().equals("\"New York\""))
	    		{
	    			System.out.println(c.getFirst_name()+""+c.getLast_name()+""+c.getCity());
	    		}
	    	}
	        break;	
			case 3 :
	        List<Employee> sort= sortEmpDet(emplist);
	        
	        for (Employee b : emplist) 
	        	{
	            System.out.println(b.getFirst_name());
	            }
	        break;
	        
	        default:
	        	System.out.println("Invalid Option");
	        break;
		}
	}

    private static List<Employee> readDataFromCSV(String fileName) {
        List<Employee> empList = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            String line = br.readLine();

            while (line != null) {
                String[] mData = line.split(",");

                Employee empL = createEmp(mData);
                empList.add(empL);
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return empList;
    }

	private static Employee createEmp(String[] mData) 
	
	
	{
		// TODO Auto-generated method stub
		 	String firstName = mData[0];
	        String lastName = mData[1];
	        String companyName = mData[2];
	        String cAddress = mData[3];
	        String cCity = mData[4];
	        String cCountry = mData[5];
	        String cState = mData[6];
	        String zipc = mData[7];
	        String ph1 = mData[8];
	        String ph2 = mData[9];
	        String cEmail = mData[10];
	        String cWeb = mData[11];
	        
	        return new Employee ( firstName,lastName,companyName, cAddress,cCity, cState, zipc, ph1, ph2,cEmail, cWeb, cWeb);
	        
	        
		
	}

	  public static List<Employee> sortEmpDet(List<Employee> l)
      
      {
   	   for (int i=0;i<l.size()-1; i++)
   	   {
   		   for (int j=0;j<l.size()-1; j++)
   		   {
   			   if(l.get(i).getFirst_name().compareTo(l.get(j).getFirst_name())<0)
   			   {
   				   Collections.swap(l, i, j);
   			   }
   		   }
      }
		return l;
      }


}
