import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class telaVerProduto extends JFrame {
    private JPanel verProdutoPanel;
    private JLabel seusProdutosLabel;
    private JTable tabelaProdutos;
    private JButton voltarButton;

    public telaVerProduto(){

        setSize(700, 400);
        setContentPane(verProdutoPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        DefaultTableModel tblModel = (DefaultTableModel) tabelaProdutos.getModel();
        tblModel.addColumn("Nome do Produto");
        tblModel.addColumn("Quantidade");
        tblModel.addColumn("Preço UN");
        tblModel.addColumn("Descrição / Observação");

        try {
            BufferedReader leitor =
                    new BufferedReader(new FileReader("produtos.txt"));
            String linha;
            do {
                linha = leitor.readLine();
                if(linha!= null)
                {

                    String[] separador = linha.split(";");
                    tblModel.addRow(separador);

                }
            }while(linha != null);
            leitor.close();
        } catch (Exception e) {

        }

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new telaPrincipal();
                dispose();

            }
        });

    }

    public static void main(String[] args) {

        telaVerProduto ln = new telaVerProduto();

    }

}
