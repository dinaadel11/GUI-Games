import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MathQuizGame extends JFrame {
    private JComboBox<String> operationComboBox, difficultyComboBox;
    private JLabel questionLabel, scoreLabel, remainingLabel;
    private JTextField answerField;
    private JButton submitButton, nextButton;
    private int correctAnswer, score = 0, totalQuestions, questionsAsked = 0;

    public MathQuizGame() {
        setTitle("Math Quiz Game");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1));

        Color color1 = new Color(0x0C0420); 
        Color color2 = new Color(0x5D3C64); 
        Color color3 = new Color(0x7B466A); 
        Color color4 = new Color(0x9F6496); 
        Color color5 = new Color(0xD391B0); 
        Color color6 = new Color(0xBA6E8F); 
        Font font1 = new Font("monospace", Font.BOLD, 16);
        Font font2 = new Font("Arial", Font.BOLD, 20);
        Font font3 = new Font("Arial", Font.BOLD, 25);

        getContentPane().setBackground(color1);

        totalQuestions = Integer.parseInt(JOptionPane.showInputDialog("How many questions do you want?"));

        operationComboBox = new JComboBox<>(new String[]{"Addition", "Subtraction", "Multiplication", "Division", "Mixed"});
        difficultyComboBox = new JComboBox<>(new String[]{"Easy", "Medium", "Hard", "Mixed"});

        JPanel selectionPanel = new JPanel();
        selectionPanel.setBackground(color2); 
        JLabel jlab1 = new JLabel("Choose Operation:");
        jlab1.setFont(font1);
        selectionPanel.add(jlab1);
        selectionPanel.add(operationComboBox);
        JLabel jlab6 = new JLabel("Choose Difficulty:");
        jlab6.setFont(font1);
        selectionPanel.add(jlab6);
        selectionPanel.add(difficultyComboBox);

        add(selectionPanel);

        JLabel jlab2 = new JLabel("Press Next to Start", SwingConstants.CENTER);
        jlab2.setFont(font2);
        
        questionLabel = jlab2;
        questionLabel.setFont(font3);
        questionLabel.setForeground(color5); 
        add(questionLabel);

        JLabel jlab3 = new JLabel("Questions Remaining: " + totalQuestions, SwingConstants.CENTER);
        jlab3.setFont(font2);
        remainingLabel = jlab3;
        remainingLabel.setForeground(color5); 
        add(remainingLabel);

        JPanel answerPanel = new JPanel();
        answerPanel.setBackground(color3); 
        JLabel jLab4 = new JLabel("Your Answer:");
        jLab4.setFont(font2);
        answerPanel.add(jLab4);
        JTextField jtxtf = new JTextField(10);
        jtxtf.setFont(font2);
        answerField = jtxtf;
        answerField.setBackground(color4); 
        answerField.setForeground(Color.WHITE); 
        answerPanel.add(answerField);
        add(answerPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(color6);
        submitButton = new JButton("Submit");
        nextButton = new JButton("Next");

        submitButton.setBackground(color4);
        submitButton.setForeground(Color.WHITE);
        nextButton.setBackground(color4);
        nextButton.setForeground(Color.WHITE);

        buttonPanel.add(submitButton);
        buttonPanel.add(nextButton);
        add(buttonPanel);

        JLabel jlab5 = new JLabel("Score: 0", SwingConstants.CENTER);
        scoreLabel = jlab5;
        scoreLabel.setForeground(color5); 
        add(scoreLabel);

        submitButton.addActionListener(new SubmitAction());
        nextButton.addActionListener(new NextQuestionAction());

        setVisible(true);
    }

    private void generateQuestion() {
        if (questionsAsked >= totalQuestions) {
            JOptionPane.showMessageDialog(this, "Quiz finished! Your score: " + score + "/" + totalQuestions);
        }

        Random rand = new Random();
        String operation = (String) operationComboBox.getSelectedItem();
        String difficulty = (String) difficultyComboBox.getSelectedItem();

        int num1 = 0, num2 = 0;

        switch (difficulty) {
            case "Easy":
                num1 = rand.nextInt(10) + 1;
                num2 = rand.nextInt(10) + 1;
                break;
            case "Medium":
                num1 = rand.nextInt(50) + 1;
                num2 = rand.nextInt(50) + 1;
                break;
            case "Hard":
                num1 = rand.nextInt(100) + 1;
                num2 = rand.nextInt(100) + 1;
                break;
            case "Mixed":
                int difficultyLevel = rand.nextInt(3);
                if (difficultyLevel == 0) {
                    num1 = rand.nextInt(10) + 1;
                    num2 = rand.nextInt(10) + 1;
                } else if (difficultyLevel == 1) {
                    num1 = rand.nextInt(50) + 1;
                    num2 = rand.nextInt(50) + 1;
                } else {
                    num1 = rand.nextInt(100) + 1;
                    num2 = rand.nextInt(100) + 1;
                }
                break;
        }

        switch (operation) {
            case "Addition":
                correctAnswer = num1 + num2;
                questionLabel.setText(num1 + " + " + num2 + " = ?");
                break;
            case "Subtraction":
                correctAnswer = num1 - num2;
                questionLabel.setText(num1 + " - " + num2 + " = ?");
                break;
            case "Multiplication":
                correctAnswer = num1 * num2;
                questionLabel.setText(num1 + " * " + num2 + " = ?");
                break;
            case "Division":
                num1 = num1 * num2;
                correctAnswer = num1 / num2;
                questionLabel.setText(num1 + " / " + num2 + " = ?");
                break;
            case "Mixed":
                int operationType = rand.nextInt(4);
                if (operationType == 0) {
                    correctAnswer = num1 + num2;
                    questionLabel.setText(num1 + " + " + num2 + " = ?");
                } else if (operationType == 1) {
                    correctAnswer = num1 - num2;
                    questionLabel.setText(num1 + " - " + num2 + " = ?");
                } else if (operationType == 2) {
                    correctAnswer = num1 * num2;
                    questionLabel.setText(num1 + " * " + num2 + " = ?");
                } else {
                    num1 = num1 * num2;
                    correctAnswer = num1 / num2;
                    questionLabel.setText(num1 + " / " + num2 + " = ?");
                }
                break;
        }

        questionsAsked++;
        remainingLabel.setText("Questions Remaining: " + (totalQuestions - questionsAsked));
    }

    private class SubmitAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int userAnswer = Integer.parseInt(answerField.getText());
                if (userAnswer == correctAnswer) {
                    score++;
                    JOptionPane.showMessageDialog(null, "Correct!");
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong! The correct answer is " + correctAnswer);
                }
                scoreLabel.setText("Score: " + score);
                answerField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }

    private class NextQuestionAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            generateQuestion();
        }
    }

}