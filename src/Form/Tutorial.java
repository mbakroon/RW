/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.border.Border;
/**
 *
 * @author Maxim Neumann
 */
public class Tutorial extends JFrame {
    private JPanel upperPanel = new JPanel();
    private JPanel textArea = new JPanel();
    private JPanel mainPanel = new JPanel();
    private JLabel upperLabel = new JLabel();
    private JLabel lowerLabel = new JLabel();
    private JLabel imageLabel;
    private JLabel robotLabel;
    private JLabel gifLabel = new JLabel();
    private JButton verstandenButton = new JButton();
    private ArrayList<String> upperList;// = new ArrayList<String>();
    private ArrayList<String> lowerList;
    private int i = 0;
    private int[] xPos;// = {660,40,825,50,140,80};
    private int[] yPos;// = {660,40,825,50,140,80};
    private ArrayList<String> imagePaths;

public Tutorial(int[] xPos, int[] yPos) {
        
        setAlwaysOnTop(true);
        this.xPos = xPos;
        this.yPos = yPos;        
        i = 0;            
        setSize(400,215);
        setLocationRelativeTo(null);
        setArrayLists();
        setUndecorated(true);
        setResizable(false);
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //Gif - Label
        gifLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/tut_background2.gif")));
        verstandenButton.setFont(new Font("Garamond", Font.ITALIC, 18));
        //verstandenButton.setBounds(150, 10, 50, 50);
        //roundbtn.paintBorder(verstandenButton, null, 0, 0, 350, 30);
        verstandenButton.setOpaque(false);
        upperLabel.setFont(new Font("Century", 1, 19));
        upperLabel.setForeground(Color.WHITE);
        lowerLabel.setFont(new Font("Lucida Bright", 1, 18));
        verstandenButton.setFont(new Font("Arial", 1, 18));
        upperLabel.setText("Starte das Tutorial");
        lowerLabel.setText("<html>\"Das beste Training liegt immer noch <br>im selbständigen Machen.\" <br>- Cyril Northcote Parkinson</html>");
        Dimension size = lowerLabel.getPreferredSize();
        int wdt = size.width;
        int hgt = size.height;
        verstandenButton.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseClicked(MouseEvent me) {
                if (i < 7) {
                    if (i == 0 || i == 1 || i == 4){
                        lowerLabel.setFont(new Font("Lucida Bright", 1, 13));
                    } else if (i == 6) {
                        lowerLabel.setFont(new Font("Lucida Bright", 1, 10));
                    } else if (i == 3){
                        lowerLabel.setFont(new Font("Lucida Bright", 1, 12));
                    } else if (i == 2){
                        lowerLabel.setFont(new Font("Lucida Bright", 1, 13));
                    } else if (i == 5){
                        lowerLabel.setFont(new Font("Lucida Bright", 1, 14));
                    } else {
                        lowerLabel.setFont(new Font("Lucida Bright", 1, 16));
                    }
                    imageLabel.setBounds(170,80,wdt,hgt);
                    imageLabel.setIcon(new ImageIcon(getClass().getResource(imagePaths.get(i))));
                    verstandenButton.setText("Verstanden!");
                    verstandenButton.requestFocus();

                    upperLabel.setText(upperList.get(i));
                    lowerLabel.setText(lowerList.get(i));
                    setLocation(xPos[i], yPos[i]);
                    i++;
                } else {
                    setVisible(false);
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                verstandenButton.setBackground(Color.BLACK);
                
            }

            @Override
            public void mouseExited(MouseEvent me) {
                verstandenButton.setBackground(Color.RED);
            }
        }) ;
        upperPanel.setLayout(new BorderLayout());
        upperPanel.setBackground(new Color(34,79,44));
        upperPanel.add(upperLabel,BorderLayout.EAST);
        robotLabel = new JLabel("");
        robotLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/tut_robot.png")));
        upperPanel.add(robotLabel,BorderLayout.WEST);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(17,15,17));
        mainPanel.add(upperPanel,BorderLayout.NORTH);
        verstandenButton.setBackground(Color.RED);
        verstandenButton.setForeground(Color.WHITE);
        verstandenButton.setText("Verstanden!");
        verstandenButton.setText("Starten!");
        verstandenButton.setEnabled(true);
        
        mainPanel.add(verstandenButton,BorderLayout.SOUTH);
        lowerLabel.setForeground(new Color(-1));
        lowerLabel.setBounds(/*150,100*/0,0,size.width,size.height);
        gifLabel.add(textArea, BorderLayout.NORTH);
        setLocation(100,100);
        imageLabel = new JLabel("");
        imageLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/tut_run2.png")));//tut_run
        imageLabel.setBounds(/*150,100*/0,80,size.width,size.height);
        gifLabel.add(imageLabel,BorderLayout.CENTER);
        mainPanel.add(/*textArea*/gifLabel,BorderLayout.CENTER);
        /*textArea*/gifLabel.add(lowerLabel, BorderLayout.NORTH);
        //textArea.setBackground(new Color(-9868951));
        setLocationRelativeTo(null);
        setVisible(true);
    }



