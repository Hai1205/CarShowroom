/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import DTO.*;
import BUS.*;
import java.awt.Component;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author voota
 */
public class JPanelEmployee extends javax.swing.JPanel {

    /**
     * Creates new form JPanelQuanLyNhanVien
     */
    private EmployeeBUS epBUS;
    private int selectedRowIndex;
    private boolean flat;

    public boolean isFlat() {
        return flat;
    }

    public JPanelEmployee() {
        initComponents();
        init();
        editDisplay();
        this.setSize(960, 700);
        this.setVisible(true);
    }

    private void init() {
        ListEmployee listEp = new ListEmployee();
        epBUS = new EmployeeBUS(listEp, this);
        buttonAdd.addActionListener(epBUS);
        buttonFix.addActionListener(epBUS);
        buttonShowAll.addActionListener(epBUS);
        buttonSearchEmployee.addActionListener(epBUS);

        jTableEmployee.getColumnModel().getColumn(2).setCellRenderer(new PasswordCellRenderer());

        setEmployee();
        showList(listEp.getList());
    }

    public javax.swing.JButton getButtonAdd() {
        return buttonAdd;
    }

    public javax.swing.JButton getButtonFix() {
        return buttonFix;
    }

    public javax.swing.JButton getButtonSearchEmployee() {
        return buttonSearchEmployee;
    }

    public javax.swing.JButton getButtonShowAll() {
        return buttonShowAll;
    }

    public javax.swing.JComboBox<String> getComboBoxEmployeeStatus() {
        return comboBoxEmployeeStatus;
    }

    public javax.swing.JComboBox<String> getComboboxStatusSearch() {
        return comboboxStatusSearch;
    }

    public javax.swing.JTable getJTableEmployee() {
        return jTableEmployee;
    }

    public javax.swing.JCheckBox getShowPassword() {
        return showPassword;
    }

    public javax.swing.JTextField getTextFieldEmployeeDOB() {
        return textFieldEmployeeDOB;
    }

    public javax.swing.JTextField getTextFieldEmployeeFirstname() {
        return textFieldEmployeeFirstname;
    }

    public javax.swing.JTextField getTextFieldEmployeeID() {
        return textFieldEmployeeID;
    }

    public javax.swing.JTextField getTextFieldEmployeeLastname() {
        return textFieldEmployeeLastname;
    }

    public javax.swing.JPasswordField getTextFieldEmployeePassword() {
        return textFieldEmployeePassword;
    }

    public javax.swing.JTextField getTextFieldEmployeeSalary() {
        return textFieldEmployeeSalary;
    }

    public javax.swing.JTextField getTextFieldEmployeeUsername() {
        return textFieldEmployeeUsername;
    }

    public javax.swing.JTextField getTextFieldSearch() {
        return textFieldSearch;
    }

    public final void editDisplay() {
        CreateImage cre = new CreateImage();
        cre.changeColorButton(buttonAdd);
        cre.changeColorButton(buttonFix);
        cre.changeColorButton(buttonSearchEmployee);
        cre.changeColorButton(buttonShowAll);
        cre.setIconForButton(buttonAdd, "add.png");
        cre.setIconForButton(buttonFix, "fix.png");
        cre.setIconForButton(buttonSearchEmployee, "search.png");
        cre.setIconForButton(buttonShowAll, "refesh.png");
    }

