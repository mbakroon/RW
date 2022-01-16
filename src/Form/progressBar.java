/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author m.bakroon
 */
public class progressBar {
    // This is the progressbar class
   private JProgressBar b ;
   private JLabel l;
   public static int x=40; 
   public static int y=0 ;

    public progressBar() {
        buildProgressBar();
    }
   
   

   public void buildProgressBar(){
       //the location of ProgressBar in jPanel
        y+=20;
     
        b = new JProgressBar();
        b.setValue(0);
        b.setBorderPainted(true);
        b.setStringPainted(true);
        b.setLocation(x, y);
        b.setSize(120, 20);
        b.setVisible(true);
   }

    public JProgressBar getProgressBar(){
        return b;
    }

}
