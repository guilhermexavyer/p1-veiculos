package prog2_projeto1.view;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import prog2_projeto1.controller.CategoriaController;
import prog2_projeto1.model.Categoria;

public class viewCategoria {

    public static void main(String[] args) {
        JFrame tela = new JFrame("Categorias");
        tela.setSize(1024, 768);
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tela.add(tabbedPane);

        JPanel panelCadastro = new JPanel();

        panelCadastro.setLayout(null);

        JLabel lblId = new JLabel("ID");
        lblId.setBounds(10, 10, 250, 25);
        panelCadastro.add(lblId);

        JTextField txtId = new JTextField();
        txtId.setBounds(10, 30, 150, 25);
        txtId.setEditable(false);
        panelCadastro.add(txtId);

        JLabel lblDescricao = new JLabel("Descrição");
        lblDescricao.setBounds(10, 50, 150, 25);
        panelCadastro.add(lblDescricao);

        JTextField txtDescricao = new JTextField();
        txtDescricao.setBounds(10, 70, 150, 25);
        panelCadastro.add(txtDescricao);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, 280, 150, 25);
        panelCadastro.add(btnSalvar);

        JButton btnAlterar = new JButton("Alterar");
        btnAlterar.setBounds(170, 280, 150, 25);
        panelCadastro.add(btnAlterar);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(330, 280, 150, 25);
        panelCadastro.add(btnExcluir);

        JButton btnLimparCampos = new JButton("Limpar Campos");
        btnLimparCampos.setBounds(490, 280, 150, 25);
        panelCadastro.add(btnLimparCampos);

        tabbedPane.addTab("Cadastro de Categorias", panelCadastro);

        btnSalvar.addActionListener(e -> {
            Categoria categoria = new Categoria();
            CategoriaController categoriaController = new CategoriaController();
            categoria.setDescricao(txtDescricao.getText());
            boolean resultado = categoriaController.salvar(categoria);
            JOptionPane.showMessageDialog(btnSalvar,
                    resultado ? "Categoria salva com sucesso!" : "Erro ao salvar categoria.",
                    resultado ? "Sucesso" : "Erro",
                    resultado ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        });

        btnAlterar.addActionListener(e -> {
            Categoria categoria = new Categoria();
            CategoriaController categoriaController = new CategoriaController();
            categoria.setId(Integer.parseInt(txtId.getText()));
            categoria.setDescricao(txtDescricao.getText());
            boolean resultado = categoriaController.alterar(categoria);
            JOptionPane.showMessageDialog(btnAlterar,
                    resultado ? "Categoria alterada com sucesso!" : "Erro ao alterar categoria.",
                    resultado ? "Sucesso" : "Erro",
                    resultado ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        });

        btnExcluir.addActionListener(e -> {
            String idText = txtId.getText();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(btnExcluir, "Informe o ID da categoria para excluir.",
                        "ID obrigatório", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int confirmacao = JOptionPane.showConfirmDialog(btnExcluir,
                    "Excluir categoria com ID " + idText + "?",
                    "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);

            if (confirmacao == JOptionPane.YES_OPTION) {
                Categoria categoria = new Categoria();
                categoria.setId(Integer.parseInt(idText));
                CategoriaController categoriaController = new CategoriaController();
                boolean resultado = categoriaController.excluir(categoria);

                JOptionPane.showMessageDialog(btnExcluir,
                        resultado ? "Categoria excluída com sucesso!" : "Erro ao excluir categoria.",
                        resultado ? "Sucesso" : "Erro",
                        resultado ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
                if (resultado) {
                    txtId.setText("");
                    txtDescricao.setText("");
                }
            }
        });

        btnLimparCampos.addActionListener(e -> {
            txtId.setText("");
            txtDescricao.setText("");
        });

        JPanel panelTabela = new JPanel();
        panelTabela.setLayout(new BoxLayout(panelTabela, BoxLayout.Y_AXIS));

        String[] colunas = {"ID", "Descricao"};
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modeloTabela);
        tabela.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(tabela);
        panelTabela.add(scrollPane);

        JButton btnRecarregar = new JButton("Atualizar consulta");
        panelTabela.add(btnRecarregar);

        btnRecarregar.addActionListener(e -> {
            modeloTabela.setRowCount(0);
            CategoriaController categoriaController = new CategoriaController();
            List<Categoria> categorias = categoriaController.buscarTodos();
            for (Categoria v : categorias) {
                modeloTabela.addRow(new Object[]{v.getId(), v.getDescricao()});
            }
        });

        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int linha = tabela.getSelectedRow();
                    txtId.setText(tabela.getValueAt(linha, 0).toString());
                    txtDescricao.setText(tabela.getValueAt(linha, 1).toString());
                    tabbedPane.setSelectedIndex(0);
                }
            }
        });

        tabbedPane.addTab("Lista de Categorias", panelTabela);

        tela.setVisible(true);
    }
}