    static class PasswordCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value != null) {
                String password = value.toString();
                String maskedPassword = "*".repeat(password.length());
                value = maskedPassword;
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }

    private void setEmployee() {
        jTableEmployee.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedRowIndex = jTableEmployee.getSelectedRow();
                showInfo();
            }
        });
    }

    private void showInfo() {
        epBUS.setEnabled(false);
        textFieldEmployeeID.setText(jTableEmployee.getValueAt(selectedRowIndex, 0).toString());
        textFieldEmployeeUsername.setText(jTableEmployee.getValueAt(selectedRowIndex, 1).toString());
        textFieldEmployeePassword.setText(jTableEmployee.getValueAt(selectedRowIndex, 2).toString());
        textFieldEmployeeFirstname.setText(jTableEmployee.getValueAt(selectedRowIndex, 3).toString());
        textFieldEmployeeLastname.setText(jTableEmployee.getValueAt(selectedRowIndex, 4).toString());
        textFieldEmployeeDOB.setText(jTableEmployee.getValueAt(selectedRowIndex, 5).toString());
        textFieldEmployeeSalary.setText(jTableEmployee.getValueAt(selectedRowIndex, 6).toString());
        comboBoxEmployeeStatus.setSelectedItem(jTableEmployee.getValueAt(selectedRowIndex, 7).toString());
    }

    public void showList(ArrayList<EmployeeDTO> list) {
        DefaultTableModel employeeTable = (DefaultTableModel) jTableEmployee.getModel();
        employeeTable.setRowCount(0);
        if (list == null) {
            return;
        }
        for (EmployeeDTO epDTO : list) {
            boolean status = epDTO.getStatus();
            String statusStr;
            if (status == true) {
                statusStr = "Còn làm việc";
            } else {
                statusStr = "Đã nghỉ việc";
            }
            employeeTable.addRow(new Object[]{epDTO.getEmployeeID(), epDTO.getUsername(), epDTO.getPassword(), epDTO.getFirstname(), epDTO.getLastname(), epDTO.getDOB(), epDTO.getSalary(), statusStr});
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textFieldEmployeeUsername = new javax.swing.JTextField();
        textFieldEmployeePassword = new javax.swing.JPasswordField();
        showPassword = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        textFieldEmployeeID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        comboBoxEmployeeStatus = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        buttonAdd = new javax.swing.JButton();
        buttonFix = new javax.swing.JButton();
        buttonShowAll = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        textFieldSearch = new javax.swing.JTextField();
        buttonSearchEmployee = new javax.swing.JButton();
        comboboxStatusSearch = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        scrollPane2 = new java.awt.ScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEmployee = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        textFieldEmployeeFirstname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textFieldEmployeeLastname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textFieldEmployeeDOB = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textFieldEmployeeSalary = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        jLabel1.setText("Mật khẩu");

        jLabel2.setText("Tên đăng nhập");

        textFieldEmployeeUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldEmployeeUsernameKeyReleased(evt);
            }
        });

        textFieldEmployeePassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldEmployeePasswordFocusLost(evt);
            }
        });
        textFieldEmployeePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldEmployeePasswordActionPerformed(evt);
            }
        });
        textFieldEmployeePassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldEmployeePasswordKeyReleased(evt);
            }
        });

        showPassword.setText("Hiện mật khẩu");
        showPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã nhân viên");

        textFieldEmployeeID.setEnabled(false);

        jLabel9.setText("Trạng thái");

        comboBoxEmployeeStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn làm việc", "Đã nghỉ việc" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(textFieldEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxEmployeeStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFieldEmployeeUsername)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textFieldEmployeePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(showPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textFieldEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxEmployeeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldEmployeeUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldEmployeePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showPassword)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        buttonAdd.setForeground(new java.awt.Color(0, 0, 0));
        buttonAdd.setText("Thêm");
        buttonAdd.setBorderPainted(false);

        buttonFix.setForeground(new java.awt.Color(0, 0, 0));
        buttonFix.setText("Sửa");
        buttonFix.setBorderPainted(false);
        buttonFix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFixActionPerformed(evt);
            }
        });

        buttonShowAll.setForeground(new java.awt.Color(0, 0, 0));
        buttonShowAll.setText("Làm mới");
        buttonShowAll.setBorderPainted(false);
        buttonShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonShowAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonShowAll, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonFix, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonFix, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonShowAll, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldSearchActionPerformed(evt);
            }
        });
        jPanel3.add(textFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 590, -1));

        buttonSearchEmployee.setForeground(new java.awt.Color(0, 0, 0));
        buttonSearchEmployee.setText("Tìm kiếm");
        buttonSearchEmployee.setBorderPainted(false);
        buttonSearchEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchEmployeeActionPerformed(evt);
            }
        });
        jPanel3.add(buttonSearchEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 140, 40));

        comboboxStatusSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Còn làm việc", "Đã nghỉ việc" }));
        jPanel3.add(comboboxStatusSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Thông tin nhân viên");

        jTableEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên đăng nhập ", "Mật khẩu", "Họ ", "Tên", "Ngày sinh", "Lương(Triệu VND)", "Trạng thái"
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
        jTableEmployee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableEmployeeKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTableEmployee);

        scrollPane2.add(jScrollPane2);

        jLabel3.setText("Họ nhân viên");

        textFieldEmployeeFirstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldEmployeeFirstnameActionPerformed(evt);
            }
        });
        textFieldEmployeeFirstname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldEmployeeFirstnameKeyReleased(evt);
            }
        });

        jLabel5.setText("Tên nhân viên");

        textFieldEmployeeLastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldEmployeeLastnameActionPerformed(evt);
            }
        });
        textFieldEmployeeLastname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldEmployeeLastnameKeyReleased(evt);
            }
        });

        jLabel4.setText("Ngày sinh(dd/MM/yyyy)");

        textFieldEmployeeDOB.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldEmployeeDOBFocusLost(evt);
            }
        });
        textFieldEmployeeDOB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldEmployeeDOBActionPerformed(evt);
            }
        });
        textFieldEmployeeDOB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldEmployeeDOBKeyReleased(evt);
            }
        });

        jLabel6.setText("Lương");

        textFieldEmployeeSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldEmployeeSalaryActionPerformed(evt);
            }
        });
        textFieldEmployeeSalary.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldEmployeeSalaryKeyReleased(evt);
            }
        });

        jLabel10.setText("Triệu VND");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(40, 40, 40))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(textFieldEmployeeSalary)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10))
                            .addComponent(textFieldEmployeeDOB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                        .addGap(84, 84, 84)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldEmployeeLastname)
                            .addComponent(textFieldEmployeeFirstname))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textFieldEmployeeFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textFieldEmployeeLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textFieldEmployeeDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textFieldEmployeeSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(scrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldEmployeeFirstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldEmployeeFirstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldEmployeeFirstnameActionPerformed

    private void textFieldEmployeeDOBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldEmployeeDOBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldEmployeeDOBActionPerformed

    private void textFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldSearchActionPerformed

    private void buttonSearchEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchEmployeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSearchEmployeeActionPerformed

    private void textFieldEmployeeSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldEmployeeSalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldEmployeeSalaryActionPerformed

    private void buttonFixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonFixActionPerformed

    private void textFieldEmployeeLastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldEmployeeLastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldEmployeeLastnameActionPerformed

    private void buttonShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShowAllActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonShowAllActionPerformed

    private void textFieldEmployeePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldEmployeePasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldEmployeePasswordActionPerformed

    private void showPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordActionPerformed
        if (showPassword.isSelected()) {
            textFieldEmployeePassword.setEchoChar((char) 0);
        } else {
            textFieldEmployeePassword.setEchoChar('*');
        }
    }//GEN-LAST:event_showPasswordActionPerformed

    private void textFieldEmployeeUsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldEmployeeUsernameKeyReleased
        String username = textFieldEmployeeUsername.getText().trim();

        if (username.isEmpty()) {
            return;
        }

        if (!Tool.checkUserName(username)) {
            flat = true;
            JOptionPane.showMessageDialog(this, "Tên đăng nhập không hợp lệ.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            textFieldEmployeeUsername.setText("");
            textFieldEmployeeUsername.requestFocus();
            flat = false;
        } else if (epBUS.searchByUsername(username)) {
            flat = true;
            JOptionPane.showMessageDialog(this, "Tên đăng nhập này đã được sử dụng.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            textFieldEmployeeUsername.setText("");
            textFieldEmployeeUsername.requestFocus();
            flat = false;
        }
    }//GEN-LAST:event_textFieldEmployeeUsernameKeyReleased

    private void textFieldEmployeePasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldEmployeePasswordKeyReleased
    }//GEN-LAST:event_textFieldEmployeePasswordKeyReleased

    private void textFieldEmployeeFirstnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldEmployeeFirstnameKeyReleased
        String firstname = textFieldEmployeeFirstname.getText().trim();

        if (firstname.isEmpty()) {
            return;
        }

        if (!Tool.isName(firstname)) {
            flat = true;
            JOptionPane.showMessageDialog(this, "Họ của nhân viên không hợp lệ");
            textFieldEmployeeFirstname.setText("");
            textFieldEmployeeFirstname.requestFocus();
            flat = false;
        }
    }//GEN-LAST:event_textFieldEmployeeFirstnameKeyReleased

    private void textFieldEmployeeLastnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldEmployeeLastnameKeyReleased
        String lastname = textFieldEmployeeLastname.getText().trim();

        if (lastname.isEmpty()) {
            return;
        }

        if (!Tool.isName(lastname)) {
            flat = true;
            JOptionPane.showMessageDialog(this, "Tên của nhân viên không hợp lệ");
            textFieldEmployeeLastname.setText("");
            textFieldEmployeeLastname.requestFocus();
            flat = false;
        }
    }//GEN-LAST:event_textFieldEmployeeLastnameKeyReleased

    private void textFieldEmployeeDOBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldEmployeeDOBKeyReleased
    }//GEN-LAST:event_textFieldEmployeeDOBKeyReleased

    private void textFieldEmployeeSalaryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldEmployeeSalaryKeyReleased
        String salary = textFieldEmployeeSalary.getText().trim();

        if (salary.isEmpty()) {
            return;
        }

        if (!Tool.isDouble(salary)) {
            flat = true;
            JOptionPane.showMessageDialog(this, "Tiền lương phải là số dương.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            textFieldEmployeeSalary.setText("");
            textFieldEmployeeSalary.requestFocus();
            flat = false;
        }
    }//GEN-LAST:event_textFieldEmployeeSalaryKeyReleased

    private void textFieldEmployeeDOBFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldEmployeeDOBFocusLost
        String DOB = textFieldEmployeeDOB.getText().trim();

        if (DOB.isEmpty()) {
            return;
        }

        if (!Tool.isValidDate(DOB)) {
            flat = true;
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng ngày sinh(dd/MM/yyyy)", "Thông báo", JOptionPane.WARNING_MESSAGE);
            textFieldEmployeeDOB.setText("");
            textFieldEmployeeDOB.requestFocus();
            flat = false;
        } else if (!Tool.isEligibleToWork(DOB)) {
            flat=true;
            JOptionPane.showMessageDialog(this, "Tuổi của nhân viên không hợp lệ", "Thông báo", JOptionPane.WARNING_MESSAGE);
            textFieldEmployeeDOB.setText("");
            textFieldEmployeeDOB.requestFocus();
            flat = false;
        }
    }//GEN-LAST:event_textFieldEmployeeDOBFocusLost

    private void textFieldEmployeePasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldEmployeePasswordFocusLost
        String password = textFieldEmployeePassword.getText().trim();

        if (password.isEmpty()) {
            return;
        }

        if (!Tool.checkPassword(password)) {
            flat = true;
            JOptionPane.showMessageDialog(this, "Mật khẩu phải chứa ít nhất: \n6 ký tự.\n1 ký tự viết thường.\n1 ký tự viết hoa.\n1 chữ số.\n1 ký tự đặc biệt.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            textFieldEmployeePassword.setText("");
            textFieldEmployeePassword.requestFocus();
            flat = false;
        }
    }//GEN-LAST:event_textFieldEmployeePasswordFocusLost

    private void jTableEmployeeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableEmployeeKeyPressed
        selectedRowIndex = jTableEmployee.getSelectedRow();
        int rowCount = jTableEmployee.getRowCount();

        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP -> {
                if (selectedRowIndex > 0) {
                    jTableEmployee.changeSelection(selectedRowIndex--, 0, false, false);
                } else {
                }
            }
            case KeyEvent.VK_DOWN -> {
                if (selectedRowIndex == rowCount - 1) {
                } else {
                    jTableEmployee.changeSelection(selectedRowIndex++, 0, false, false);
                }
            }
        }
        showInfo();
    }//GEN-LAST:event_jTableEmployeeKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonFix;
    private javax.swing.JButton buttonSearchEmployee;
    private javax.swing.JButton buttonShowAll;
    private javax.swing.JComboBox<String> comboBoxEmployeeStatus;
    private javax.swing.JComboBox<String> comboboxStatusSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEmployee;
    private java.awt.ScrollPane scrollPane2;
    private javax.swing.JCheckBox showPassword;
    private javax.swing.JTextField textFieldEmployeeDOB;
    private javax.swing.JTextField textFieldEmployeeFirstname;
    private javax.swing.JTextField textFieldEmployeeID;
    private javax.swing.JTextField textFieldEmployeeLastname;
    private javax.swing.JPasswordField textFieldEmployeePassword;
    private javax.swing.JTextField textFieldEmployeeSalary;
    private javax.swing.JTextField textFieldEmployeeUsername;
    private javax.swing.JTextField textFieldSearch;
    // End of variables declaration//GEN-END:variables
}