public void setArrayLists() {
        upperList = new ArrayList<String>();
        upperList.add("Wichtige Informationen");
        upperList.add("Timer");//Background_timerBox
        upperList.add("Verschlüsselung");//jScrollPane_ProgressBars
        upperList.add("Entschlüsseln - Eingabe");//jTextField_decryting
        upperList.add("Entschlüsseln - Bestätigen");//Submit_Button
        upperList.add("Demo Beschleunigen");//skipTimer_Button
        upperList.add("Zurück zum Menü");//Back
        lowerList = new ArrayList<String>();
        lowerList.add("<html>Bitte lesen Sie sich den Erklärungstext durch, um sich über potentielle Sicherheitsrisiken bewusst zu werden.</html>");
        lowerList.add("<html>Der Timer verrät, wie viel Zeit Sie noch haben, um das Lösegeld zu zahlen. Danach würden im Ernstfall die verschlüsselten Daten für immer verschlüsselt bleiben.</html>");
        lowerList.add("<html>Die Dateien werden nacheinander alle 60 Sekunden verschlüsselt. Wenn der Balken auf 100 % ist, ist die Datei verschlüsselt.</html>");
        lowerList.add("<html>Hier geben Sie bitte zum Entschlüsseln der Dateien den Schlüssel “BitteEntsperren!“ ein.</html>");
        lowerList.add("<html>Bestätigen Sie Ihre Eingabe. Nach dem Bestätigen werden Ihre Daten entschlüsselt. Im Ernstfall müssten Sie für den Schlüssel Lösegeld bezahlen.</html>");
        lowerList.add("<html>Mit einem Klick überspringen Sie die Demo. Es werden dabei alle (übrig gebliebenen) Dateien verschlüsselt. Der Timer läuft danach nur noch 10 Sekunden.</html>");
        lowerList.add("<html>Mit einem Klick gelangen Sie zurück ins Menü. Sie sind dort dazu eingeladen unsere anderen spannenden Inhalte zu beäugen. Doch bitte schauen Sie sich zuerst die Demo im Detail an und vergewissern Sie sich ob Ihre Daten in dem Ordner \"meinSehrWichtigerOrdner\" verschlüsselt worden sind.</html>");
        imagePaths = new ArrayList<String>();
        imagePaths.add("/Icons/tut_read.png");
        imagePaths.add("/Icons/tut_timer2.png");
        imagePaths.add("/Icons/tut_encr.png");
        imagePaths.add("/Icons/tut_decr.png");
        imagePaths.add("/Icons/tut_subm.png");
        imagePaths.add("/Icons/tut_uebers.png");
        imagePaths.add("/Icons/tut_back3.png");

    }


}
