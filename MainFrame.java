
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    JPanel p1 =  new JPanel();
    JPanel p2 =  new JPanel();
    JButton memoryPuzzleButton, mathQuizButton, xoGameButton, rpsGameButton,guessNumber;
    ImageIcon originalIcon = new ImageIcon("photo_2024-12-30_01-22-09.jpg");
   Image image = originalIcon.getImage();
   Image resizedImage = image.getScaledInstance(700, 400, Image.SCALE_SMOOTH);
   ImageIcon resizedIcon = new ImageIcon(resizedImage);
    public MainFrame() {

        setTitle("Game Launcher");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new  BorderLayout()); 
        setResizable(false);
        setLocation(370,180);

       p1.setLayout(new BorderLayout());
       JLabel label= new JLabel();
       label.setIcon(resizedIcon);
       p1.add(label,BorderLayout.CENTER);
       add(p1,BorderLayout.CENTER);
       add(p2,BorderLayout.SOUTH);
       
        memoryPuzzleButton = new JButton("Memory Puzzle");
         mathQuizButton = new JButton("Math Quiz");
         xoGameButton = new JButton("Tic Tac Toe");
         rpsGameButton = new JButton("Rock Paper Scissors");
         guessNumber= new JButton("Guesses Games");
        
         Color color2 = new Color(0x7E99A3);
         memoryPuzzleButton.setBackground(color2);
         mathQuizButton.setBackground(color2);
         xoGameButton.setBackground(color2);
         rpsGameButton.setBackground(color2);
         guessNumber.setBackground(color2);

         p2.setLayout(new FlowLayout());
         p2.add(memoryPuzzleButton);
         p2.add(mathQuizButton);
         p2.add(xoGameButton);
         p2.add(rpsGameButton);
         p2.add(guessNumber);

        memoryPuzzleButton.addActionListener(this);
        mathQuizButton.addActionListener(this);
        xoGameButton.addActionListener(this);
        rpsGameButton.addActionListener(this);
        guessNumber.addActionListener(this);

    setVisible(true);
    }
    
  
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == memoryPuzzleButton) {
            new MemoryPuzzleTips(); 
        } else if (e.getSource() == mathQuizButton) {
            new MathQuizTips(); 
        } else if (e.getSource() == xoGameButton) {
            new XOTips(); 
        } else if (e.getSource() == rpsGameButton) {
            new rockPaperScissorsTips();
             
        }
        else if (e.getSource()== guessNumber)
        {
            new GuessesGames();
        }
    }

        public static void main(String[] args) {
            new MainFrame();
        }
   
    }

