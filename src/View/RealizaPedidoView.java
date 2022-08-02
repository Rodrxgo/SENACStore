package View;

import Controller.ClienteController;
import Controller.ProdutoController;
import Controller.VendaController;
import static Utils.Utils.formatPtBr;
import static Utils.Utils.validaNumero;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.util.Locale;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RealizaPedidoView extends javax.swing.JFrame {
    
    //Define atributos necessários
    public int codigoP = 0;
    public int codigoC = 0;
    public int quantidadeP = 0;
    
    public RealizaPedidoView() {
        initComponents();
        setResizable(false);
        jTable1.setDefaultEditor(Object.class, null); //<-- Desativa edição da tabela p/ usuário
        jTable2.setDefaultEditor(Object.class, null); //<-- Desativa edição da tabela p/ usuário
        jTable3.setDefaultEditor(Object.class, null); //<-- Desativa edição da tabela p/ usuário
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../icons/icon.png"))); //Seta imagem padrão <--
    }
    
    public void atualizaPrecoCarrinho(String valorItemAdicionado, int quantidadeProduto, Boolean adicionarItem){
        //Pega o preco atual que está no carrinho
        String precoAtualCarrinho = precoCarrinho.getText().trim();

        //Conserta string para poder converter para double
        precoAtualCarrinho = precoAtualCarrinho.replace(".", ""); //<-- Preco atual do carrinho
        precoAtualCarrinho = precoAtualCarrinho.replace(",", ".");

        valorItemAdicionado = valorItemAdicionado.replace(".", ""); //<-- Preco do item à adicionar no carrinho
        valorItemAdicionado = valorItemAdicionado.replace(",", ".");

        //Converte as strings
        Double precoCorretoCarrinho = Double.parseDouble(precoAtualCarrinho);
        Double precoCorretoitemAdicionado = Double.parseDouble(valorItemAdicionado);
        //Calcula o valor final
        Double valorFinal = 0D;
        if (adicionarItem == true){
            valorFinal = precoCorretoCarrinho + precoCorretoitemAdicionado*quantidadeProduto;
        } else {
            valorFinal = precoCorretoCarrinho - precoCorretoitemAdicionado*quantidadeProduto;
        }
        
        Locale localBrasil = new Locale("pt", "BR");
        String valorFormatado = NumberFormat.getCurrencyInstance(localBrasil).format(valorFinal).replace("R$", "").trim();
        
        //Atualiza valor
        precoCarrinho.setText(valorFormatado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        precoCarrinho = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        codigoProduto = new javax.swing.JTextField();
        nomeProduto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        marcaProduto = new javax.swing.JComboBox();
        corProduto = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        codCli = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        pessoaJ = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        cpfCli = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        cnpjCli = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        nomeCli = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        clienteCarrinho = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 204));
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Valor Total:     R$: ");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cart_add.png"))); // NOI18N
        jButton2.setText("Finalizar Pedido");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cart_remove.png"))); // NOI18N
        jButton5.setText("Limpar Carrinho");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        precoCarrinho.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        precoCarrinho.setText("0");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos"));
        jPanel3.setToolTipText("");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Marca", "Cor", "Valor", "Quantidade"
            }
        ));
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(jTable2);

        codigoProduto.setForeground(new java.awt.Color(102, 102, 102));

        nomeProduto.setForeground(new java.awt.Color(102, 102, 102));
        nomeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeProdutoActionPerformed(evt);
            }
        });

        jLabel5.setText("Código");

        jLabel6.setText("Nome produto");

        jLabel7.setText("Marca");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/magnifier.png"))); // NOI18N
        jButton6.setText("Localizar");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel10.setText("Cor");

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cart_go.png"))); // NOI18N
        jButton9.setText("Adicionar ao carrinho");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        marcaProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas", "Nike", "Adidas", "Luis Vitton", "Supreme" }));

        corProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                corProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(codigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(nomeProduto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(corProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(marcaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton9)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marcaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton6, jButton9});

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        jButton7.setText("Sair");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Carrinho"));
        jPanel4.setToolTipText("");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Marca", "Cor", "Valor", "Quantidade"
            }
        ));
        jTable3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));
        jPanel5.setToolTipText("");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Telefone", "Email", "Sexo", "CPF", "CNPJ"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane3.setViewportView(jTable1);

        codCli.setForeground(new java.awt.Color(102, 102, 102));

        jLabel8.setText("Código");

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/magnifier.png"))); // NOI18N
        jButton8.setText("Localizar");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user_add.png"))); // NOI18N
        jButton10.setText("Escolher cliente");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
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

        jLabel11.setText("CNPJ *");

        cnpjCli.setEditable(false);
        try {
            cnpjCli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cnpjCli.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel13.setText("Nome");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(codCli, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pessoaJ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(cpfCli, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(cnpjCli, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(nomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cnpjCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpfCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pessoaJ)
                            .addComponent(jButton8)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton10, jButton8});

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Realiza Pedidos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(517, 517, 517))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cart_remove.png"))); // NOI18N
        jButton11.setText("Remover Item");
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Cliente:");

        clienteCarrinho.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        clienteCarrinho.setText("--");

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cart_edit.png"))); // NOI18N
        jButton12.setText("Alterar Quantidade");
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11)
                .addGap(12, 12, 12)
                .addComponent(jButton12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoCarrinho))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clienteCarrinho)))
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton11, jButton2, jButton5, jButton7});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(clienteCarrinho))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(precoCarrinho)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton7)
                        .addComponent(jButton11)
                        .addComponent(jButton5)
                        .addComponent(jButton12)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton11, jButton2, jButton5, jButton7});

        jPanel3.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Instancia a tabela dos clientes
        DefaultTableModel tabelaClientes = (DefaultTableModel) jTable1.getModel();
        tabelaClientes = (DefaultTableModel) jTable1.getModel();
        
        //Instancia a tabela dos produtos
        DefaultTableModel tabelaProdutos = (DefaultTableModel) jTable2.getModel();
        tabelaProdutos = (DefaultTableModel) jTable2.getModel();
        
        //Instancia a tabela do carrino
        DefaultTableModel tabelaCarrinho = (DefaultTableModel) jTable3.getModel();
        tabelaCarrinho = (DefaultTableModel) jTable3.getModel();
        
        //Verifica se usuário selecionou um cliente
        if (codigoC == 0){
            JOptionPane.showMessageDialog(null, "Selecione algum cliente");
            return;
        }
        
        //pega o numero de linhas do carrinho
        int numeroLinhas = tabelaCarrinho.getRowCount();
        //Pega o numero de colunas do carrinho
        int numeroColunas = tabelaCarrinho.getColumnCount();
        //Cria var de disponibilidade no estoque
        ResultSet disponibilidadeEstoque;
        
        //Pega o valor da venda
        String valorCarrinho = precoCarrinho.getText().trim();
        valorCarrinho = valorCarrinho.replace(".", "");
        valorCarrinho = valorCarrinho.replace(",", ".");
        
        //Converte valor da venda para formato #.###,##
        Double valorVenda = Double.parseDouble(valorCarrinho);
                
        //Validação itens do carrinho
        if (numeroLinhas == 0){
            JOptionPane.showMessageDialog(null, "Coloque algum item no carrinho para finalizar o pedido");
            return;
        }
        
        //Loopando o carrinho para checar se possui estoque dos produtos escolhidos
        for (int i = 0; i < numeroLinhas; i++){
            String nomeProduto = (String) tabelaCarrinho.getValueAt(i, 1);
            int codigoProduto = Integer.parseInt((String) tabelaCarrinho.getValueAt(i, 0));
            System.out.println("converte quantidade: " + (String) tabelaCarrinho.getValueAt(i, 5));
            int quantidadeItem = Integer.parseInt((String) tabelaCarrinho.getValueAt(i, 5));
            
            //Chama o método do controller para salvar infos no DB
            disponibilidadeEstoque = VendaController.consultaEstoqueDB(codigoProduto);
            
            //Verifica se possuímos estoque do produto
            try {
                if (disponibilidadeEstoque.next()){
                    int quantidadeEstoque = Integer.parseInt(disponibilidadeEstoque.getString("estoque"));
                    
                    if (quantidadeEstoque < quantidadeItem){
                        JOptionPane.showMessageDialog(null, "Não possuímos estoque do produto: " + nomeProduto + "\n\nQuantidade disponível: " + quantidadeEstoque + "\nQuantidade requisitada: " + quantidadeItem);
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível consultar estoque do produto: " + nomeProduto);
                    return;
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Não foi possível consultar estoque do produto: " + nomeProduto);
                return;
            }
        }
        
        //Array do pedido
        ArrayList<ArrayList> Pedido = new ArrayList();
        int itensPedido = 0;
        
        //Pegando todo os itens do carrinho, e adicionando ao array "Pedido"
        for (int i = 0; i < numeroLinhas; i++){
            //Array de itens do carrinho
            ArrayList<String> itemCarrinho = new ArrayList();
            //Quantidade desse item
            int quantidadeItem = 0;
            
            for (int j = 0; j < numeroColunas; j++){
                //Pega o valor da coluna atual
                String valorColunaAtual = (String) tabelaCarrinho.getValueAt(i, j);
                
                //Caso seja a coluna de valor, formatar como ####.##
                if (j == 4){
                    valorColunaAtual = valorColunaAtual.replace(".", "");
                    valorColunaAtual = valorColunaAtual.replace(",", ".");
                } else if (j == 5){
                    //Caso seja a coluna de quantidade
                    quantidadeItem = Integer.parseInt(valorColunaAtual);
                }
                
                //Adicionar a coluna ao item atual
                itemCarrinho.add(valorColunaAtual);
            }
            
            for (int k = 0; k < quantidadeItem; k++){
                //Adiciona ao array de pedido
                Pedido.add(itemCarrinho);
            }
            
            //Incrementa valor para ter o tracking do numero de pedidos
            itensPedido +=quantidadeItem;
        }

        //Chama o método do controller para salvar infos no DB
        int numPedido = VendaController.cadastrarDB(codigoC, valorVenda, itensPedido, Pedido);
        
        //Caso tenha dado certo
        if (numPedido != 0){
            JOptionPane.showMessageDialog(null, "Pedido realizado com sucesso!\nNumero do pedido gerado: " + numPedido);
            
            //Prepara ambiente para próximas execuções
            tabelaClientes.setRowCount(0);
            tabelaProdutos.setRowCount(0);
            tabelaCarrinho.setRowCount(0);
            codigoC = 0;
            precoCarrinho.setText("0");
            clienteCarrinho.setText("--");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar o pedido, tente novamente mais tarde.");
            return;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //Instancia a tabela do carrinho
        DefaultTableModel tabelaCarrinho = (DefaultTableModel) jTable3.getModel();
        tabelaCarrinho = (DefaultTableModel) jTable3.getModel();
        
        try { 
            //Pergunta para o usuário se ele realmente quer realizar a operação
            Object[] options = { "Confirmar", "Cancelar" };
            int resposta = JOptionPane.showOptionDialog(null, "Certeza que deseja limpar o carrinho?", "Confirmar operação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

            if (resposta == 0){
                //Limpa o carrinho
                tabelaCarrinho.setRowCount(0);
            } else {
                return;
            }
            
            //Reseta o valor e o cliente do carrinho
            precoCarrinho.setText("0");
            
            JOptionPane.showMessageDialog(null, "O carrinho foi limpo com sucesso!");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Não foi possível limpar o carrinho, tente novamente mais tarde.");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //Instancia a tabela de objetos
        DefaultTableModel tabelaProdutos = (DefaultTableModel) jTable2.getModel();
        tabelaProdutos = (DefaultTableModel) jTable2.getModel();
        tabelaProdutos.setNumRows(0); // <-- Limpa a tabela de execuções anteriores
        
        //Verifica se código do produto é int
        if (!codigoProduto.getText().isEmpty()){
            if (!validaNumero(codigoProduto.getText().trim())){
                JOptionPane.showMessageDialog(null, "O campo \"Código\" está incorreto");
                return;
            }
            codigoP = Integer.parseInt(codigoProduto.getText().trim());
        }
        
        //Crias as vars do processo
        String nome = nomeProduto.getText().trim();
        String fornecedor = (String) marcaProduto.getSelectedItem();
        String cor = (String) corProduto.getText().trim();
        
        //Chama o método do controller para consultar infos no DB
        ResultSet resultado = ProdutoController.consultarDB(codigoP, fornecedor, nome, cor);

        //Confirmação p/ usuário
        int resultados = 0;
        try {
            //Tenta exibir na tabela os resultados
            while (resultado.next()){
                tabelaProdutos.addRow(new Object[]{
                    resultado.getString("codProduto"),
                    resultado.getString("nome"),
                    resultado.getString("fornecedor"),
                    resultado.getString("cor"),
                    formatPtBr(resultado, "valor")
                });
                resultados++;
            } 
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a consulta, tente novamente mais tarde");
            return;
        }
        
        if (resultados == 0){
            JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado");
            return;
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        //Pergunta para o usuário se ele realmente quer realizar a operação
        Object[] options = { "Confirmar", "Cancelar" };
        int resposta = JOptionPane.showOptionDialog(null, "Certeza que deseja cancelar o pedido?", "Confirmar operação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        
        if (resposta == 0){
            //Caso usuário tenha confirmado a operação
            this.setVisible(false);
        } else {
            //Caso usuário não tenha confirmado a operação
            return;
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void corProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_corProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_corProdutoActionPerformed

    private void nomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeProdutoActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        //Instancia a tabela de objetos
        DefaultTableModel tabelaClientes = (DefaultTableModel) jTable1.getModel();
        tabelaClientes = (DefaultTableModel) jTable1.getModel();
        tabelaClientes.setNumRows(0); // <-- Limpa a tabela de execuções anteriores
        
        //Pega campos
        String codigo = codCli.getText().trim();
        String nome = nomeCli.getText().trim();
        String cpf = cpfCli.getText().trim();
        String cnpj = cnpjCli.getText().trim();
        String cpfNaoFormatado = cpf.replaceAll("[\\s()-.]", "");
        String cnpjNaoFormatado = cnpj.replaceAll("[\\s()-.\\/]", "");
        
        //Validação dos dados inputados pelo usuário:
        
        //Caso código nao seja um número
        if (!codigo.isEmpty()){
            if (!validaNumero(codigo)){
                JOptionPane.showMessageDialog(null, "Código inserido deve ser um número");
                return;
            }
        }
        
        //Transforma em int
        int codigoCliente = 0;
        if (!codigo.isEmpty()){
            codigoCliente = Integer.parseInt(codigo);
        }
        
        //Chama o método do controller para consultar infos no DB
        ResultSet resultadoCliente = ClienteController.consultarDBCliente(codigoCliente, cpf, cnpj, cpfNaoFormatado, cnpjNaoFormatado, nome);
        
        //Exibir na tabela os resultados
        int resultados = 0;
        try {
            while (resultadoCliente.next()){
                tabelaClientes.addRow(new Object[]{
                    resultadoCliente.getString("codCliente"),
                    resultadoCliente.getString("nome"),
                    resultadoCliente.getString("telefone"),
                    resultadoCliente.getString("email"),
                    resultadoCliente.getString("sexo"),
                    resultadoCliente.getString("cpf"),
                    resultadoCliente.getString("cnpj"),
                });
                resultados++;
                //Adiciona à quantidade de insercoes encontradas
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a consulta, tente novamente mais tarde");
            return;
        }
        
        if (resultados == 0){
            //Caso nao tenha encontrado nenhuma insercao
            JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado");
            return;
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        //Pega a linha que o usuário selecionou
        try {
            int linhaSelecionada = jTable1.getSelectedRow();
            codigoC = Integer.parseInt((String) jTable1.getValueAt(linhaSelecionada, 0));
            String nomeCli = (String) jTable1.getValueAt(linhaSelecionada, 1);
            clienteCarrinho.setText(nomeCli);
            JOptionPane.showMessageDialog(null, "Cliente: \"" + nomeCli + "\" escolhido com sucesso!");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Favor selecionar algum cliente");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        //Instancia a tabela do carrinho
        DefaultTableModel tabelaCarrinho = (DefaultTableModel) jTable3.getModel();
        tabelaCarrinho = (DefaultTableModel) jTable3.getModel();
        
        try {
            //Pega o produto do carrinho que o usuário selecionou
            int linhaSelecionada = jTable3.getSelectedRow();
            String nomeProduto = (String) jTable3.getValueAt(linhaSelecionada, 0);
            String valorProduto = (String) jTable3.getValueAt(linhaSelecionada, 4);
            int quantidadeProduto = Integer.parseInt((String) jTable3.getValueAt(linhaSelecionada, 5));
            
            //Pergunta para o usuário se ele realmente quer realizar a operação
            Object[] options = { "Confirmar", "Cancelar" };
            int resposta = JOptionPane.showOptionDialog(null, "Certeza que deseja remover o produto: \"" + nomeProduto + "\" do carrinho?", "Confirmar operação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            
            if (resposta == 0){
                //Remove o item do carrinho
                tabelaCarrinho.removeRow(linhaSelecionada);

                //Atualiza valor do carrinho
                atualizaPrecoCarrinho(valorProduto, quantidadeProduto, false);
            } else {
                return;
            }
            JOptionPane.showMessageDialog(null, "Item removido com sucesso!");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Favor selecionar algum produto");
            return;
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            //Instancia a tabela do carrinho
            DefaultTableModel tabelaCarrinho = (DefaultTableModel) jTable3.getModel();
            tabelaCarrinho = (DefaultTableModel) jTable3.getModel();
            //Pega os valores do produto que o usuário selecionou
            
            int linhaSelecionada = jTable2.getSelectedRow();
            String codigoProduto = (String) jTable2.getValueAt(linhaSelecionada, 0);
            String nomeProduto = (String) jTable2.getValueAt(linhaSelecionada, 1);
            String corProduto = (String) jTable2.getValueAt(linhaSelecionada, 2);
            String marcaProduto = (String) jTable2.getValueAt(linhaSelecionada, 3);
            String valorProduto = (String) jTable2.getValueAt(linhaSelecionada, 4);
            
            //Chama View responsável por perguntar ao usuário qual a quantidade desejada
            EscolheQuantidadeProduto getQuantidadeProduto = new EscolheQuantidadeProduto(this, true);
            getQuantidadeProduto.setVisible(true);

            //Pega a quantidade escolhida pelo usuário
            int quantidadeProduto = Integer.parseInt(getQuantidadeProduto.getValue());

            //Valida valores inputados
            if (quantidadeProduto == 0){
                return;
            }
            
            //Adiciona o item no carrinho
            tabelaCarrinho.addRow(new Object[]{
                codigoProduto,
                nomeProduto,
                corProduto,
                marcaProduto,
                valorProduto,
                getQuantidadeProduto.getValue()
            });
            
            //Pega o preco do item, e atualiza o valor total do carrinho
            atualizaPrecoCarrinho(valorProduto, quantidadeProduto, true);
                  
            JOptionPane.showMessageDialog(null, "Item adicionado com sucesso!");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Favor selecionar algum produto");
            return;
        }
    }//GEN-LAST:event_jButton9ActionPerformed

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

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try {
            //Chama View responsável por perguntar ao usuário qual a quantidade desejada
            EscolheQuantidadeProduto getQuantidadeProduto = new EscolheQuantidadeProduto(this, true);
            getQuantidadeProduto.setVisible(true);
            
            //Pega a quantidade escolhida pelo usuário
            String quantidadeProduto = getQuantidadeProduto.getValue();
            int quantidadeProd = Integer.parseInt(quantidadeProduto);
            
            //Atualiza tabela
            int linhaSelecionada = jTable3.getSelectedRow();
            String valorProduto = (String) jTable2.getValueAt(linhaSelecionada, 4);
            jTable3.setValueAt(quantidadeProduto, linhaSelecionada, 5);
            
            //Pega o preco do item, e atualiza o valor total do carrinho
            atualizaPrecoCarrinho(valorProduto, quantidadeProd, true);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Favor selecionar algum produto");
            return;
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RealizaPedidoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel clienteCarrinho;
    private javax.swing.JFormattedTextField cnpjCli;
    private javax.swing.JTextField codCli;
    private javax.swing.JTextField codigoProduto;
    private javax.swing.JTextField corProduto;
    private javax.swing.JFormattedTextField cpfCli;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JComboBox marcaProduto;
    private javax.swing.JTextField nomeCli;
    private javax.swing.JTextField nomeProduto;
    private javax.swing.JCheckBox pessoaJ;
    private javax.swing.JLabel precoCarrinho;
    // End of variables declaration//GEN-END:variables
}
