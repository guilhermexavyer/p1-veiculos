package prog2_projeto1.view;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import prog2_projeto1.controller.ClienteController;
import prog2_projeto1.model.Cliente;

public class viewCliente {

    public static void main(String[] args) {
        JFrame tela = new JFrame("Clientes");
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
        JLabel lblReferencia_comercial = new JLabel("Referencia Comercial");
        lblReferencia_comercial.setBounds(10, y, 150, 25);
        panelCadastro.add(lblReferencia_comercial);

        y += 20;
        JTextField txtReferencia_comercial = new JTextField();
        txtReferencia_comercial.setBounds(10, y, 150, 25);
        panelCadastro.add(txtReferencia_comercial);

        y += 30;
        JLabel lblData_nascimento = new JLabel("Data Nascimento (dd/mm/aaaa)");
        lblData_nascimento.setBounds(10, y, 300, 25);
        panelCadastro.add(lblData_nascimento);

        y += 20;
        JTextField txtData_nascimento = new JTextField();
        txtData_nascimento.setBounds(10, y, 150, 25);
        panelCadastro.add(txtData_nascimento);

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

        tabbedPane.addTab("Cadastro de Clientes", panelCadastro);

        btnSalvar.addActionListener(e -> {
            Cliente cliente = new Cliente();
            ClienteController clienteController = new ClienteController();
            String dataTexto = txtData_cadastro.getText();
            try {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/mm/yyyy");
                java.util.Date dataUtil = sdf.parse(dataTexto);
                java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
                cliente.setData_cadastro(dataSql);

            } catch (Exception b) {
                b.printStackTrace();
                JOptionPane.showMessageDialog(null, "Data inválida! Use o formato dd/mm/yyyy.");
            }
            cliente.setNome(txtNome.getText());
            cliente.setCpf(txtCpf.getText());
            cliente.setRg(txtRg.getText());
            cliente.setEndereco(txtEndereco.getText());
            cliente.setTelefone(txtTelefone.getText());
            cliente.setEmail(txtEmail.getText());
            cliente.setReferencia_comercial(txtReferencia_comercial.getText());
            String dataTexto2 = txtData_nascimento.getText();

            try {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/mm/yyyy");
                java.util.Date dataUtil = sdf.parse(dataTexto2);
                java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
                cliente.setData_nascimento(dataSql);

            } catch (Exception b) {
                b.printStackTrace();
                JOptionPane.showMessageDialog(null, "Data inválida! Use o formato dd/mm/yyyy.");
            }

            boolean resultado = clienteController.salvar(cliente);
            JOptionPane.showMessageDialog(btnSalvar,
                    resultado ? "Cliente salvo com sucesso!" : "Erro ao salvar cliente.",
                    resultado ? "Sucesso" : "Erro",
                    resultado ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        });

        btnAlterar.addActionListener(e -> {
            Cliente cliente = new Cliente();
            ClienteController clienteController = new ClienteController();
            cliente.setId(Integer.parseInt(txtId.getText()));
            String dataTexto = txtData_cadastro.getText();
            try {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/mm/yyyy");
                java.util.Date dataUtil = sdf.parse(dataTexto);
                java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
                cliente.setData_cadastro(dataSql);

            } catch (Exception b) {
                b.printStackTrace();
                JOptionPane.showMessageDialog(null, "Data inválida! Use o formato dd/mm/yyyy.");
            }
            cliente.setNome(txtNome.getText());
            cliente.setCpf(txtCpf.getText());
            cliente.setRg(txtRg.getText());
            cliente.setEndereco(txtEndereco.getText());
            cliente.setTelefone(txtTelefone.getText());
            cliente.setEmail(txtEmail.getText());
            cliente.setReferencia_comercial(txtReferencia_comercial.getText());
            String dataTexto2 = txtData_nascimento.getText();

            try {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/mm/yyyy");
                java.util.Date dataUtil = sdf.parse(dataTexto2);
                java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
                cliente.setData_nascimento(dataSql);

            } catch (Exception b) {
                b.printStackTrace();
                JOptionPane.showMessageDialog(null, "Data inválida! Use o formato dd/mm/yyyy.");
            }

            boolean resultado = clienteController.alterar(cliente);
            JOptionPane.showMessageDialog(btnSalvar,
                    resultado ? "Cliente alterado com sucesso!" : "Erro ao alterar cliente.",
                    resultado ? "Sucesso" : "Erro",
                    resultado ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        });

        btnExcluir.addActionListener(e -> {
            String idText = txtId.getText();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(btnExcluir, "Por favor, informe o ID do cliente a ser excluído.",
                        "ID obrigatório", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int confirmacao = JOptionPane.showConfirmDialog(btnExcluir,
                    "Tem certeza que deseja excluir o cliente com ID " + idText + "?",
                    "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);

            if (confirmacao == JOptionPane.YES_OPTION) {
                Cliente cliente = new Cliente();
                cliente.setId(Integer.parseInt(idText));

                ClienteController clienteController = new ClienteController();
                boolean resultado = clienteController.excluir(cliente);

                JOptionPane.showMessageDialog(btnExcluir,
                        resultado ? "Cliente excluído com sucesso!" : "Erro ao excluir cliente.",
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
                    txtReferencia_comercial.setText("");
                    txtData_nascimento.setText("");
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
                txtReferencia_comercial.setText("");
                txtData_nascimento.setText("");
        });

        JPanel panelTabela = new JPanel();
        panelTabela.setLayout(new BoxLayout(panelTabela, BoxLayout.Y_AXIS));

        String[] colunas = {"ID","Data Cadastro", "Nome", "CPF", "RG", "Endereço", "Telefone", "Email", "Referência Comercial", "Data Nascimento"};
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modeloTabela);
        tabela.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(tabela);
        panelTabela.add(scrollPane);

        JButton btnRecarregar = new JButton("Atualizar consulta");
        panelTabela.add(btnRecarregar);

        btnRecarregar.addActionListener(e -> {
            modeloTabela.setRowCount(0);
            ClienteController clienteController = new ClienteController();
            List<Cliente> clientes = clienteController.buscarTodos();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/mm/yyyy");

        for (Cliente v : clientes) {
            String dataCadastroFormatada = v.getData_cadastro() != null ? sdf.format(v.getData_cadastro()) : "";
            String dataNascimentoFormatada = v.getData_nascimento() != null ? sdf.format(v.getData_nascimento()) : "";

            modeloTabela.addRow(new Object[]{
                v.getId(),
                dataCadastroFormatada,
                v.getNome(),
                v.getCpf(),
                v.getRg(),
                v.getEndereco(),
                v.getTelefone(),
                v.getEmail(),
                v.getReferencia_comercial(),
                dataNascimentoFormatada
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
                    txtReferencia_comercial.setText(tabela.getValueAt(linha, 8).toString());
                    txtData_nascimento.setText(tabela.getValueAt(linha, 9).toString());
                    tabbedPane.setSelectedIndex(0);
                }
            }
        });
        tabbedPane.addTab("Lista de Clientes", panelTabela);

        tela.setVisible(true);
    }
}