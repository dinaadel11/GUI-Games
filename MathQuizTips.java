import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

public class MathQuizTips extends JFrame implements ActionListener {
     
    private static boolean isFirstClick = true;
    Color color = new Color(0x7B466A);
     JPanel p1= new JPanel();
     JLabel tip1,tip2,tip3,tip4,mainLabel;
      JTextArea desctip1,desctip2,desctip3,desctip4;
     JButton Next,StartTheGame;
    public MathQuizTips()
    {
        setTitle("Math Quiz Tips");
        setSize(900,600);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocation(450,150);
       
        tip1 = new JLabel("1.Understand the Game Objective");
        tip2 = new JLabel("2.Choose Your Settings");
        tip3 = new JLabel("3.Focus on Accuracy");
        tip4 = new JLabel("4.Practice Mental Math");
        mainLabel = new JLabel("Tips for Playing the Math Quiz Game");
        desctip1 = new JTextArea("Answer as many math questions as possible correctly within the given number of questions.");
        desctip2 = new JTextArea("Select the operation (Addition, Subtraction, Multiplication, Division, or Mixed) and difficulty level (Easy, Medium, Hard, or Mixed) to match your math skills.");
        desctip3 = new JTextArea("Take your time to solve each question carefully—incorrect answers can’t be changed.");
        desctip4 = new JTextArea("Try solving questions in your head to improve your speed and accuracy.");
    
        desctip1.setEditable(false);
        desctip2.setEditable(false);
        desctip3.setEditable(false);
        desctip4.setEditable(false);
    
        Next = new JButton("Next");
        StartTheGame = new JButton("Start The Game");
    
        
        Font font1 = new Font("Georgia", 1,16);
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
         tip1.setText("5.Use the Calculator (if necessary)");
         tip2.setText("6.Manage Your Input");
         tip3.setText("7.Learn From Mistakes");
         tip4.setText("8.Stay Calm Under Pressure");
    
         desctip1.setText("If the difficulty is high, don’t hesitate to use a calculator to confirm your answer.");
         desctip2.setText("Ensure you enter numbers only—no letters or symbols—or the game won’t accept your response.");
         desctip3.setText("When you get a question wrong, note the correct answer to understand your mistake and improve.");
         desctip4.setText("The game isn’t timed, so focus on getting the answers right rather than rushing.");
    
         Next.setText("Back");
         p1.setBackground(Color.lightGray);
         isFirstClick = false;
        }
        else if (e.getSource()== Next && !isFirstClick)
        {
            tip1.setText("1.Understand the Game Objective");
            tip2.setText("2.Choose Your Settings");
            tip3.setText("3.Focus on Accuracy");
            tip4.setText("4.Practice Mental Math");
       
            desctip1.setText("Answer as many math questions as possible correctly within the given number of questions.");
            desctip2.setText("Select the operation (Addition, Subtraction, Multiplication, Division, or Mixed) and difficulty level (Easy, Medium, Hard, or Mixed) to match your math skills.");
            desctip3.setText("Take your time to solve each question carefully—incorrect answers can’t be changed.");
            desctip4.setText("Try solving questions in your head to improve your speed and accuracy.");
       
            Next.setText("Next");
            p1.setBackground(color);
            isFirstClick = true;
    
        }
        else if (e.getSource()==StartTheGame)
        {
            new MathQuizGame();
            dispose();
        }
    }
    
      
    }

