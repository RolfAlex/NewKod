/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot_x;

import static bot_x.Calculation.getChekTrustBalans;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class BotInterfase extends javax.swing.JFrame {

    /**
     * Creates new form BotInterfase
     */
    public BotInterfase() {
        initComponents();
    }

    // **************Авторизация*****************
    String key = Bot_Action.getKey();
    String secret = Bot_Action.getSecret();

    // Валютные пары + лимит количества ордеров для вычисления средней цены 
    String pair = Bot_Action.getPair();
    String valent = Bot_Action.getValent();
    
    double prise = 0.0;

    //Флаг кнопок Start/Stop
    boolean stop = true;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jStrategi = new javax.swing.JFrame();
        TrustedLimit = new javax.swing.JLabel();
        jFIeldLimit = new javax.swing.JTextField();
        Dolar = new javax.swing.JLabel();
        jAverageOrderPrise = new javax.swing.JCheckBox();
        jCurentOrderPrise = new javax.swing.JCheckBox();
        jNumField = new javax.swing.JTextField();
        Num = new javax.swing.JLabel();
        OrderLifetime = new javax.swing.JLabel();
        jOrderLifetime = new javax.swing.JTextField();
        Sec = new javax.swing.JLabel();
        jOkeyButton = new javax.swing.JButton();
        jErrorMessage = new javax.swing.JLabel();
        jConfirmSet = new javax.swing.JDialog();
        jSetting = new javax.swing.JScrollPane();
        JSetPnel = new javax.swing.JTextPane();
        jSaveSetting = new javax.swing.JButton();
        LabBalans = new javax.swing.JLabel();
        jStart = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Balans = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BalansReserved = new javax.swing.JTextArea();
        jOrderListF = new javax.swing.JScrollPane();
        jFinishOrderList = new javax.swing.JTextArea();
        FinishOrderList = new javax.swing.JLabel();
        OrderList = new javax.swing.JLabel();
        jOrderListS = new javax.swing.JScrollPane();
        jOrderList = new javax.swing.JTextArea();
        CanseledOrders = new javax.swing.JScrollPane();
        jCanseledOrders = new javax.swing.JTextArea();
        CanseledOrder = new javax.swing.JLabel();
        jStop = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jStrategi.setLocationByPlatform(true);
        jStrategi.setMaximumSize(new java.awt.Dimension(381, 320));
        jStrategi.setMinimumSize(new java.awt.Dimension(381, 320));

        TrustedLimit.setText("Trusted limit");

        jFIeldLimit.setText("1");
        jFIeldLimit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFIeldLimitActionPerformed(evt);
            }
        });

        Dolar.setText("$");

        jAverageOrderPrise.setText("Ордера по среднему значению ");
        jAverageOrderPrise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAverageOrderPriseActionPerformed(evt);
            }
        });

        jCurentOrderPrise.setSelected(true);
        jCurentOrderPrise.setText("Ордера по теушей цене");
        jCurentOrderPrise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCurentOrderPriseActionPerformed(evt);
            }
        });

        jNumField.setText("1");
        jNumField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNumFieldActionPerformed(evt);
            }
        });

        Num.setText("Количество ордеров");

        OrderLifetime.setText("Время жизни ордера");

        jOrderLifetime.setText("30");
        jOrderLifetime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOrderLifetimeActionPerformed(evt);
            }
        });

        Sec.setText("мин.");

        jOkeyButton.setText("OK");
        jOkeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOkeyButtonActionPerformed(evt);
            }
        });

        jErrorMessage.setBackground(new java.awt.Color(204, 102, 0));
        jErrorMessage.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N

        javax.swing.GroupLayout jStrategiLayout = new javax.swing.GroupLayout(jStrategi.getContentPane());
        jStrategi.getContentPane().setLayout(jStrategiLayout);
        jStrategiLayout.setHorizontalGroup(
            jStrategiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jStrategiLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jStrategiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jStrategiLayout.createSequentialGroup()
                        .addGroup(jStrategiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFIeldLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TrustedLimit, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Dolar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jStrategiLayout.createSequentialGroup()
                        .addGroup(jStrategiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jStrategiLayout.createSequentialGroup()
                                .addGroup(jStrategiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Num)
                                    .addComponent(jCurentOrderPrise)
                                    .addComponent(jAverageOrderPrise)
                                    .addComponent(jNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jStrategiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(OrderLifetime)
                                    .addGroup(jStrategiLayout.createSequentialGroup()
                                        .addComponent(jOrderLifetime, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Sec, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jErrorMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27))))
            .addGroup(jStrategiLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jOkeyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jStrategiLayout.setVerticalGroup(
            jStrategiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jStrategiLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TrustedLimit, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jStrategiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jStrategiLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(Dolar))
                    .addComponent(jFIeldLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jCurentOrderPrise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAverageOrderPrise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jStrategiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jStrategiLayout.createSequentialGroup()
                        .addComponent(OrderLifetime, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jStrategiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jOrderLifetime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Sec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jStrategiLayout.createSequentialGroup()
                        .addComponent(Num, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)
                        .addComponent(jNumField)))
                .addGap(18, 18, 18)
                .addComponent(jOkeyButton, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        jConfirmSet.setLocationByPlatform(true);
        jConfirmSet.setMinimumSize(new java.awt.Dimension(411, 315));

        jSetting.setViewportView(JSetPnel);

        jSaveSetting.setText("Save Settings ");
        jSaveSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveSettingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jConfirmSetLayout = new javax.swing.GroupLayout(jConfirmSet.getContentPane());
        jConfirmSet.getContentPane().setLayout(jConfirmSetLayout);
        jConfirmSetLayout.setHorizontalGroup(
            jConfirmSetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jConfirmSetLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSetting, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jConfirmSetLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jSaveSetting)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jConfirmSetLayout.setVerticalGroup(
            jConfirmSetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jConfirmSetLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSaveSetting)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        LabBalans.setText("Баланс: ");

        jStart.setText("START");
        jStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStartActionPerformed(evt);
            }
        });

        jLabel1.setText("Exchange rate ");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Balans.setColumns(20);
        Balans.setRows(5);
        Balans.setMaximumSize(new java.awt.Dimension(83, 130));
        Balans.setMinimumSize(new java.awt.Dimension(83, 130));
        Balans.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(Balans);

        jLabel2.setText("ETH_USD");

        jLabel3.setText("Баланс в ордерах:");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        BalansReserved.setColumns(20);
        BalansReserved.setRows(5);
        jScrollPane1.setViewportView(BalansReserved);

        jFinishOrderList.setEditable(false);
        jFinishOrderList.setColumns(20);
        jFinishOrderList.setRows(5);
        jOrderListF.setViewportView(jFinishOrderList);

        FinishOrderList.setText("Список успешно завершенных ордеров:");

        OrderList.setText("Список открытых ордеров:");

        jOrderList.setEditable(false);
        jOrderList.setColumns(20);
        jOrderList.setRows(5);
        jOrderListS.setViewportView(jOrderList);

        jCanseledOrders.setColumns(20);
        jCanseledOrders.setRows(5);
        CanseledOrders.setViewportView(jCanseledOrders);

        CanseledOrder.setText("Отмеененные ордера:");

        jStop.setText("STOP");
        jStop.setEnabled(false);
        jStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStopActionPerformed(evt);
            }
        });

        jMenu1.setText("Настройки");

        jMenuItem1.setText("API KEY");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Strategi");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabBalans)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jStart, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jStop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 479, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CanseledOrder)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(OrderList)
                            .addGap(204, 204, 204))
                        .addComponent(jOrderListS, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jOrderListF, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(FinishOrderList)
                        .addComponent(CanseledOrders)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabBalans)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(OrderList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jOrderListS, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(FinishOrderList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jOrderListF, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(CanseledOrder)
                        .addGap(5, 5, 5)
                        .addComponent(CanseledOrders, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jStart, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jStop, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//  Modules m = new Modules();
//    String key = "";
//    String secret = "";
//    jTextArea1.append((String) m.getUserBalansInfo(key, secret).get("balans"));

    private void jStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStartActionPerformed
        start();
        startBal();
        startBalRes();
        jStart.setEnabled(false);
        jStop.setEnabled(true);
    }//GEN-LAST:event_jStartActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        jStrategi.setVisible(true);
        jNumField.setVisible(false);
        Num.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowStateChanged

    private void jFIeldLimitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFIeldLimitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFIeldLimitActionPerformed

    private void jAverageOrderPriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAverageOrderPriseActionPerformed
        jNumField.setVisible(true);
        Num.setVisible(true);
        jCurentOrderPrise.setSelected(false);    }//GEN-LAST:event_jAverageOrderPriseActionPerformed

    private void jNumFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNumFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNumFieldActionPerformed

    private void jOkeyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOkeyButtonActionPerformed
        try {
            String info = "Доверреный боту лимит " + jFIeldLimit.getText() + "$\n";
            if (jCurentOrderPrise.isSelected()) {
                info = info.concat("Бот будет выставлять ордера на продажу\nпо текущей цене на валту\n");
                Bot_Action.setAverageOrCurent(false);
            } else if (jAverageOrderPrise.isSelected()) {
                info = info.concat("Бот будет выставлять ордера на продажу\nпо среднему значению \"" + jNumField.getText() + "\" ордеров на ринку\n");
                Bot_Action.setAverageOrCurent(true);
            }
            
            info = info.concat("Время жизни ордера составит " + jOrderLifetime.getText() + " мин.");
            JSetPnel.setText(info);
            jConfirmSet.setVisible(true);
            Bot_Action.setTrustLimit(jFIeldLimit.getText());
            Bot_Action.setOrderCount(jNumField.getText());
            Bot_Action.setorderLifeTime(jOrderLifetime.getText());
        } catch (NumberFormatException e) {
            try {
                jErrorMessage.setText("Поля не заполнены или заполнены не корректно!");
                Thread.sleep(1000);
                jErrorMessage.setText("");
                
            } catch (InterruptedException ex) {
                Logger.getLogger(BotInterfase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        System.out.println("getAverageOrCurent " + Bot_Action.getAverageOrCurent());
//        System.out.println("getOrderCount " + Bot_Action.getOrderCount());
//        System.out.println("getTrustLimit " + Bot_Action.getTrustLimit());
//        System.out.println("getorderLifeTime " + Bot_Action.getorderLifeTime());

    }//GEN-LAST:event_jOkeyButtonActionPerformed

    private void jCurentOrderPriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCurentOrderPriseActionPerformed
        jNumField.setVisible(false);
        Num.setVisible(false);
        jAverageOrderPrise.setSelected(false);
    }//GEN-LAST:event_jCurentOrderPriseActionPerformed

    private void jSaveSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveSettingActionPerformed
        jStrategi.setVisible(false);
        jConfirmSet.setVisible(false);
    }//GEN-LAST:event_jSaveSettingActionPerformed

    private void jStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStopActionPerformed
        stop = false;
        jStart.setEnabled(true);
        jStop.setEnabled(false);
    }//GEN-LAST:event_jStopActionPerformed

    private void jOrderLifetimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOrderLifetimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jOrderLifetimeActionPerformed
    
    public void start() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                prise = Calculation.getFormatPrise(Double.parseDouble(Modules.getPrise(key, secret, pair).get("1").toString()), "#0.0000");
                while (stop) {
//                    jLabel1.setText((String) Modules.getPrise(key, secret, pair).get("1"));

                    double trustedLimitUSD = Double.parseDouble((String) Calculation.getChekTrustBalans(key, secret, Bot_Action.getValent(), Bot_Action.getTrustLimit(), String.valueOf(prise)).get("trustUsd"));
                    double trustedLimitETH = Double.parseDouble((String) Calculation.getChekTrustBalans(key, secret, Bot_Action.getValent(), Bot_Action.getTrustLimit(), String.valueOf(prise)).get("trustEth"));
                    double persProfit = 0.5; // НУЖНО ОБРАБОТАТЬ!!!!!!!!!!!!!!!111
                    System.out.println("trustedLimitUSD " + trustedLimitUSD);
                    System.out.println("trustedLimitETH " + trustedLimitETH);
                    
                    boolean checkPrise = false; // Если !true! значение цены берется по среднему значению N ордеров на покупку если !false! - по текущей цене на валюту

                    double orderAsk = Calculation.getFormatPrise(Calculation.getOrderAskPrise(pair, Bot_Action.getOrderCount(), persProfit, trustedLimitETH, key, secret, Bot_Action.getAverageOrCurent(), prise), "#0.000000");
                    double orderBid = Calculation.getFormatPrise(Calculation.getOrderBidPrise(pair, persProfit, key, secret, trustedLimitUSD), "#0.00");

//                    
//                    System.out.println( Calculation.getChekTrustBalans(key, secret, Bot_Action.getValent(), trustedLimit, pair).get("chekVal").toString());
//                    System.out.println("1");
                    int lifeTime = 0;
                    double orderLifeTime = Bot_Action.getorderLifeTime();
//                       System.out.println(Calculation.getChekTrustBalans(key, secret, Bot_Action.getValent(), trustedLimUsd, curPr).get("chekVal").toString());
//                       System.out.println(String.valueOf(prise));
                    String chekByOrSell = Calculation.getChekTrustBalans(key, secret, Bot_Action.getValent(), trustedLimitUSD, String.valueOf(prise)).get("chekVal").toString();
                    boolean checkByOrBit = true;
                    System.out.println("2");
                    if (chekByOrSell.equalsIgnoreCase("sell")) {
                        checkByOrBit = false;
                        jOrderList.append("Цена ордера на продажу " + orderAsk);
                        System.out.println("Цена ордера на продажу " + orderAsk);
                    } else if (chekByOrSell.equalsIgnoreCase("buy")) {
                        checkByOrBit = true;
                        jOrderList.append("Цена ордера на продажу " + orderAsk);
                        System.out.println("Цена ордера на покупку " + orderBid);
                    }
                    while (stop) {
                        
                        prise = Calculation.getFormatPrise(Double.parseDouble(Modules.getPrise(key, secret, pair).get("1").toString()), "#0.00000");
                        jLabel1.setText(String.valueOf(prise));
                        Thread.sleep(500);
                        //ПРОДАЖА
                        if (orderAsk <= prise && checkByOrBit == false) {
                            jFinishOrderList.append("**Срабатывание ордера на ПРОДАЖУ**\nЦена ордера на продажу \n" + orderAsk + "\n");
                            System.out.println("**Срабатывание ордера на ПРОДАЖУ**");
                            System.out.println("Цена ордера на продажу " + orderAsk);
                            System.out.println("Продано по цене " + prise);
                            orderBid = Calculation.getOrderBidPrise(pair, persProfit, key, secret, trustedLimitUSD);
                            jOrderList.setText("Цена ордера на покупку " + orderBid + "\n");
                            System.out.println("Цена ордера на покупку " + orderBid);
                            checkByOrBit = true;
                        }
                        //ПОКУПКА
                        if (orderBid >= prise && checkByOrBit == true) {
                            jFinishOrderList.append("**Срабатывание ордера на ПОКУПКУ**\nЦена ордера на покупку " + orderBid + "\n");
                            System.out.println("***********Срабатывание ордера на ПОКУПКУ*********");
                            System.out.println("Цена ордера на покупку " + orderBid);
                            System.out.println("---Куплено по цене " + prise);
                            orderAsk = Calculation.getOrderAskPrise(pair, Bot_Action.getOrderCount(), persProfit, trustedLimitETH, key, secret, Bot_Action.getAverageOrCurent(), prise);
                            jOrderList.setText("Цена ордера на продажу " + orderAsk + "\n");
                            System.out.println("Цена ордера на продажу " + orderAsk);
                            checkByOrBit = false;
                        }
                        //ЖИЗНЬ ОРДЕРА
                        if (lifeTime > orderLifeTime && checkByOrBit == true) {
                            orderBid = Calculation.getOrderBidPrise(pair, persProfit, key, secret, trustedLimitUSD);
                            jCanseledOrders.append("смена ордера на покупку " + orderBid + "\n");
                            jOrderList.setText("Цена ордера на покупку " + orderBid + "\n");
                            System.out.println("смена ордера на покупку " + orderBid);
                            lifeTime = 0;
                        } else if (lifeTime > orderLifeTime && checkByOrBit == false) {
                            orderAsk = Calculation.getOrderAskPrise(pair, Bot_Action.getOrderCount(), persProfit, trustedLimitETH, key, secret, checkPrise, prise);
                            jCanseledOrders.append("смена ордера на продажу " + orderAsk + "\n");
                            jOrderList.setText("Цена ордера на продажу " + orderAsk + "\n");
                            System.out.println("смена ордера на продажу " + orderAsk);
                            lifeTime = 0;
                        }
                        lifeTime++;
                    }
                }
                stop = true;
                return null;
            }
        };
        worker.execute();
    }
    
    public void startBal() {
        Modules m = new Modules();
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                int u = 0;
                while (true) {
                    Balans.setText((String) m.getUserBalansInfo(key, secret).get("balans"));
                    do {
                        
                        if (Balans.getText().split("\n").length <= 0) {
                            Balans.setText((String) m.getUserBalansInfo(key, secret).get("balans"));
                            System.out.println("ХУЙНЯ!!!!");
                            u = 1;
                        }
                        
                    } while (u <= 0);
                    Thread.sleep(10000);
                }
            }
        };
        worker.execute();
    }
    
    public void startBalRes() {
        Modules m = new Modules();
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                while (true) {
                    BalansReserved.setText((String) m.getUserBalansInfo(key, secret).get("reserv"));
                    Thread.sleep(11000);
                    
                }
            }
        };
        worker.execute();
    }
    
    public static void main(String args[]) {
        Modules mm = new Modules();
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BotInterfase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BotInterfase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BotInterfase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BotInterfase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BotInterfase().setVisible(true);
//                jTextArea1.append((String) m.getUserBalansInfo(key, secret).get("balans"));            
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea Balans;
    public static javax.swing.JTextArea BalansReserved;
    private javax.swing.JLabel CanseledOrder;
    private javax.swing.JScrollPane CanseledOrders;
    private javax.swing.JLabel Dolar;
    private javax.swing.JLabel FinishOrderList;
    private javax.swing.JTextPane JSetPnel;
    private javax.swing.JLabel LabBalans;
    private javax.swing.JLabel Num;
    private javax.swing.JLabel OrderLifetime;
    private javax.swing.JLabel OrderList;
    private javax.swing.JLabel Sec;
    private javax.swing.JLabel TrustedLimit;
    private javax.swing.JCheckBox jAverageOrderPrise;
    private javax.swing.JTextArea jCanseledOrders;
    private javax.swing.JDialog jConfirmSet;
    private javax.swing.JCheckBox jCurentOrderPrise;
    private javax.swing.JLabel jErrorMessage;
    private javax.swing.JTextField jFIeldLimit;
    private javax.swing.JTextArea jFinishOrderList;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JTextField jNumField;
    private javax.swing.JButton jOkeyButton;
    private javax.swing.JTextField jOrderLifetime;
    private javax.swing.JTextArea jOrderList;
    private javax.swing.JScrollPane jOrderListF;
    private javax.swing.JScrollPane jOrderListS;
    private javax.swing.JButton jSaveSetting;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jSetting;
    private javax.swing.JButton jStart;
    private javax.swing.JButton jStop;
    private javax.swing.JFrame jStrategi;
    // End of variables declaration//GEN-END:variables
}
