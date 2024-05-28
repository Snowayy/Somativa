import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

public class Vendas extends JFrame {
    private JPanel vendasPanel;
    private JLabel inicioLabel;
    private JTextField clienteTextField;
    private JTextField cpfTextField;
    private JTextField produtoTextField;
    private JLabel clienteLabel;
    private JLabel cpfLabel;
    private JLabel produtoLabel;
    private JLabel labelErro;
    private JButton confirmarVendaButton;

    public boolean verificarProduto(){

        try {
            BufferedReader leitor =
                    new BufferedReader(new FileReader("produtos.txt"));
            String linha;
            do {
                linha = leitor.readLine();
                if(linha!= null)
                {

                    String[] separador = linha.split(";");

                    if(separador[0].equals(produtoTextField.getText())){

                        Integer desposable = Integer.parseInt(separador[1]) - 1;
                        try {
                            FileWriter escritor = new FileWriter("produtos.txt",true);
                            //escritor.write(desposable.toString());
                            linha = separador[1].replace(separador[1], desposable.toString());
                            escritor.write(linha);
                            escritor.close();
                        } catch (IOException p) {
                            throw new RuntimeException(p);
                        }

                        return true;

                    }

                }
            }while(linha != null);
            leitor.close();
        } catch (Exception e) {

        }

        return false;

    }

    public Vendas(){

        setSize(700, 400);
        setContentPane(vendasPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        confirmarVendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(clienteTextField.getText().isBlank() || cpfTextField.getText().isBlank()
                || produtoTextField.getText().isBlank()){

                    labelErro.setText("PREENCHA TUDO");

                }else if(verificarProduto()){

                    clienteTextField.setText("");
                    cpfTextField.setText("");
                    produtoTextField.setText("");

                }else {

                    labelErro.setText("PRODUTO INEXISTENTE");

                }

            }
        });

    }

    public static void main(String[] args) {

        Vendas ln = new Vendas();

    }
}
