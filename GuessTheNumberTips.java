import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class GuessTheNumberTips extends JFrame implements ActionListener {

    private static boolean isFirstClick = true;
    Color color = new Color(200,40,80);
     JPanel p1= new JPanel();
     JLabel tip1,tip2,tip3,tip4,mainLabel;
      JTextArea desctip1,desctip2,desctip3,desctip4;
     JButton Next,StartTheGame;

     public GuessTheNumberTips()
     {
        setTitle(" Guess The Number Tips");
        setSize(900,600);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocation(450,150);
       
        tip1 = new JLabel("1.Choose a Difficulty");
        tip2 = new JLabel("2.Input Your Guess");
        tip3 = new JLabel("3.Game Objective");
        tip4 = new JLabel("4.Feedback on Guess");
        mainLabel = new JLabel("Tips for Playing Guess The Number Game");
        desctip1 = new JTextArea("Select one of the difficulty levels - Easy, Medium, or Hard - to start the game.");
        desctip2 = new JTextArea("Enter your guess in the text field. The number will be between the specified range (1–10, 1–50, or 1–100).");
        desctip4 = new JTextArea("Your goal is to guess the secret number correctly before running out of tries."); 
        desctip3 = new JTextArea(" IF your guess is too high, you'll be told the number is smaller,If your guess is too low, you'll be told the number is larger.");
    
    
        desctip1.setEditable(false);
        desctip2.setEditable(false);
        desctip3.setEditable(false);
        desctip4.setEditable(false);
    
        Next = new JButton("Next");
        StartTheGame = new JButton("Start The Game");
    
        
        Font font1 = new Font("Georgia", 1,18);
        Font font2 = new Font("Trebuchet MS", 2,16);
        Font font3 = new Font("Courier New",3,20);
        Font font4 = new Font("Courier New",2,20);
    
        desctip1.setFont(font2);
        desctip2.setFont(font2);
        desctip3.setFont(font2);
        desctip4.setFont(font2);
    
        tip1.setFont(font1);
        tip2.setFont(font1);
        tip3.setFont(font1);
        tip4.setFont(font1);
    
        mainLabel.setFont(font3);
    
        mainLabel.setBounds(200,10,700,20);
        tip1.setBounds(20,50,700,20);
        desctip1.setBounds(2,80,900,40);
        tip2.setBounds(20,140,700,20);
        desctip2.setBounds(2,180,900,40);
        tip3.setBounds(20,240,700,20);
        desctip3.setBounds(2,280,900,40);
        tip4.setBounds(20,340,700,20);
        desctip4.setBounds(2,380,900,40);
    
        Next.setBackground(Color.LIGHT_GRAY);
        Next.setFont(font4);
        StartTheGame.setBackground(Color.LIGHT_GRAY);
        StartTheGame.setFont(font4);
        StartTheGame.setBounds(100,460,300,20);
        Next.setBounds(450,460,300,20);
    
        Next.addActionListener(this);
        StartTheGame.addActionListener(this);
    
        p1.setLayout(null);
        p1.setBackground(color);
        p1.add(mainLabel);
        p1.add(tip1);
        p1.add(tip2);
        p1.add(tip3);
        p1.add(tip4);
        p1.add(desctip1);
        p1.add(desctip2);
        p1.add(desctip3);
        p1.add(desctip4);
        p1.add(Next);
        p1.add(StartTheGame);
    
        add(p1,BorderLayout.CENTER);
        setVisible(true);
     }
     public void actionPerformed (ActionEvent e )
     {
         if(e.getSource()==Next && isFirstClick)
         {
          tip1.setText("5.Tries Left");
          tip2.setText("6.Correct Guess");
          tip3.setText("7.Points System");
          tip4.setText("8.Game Reset");
     
          desctip1.setText("You have a limited number of tries to guess the correct number. If you run out of tries, the game will end.");         
          desctip2.setText("If you guess the number correctly, you earn 10 points, and the game will reset for a new round. ");
          desctip3.setText("Your points are displayed at the bottom of the screen. Earn points by guessing correctly and keep track of your progress!");
          desctip4.setText("After each round, if you win or run out of tries, the game will reset, and you can play again.");
 
          Next.setText("Back");
          p1.setBackground(Color.lightGray);
          isFirstClick = false;
         }
         else if (e.getSource()== Next && !isFirstClick)
         {
             tip1.setText("1.Choose a Difficulty");
             tip2.setText("2.Input Your Guess");
             tip3.setText("3.Game Objective");
             tip4.setText("4.Feedback on Guess");
        
             desctip1.setText("Select one of the difficulty levels - Easy, Medium, or Hard - to start the game");
             desctip2.setText("Enter your guess in the text field. The number will be between the specified range (1–10, 1–50, or 1–100).");
             desctip3.setText("Your goal is to guess the secret number correctly before running out of tries.");
             desctip4.setText("If your guess is too high, you'll be told the number is smaller,If your guess is too low, you'll be told the number is larger.");
                                 
        
             Next.setText("Next");
             p1.setBackground(color);
             isFirstClick = true;
     
         }
         else if (e.getSource()==StartTheGame)
         {
             new GuessTheNumberGame();
             dispose();
         }
     }
    
}
