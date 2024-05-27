import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class telaRegistro extends JFrame {
    private JLabel inicio;
    private JTextField userTextField;
    private JLabel userLabel;
    private JTextField senhaTextField;
    private JLabel passLabel;
    private JButton registrarButton;
    private JButton voltarButton;
    private JPanel registroPanel;
    private JLabel vazioBoxes;

    public telaRegistro(){

        setSize(700,400);
        setContentPane(registroPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new telaLogin();
                dispose();

            }
        });

        //botão de registrar
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(userTextField.getText().equals("") || senhaTextField.getText().equals("")){

                    vazioBoxes.setText("INSIRA CORRETAMENTE AS INFORMAÇÕES");

                }else {

                    //vai escrever as informações no arquivo e voltar a tela de login
                    try {
                        FileWriter escritor = new FileWriter("logins.txt",true);
                        escritor.write(userTextField.getText() + ";" + senhaTextField.getText() + "\n");
                        escritor.close();
                    } catch (IOException p) {
                        throw new RuntimeException(p);
                    }

                    new telaLogin();
                    dispose();

                }

            }
        });


}




    public static void main(String[] args) {

        telaRegistro ln = new telaRegistro();

    }

}
