package prog2_projeto1.view;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import prog2_projeto1.controller.CategoriaController;
import prog2_projeto1.controller.VeiculoController;
import prog2_projeto1.model.Categoria;
import prog2_projeto1.model.Veiculo;

public class viewVeiculo {

    public static void main(String[] args) {
        JFrame tela = new JFrame("Veículos");
        tela.setSize(1024, 768);
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setLocationRelativeTo(null);

        JComboBox<Categoria> comboCategoria = new JComboBox<>();
        preencherComboCategorias(comboCategoria);

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
        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(10, y, 150, 25);
        panelCadastro.add(lblNome);

        y += 20;
        JTextField txtNome = new JTextField();
        txtNome.setBounds(10, y, 150, 25);
        panelCadastro.add(txtNome);

        y += 30;
        JLabel lblCategoria = new JLabel("Categoria");
        lblCategoria.setBounds(10, y, 150, 25);
        panelCadastro.add(lblCategoria);

        y += 20;
        comboCategoria.setBounds(10, y, 150, 25);
        panelCadastro.add(comboCategoria);

        y += 30;
        JLabel lblAno = new JLabel("Ano");
        lblAno.setBounds(10, y, 150, 25);
        panelCadastro.add(lblAno);

        y += 20;
        JTextField txtAno = new JTextField();
        txtAno.setBounds(10, y, 150, 25);
        panelCadastro.add(txtAno);

        y += 30;
        JLabel lblModelo = new JLabel("Modelo");
        lblModelo.setBounds(10, y, 250, 25);
        panelCadastro.add(lblModelo);

        y += 20;
        JTextField txtModelo = new JTextField();
        txtModelo.setBounds(10, y, 150, 25);
        panelCadastro.add(txtModelo);

        y += 30;
        JLabel lblCor = new JLabel("Cor");
        lblCor.setBounds(10, y, 150, 25);
        panelCadastro.add(lblCor);

        y += 20;
        JTextField txtCor = new JTextField();
        txtCor.setBounds(10, y, 150, 25);
        panelCadastro.add(txtCor);

        y += 30;
        JLabel lblPlaca = new JLabel("Placa");
        lblPlaca.setBounds(10, y, 150, 25);
        panelCadastro.add(lblPlaca);

        y += 20;
        JTextField txtPlaca = new JTextField();
        txtPlaca.setBounds(10, y, 150, 25);
        panelCadastro.add(txtPlaca);

        y += 30;
        JLabel lblValor = new JLabel("Valor");
        lblValor.setBounds(10, y, 150, 25);
        panelCadastro.add(lblValor);

        y += 20;
        JTextField txtValor = new JTextField();
        txtValor.setBounds(10, y, 150, 25);
        panelCadastro.add(txtValor);

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

        tabbedPane.addTab("Cadastro de Veículos", panelCadastro);

        btnSalvar.addActionListener(e -> {
            Veiculo veiculo = new Veiculo();
            VeiculoController veiculoController = new VeiculoController();
            veiculo.setNome(txtNome.getText());
            veiculo.setAno(Integer.parseInt(txtAno.getText()));
            veiculo.setModelo(txtModelo.getText());
            veiculo.setCategoria((Categoria) comboCategoria.getSelectedItem());
            veiculo.setCor(txtCor.getText());
            veiculo.setPlaca(txtPlaca.getText());
            veiculo.setValor(Double.parseDouble(txtValor.getText()));
            boolean resultado = veiculoController.salvar(veiculo);
            JOptionPane.showMessageDialog(btnSalvar,
                    resultado ? "Veículo salvo com sucesso!" : "Erro ao salvar veículo.",
                    resultado ? "Sucesso" : "Erro",
                    resultado ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        });

        btnAlterar.addActionListener(e -> {
            Veiculo veiculo = new Veiculo();
            VeiculoController veiculoController = new VeiculoController();
            veiculo.setId(Integer.parseInt(txtId.getText()));
            veiculo.setNome(txtNome.getText());
            veiculo.setAno(Integer.parseInt(txtAno.getText()));
            veiculo.setModelo(txtModelo.getText());
            veiculo.setCategoria((Categoria) comboCategoria.getSelectedItem());
            veiculo.setCor(txtCor.getText());
            veiculo.setPlaca(txtPlaca.getText());
            veiculo.setValor(Double.parseDouble(txtValor.getText()));
            boolean resultado = veiculoController.alterar(veiculo);
            JOptionPane.showMessageDialog(btnAlterar,
                    resultado ? "Veículo alterado com sucesso!" : "Erro ao alterar veículo.",
                    resultado ? "Sucesso" : "Erro",
                    resultado ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        });

        btnExcluir.addActionListener(e -> {
            String idText = txtId.getText();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(btnExcluir, "Por favor, informe o ID do veiculo a ser excluído.",
                        "ID obrigatório", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int confirmacao = JOptionPane.showConfirmDialog(btnExcluir,
                    "Tem certeza que deseja excluir o veiculo com ID " + idText + "?",
                    "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);

            if (confirmacao == JOptionPane.YES_OPTION) {
                Veiculo veiculo = new Veiculo();
                veiculo.setId(Integer.parseInt(idText));

                VeiculoController veiculoController = new VeiculoController();
                boolean resultado = veiculoController.excluir(veiculo);

                JOptionPane.showMessageDialog(btnExcluir,
                        resultado ? "Veiculo excluído com sucesso!" : "Erro ao excluir veiculo.",
                        resultado ? "Sucesso" : "Erro",
                        resultado ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
                if (resultado) {
                    txtId.setText("");
                    txtNome.setText("");
                    txtAno.setText("");
                    txtModelo.setText("");
                    comboCategoria.setSelectedIndex(0);
                    txtCor.setText("");
                    txtPlaca.setText("");
                    txtValor.setText("");
                }
            }
        });

        btnLimparCampos.addActionListener(e -> {
            txtId.setText("");
            txtNome.setText("");
            txtAno.setText("");
            txtModelo.setText("");
            comboCategoria.setSelectedIndex(0);
            txtCor.setText("");
            txtPlaca.setText("");
            txtValor.setText("");
        });

        JPanel panelTabela = new JPanel();
        panelTabela.setLayout(new BoxLayout(panelTabela, BoxLayout.Y_AXIS));

        String[] colunas = {"ID", "Nome", "Ano", "Modelo", "Categoria", "Cor", "Placa", "Valor"};
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modeloTabela);
        tabela.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(tabela);
        panelTabela.add(scrollPane);

        JButton btnRecarregar = new JButton("Atualizar consulta");
        panelTabela.add(btnRecarregar);

        btnRecarregar.addActionListener(e -> {
            modeloTabela.setRowCount(0);
            VeiculoController veiculoController = new VeiculoController();
            List<Veiculo> veiculos = veiculoController.buscarTodos();
            for (Veiculo v : veiculos) {
                modeloTabela.addRow(new Object[]{
                        v.getId(), v.getNome(), v.getAno(), v.getModelo(),
                        v.getCategoria(), v.getCor(), v.getPlaca(), v.getValor()
                });
            }
        });

        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int linha = tabela.getSelectedRow();
                    txtId.setText(tabela.getValueAt(linha, 0).toString());
                    txtNome.setText(tabela.getValueAt(linha, 1).toString());
                    txtAno.setText(tabela.getValueAt(linha, 2).toString());
                    txtModelo.setText(tabela.getValueAt(linha, 3).toString());
                    comboCategoria.setSelectedItem((Categoria) tabela.getValueAt(linha, 4));;
                    txtCor.setText(tabela.getValueAt(linha, 5).toString());
                    txtPlaca.setText(tabela.getValueAt(linha, 6).toString());
                    txtValor.setText(tabela.getValueAt(linha, 7).toString());
                    tabbedPane.setSelectedIndex(0);
                }
            }
        });
        tabbedPane.addTab("Lista de Veículos", panelTabela);

        tela.setVisible(true);
    }

    private static void preencherComboCategorias(JComboBox combo) {
        CategoriaController categoriaController = new CategoriaController();

        List<Categoria> categorias = categoriaController.buscarTodos();

        for(Categoria categoria : categorias) {
            combo.addItem(categoria);
        }
    }
}