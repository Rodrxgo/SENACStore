package View;

import Controller.ClienteController;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static Utils.Utils.*;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsultaClienteView extends javax.swing.JFrame {
    
    public ConsultaClienteView() {
        initComponents();
        setResizable(false);  //<-- Janela nao redimensionável
        jTable1.setDefaultEditor(Object.class, null); //<-- Desativa edição da tabela p/ usuário
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../icons/icon.png"))); //Seta imagem padrão <--
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nomeCli = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        codCli = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        pessoaJ = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        cpfCli = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        cnpjCli = new javax.swing.JFormattedTextField();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Localiza Cliente");
        setBackground(new java.awt.Color(102, 102, 102));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Localizar Cliente"));
        jPanel1.setFocusable(false);

        jLabel2.setText("Nome");

        jLabel3.setText("Código");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Cliente", "Nome", "Telefone", "Email", "Sexo", "Estado Civ.", "Nascimento", "CPF", "CNPJ"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/magnifier.png"))); // NOI18N
        jButton1.setText("Localizar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pencil_go.png"))); // NOI18N
        jButton3.setText("Editar");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        pessoaJ.setText("Pessoa Jurídica");
        pessoaJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pessoaJActionPerformed(evt);
            }
        });

        jLabel4.setText("CPF *");

        try {
            cpfCli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpfCli.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel5.setText("CNPJ *");

        cnpjCli.setEditable(false);
        try {
            cnpjCli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cnpjCli.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pencil_go.png"))); // NOI18N
        jButton4.setText("Editar Endereço");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(codCli, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pessoaJ)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(cpfCli, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(cnpjCli, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(nomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 197, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cnpjCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pessoaJ)
                    .addComponent(cpfCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(144, 144, 144))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        jPanel5.setBackground(new java.awt.Color(102, 153, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Consulta de Clientes");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(454, 454, 454))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Instancia a tabela de clientes
        DefaultTableModel tabela = (DefaultTableModel) jTable1.getModel();
        tabela = (DefaultTableModel) jTable1.getModel();
        tabela.setNumRows(0); // <-- Limpa a tabela de execuções anteriores
        
        //Pega campos
        String codigo = codCli.getText().trim();
        String nome = nomeCli.getText().trim();
        String cpf = cpfCli.getText().trim();
        String cnpj = cnpjCli.getText().trim();
        String cpfNaoFormatado = cpf.replaceAll("[\\s()-.]", "");
        String cnpjNaoFormatado = cnpj.replaceAll("[\\s()-.\\/]", "");
        int codigoCliente = 0;
        
        //Validação dos dados inputados pelo usuário:
        
        //Caso código nao seja um número
        if (!codigo.isEmpty()){
            if (!validaNumero(codigo)){
                JOptionPane.showMessageDialog(null, "Código inserido deve ser um número");
                return;
            }
            codigoCliente = Integer.parseInt(codigo);
        }
        
        //Chama o método do controller para consultar infos no DB de cliente
        ResultSet resultadoCliente = ClienteController.consultarDBCliente(codigoCliente, cpf, cnpj, cpfNaoFormatado, cnpjNaoFormatado, nome);
        
        int resultados = 0;
        //Exibir na tabela os resultados
        try {
            //Os resultados da consulta dos dados do cliente
            while (resultadoCliente.next()){
                tabela.addRow(new Object[]{
                    resultadoCliente.getString("codCliente"),
                    resultadoCliente.getString("nome"),
                    resultadoCliente.getString("telefone"),
                    resultadoCliente.getString("email"),
                    resultadoCliente.getString("sexo"),
                    resultadoCliente.getString("estadoCivil"),
                    resultadoCliente.getString("nascimento"),
                    resultadoCliente.getString("cpf"),
                    resultadoCliente.getString("cnpj")
                });
                resultados++;
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a consulta, tente novamente mais tarde");
            return;
        }
        
        //Caso nao tenha encontrado nenhum resultado
        if (resultados == 0){
            JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado para as informações fornecidas");
            return;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Tenta pegar os valores, se nao conseguir, nao prosseguir
        try {
            int linhaSelecionada = jTable1.getSelectedRow();
            String codigo = (String) jTable1.getValueAt(linhaSelecionada, 0);
            String nome = (String) jTable1.getValueAt(linhaSelecionada, 1);
            String telefone = (String) jTable1.getValueAt(linhaSelecionada, 2);
            String email = (String) jTable1.getValueAt(linhaSelecionada, 3);
            String sexo = (String) jTable1.getValueAt(linhaSelecionada, 4);
            String estadoCiv = (String) jTable1.getValueAt(linhaSelecionada, 5);
            String nascimento = (String) jTable1.getValueAt(linhaSelecionada, 6);
            String cpf = (String) jTable1.getValueAt(linhaSelecionada, 7);
            String cnpj = (String) jTable1.getValueAt(linhaSelecionada, 8);
            String cpfNaoFormatado = cpf.replaceAll("[\\s()-.]", "");
            Date dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(nascimento);  
            
            //Instancia a classe com o GUI de edição de cliente
            EditaClienteView editaCliente = new EditaClienteView();
            editaCliente.setVisible(true);
            
            //Passa para ela os dados iniciais do cliente
            editaCliente.setVars(codigo, nome, telefone, email, sexo, estadoCiv, dataNascimento, cpf, cpfNaoFormatado, cnpj);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente para editar");
            return;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void pessoaJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pessoaJActionPerformed
        if (cpfCli.isEditable()){
             
            //Desativar campos CPF, sexo, estado civíl e data de nascimento
            cpfCli.setEditable(false);
            
            //Ativar campo CNPJ
            cnpjCli.setEditable(true);
            
            //Limpar campos CPF e data nascimento
            cpfCli.setText("");
        } else {
            //Desativar CNPJ
            cnpjCli.setEditable(false);
            
            //Ativar campos CPF, sexo, estado civíl e data de nascimento
            cpfCli.setEditable(true);
            
            //Limpar campo de CNPJ
            cnpjCli.setText("");
        }
    }//GEN-LAST:event_pessoaJActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Instancia a tabela de clientes
        DefaultTableModel tabelaCliente = (DefaultTableModel) jTable1.getModel();
        tabelaCliente = (DefaultTableModel) jTable1.getModel();
        //tabelaCliente.setNumRows(0); // <-- Limpa a tabela de execuções anteriores
        
        try {
            int linhaSelecionada = jTable1.getSelectedRow();
            int codigoCliente = Integer.parseInt((String) jTable1.getValueAt(linhaSelecionada, 0));
            String nomeCliente = (String) jTable1.getValueAt(linhaSelecionada, 1);
            
            //Instancia a classe com o GUI de edição
            EditaEnderecoView editaEndereco = new EditaEnderecoView();
            editaEndereco.setVisible(true);
            
            //Passa para ela os dados iniciais do cliente
            editaEndereco.setVars(codigoCliente, nomeCliente);
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Selecione um cliente para editar");
            return;
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaClienteView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField cnpjCli;
    private javax.swing.JTextField codCli;
    private javax.swing.JFormattedTextField cpfCli;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nomeCli;
    private javax.swing.JCheckBox pessoaJ;
    // End of variables declaration//GEN-END:variables
}
