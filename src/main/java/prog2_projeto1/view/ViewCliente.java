package prog2_projeto1.view;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import prog2_projeto1.controller.ClienteController;
import prog2_projeto1.model.Cliente;

public class ViewCliente {
    public static void main(String[] args) {
        JFrame tela = new JFrame("Cadastro de Clientes");
        tela.setSize(900, 500);
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tela.add(tabbedPane);

        // Painel de Cadastro
        JPanel panelCadastro = new JPanel();
        panelCadastro.setLayout(null);

        JLabel lblId = new JLabel("ID");
        lblId.setBounds(10, 10, 150, 25);
        panelCadastro.add(lblId);

        JTextField txtId = new JTextField();
        txtId.setBounds(10, 30, 100, 25);
        txtId.setEditable(false);
        panelCadastro.add(txtId);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(10, 60, 150, 25);
        panelCadastro.add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(10, 80, 300, 25);
        panelCadastro.add(txtNome);

        JLabel lblCpf = new JLabel("CPF");
        lblCpf.setBounds(10, 110, 150, 25);
        panelCadastro.add(lblCpf);

        JTextField txtCpf = new JTextField();
        txtCpf.setBounds(10, 130, 200, 25);
        panelCadastro.add(txtCpf);

        JLabel lblRg = new JLabel("RG");
        lblRg.setBounds(10, 160, 150, 25);
        panelCadastro.add(lblRg);

        JTextField txtRg = new JTextField();
        txtRg.setBounds(10, 180, 200, 25);
        panelCadastro.add(txtRg);

        JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setBounds(10, 210, 150, 25);
        panelCadastro.add(lblTelefone);

        JTextField txtTelefone = new JTextField();
        txtTelefone.setBounds(10, 230, 200, 25);
        panelCadastro.add(txtTelefone);

        JLabel lblReferencia = new JLabel("Referência Comercial");
        lblReferencia.setBounds(10, 260, 200, 25);
        panelCadastro.add(lblReferencia);

        JTextField txtReferencia = new JTextField();
        txtReferencia.setBounds(10, 280, 300, 25);
        panelCadastro.add(txtReferencia);

        JLabel lblDataNasc = new JLabel("Data de Nascimento (AAAA-MM-DD)");
        lblDataNasc.setBounds(10, 310, 300, 25);
        panelCadastro.add(lblDataNasc);

        JTextField txtDataNasc = new JTextField();
        txtDataNasc.setBounds(10, 330, 200, 25);
        panelCadastro.add(txtDataNasc);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, 380, 150, 25);
        panelCadastro.add(btnSalvar);

        JButton btnAlterar = new JButton("Alterar");
        btnAlterar.setBounds(170, 380, 150, 25);
        panelCadastro.add(btnAlterar);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(330, 380, 150, 25);
        panelCadastro.add(btnExcluir);

        JButton btnLimparCampos = new JButton("Limpar Campos");
        btnLimparCampos.setBounds(500, 380, 150, 25);
        panelCadastro.add(btnLimparCampos);

        tabbedPane.addTab("Cadastro", panelCadastro);

        // Botões
        ClienteController clienteController = new ClienteController();

        btnSalvar.addActionListener((ActionEvent e) -> {
            try {
                Cliente cliente = new Cliente();
                cliente.setNome(txtNome.getText());
                cliente.setCpf(txtCpf.getText());
                cliente.setRg(txtRg.getText());
                cliente.setTelefone(txtTelefone.getText());
                cliente.setReferenciaComercial(txtReferencia.getText());
                cliente.setDataNascimento(LocalDate.parse(txtDataNasc.getText()));

                boolean resultado = clienteController.salvar(cliente);
                if (resultado) {
                    JOptionPane.showMessageDialog(tela, "Cliente salvo com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(tela, "Erro ao salvar cliente!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(tela, "Erro nos dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnAlterar.addActionListener(e -> {
            try {
                Cliente cliente = new Cliente();
                cliente.setId(Integer.parseInt(txtId.getText()));
                cliente.setNome(txtNome.getText());
                cliente.setCpf(txtCpf.getText());
                cliente.setRg(txtRg.getText());
                cliente.setTelefone(txtTelefone.getText());
                cliente.setReferenciaComercial(txtReferencia.getText());
                cliente.setDataNascimento(LocalDate.parse(txtDataNasc.getText()));

                boolean resultado = clienteController.alterar(cliente);
                if (resultado) {
                    JOptionPane.showMessageDialog(tela, "Cliente alterado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(tela, "Erro ao alterar cliente!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(tela, "Erro nos dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnExcluir.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(tela, "Tem certeza que deseja excluir o cliente?",
                    "Confirmação", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) return;

            Cliente cliente = new Cliente();
            cliente.setId(Integer.parseInt(txtId.getText()));

            boolean resultado = clienteController.excluir(cliente);
            if (resultado) {
                JOptionPane.showMessageDialog(tela, "Cliente excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(tela, "Erro ao excluir cliente!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnLimparCampos.addActionListener(e -> {
            txtId.setText("");
            txtNome.setText("");
            txtCpf.setText("");
            txtRg.setText("");
            txtTelefone.setText("");
            txtReferencia.setText("");
            txtDataNasc.setText("");
        });

        // Painel de Listagem
        JPanel panelTabela = new JPanel();
        panelTabela.setLayout(new BoxLayout(panelTabela, BoxLayout.Y_AXIS));

        String[] colunas = { "ID", "Nome", "CPF", "RG", "Telefone", "Referência", "Data Nasc." };
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modeloTabela);
        tabela.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(tabela);
        panelTabela.add(scrollPane);

        tabbedPane.addTab("Lista de Clientes", panelTabela);

        tabbedPane.addChangeListener(e -> {
            if (tabbedPane.getSelectedIndex() == 1) {
                modeloTabela.setRowCount(0);
                List<Cliente> clientes = clienteController.buscarTodos();
                for (Cliente c : clientes) {
                    modeloTabela.addRow(new Object[] {
                        c.getId(),
                        c.getNome(),
                        c.getCpf(),
                        c.getRg(),
                        c.getTelefone(),
                        c.getReferenciaComercial(),
                        c.getDataNascimento()
                    });
                }
            }
        });

        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int linha = tabela.getSelectedRow();
                    txtId.setText(tabela.getValueAt(linha, 0).toString());
                    txtNome.setText(tabela.getValueAt(linha, 1).toString());
                    txtCpf.setText(tabela.getValueAt(linha, 2).toString());
                    txtRg.setText(tabela.getValueAt(linha, 3).toString());
                    txtTelefone.setText(tabela.getValueAt(linha, 4).toString());
                    txtReferencia.setText(tabela.getValueAt(linha, 5).toString());
                    txtDataNasc.setText(tabela.getValueAt(linha, 6).toString());
                    tabbedPane.setSelectedIndex(0);
                }
            }
        });

        tela.setVisible(true);
    }
}
