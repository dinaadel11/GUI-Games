import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class rockPaperScissors extends JFrame implements ActionListener {
    ImageIcon[] images = new ImageIcon[3];
    JLabel jlabels = new JLabel();
    JButton[] jButtons = new JButton[3];
    JLabel jlab = new JLabel("Choose one");
    Color color1 = new Color(0x638C6D);
    Color color2 = new Color(0x7E99A3);
    Color color3 = new Color(0xFF4545);
    JPanel panel = new JPanel();
    public rockPaperScissors(){
        JFrame frame = new JFrame();
        frame.setTitle("Rock_Paper_Scissors");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
       
        frame.setResizable(false);
        panel.setLayout(null);
        panel.setBackground(color1);

        images[0] = new ImageIcon("Rock__1_-removebg-preview.png");
        images[1] = new ImageIcon("Paper__1_-removebg-preview.png");
        images[2] = new ImageIcon("Scissor (1).png");

        images[0].getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        images[1].getImage().getScaledInstance(133, 100, Image.SCALE_SMOOTH);
        images[2].getImage().getScaledInstance(133, 100, Image.SCALE_SMOOTH);

        jButtons[0] = new JButton(images[0]);
        jButtons[1] = new JButton(images[1]);
        jButtons[2] = new JButton(images[2]);

        jlab.setBounds(170, 20, 150, 50);
        jlab.setFont(new Font("Arial", Font.BOLD, 25));
        jButtons[0].setBounds(50, 80, 133, 100);
        jButtons[1].setBounds(183, 80, 133, 100);
        jButtons[2].setBounds(316, 80, 133, 100);
        jButtons[0].setBackground(color1);
        jButtons[1].setBackground(color1);
        jButtons[2].setBackground(color1);
        jlabels.setBounds(50, 200, 133, 100);
        panel.setBounds(0, 0, 500, 500);

        panel.add(jlab);
        panel.add(jButtons[0]);
        panel.add(jButtons[1]);
        panel.add(jButtons[2]);
        panel.add(jlabels);
        frame.add(panel);

        jButtons[0].addActionListener(this);
        jButtons[1].addActionListener(this);
        jButtons[2].addActionListener(this);
        frame.setVisible(true);

    }
    private ImageIcon ChoiceRandomShape(ImageIcon[] images){
        Random random = new Random();
        ImageIcon image = images[random.nextInt(images.length)];
        return image;
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < jButtons.length; i++){
            if(e.getSource() == jButtons[i]) {
                jlabels.setIcon(ChoiceRandomShape(images));
                if(jlabels.getIcon() == images[i]){
                    JOptionPane.showMessageDialog(this, "it's a draw!");
                    jlabels.setIcon(null);
                    return;
                } else if (jButtons[i].getIcon() == images[0] && jlabels.getIcon() == images[1]) {
                    panel.setBackground(color3);
                    jButtons[0].setBackground(color3);
                    jButtons[1].setBackground(color3);
                    jButtons[2].setBackground(color3);
                    JOptionPane.showMessageDialog(this, "Computer wins!");
                    jlabels.setIcon(null);
                    panel.setBackground(color1);
                    jButtons[0].setBackground(color1);
                    jButtons[1].setBackground(color1);
                    jButtons[2].setBackground(color1);
                    return;
                } else if (jButtons[i].getIcon() == images[0] && jlabels.getIcon() == images[2]) {
                    panel.setBackground(color2);
                    jButtons[0].setBackground(color2);
                    jButtons[1].setBackground(color2);
                    jButtons[2].setBackground(color2);
                    JOptionPane.showMessageDialog(this, "Congratulations! You win!");
                    jlabels.setIcon(null);
                    panel.setBackground(color1);
                    jButtons[0].setBackground(color1);
                    jButtons[1].setBackground(color1);
                    jButtons[2].setBackground(color1);
                    return;
                }
                else if (jButtons[i].getIcon() == images[1] && jlabels.getIcon() == images[0]) {
                    panel.setBackground(color2);
                    jButtons[0].setBackground(color2);
                    jButtons[1].setBackground(color2);
                    jButtons[2].setBackground(color2);
                    JOptionPane.showMessageDialog(this, "Congratulations! You win!");
                    jlabels.setIcon(null);
                    panel.setBackground(color1);
                    jButtons[0].setBackground(color1);
                    jButtons[1].setBackground(color1);
                    jButtons[2].setBackground(color1);
                    return;
                } else if (jButtons[i].getIcon() == images[1] && jlabels.getIcon() == images[2]) {
                    panel.setBackground(color3);
                    jButtons[0].setBackground(color3);
                    jButtons[1].setBackground(color3);
                    jButtons[2].setBackground(color3);
                    JOptionPane.showMessageDialog(this, "Computer wins!");
                    jlabels.setIcon(null);
                    panel.setBackground(color1);
                    jButtons[0].setBackground(color1);
                    jButtons[1].setBackground(color1);
                    jButtons[2].setBackground(color1);
                    return;
                }else if (jButtons[i].getIcon() == images[2] && jlabels.getIcon() == images[0]) {
                    panel.setBackground(color3);
                    jButtons[0].setBackground(color3);
                    jButtons[1].setBackground(color3);
                    jButtons[2].setBackground(color3);
                    JOptionPane.showMessageDialog(this, "Computer wins!");
                    jlabels.setIcon(null);
                    panel.setBackground(color1);
                    jButtons[0].setBackground(color1);
                    jButtons[1].setBackground(color1);
                    jButtons[2].setBackground(color1);
                    return;
                } else if (jButtons[i].getIcon() == images[2] && jlabels.getIcon() == images[1]) {
                    panel.setBackground(color2);
                    jButtons[0].setBackground(color2);
                    jButtons[1].setBackground(color2);
                    jButtons[2].setBackground(color2);
                    JOptionPane.showMessageDialog(this, "Congratulations! You win!");
                    jlabels.setIcon(null);
                    panel.setBackground(color1);
                    jButtons[0].setBackground(color1);
                    jButtons[1].setBackground(color1);
                    jButtons[2].setBackground(color1);
                    return;
                }
            }
        }

    }
}
