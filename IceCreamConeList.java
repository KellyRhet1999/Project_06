import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
* Rhet Kelly
* 10/14/19
* Project_06
*
* Displays a list of cones.
*/

public class IceCreamConeList
{
   private String listName;
   private ArrayList<IceCreamCone> coneList;

/**
* @param listNameIn input for the name
* @param coneListIn input for the list
*/

   public IceCreamConeList(String listNameIn, ArrayList<IceCreamCone>
      coneListIn) 
   {
      listName = listNameIn;
      coneList = coneListIn;               
   }

/**
* @return returns the name of the list
*/

   public String getName()
   {
      return listName;
   }
   
   /**
   * @return returns the list size
   */
   
   public int numberOfIceCreamCones()
   {
      return coneList.size();
   }

/**
* @return returns the surface area
*/

   public double totalSurfaceArea()
   {
      double total = 0;
      int index = 0;
      while (index < coneList.size())
      {
         total += coneList.get(index).surfaceArea();
         index++;
      }
      return total;
   }
   
   /**
   * @return returns the total volume
   */
   
   public double totalVolume()
   {
      double total = 0;
      int index = 0;
      while (index < coneList.size())
      {
         total += coneList.get(index).volume();
         index++;
      }
      return total;
   }
   
   /**
   * @return returns average surface area
   */
   
   public double averageSurfaceArea()
   {
      double total = 0;
      int index = 0;
      while (index < coneList.size())
      {
         total += coneList.get(index).surfaceArea();
         index++;
      }
      if (index == 0)
      {
         total = 0;
      }
      else
      {
         total = total / index;
      }
      return total;
   }
   
   /**
   * @return returns the average volume
   */
   
   public double averageVolume()
   {
      double total = 0;
      int index = 0;
      while (index < coneList.size())
      {
         total += coneList.get(index).volume();
         index++;
      }
      if (index == 0)
      {
         total = 0;
      }
      else
      {
         total = total / index;
      }
      return total;
   }
   
   /**
   * @return returns the string
   */
   
   public String toString()
   {
      String result = "\n" + listName + "\n";
      int index = 0;
      while (index < coneList.size())
      {
         result += "\n" + coneList.get(index) + "\n";
         index++;
      }
      return result;
   }
   
   /**
   * @return returns cone information
   */
   
   public String summaryInfo()
   {
      DecimalFormat dFmt = new DecimalFormat("#,##0.0##");
      String result = "";
      return ("----- Summary for " + getName() + " -----")
         + ("\nNumber of IceCreamCone Objects: " + numberOfIceCreamCones())
         + ("\nTotal Surface Area: ") + dFmt.format(totalSurfaceArea())
         + ("\nTotal Volume: ") + dFmt.format(totalVolume())
         + ("\nAverage Surface Area: ") + dFmt.format(averageSurfaceArea())
         + ("\nAverage Volume: ") + dFmt.format(averageVolume())
         + ("");
   }
   
   /**
   * @return array list of ice cream cones.
   */
   
   public ArrayList<IceCreamCone> getList()
   {
      return null;
   }
   
   /**
   * @throws FileNotFoundException for reading the file.
   * @param file is the file name.
   * @return returns the list
   */
   
   public IceCreamConeList readFile(String file) throws FileNotFoundException
   {
      Scanner scan = new Scanner(System.in);
   
      String fileName = "";
      System.out.print("\tFile Name: ");
      fileName = scan.nextLine();
      Scanner scanFile = new Scanner(new File(fileName));
      listName = scanFile.nextLine();
      if (new File(fileName) == null)
      {
         return null;
      }
      while (scanFile.hasNext())
      {
         String labelIn = scanFile.nextLine();
         double radiusIn = Double.parseDouble(scanFile.nextLine());
         double heightIn = Double.parseDouble(scanFile.nextLine());
      
         IceCreamCone newCone = new IceCreamCone(labelIn, radiusIn, heightIn);
         coneList.add(newCone);
      }
      
      String listTitle = "";
      IceCreamConeList newConeList = new IceCreamConeList(listTitle, coneList);
      System.out.println("\tFile read in and IceCreamCone List created");
      System.out.println("");
      return newConeList;
   
   }
   
   /**
   * @param labelIn is the label.
   * @param radiusIn is the radius.
   * @param heightIn is the height.
   */
   
   public void addIceCreamCone(String labelIn, double radiusIn, double heightIn)
   {
      Scanner scan = new Scanner(System.in);
   
      IceCreamCone coneAdd = new IceCreamCone(labelIn, radiusIn, heightIn);
      System.out.print("\tLabel: ");
      labelIn = scan.nextLine();
      coneAdd.setLabel(labelIn);
   
      System.out.print("\tRadius: ");
      radiusIn = scan.nextDouble();
      coneAdd.setRadius(radiusIn);
   
      System.out.print("\tHeight: ");
      heightIn = scan.nextDouble();
      coneAdd.setHeight(heightIn);
      coneList.add(coneAdd);
   
   }
   
   /**
   * @param labelIn is the label.
   * @return returns the result.
   */
   
   public IceCreamCone findIceCreamCone(String labelIn)
   {
      IceCreamCone result = null;
      int index = -1;
      for (IceCreamCone t : coneList)
      {
         if (t.getLabel().equalsIgnoreCase(labelIn))
         {
            index = coneList.indexOf(t);
            break;
         }
      }
      
      if (index >= 0)
      {
         result = coneList.get(index);
      }
      return result;
   }
   /**
   * @param labelIn is the label.
   * @return returns the result.
   */
   
   public IceCreamCone deleteIceCreamCone(String labelIn)
   {
      IceCreamCone result = null;
      for (int i = 0; i < coneList.size(); i++) {
         if (coneList.get(i).getLabel().equalsIgnoreCase(labelIn)) {
            result = coneList.get(i);
            coneList.remove(i);
         }
      }
      return result;
   }
   
   /**
   * @param labelIn is the label.
   * @param radius is the radius.
   * @param height is the height.
   * @return returns the result.
   */
   
   public boolean editIceCreamCone(String labelIn, double radius, double height)
   {
      IceCreamCone result = null;
      int index = -1;
      for (IceCreamCone t : coneList)
      {
         if (t.getLabel().equalsIgnoreCase(labelIn))
         {
            index = coneList.indexOf(t);
            break;
         }
      }
   
      if (index >= 0)
      {
         result = coneList.get(index);
         result.setRadius(radius);
         result.setHeight(height);
         return true;
      }
      return false;
   }
   

}