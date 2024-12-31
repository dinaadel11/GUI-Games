import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class GuessTheFruitTips extends JFrame implements ActionListener {

    private static boolean isFirstClick = true;
    Color color = new Color(200,40,80);
     JPanel p1= new JPanel();
     JLabel tip1,tip2,tip3,tip4,mainLabel;
      JTextArea desctip1,desctip2,desctip3,desctip4;
     JButton Next,StartTheGame;

     public GuessTheFruitTips()
     {
        setTitle(" Guess The Fruit Tips");
        setSize(900,600);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocation(450,150);
       
        tip1 = new JLabel("1.Understand the Objective");
        tip2 = new JLabel("2.Start with Common Letters");
        tip3 = new JLabel("3.Pay Attention to Feedback");
        tip4 = new JLabel("4.Avoid Repeating Letters");
        mainLabel = new JLabel("Tips for Playing Guess The Fruit Game");
        desctip1 = new JTextArea("The goal is to guess the name of a fruit by entering one letter at a time. Correct guesses reveal the letters in their correct positions.");
        desctip2 = new JTextArea("Begin by guessing commonly used letters like vowels (a, e, i, o, u) or frequent consonants (s, t, r, l, n).");
        desctip3 = new JTextArea("If the guessed letter is correct, it will replace the corresponding underscores,If it's wrong, try a different letter.");
        desctip4 = new JTextArea("Keep track of the letters you've already guessed to avoid wasting turns on repeats.");
    
    
        desctip1.setEditable(false);
        desctip2.setEditable(false);
        desctip3.setEditable(false);
        desctip4.setEditable(false);
    
        Next = new JButton("Next");
        StartTheGame = new JButton("Start The Game");
    
        
        Font font1 = new Font("Georgia", 1,18);
        Font font2 = new Font("Trebuchet MS", 2,12);
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
          tip1.setText("5.Think of Fruit Names");
          tip2.setText("6.Take Your Time");
          tip3.setText("7.Celebrate Your Win");
          tip4.setText("");
     
          desctip1.setText("Use the length of the word and revealed letters to guess the fruit. For example, if the word starts with \"a_p__\", it could be \"apple.\"");         
          desctip2.setText("There's no time limit, so carefully consider each guess.");
          desctip3.setText(" Once the word is fully revealed, enjoy the satisfaction of your correct guesses!");
          desctip4.setText("");

          desctip4.setBackground(Color.LIGHT_GRAY);
 
          Next.setText("Back");
          p1.setBackground(Color.lightGray);
          isFirstClick = false;
         }
         else if (e.getSource()== Next && !isFirstClick)
         {
             tip1.setText("1.Understand the Objective");
             tip2.setText("2.Start with Common Letters");
             tip3.setText("3.Pay Attention to Feedback");
             tip4.setText("4.Avoid Repeating Letters");
        
             desctip1.setText("The goal is to guess the name of a fruit by entering one letter at a time. Correct guesses reveal the letters in their correct positions.");
             desctip2.setText("Begin by guessing commonly used letters like vowels (a, e, i, o, u) or frequent consonants (s, t, r, l, n).");
             desctip3.setText("If the guessed letter is correct, it will replace the corresponding underscores,If it's wrong, try a different letter.");
             desctip4.setText("Keep track of the letters you've already guessed to avoid wasting turns on repeats.");
                                 
            desctip4.setBackground(Color.WHITE);
             Next.setText("Next");
             p1.setBackground(color);
             isFirstClick = true;
     
         }
         else if (e.getSource()==StartTheGame)
         {
             new GuessTheFruitGame();
             dispose();
         }
     }
    
}
