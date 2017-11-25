import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private int G = 8;

    private Generator generator = new Generator();

    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();

    private ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton btn8bit = new JRadioButton("8", true);
    private JRadioButton btn16bit = new JRadioButton("16", false);
    private JRadioButton btn32bit = new JRadioButton("32", false);

    private JLabel jLabel1 = new JLabel("Длина пароля");
    private JLabel jLabel2 = new JLabel("символа(ов)");
    private JTextField jTextField = new JTextField();

    private JButton btnGenerate = new JButton("Сгенерировать");

    public void createGUI() {
        JFrame jFrame = new JFrame("Генератор Паролей");
        jFrame.setSize(300, 200);
        jFrame.setResizable(false);

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        jFrame.getContentPane().add(panel1);

        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        panel1.add(panel2);

        panel1.add(Box.createVerticalGlue(), 0);

        ActionListener rBtnListener = new rBtnActionListener();
        buttonGroup.add(btn8bit);
        btn8bit.addActionListener(rBtnListener);
        buttonGroup.add(btn16bit);
        btn16bit.addActionListener(rBtnListener);
        buttonGroup.add(btn32bit);
        btn32bit.addActionListener(rBtnListener);

        panel2.add(jLabel1);
        panel2.add(btn8bit);
        panel2.add(btn16bit);
        panel2.add(btn32bit);
        panel2.add(jLabel2);

        panel1.add(Box.createVerticalGlue());

        jTextField.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        jTextField.setHorizontalAlignment(JTextField.CENTER);
        panel1.add(jTextField);

        panel1.add(Box.createVerticalGlue());

        ActionListener btnListener = new btnActionListener();
        btnGenerate.addActionListener(btnListener);
        btnGenerate.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel1.add(btnGenerate);

        panel1.add(Box.createVerticalGlue());

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    private class btnActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            jTextField.setText(generator.ramndom(G));
        }
    }

    private class rBtnActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (btn8bit.isSelected()) {
                G = 8;
            } else if (btn16bit.isSelected()) {
                G = 16;
            } else if (btn32bit.isSelected()) {
                G = 32;
            }
        }
    }
}
