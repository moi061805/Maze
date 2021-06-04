package cont;

import javax.swing.JOptionPane;

public class JOP {
  //This class enables me to use the JOptionPane features
  public static void msg(String msg) {
    JOptionPane.showMessageDialog(null, msg);
  }
  
  public static String in(String msg) {
    return JOptionPane.showInputDialog(msg);
  }
}
