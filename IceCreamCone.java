import java.text.DecimalFormat;
/**
* Rhet Kelly
* 09/20/19
* Project_04
*
* Displays values about a given cone.
*/

public class IceCreamCone
{
// fields
/**
* Initialize variables.
*/

   private String label = "";
   private double radius = 0.0;
   private double height = 0.0;

// constructor
/**
* Sets values for a cone.
* @param labelIn is the label inputed by user.
* @param heightIn is the height inputed by user.
* @param radiusIn is the radius inputed by user.
*/

   public IceCreamCone(String labelIn, double radiusIn, double heightIn)
   {
      setLabel(labelIn);
      setRadius(radiusIn);
      setHeight(heightIn);
   
   }
   // methods
   /**
   * Gets the label string.
   * @return returns the label of the ice cream cone.
   */
   public String getLabel()
   {
      return label;
   }
   
   /**
   * Sets the label of the cone.
   * @param labelIn is the label entered by the user.
   * @return returns true or false.
   */
   
   public boolean setLabel(String labelIn)
   {
      if (labelIn == null)
      {
         return false;
      }
      else
      {
         label = labelIn.trim();
         return true;
      }
   }
   
   /**
   * Gets the height of the cone.
   * @return returns the height.
   */
   public double getHeight()
   {
      return height;
   }
   
   /**
   * Sets the height.
   * @param heightIn is the height.
   * @return returns true or false for the height.
   */
   public boolean setHeight(double heightIn)
   {
      boolean isSet = false;
      if (heightIn > 0)
      {
         height = heightIn;
         return true;
      }
      return isSet;
   }
   
   /**
   * Gets the radius.
   * @return returns the radius.
   */
   
   public double getRadius()
   {
      return radius;
   }
   
   /**
   * Sets the radius.
   * @param radiusIn is the radius entered by the user.
   * @return returns true or false depending on the radius.
   */
   
   public boolean setRadius(double radiusIn)
   {
      boolean isSet = false;
      if (radiusIn > 0)
      {
         radius = radiusIn;
         return true;
      }
      return false;
      
   }
   
   
   /**
   * Find the surface area of both the hemisphere and the cone.
   * @return returns the surface area.
   */
   
   public double surfaceArea()
   {
      double surfaceArea = (((radius) * (Math.PI)) 
          * (Math.sqrt(Math.pow(height, 2) 
          + Math.pow(radius, 2)))) + (Math.pow(radius, 2) 
           * Math.PI * 2);
      return surfaceArea;
   }
   
   
   /**
   * Find the total volume of the two objects.
   * @return returns the total volume.
   */
   
   public double volume()
   {
      double volume = (((height * Math.PI) 
         * (Math.pow(radius, 2))) / 3) + ((2 * Math.PI 
         * (Math.pow(radius, 3))) / 3);
      return volume;
   }
   
   /**
   * Print information about the cone.
   * @return returns the information.
   */
   
   public String toString()
   {
      DecimalFormat dFmt = new DecimalFormat("#,##0.0######");
      return "IceCreamCone " + "\"" + label + "\" with radius = "
         + dFmt.format(radius) + " and height = "
         + dFmt.format(height) + " units has: \n"
         + "\tsurface area = " + dFmt.format(surfaceArea())
         + " square units\n" + "\tvolume = "
         + dFmt.format(volume()) + " cubic units";
   }
   

}