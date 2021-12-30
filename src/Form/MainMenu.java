/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author m.Bakroon
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    // This is mainmenu class
    public MainMenu() {
        initComponents();
        this.setResizable(false);
    


    }   
     private void labelcolor(JLabel label) {
        label.setBackground(new java.awt.Color(53, 162, 107));
    }

    private void resetlabelcolor(JLabel label) {
        label.setBackground(new java.awt.Color(54, 70, 78));
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
        jLabel1 = new javax.swing.JLabel();
        OP_CloseSideBar = new javax.swing.JLabel();
        jPanel_SideBar = new javax.swing.JPanel();
        jPanel_Six_hour = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        demo_six_hour = new javax.swing.JLabel();
        jPanel_Dashboard = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        DashboardLabelSideBar = new javax.swing.JLabel();
        jPanel_Members = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        MembersLabelSidebar = new javax.swing.JLabel();
        jPanel_Report = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        ReportLabelSidebar = new javax.swing.JLabel();
        jPanel_Collections = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        CollectionLabelSideBar = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        sideBarText = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        navBar = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        dynamicPanel = new javax.swing.JPanel();
        Dashboard = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        dashboardLabel = new javax.swing.JLabel();
        Demo6Stunde = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        Demo6 = new javax.swing.JLabel();
        Members = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        MemberLabel1 = new javax.swing.JLabel();
        Collections = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        CollectionLabel2 = new javax.swing.JLabel();
        Report = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        ReportLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        MainJPanel.setBackground(new java.awt.Color(204, 204, 255));
        MainJPanel.setMinimumSize(new java.awt.Dimension(1000, 625));
        MainJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/background2 copy1000_625.jpg"))); // NOI18N
        MainJPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 55, 790, 570));

        OP_CloseSideBar.setBackground(new java.awt.Color(54, 70, 78));
        OP_CloseSideBar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OP_CloseSideBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-menu-30.png"))); // NOI18N
        OP_CloseSideBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OP_CloseSideBar.setOpaque(true);
        OP_CloseSideBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OP_CloseSideBarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OP_CloseSideBarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OP_CloseSideBarMouseExited(evt);
            }
        });
        MainJPanel.add(OP_CloseSideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 40, 20));

        jPanel_SideBar.setBackground(new java.awt.Color(54, 70, 78));
        jPanel_SideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_Six_hour.setBackground(new java.awt.Color(54, 70, 78));
        jPanel_Six_hour.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-magazine-23.png"))); // NOI18N
        jPanel_Six_hour.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, 40, 30));

        demo_six_hour.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        demo_six_hour.setForeground(new java.awt.Color(255, 255, 255));
        demo_six_hour.setText("Demo 6 Stunde");
        demo_six_hour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        demo_six_hour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                demo_six_hourMouseClicked(evt);
            }
        });
        jPanel_Six_hour.add(demo_six_hour, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 140, 20));

        jPanel_SideBar.add(jPanel_Six_hour, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 210, 40));

        jPanel_Dashboard.setBackground(new java.awt.Color(54, 70, 78));
        jPanel_Dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-home-page-23.png"))); // NOI18N
        jPanel_Dashboard.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, 40, 30));

        DashboardLabelSideBar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        DashboardLabelSideBar.setForeground(new java.awt.Color(255, 255, 255));
        DashboardLabelSideBar.setText("Dashboard");
        DashboardLabelSideBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardLabelSideBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardLabelSideBarMouseClicked(evt);
            }
        });
        jPanel_Dashboard.add(DashboardLabelSideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 140, 20));

        jPanel_SideBar.add(jPanel_Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 210, 40));

        jPanel_Members.setBackground(new java.awt.Color(54, 70, 78));
        jPanel_Members.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-male-user-23.png"))); // NOI18N
        jPanel_Members.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, 40, 30));

        MembersLabelSidebar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        MembersLabelSidebar.setForeground(new java.awt.Color(255, 255, 255));
        MembersLabelSidebar.setText("Members");
        MembersLabelSidebar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MembersLabelSidebar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MembersLabelSidebarMouseClicked(evt);
            }
        });
        jPanel_Members.add(MembersLabelSidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 140, 20));

        jPanel_SideBar.add(jPanel_Members, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 210, 40));

        jPanel_Report.setBackground(new java.awt.Color(54, 70, 78));
        jPanel_Report.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-increase-23.png"))); // NOI18N
        jPanel_Report.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, 40, 30));

        ReportLabelSidebar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        ReportLabelSidebar.setForeground(new java.awt.Color(255, 255, 255));
        ReportLabelSidebar.setText("Report");
        ReportLabelSidebar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ReportLabelSidebar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReportLabelSidebarMouseClicked(evt);
            }
        });
        jPanel_Report.add(ReportLabelSidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 140, 20));

        jPanel_SideBar.add(jPanel_Report, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 210, 40));

        jPanel_Collections.setBackground(new java.awt.Color(54, 70, 78));
        jPanel_Collections.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-survey-23.png"))); // NOI18N
        jPanel_Collections.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, 40, 30));

        CollectionLabelSideBar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        CollectionLabelSideBar.setForeground(new java.awt.Color(255, 255, 255));
        CollectionLabelSideBar.setText("Collections");
        CollectionLabelSideBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CollectionLabelSideBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CollectionLabelSideBarMouseClicked(evt);
            }
        });
        jPanel_Collections.add(CollectionLabelSideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 140, 20));

        jPanel_SideBar.add(jPanel_Collections, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 210, 40));

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Ransomeware Program");
        jPanel_SideBar.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 486, 160, 20));

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Copyright @ Mohammed Bakroon");
        jPanel_SideBar.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 470, 200, 20));

        MainJPanel.add(jPanel_SideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 55, 210, 570));

        jLabel22.setText("Hello Workd");

        javax.swing.GroupLayout sideBarTextLayout = new javax.swing.GroupLayout(sideBarText);
        sideBarText.setLayout(sideBarTextLayout);
        sideBarTextLayout.setHorizontalGroup(
            sideBarTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
            .addGroup(sideBarTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sideBarTextLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        sideBarTextLayout.setVerticalGroup(
            sideBarTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
            .addGroup(sideBarTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sideBarTextLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        MainJPanel.add(sideBarText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 55, 210, 570));

        navBar.setBackground(new java.awt.Color(1, 8, 33));
        navBar.setForeground(new java.awt.Color(255, 255, 255));

        jLabel23.setForeground(new java.awt.Color(204, 0, 0));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/hacking copy54x54.gif"))); // NOI18N

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Big Caslon", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setLabelFor(navBar);
        jLabel24.setText("Ransomeware Interaktive Lehreinleitung ");

        jLabel25.setForeground(new java.awt.Color(204, 0, 0));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/thief-hacker-locked-victim-compu.jpg"))); // NOI18N

        javax.swing.GroupLayout navBarLayout = new javax.swing.GroupLayout(navBar);
        navBar.setLayout(navBarLayout);
        navBarLayout.setHorizontalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addGap(17, 17, 17)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        navBarLayout.setVerticalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(navBarLayout.createSequentialGroup()
                .addGroup(navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 1, Short.MAX_VALUE))
        );

        MainJPanel.add(navBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 55));

        Dashboard.setPreferredSize(new java.awt.Dimension(790, 570));
        Dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel21.setText("Dashboard");
        Dashboard.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 410, 190));

        dashboardLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/background2 copy1000_625.jpg"))); // NOI18N
        Dashboard.add(dashboardLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 570));

        Demo6Stunde.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel29.setText("jLabel28");
        Demo6Stunde.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 360, 250));

        Demo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/background2 copy1000_625.jpg"))); // NOI18N
        Demo6Stunde.add(Demo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 570));

        Members.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel26.setText("Members");
        Members.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 330, 180));

        MemberLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/background2 copy1000_625.jpg"))); // NOI18N
        Members.add(MemberLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 570));

        Collections.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel27.setText("Collection");
        Collections.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 620, 210));

        CollectionLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/background2 copy1000_625.jpg"))); // NOI18N
        Collections.add(CollectionLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 570));

        Report.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel28.setText("jLabel28");
        Report.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 360, 250));

        ReportLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/background2 copy1000_625.jpg"))); // NOI18N
        Report.add(ReportLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 570));

        javax.swing.GroupLayout dynamicPanelLayout = new javax.swing.GroupLayout(dynamicPanel);
        dynamicPanel.setLayout(dynamicPanelLayout);
        dynamicPanelLayout.setHorizontalGroup(
            dynamicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Members, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Report, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Collections, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Demo6Stunde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        dynamicPanelLayout.setVerticalGroup(
            dynamicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Members, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Report, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Collections, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Demo6Stunde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        MainJPanel.add(dynamicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 55, 790, 570));

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
    int x = 210;
    Thread th;
    private void OP_CloseSideBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OP_CloseSideBarMouseClicked
        if (x == 210) {
            jPanel_SideBar.setSize(210, 552);

            th = new Thread() {
                @Override
                public void run() {
                    try {
                        for (int i = 210; i >= 0; i--) {
                            Thread.sleep(1);
                            jPanel_SideBar.setSize(i, 552);

                            OP_CloseSideBar.setBackground(new java.awt.Color(255, 255, 255));
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };
            th.start();
            x = 0;
        } else if (x == 0) {
            jPanel_SideBar.setSize(x, 552);
            th = new Thread() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i <= x; i++) {
                            th.sleep(1);
                            jPanel_SideBar.setSize(i, 552);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };
            th.start();
            x = 210;
        }
    }//GEN-LAST:event_OP_CloseSideBarMouseClicked

    private void OP_CloseSideBarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OP_CloseSideBarMouseEntered
        labelcolor(OP_CloseSideBar);
    }//GEN-LAST:event_OP_CloseSideBarMouseEntered

    private void OP_CloseSideBarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OP_CloseSideBarMouseExited
        resetlabelcolor(OP_CloseSideBar);

    }//GEN-LAST:event_OP_CloseSideBarMouseExited
    private void demo_six_hourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_demo_six_hourMouseClicked
        new TimerJframe().setVisible(true);
        this.dispose();
      
    }//GEN-LAST:event_demo_six_hourMouseClicked
  
    private void MembersLabelSidebarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MembersLabelSidebarMouseClicked
        dynamicPanel.removeAll();
        dynamicPanel.revalidate();
        dynamicPanel.repaint();
        
        dynamicPanel.add(Members);
        dynamicPanel.revalidate();
        dynamicPanel.repaint();
        
    }//GEN-LAST:event_MembersLabelSidebarMouseClicked

    private void DashboardLabelSideBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardLabelSideBarMouseClicked
        dynamicPanel.removeAll();
        dynamicPanel.revalidate();
        dynamicPanel.repaint();

        dynamicPanel.revalidate();
        dynamicPanel.add(Dashboard);
        dynamicPanel.repaint();
        
    }//GEN-LAST:event_DashboardLabelSideBarMouseClicked

    private void CollectionLabelSideBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CollectionLabelSideBarMouseClicked
        dynamicPanel.removeAll();
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
        
        dynamicPanel.add(Collections);
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
    }//GEN-LAST:event_CollectionLabelSideBarMouseClicked

    private void ReportLabelSidebarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportLabelSidebarMouseClicked
        dynamicPanel.removeAll();
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
        
        dynamicPanel.add(Report);
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
    }//GEN-LAST:event_ReportLabelSidebarMouseClicked

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        // JProgressBar-Objekt wird erzeugt
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CollectionLabel2;
    private javax.swing.JLabel CollectionLabelSideBar;
    private javax.swing.JPanel Collections;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JLabel DashboardLabelSideBar;
    private javax.swing.JLabel Demo6;
    private javax.swing.JPanel Demo6Stunde;
    private javax.swing.JPanel MainJPanel;
    private javax.swing.JLabel MemberLabel1;
    private javax.swing.JPanel Members;
    private javax.swing.JLabel MembersLabelSidebar;
    private javax.swing.JLabel OP_CloseSideBar;
    private javax.swing.JPanel Report;
    private javax.swing.JLabel ReportLabel3;
    private javax.swing.JLabel ReportLabelSidebar;
    private javax.swing.JLabel dashboardLabel;
    private javax.swing.JLabel demo_six_hour;
    private javax.swing.JPanel dynamicPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel_Collections;
    private javax.swing.JPanel jPanel_Dashboard;
    private javax.swing.JPanel jPanel_Members;
    private javax.swing.JPanel jPanel_Report;
    private javax.swing.JPanel jPanel_SideBar;
    private javax.swing.JPanel jPanel_Six_hour;
    private javax.swing.JPanel navBar;
    private javax.swing.JPanel sideBarText;
    // End of variables declaration//GEN-END:variables
   
}
