import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class telaAdicionarProduto extends JFrame {
    private JPanel adicionarProdutoPanel;
    private JLabel inicioLabel;
    private JTextField nomeProdutoTextField;
    private JTextField quantidadeTextField;
    private JTextField precoTextField;
    private JTextField descTextField;
    private JLabel nomeProdutoLabel;
    private JLabel quantidadeLabel;
    private JLabel preçoUnidadeLabel;
    private JLabel descLabel;
    private JButton addButton;
    private JLabel corrgirCampos;
    private JButton voltarButton;

    public void escreverProdutos(){

        try {
            FileWriter escritor = new FileWriter("produtos.txt",true);
            escritor.write(nomeProdutoTextField.getText() + ";" +
                    quantidadeTextField.getText() + ";" +
                    precoTextField.getText() + ";" +
                    descTextField.getText() + "\n");
            escritor.close();
        } catch (IOException p) {
            throw new RuntimeException(p);
        }

    }

    public void zerarTextos() {

        nomeProdutoTextField.setText("");
        quantidadeTextField.setText("");
        precoTextField.setText("");
        descTextField.setText("");

    }

    public telaAdicionarProduto(){

        setSize(700, 400);
        setContentPane(adicionarProdutoPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(nomeProdutoTextField.getText().isEmpty() || quantidadeTextField.getText().isEmpty()
                || precoTextField.getText().isEmpty() || descTextField.getText().isEmpty()){

                    corrgirCampos.setText("PREENCHA TODOS OS CAMPOS");

                }else {

                    escreverProdutos();
                    zerarTextos();

                }

            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new telaPrincipal();
                dispose();;

            }
        });

    }

    public static void main(String[] args) {

        telaAdicionarProduto ln = new telaAdicionarProduto();

    }

}
