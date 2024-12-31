import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class XOTips extends JFrame implements ActionListener {
    private static boolean isFirstClick = true;
    Color color = new Color(65, 105, 225);
     JPanel p1= new JPanel();
     JLabel tip1,tip2,tip3,tip4,mainLabel;
      JTextArea desctip1,desctip2,desctip3,desctip4;
     JButton Next,StartTheGame;

     public XOTips()
     {
        setTitle(" Tic Tac Teo Tips");
        setSize(900,600);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocation(450,150);
       
        tip1 = new JLabel("1.Game Setup");
        tip2 = new JLabel("2.Make Your Move");
        tip3 = new JLabel("3.Computer's Move");
        tip4 = new JLabel("4.Winning Condition");
        mainLabel = new JLabel("Tips for Playing the Tic Tac Teo Game");
        desctip1 = new JTextArea("The game board consists of a 3x3 grid where you play against the computer.");
        desctip2 = new JTextArea(" Click on any empty square to place your X."); 
        desctip3 = new JTextArea("After you place your X, the computer will automatically place its O on a random empty square.");
        desctip4 = new JTextArea("To win, align three of your symbols (X) horizontally, vertically, or diagonally.");
    
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
          tip1.setText("5.Losing Condition");
          tip2.setText("6.Draw Condition");
          tip3.setText("7.Reset Game");
          tip4.setText("");
     
          desctip1.setText(" If the computer aligns three O's, it wins the game.");         
          desctip2.setText(" If the board is full and no one wins, the game ends in a draw.");
          desctip3.setText("After each game, the board will reset automatically, and you can play again");
          desctip4.setText("");
 
         
          desctip4.setBackground(Color.lightGray);
     
          Next.setText("Back");
          p1.setBackground(Color.lightGray);
          isFirstClick = false;
         }
         else if (e.getSource()== Next && !isFirstClick)
         {
             tip1.setText("1.Game Setup");
             tip2.setText("2.Make Your Move");
             tip3.setText("3.Computer's Move");
             tip4.setText("4.Winning Condition");
        
             desctip1.setText("The game board consists of a 3x3 grid where you play against the computer.");
             desctip2.setText("Click on any empty square to place your X.");
             desctip3.setText("After you place your X, the computer will automatically place its O on a random empty square.");
             desctip4.setText("To win, align three of your symbols (X) horizontally, vertically, or diagonally.");
        
             
             desctip4.setBackground(Color.WHITE);
 
             Next.setText("Next");
             p1.setBackground(color);
             isFirstClick = true;
     
         }
         else if (e.getSource()==StartTheGame)
         {
             new XOGame();
             dispose();
         }
     }
    
}
