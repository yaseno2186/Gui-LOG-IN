import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Main extends JFrame {
    private JTextField name;
    private JPasswordField pass;
    private JLabel msg;
    private boolean error;
    public Main() {
        super("Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,1,0,0));
        panel.setBorder(new EmptyBorder(10,10,0,10));
        msg = new JLabel();
        panel.add(msg);
        panel.add(new JLabel("Name"));
        name = new JTextField(20);
        name.setHorizontalAlignment(JTextField.CENTER);
        panel.add(name);
        panel.add(new JLabel("Password"));
        pass= new JPasswordField(8);
        pass.setHorizontalAlignment(JTextField.CENTER);
        panel.add(pass);

        JPanel panel1 = new JPanel();
        panel1.setBorder(new EmptyBorder(10,10,10,10));
        JButton enter = new JButton("Enter");
        JButton exit = new JButton("Exit");
        panel1.add(enter);
        panel1.add(exit);

        //Coloring


        //Implementing the Panels in JFrame
        add(panel, BorderLayout.NORTH);
        add(panel1, BorderLayout.SOUTH);

        //Conditions for name
        name.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String s = ((JTextField) input).getText();

                if(s.isEmpty() || s.contains("[^\\\\sa-zA-Z0-9]")){
                    msg.setText("Name is wrong");
                    error = true;
                    return false;
                }
                msg.setText("");
                error= false;
                return true;
            }
        });
        //Conditions for password
        pass.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String s = ((JTextField) input).getText();

                if(s.isEmpty() || s.contains("[^\\\\sa-zA-Z0-9]")){
                    msg.setText("password is wrong");
                    error = true;
                    return false;
                }
                msg.setText("");
                error= false;
                return true;
            }
        });
        // Enter button
        enter.addActionListener(e -> {
            if(!error) {
                msg.setText("Logged Successfully !");
            }
        });

        //Exit Button
        exit.addActionListener(e -> {
            System.exit(0);
        });


        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
       new Main();}
}