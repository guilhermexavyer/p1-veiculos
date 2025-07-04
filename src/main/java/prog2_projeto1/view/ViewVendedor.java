package prog2_projeto1.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import prog2_projeto1.controller.VendedorController;
import prog2_projeto1.model.Vendedor;

public class ViewVendedor {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Vendedores");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        frame.add(tabbedPane);

        // Aba Cadastro
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

        JLabel lblSalario = new JLabel("Salário");
        lblSalario.setBounds(10, 160, 150, 25);
        panelCadastro.add(lblSalario);

        JTextField txtSalario = new JTextField();
        txtSalario.setBounds(10, 180, 200, 25);
        panelCadastro.add(txtSalario);

        JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setBounds(10, 210, 150, 25);
        panelCadastro.add(lblTelefone);

        JTextField txtTelefone = new JTextField();
        txtTelefone.setBounds(10, 230, 200, 25);
        panelCadastro.add(txtTelefone);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, 280, 100, 25);
        panelCadastro.add(btnSalvar);

        JButton btnAlterar = new JButton("Alterar");
        btnAlterar.setBounds(120, 280, 100, 25);
        panelCadastro.add(btnAlterar);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(230, 280, 100, 25);
        panelCadastro.add(btnExcluir);

        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(340, 280, 100, 25);
        panelCadastro.add(btnLimpar);

        tabbedPane.addTab("Cadastro", panelCadastro);

        // Eventos
        VendedorController controller = new VendedorController();

        btnSalvar.addActionListener(e -> {
            Vendedor v = new Vendedor();
            v.setNome(txtNome.getText());
            v.setCpf(txtCpf.getText());
            v.setSalario(txtSalario.getText());
            v.setTelefone(txtTelefone.getText());

            boolean resultado = controller.salvar(v);
            JOptionPane.showMessageDialog(frame, resultado ? "Salvo com sucesso" : "Erro ao salvar");
        });

        btnAlterar.addActionListener(e -> {
            Vendedor v = new Vendedor();
            v.setId(Integer.parseInt(txtId.getText()));
            v.setNome(txtNome.getText());
            v.setCpf(txtCpf.getText());
            v.setSalario(txtSalario.getText());
            v.setTelefone(txtTelefone.getText());

            boolean resultado = controller.alterar(v);
            JOptionPane.showMessageDialog(frame, resultado ? "Alterado com sucesso" : "Erro ao alterar");
        });

        btnExcluir.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(frame, "Deseja excluir?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                Vendedor v = new Vendedor();
                v.setId(Integer.parseInt(txtId.getText()));
                boolean resultado = controller.excluir(v);
                JOptionPane.showMessageDialog(frame, resultado ? "Excluído com sucesso" : "Erro ao excluir");
            }
        });

        btnLimpar.addActionListener(e -> {
            txtId.setText("");
            txtNome.setText("");
            txtCpf.setText("");
            txtSalario.setText("");
            txtTelefone.setText("");
        });

        // Aba Lista
        JPanel panelTabela = new JPanel();
        String[] colunas = { "ID", "Nome", "CPF", "Salário", "Telefone" };
        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(model);
        JScrollPane scroll = new JScrollPane(tabela);
        panelTabela.add(scroll);
        tabbedPane.addTab("Lista de Vendedores", panelTabela);

        tabbedPane.addChangeListener(e -> {
            if (tabbedPane.getSelectedIndex() == 1) {
                model.setRowCount(0);
                for (Vendedor v : controller.buscarTodos()) {
                    model.addRow(new Object[] {
                        v.getId(), v.getNome(), v.getCpf(), v.getSalario(), v.getTelefone()
                    });
                }
            }
        });

        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int linha = tabela.getSelectedRow();
                    txtId.setText(tabela.getValueAt(linha, 0).toString());
                    txtNome.setText(tabela.getValueAt(linha, 1).toString());
                    txtCpf.setText(tabela.getValueAt(linha, 2).toString());
                    txtSalario.setText(tabela.getValueAt(linha, 3).toString());
                    txtTelefone.setText(tabela.getValueAt(linha, 4).toString());
                    tabbedPane.setSelectedIndex(0);
                }
            }
        });

        frame.setVisible(true);
    }
}