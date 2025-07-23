package prog2_projeto1.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class ViewPrincipal extends JFrame {
    
    public ViewPrincipal(){

    setTitle("Software - Venda de veículos");
    setSize(1024, 768);
    setExtendedState(MAXIMIZED_BOTH);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    JMenuBar menuBar = new JMenuBar();

    JMenu menuCadastro = new JMenu("Cadastros");
    JMenu menuVendas = new JMenu("Venda");
    JMenu menuRelatorios = new JMenu("Relatórios");

    JMenuItem itemCliente = new JMenuItem("Cliente");
    JMenuItem itemCategoria = new JMenuItem("Categorias");
    JMenuItem itemVeiculo = new JMenuItem("Veículos");
    JMenuItem itemVendedor = new JMenuItem("Vendedor");
    JMenuItem itemVendaVeiculo = new JMenuItem("Venda");
    JMenuItem itemRelatorioVendas = new JMenuItem("Relatório de Vendas");

    
    menuCadastro.add(itemCategoria);
    menuCadastro.add(itemCliente);
    menuCadastro.add(itemVeiculo);
    menuCadastro.add(itemVendedor);

    menuVendas.add(itemVendaVeiculo);

    menuRelatorios.add(itemRelatorioVendas);

    menuBar.add(menuCadastro);
    menuBar.add(menuVendas);
    menuBar.add(menuRelatorios);

    setJMenuBar(menuBar);

    

    itemCategoria.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            ViewCategoria.main(null);
        }
    });

    itemCliente.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            ViewCliente.main(null);
        }
    });

    itemVeiculo.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
            ViewVeiculo.main(null);
        }
    });

    itemVendedor.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            ViewVendedor.main(null);
        }
    });

    itemVendaVeiculo.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            ViewVendaVeiculo.main(null);
        }
    });
    itemRelatorioVendas.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        viewRelatorioVendasPorPeriodo.main(null);
    }
});
}
public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
            new ViewPrincipal().setVisible(true);
    });

}
}