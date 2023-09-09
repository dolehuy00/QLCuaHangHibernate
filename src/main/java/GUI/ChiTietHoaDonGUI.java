
package GUI;

import BLL.categoryBLL;
import BLL.customerBLL;
import BLL.orderBLL;
import BLL.vegetableBLL;
import DAL.OrderVegetable;
import DAL.customers;
import DAL.order;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.table.*;

public class ChiTietHoaDonGUI extends javax.swing.JFrame {
    order order;
    
    vegetableBLL vegetableBLL;// = new vegetableBLL();
    categoryBLL categoryBLL = new categoryBLL();
    customerBLL customerBLL= new customerBLL();
    orderBLL orderBLL;
    JComboBox cbb_cate_add_vege, cbb_customer;
    
    public ChiTietHoaDonGUI(orderBLL odBLL) {
        vegetableBLL= new vegetableBLL();
        this.orderBLL = odBLL;
        order = new order();
        initComponents();
        CustomCode();
        NewOrderGUI();
    }

    public ChiTietHoaDonGUI(order order, orderBLL odBLL) {
        vegetableBLL= new vegetableBLL();
        this.orderBLL = odBLL;
        this.order = order;
        initComponents();
        CustomCode();
        SetInfomation();
        LoadVegtableOrder();
    }
    
