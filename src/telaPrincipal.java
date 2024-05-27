import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class telaPrincipal extends JFrame {
    private JPanel telaPrincipalPainel;
    private JLabel bemVindoLabel;
    private JButton addProdutoButton;
    private JButton verProdutoButton;

    public telaPrincipal(){

        setSize(700, 400);
        setContentPane(telaPrincipalPainel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        addProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new telaAdicionarProduto();
                dispose();

            }
        });

        verProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new telaVerProduto();
                dispose();

            }
        });

    }

    public static void main(String[] args) {

        telaPrincipal ln = new telaPrincipal();

    }

}
