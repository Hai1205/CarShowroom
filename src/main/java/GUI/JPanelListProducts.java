/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.CreateImage;
import BUS.*;
import DTO.*;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class JPanelListProducts extends javax.swing.JPanel {

    private String customerID, employeeID, idProduct;

    public String getCustomerID() {
        return customerID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public ArrayList<OrderDTO> getOrders() {
        return orders;
    }
    private ArrayList<OrderDTO> orders = new ArrayList<>();
    private ListProduct listPd;
    private ProductBUS pdBUS;
    private int selectedRowIndex;

    public JPanelListProducts() {
        initComponents();
        init();
        this.setSize(1000, 700);
        this.setVisible(true);
    }

    public JPanelListProducts(String customerID, String employeeID, ArrayList<OrderDTO> orders) {
        initComponents();
        this.setSize(960, 700);
        this.setVisible(true);
        this.orders = orders;
        this.customerID = customerID;
        this.employeeID = employeeID;
        init();
    }

    private void init() {
        editDisplay();
        listPd = new ListProduct();
        pdBUS = new ProductBUS(listPd, this, this.employeeID);
        buttonSearchListProduct.addActionListener(pdBUS);
        buttonConfirm.addActionListener(pdBUS);
        buttonCancel.addActionListener(pdBUS);
        buttonRefesh.addActionListener(pdBUS);

        showListProduct(listPd.getListStillSell());
    }

    public javax.swing.JTable getJTableProduct() {
        return JTableProduct;
    }

    public javax.swing.JButton getButtonCancel() {
        return buttonCancel;
    }

    public javax.swing.JButton getButtonConfirm() {
        return buttonConfirm;
    }

    public javax.swing.JButton getButtonRefesh() {
        return buttonRefesh;
    }

    public javax.swing.JButton getButtonSearchListProduct() {
        return buttonSearchListProduct;
    }

    public javax.swing.JLabel getLabelProductId() {
        return labelProductId;
    }

    public javax.swing.JLabel getLabelProductMFG() {
        return labelProductMFG;
    }

    public javax.swing.JLabel getLabelProductName() {
        return labelProductName;
    }

    public javax.swing.JLabel getLabelProductPicture() {
        return labelProductPicture;
    }

    public javax.swing.JLabel getLabelProductPrice() {
        return labelProductPrice;
    }

    public javax.swing.JLabel getLabelProductQuantity() {
        return labelProductQuantity;
    }

    public javax.swing.JLabel getLabelProductSeat() {
        return labelProductSeat;
    }

    public javax.swing.JLabel getLabelProductType() {
        return labelProductType;
    }

    public javax.swing.JTextField getTextFieldSearch() {
        return textFieldSearch;
    }

    public void showListProduct(ArrayList<ProductDTO> list) {
        DefaultTableModel listProductTable = (DefaultTableModel) JTableProduct.getModel();
        listProductTable.setRowCount(0);
        if (list == null) {
            return;
        }
        for (ProductDTO pdDTO : list) {
            int quantity = pdDTO.getQuantity();
            if (quantity == 0) {
                continue;
            }
            listProductTable.addRow(new Object[]{pdDTO.getProductID(), pdDTO.getSupplierID(), pdDTO.getProductName(), pdDTO.getSupplierName(), pdDTO.getType(), quantity, pdDTO.getPrice()});
        }
    }

    public final void editDisplay() {
        CreateImage cre = new CreateImage();
        cre.changeColorButton(buttonCancel);
        cre.changeColorButton(buttonConfirm);
        cre.changeColorButton(buttonSearchListProduct);

        cre.setIconForButton(buttonRefesh, "refesh.png");
        cre.setIconForButton(buttonCancel, "cancle.png");
        cre.setIconForButton(buttonConfirm, "confirm.png");
        cre.setIconForButton(buttonSearchListProduct, "search.png");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        textFieldSearch = new javax.swing.JTextField();
        buttonSearchListProduct = new javax.swing.JButton();
        buttonConfirm = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        productID = new javax.swing.JLabel();
        labelProductId = new javax.swing.JLabel();
        productName = new javax.swing.JLabel();
        labelProductName = new javax.swing.JLabel();
        labelProductType = new javax.swing.JLabel();
        seats = new javax.swing.JLabel();
        labelProductSeat = new javax.swing.JLabel();
        mfg = new javax.swing.JLabel();
        labelProductMFG = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        cost = new javax.swing.JLabel();
        labelProductPrice = new javax.swing.JLabel();
        labelProductPicture = new javax.swing.JLabel();
        type1 = new javax.swing.JLabel();
        labelProductQuantity = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        scrollPane1 = new java.awt.ScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableProduct = new javax.swing.JTable();
        buttonRefesh = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh sách sản phẩm");

        buttonSearchListProduct.setForeground(new java.awt.Color(0, 0, 0));
        buttonSearchListProduct.setText("Tìm kiếm");
        buttonSearchListProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSearchListProductMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonSearchListProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(buttonSearchListProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        buttonConfirm.setForeground(new java.awt.Color(0, 0, 0));
        buttonConfirm.setText("Xác nhận");
        buttonConfirm.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonConfirm.setPreferredSize(new java.awt.Dimension(79, 46));
        buttonConfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonConfirmMouseClicked(evt);
            }
        });
        buttonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmActionPerformed(evt);
            }
        });

        buttonCancel.setForeground(new java.awt.Color(0, 0, 0));
        buttonCancel.setText("Hủy");
        buttonCancel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonCancel.setPreferredSize(new java.awt.Dimension(72, 46));
        buttonCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCancelMouseClicked(evt);
            }
        });
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        productID.setText("Mã sản phẩm");

        productName.setText("Tên sản phẩm");

        seats.setText("Chỗ ngồi");

        mfg.setText("Ngày sản xuất");

        type.setText("Loại");

        cost.setText("Giá");

        labelProductPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        type1.setText("Số lượng");

        jLabel2.setText("Triệu VND");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(productID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(productName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(type1)
                        .addGap(18, 18, 18)
                        .addComponent(labelProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(mfg)
                        .addGap(18, 18, 18)
                        .addComponent(labelProductMFG, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(type)
                        .addGap(18, 18, 18)
                        .addComponent(labelProductType, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(seats)
                        .addGap(18, 18, 18)
                        .addComponent(labelProductSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cost)
                        .addGap(18, 18, 18)
                        .addComponent(labelProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelProductPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelProductPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(productID)
                            .addComponent(labelProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productName)
                            .addComponent(labelProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(type1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mfg)
                            .addComponent(labelProductMFG, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelProductType, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(type)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(seats))
                                .addComponent(labelProductSeat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cost, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelProductPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(22, 22, 22))))
        );

        JTableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Mã nhà cung cấp", "Tên sản phẩm", "Tên nhà cung cấp", "Loại xe", "Số lượng", "Đơn giá(Triệu VND)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableProductMouseClicked(evt);
            }
        });
        JTableProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTableProductKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(JTableProduct);
        if (JTableProduct.getColumnModel().getColumnCount() > 0) {
            JTableProduct.getColumnModel().getColumn(0).setPreferredWidth(50);
            JTableProduct.getColumnModel().getColumn(4).setPreferredWidth(50);
            JTableProduct.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        scrollPane1.add(jScrollPane2);

        buttonRefesh.setForeground(new java.awt.Color(0, 0, 0));
        buttonRefesh.setText("Làm mới");
        buttonRefesh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonRefesh.setPreferredSize(new java.awt.Dimension(72, 46));
        buttonRefesh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRefeshMouseClicked(evt);
            }
        });
        buttonRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefeshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonRefesh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonRefesh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void JTableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableProductMouseClicked
        selectedRowIndex = JTableProduct.getSelectedRow();
        showInfo();
    }//GEN-LAST:event_JTableProductMouseClicked

    private void showInfo(){
        DefaultTableModel listProductTable = (DefaultTableModel) JTableProduct.getModel();
        listPd = new ListProduct();
        ListDetailProduct listDpd = new ListDetailProduct();
        ProductDTO pdDTO = listPd.searchProductByProductID(listProductTable.getValueAt(selectedRowIndex, 0).toString());
        DetailProductDTO dpdDTO = listDpd.searchDetailProductByProductID((String) listProductTable.getValueAt(selectedRowIndex, 0));
        idProduct = pdDTO.getProductID();
        labelProductId.setText(idProduct);
        labelProductName.setText(pdDTO.getProductName());
        labelProductMFG.setText(dpdDTO.getMFG());
        labelProductPrice.setText(Double.toString(pdDTO.getPrice()));
        labelProductType.setText(pdDTO.getType());
        labelProductSeat.setText(Integer.toString(dpdDTO.getSeat()));
        CreateImage ci = new CreateImage();
        String imgName = pdDTO.getProductName() + ".png";
        String imageURL = (ci.getImagePathAbsolute(imgName));
        ImageIcon originalIcon = new ImageIcon(imageURL);
        int labelWidth = labelProductPicture.getWidth();
        int labelHeight = labelProductPicture.getHeight();
        Image img = originalIcon.getImage();
        Image resizedImg = img.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImg);
        labelProductPicture.setIcon(resizedIcon);
        labelProductQuantity.setText(pdDTO.getQuantity() + "");
    }
    
    private void buttonConfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonConfirmMouseClicked

    }//GEN-LAST:event_buttonConfirmMouseClicked

    private void buttonSearchListProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSearchListProductMouseClicked

    }//GEN-LAST:event_buttonSearchListProductMouseClicked

    private void buttonCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCancelMouseClicked

    }//GEN-LAST:event_buttonCancelMouseClicked

    private void buttonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonConfirmActionPerformed

    private void buttonRefeshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRefeshMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRefeshMouseClicked

    private void buttonRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefeshActionPerformed

    }//GEN-LAST:event_buttonRefeshActionPerformed

    private void JTableProductKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTableProductKeyPressed
        selectedRowIndex = JTableProduct.getSelectedRow();
        int rowCount = JTableProduct.getRowCount();

        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP -> {
                if (selectedRowIndex > 0) {
                    JTableProduct.changeSelection(selectedRowIndex--, 0, false, false);
                } else {
                }
            }
            case KeyEvent.VK_DOWN -> {
                if (selectedRowIndex == rowCount - 1) {
                } else {
                    JTableProduct.changeSelection(selectedRowIndex++, 0, false, false);
                }
            }
        }
        showInfo();
    }//GEN-LAST:event_JTableProductKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableProduct;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonConfirm;
    private javax.swing.JButton buttonRefesh;
    private javax.swing.JButton buttonSearchListProduct;
    private javax.swing.JLabel cost;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelProductId;
    private javax.swing.JLabel labelProductMFG;
    private javax.swing.JLabel labelProductName;
    private javax.swing.JLabel labelProductPicture;
    private javax.swing.JLabel labelProductPrice;
    private javax.swing.JLabel labelProductQuantity;
    private javax.swing.JLabel labelProductSeat;
    private javax.swing.JLabel labelProductType;
    private javax.swing.JLabel mfg;
    private javax.swing.JLabel productID;
    private javax.swing.JLabel productName;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JLabel seats;
    private javax.swing.JTextField textFieldSearch;
    private javax.swing.JLabel type;
    private javax.swing.JLabel type1;
    // End of variables declaration//GEN-END:variables
}
