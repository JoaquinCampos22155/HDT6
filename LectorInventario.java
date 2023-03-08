import java.io.File;
 import java.util.Map;
 import java.util.Scanner;
 
 public class  LectorInventario {
 
     public void getInventory(Map <Integer, Objeto> productoTree, String filename) {
         try {
                Scanner input = new Scanner(new File(filename));
                int i = 1;
                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    String[] tokens = line.split(" \\|	");
                    productoTree.put(i, new Objeto(tokens[1], tokens[0], 55));
                    i++;
                }
                input.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }
}