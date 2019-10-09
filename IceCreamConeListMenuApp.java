import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
/**
* Rhet Kelly
* 10/14/19
* Project_06
* Gives user options for a cone.
*/

public class IceCreamConeListMenuApp
{
/**
* @param args Command line arguments (not used).
* @throws FileNotFoundException for scanning file.
*/

   public static void main(String[] args) throws FileNotFoundException
   {
      char choice = 'Q';
      String labelIn = "";
      double radiusIn = 0;
      double heightIn = 0;
      String fileName = "";
   
      String coneListName = "*** no list name assigned ***";
      ArrayList<IceCreamCone> noCone = new ArrayList<IceCreamCone>();
      IceCreamConeList noConeList = new IceCreamConeList(coneListName, noCone);
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Cone List System Menu"
         + "\nR - Read File and Create IceCreamCone List"
         + "\nP - Print IceCreamCone List"
         + "\nS - Print Summary"
         + "\nA - Add IceCreamCone"
         + "\nD - Delete IceCreamCone"
         + "\nF - Find IceCreamCone"
         + "\nE - Edit IceCreamCone"
         + "\nQ - Quit");
      
      do
      {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         choice = scan.nextLine().toUpperCase().charAt(0);
         
         
         
         switch (choice)
         {
            case 'R':
               noConeList.readFile(fileName);
               break;
               
            case 'P':
               System.out.println(noConeList.toString());
               break;
               
            case 'S':
               System.out.println(noConeList.summaryInfo());
               break;
               
            case 'A':
               noConeList.addCone(labelIn, heightIn, radiusIn);
               System.out.println("\t*** IceCreamCone added ***");
               System.out.println("");
               break;
               
            case 'D':
               System.out.print("\tLabel: ");
               labelIn = scan.nextLine();
            
               if (noConeList.deleteCone(labelIn) == null) {
                  System.out.println("\t\"" + labelIn + "\" not found\n");
                 
               }
               else {
                  System.out.println("\t\"" + labelIn + "\" deleted\n");
               }
               break;
               
            case 'F':
               System.out.print("\tLabel: ");
               labelIn = scan.nextLine();
            
               if (noConeList.findCone(labelIn) == null)
               {
                  System.out.println("\t" + labelIn + " not found");
                  System.out.println("");
                  
               }
               else
               {
                  System.out.println(noConeList.findCone(labelIn).toString());
                  System.out.println("");
               }
               break;
               
            case 'E':
               System.out.print("\tLabel: ");
               labelIn = scan.nextLine();
               
               System.out.print("\tRadius: ");
               radiusIn = Double.parseDouble(scan.nextLine());
               
               System.out.print("\tHeight: ");
               heightIn = Double.parseDouble(scan.nextLine());
               
               if (noConeList.findCone(labelIn) == null)
               {
                  System.out.println("\t" + labelIn + " not found");
                  System.out.println("");
               }
               else
               {
                  noConeList.editCone(labelIn, heightIn, radiusIn);
                  System.out.println("\t\""
                     + labelIn + "\" successfully edited");
                  System.out.println("");
               }
               break;
               
            case 'Q':
               
               break;
               
            default:
               System.out.println("\t*** invalid code ***");
               System.out.println("");
         }
      
      } while (choice != 'Q');
   
   
   
   
   }
}