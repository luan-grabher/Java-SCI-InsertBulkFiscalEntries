/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sci.insertbulkfiscalentries.View;

import java.util.Map;
import java.util.TreeMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sci.insertbulkfiscalentries.Model.Cities_Model;
import sci.insertbulkfiscalentries.Model.Entities.City;
import sci.insertbulkfiscalentries.Model.Entities.Service;
import sci.insertbulkfiscalentries.Model.Entities.State;
import sci.insertbulkfiscalentries.Model.Services_Model;
import sci.insertbulkfiscalentries.Model.States_Model;

/**
 *
 * @author TI01
 */
public class Home extends javax.swing.JFrame {

    private Integer enterpriseCode;
    private Map<String, Service> services;
    private Map<String, State> states;
    private Map<String, City> cities;

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        setTheme();

        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    public void setServicesList() {
        servicesList.removeAllItems();

        Services_Model model = new Services_Model();
        services = model.getDatabaseServices(enterpriseCode);
        
        for (Map.Entry<String, Service> entry : services.entrySet()) {
            String name = entry.getKey();
            Service service = entry.getValue();

            servicesList.addItem(name);
        }
    }

    public void setStatesList() {
        statesList.removeAllItems();

        States_Model model = new States_Model();
        states = model.getStatesFromDb();
        for (Map.Entry<String, State> entry : states.entrySet()) {
            String name = entry.getKey();
            State state = entry.getValue();

            statesList.addItem(name);
        }

        statesList.setSelectedItem("Rio Grande do Sul");
    }

    public void setCitiesList() {
        citiesList.removeAllItems();

        Cities_Model model = new Cities_Model();
        cities = model.getStateCitiesFromDb(states.get(statesList.getSelectedItem().toString()).getCode());
        for (Map.Entry<String, City> entry : cities.entrySet()) {
            String name = entry.getKey();
            City city = entry.getValue();

            citiesList.addItem(name);
        }

        if (statesList.getSelectedItem().equals("Rio Grande do Sul")) {
            citiesList.setSelectedItem("Porto Alegre");
        }
    }

    private void setTheme() {
        try {
            javax.swing.UIManager.setLookAndFeel("Windows");
        } catch (Exception e) {
        }
    }

