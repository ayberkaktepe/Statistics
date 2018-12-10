/*
 * first row:weight
 * second row:value
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class weightedarithmeticmean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        File file = new File("sample.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            
            List<String[]> list = new ArrayList<>();                
            String temp = null;
            while ((temp = bufferedReader.readLine()) != null) {
                list.add(temp.trim().split(" "));
            }
            
            double[][] array = new double[list.size()][];
            for (int i = 0; i < array.length; i++) {                    
                array[i] = new double[list.get(i).length];
                
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = Integer.parseInt(list.get(i)[j]);
                }
            }
            
            //
            
            double sumxy=0;
            double sumx=0;
            for(int i=0; i<array[0].length; i++) {
            	sumx=array[0][i];
            	sumxy+=array[0][i]*array[1][i];
            }
            double weightedarithmeticmean=sumxy/sumx;
            System.out.println("Weighted Arithmetic Mean="+weightedarithmeticmean);
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
