/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import javax.swing.table.DefaultTableModel;
import DTO.*;
import BUS.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author voota
 */
public class JPanelImport extends javax.swing.JPanel {

    /**
     * Creates new form JPanelQuanLyHoaDon textFieldSearch buttonSearchImport
     */
    private ListImport listIp;
    private ImportBUS ipBUS;
    private ListDetailImport listDip;
    private boolean flat;

    public boolean isFlat() {
        return flat;
    }

    public JPanelImport() {
        initComponents();
        init();
        editDisplay();
        this.setSize(960, 700);
        this.setVisible(true);
    }

    private void init() {
        listIp = new ListImport();
        listDip = new ListDetailImport();
        ipBUS = new ImportBUS(listIp, this);
        buttonSearchImport.addActionListener(ipBUS);
        buttonAdd.addActionListener(ipBUS);
        buttonSearchImport.addActionListener(ipBUS);
        buttonDelete.addActionListener(ipBUS);
        buttonFix.addActionListener(ipBUS);
        buttonConfirm.addActionListener(ipBUS);
        buttonCancle.addActionListener(ipBUS);

        showListImport(listIp.getList());
        showListDetailImport(null);
        setImportID();
        setCombobox();
    }

    public javax.swing.JButton getButtonAdd() {
        return buttonAdd;
    }

    public javax.swing.JButton getButtonCancle() {
        return buttonCancle;
    }

    public javax.swing.JButton getButtonConfirm() {
        return buttonConfirm;
    }

    public javax.swing.JButton getButtonDelete() {
        return buttonDelete;
    }

    public javax.swing.JButton getButtonFix() {
        return buttonFix;
    }

    public javax.swing.JButton getButtonSearchImport() {
        return buttonSearchImport;
    }

    public javax.swing.JComboBox<String> getComboBoxProductName() {
        return comboBoxProductName;
    }

    public javax.swing.JComboBox<String> getComboBoxSupplierName() {
        return comboBoxSupplierName;
    }

    public javax.swing.JTable getJTableImport() {
        return jTableImport;
    }

    public javax.swing.JTable getJTableImportDetail() {
        return jTableImportDetail;
    }

    public javax.swing.JTable getJTableTempImport() {
        return jTableTempImport;
    }

    public javax.swing.JTextField getTextFieldImportPrice() {
        return textFieldImportPrice;
    }

    public javax.swing.JTextField getTextFieldProductPrice() {
        return textFieldProductPrice;
    }

    public javax.swing.JTextField getTextFieldQuantity() {
        return textFieldQuantity;
    }

    public javax.swing.JTextField getTextFieldSearch() {
        return textFieldSearch;
    }

    public javax.swing.JTextField getTextFieldTotalCost() {
        return textFieldTotalCost;
    }

    public void setTextFieldTotalCost(String totalCost) {
        textFieldTotalCost.setText(totalCost);
    }

    public final void editDisplay() {
        CreateImage cre = new CreateImage();
        cre.changeColorButton(buttonAdd);
        cre.changeColorButton(buttonSearchImport);
        cre.changeColorButton(buttonDelete);
        cre.changeColorButton(buttonFix);
        cre.changeColorButton(buttonConfirm);
        cre.changeColorButton(buttonCancle);

        cre.setIconForButton(buttonAdd, "add.png");
        cre.setIconForButton(buttonSearchImport, "search.png");
        cre.setIconForButton(buttonDelete, "delete.png");
        cre.setIconForButton(buttonFix, "fix.png");
        cre.setIconForButton(buttonConfirm, "confirm.png");
        cre.setIconForButton(buttonCancle, "cancle.png");
    }

