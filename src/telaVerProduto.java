import javax.swing.*;

public class telaVerProduto extends JFrame {
    private JPanel verProdutoPanel;

    public telaVerProduto(){

        setSize(700, 400);
        setContentPane(verProdutoPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {

        telaVerProduto ln = new telaVerProduto();

    }

}
