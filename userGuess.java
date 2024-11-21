package UserGuess;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class userGuess extends JFrame implements ActionListener {
private final int randomNumber = (int) (Math.random() * 100) + 1; // Generate once
  private int attempts = 0; 
  private final int maxAttempts = 3;   
    JLabel nombreOne = new JLabel("Guess a number between 1 and 100: (3 Guesses only!)");
    JTextField jT1 = new JTextField(20); 
    DefaultListModel<String> model = new DefaultListModel<>();
    JList<String> liste1 = new JList<>(model);//pour l'affichage des résultats
    JButton CheckNumber = new JButton("Check");
    public userGuess(){
        checknumber();
    }
    public void checknumber(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Random Number Game");
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        nombreOne.setFont(new Font("Arial", Font.BOLD, 20));
        nombreOne.setForeground(new Color(30, 144, 255));
        CheckNumber.setFont(new Font("Arial", Font.BOLD, 20));
        CheckNumber.setBackground(new Color(60, 179, 113));
        CheckNumber.setForeground(Color.WHITE);
        liste1.setFont(new Font("Arial", Font.PLAIN, 14));
        JPanel jp1 = new JPanel(new FlowLayout());
        jp1.add(nombreOne);
        jp1.add(jT1);
        jp1.add(CheckNumber);

         // Panel 2 (Display Results)
         JPanel jp2 = new JPanel(new BorderLayout());
         liste1.setBackground(new Color(245, 245, 245)); // Light gray background for list
         jp2.add(new JScrollPane(liste1), BorderLayout.CENTER);
 
         // Add panels to frame
         this.add(jp1, BorderLayout.NORTH);
         this.add(jp2, BorderLayout.CENTER);
 
         // Action listener for button
         CheckNumber.addActionListener(this);
 
         this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == CheckNumber) {
         
          if (attempts >= maxAttempts) {
            JOptionPane.showMessageDialog(this, "You have reached the maximum number of attempts. the random number was"+randomNumber, "Game Over", JOptionPane.WARNING_MESSAGE);
            return;
        }
            String input = jT1.getText();
           
              
           
            try {
          
                String result;
                int UserNumber = Integer.parseInt(input);
                attempts++;
                  if(UserNumber==randomNumber){
                    result="You won the Game  the random number was "+randomNumber;
                    JOptionPane.showMessageDialog(this, result, "Victory!", JOptionPane.INFORMATION_MESSAGE);
                    attempts = 0;
                    model.clear();
                    jT1.setText("");
                    JOptionPane.showMessageDialog(this, "A new game will start now!", "New Game", JOptionPane.INFORMATION_MESSAGE);
                  }
                  else if(UserNumber<randomNumber){
                    result = "Your guess (" + UserNumber + ") is too low. Try a higher number.";

                  }
                  else{
                    result = "Your guess (" + UserNumber + ") is too high. Try a higher number.";

                  }
             
               
             
               
                model.addElement(result);  // Add result to list
                jT1.setText("");
               
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Veuillez entrer un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public static void main(String[] args) {
   new userGuess();
  }
}
    
