/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.CreateImage;
import javax.swing.table.DefaultTableModel;
import DTO.*;
import BUS.*;
import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author voota
 */
public class JPanelProduct extends javax.swing.JPanel {

    /**
     * Creates new form JPanelQuanLySanPham
     */
    private ListProduct listPd;
    private ProductBUS pdBUS;
    private ListDetailProduct listDpd;
    private String productID;
    private int selectedRowIndex;
    private boolean flat;

    public String getProductID() {
        return productID;
    }

    public int getSelectedRowIndex() {
        return selectedRowIndex;
    }

    public boolean isFlat() {
        return flat;
    }

    public JPanelProduct() {
        initComponents();
        init();
        editDisplay();
        this.setSize(960, 700);
        this.setVisible(true);
    }

    public final void editDisplay() {
        CreateImage cre = new CreateImage();
        cre.changeColorButton(buttonAdd);
        cre.changeColorButton(buttonFix);
        cre.changeColorButton(buttonRefesh);
        cre.changeColorButton(buttonSearch);

        cre.setIconForButton(buttonAdd, "add.png");
        cre.setIconForButton(buttonFix, "fix.png");
        cre.setIconForButton(buttonRefesh, "refesh.png");
        cre.setIconForButton(buttonSearch, "search.png");
    }

    private void init() {
        listPd = new ListProduct();
        listDpd = new ListDetailProduct();
        pdBUS = new ProductBUS(listPd, this);
        buttonFix.addActionListener(pdBUS);
        buttonAdd.addActionListener(pdBUS);
        buttonAddImg.addActionListener(pdBUS);
        buttonSearch.addActionListener(pdBUS);
        buttonRefesh.addActionListener(pdBUS);
        comboboxType.addActionListener(pdBUS);

        showListProduct(listPd.getList());
        setProductID();
        setSupplierName();
    }

    public javax.swing.JTextField getTextFiedProductName() {
        return textFiedProductName;
    }

    public javax.swing.JLabel getLableUnit() {
        return lableUnit;
    }

    public javax.swing.JButton getButtonAdd() {
        return buttonAdd;
    }

    public javax.swing.JButton getButtonAddImg() {
        return buttonAddImg;
    }

    public javax.swing.JButton getButtonFix() {
        return buttonFix;
    }

    public javax.swing.JButton getButtonRefesh() {
        return buttonRefesh;
    }

    public javax.swing.JButton getButtonSearch() {
        return buttonSearch;
    }

    public javax.swing.JComboBox<String> getComboboxStatus() {
        return comboboxStatus;
    }

    public javax.swing.JComboBox<String> getComboboxStatusSearch() {
        return comboboxStatusSearch;
    }

    public javax.swing.JComboBox<String> getComboboxSupplierName() {
        return comboboxSupplierName;
    }

    public javax.swing.JComboBox<String> getComboboxType() {
        return comboboxType;
    }

    public javax.swing.JLabel getFuelLabel() {
        return fuelLabel;
    }

    public javax.swing.JTable getJTableProduct() {
        return jTableProduct;
    }

    public javax.swing.JLabel getLabelPictureProduct() {
        return labelPictureProduct;
    }

    public javax.swing.JTextField getTextFieldProductName() {
        return textFiedProductName;
    }

    public javax.swing.JTextField getTextFieldFuel() {
        return textFieldFuel;
    }

    public javax.swing.JTextField getTextFieldMFG() {
        return textFieldMFG;
    }

    public javax.swing.JTextField getTextFieldPrice() {
        return textFieldPrice;
    }

    public javax.swing.JTextField getTextFieldProductID() {
        return textFieldProductID;
    }

    public javax.swing.JTextField getTextFieldQuantity() {
        return textFieldQuantity;
    }

    public javax.swing.JTextField getTextFieldSearch() {
        return textFieldSearch;
    }

    public javax.swing.JTextField getTextFieldSeat() {
        return textFieldSeat;
    }

    public javax.swing.JTextField getTxtFieldSeries() {
        return txtFieldSeries;
    }

    private void setSupplierName() {
        ListSupplier listSp = new ListSupplier();

        DefaultComboBoxModel<String> modelSupplier = new DefaultComboBoxModel<>();
        for (String item : listSp.getListSupplierName()) {
            modelSupplier.addElement(item);
        }

        comboboxSupplierName.setModel(modelSupplier);
    }