    private void setCombobox() {
        ListSupplier listSp = new ListSupplier();

        DefaultComboBoxModel<String> modelSupplier = new DefaultComboBoxModel<>();
        for (String item : listSp.getListSupplierName()) {
            modelSupplier.addElement(item);
        }

        comboBoxSupplierName.setModel(modelSupplier);
        updateComboBoxProduct(null);

        comboBoxSupplierName.addItemListener((ItemEvent e) -> {
            textFieldImportPrice.setText("");
            textFieldQuantity.setText("");
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String supplierName = (String) comboBoxSupplierName.getSelectedItem();
                updateComboBoxProduct(supplierName);
            }
        });
        comboBoxProductName.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String productName = (String) comboBoxProductName.getSelectedItem();
                setPrice(productName);
            }
        });
    }

    private void setPrice(String productName) {
        switch (productName) {
            case "Nhấp để chọn" ->
                textFieldProductPrice.setText("");
            default -> {
                ListProduct listPd = new ListProduct();
                Double price = listPd.getPrice(productName);
                if (price == 0.0) {
                    textFieldProductPrice.setEnabled(true);
                }
                textFieldProductPrice.setText("" + price);
            }
        }
    }

    public void updateComboBoxProduct(String supplierName) {
        ListProduct listPd = new ListProduct();
        DefaultComboBoxModel<String> modelProduct = new DefaultComboBoxModel<>();
        for (String item : listPd.getListProductName(supplierName)) {
            modelProduct.addElement(item);
        }
        comboBoxProductName.setModel(modelProduct);
    }

    private void setImportID() {
        jTableImport.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRowIndex = jTableImport.getSelectedRow();

                showListDetailImport(listDip.getListTemp(jTableImport.getValueAt(selectedRowIndex, 0).toString()));
            }
        });
    }

    public void showListImport(ArrayList<ImportDTO> list) {
        DefaultTableModel importTable = (DefaultTableModel) jTableImport.getModel();
        importTable.setRowCount(0);
        if (list == null) {
            return;
        }
        for (ImportDTO ipDTO : list) {
            importTable.addRow(new Object[]{ipDTO.getImportID(), ipDTO.getDate(), ipDTO.getTotalCost()});
        }
    }

    public void showListDetailImport(ArrayList<DetailImportDTO> list) {
        DefaultTableModel importDetailTable = (DefaultTableModel) jTableImportDetail.getModel();
        importDetailTable.setRowCount(0);
        if (list == null) {
            return;
        }
        for (DetailImportDTO divDTO : list) {
            importDetailTable.addRow(new Object[]{divDTO.getImportID(), divDTO.getSupplierID(), divDTO.getProductID(), divDTO.getQuantity(), divDTO.getPrice(), divDTO.getCost()});
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

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        textFieldSearch = new javax.swing.JTextField();
        buttonSearchImport = new javax.swing.JButton();
        scrollPane1 = new java.awt.ScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableImport = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        scrollPane2 = new java.awt.ScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableImportDetail = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboBoxSupplierName = new javax.swing.JComboBox<>();
        textFieldQuantity = new javax.swing.JTextField();
        textFieldImportPrice = new javax.swing.JTextField();
        comboBoxProductName = new javax.swing.JComboBox<>();
        textFieldProductPrice = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textFieldTotalCost = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        buttonAdd = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonFix = new javax.swing.JButton();
        buttonConfirm = new javax.swing.JButton();
        buttonCancle = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        scrollPane3 = new java.awt.ScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTempImport = new javax.swing.JTable();

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Quản lý nhập hàng");

        textFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldSearchActionPerformed(evt);
            }
        });

        buttonSearchImport.setText("Tìm kiếm");
        buttonSearchImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchImportActionPerformed(evt);
            }
        });

        jTableImport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã phiếu nhập", "Ngày lập", "Tổng tiền(Triệu VND)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableImport.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableImportKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTableImport);

        scrollPane1.add(jScrollPane2);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Phiếu nhập");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Chi tiết phiếu nhập");

        jTableImportDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu nhập", "Mã nhà cung cấp", "Mã sản phẩm", "Số lượng", "Đơn giá(Triệu VND)", "Thành tiền(Triệu VND)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableImportDetail);

        scrollPane2.add(jScrollPane3);

        jLabel4.setText("Tên nhà cung cấp");

        jLabel5.setText("Tên sản phẩm");

        jLabel6.setText("Giá nhập vào");

        jLabel9.setText("Số lượng nhập");

        textFieldQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldQuantityKeyReleased(evt);
            }
        });

        textFieldImportPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldImportPriceKeyReleased(evt);
            }
        });

        textFieldProductPrice.setEnabled(false);
        textFieldProductPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldProductPriceKeyReleased(evt);
            }
        });

        jLabel10.setText("Giá bán ra");

        jLabel7.setText("Tổng tiền");

        textFieldTotalCost.setText("0.0");
        textFieldTotalCost.setEnabled(false);

        jLabel3.setText("Triệu VND");

        jLabel11.setText("Triệu VND");

        jLabel12.setText("Triệu VND");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(comboBoxProductName, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textFieldQuantity, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(textFieldImportPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(textFieldTotalCost, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                .addComponent(textFieldProductPrice))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel3))))
                    .addComponent(comboBoxSupplierName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboBoxSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboBoxProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textFieldImportPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textFieldTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonAdd.setText("Thêm sản phẩm");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonDelete.setText("Xóa sản phẩm");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonFix.setText("Sửa phiếu nhập");
        buttonFix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFixActionPerformed(evt);
            }
        });

        buttonConfirm.setText("Xác nhận phiếu nhập");

        buttonCancle.setText("Hủy phiếu nhập");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonFix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonCancle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonFix)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonConfirm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCancle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableTempImport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tên nhà cung cấp", "Tên sản phẩm", "Giá nhập", "Số lượng nhập", "Giá bán", "Thành tiền(Triệu VND)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableTempImport);

        scrollPane3.add(jScrollPane1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonSearchImport, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 17, Short.MAX_VALUE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addComponent(scrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonSearchImport)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(scrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void textFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldSearchActionPerformed

    private void buttonSearchImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchImportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSearchImportActionPerformed

    private void buttonFixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonFixActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAddActionPerformed

    private void textFieldImportPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldImportPriceKeyReleased
        String importPriceStr = textFieldImportPrice.getText().trim();
        String productPriceStr = textFieldProductPrice.getText().trim();

        if (importPriceStr.isEmpty()) {
            return;
        }

        if (!Tool.isDouble(importPriceStr)) {
            flat = true;
            JOptionPane.showMessageDialog(this, "Giá nhập vào của sản phẩm không hợp lệ.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            textFieldImportPrice.setText("");
            textFieldImportPrice.requestFocus();
            flat = false;
        }else if(Double.parseDouble(importPriceStr) > Double.parseDouble(productPriceStr)){
            flat = true;
            JOptionPane.showMessageDialog(this, "Giá nhập vào phải thấp hơn hoặc bằng giá bán.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            textFieldImportPrice.setText("");
            textFieldImportPrice.requestFocus();
            flat = false;
        }
    }//GEN-LAST:event_textFieldImportPriceKeyReleased

    private void textFieldQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldQuantityKeyReleased
        String quantityStr = textFieldQuantity.getText().trim();

        if (quantityStr.isEmpty()) {
            return;
        }

        if (!Tool.isInt(quantityStr)) {
            flat = true;
            JOptionPane.showMessageDialog(this, "Số lượng của sản phẩm không hợp lệ.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            textFieldQuantity.setText("");
            textFieldQuantity.requestFocus();
            flat = false;
        }
    }//GEN-LAST:event_textFieldQuantityKeyReleased

    private void textFieldProductPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldProductPriceKeyReleased
        String productPriceStr = textFieldProductPrice.getText().trim();
        String importPriceStr = textFieldImportPrice.getText().trim();

        if (productPriceStr.isEmpty()) {
            return;
        }

        if (!Tool.isDouble(productPriceStr)) {
            flat = true;
            JOptionPane.showMessageDialog(this, "Giá bán ra của sản phẩm không hợp lệ.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            textFieldProductPrice.setText("");
            textFieldProductPrice.requestFocus();
            flat = false;
        }else if(Double.parseDouble(importPriceStr) > Double.parseDouble(productPriceStr)){
            flat = true;
            JOptionPane.showMessageDialog(this, "Giá bán phải lớn hơn hoặc bằng giá nhập vào.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            textFieldProductPrice.setText("");
            textFieldProductPrice.requestFocus();
            flat = false;
        }
    }//GEN-LAST:event_textFieldProductPriceKeyReleased

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void jTableImportKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableImportKeyPressed
        int selectedRowIndex = jTableImport.getSelectedRow();
        int rowCount = jTableImport.getRowCount();

        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP -> {
                if (selectedRowIndex > 0) {
                    jTableImport.changeSelection(selectedRowIndex--, 0, false, false);
                } else {
                }
            }
            case KeyEvent.VK_DOWN -> {
                if (selectedRowIndex == rowCount - 1) {
                } else {
                    jTableImport.changeSelection(selectedRowIndex++, 0, false, false);
                }
            }
        }
        
        showListDetailImport(listDip.getListTemp(jTableImport.getValueAt(selectedRowIndex, 0).toString()));
    }//GEN-LAST:event_jTableImportKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonCancle;
    private javax.swing.JButton buttonConfirm;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonFix;
    private javax.swing.JButton buttonSearchImport;
    private javax.swing.JComboBox<String> comboBoxProductName;
    private javax.swing.JComboBox<String> comboBoxSupplierName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableImport;
    private javax.swing.JTable jTableImportDetail;
    private javax.swing.JTable jTableTempImport;
    private java.awt.ScrollPane scrollPane1;
    private java.awt.ScrollPane scrollPane2;
    private java.awt.ScrollPane scrollPane3;
    private javax.swing.JTextField textFieldImportPrice;
    private javax.swing.JTextField textFieldProductPrice;
    private javax.swing.JTextField textFieldQuantity;
    private javax.swing.JTextField textFieldSearch;
    private javax.swing.JTextField textFieldTotalCost;
    // End of variables declaration//GEN-END:variables
}
