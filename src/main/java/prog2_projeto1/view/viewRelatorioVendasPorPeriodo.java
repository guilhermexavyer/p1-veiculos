package prog2_projeto1.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import prog2_projeto1.controller.VendaVeiculoController;
import prog2_projeto1.model.VendaVeiculo;

public class viewRelatorioVendasPorPeriodo {

    public static void main(String[] args) {
        JFrame tela = new JFrame("Relatório de Vendas");
        tela.setSize(1024, 768);
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        tela.add(panel);

        JLabel lblDataInicio = new JLabel("Data Início (dd/MM/aaaa):");
        lblDataInicio.setBounds(10, 10, 200, 25);
        panel.add(lblDataInicio);

        JTextField txtDataInicio = new JTextField();
        txtDataInicio.setBounds(220, 10, 150, 25);
        panel.add(txtDataInicio);

        JLabel lblDataFim = new JLabel("Data Fim (dd/MM/aaaa):");
        lblDataFim.setBounds(10, 40, 200, 25);
        panel.add(lblDataFim);

        JTextField txtDataFim = new JTextField();
        txtDataFim.setBounds(220, 40, 150, 25);
        panel.add(txtDataFim);

        JButton btnGerar = new JButton("Gerar Relatório");
        btnGerar.setBounds(10, 70, 150, 25);
        panel.add(btnGerar);

        String[] colunas = {"ID", "Data Venda", "Valor Desconto", "Valor Final", "Cliente", "Vendedor", "Veiculo"};
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modeloTabela);
        tabela.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(10, 110, 1000, 600);
        panel.add(scrollPane);

        btnGerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    java.util.Date dataInicioUtil = sdf.parse(txtDataInicio.getText());
                    java.util.Date dataFimUtil = sdf.parse(txtDataFim.getText());

                    java.sql.Date dataInicioSql = new java.sql.Date(dataInicioUtil.getTime());
                    java.sql.Date dataFimSql = new java.sql.Date(dataFimUtil.getTime());

                    VendaVeiculoController controller = new VendaVeiculoController();
                    List<VendaVeiculo> vendas = controller.buscarPorPeriodo(dataInicioSql, dataFimSql);

                    modeloTabela.setRowCount(0);
                    for (VendaVeiculo v : vendas) {
                        String dataVenda = v.getData_venda() != null
                                ? sdf.format(java.sql.Date.valueOf(v.getData_venda()))
                                : "";
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
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(tela, "Formato de data inválido. Use dd/MM/aaaa.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        tela.setVisible(true);
    }
}