import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class MemoryPuzzleTips  extends JFrame implements ActionListener{

private static boolean isFirstClick = true;
Color color = new Color(250, 218, 221);
 JPanel p1= new JPanel();
 JLabel tip1,tip2,tip3,tip4,mainLabel;
  JTextArea desctip1,desctip2,desctip3,desctip4;
 JButton Next,StartTheGame;
public MemoryPuzzleTips()
{

    setTitle("Memory Puzzle Tips");
    setSize(900,600);
    setLayout(new BorderLayout());
    setResizable(false);
    setLocation(450,150);
   
    tip1 = new JLabel("1.Understand the Objective");
    tip2 = new JLabel("2.Start by Observing");
    tip3 = new JLabel("3.Click Carefully");
    tip4 = new JLabel("4.Match Pairs");
    mainLabel = new JLabel("Tips For Playing The Memory Puzzle Game");
    desctip1 = new JTextArea("Match all the pairs of identical images hidden behind the buttons on the grid.");
    desctip2 = new JTextArea("When the game begins, all the images are shown briefly. Use this time to memorize as many pairs as possible.");
    desctip3 = new JTextArea("Select a button to reveal the hidden image. Try to remember the position of each revealed image.");
    desctip4 = new JTextArea("If you find two matching images, their buttons will stay revealed. Otherwise, the images will be hidden again.");

    desctip1.setEditable(false);
    desctip2.setEditable(false);
    desctip3.setEditable(false);
    desctip4.setEditable(false);

    Next = new JButton("Next");
    StartTheGame = new JButton("Start The Game");

    
    Font font1 = new Font("Georgia", 1,20);
    Font font2 = new Font("Trebuchet MS", 2,15);
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
 
 public void actionPerformed(ActionEvent e){
    if(e.getSource()==Next && isFirstClick)
    {
     tip1.setText("5.Focus on Locations");
     tip2.setText("6.Plan Moves Strategically");
     tip3.setText("7.Speed vs. Accuracy");
     tip4.setText("8.Avoid Random Clicking");

     desctip1.setText("Pay close attention to where images are located; this will help you remember their positions for future matches.");
     desctip2.setText("If you reveal an image and don't find its match, remember its location to match it later when you find the identical image.");
     desctip3.setText("While there's no time limit, playing quickly but accurately will keep the game engaging and fun.");
     desctip4.setText("Randomly clicking buttons may confuse you and make it harder to track the image pairs.");

     Next.setText("Back");
     p1.setBackground(Color.lightGray);
     isFirstClick = false;
    }
    else if (e.getSource()== Next && !isFirstClick)
    {
        tip1.setText("1.Understand the Objective");
        tip2.setText("2.Start by Observing");
        tip3.setText("3.Click Carefully");
        tip4.setText("4.Match Pairs");
   
        desctip1.setText("Match all the pairs of identical images hidden behind the buttons on the grid.");
        desctip2.setText("When the game begins, all the images are shown briefly. Use this time to memorize as many pairs as possible.");
        desctip3.setText("Select a button to reveal the hidden image. Try to remember the position of each revealed image.");
        desctip4.setText("If you find two matching images, their buttons will stay revealed. Otherwise, the images will be hidden again.");
   
        Next.setText("Next");
        p1.setBackground(color);
        isFirstClick = true;

    }
    else if (e.getSource()==StartTheGame)
    {
        new MemoryPuzzle();
        dispose();
    }
}

    
}