    public ChiTietHoaDonGUI() {
        initComponents();
        CustomCode();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialog_searchProduct = new javax.swing.JDialog();
        container_searchProduct = new javax.swing.JPanel();
        text_search_vegetable = new javax.swing.JTextField();
        scrollpane_add_vegetable = new javax.swing.JScrollPane();
        table_add_vegetable = new javax.swing.JTable();
        container_all = new javax.swing.JPanel();
        scroll_tableProduct = new javax.swing.JScrollPane();
        table_product = new javax.swing.JTable();
        pnl_note = new javax.swing.JPanel();
        scroll_note = new javax.swing.JScrollPane();
        text_note = new javax.swing.JTextArea();
        pnl_id = new javax.swing.JPanel();
        text_id = new javax.swing.JTextField();
        pnl_customer = new javax.swing.JPanel();
        text_customer = new javax.swing.JTextField();
        pnl_date = new javax.swing.JPanel();
        text_date = new javax.swing.JTextField();
        pnl_address = new javax.swing.JPanel();
        text_address = new javax.swing.JTextField();
        pnl_city = new javax.swing.JPanel();
        text_city = new javax.swing.JTextField();
        label_product = new javax.swing.JLabel();
        btn_addProduct = new javax.swing.JButton();
        pnl_action = new javax.swing.JPanel();
        btn_edit = new javax.swing.JButton();
        btn_saveAdd = new javax.swing.JButton();
        btn_saveEdit = new javax.swing.JButton();
        label_total = new javax.swing.JLabel();
        label_total1 = new javax.swing.JLabel();

        dialog_searchProduct.setLocation(new java.awt.Point(0, 0));
        dialog_searchProduct.setMaximumSize(new java.awt.Dimension(630, 345));
        dialog_searchProduct.setMinimumSize(new java.awt.Dimension(630, 345));
        dialog_searchProduct.setUndecorated(true);
        dialog_searchProduct.setPreferredSize(new java.awt.Dimension(630, 345));
        dialog_searchProduct.setResizable(false);
        dialog_searchProduct.setType(java.awt.Window.Type.POPUP);
        dialog_searchProduct.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                dialog_searchProductWindowDeactivated(evt);
            }
        });

        container_searchProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        container_searchProduct.setMaximumSize(new java.awt.Dimension(450, 300));
        container_searchProduct.setMinimumSize(new java.awt.Dimension(450, 300));
        container_searchProduct.setPreferredSize(new java.awt.Dimension(450, 300));
        container_searchProduct.setLayout(null);

        text_search_vegetable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_search_vegetableKeyReleased(evt);
            }
        });
        container_searchProduct.add(text_search_vegetable);
        text_search_vegetable.setBounds(10, 10, 450, 30);

        table_add_vegetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Unit", "Quantity", "+"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_add_vegetable.setRowHeight(50);
        scrollpane_add_vegetable.setViewportView(table_add_vegetable);
        if (table_add_vegetable.getColumnModel().getColumnCount() > 0) {
            table_add_vegetable.getColumnModel().getColumn(0).setMinWidth(30);
            table_add_vegetable.getColumnModel().getColumn(0).setPreferredWidth(30);
            table_add_vegetable.getColumnModel().getColumn(0).setMaxWidth(30);
            table_add_vegetable.getColumnModel().getColumn(2).setMinWidth(90);
            table_add_vegetable.getColumnModel().getColumn(2).setPreferredWidth(90);
            table_add_vegetable.getColumnModel().getColumn(2).setMaxWidth(90);
            table_add_vegetable.getColumnModel().getColumn(3).setMinWidth(50);
            table_add_vegetable.getColumnModel().getColumn(3).setPreferredWidth(50);
            table_add_vegetable.getColumnModel().getColumn(3).setMaxWidth(50);
            table_add_vegetable.getColumnModel().getColumn(4).setMinWidth(70);
            table_add_vegetable.getColumnModel().getColumn(4).setPreferredWidth(70);
            table_add_vegetable.getColumnModel().getColumn(4).setMaxWidth(70);
            table_add_vegetable.getColumnModel().getColumn(5).setMinWidth(70);
            table_add_vegetable.getColumnModel().getColumn(5).setPreferredWidth(70);
            table_add_vegetable.getColumnModel().getColumn(5).setMaxWidth(70);
        }

        container_searchProduct.add(scrollpane_add_vegetable);
        scrollpane_add_vegetable.setBounds(10, 50, 600, 290);

        dialog_searchProduct.getContentPane().add(container_searchProduct, java.awt.BorderLayout.CENTER);

        dialog_searchProduct.getAccessibleContext().setAccessibleDescription("");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Order 1");
        setBackground(null);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1000, 655));
        setName("HoaDon"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 655));
        getContentPane().setLayout(null);

        container_all.setBackground(new java.awt.Color(255, 255, 255));
        container_all.setLayout(null);

        table_product.setAutoCreateRowSorter(true);
        table_product.getTableHeader().setBackground(new Color(0, 0, 60));
        table_product.getTableHeader().setForeground(Color.white);
        table_product.setPreferredScrollableViewportSize(new Dimension(970, 320));
        table_product.setBackground(java.awt.Color.white);
        table_product.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table_product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID", "Name", "Quantity", "Unit", "Price", "Total Price", "Tool"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_product.setToolTipText("");
        table_product.setEnabled(false);
        table_product.setGridColor(new java.awt.Color(0, 0, 60));
        table_product.setInheritsPopupMenu(true);
        table_product.setRowHeight(50);
        scroll_tableProduct.setViewportView(table_product);
        if (table_product.getColumnModel().getColumnCount() > 0) {
            table_product.getColumnModel().getColumn(0).setMinWidth(50);
            table_product.getColumnModel().getColumn(0).setPreferredWidth(50);
            table_product.getColumnModel().getColumn(0).setMaxWidth(50);
            table_product.getColumnModel().getColumn(1).setMinWidth(50);
            table_product.getColumnModel().getColumn(1).setPreferredWidth(50);
            table_product.getColumnModel().getColumn(1).setMaxWidth(50);
            table_product.getColumnModel().getColumn(3).setMinWidth(100);
            table_product.getColumnModel().getColumn(3).setPreferredWidth(100);
            table_product.getColumnModel().getColumn(3).setMaxWidth(100);
            table_product.getColumnModel().getColumn(4).setMinWidth(70);
            table_product.getColumnModel().getColumn(4).setPreferredWidth(70);
            table_product.getColumnModel().getColumn(4).setMaxWidth(70);
            table_product.getColumnModel().getColumn(5).setMinWidth(100);
            table_product.getColumnModel().getColumn(5).setPreferredWidth(100);
            table_product.getColumnModel().getColumn(5).setMaxWidth(100);
            table_product.getColumnModel().getColumn(6).setMinWidth(100);
            table_product.getColumnModel().getColumn(6).setPreferredWidth(100);
            table_product.getColumnModel().getColumn(6).setMaxWidth(100);
            table_product.getColumnModel().getColumn(7).setMinWidth(100);
            table_product.getColumnModel().getColumn(7).setPreferredWidth(100);
            table_product.getColumnModel().getColumn(7).setMaxWidth(100);
        }

        container_all.add(scroll_tableProduct);
        scroll_tableProduct.setBounds(30, 290, 920, 270);

        pnl_note.setBackground(java.awt.Color.white);
        pnl_note.setBorder(javax.swing.BorderFactory.createTitledBorder("Note"));
        pnl_note.setForeground(new java.awt.Color(0, 0, 0));

        scroll_note.setBorder(null);
        scroll_note.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        text_note.setBackground(java.awt.Color.white);
        text_note.setColumns(20);
        text_note.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        text_note.setForeground(new java.awt.Color(0, 0, 0));
        text_note.setLineWrap(true);
        text_note.setRows(1);
        text_note.setBorder(null);
        scroll_note.setViewportView(text_note);

        javax.swing.GroupLayout pnl_noteLayout = new javax.swing.GroupLayout(pnl_note);
        pnl_note.setLayout(pnl_noteLayout);
        pnl_noteLayout.setHorizontalGroup(
            pnl_noteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_noteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll_note, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_noteLayout.setVerticalGroup(
            pnl_noteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_noteLayout.createSequentialGroup()
                .addComponent(scroll_note, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addContainerGap())
        );

        container_all.add(pnl_note);
        pnl_note.setBounds(30, 150, 920, 100);

        pnl_id.setBackground(java.awt.Color.white);
        pnl_id.setBorder(javax.swing.BorderFactory.createTitledBorder("ID"));
        pnl_id.setForeground(new java.awt.Color(0, 0, 0));
        pnl_id.setMinimumSize(new java.awt.Dimension(170, 60));
        pnl_id.setPreferredSize(new java.awt.Dimension(170, 60));

        text_id.setBackground(java.awt.Color.white);
        text_id.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        text_id.setForeground(new java.awt.Color(0, 0, 0));
        text_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_id.setBorder(null);

        javax.swing.GroupLayout pnl_idLayout = new javax.swing.GroupLayout(pnl_id);
        pnl_id.setLayout(pnl_idLayout);
        pnl_idLayout.setHorizontalGroup(
            pnl_idLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_idLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text_id, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_idLayout.setVerticalGroup(
            pnl_idLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_idLayout.createSequentialGroup()
                .addComponent(text_id, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        text_id.getAccessibleContext().setAccessibleName("");

        container_all.add(pnl_id);
        pnl_id.setBounds(30, 10, 200, 60);

        pnl_customer.setBackground(java.awt.Color.white);
        pnl_customer.setBorder(javax.swing.BorderFactory.createTitledBorder("Customer"));
        pnl_customer.setForeground(new java.awt.Color(0, 0, 0));

        text_customer.setEditable(false);
        text_customer.setBackground(java.awt.Color.white);
        text_customer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        text_customer.setForeground(new java.awt.Color(0, 0, 0));
        text_customer.setBorder(null);

        javax.swing.GroupLayout pnl_customerLayout = new javax.swing.GroupLayout(pnl_customer);
        pnl_customer.setLayout(pnl_customerLayout);
        pnl_customerLayout.setHorizontalGroup(
            pnl_customerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_customerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text_customer, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_customerLayout.setVerticalGroup(
            pnl_customerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_customerLayout.createSequentialGroup()
                .addComponent(text_customer, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        container_all.add(pnl_customer);
        pnl_customer.setBounds(260, 10, 420, 60);

        pnl_date.setBackground(java.awt.Color.white);
        pnl_date.setBorder(javax.swing.BorderFactory.createTitledBorder("Date"));
        pnl_date.setForeground(new java.awt.Color(0, 0, 0));
        pnl_date.setMinimumSize(new java.awt.Dimension(300, 60));
        pnl_date.setPreferredSize(new java.awt.Dimension(300, 60));

        text_date.setEditable(false);
        text_date.setBackground(java.awt.Color.white);
        text_date.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        text_date.setForeground(new java.awt.Color(0, 0, 0));
        text_date.setBorder(null);

        javax.swing.GroupLayout pnl_dateLayout = new javax.swing.GroupLayout(pnl_date);
        pnl_date.setLayout(pnl_dateLayout);
        pnl_dateLayout.setHorizontalGroup(
            pnl_dateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_dateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text_date, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_dateLayout.setVerticalGroup(
            pnl_dateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_dateLayout.createSequentialGroup()
                .addComponent(text_date, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        container_all.add(pnl_date);
        pnl_date.setBounds(30, 80, 200, 60);

        pnl_address.setBackground(java.awt.Color.white);
        pnl_address.setBorder(javax.swing.BorderFactory.createTitledBorder("Address"));
        pnl_address.setForeground(new java.awt.Color(0, 0, 0));
        pnl_address.setMinimumSize(new java.awt.Dimension(300, 60));
        pnl_address.setPreferredSize(new java.awt.Dimension(300, 60));

        text_address.setEditable(false);
        text_address.setBackground(java.awt.Color.white);
        text_address.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        text_address.setForeground(new java.awt.Color(0, 0, 0));
        text_address.setBorder(null);

        javax.swing.GroupLayout pnl_addressLayout = new javax.swing.GroupLayout(pnl_address);
        pnl_address.setLayout(pnl_addressLayout);
        pnl_addressLayout.setHorizontalGroup(
            pnl_addressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_addressLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text_address, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_addressLayout.setVerticalGroup(
            pnl_addressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_addressLayout.createSequentialGroup()
                .addComponent(text_address, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        container_all.add(pnl_address);
        pnl_address.setBounds(260, 80, 420, 60);

        pnl_city.setBackground(java.awt.Color.white);
        pnl_city.setBorder(javax.swing.BorderFactory.createTitledBorder("City"));
        pnl_city.setForeground(new java.awt.Color(0, 0, 0));
        pnl_city.setMinimumSize(new java.awt.Dimension(300, 60));
        pnl_city.setPreferredSize(new java.awt.Dimension(300, 60));

        text_city.setEditable(false);
        text_city.setBackground(java.awt.Color.white);
        text_city.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        text_city.setForeground(new java.awt.Color(0, 0, 0));
        text_city.setBorder(null);

        javax.swing.GroupLayout pnl_cityLayout = new javax.swing.GroupLayout(pnl_city);
        pnl_city.setLayout(pnl_cityLayout);
        pnl_cityLayout.setHorizontalGroup(
            pnl_cityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cityLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text_city, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_cityLayout.setVerticalGroup(
            pnl_cityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cityLayout.createSequentialGroup()
                .addComponent(text_city, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        container_all.add(pnl_city);
        pnl_city.setBounds(710, 80, 240, 60);

        label_product.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_product.setForeground(new java.awt.Color(0, 0, 0));
        label_product.setText("Product");
        container_all.add(label_product);
        label_product.setBounds(30, 260, 90, 20);

        btn_addProduct.setVisible(false);
        btn_addProduct.setBackground(new java.awt.Color(0, 0, 60));
        btn_addProduct.setForeground(java.awt.Color.white);
        btn_addProduct.setText("Add Product");
        btn_addProduct.setToolTipText("");
        btn_addProduct.setFocusPainted(false);
        btn_addProduct.setMaximumSize(new java.awt.Dimension(110, 25));
        btn_addProduct.setMinimumSize(new java.awt.Dimension(110, 25));
        btn_addProduct.setPreferredSize(new java.awt.Dimension(110, 25));
        btn_addProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addProductActionPerformed(evt);
            }
        });
        container_all.add(btn_addProduct);
        btn_addProduct.setBounds(830, 260, 120, 25);

        pnl_action.setBackground(new java.awt.Color(255, 255, 255));
        pnl_action.setLayout(new javax.swing.BoxLayout(pnl_action, javax.swing.BoxLayout.LINE_AXIS));

        btn_edit.setBackground(new java.awt.Color(0, 0, 60));
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("Edit");
        btn_edit.setFocusPainted(false);
        btn_edit.setOpaque(true);
        btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editMouseClicked(evt);
            }
        });
        pnl_action.add(btn_edit);

        btn_saveAdd.setVisible(false);
        btn_saveAdd.setBackground(new java.awt.Color(0, 0, 60));
        btn_saveAdd.setForeground(new java.awt.Color(255, 255, 255));
        btn_saveAdd.setText("Save");
        btn_saveAdd.setFocusPainted(false);
        btn_saveAdd.setOpaque(true);
        btn_saveAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_saveAddMouseClicked(evt);
            }
        });
        pnl_action.add(btn_saveAdd);

        btn_saveEdit.setBackground(new java.awt.Color(0, 0, 60));
        btn_saveEdit.setForeground(new java.awt.Color(255, 255, 255));
        btn_saveEdit.setVisible(false);
        btn_saveEdit.setText("Save");
        btn_saveEdit.setFocusPainted(false);
        btn_saveEdit.setOpaque(true);
        btn_saveEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_saveEditMouseClicked(evt);
            }
        });
        pnl_action.add(btn_saveEdit);

        container_all.add(pnl_action);
        pnl_action.setBounds(870, 20, 80, 30);

        label_total.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_total.setForeground(new java.awt.Color(0, 0, 0));
        container_all.add(label_total);
        label_total.setBounds(820, 560, 130, 40);

        label_total1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_total1.setForeground(new java.awt.Color(0, 0, 0));
        label_total1.setText("Total: ");
        container_all.add(label_total1);
        label_total1.setBounds(760, 560, 60, 40);

        getContentPane().add(container_all);
        container_all.setBounds(10, 10, 970, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CustomCode(){
        CategoryModel categoryInputCBModel = new CategoryModel(
                categoryBLL.convertListComboBox(categoryBLL.loadCategory()));
        cbb_cate_add_vege = new JComboBox(categoryInputCBModel);
        container_searchProduct.add(cbb_cate_add_vege);
        cbb_cate_add_vege.setBounds(470, 10, 140, 30);
        cbb_cate_add_vege.insertItemAt("All Category", 0);
        cbb_cate_add_vege.setSelectedItem("All Category");
        cbb_cate_add_vege.setLightWeightPopupEnabled(true);
        cbb_cate_add_vege.addActionListener((ActionEvent e) -> {
            loadVegetableAddProduct();
        }); 
        
        table_add_vegetable.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());;
        table_add_vegetable.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JTextField()));
        table_product.getColumnModel().getColumn(7).setCellRenderer(new ButtonDeleteRenderer());;
        table_product.getColumnModel().getColumn(7).setCellEditor(new ButtonDeleteEditor(new JTextField()));
        
        CustomerModel customerCBModel = new CustomerModel(
                customerBLL.convertListComboBox(customerBLL.loadCustomers()));
        cbb_customer = new JComboBox(customerCBModel);
        pnl_customer.add(cbb_customer);
        cbb_customer.setBounds(10, 20, 400, 30);
        cbb_customer.setVisible(false);
        cbb_customer.insertItemAt("Customer", 0);
        cbb_customer.setSelectedItem("Customer");
        cbb_customer.setLightWeightPopupEnabled(true);
        cbb_customer.setBackground(java.awt.Color.white);
        cbb_customer.setFont(new java.awt.Font("Segoe UI", 0, 14));
        cbb_customer.setForeground(new java.awt.Color(0, 0, 0));
        cbb_customer.setBorder(null);
        cbb_customer.addActionListener((ActionEvent e) -> {
            try {
                customers c = (customers) cbb_customer.getSelectedItem();
                text_address.setText(c.getAddress());
                text_city.setText(c.getCity());
                text_customer.setText(c.toString());
            } catch (Exception ex) {
                text_address.setText("");
                text_city.setText("");
                text_customer.setText("");
            }
        }); 
        text_id.setEditable(false);
        dialog_searchProduct.setLocationRelativeTo(this);     
        this.setVisible(true);
        this.setLocation(380,120);
        table_product.getModel().addTableModelListener((TableModelEvent e) -> {
            int rowChange = e.getFirstRow();
            int columnChange = e.getColumn();
            if (e.getType()==0 && columnChange==3) {
                int quantity = Integer.parseInt((String) table_product.getValueAt(rowChange,3));
                String price = (String) table_product.getValueAt(rowChange, 5);
                String value = String.valueOf(quantity*Float.parseFloat(price));
                table_product.setValueAt(value, rowChange, 6);
            }else
            if (e.getType()==-1) {
                float total=0;
                for (int i = 0; i < table_product.getRowCount()-1; i++) {
                    total += Float.parseFloat((String)table_product.getValueAt(i,6));                
                }
                label_total.setText(String.valueOf(total));  
            }else{          
                float total=0;
                for (int i = 0; i < table_product.getRowCount(); i++) {
                    total += Float.parseFloat((String)table_product.getValueAt(i,6));                
                }
                label_total.setText(String.valueOf(total));  
            }
        });
        
} 
    
    private void SetInfomation(){
        text_note.setEditable(false);
        this.setTitle("Order "+String.valueOf(order.getOrderID()));
        text_id.setText(String.valueOf(order.getOrderID()));
        text_date.setText(String.valueOf(order.getDate()));
        if(order.getCustomer()!=null){
            text_address.setText(order.getCustomer().getAddress());
            text_city.setText(order.getCustomer().getCity());
            text_customer.setText(order.getCustomer().toString());
            cbb_customer.setSelectedItem(order.getCustomer());
        }
        text_note.setText(order.getNote());
        label_total.setText(order.getTotal());
    }
    
    private void LoadVegtableOrder(){
        DefaultTableModel table_product_model = (DefaultTableModel) table_product.getModel();
        List list = order.getOrderVegetable();
        Object[][] data = orderBLL.convertListVegetableInOrder(list);
        table_product_model.setRowCount(0);
        for (Object[] row : data) {
            table_product_model.addRow(row);
        }
        
    }
    
    private void NewOrderGUI(){
        text_date.setText(String.valueOf(java.time.LocalDate.now()));
        this.setTitle("New Order");
        btn_edit.setVisible(false);
        btn_saveEdit.setVisible(false);
        text_customer.setVisible(false);
        table_product.setEnabled(true);
        btn_addProduct.setVisible(true); 
        btn_saveAdd.setVisible(true);
        cbb_customer.setVisible(true);
    }
    
    public void loadVegetableAddProduct(){
        DefaultTableModel tableModel = (DefaultTableModel) table_add_vegetable.getModel();
        String name = text_search_vegetable.getText();
        Object cate = cbb_cate_add_vege.getModel().getSelectedItem();
        List list = vegetableBLL.searchVegetable(name, cate);
        Object[][] data = orderBLL.convertListSearchVe(list);
        tableModel.setRowCount(0);
        for (Object[] row : data) {
            tableModel.addRow(row);
        }
    }
    
    public void AddVegetableToOrder(int row){
        DefaultTableModel table_product_model = (DefaultTableModel) table_product.getModel();
        int quantityAdd = Integer.parseInt((String) table_add_vegetable.getValueAt(row, 4));
        int rowCount = table_product.getRowCount();
        for (int i = 0; i <= rowCount; i++) {
            if( rowCount!=0 && rowCount!=i && table_product.getValueAt(i, 1)==table_add_vegetable.getValueAt(row, 0)){
                int quantityOld = Integer.parseInt((String) table_product.getValueAt(i, 3));
                String value = String.valueOf(quantityAdd + quantityOld);
                table_product.setValueAt(value, i, 3);
                break;
            }
            if (i==rowCount) {
                String name = (String) table_add_vegetable.getValueAt(row, 1);
                int id = (int) table_add_vegetable.getValueAt(row, 0); 
                String unit = (String) table_add_vegetable.getValueAt(row, 3);
                String price = (String) table_add_vegetable.getValueAt(row, 2);
                Object[] data = new Object[8];
                    data[0] = table_product.getRowCount()+1;
                    data[1] = id;
                    data[2] = name;
                    data[3] = String.valueOf(quantityAdd);
                    data[4] = unit;
                    data[5] = price;
                    data[6] = String.valueOf(Float.parseFloat(price)*quantityAdd);
                    data[7] = "Delete";
                table_product_model.addRow(data); 
                break;
            }
        }
        
    }
     
    public void AddNewOrder(){
        order.setCustomer((customers) cbb_customer.getSelectedItem());
        order.setDate(new Date());
        order.setTotal(label_total.getText());
        order.setNote(text_note.getText()); 
        for (int i = 0; i < table_product.getRowCount(); i++) {
            int id = (int) table_product.getValueAt(i, 1);
            OrderVegetable orderVegetable = new OrderVegetable();
            orderVegetable.setOrder(order);
            orderVegetable.setVegetable(vegetableBLL.getVegetable(id));
            orderVegetable.setPrice((String) table_product.getValueAt(i, 6));
            orderVegetable.setQuantity((String) table_product.getValueAt(i, 3));
            order.addOrderVegetable(orderVegetable);
        }
        boolean status = orderBLL.insertOrder(order);
        if(status){
            text_id.setText(String.valueOf(order.getOrderID()));
            this.setTitle("Order "+String.valueOf(order.getOrderID()));
            JOptionPane.showMessageDialog(null,"Add successfully","Insert",
                    JOptionPane.INFORMATION_MESSAGE); 
        }else{
            JOptionPane.showMessageDialog(null,"Add failure","Insert",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void EditOrder(){
        List list = order.getOrderVegetable();
        order=new order();
        order.setOrderID(Integer.parseInt(text_id.getText()));
        order.setCustomer((customers) cbb_customer.getSelectedItem());
        order.setDate(new Date());
        order.setTotal(label_total.getText());
        order.setNote(text_note.getText()); 
        for (int i = 0; i < table_product.getRowCount(); i++) {
            int id = (int) table_product.getValueAt(i, 1);
            OrderVegetable orderVegetable = new OrderVegetable();
            orderVegetable.setOrder(order);
            orderVegetable.setVegetable(vegetableBLL.getVegetable(id));
            orderVegetable.setPrice((String) table_product.getValueAt(i, 6));
            orderVegetable.setQuantity((String) table_product.getValueAt(i, 3));
            order.addOrderVegetable(orderVegetable);
        }
        boolean status = orderBLL.editOrder(order, list);
        if(status){
            JOptionPane.showMessageDialog(null,"Save successfully","Edit",
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"Save failure","Edit",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void btn_addProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addProductActionPerformed
        dialog_searchProduct.setLocation(this.getX()+335,this.getY()+300);
        dialog_searchProduct.setVisible(true);
    }//GEN-LAST:event_btn_addProductActionPerformed

    private void dialog_searchProductWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dialog_searchProductWindowDeactivated
        dialog_searchProduct.setVisible(false);
    }//GEN-LAST:event_dialog_searchProductWindowDeactivated

    private void text_search_vegetableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_search_vegetableKeyReleased
        loadVegetableAddProduct();
    }//GEN-LAST:event_text_search_vegetableKeyReleased

    private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
        text_note.setEditable(true);
        text_customer.setVisible(false);
        cbb_customer.setVisible(true);
        btn_addProduct.setVisible(true);
        btn_edit.setVisible(false);
        btn_saveEdit.setVisible(true);
        btn_saveAdd.setVisible(false);
        table_product.setEnabled(true);
    }//GEN-LAST:event_btn_editMouseClicked

    private void btn_saveAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveAddMouseClicked
        btn_addProduct.setVisible(false);
        cbb_customer.setVisible(false);
        text_note.setEditable(false);
        text_customer.setVisible(true);
        btn_edit.setVisible(true);
        btn_saveAdd.setVisible(false);
        table_product.setEnabled(false);
        AddNewOrder();
    }//GEN-LAST:event_btn_saveAddMouseClicked

    private void btn_saveEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveEditMouseClicked
        btn_addProduct.setVisible(false);
        text_note.setEditable(false);
        btn_edit.setVisible(true);
        cbb_customer.setVisible(false);
        text_customer.setVisible(true);
        btn_saveEdit.setVisible(false);
        table_product.setEnabled(false);
        System.err.println("/////////////////////");
        EditOrder();
    }//GEN-LAST:event_btn_saveEditMouseClicked

//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ChiTietHoaDonGUI("").setVisible(true);
//            }
//        });
//    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addProduct;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_saveAdd;
    private javax.swing.JButton btn_saveEdit;
    private javax.swing.JPanel container_all;
    private javax.swing.JPanel container_searchProduct;
    private javax.swing.JDialog dialog_searchProduct;
    private javax.swing.JLabel label_product;
    private javax.swing.JLabel label_total;
    private javax.swing.JLabel label_total1;
    private javax.swing.JPanel pnl_action;
    private javax.swing.JPanel pnl_address;
    private javax.swing.JPanel pnl_city;
    private javax.swing.JPanel pnl_customer;
    private javax.swing.JPanel pnl_date;
    private javax.swing.JPanel pnl_id;
    private javax.swing.JPanel pnl_note;
    private javax.swing.JScrollPane scroll_note;
    private javax.swing.JScrollPane scroll_tableProduct;
    private javax.swing.JScrollPane scrollpane_add_vegetable;
    private javax.swing.JTable table_add_vegetable;
    private javax.swing.JTable table_product;
    private javax.swing.JTextField text_address;
    private javax.swing.JTextField text_city;
    private javax.swing.JTextField text_customer;
    private javax.swing.JTextField text_date;
    private javax.swing.JTextField text_id;
    private javax.swing.JTextArea text_note;
    private javax.swing.JTextField text_search_vegetable;
    // End of variables declaration//GEN-END:variables
    

    class ButtonRenderer extends JButton implements TableCellRenderer{
        //CONSTRUCTOR
        public ButtonRenderer() {
            //SET BUTTON PROPERTIES
            setOpaque(true);
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object obj,
                boolean selected, boolean focused, int row, int col) {
            //SET PASSED OBJECT AS BUTTON TEXT
            setText((obj==null) ? "":obj.toString());
            return this;
        }
    }
    
    //BUTTON EDITOR CLASS
    class ButtonEditor extends DefaultCellEditor{
        protected JButton btn;
        private String lbl;
        private Boolean clicked;
        
        public ButtonEditor(JTextField txt) {
            super(txt);
            btn=new JButton();
            btn.setOpaque(true);
            //WHEN BUTTON IS CLICKED
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AddVegetableToOrder(table_add_vegetable.getSelectedRow());
                }
            });
        }
        //OVERRIDE A COUPLE OF METHODS
        @Override
        public Component getTableCellEditorComponent(JTable table, Object obj,
                boolean selected, int row, int col) {
            //SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
            lbl=(obj==null) ? "":obj.toString();
            btn.setText(lbl);
            clicked=true;
            return btn;
        }

        //IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
        @Override
        public Object getCellEditorValue() {
            if(clicked){
            }
            //SET IT TO FALSE NOW THAT ITS CLICKED
            clicked=false;
            return new String(lbl);
        }
        @Override
        public boolean stopCellEditing() {
            //SET CLICKED TO FALSE FIRST
            clicked=false;
            return super.stopCellEditing();
        }
        @Override
        protected void fireEditingStopped() {
            // TODO Auto-generated method stub
            super.fireEditingStopped();
        }
    }
    
    class ButtonDeleteRenderer extends JButton implements TableCellRenderer{
        //CONSTRUCTOR
        public ButtonDeleteRenderer() {
            //SET BUTTON PROPERTIES
            setOpaque(true);
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object obj,
                boolean selected, boolean focused, int row, int col) {
            //SET PASSED OBJECT AS BUTTON TEXT
            setText((obj==null) ? "":obj.toString());
            return this;
        }
    }
    //BUTTON EDITOR CLASS
    class ButtonDeleteEditor extends DefaultCellEditor{
        protected JButton btn;
        private String lbl;
        private Boolean clicked;
        
        public ButtonDeleteEditor(JTextField txt) {
            super(txt);
            btn=new JButton();
            btn.setOpaque(true);
            //WHEN BUTTON IS CLICKED
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DefaultTableModel d = (DefaultTableModel) table_product.getModel();
                    d.removeRow(table_product.getSelectedRow());
                }
            });
        }
        //OVERRIDE A COUPLE OF METHODS
        @Override
        public Component getTableCellEditorComponent(JTable table, Object obj,
                boolean selected, int row, int col) {
            //SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
            lbl=(obj==null) ? "":obj.toString();
            btn.setText(lbl);
            clicked=true;
            return btn;
        }

        //IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
        @Override
        public Object getCellEditorValue() {
            if(clicked){
            }
            //SET IT TO FALSE NOW THAT ITS CLICKED
            clicked=false;
            return new String(lbl);
        }
       @Override
        public boolean stopCellEditing() {
            //SET CLICKED TO FALSE FIRST
            clicked=false;
            return super.stopCellEditing();
        }
        @Override
        protected void fireEditingStopped() {
            // TODO Auto-generated method stub
            super.fireEditingStopped();
        }
    }
}


