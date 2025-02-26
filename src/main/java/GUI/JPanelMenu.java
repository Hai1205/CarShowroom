/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.CreateImage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author voota
 */
public class JPanelMenu extends javax.swing.JPanel {

    /**
     * Creates new form ChucNang
     */
    private JFrame mainFrame;
    private String employeeID;
    
    public JPanelMenu(JFrame mainFrame, String employeeID) {
        initComponents();
        editDisplay();
        this.setSize(240, 700);
        this.setVisible(true);
        this.mainFrame = mainFrame;
        this.employeeID = employeeID;
        authorization(employeeID);
    }
    
    private void authorization(String employeeID) {
        if (!employeeID.equals("EP0000000000")) {
            setVisibleButton(false);
        }
    }
    
    private void setVisibleButton(boolean request) {
        buttonInvoice.setVisible(request);
        buttonImport.setVisible(request);
        buttonSupplier.setVisible(request);
        buttonEmployee.setVisible(request);
        buttonDiscount.setVisible(request);
        buttonStatistics.setVisible(request);
    }
    
    public final void editDisplay() {
        CreateImage cre = new CreateImage();
        
        labelAvatar.setSize(150, 147);
        cre.setIconForLabel(labelAvatar, "logo.png");
        
        cre.changeColorButton(buttonAccount);
        cre.changeColorButton(buttonCustomer);
        cre.changeColorButton(buttonStatistics);
        cre.changeColorButton(buttonEmployee);
        cre.changeColorButton(buttonImport);
        cre.changeColorButton(buttonInvoice);
        cre.changeColorButton(buttonProduct);
        cre.changeColorButton(buttonSell);
        cre.changeColorButton(buttonSupplier);
        cre.changeColorButton(buttonDiscount);
        
        cre.setIconForButton(buttonAccount, "buttonAccount.png");
        cre.setIconForButton(buttonCustomer, "buttonCustomer.png");
        cre.setIconForButton(buttonStatistics, "buttonStatistics.png");
        cre.setIconForButton(buttonEmployee, "buttonEmployee.png");
        cre.setIconForButton(buttonImport, "buttonImport.png");
        cre.setIconForButton(buttonInvoice, "buttonInvoice.png");
        cre.setIconForButton(buttonProduct, "buttonProduct.png");
        cre.setIconForButton(buttonSell, "buttonSell.png");
        cre.setIconForButton(buttonSupplier, "buttonSupplier.png");
        cre.setIconForButton(buttonDiscount, "buttonDiscount.png");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        buttonStatistics = new javax.swing.JButton();
        buttonSell = new javax.swing.JButton();
        buttonProduct = new javax.swing.JButton();
        buttonImport = new javax.swing.JButton();
        buttonSupplier = new javax.swing.JButton();
        buttonEmployee = new javax.swing.JButton();
        buttonCustomer = new javax.swing.JButton();
        buttonInvoice = new javax.swing.JButton();
        buttonAccount = new javax.swing.JButton();
        buttonDiscount = new javax.swing.JButton();
        labelAvatar = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelMenu.setBackground(new java.awt.Color(0, 204, 204));

        buttonStatistics.setForeground(new java.awt.Color(0, 0, 0));
        buttonStatistics.setText("Thống kê");
        buttonStatistics.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonStatistics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonStatisticsMouseClicked(evt);
            }
        });
        buttonStatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStatisticsActionPerformed(evt);
            }
        });

        buttonSell.setForeground(new java.awt.Color(0, 0, 0));
        buttonSell.setText("Bán hàng");
        buttonSell.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonSell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSellMouseClicked(evt);
            }
        });
        buttonSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSellActionPerformed(evt);
            }
        });

        buttonProduct.setForeground(new java.awt.Color(0, 0, 0));
        buttonProduct.setText("Quản lý sản phẩm");
        buttonProduct.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonProductMouseClicked(evt);
            }
        });
        buttonProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProductActionPerformed(evt);
            }
        });

        buttonImport.setForeground(new java.awt.Color(0, 0, 0));
        buttonImport.setText("Quản lý nhập hàng");
        buttonImport.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonImportMouseClicked(evt);
            }
        });
        buttonImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImportActionPerformed(evt);
            }
        });

        buttonSupplier.setForeground(new java.awt.Color(0, 0, 0));
        buttonSupplier.setText("Quản lý nhà cung cấp");
        buttonSupplier.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonSupplier.setPreferredSize(new java.awt.Dimension(150, 23));
        buttonSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSupplierMouseClicked(evt);
            }
        });
        buttonSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSupplierActionPerformed(evt);
            }
        });

        buttonEmployee.setForeground(new java.awt.Color(0, 0, 0));
        buttonEmployee.setText("Quản lý nhân viên");
        buttonEmployee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonEmployeeMouseClicked(evt);
            }
        });
        buttonEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEmployeeActionPerformed(evt);
            }
        });

        buttonCustomer.setForeground(new java.awt.Color(0, 0, 0));
        buttonCustomer.setText("Quản lý khách hàng");
        buttonCustomer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCustomerMouseClicked(evt);
            }
        });
        buttonCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCustomerActionPerformed(evt);
            }
        });

        buttonInvoice.setForeground(new java.awt.Color(0, 0, 0));
        buttonInvoice.setText("Quản lý hóa đơn");
        buttonInvoice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonInvoiceMouseClicked(evt);
            }
        });
        buttonInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInvoiceActionPerformed(evt);
            }
        });

        buttonAccount.setForeground(new java.awt.Color(0, 0, 0));
        buttonAccount.setText("Đăng xuất");
        buttonAccount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAccountMouseClicked(evt);
            }
        });
        buttonAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAccountActionPerformed(evt);
            }
        });

        buttonDiscount.setForeground(new java.awt.Color(0, 0, 0));
        buttonDiscount.setText("Quản lý khuyến mãi");
        buttonDiscount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonDiscount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonDiscountMouseClicked(evt);
            }
        });
        buttonDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDiscountActionPerformed(evt);
            }
        });

        labelAvatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(buttonStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonImport, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonSupplier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonEmployee, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonCustomer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonInvoice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonDiscount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonSell, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAvatar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonSell, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonImport, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonStatisticsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonStatisticsMouseClicked

    }//GEN-LAST:event_buttonStatisticsMouseClicked

    private void buttonStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStatisticsActionPerformed
        JPanelStatistics statistic = new JPanelStatistics();
        MainFrameGUI mainFrame = (MainFrameGUI) SwingUtilities.getWindowAncestor(this);
        mainFrame.getjPanelMain().removeAll();
        mainFrame.getjPanelMain().add(statistic).setVisible(true);
        mainFrame.pack();
    }//GEN-LAST:event_buttonStatisticsActionPerformed

    private void buttonSellMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSellMouseClicked

    }//GEN-LAST:event_buttonSellMouseClicked

    private void buttonSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSellActionPerformed
        JPanelOrder order = new JPanelOrder(this.employeeID);
        MainFrameGUI main = (MainFrameGUI) SwingUtilities.getWindowAncestor(this);
        main.getjPanelMain().removeAll();
        main.getjPanelMain().add(order).setVisible(true);
        main.pack();
    }//GEN-LAST:event_buttonSellActionPerformed

    private void buttonProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonProductMouseClicked

    }//GEN-LAST:event_buttonProductMouseClicked

    private void buttonProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProductActionPerformed
        JPanelProduct product = new JPanelProduct();
        MainFrameGUI trangChu = (MainFrameGUI) SwingUtilities.getWindowAncestor(this);
        trangChu.getjPanelMain().removeAll();
        trangChu.getjPanelMain().add(product).setVisible(true);
        trangChu.pack();
    }//GEN-LAST:event_buttonProductActionPerformed

    private void buttonImportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonImportMouseClicked

    }//GEN-LAST:event_buttonImportMouseClicked

    private void buttonImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImportActionPerformed
        JPanelImport Import = new JPanelImport();
        MainFrameGUI trangChu = (MainFrameGUI) SwingUtilities.getWindowAncestor(this);
        trangChu.getjPanelMain().removeAll();
        trangChu.getjPanelMain().add(Import).setVisible(true);
        trangChu.pack();
    }//GEN-LAST:event_buttonImportActionPerformed

    private void buttonSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSupplierMouseClicked

    }//GEN-LAST:event_buttonSupplierMouseClicked

    private void buttonSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSupplierActionPerformed
        JPanelSupplier supplier = new JPanelSupplier();
        MainFrameGUI mainFrame = (MainFrameGUI) SwingUtilities.getWindowAncestor(this);
        mainFrame.getjPanelMain().removeAll();
        mainFrame.getjPanelMain().add(supplier).setVisible(true);
        mainFrame.pack();
    }//GEN-LAST:event_buttonSupplierActionPerformed

    private void buttonEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEmployeeMouseClicked

    }//GEN-LAST:event_buttonEmployeeMouseClicked

    private void buttonEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEmployeeActionPerformed
        JPanelEmployee employee = new JPanelEmployee();
        MainFrameGUI mainFrame = (MainFrameGUI) SwingUtilities.getWindowAncestor(this);
        mainFrame.getjPanelMain().removeAll();
        mainFrame.getjPanelMain().add(employee).setVisible(true);
        mainFrame.pack();
    }//GEN-LAST:event_buttonEmployeeActionPerformed

    private void buttonCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCustomerMouseClicked

    }//GEN-LAST:event_buttonCustomerMouseClicked

    private void buttonCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCustomerActionPerformed
        JPanelCustomer customer = new JPanelCustomer();
        MainFrameGUI mainFrame = (MainFrameGUI) SwingUtilities.getWindowAncestor(this);
        mainFrame.getjPanelMain().removeAll();
        mainFrame.getjPanelMain().add(customer).setVisible(true);
        mainFrame.pack();
    }//GEN-LAST:event_buttonCustomerActionPerformed

    private void buttonInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonInvoiceMouseClicked

    }//GEN-LAST:event_buttonInvoiceMouseClicked

    private void buttonInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInvoiceActionPerformed
        JPanelInvoice invoice = new JPanelInvoice();
        MainFrameGUI mainFrame = (MainFrameGUI) SwingUtilities.getWindowAncestor(this);
        mainFrame.getjPanelMain().removeAll();
        mainFrame.getjPanelMain().add(invoice).setVisible(true);
        mainFrame.pack();
    }//GEN-LAST:event_buttonInvoiceActionPerformed

    private void buttonAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAccountMouseClicked

    }//GEN-LAST:event_buttonAccountMouseClicked

    private void buttonAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAccountActionPerformed
        int response = JOptionPane.showConfirmDialog(mainFrame, "Bạn có chắc chắn muốn đăng xuất?", "Xác nhận đăng xuất", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            mainFrame.dispose();
            new LoginGUI().setVisible(true);
//            setEnabledButton(true);
            setVisibleButton(true);
        }
    }//GEN-LAST:event_buttonAccountActionPerformed

    private void buttonDiscountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDiscountMouseClicked

    }//GEN-LAST:event_buttonDiscountMouseClicked

    private void buttonDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDiscountActionPerformed
        JPanelDiscount discount = new JPanelDiscount();
        MainFrameGUI mainFrame = (MainFrameGUI) SwingUtilities.getWindowAncestor(this);
        mainFrame.getjPanelMain().removeAll();
        mainFrame.getjPanelMain().add(discount).setVisible(true);
        mainFrame.pack();
    }//GEN-LAST:event_buttonDiscountActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton buttonAccount;
    public javax.swing.JButton buttonCustomer;
    public javax.swing.JButton buttonDiscount;
    public javax.swing.JButton buttonEmployee;
    public javax.swing.JButton buttonImport;
    public javax.swing.JButton buttonInvoice;
    public javax.swing.JButton buttonProduct;
    public javax.swing.JButton buttonSell;
    public javax.swing.JButton buttonStatistics;
    public javax.swing.JButton buttonSupplier;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelAvatar;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
}
