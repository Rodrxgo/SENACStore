package View;

import Controller.ClienteController;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditaClienteView extends javax.swing.JFrame {
    
    public int codigoCliente;
    
    public EditaClienteView() {
        initComponents();
        setResizable(false); //<-- Janela nao redimensionável
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../icons/icon.png"))); //Seta imagem padrão <--
        
    }
    
    public void setVars(String codigo, String nome, String telefone, String email, String sexo, String estadoCiv, Date nascimento, String cpf, String cpfNaoFormatado, String cnpj){
        //Função responsável por pegar os dados da tabela, e preencher no GUI
        
        //Verifica se é cpf ou cnpj
        try {
            if (!cpfNaoFormatado.isEmpty()){
                //Se for CPF, preencher cpf, sexo, estado civil e nascimento
                cpfCli.setText(cpf);
                sexoCli.setSelectedItem(sexo);
                estadoCCli.setSelectedItem(estadoCiv);
                nascimentoCli.setDate(nascimento);
            }
        } catch (Exception e){
            //Se for CNPJ, clicar no checkbox
            pessoaJ.doClick();
            
            //Preencher valor cnpj
            cnpjCli.setText(cnpj);
        }
        
        //Preenchendo dados
        nomeCli.setText(nome);
        telCli.setText(telefone);
        emailCli.setText(email);
        
        //Pega o código do cliente
        codigoCliente = Integer.parseInt(codigo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        nomeCli = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        sexoCli = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        estadoCCli = new javax.swing.JComboBox();
        emailCli = new javax.swing.JTextField();
        pessoaJ = new javax.swing.JCheckBox();
        cpfCli = new javax.swing.JFormattedTextField();
        cnpjCli = new javax.swing.JFormattedTextField();
        telCli = new javax.swing.JFormattedTextField();
        jButton2 = new javax.swing.JButton();
        nascimentoCli = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Clientes");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Nome do Cliente *");

        jLabel4.setText("CPF *");

        jLabel5.setText("CNPJ *");

        jLabel12.setText("Telefone *");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_refresh_small.png"))); // NOI18N
        jButton1.setText("Alterar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        jButton5.setText("Cancelar");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel14.setText("E-mail *");

        jLabel15.setText("Sexo *");

        sexoCli.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Feminino", "Masculino", "Outro" }));
        sexoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexoCliActionPerformed(evt);
            }
        });

        jLabel16.setText("Estado  civil *");

        jLabel17.setText("Data de Nascimento *");

        estadoCCli.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Casado(a)", "Divorciado(a)", "Separado(a) Judicialmente", "Solteiro(a)", "Viúvo(a)" }));
        estadoCCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoCCliActionPerformed(evt);
            }
        });

        pessoaJ.setText("Pessoa Jurídica");
        pessoaJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pessoaJActionPerformed(evt);
            }
        });

        cpfCli.setBorder(cnpjCli.getBorder());
        try {
            cpfCli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpfCli.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        cnpjCli.setEditable(false);
        try {
            cnpjCli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cnpjCli.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cnpjCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnpjCliActionPerformed(evt);
            }
        });

        try {
            telCli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        telCli.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        telCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telCliActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cross.png"))); // NOI18N
        jButton2.setText("Excluir");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        nascimentoCli.setDateFormatString("dd/MM/yyyy");
        nascimentoCli.setMaxSelectableDate(new java.util.Date(1609387314000L));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pessoaJ)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(cpfCli, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cnpjCli)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(71, 71, 71)
                                        .addComponent(jLabel14)
                                        .addGap(202, 202, 202))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(telCli)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(emailCli, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sexoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(estadoCCli, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(12, 12, 12))
                                    .addComponent(nascimentoCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(nomeCli))
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton5});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nascimentoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sexoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(estadoCCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pessoaJ)
                    .addComponent(cpfCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cnpjCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton1)
                    .addComponent(jButton2)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton5});

        jPanel4.setBackground(new java.awt.Color(102, 153, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel19.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Edição de Clientes");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(296, 296, 296))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sexoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexoCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexoCliActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        //Dados inputados pelo usuário:
        String nome = nomeCli.getText().trim();
        String telefone = telCli.getText().trim();
        String email = emailCli.getText().trim();
        Date nascimento = nascimentoCli.getDate();
        String cnpj = cnpjCli.getText().trim();
        String cpf = cpfCli.getText().trim();
        String sexo = (String) sexoCli.getSelectedItem();
        String estadoCivil = (String) estadoCCli.getSelectedItem();
        String telefoneUnformatted = telefone.replaceAll("[\\s()-.]", "");
        String cpfUnformatted = cpf.replaceAll("[\\s()-.\\/]", "");
        String cnpjUnformatted = cnpj.replaceAll("[\\s()-.\\/]", "");
        String dataNascimento = "";
        
        //Converte data de nascimento para o formato
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");  
            dataNascimento = dateFormat.format(nascimento);  
        } catch (Exception e){
            
        }
        
        //Validação dos dados inputados pelo usuário:
        if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty() || dataNascimento.isEmpty()
         || (pessoaJ.isSelected() && cnpjUnformatted.isEmpty()) || (!pessoaJ.isSelected() && cpfUnformatted.isEmpty())){
            //Caso não tenha preenchido algum campo necessário
            JOptionPane.showMessageDialog(null, "Favor preencher todos os campos marcados com *");
            return;
        } else if (!pessoaJ.isSelected() && cpfUnformatted.isEmpty()){
            //Caso CPF nao tenha quantidade correta de caracteres
            JOptionPane.showMessageDialog(null, "O campo \"CPF\" está incorreto");
            return;
        } else if (pessoaJ.isSelected() && cnpjUnformatted.isEmpty()){
            //Caso CNPJ nao tenha quantidade correta de caracteres
            JOptionPane.showMessageDialog(null, "O campo \"CNPJ\" está incorreto");
            return;
        } else if (telefoneUnformatted.isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo \"Telefone\" está incorreto");
            return;
        }
        
        //Pergunta para o usuário se ele realmente quer realizar a operação
        Object[] options = { "Confirmar", "Cancelar" };
        int resposta = JOptionPane.showOptionDialog(null, "Certeza que deseja editar os dados do cliente: " + nome  + "?", "Confirmar operação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            
        //Varíavel de resultado da atualização
        boolean resultado;
        
        if (resposta == 0){
            //Caso usuário tenha confirmado a operação
            resultado = ClienteController.editarDBCliente(codigoCliente, nome, telefone, email, dataNascimento, cpf, cnpj, cnpjUnformatted, cpfUnformatted, sexo, estadoCivil);
        } else {
            //Caso usuário não tenha confirmado a operação
            return;
        }
        
        if (resultado == true){
            JOptionPane.showMessageDialog(null, "Atualização do cliente: \"" + nome + "\" realizada com sucesso!");
            setVisible(false);
            return;
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a atualização, tente novamente mais tarde");
            return;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pessoaJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pessoaJActionPerformed
         if (cpfCli.isEditable()){
             
            //Desativar campos CPF, sexo, estado civíl e data de nascimento
            cpfCli.setEditable(false);
            sexoCli.setEnabled(false);
            estadoCCli.setEnabled(false);
            nascimentoCli.setEnabled(false);
            
            //Ativar campo CNPJ
            cnpjCli.setEditable(true);
            
            //Limpar campos CPF e data nascimento
            cpfCli.setText("");
            nascimentoCli.setDate(null);
        } else {
            //Desativar CNPJ
            cnpjCli.setEditable(false);
            
            //Ativar campos CPF, sexo, estado civíl e data de nascimento
            cpfCli.setEditable(true);
            sexoCli.setEnabled(true);
            estadoCCli.setEnabled(true);
            nascimentoCli.setEnabled(true);
            
            //Limpar campo de CNPJ
            cnpjCli.setText("");
        }
    }//GEN-LAST:event_pessoaJActionPerformed

    private void telCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telCliActionPerformed

    private void cnpjCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnpjCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnpjCliActionPerformed

    private void estadoCCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoCCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadoCCliActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Pergunta para o usuário se ele realmente quer realizar a operação
        Object[] options = { "Confirmar", "Cancelar" };
        int resposta = JOptionPane.showOptionDialog(null, "Certeza que deseja excluir o cliente: \"" + nomeCli.getText().trim()  + "\"?", "Confirmar operação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        
        //Varíavel de resultado da atualização
        boolean resultado;
        
        if (resposta == 0){
            //Caso usuário tenha confirmado a operação
            System.out.println("excluir");
            resultado = ClienteController.excluirDB(codigoCliente);
        } else {
            //Caso usuário não tenha confirmado a operação
            return;
        }
        
        if (resultado == true){
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");
            setVisible(false);
            return;
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a exclusão, tente novamente mais tarde");
            return;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditaClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditaClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditaClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditaClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditaClienteView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField cnpjCli;
    private javax.swing.JFormattedTextField cpfCli;
    private javax.swing.JTextField emailCli;
    private javax.swing.JComboBox estadoCCli;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private com.toedter.calendar.JDateChooser nascimentoCli;
    private javax.swing.JTextField nomeCli;
    private javax.swing.JCheckBox pessoaJ;
    private javax.swing.JComboBox sexoCli;
    private javax.swing.JFormattedTextField telCli;
    // End of variables declaration//GEN-END:variables

}
