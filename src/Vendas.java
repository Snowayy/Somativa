import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

                        int desposable = Integer.parseInt(separador[1]);
                        try {
                            FileWriter escritor = new FileWriter("produtos.txt",true);
                            escritor.write(desposable);//corrigir isso
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
