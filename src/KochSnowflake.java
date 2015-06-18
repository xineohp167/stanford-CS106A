/*
 * File: KochSnowflake.java
 * ------------------------
 * This program demonstrates the use of the GPen class by drawing
 * a Koch fractal snowflake.
 */
 
import acm.program.*;
import acm.graphics.*;
import java.awt.*;
 
public class KochSnowflake extends GraphicsProgram {
 
/** Runs the program to create the snowflake display */
   public void run() {
      double width = getWidth();
      double height = getHeight();
      pen = new GPen();
      add(pen, width / 2, height / 2);
      drawKochFractal(EDGE_FRACTION * Math.min(width, height), ORDER);
   }
 
/*
 * Draws a snowflake fractal centered at the current pen position.
 * The edge parameter indicates the length of any of an edge on the
 * order 0 fractal, which is simply a triangle.  The order parameter
 * specifies the number of levels of recursive decomposition.
 */
   private void drawKochFractal(double edge, int order) {
      pen.move(-edge / 2, -edge / (2 * Math.sqrt(3)));
      drawFractalLine(edge, 0, order);
      drawFractalLine(edge, -120, order);
      drawFractalLine(edge, +120, order);
   }
 
/*
 * Draws a fractal line that extends r pixels in the direction theta.
 */
   private void drawFractalLine(double r, int theta, int order) {
      if (order == 0) {
         pen.drawPolarLine(r, theta);
      } else {
         drawFractalLine(r / 3, theta, order - 1);
         drawFractalLine(r / 3, theta + 60, order - 1);
         drawFractalLine(r / 3, theta - 60, order - 1);
         drawFractalLine(r / 3, theta, order - 1);
      }
   }
 
/* Private constants */
   private static final double EDGE_FRACTION = 0.75;
   private static final int ORDER = 3;
 
/* Private instance variables */
   private GPen pen;
} 