    public Integer getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(Integer enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cnpj = new javax.swing.JTextField();
        titulo1 = new javax.swing.JLabel();
        cnpjSearch = new javax.swing.JButton();
        titulo2 = new javax.swing.JLabel();
        nf = new javax.swing.JTextField();
        titulo4 = new javax.swing.JLabel();
        servicesList = new javax.swing.JComboBox<>();
        titulo5 = new javax.swing.JLabel();
        value = new javax.swing.JFormattedTextField();
        statesList = new javax.swing.JComboBox<>();
        titulo6 = new javax.swing.JLabel();
        citiesList = new javax.swing.JComboBox<>();
        titulo7 = new javax.swing.JLabel();
        addToList = new javax.swing.JButton();
        generateFile = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        deleteRow = new javax.swing.JButton();
        titulo3 = new javax.swing.JLabel();
        description = new javax.swing.JTextField();
        titulo8 = new javax.swing.JLabel();
        date = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCI - Gerar arquivo de Importação de NFs de Serviço");
        setBackground(new java.awt.Color(60, 62, 65));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("homeFrame"); // NOI18N

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setLabelFor(cnpj);
        titulo.setText("CNPJ");

        cnpj.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cnpj.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        cnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnpjActionPerformed(evt);
            }
        });

        titulo1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo1.setText("SCI - Gerar arquivo de Importação de NFs de Serviço");

        cnpjSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sci/insertbulkfiscalentries/View/Images/search.png"))); // NOI18N
        cnpjSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnpjSearchActionPerformed(evt);
            }
        });

        titulo2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        titulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo2.setLabelFor(nf);
        titulo2.setText("Número NF");

        nf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nfActionPerformed(evt);
            }
        });

        titulo4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        titulo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo4.setLabelFor(value);
        titulo4.setText("Valor");

        servicesList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicesListActionPerformed(evt);
            }
        });

        titulo5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        titulo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo5.setLabelFor(servicesList);
        titulo5.setText("Serviço");

        value.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        value.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        statesList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statesListActionPerformed(evt);
            }
        });

        titulo6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        titulo6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo6.setLabelFor(cnpj);
        titulo6.setText("Estado");

        citiesList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                citiesListActionPerformed(evt);
            }
        });

        titulo7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        titulo7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo7.setLabelFor(cnpj);
        titulo7.setText("Cidade");

        addToList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sci/insertbulkfiscalentries/View/Images/add.png"))); // NOI18N
        addToList.setText("Adicionar à Lista");
        addToList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToListActionPerformed(evt);
            }
        });

        generateFile.setBackground(new java.awt.Color(153, 153, 153));
        generateFile.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        generateFile.setForeground(new java.awt.Color(0, 0, 0));
        generateFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sci/insertbulkfiscalentries/View/Images/createFile.png"))); // NOI18N
        generateFile.setText("Gerar Arquivo");
        generateFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateFileActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CNPJ", "NF", "Data", "Descrição", "Valor", "Serviço", "Estado", "Cidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        deleteRow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sci/insertbulkfiscalentries/View/Images/delete.png"))); // NOI18N
        deleteRow.setText("Deletar Linha Selecionada");
        deleteRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRowActionPerformed(evt);
            }
        });

        titulo3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        titulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo3.setLabelFor(description);
        titulo3.setText("Descrição");

        description.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionActionPerformed(evt);
            }
        });

        titulo8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        titulo8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo8.setLabelFor(servicesList);
        titulo8.setText("Data (dd/mm/aaaa)");

        date.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        date.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addToList)
                                .addGap(18, 18, 18)
                                .addComponent(deleteRow))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cnpjSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cnpj)
                                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nf)
                                    .addComponent(titulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(description, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(titulo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(22, 22, 22)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(value, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                    .addComponent(titulo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(date)
                                    .addComponent(titulo8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(servicesList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(titulo5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(statesList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(titulo6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(citiesList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(titulo7, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 198, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(725, 725, 725)
                                .addComponent(generateFile, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(titulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 1406, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(titulo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cnpjSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(titulo2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(titulo3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(titulo8)
                                    .addComponent(titulo4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(titulo5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(servicesList, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(value, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(titulo7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(citiesList, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(titulo6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(statesList, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(generateFile, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addToList)
                        .addComponent(deleteRow)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(647, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cnpjSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnpjSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnpjSearchActionPerformed

    private void nfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nfActionPerformed

    private void descriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionActionPerformed

    private void servicesListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicesListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_servicesListActionPerformed

    private void statesListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statesListActionPerformed
        if (statesList.getItemCount() > 0) {
            setCitiesList();
        }
    }//GEN-LAST:event_statesListActionPerformed

    private void citiesListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_citiesListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_citiesListActionPerformed

    private void addToListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToListActionPerformed
        try {
            //Verifica se tem algum item vazio
            if (!cnpj.getText().equals("")
                    & !nf.getText().equals("")
                    & !description.getText().equals("")
                    & !value.getValue().toString().equals("")
                    & !date.getValue().toString().equals("")
                    & !servicesList.getSelectedItem().toString().equals("")
                    & !statesList.getSelectedItem().toString().equals("")
                    & !citiesList.getSelectedItem().toString().equals("")) {
                //Verifica se NF já existe para aquele CNPJ
                if(!ifCnpjNfOnTable(cnpj.getText(), nf.getText())){
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(new Object[]{
                        cnpj.getText(),
                        nf.getText(),
                        date.getText(),
                        description.getText(),
                        value.getValue(),
                        servicesList.getSelectedItem().toString(),
                        statesList.getSelectedItem().toString(),
                        citiesList.getSelectedItem().toString()
                    });
                }else{
                    JOptionPane.showMessageDialog(this, "Já existe esta NF para este CNPJ!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum campo pode ficar em branco!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nenhum campo pode ficar em branco!");
        }
    }//GEN-LAST:event_addToListActionPerformed

    private boolean ifCnpjNfOnTable(String cnpjSearched, String nfSearched) {
        // Get row and column count
        int rowCount = table.getRowCount();
        int cnpjCollumn = 0;
        int nfCollumn = 1;
        
        //Unify
        String cnpjnf = cnpjSearched + nfSearched;

        // Check all entries
        for (int i = 0; i < rowCount; i++) {
            String rowValue = table.getValueAt(i, cnpjCollumn).toString() + table.getValueAt(i, nfCollumn).toString();
            if(rowValue.equalsIgnoreCase(cnpjnf)){
                return true;
            }
        }
        return false;

    }

    private void generateFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_generateFileActionPerformed

    private void deleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRowActionPerformed
        //Delete selected row in table
        Integer rowNumber = table.getSelectedRow();

        if (rowNumber > -1) {
            ((DefaultTableModel) table.getModel()).removeRow(rowNumber);
            table.setRowSelectionInterval(0, 0);
        }
    }//GEN-LAST:event_deleteRowActionPerformed

    private void cnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnpjActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToList;
    private javax.swing.JComboBox<String> citiesList;
    private javax.swing.JTextField cnpj;
    private javax.swing.JButton cnpjSearch;
    private javax.swing.JFormattedTextField date;
    private javax.swing.JButton deleteRow;
    private javax.swing.JTextField description;
    private javax.swing.JButton generateFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField nf;
    private javax.swing.JComboBox<String> servicesList;
    private javax.swing.JComboBox<String> statesList;
    private javax.swing.JTable table;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo1;
    private javax.swing.JLabel titulo2;
    private javax.swing.JLabel titulo3;
    private javax.swing.JLabel titulo4;
    private javax.swing.JLabel titulo5;
    private javax.swing.JLabel titulo6;
    private javax.swing.JLabel titulo7;
    private javax.swing.JLabel titulo8;
    private javax.swing.JFormattedTextField value;
    // End of variables declaration//GEN-END:variables
}
