import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GuessesGames extends JFrame implements ActionListener {
    JPanel p1 =  new JPanel();
    JPanel p2 =  new JPanel();
    JButton guessTheNum,guessThefruit;
    ImageIcon originalIcon = new ImageIcon("photo_2024-12-30_21-14-42.jpg");
   Image image = originalIcon.getImage();
   Image resizedImage = image.getScaledInstance(600, 250, Image.SCALE_SMOOTH);
   ImageIcon resizedIcon = new ImageIcon(resizedImage);

   public GuessesGames()
   {
    setTitle("Guesses Games");
    setSize(600, 300);
    setLayout(new  BorderLayout()); 
    setResizable(false);
    setLocation(370,180);

    p1.setLayout(new BorderLayout());
       JLabel label= new JLabel();
       label.setIcon(resizedIcon);
       p1.add(label,BorderLayout.CENTER);

       guessTheNum = new JButton("Guess The Number");
       guessThefruit = new JButton("Guess The Fruit");

       Color color = new Color(0x7E99A3);
       guessTheNum.setBackground(color);
       guessThefruit.setBackground(color);

       guessTheNum.addActionListener(this);
       guessThefruit.addActionListener(this);

       p2.add(guessThefruit);
       p2.add(guessTheNum);
       add(p1,BorderLayout.CENTER);
       add(p2,BorderLayout.SOUTH);

       setVisible(true);
   }

   public void actionPerformed(ActionEvent e) {
    if (e.getSource() == guessTheNum) {
        new GuessTheNumberTips(); 
    } else if (e.getSource() == guessThefruit) {
        new GuessTheFruitTips(); 
   
}
   }
}
