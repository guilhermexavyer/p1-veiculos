package prog2_projeto1.view;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import prog2_projeto1.controller.VeiculoController;
import prog2_projeto1.controller.ClienteController;
import prog2_projeto1.controller.VendaVeiculoController;
import prog2_projeto1.controller.VendedorController;
import prog2_projeto1.model.Veiculo;
import prog2_projeto1.model.Cliente;
import prog2_projeto1.model.VendaVeiculo;
import prog2_projeto1.model.Vendedor;

public class ViewVendaVeiculo {

    public static void main(String[] args) {
        JFrame tela = new JFrame("Venda de veículo");
        tela.setSize(1024, 768);
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setLocationRelativeTo(null);

        JComboBox<Cliente> comboCliente = new JComboBox<>();
        preencherComboClientes(comboCliente);

        JComboBox<Vendedor> comboVendedor = new JComboBox<>();
        preencherComboVendedores(comboVendedor);

        JComboBox<Veiculo> comboVeiculo = new JComboBox<>();
        preencherComboVeiculos(comboVeiculo);

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
        JLabel lblData_venda = new JLabel("Data Venda dd/MM/aaaa");
        lblData_venda.setBounds(10, y, 150, 25);
        panelCadastro.add(lblData_venda);

       y += 20;
        JTextField txtData_venda = new JTextField();
        txtData_venda.setBounds(10, y, 150, 25);
        panelCadastro.add(txtData_venda);

        y += 30;
        JLabel lblValor_desconto = new JLabel("Valor Desconto");
        lblValor_desconto.setBounds(10, y, 150, 25);
        panelCadastro.add(lblValor_desconto);

        y += 20;
        JTextField txtValor_desconto = new JTextField();
        txtValor_desconto.setBounds(10, y, 150, 25);
        panelCadastro.add(txtValor_desconto);


        y += 30;
        JLabel lblValor_final = new JLabel("Valor Final");
        lblValor_final.setBounds(10, y, 150, 25);
        panelCadastro.add(lblValor_final);

        y += 20;
        JTextField txtValor_final = new JTextField();
        txtValor_final.setBounds(10, y, 150, 25);
        panelCadastro.add(txtValor_final);

        y += 30;
        JLabel lblCliente = new JLabel("Cliente");
        lblCliente.setBounds(10, y, 150, 25);
        panelCadastro.add(lblCliente);

        y += 20;
        comboCliente.setBounds(10, y, 150, 25);
        panelCadastro.add(comboCliente);

        y += 30;
        JLabel lblVendedor = new JLabel("Vendedor");
        lblVendedor.setBounds(10, y, 150, 25);
        panelCadastro.add(lblVendedor);

        y += 20;
        comboVendedor.setBounds(10, y, 150, 25);
        panelCadastro.add(comboVendedor);

        y += 30;
        JLabel lblVeiculo = new JLabel("Veiculo ");
        lblVeiculo .setBounds(10, y, 150, 25);
        panelCadastro.add(lblVeiculo );

        y += 20;
        comboVeiculo .setBounds(10, y, 150, 25);
        panelCadastro.add(comboVeiculo);

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

        tabbedPane.addTab("Cadastro de Venda de Veículos", panelCadastro);

        btnSalvar.addActionListener(e -> {
            VendaVeiculo vendaVeiculo = new VendaVeiculo();
            VendaVeiculoController vendaVeiculoController = new VendaVeiculoController();
            String dataTexto = txtData_venda.getText();
            try {
                java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
                java.time.LocalDate dataVenda = java.time.LocalDate.parse(dataTexto, formatter);
                vendaVeiculo.setData_venda(dataVenda);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Data inválida! Use o formato dd/MM/yyyy.");
                ex.printStackTrace();
                return;
            }
            vendaVeiculo.setValor_desconto(Double.parseDouble(txtValor_desconto.getText()));
            vendaVeiculo.setValor_final(Double.parseDouble(txtValor_final.getText()));
            vendaVeiculo.setCliente((Cliente) comboCliente.getSelectedItem());
            vendaVeiculo.setVendedor((Vendedor) comboVendedor.getSelectedItem());
            vendaVeiculo.setVeiculo((Veiculo) comboVeiculo.getSelectedItem());
            boolean resultado = vendaVeiculoController.salvar(vendaVeiculo);
            JOptionPane.showMessageDialog(btnSalvar,
                    resultado ? "Venda Veiculo salvo com sucesso!" : "Erro ao salvar venda veículo.",
                    resultado ? "Sucesso" : "Erro",
                    resultado ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        });

        btnAlterar.addActionListener(e -> {
            VendaVeiculo vendaVeiculo = new VendaVeiculo();
            VendaVeiculoController vendaVeiculoController = new VendaVeiculoController();
            vendaVeiculo.setId(Integer.parseInt(txtId.getText()));
            String dataTexto = txtData_venda.getText();
            try {
                java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
                java.time.LocalDate dataVenda = java.time.LocalDate.parse(dataTexto, formatter);
                vendaVeiculo.setData_venda(dataVenda);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Data inválida! Use o formato dd/MM/yyyy.");
                ex.printStackTrace();
                return;
            }
            vendaVeiculo.setValor_desconto(Double.parseDouble(txtValor_desconto.getText()));
            vendaVeiculo.setValor_final(Double.parseDouble(txtValor_final.getText()));      
            vendaVeiculo.setCliente((Cliente) comboCliente.getSelectedItem());
            vendaVeiculo.setVendedor((Vendedor) comboVendedor.getSelectedItem());
            vendaVeiculo.setVeiculo((Veiculo) comboVeiculo.getSelectedItem());
            boolean resultado = vendaVeiculoController.alterar(vendaVeiculo);
            JOptionPane.showMessageDialog(btnAlterar,
                    resultado ? "Venda Veiculo alterado com sucesso!" : "Erro ao alterar venda veículo.",
                    resultado ? "Sucesso" : "Erro",
                    resultado ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        });

        btnExcluir.addActionListener(e -> {
            String idText = txtId.getText();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(btnExcluir, "Por favor, informe o ID do venda veículo a ser excluído.",
                        "ID obrigatório", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int confirmacao = JOptionPane.showConfirmDialog(btnExcluir,
                    "Tem certeza que deseja excluir a venda veículo com ID " + idText + "?",
                    "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);

            if (confirmacao == JOptionPane.YES_OPTION) {
                VendaVeiculo vendaVeiculo = new VendaVeiculo();
                vendaVeiculo.setId(Integer.parseInt(idText));

                VendaVeiculoController vendaVeiculoController = new VendaVeiculoController();
                boolean resultado = vendaVeiculoController.excluir(vendaVeiculo);

                JOptionPane.showMessageDialog(btnExcluir,
                        resultado ? "Venda veiculo excluído com sucesso!" : "Erro ao excluir venda veículo.",
                        resultado ? "Sucesso" : "Erro",
                        resultado ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
                if (resultado) {
                    txtId.setText("");
                    txtData_venda.setText("");
                    txtValor_desconto.setText("");
                    txtValor_final.setText("");
                    comboCliente.setSelectedIndex(0);
                    comboVendedor.setSelectedIndex(0);
                    comboVeiculo.setSelectedIndex(0);
                }
            }
        });

        btnLimparCampos.addActionListener(e -> {
                txtId.setText("");
                txtData_venda.setText("");
                txtValor_desconto.setText("");
                txtValor_final.setText("");
                comboCliente.setSelectedIndex(0);
                comboVendedor.setSelectedIndex(0);
                comboVeiculo.setSelectedIndex(0);
        });

        JPanel panelTabela = new JPanel();
        panelTabela.setLayout(new BoxLayout(panelTabela, BoxLayout.Y_AXIS));

        String[] colunas = {"ID", "Data Venda", "Valor Desconto", "Valor Final", "Cliente", "Vendedor", "Veiculo"};
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modeloTabela);
        tabela.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(tabela);
        panelTabela.add(scrollPane);

        JButton btnRecarregar = new JButton("Atualizar consulta");
        panelTabela.add(btnRecarregar);

        btnRecarregar.addActionListener(e -> {
            modeloTabela.setRowCount(0);
            VendaVeiculoController vendaVeiculoController = new VendaVeiculoController();
            List<VendaVeiculo> vendaVeiculos = vendaVeiculoController.buscarTodos();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");

            for (VendaVeiculo v : vendaVeiculos) {
                String dataVenda = v.getData_venda() != null ? 
                    sdf.format(java.sql.Date.valueOf(v.getData_venda())) : "";

                modeloTabela.addRow(new Object[]{
                    v.getId(),
                    dataVenda,
                    v.getValor_desconto(),
                    v.getValor_final(),
                    v.getCliente(),
                    v.getVendedor(),
                    v.getVeiculo()
                });
            }
        });

        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int linha = tabela.getSelectedRow();
                    txtId.setText(tabela.getValueAt(linha, 0).toString());
                    txtData_venda.setText(tabela.getValueAt(linha, 1).toString());
                    txtValor_desconto.setText(tabela.getValueAt(linha, 2).toString());
                    txtValor_final.setText(tabela.getValueAt(linha, 3).toString());
                    comboCliente.setSelectedItem((Cliente) tabela.getValueAt(linha, 4));;
                    comboVendedor.setSelectedItem((Vendedor) tabela.getValueAt(linha, 5));;
                    comboVeiculo.setSelectedItem((Veiculo) tabela.getValueAt(linha, 6));;
                    tabbedPane.setSelectedIndex(0);
                }
            }
        });
        tabbedPane.addTab("Lista de Venda de Veiculos", panelTabela);

        tela.setVisible(true);
    }

    private static void preencherComboClientes(JComboBox combo) {
        ClienteController clienteController = new ClienteController();

        List<Cliente> clientes = clienteController.buscarTodos();

        for(Cliente cliente : clientes) {
            combo.addItem(cliente);
        }
    }

        private static void preencherComboVendedores(JComboBox combo) {
        VendedorController vendedorController = new VendedorController();

        List<Vendedor> vendedores = vendedorController.buscarTodos();

        for(Vendedor vendedor : vendedores) {
            combo.addItem(vendedor);
        }
    }

        private static void preencherComboVeiculos(JComboBox combo) {
        VeiculoController veiculoController = new VeiculoController();

        List<Veiculo> veiculos = veiculoController.buscarTodos();

        for(Veiculo veiculo : veiculos) {
            combo.addItem(veiculo);
        }
    }
}