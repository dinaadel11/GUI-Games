import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
public class MemoryPuzzle extends JFrame implements ActionListener {

   JButton [] buttons;
   ImageIcon[] images;
   boolean [] revealed;
   int firstIndex= -1;
   int secondIndex= -1;
 
   ImageIcon originalIcon = new ImageIcon("download (3).jpg");
   Image image = originalIcon.getImage();
   Image resizedImage = image.getScaledInstance(125, 125, Image.SCALE_SMOOTH);
   ImageIcon resizedIcon = new ImageIcon(resizedImage);
   
 
    public MemoryPuzzle()
    {
        revealed = new boolean[16];
        buttons = new JButton[16];
        setTitle("Memory Puzzle");
        setSize(500,500);
        setLayout(new GridLayout(4,4));
        setResizable(false);
        setLocation(450,180);

        for(int i= 0 ; i<buttons.length;i++)
        {
            JButton button = new JButton();
            button.addActionListener(this);
          buttons[i]= button;
           add(button);
        }

        String []  imagePaths={"download (1).jpg","download (2).jpg","Download orange slice watercolor illustration, orange slice on transparent background for free.jpg"
    ,"download.jpg","A Glossary of Wedding Flowers by Color.jpg","Orange Lily Coloured Pencil Sticker by SurayaBond.jpg",
    "Pink Stickers for Sale.jpg","Pink Watermelon PNG Transparent, One Pink Watermelon Free Button, One Petal, Pink Watermelon, Free Buckle Illustration PNG Image For Free Download.jpg"
     };
      
     images = new ImageIcon[16];
     for(int i =0;i<imagePaths.length;i++)
     {
        ImageIcon originalIcon2 =  new ImageIcon(imagePaths[i]);
        Image img = originalIcon2.getImage();
        Image resizedImg = img.getScaledInstance(125, 125, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon2 = new ImageIcon(resizedImg);
        images[i*2]=resizedIcon2;
        images[i*2+1]=resizedIcon2;

     }

     
     RandomIamges(images);
       ShowImages();
    
       setVisible(true); 
    }
    
   
    private void RandomIamges ( ImageIcon [] images)
    {
       Random rand = new Random();
     for(int i = images.length-1;i>0;i--)
     {
      
       int j = rand.nextInt(i+1);
       ImageIcon temp = images[i];
       images[i]=images[j];
       images[j]= temp;
     }
    }

     private void ShowImages ()
     {
        for (int i=0;i<16;i++)
        {
          buttons[i].setIcon(images[i]);
        }

        Timer time = new Timer(2000,new ActionListener() {
            public void actionPerformed( ActionEvent e)
            {
             hideImages();
            }
        });
        time.setRepeats(false);
        time.start();
     }

  
     private void hideImages()
     {
       

        for (int i =0;i<16;i++)
        {
            buttons[i].setIcon(resizedIcon);
        }
     }


    public void actionPerformed(ActionEvent e)
    {
       for (int i =0;i<buttons.length;i++)
       {
        if(e.getSource()==buttons[i]&& ! revealed[i])
        {
          ButtonClick(i);
        }
       }
    }

    private void ButtonClick (int index)
    {
        if (firstIndex==-1)
        {
            firstIndex = index;
            buttons[index].setIcon(images[index]);
        }
        else if (secondIndex==-1 && index!= firstIndex)
        {
            secondIndex = index;
            buttons[index].setIcon(images[index]);
        }

        Timer time = new Timer(500, new ActionListener() {
            public void actionPerformed( ActionEvent e)
            {
             isMatching();
            }
        });
        time.setRepeats(false);
        time.start();
    }

    private void isMatching ()
    {
     if( images[firstIndex].equals(images[secondIndex]))
     {
        revealed[firstIndex] = true;
        revealed[secondIndex] = true;
     }
     else 
     {
        buttons[firstIndex].setIcon(resizedIcon);
        buttons[secondIndex].setIcon(resizedIcon);
     }
     firstIndex=-1;
     secondIndex=-1;
    }
}

  
    

