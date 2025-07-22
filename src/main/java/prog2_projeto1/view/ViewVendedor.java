package prog2_projeto1.view;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import prog2_projeto1.controller.VendedorController;
import prog2_projeto1.model.Vendedor;


public class viewVendedor {

    public static void main(String[] args) {
        JFrame tela = new JFrame("Vendedor");
        tela.setSize(1024, 768);
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tela.add(tabbedPane);

        JPanel panelCadastro = new JPanel();
        panelCadastro.setLayout(null);

        int y = 10;
        JLabel lblId = new JLabel("ID");
        lblId.setBounds(10, 10, 250, 25);
        panelCadastro.add(lblId);

        y += 20;
        JTextField txtId = new JTextField();
        txtId.setBounds(10, y, 150, 25);
        txtId.setEditable(false);
        panelCadastro.add(txtId);

        y += 30;
        JLabel lblData_cadastro = new JLabel("Data Cadastro (dd/mm/aaaa)");
        lblData_cadastro.setBounds(10, y, 300, 25);
        panelCadastro.add(lblData_cadastro);

        y += 20;
        JTextField txtData_cadastro = new JTextField();
        txtData_cadastro.setBounds(10, y, 150, 25);
        panelCadastro.add(txtData_cadastro);

        y += 30;
        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(10, y, 150, 25);
        panelCadastro.add(lblNome);

        y += 20;
        JTextField txtNome = new JTextField();
        txtNome.setBounds(10, y, 150, 25);
        panelCadastro.add(txtNome);

        y += 30;
        JLabel lblCpf = new JLabel("CPF");
        lblCpf.setBounds(10, y, 150, 25);
        panelCadastro.add(lblCpf);

        y += 20;
        JTextField txtCpf = new JTextField();
        txtCpf.setBounds(10, y, 150, 25);
        panelCadastro.add(txtCpf);

        y += 30;
        JLabel lblRg = new JLabel("RG");
        lblRg.setBounds(10, y, 250, 25);
        panelCadastro.add(lblRg);

        y += 20;
        JTextField txtRg = new JTextField();
        txtRg.setBounds(10, y, 150, 25);
        panelCadastro.add(txtRg);

        y += 30;
        JLabel lblEndereco = new JLabel("Endereço");
        lblEndereco.setBounds(10, y, 150, 25);
        panelCadastro.add(lblEndereco);

        y += 20;
        JTextField txtEndereco = new JTextField();
        txtEndereco.setBounds(10, y, 150, 25);
        panelCadastro.add(txtEndereco);

        y += 30;
        JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setBounds(10, y, 150, 25);
        panelCadastro.add(lblTelefone);

        y += 20;
        JTextField txtTelefone = new JTextField();
        txtTelefone.setBounds(10, y, 150, 25);
        panelCadastro.add(txtTelefone);

        y += 30;
        JLabel lblEmail = new JLabel("E-mail");
        lblEmail.setBounds(10, y, 150, 25);
        panelCadastro.add(lblEmail);

        y += 20;
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(10, y, 150, 25);
        panelCadastro.add(txtEmail);

        y += 30;
        JLabel lblSalario = new JLabel("Salario");
        lblSalario.setBounds(10, y, 150, 25);
        panelCadastro.add(lblSalario);

        y += 20;
        JTextField txtSalario = new JTextField();
        txtSalario.setBounds(10, y, 150, 25);
        panelCadastro.add(txtSalario);

        y += 30;
        JLabel lblComissao = new JLabel("Comissão");
        lblComissao.setBounds(10, y, 150, 25);
        panelCadastro.add(lblComissao);

        y += 20;
        JTextField txtComissao = new JTextField();
        txtComissao.setBounds(10, y, 150, 25);
        panelCadastro.add(txtComissao);

        y += 40;
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, y, 150, 25);
        panelCadastro.add(btnSalvar);

        JButton btnAlterar = new JButton("Alterar");
        btnAlterar.setBounds(170, y, 150, 25);
        panelCadastro.add(btnAlterar);


        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(330, y, 150, 25);
        panelCadastro.add(btnExcluir);

        JButton btnLimparCampos = new JButton("Limpar Campos");
        btnLimparCampos.setBounds(490, y, 150, 25);
        panelCadastro.add(btnLimparCampos);

        tabbedPane.addTab("Cadastro de Vendedores", panelCadastro);

