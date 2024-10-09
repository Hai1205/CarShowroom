/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import GUI.*;
import DTO.*;
import DAL.ProductDAL;
import DAL.DetailProductDAL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.SwingUtilities;

/**
 *
 * @author ASUS
 */
public class ProductBUS implements ActionListener {

    private final ListProduct listPd;
    private final ListDetailProduct listDpd;
    private JPanelProduct jPanelProduct;
    private JPanelListProducts jPanelListProducts;

    private String productName, supplierName, type, price, MFG, seat, series, fuel, productID, info, employeeID, statusSearch, textFuel;
    private boolean status;

    public ProductBUS(ListProduct listPd, JPanelProduct jPanelProduct) {
        this.listPd = listPd;
        listDpd = new ListDetailProduct();
        this.jPanelProduct = jPanelProduct;

        jPanelProduct.getComboboxType().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                updateFuelLabel();
            }
        });
    }

    public ProductBUS(ListProduct listPd, JPanelListProducts jPanelListProducts, String employeeID) {
        this.employeeID = employeeID;
        this.listPd = listPd;
        listDpd = new ListDetailProduct();
        this.jPanelListProducts = jPanelListProducts;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jPanelProduct != null) {
            if ((e.getSource() == jPanelProduct.getButtonFix())) {
                fix();
            } else if (e.getSource() == jPanelProduct.getButtonAddImg()) {
                choseImg();
            } else if ((e.getSource() == jPanelProduct.getButtonRefesh())) {
                refesh();
            } else if ((e.getSource() == jPanelProduct.getButtonSearch())) {
                getInforJPanelProduct();
                jPanelProduct.showListProduct(search(info, statusSearch));
            } else if (e.getSource() == jPanelProduct.getButtonAdd()) {
                add();
            } else if (e.getSource() == jPanelProduct.getComboboxType()) {
                updateFuelLabel();
            }
        } else if (jPanelListProducts != null) {
            if ((e.getSource() == jPanelListProducts.getButtonSearchListProduct())) {
                getInforJPanelListProducts();
                jPanelListProducts.showListProduct(search(info, "Còn bán"));
            } else if (e.getSource() == jPanelListProducts.getButtonConfirm()) {
                confirm();
            } else if (e.getSource() == jPanelListProducts.getButtonCancel()) {
                cancel();
            } else if (e.getSource() == jPanelListProducts.getButtonRefesh()) {
                clearJPanelListProducts();
            }
        }
    }

    private void clearJPanelListProducts() {
        jPanelListProducts.getTextFieldSearch().setText("");
        jPanelListProducts.getLabelProductId().setText("");
        jPanelListProducts.getLabelProductMFG().setText("");
        jPanelListProducts.getLabelProductName().setText("");
        jPanelListProducts.getLabelProductType().setText("");
        jPanelListProducts.getLabelProductSeat().setText("");
        jPanelListProducts.getLabelProductPrice().setText("");
        jPanelListProducts.getLabelProductQuantity().setText("");
        jPanelListProducts.getLabelProductPicture().setIcon(null);

        jPanelListProducts.showListProduct(listPd.getListStillSell());
    }

    private void confirm() {
        if (jPanelListProducts.getIdProduct() == null) {
            JOptionPane.showMessageDialog(jPanelListProducts,
                    "Hãy chắc chắn bạn dã chọn sản phẩm trước khi xác nhận",
                    "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JPanelOrder order = new JPanelOrder(jPanelListProducts.getCustomerID(), this.employeeID, jPanelListProducts.getIdProduct(), jPanelListProducts.getOrders());
        MainFrameGUI main = (MainFrameGUI) SwingUtilities.getWindowAncestor(jPanelListProducts);
        main.getjPanelMain().removeAll();
        main.getjPanelMain().add(order).setVisible(true);
        main.pack();
    }

    private void cancel() {
        JPanelOrder order = new JPanelOrder(jPanelListProducts.getCustomerID(), jPanelListProducts.getEmployeeID(), null, jPanelListProducts.getOrders());
        MainFrameGUI main = (MainFrameGUI) SwingUtilities.getWindowAncestor(jPanelListProducts);
        main.getjPanelMain().removeAll();
        main.getjPanelMain().add(order).setVisible(true);
        main.pack();
    }

    private void choseImg() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "png"));

        int option = chooser.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            String imageName = jPanelProduct.getTextFieldProductName().getText().trim() + ".png";

            if (imageName.matches("[a-zA-Z0-9_-]+\\.png")) {
                File destinationDir = new File("./src/main/java/CarPhotos/");

                if (!destinationDir.exists()) {
                    destinationDir.mkdirs();
                }

                File destination = new File(destinationDir, imageName);

                if (destination.exists()) {
                    if (!destination.delete()) {
                        JOptionPane.showMessageDialog(jPanelProduct, "Không thể xóa tệp ảnh cũ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                try {
                    Files.copy(selectedFile.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(jPanelProduct, "Đã xảy ra lỗi khi sao chép ảnh.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(jPanelProduct, "Chỉ có thể chọn các ảnh có đuôi PNG.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void fix() {
        if (jPanelProduct.isFlat()) {
            return;
        }

        int selectedRow = jPanelProduct.getJTableProduct().getSelectedRow();
        getInforJPanelProduct();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(jPanelProduct, "Xin hãy chọn sản phẩm cần sửa.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!valid()) {
            return;
        }

        productID = jPanelProduct.getProductID();
        listPd.fix(selectedRow, productName, supplierName, Double.valueOf(price), status);
        listDpd.fix(productID, MFG, Integer.parseInt(seat), series, Integer.parseInt(fuel));
        ProductDAL.setAllProducts(listPd.getList());
        DetailProductDAL.setAllProductDetails(listDpd.getList());
        refesh();
    }

    private void refesh() {
        clearJPanelProduct();
        jPanelProduct.showListProduct(listPd.getList());
    }

    private ArrayList<ProductDTO> search(String info, String statusSearch) {
        ArrayList<ProductDTO> ls = listPd.search(info, statusSearch);

        if (ls.isEmpty()) {
            return null;
        }

        return ls;
    }

    private void clearJPanelProduct() {
        jPanelProduct.getButtonAdd().setEnabled(true);
        jPanelProduct.getTextFieldProductID().setText("");
        jPanelProduct.getTextFiedProductName().setText("");
        jPanelProduct.getTextFieldProductID().setText("");
        jPanelProduct.getComboboxSupplierName().setSelectedIndex(0);
        jPanelProduct.getComboboxType().setSelectedIndex(0);
        jPanelProduct.getComboboxStatus().setSelectedIndex(0);
        jPanelProduct.getTextFieldQuantity().setText("");
        jPanelProduct.getTextFieldPrice().setText("");
        jPanelProduct.getLabelPictureProduct().setIcon(null);

        jPanelProduct.getTextFieldMFG().setText("");
        jPanelProduct.getTextFieldSeat().setText("");
        jPanelProduct.getTxtFieldSeries().setText("");
        jPanelProduct.getTextFieldFuel().setText("");

        jPanelProduct.getTextFieldSearch().setText("");
        jPanelProduct.getComboboxStatusSearch().setSelectedIndex(0);
    }

    private void getInforJPanelProduct() {
        productID = jPanelProduct.getTextFieldProductID().getText().trim();
        if (productID == null || productID.isEmpty()) {
            productID = listPd.createProductID();
        }
        productName = jPanelProduct.getTextFieldProductName().getText().trim();
        supplierName = (String) jPanelProduct.getComboboxSupplierName().getSelectedItem();
        type = (String) jPanelProduct.getComboboxType().getSelectedItem();
        price = jPanelProduct.getTextFieldPrice().getText().trim();
        String statusStr = (String) jPanelProduct.getComboboxStatus().getSelectedItem();
        status = statusStr.equals("Còn bán");

        MFG = jPanelProduct.getTextFieldMFG().getText().trim();
        seat = jPanelProduct.getTextFieldSeat().getText().trim();
        series = jPanelProduct.getTxtFieldSeries().getText().trim();
        fuel = jPanelProduct.getTextFieldFuel().getText().trim();

        info = jPanelProduct.getTextFieldSearch().getText().trim();
        statusSearch = (String) jPanelProduct.getComboboxStatusSearch().getSelectedItem();
    }

    private void getInforJPanelListProducts() {
        info = jPanelListProducts.getTextFieldSearch().getText();
    }

    private void updateFuelLabel() {
        String carType = (String) jPanelProduct.getComboboxType().getSelectedItem();
        switch (carType) {
            case "Car" -> {
                textFuel = "Dung tích bình xăng";
                jPanelProduct.getFuelLabel().setText(textFuel);
                jPanelProduct.getLableUnit().setText("lít");
            }
            case "ECar" -> {
                textFuel = "Dung lượng pin";
                jPanelProduct.getFuelLabel().setText(textFuel);
                jPanelProduct.getLableUnit().setText("kWh");
            }
        }
    }

    private boolean valid() {
        if (productName == null || productName.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelProduct, "Tên xe không được để trống.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            jPanelProduct.getTextFiedProductName().requestFocus();
            return false;
        } else if (supplierName.equals("Nhấp để chọn")) {
            JOptionPane.showMessageDialog(jPanelProduct, "Vui lòng chọn nhà cung cấp.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            jPanelProduct.getComboboxSupplierName().requestFocus();
            return false;
        } else if (type == null || type.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelProduct, "Loại xe không được để trống.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            jPanelProduct.getComboboxType().requestFocus();
            return false;
        } else if (MFG == null || MFG.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelProduct, "Năm sản xuất không được để trống.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            jPanelProduct.getTextFieldMFG().requestFocus();
            return false;
        } else if (seat == null || seat.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelProduct, "Số chỗ ngồi không được để trống.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            jPanelProduct.getTextFieldSeat().requestFocus();
            return false;
        } else if (series == null || series.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelProduct, "Dòng xe không được để trống.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            jPanelProduct.getTxtFieldSeries().requestFocus();
            return false;
        } else if (fuel == null || fuel.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelProduct, textFuel + " không được để trống.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            jPanelProduct.getTextFieldFuel().requestFocus();
            return false;
        }
        return true;
    }

    public void add() {
        if (jPanelProduct.isFlat()) {
            return;
        }

        getInforJPanelProduct();
        if (!valid()) {
            return;
        }

        ListSupplier listSp = new ListSupplier();
        String suppierID = listSp.getSupplierID(supplierName);
        addProduct(productID, suppierID, productName, supplierName, type, 0, 0.0, status);
        if (type.equals("Car")) {
            addProductDetail(productID, MFG, Integer.parseInt(seat), series, Integer.parseInt(fuel), 0);
        } else {
            addProductDetail(productID, MFG, Integer.parseInt(seat), series, 0, Integer.parseInt(fuel));
        }
        refesh();
    }

    public void addProduct(String productID, String supplierID, String productName, String supplierName, String type, int quantity, Double price, boolean status) {
        if (productID == null) {
            productID = listPd.createProductID();
        }
        listPd.add(productID, supplierID, productName, supplierName, type, quantity, price, status);
        ProductDAL.setAllProducts(listPd.getList());
    }

    public void addProductDetail(String productID, String MFG, int seat, String series, int petrol, int pin) {
        listDpd.add(productID, MFG, seat, series, petrol, pin);
        DetailProductDAL.setAllProductDetails(listDpd.getList());
    }
}
