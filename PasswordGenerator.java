/*
* Simple, 100% standard Java code
* No mavern, no gradle, nothing complex.
* No 3rd party libraries

[X] Uppercase
[X] Lowercase
[X] Digits
[X] Special characters
[   ] Password length

* Compile and create a JAR file.
* My code will be on Github

* TODO: min chars, min digits, eg. password must have 2 alphabetic letters
2 digits, and 1 special minimum.
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.security.SecureRandom;

public class PasswordGenerator extends JFrame
{
   // Constants:
   public static final String APP_NAME_AND_VERS = "Password Generator";// v0.02";
   public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
   public static final String DIGITS            = "0123456789";
   public static final String SPECIAL_CHARS     = ",.;:!";

   // GUI Components:
   private JCheckBox uppercaseCheckBox          = new JCheckBox ("Uppercase letters (A-Z)");
   private JCheckBox lowercaseCheckBox          = new JCheckBox ("Lowercase letters (a-z)");
   private JCheckBox digitsCheckBox             = new JCheckBox ("Digits (0-9)");
   private JCheckBox specialCharsCheckBox       = new JCheckBox ("Special Chars: " + SPECIAL_CHARS);
   private JSpinner  passwordLengthSpinner      = new JSpinner  ();
   private JButton   generatePassswordButton    = new JButton   ("Generate Password");
   private JLabel    passwordLabel              = new JLabel    ();
   private JButton   copyClipboardButton        = new JButton   ("Copy Clipboard");

   private SecureRandom generator               = new SecureRandom ();


   public PasswordGenerator ()
   {
      setLayout (new GridLayout (8, 1) );

      passwordLengthSpinner.setModel (new SpinnerNumberModel (15, 15, 100, 1) );

      add (uppercaseCheckBox);
      add (lowercaseCheckBox);
      add (digitsCheckBox);
      add (specialCharsCheckBox);
      add (passwordLengthSpinner);
      add (passwordLabel);
      add (generatePassswordButton);
      add (copyClipboardButton);

      generatePassswordButton.addActionListener (event -> generatePasssword () );


      setTitle    (APP_NAME_AND_VERS);
      setSize     (500, 500);
      setLocation (300, 100);
      setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      setVisible  (true);
   }

   private void generatePasssword ()
   {
      passwordLabel.setText ("password goes here");

      String passwordStr = "";
      int passwordLength = (int) passwordLengthSpinner.getValue ();
      System.out.println (passwordLength);

      passwordLabel.setText ("");

      if ((uppercaseCheckBox.isSelected()    == false) &&
          (lowercaseCheckBox.isSelected()    == false) &&
          (digitsCheckBox.isSelected()       == false) &&
          (specialCharsCheckBox.isSelected() == false) )
      {
         JOptionPane.showMessageDialog (null, "ERROR: No password characters selected.");

         return;
      }


      for (int c = 0; c < passwordLength; c++)
      {
         int charType = (int) (Math.random() * 4); // 0 - 3

         if ((charType == 0) && (uppercaseCheckBox.isSelected() == true) )
         {
            int rand = generator.nextInt (UPPERCASE_LETTERS.length() );    // 0-25;
            passwordStr += UPPERCASE_LETTERS.charAt (rand);
         }

         if ((charType == 1) && (lowercaseCheckBox.isSelected() == true) )
         {
            int rand = generator.nextInt (LOWERCASE_LETTERS.length() );    // 0-25;
            passwordStr += LOWERCASE_LETTERS.charAt (rand);
         }

         if ((charType == 2) && (digitsCheckBox.isSelected() == true) )
         {
            int rand = generator.nextInt (DIGITS.length() );    //0 to 9.
            passwordStr += DIGITS.charAt (rand);
         }

         if ((charType == 3) && (specialCharsCheckBox.isSelected() == true) )
         {
            int rand = generator.nextInt (SPECIAL_CHARS.length() );    //0 to ...
            passwordStr += SPECIAL_CHARS.charAt (rand);
         }
      }

      passwordLabel.setText (passwordStr);

   }


   public static void main(String[] args)
   {
      new PasswordGenerator ();
   }
}