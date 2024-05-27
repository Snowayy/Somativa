import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class telaLogin extends JFrame {


    private JLabel inicio;
    private JLabel UserLabel;
    private JTextField userTextField;
    private JLabel passLabel;
    private JTextField passTextField;
    private JButton LoginButton;
    private JButton RegisterButton;
    private JButton FecharButton;
    private JPanel loginPanel;
    private JLabel caixaErrada;

    public boolean verificarUser(){

        //leitor para ver se tem user
        try {
            BufferedReader leitor =
                    new BufferedReader(new FileReader("logins.txt"));
            String linha;
            do {
                linha = leitor.readLine();
                if(linha!= null)
                {
                    String[] u = linha.split(";");
                    if(u[0].equals(userTextField.getText()) && u[1].equals(passTextField.getText())){

                        return true;

                    }
                }
            }while(linha != null);
            leitor.close();
        } catch (Exception e) {

        }
        return false;
    }



    public telaLogin() {

        setSize(700, 400);
        setContentPane(loginPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(userTextField.getText().equals("") || passTextField.getText().equals("")){

                    caixaErrada.setText("PREENCHA OS CAMPOS");

                }else if(verificarUser() == false){

                    caixaErrada.setText("USUÁRIO OU SENHA INCORRETO");

                }else if(verificarUser()){

                    new telaPrincipal();
                    dispose();

                }

            }
        });

        FecharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();

            }
        });

        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new telaRegistro();
                dispose();

            }
        });

    }

    public static void main(String[] args) {

        telaLogin ln = new telaLogin();

    }

}
