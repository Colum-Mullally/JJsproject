/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Controllers.LeaderBoard;
import DatabaseController.LeaderboardDB;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author jakec
 */
public class LeaderboardUI extends javax.swing.JFrame {
    
    String username;
    Boolean logged = false;

    LeaderboardUI() {
        getUsers();
        initComponents();
    }
    void getUsers(){
        LeaderBoard l = new LeaderBoard();
        String[][] uArr = l.getUsers();
        setUsers(uArr);
    }
    
    void setUsers(String[][] uArr){
        model.addElement("Name  |  Score");
        for(int i = 0; i < uArr.length ; i++){
            model.addElement(uArr[i][1]+"  |  "+uArr[i][0]);
        }
    }
    public LeaderboardUI(String username) {
        this.username= username;
        logged = true;
        getUsers();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(leaderList);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(backButton)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>                        

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //Back Button
        if(logged){
            MainMenuUI temp = new MainMenuUI(username);
            temp.setVisible(true);
            dispose();
        }
        else{
            guestMenu temp = new guestMenu();
            temp.setVisible(true);
            dispose();
        }
    }                                          


    // Variables declaration - do not modify                     
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane jScrollPane1;
    DefaultListModel<String> model = new DefaultListModel<>();
    private JList<String> leaderList = new JList<>(model);
    // End of variables declaration                   
}
