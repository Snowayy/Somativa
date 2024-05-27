import javax.swing.*;

public class telaAdicionarProduto extends JFrame {
    private JPanel adicionarProdutoPanel;

    public telaAdicionarProduto(){

        setSize(700, 400);
        setContentPane(adicionarProdutoPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {

        telaAdicionarProduto ln = new telaAdicionarProduto();

    }

}