        btnSalvar.addActionListener(e -> {
            Vendedor vendedor = new Vendedor();
            VendedorController vendedorController = new VendedorController();
            String dataTexto = txtData_cadastro.getText();
            
            try {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/mm/yyyy");
                java.util.Date dataUtil = sdf.parse(dataTexto);
                java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
                vendedor.setData_cadastro(dataSql);

            } catch (Exception b) {
                b.printStackTrace();
                JOptionPane.showMessageDialog(null, "Data inválida! Use o formato dd/mm/yyyy.");
            }
            vendedor.setNome(txtNome.getText());
            vendedor.setCpf(txtCpf.getText());
            vendedor.setRg(txtRg.getText());
            vendedor.setEndereco(txtEndereco.getText());
            vendedor.setTelefone(txtTelefone.getText());
            vendedor.setEmail(txtEmail.getText());
            vendedor.setSalario(Double.parseDouble(txtSalario.getText()));
            vendedor.setComissao(Double.parseDouble(txtSalario.getText()));

            boolean resultado = vendedorController.salvar(vendedor);
            JOptionPane.showMessageDialog(btnSalvar,
                    resultado ? "Vendedor salvo com sucesso!" : "Erro ao salvar vendedor.",
                    resultado ? "Sucesso" : "Erro",
                    resultado ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        });

        btnAlterar.addActionListener(e -> {
            Vendedor vendedor = new Vendedor();
            VendedorController vendedorController = new VendedorController();
            vendedor.setId(Integer.parseInt(txtId.getText()));
            String dataTexto = txtData_cadastro.getText();
            
            try {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/mm/yyyy");
                java.util.Date dataUtil = sdf.parse(dataTexto);
                java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
                vendedor.setData_cadastro(dataSql);

            } catch (Exception b) {
                b.printStackTrace();
                JOptionPane.showMessageDialog(null, "Data inválida! Use o formato dd/mm/yyyy.");
            }
            vendedor.setNome(txtNome.getText());
            vendedor.setCpf(txtCpf.getText());
            vendedor.setRg(txtRg.getText());
            vendedor.setEndereco(txtEndereco.getText());
            vendedor.setTelefone(txtTelefone.getText());
            vendedor.setEmail(txtEmail.getText());
            vendedor.setSalario(Double.parseDouble(txtSalario.getText()));
            vendedor.setComissao(Double.parseDouble(txtSalario.getText()));


            boolean resultado = vendedorController.alterar(vendedor);
            JOptionPane.showMessageDialog(btnAlterar,
                    resultado ? "Vendedor alterado com sucesso!" : "Erro ao alterar vendedor.",
                    resultado ? "Sucesso" : "Erro",
                    resultado ? JOptionPane .INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        });

        btnExcluir.addActionListener(e -> {
            String idText = txtId.getText();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(btnExcluir, "Por favor, informe o ID do vendedor a ser excluído.",
                        "ID obrigatório", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int confirmacao = JOptionPane.showConfirmDialog(btnExcluir,
                    "Tem certeza que deseja excluir o vendedor com ID " + idText + "?",
                    "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);

            if (confirmacao == JOptionPane.YES_OPTION) {
                Vendedor vendedor = new Vendedor();
                vendedor.setId(Integer.parseInt(idText));

                VendedorController vendedorController = new VendedorController();
                boolean resultado = vendedorController.excluir(vendedor);

                JOptionPane.showMessageDialog(btnExcluir,
                        resultado ? "Vendedor excluído com sucesso!" : "Erro ao excluir vendedor.",
                        resultado ? "Sucesso" : "Erro",
                        resultado ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
                if (resultado) {
                    txtId.setText("");
                    txtData_cadastro.setText("");
                    txtNome.setText("");
                    txtCpf.setText("");
                    txtRg.setText("");
                    txtEndereco.setText("");
                    txtTelefone.setText("");
                    txtEmail.setText("");
                    txtSalario.setText("");
                    txtComissao.setText("");
                }
            }
        });

        btnLimparCampos.addActionListener(e -> {
                txtId.setText("");
                txtData_cadastro.setText("");
                txtNome.setText("");
                txtCpf.setText("");
                txtRg.setText("");
                txtEndereco.setText("");
                txtTelefone.setText("");
                txtEmail.setText("");
                txtSalario.setText("");
                txtComissao.setText("");
        });

        JPanel panelTabela = new JPanel();
        panelTabela.setLayout(new BoxLayout(panelTabela, BoxLayout.Y_AXIS));

        String[] colunas = {"ID","Data Cadastro", "Nome", "CPF", "RG", "Endereço", "Telefone", "Email", "Salário", "Comissão"};
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modeloTabela);
        tabela.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(tabela);
        panelTabela.add(scrollPane);

        JButton btnRecarregar = new JButton("Atualizar consulta");
        panelTabela.add(btnRecarregar);

        btnRecarregar.addActionListener(e -> {
            modeloTabela.setRowCount(0);
            VendedorController vendedorController = new VendedorController();
            List<Vendedor> vendedores = vendedorController.buscarTodos();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/mm/yyyy");

            for (Vendedor v : vendedores) {
                String dataCadastroFormatada = v.getData_cadastro() != null ? sdf.format(v.getData_cadastro()) : "";

                modeloTabela.addRow(new Object[]{
                    v.getId(),
                    dataCadastroFormatada,
                    v.getNome(),
                    v.getCpf(),
                    v.getRg(),
                    v.getEndereco(),
                    v.getTelefone(),
                    v.getEmail(),
                    v.getSalario(),
                    v.getComissao()
                });
            }
        });


        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int linha = tabela.getSelectedRow();
                    txtId.setText(tabela.getValueAt(linha, 0).toString());
                    txtData_cadastro.setText(tabela.getValueAt(linha, 1).toString());
                    txtNome.setText(tabela.getValueAt(linha, 2).toString());
                    txtCpf.setText(tabela.getValueAt(linha, 3).toString());
                    txtRg.setText(tabela.getValueAt(linha, 4).toString());
                    txtEndereco.setText(tabela.getValueAt(linha, 5).toString());
                    txtTelefone.setText(tabela.getValueAt(linha, 6).toString());
                    txtEmail.setText(tabela.getValueAt(linha, 7).toString());
                    txtSalario.setText(tabela.getValueAt(linha, 8).toString());
                    txtComissao.setText(tabela.getValueAt(linha, 9).toString());
                    tabbedPane.setSelectedIndex(0);
                }
            }
        });
        tabbedPane.addTab("Lista de Vendedores", panelTabela);

        tela.setVisible(true);
    }
}
