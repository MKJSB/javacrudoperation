import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.io.FileWriter;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class productForm extends javax.swing.JFrame {
    public productForm() {
        initComponents();// Initialize the components of the JFrame
        Connect();// Connect to the SQL database
        LoadProductNum();// Load the product numbers
        Fetch();// Fetch data from the SQL database
    }

Connection con;
PreparedStatement pst;    
ResultSet rs;

    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");// Loads the MySQL JDBC driver
            con = DriverManager.getConnection("jdbc:mysql://localhost/javacrud","root","");// Establishes a connection to the SQL database
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);// Logs any errors related to the JDBC driver
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);// Logs any SQL-related errors
        }
    }
    public void LoadProductNum(){
        
        try {
            pst = con.prepareStatement("SELECT id FROM product_tbl");// Prepares a SQL statement to retrieve the product IDs from the "product_tbl" table
            rs = pst.executeQuery();// Executes the SQL query and retrieves the result set
            txtpid.removeAllItems();// Clears any existing items in the txtpid JComboBox
            while(rs.next()){
            txtpid.addItem(rs.getString(1));// Adds each product ID from the result set to the txtpid JComboBox
            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);// Logs any SQL-related errors
        }
    }
    
    private void Fetch(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM product_tbl");// Prepares a SQL statement to retrieve all columns from the "product_tbl" table
            rs = pst.executeQuery();// Executes the SQL query and retrieves the result set
            ResultSetMetaData rss = rs.getMetaData();// Retrieves metadata about the result set
            q = rss.getColumnCount();// Retrieves the number of columns in the result set
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();// Gets the default table model of jTable1
            df.setRowCount(0);// Clears any existing rows in the table
            while(rs.next()){
                Vector v2 = new Vector();
                for(int a=1; a<=q; a++){
                    v2.add(rs.getString("id"));// Adds the "id" column value to the vector
                    v2.add(rs.getString("pname"));// Adds the "pname" column value to the vector
                    v2.add(rs.getString("price"));// Adds the "price" column value to the vector
                    v2.add(rs.getString("qty"));// Adds the "qty" column value to the vector
                    v2.add(rs.getString("console"));// Adds the "console" column value to the vector
                }
                df.addRow(v2);// Adds the vector as a row to the table model
            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);// Logs any SQL-related errors
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtpid = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCSV = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnPDF = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtConsole = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Product Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Product Price");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Product Qty");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Product Id");

        txtpid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCSV.setText("Export to CSV");
        btnCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCSVActionPerformed(evt);
            }
        });

        jPanel2.setPreferredSize(new java.awt.Dimension(457, 284));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Price", "Quanitity", "Console"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnPDF.setText("Export to PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCSV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPDF))
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnCSV)
                    .addComponent(btnPDF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("JAVA CRUD Operation");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Console Ver");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtConsole, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtQty, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtpid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnSearch)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtpid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtConsole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(txtPName.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Product name is required");
        }else if(txtPrice.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Product price is required");
        }else if(txtQty.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Product quantity is required");
        }else if(txtConsole.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Console version is required");
        }else{
        try {
            String pname = txtPName.getText();// Retrieves the product name from the text field
            String price = txtPrice.getText();// Retrieves the product price from the text field
            String qty = txtQty.getText();// Retrieves the product quantity from the text field
            String console = txtConsole.getText();// Retrieves the console version from the text field
            String pid = txtpid.getSelectedItem().toString();// Retrieves the selected product ID from the combo box
            
            pst = con.prepareStatement("UPDATE product_tbl SET pname=?,price=?,qty=?,console=? WHERE id=?");// Prepares a SQL statement to update the "product_tbl" table
            pst.setString(1, pname);// Sets the product name value in the prepared statement
            pst.setString(2, price);// Sets the product price value in the prepared statement
            pst.setString(3, qty);// Sets the product quantity value in the prepared statement
            pst.setString(4, console);// Sets the console version value in the prepared statement
            pst.setString(5, pid);// Sets the product ID value in the prepared statement
            
            int k = pst.executeUpdate();// Executes the update operation and retrieves the number of affected rows
            if(k==1){
                JOptionPane.showMessageDialog(this,"Record successfully updated");
                    txtPName.setText("");// Clears the product name text field
                    txtPrice.setText("");// Clears the product price text field
                    txtQty.setText("");// Clears the product quantity text field
                    txtConsole.setText("");// Clears the console version text field
                    txtPName.requestFocus();// Sets the focus back to the product name text field
                    Fetch();// Refreshes the table with updated data
                    LoadProductNum();// Reloads the product numbers in the combo box
            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);// Logs any SQL-related errors
        }
       }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(txtPName.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Product name is required");
        }else if(txtPrice.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Product price is required");
        }else if(txtQty.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Product quantity is required");
        }else if(txtConsole.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Console version is required");
        }else{
        try {
            String pname = txtPName.getText();// Retrieves the product name from the text field
            String price = txtPrice.getText();// Retrieves the product price from the text field
            String qty = txtQty.getText();// Retrieves the product quantity from the text field
            String console = txtConsole.getText();// Retrieves the console version from the text field
            
            pst = con.prepareStatement("INSERT INTO product_tbl (pname,price,qty,console)VALUES(?,?,?,?)");// Prepares a SQL statement to insert a new row into the "product_tbl" table
            pst.setString(1,pname);// Sets the product name value in the prepared statement
            pst.setString(2,price);// Sets the product price value in the prepared statement
            pst.setString(3,qty);// Sets the product quantity value in the prepared statement
            pst.setString(4,console);// Sets the console version value in the prepared statement
            
            int k = pst.executeUpdate();// Executes the insert operation and retrieves the number of affected rows
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Record added successfully");
                txtPName.setText("");// Clears the product name text field
                txtPrice.setText("");// Clears the product price text field
                txtQty.setText("");// Clears the product quantity text field
                txtConsole.setText("");// Clears the console version text field
                Fetch();// Refreshes the table with updated data
                LoadProductNum();// Reloads the product numbers in the combo box
            }else{
                JOptionPane.showMessageDialog(this,"Record failed to save");
            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);// Logs any SQL-related errors
        }
       }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            String pid = txtpid.getSelectedItem().toString();// Retrieves the selected product ID from the combo box
            pst = con.prepareStatement("SELECT * FROM product_tbl WHERE id=?");// Prepares a SQL statement to retrieve a row from the "product_tbl" table based on the ID
            pst.setString(1, pid);// Sets the product ID value in the prepared statement
            rs=pst.executeQuery();// Executes the query and retrieves the result set
            
            if(rs.next()==true){
                txtPName.setText(rs.getString(2));// Sets the product name text field with the retrieved value from the result set
                txtPrice.setText(rs.getString(3));// Sets the product price text field with the retrieved value from the result set
                txtQty.setText(rs.getString(4));// Sets the product quantity text field with the retrieved value from the result set
                txtConsole.setText(rs.getString(5));// Sets the console version text field with the retrieved value from the result set
            }else{
                JOptionPane.showMessageDialog(this,"No record found");// Displays a message if no matching record is found
            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);// Logs any SQL-related errors
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            String pid = txtpid.getSelectedItem().toString();// Retrieves the selected product ID from the combo box
            pst = con.prepareStatement("DELETE FROM product_tbl WHERE id=?");// Prepares a SQL statement to delete a row from the "product_tbl" table based on the ID
            pst.setString(1, pid);// Sets the product ID value in the prepared statement
            
            int k = pst.executeUpdate();// Executes the update query and retrieves the number of affected rows
            if(k==1){
                JOptionPane.showMessageDialog(this,"Record successfully deleted");// Displays a success message if one row is deleted
                txtPName.setText("");// Clears the product name text field
                txtPrice.setText("");// Clears the product price text field
                txtQty.setText("");// Clears the product quantity text field
                txtConsole.setText("");// Clears the console version text field
                txtPName.requestFocus();// Sets the focus back to the product name text field
                Fetch();// Refreshes the table data by fetching the updated records
                LoadProductNum();// Updates the product IDs in the combo box
            }else{
                JOptionPane.showMessageDialog(this,"Record failed to delete");// Displays an error message if no row is deleted
            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);// Logs any SQL-related errors
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCSVActionPerformed
        String filename = "C:\\Users\\ACER\\Documents\\ExporedFileJava.csv";// Define the file path and name for the CSV file
        
        try {
            FileWriter fw = new FileWriter(filename);// Create a FileWriter object to write to the CSV file
            pst = con.prepareStatement("SELECT * FROM product_tbl"); // Retrieve data from the "product_tbl" table
            rs = pst.executeQuery();// Executes the query and retrieves the result set
            
            while(rs.next()){
                fw.append(rs.getString(1));// Write column 1
                fw.append(',');// Add comma separator
                fw.append(rs.getString(2));// Write column 2
                fw.append(',');// Add comma separator
                fw.append(rs.getString(3));// Write column 3
                fw.append(',');// Add comma separator
                fw.append(rs.getString(4));// Write column 4
                fw.append(',');// Add comma separator
                fw.append(rs.getString(5));// Write column 5
                fw.append('\n');// Add a new line character to separate records
            }
            JOptionPane.showMessageDialog(this,"CSV file exported successfully");// Executes the query and retrieves the result set
            // Flush and close the FileWriter object to release system resources
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);//Logs any I/O-related errors
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);// Logs any SQL-related errors
        }
    }//GEN-LAST:event_btnCSVActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        try {
            // Prepare the database query to retrieve data from the "product_tbl" table
            pst = con.prepareStatement("SELECT * FROM product_tbl");
            rs = pst.executeQuery();
            
            Document PDFreport = new Document();// Create a new PDF document
            PdfWriter.getInstance(PDFreport, new FileOutputStream("C:\\Users\\ACER\\Documents\\OutputReportJava"));// Specify the output file for the PDF
            
            PDFreport.open();// Open the PDF document
            
            PdfPTable PDFTable = new PdfPTable(5);// Create a table with 5 columns for the PDF content
            PdfPCell table_cell;// Cell object for table cells
            
            while(rs.next()){
            // Retrieve product ID and add it to the PDF table
            String pid = rs.getString("id");
            table_cell = new PdfPCell(new Phrase(pid));
            PDFTable.addCell(table_cell);
            
            // Retrieve product name and add it to the PDF table
            String ppname = rs.getString("pname");
            table_cell = new PdfPCell(new Phrase(ppname));
            PDFTable.addCell(table_cell);
            
            // Retrieve product price and add it to the PDF table
            String pprice = rs.getString("price");
            table_cell = new PdfPCell(new Phrase(pprice));
            PDFTable.addCell(table_cell);
            
            // Retrieve product quantity and add it to the PDF table
            String pqty = rs.getString("qty");
            table_cell = new PdfPCell(new Phrase(pqty));
            PDFTable.addCell(table_cell);
            
            // Retrieve product console and add it to the PDF table
            String pconsole = rs.getString("console");
            table_cell = new PdfPCell(new Phrase(pconsole));
            PDFTable.addCell(table_cell);
            }
            JOptionPane.showMessageDialog(this,"PDF file exported successfully");// Displays a success message if one row is deleted
            PDFreport.add(PDFTable);// Add the PDF table to the PDF document
            PDFreport.close();//Close PDF document
        // Handle any exceptions 
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPDFActionPerformed

    public static void main(String args[]) {
        // Entry point of the program
        // Starts the application on the event dispatch thread
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Creates and displays the login form
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCSV;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtConsole;
    private javax.swing.JTextField txtPName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQty;
    private javax.swing.JComboBox<String> txtpid;
    // End of variables declaration//GEN-END:variables

    private void LoadProductNo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
