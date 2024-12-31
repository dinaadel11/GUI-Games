import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class XOGame extends JFrame implements ActionListener{
    JButton[] jButtons = new JButton[9];
    public XOGame(){
        JFrame frame = new JFrame();
        frame.setTitle("X, O Game");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(new GridLayout(3, 3, 5, 5));

        for(int i = 0; i < jButtons.length; i++){
            jButtons[i] = new JButton();
            jButtons[i].setBackground(Color.BLUE);
            jButtons[i].setFont(new Font("Arial", Font.BOLD, 100));
            jButtons[i].addActionListener(this);
            frame.add(jButtons[i]);
        }

    }

    public JButton choiceRandomButton(JButton[] jButtons){
        ArrayList<JButton> emptyButtons = new ArrayList<>();
        Random random = new Random();
        JButton randomButton = new JButton();
        int randomIndex;
        for(int i = 0; i < jButtons.length; i++){
            if(jButtons[i].getText() == ""){
                emptyButtons.add(jButtons[i]);
            }
        }
        if(!emptyButtons.isEmpty()){
            randomIndex = random.nextInt(emptyButtons.size());
            randomButton = emptyButtons.get(randomIndex);
        }
        return randomButton;
    }

  

    private void resetGame(){
        for(JButton button : jButtons){
            button.setText("");
            button.setBackground(Color.BLUE);
        }
    }

    private boolean isBoardFull(){
        for(JButton button : jButtons){
            if(button.getText().isEmpty()){
                return false;
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int [][] winCombinnations = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };
        for(int i = 0; i < jButtons.length; i++){
            if(jButtons[i].getText() == "") {
                if(e.getSource() == jButtons[i]){
                jButtons[i].setText("X");
                choiceRandomButton(jButtons).setText("O");
                }
            }
            for(int[] combination : winCombinnations){
                if(jButtons[combination[0]].getText().equals("X") && jButtons[combination[1]].getText().equals("X") && jButtons[combination[2]].getText().equals("X")){
                    jButtons[combination[0]].setBackground(Color.GREEN);
                    jButtons[combination[1]].setBackground(Color.GREEN);
                    jButtons[combination[2]].setBackground(Color.GREEN);
                    JOptionPane.showMessageDialog(this, "Congratulations! You win!");
                    resetGame();
                    return;
                }
                else if(jButtons[combination[0]].getText().equals("O") && jButtons[combination[1]].getText().equals("O") && jButtons[combination[2]].getText().equals("O")){
                    jButtons[combination[0]].setBackground(Color.red);
                    jButtons[combination[1]].setBackground(Color.red);
                    jButtons[combination[2]].setBackground(Color.red);
                    JOptionPane.showMessageDialog(this, "Computer wins!");
                    resetGame();
                    return;
                }

            }

            }
        if(isBoardFull()){
            JOptionPane.showMessageDialog(this, "It's a draw!");
            resetGame();
            return;
        }
    }

}