    private void setProductID() {
        jTableProduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedRowIndex = jTableProduct.getSelectedRow();
                productID = jTableProduct.getValueAt(selectedRowIndex, 0).toString();

                showInfor(productID);
            }
        });
    }

    public void showListProduct(ArrayList<ProductDTO> list) {
        DefaultTableModel productTable = (DefaultTableModel) jTableProduct.getModel();
        productTable.setRowCount(0);
        if (list == null) {
            return;
        }
        for (ProductDTO pdDTO : list) {
            boolean status = pdDTO.getStatus();
            String statusStr;
            if (status == true) {
                statusStr = "Còn bán";
            } else {
                statusStr = "Ngưng bán";
            }
            productTable.addRow(new Object[]{pdDTO.getProductID(), pdDTO.getSupplierID(), pdDTO.getProductName(), pdDTO.getSupplierName(), pdDTO.getType(), pdDTO.getQuantity(), pdDTO.getPrice(), statusStr});
        }
    }

    public void showInfor(String productID) {
        textFieldQuantity.setEnabled(false);
        buttonAdd.setEnabled(false);
        listDpd.updateList();
        int pdIndex = listPd.searchByProductID(productID);
        int pddIndex = listDpd.searchByProductID(productID);

        if (pdIndex < 0 || pddIndex < 0) {
            return;
        }
        ProductDTO pdDTO = listPd.getList().get(listPd.searchByProductID(productID));
        DetailProductDTO dpdDTO = listDpd.getList().get(listDpd.searchByProductID(productID));
        textFieldProductID.setText(productID);
        textFiedProductName.setText(pdDTO.getProductName());
        comboboxSupplierName.setSelectedItem(pdDTO.getSupplierName());
        String typeValue = pdDTO.getType();
        comboboxType.setSelectedItem(typeValue);
        textFieldQuantity.setText("" + pdDTO.getQuantity());
        textFieldPrice.setText("" + pdDTO.getPrice());

        boolean status = pdDTO.getStatus();
        String statusStr;
        if (status == true) {
            statusStr = "Còn bán";
        } else {
            statusStr = "Ngưng bán";
        }
        comboboxStatus.setSelectedItem(statusStr);

        int fuelValue;
        switch (typeValue) {
            case "ECar" -> {
                fuelValue = dpdDTO.getPin();
                fuelLabel.setText("Dung lượng pin");
            }
            default -> {
                fuelValue = dpdDTO.getPetrol();
                fuelLabel.setText("Dung tích bình xăng");
            }
        }

        textFieldMFG.setText(dpdDTO.getMFG());
        textFieldSeat.setText("" + dpdDTO.getSeat());
        txtFieldSeries.setText(dpdDTO.getSeries());
        textFieldFuel.setText("" + fuelValue);

        CreateImage ci = new CreateImage();
        String imgName = pdDTO.getProductName() + ".png";
        String imageURL = (ci.getImagePathAbsolute(imgName));
        ImageIcon originalIcon = new ImageIcon(imageURL);
        int labelWidth = panel.getWidth();
        int labelHeight = panel.getHeight();
        Image img = originalIcon.getImage();
        Image resizedImg = img.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImg);
        labelPictureProduct.setIcon(resizedIcon);
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
        jPanel13 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        textFiedProductName = new javax.swing.JTextField();
        textFieldQuantity = new javax.swing.JTextField();
        textFieldPrice = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        fuelLabel = new javax.swing.JLabel();
        textFieldMFG = new javax.swing.JTextField();
        textFieldSeat = new javax.swing.JTextField();
        txtFieldSeries = new javax.swing.JTextField();
        textFieldFuel = new javax.swing.JTextField();
        comboboxSupplierName = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        buttonAddImg = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        textFieldProductID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboboxStatus = new javax.swing.JComboBox<>();
        comboboxType = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        lableUnit = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        textFieldSearch = new javax.swing.JTextField();
        buttonSearch = new javax.swing.JButton();
        buttonAdd = new javax.swing.JButton();
        buttonFix = new javax.swing.JButton();
        buttonRefesh = new javax.swing.JButton();
        comboboxStatusSearch = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        scrollPane1 = new java.awt.ScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableProduct = new javax.swing.JTable();
        panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        labelPictureProduct = new javax.swing.JLabel();

        jLabel29.setText("Tên nhà cung cấp");

        jLabel30.setText("Loại xe");

        jLabel31.setText("Tên xe");

        jLabel27.setText("Số lượng");

        jLabel34.setText("Giá");

        textFiedProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFiedProductNameActionPerformed(evt);
            }
        });
        textFiedProductName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFiedProductNameKeyReleased(evt);
            }
        });

        textFieldQuantity.setEnabled(false);

        textFieldPrice.setEnabled(false);
        textFieldPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPriceActionPerformed(evt);
            }
        });

        jLabel1.setText("Năm sản xuất");

        jLabel9.setText("Số chỗ ngồi");

        jLabel10.setText("Dòng xe");

        fuelLabel.setText("Dung tích bình xăng");

        textFieldMFG.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldMFGFocusLost(evt);
            }
        });
        textFieldMFG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldMFGKeyReleased(evt);
            }
        });

        textFieldSeat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldSeatKeyReleased(evt);
            }
        });

        txtFieldSeries.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldSeriesKeyReleased(evt);
            }
        });

        textFieldFuel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldFuelActionPerformed(evt);
            }
        });
        textFieldFuel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldFuelKeyReleased(evt);
            }
        });

        comboboxSupplierName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxSupplierNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Hình ảnh");

        buttonAddImg.setText("Chọn ảnh");

        jLabel4.setText("Mã sản phẩm");

        textFieldProductID.setEnabled(false);

        jLabel5.setText("Trạng thái");

        comboboxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn bán", "Ngưng bán" }));
        comboboxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxStatusActionPerformed(evt);
            }
        });

        comboboxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Car", "ECar" }));

        jLabel6.setText("Triệu VND");

        lableUnit.setText("lít");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel31)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                            .addComponent(textFiedProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(jLabel27)
                                        .addGap(63, 63, 63))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(jLabel34)
                                    .addGap(93, 93, 93)))
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(textFieldPrice)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel6))
                                .addComponent(textFieldQuantity)
                                .addComponent(textFieldProductID)
                                .addComponent(comboboxType, 0, 152, Short.MAX_VALUE))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(18, 18, 18)
                        .addComponent(comboboxSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(fuelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(textFieldFuel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lableUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(textFieldSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldMFG, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFieldSeries, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonAddImg, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboboxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textFieldMFG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldProductID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textFieldSeat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(textFiedProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtFieldSeries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel29)
                    .addComponent(comboboxSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lableUnit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fuelLabel)
                        .addComponent(jLabel30)
                        .addComponent(comboboxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldFuel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel27)
                        .addComponent(textFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonAddImg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34)
                        .addComponent(textFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6))
                    .addComponent(comboboxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        textFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldSearchActionPerformed(evt);
            }
        });

        buttonSearch.setForeground(new java.awt.Color(0, 0, 0));
        buttonSearch.setText("Tìm kiếm");
        buttonSearch.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        buttonAdd.setForeground(new java.awt.Color(0, 0, 0));
        buttonAdd.setText("Thêm");
        buttonAdd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonFix.setForeground(new java.awt.Color(0, 0, 0));
        buttonFix.setText("Sửa");
        buttonFix.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonFix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFixActionPerformed(evt);
            }
        });

        buttonRefesh.setForeground(new java.awt.Color(0, 0, 0));
        buttonRefesh.setText("Làm mới");
        buttonRefesh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        comboboxStatusSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Còn bán", "Ngưng bán" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonFix, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonRefesh, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboboxStatusSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAdd)
                            .addComponent(buttonFix)
                            .addComponent(buttonRefesh)
                            .addComponent(comboboxStatusSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(buttonSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Quản lý sản phẩm");

        jTableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Mã nhà cung cấp", "Tên sản phẩm", "Tên nhà cung cấp", "Loại xe", "Số lượng", "Đơn giá(Triệu VND)", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableProductKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTableProduct);

        scrollPane1.add(jScrollPane3);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelPictureProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPictureProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldSearchActionPerformed

    private void textFiedProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFiedProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFiedProductNameActionPerformed

    private void buttonFixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonFixActionPerformed

    private void textFieldFuelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldFuelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldFuelActionPerformed

    private void comboboxSupplierNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxSupplierNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxSupplierNameActionPerformed

    private void comboboxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxStatusActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAddActionPerformed

    private void textFieldPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPriceActionPerformed

    private void textFiedProductNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFiedProductNameKeyReleased
        String productName = textFiedProductName.getText().trim();

        if (!Tool.isAdress(productName) || productName.length() > 50) {
            JOptionPane.showMessageDialog(this, "Tên xe không hợp lệ");
            textFiedProductName.setText("");
        } else if (!listPd.checkNameExist(productName)) {
            JOptionPane.showMessageDialog(this, "Tên nhà sản phẩm này đã được sử dụng.", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            textFiedProductName.setText("");
        }
    }//GEN-LAST:event_textFiedProductNameKeyReleased

    private void textFieldMFGKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldMFGKeyReleased
    }//GEN-LAST:event_textFieldMFGKeyReleased

    private void textFieldSeatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldSeatKeyReleased
        String seat = textFieldSeat.getText().trim();

        if (seat.isEmpty()) {
            return;
        }

        if (!Tool.isInt(seat)) {
            flat = true;
            JOptionPane.showMessageDialog(this, "số chõ ngồi không hơp lệ.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            textFieldSeat.setText("");
            textFieldSeat.requestFocus();
            flat = false;
        }
    }//GEN-LAST:event_textFieldSeatKeyReleased

    private void txtFieldSeriesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldSeriesKeyReleased
        String series = txtFieldSeries.getText().trim();

        if (!Tool.isName(series) || series.length()> 15) {
            flat = true;
            JOptionPane.showMessageDialog(this, "Dòng xe không hợp lệ");
            txtFieldSeries.setText("");
            txtFieldSeries.requestFocus();
            flat = false;
        }
    }//GEN-LAST:event_txtFieldSeriesKeyReleased

    private void textFieldFuelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldFuelKeyReleased
        String fuel = textFieldFuel.getText().trim();
        String carType = (String) comboboxType.getSelectedItem();

        if (fuel.isEmpty()) {
            return;
        }

        String textFuel;
        if (carType.equals("Car")) {
            textFuel = "Dung tích bình xăng";
        } else {
            textFuel = "Dung lượng pin";
        }

        if (!Tool.isInt(fuel)) {
            flat = true;
            JOptionPane.showMessageDialog(this, textFuel + " không hợp lệ.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            textFieldFuel.setText("");
            textFieldFuel.requestFocus();
            flat = false;
        }
    }//GEN-LAST:event_textFieldFuelKeyReleased

    private void textFieldMFGFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldMFGFocusLost
        String MFG = textFieldMFG.getText().trim();

        if (MFG.isEmpty()) {
            return;
        }

        if (!Tool.checkMFG(MFG)) {
            flat = true;
            JOptionPane.showMessageDialog(this, "Năm sản xuất không hợp lệ.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            textFieldMFG.setText("");
            textFieldMFG.requestFocus();
            flat = false;
        }
    }//GEN-LAST:event_textFieldMFGFocusLost

    private void jTableProductKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableProductKeyPressed
        selectedRowIndex = jTableProduct.getSelectedRow();
        int rowCount = jTableProduct.getRowCount();

        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP -> {
                if (selectedRowIndex > 0) {
                    jTableProduct.changeSelection(selectedRowIndex--, 0, false, false);
                } else {
                }
            }
            case KeyEvent.VK_DOWN -> {
                if (selectedRowIndex == rowCount - 1) {
                } else {
                    jTableProduct.changeSelection(selectedRowIndex++, 0, false, false);
                }
            }
        }
        productID = jTableProduct.getValueAt(selectedRowIndex, 0).toString();
        showInfor(productID);
    }//GEN-LAST:event_jTableProductKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonAddImg;
    private javax.swing.JButton buttonFix;
    private javax.swing.JButton buttonRefesh;
    private javax.swing.JButton buttonSearch;
    private javax.swing.JComboBox<String> comboboxStatus;
    private javax.swing.JComboBox<String> comboboxStatusSearch;
    private javax.swing.JComboBox<String> comboboxSupplierName;
    private javax.swing.JComboBox<String> comboboxType;
    private javax.swing.JLabel fuelLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableProduct;
    private javax.swing.JLabel labelPictureProduct;
    private javax.swing.JLabel lableUnit;
    public javax.swing.JPanel panel;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JTextField textFiedProductName;
    private javax.swing.JTextField textFieldFuel;
    private javax.swing.JTextField textFieldMFG;
    private javax.swing.JTextField textFieldPrice;
    private javax.swing.JTextField textFieldProductID;
    private javax.swing.JTextField textFieldQuantity;
    private javax.swing.JTextField textFieldSearch;
    private javax.swing.JTextField textFieldSeat;
    private javax.swing.JTextField txtFieldSeries;
    // End of variables declaration//GEN-END:variables
}
