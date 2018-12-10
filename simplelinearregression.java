/*
 * x values to first row
 * y values to the second row
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class simplelinearregression {
	
    public static void main(String[] args) {   
    	
    	//reading text file and converting to array
        File file = new File("sample.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            List<String[]> list = new ArrayList<>();                
            String temp = null;
            while ((temp = bufferedReader.readLine()) != null) 
                list.add(temp.trim().split(" "));            
            double[][] array = new double[list.size()][];
            for (int i = 0; i < array.length; i++) {                    
                array[i] = new double[list.get(i).length];
               for (int j = 0; j < array[i].length; j++) 
                    array[i][j] = Integer.parseInt(list.get(i)[j]);
            }
            
            //Calculating a and b values
            double sumx=0;
            double sumy=0;
            double sumxy=0;
            double sumxexp2=0;
            for(int i=0; i<array[0].length; i++) {
            	sumx+=array[0][i];
            	sumy+=array[1][i];
            	sumxy+=(array[0][i]*array[1][i]);
            	sumxexp2+=(array[0][i]*array[0][i]);
            }
            double b=((array[0].length*sumxy)-(sumx*sumy))/(array[0].length*sumxexp2-(sumx*sumx));
            double a=(sumy/array[0].length)-b*(sumx/array[0].length);
            System.out.println("a="+a+" b="+b+" yi=a+bi");
            Scanner scan=new Scanner(System.in);
            System.out.println("please enter i value");
            int i=scan.nextInt();
            System.out.println("y"+i+"="+(a+b*i));                   
            	
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }    
}