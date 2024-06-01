
package mayintarlasi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Main  {

  
    public static void main(String[] args) {
      JFrame fram;
      
      fram=new JFrame("MAYIN TARLASI");
      JButton b= new JButton();
      b.setText("BAŞLANGIÇ");
      b.setBounds(0, 0, 100, 100);
      b.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              mayinTarlasi m= new mayinTarlasi();
          }   
    });
      fram.add(b);
      JButton o= new JButton("ORTA ");
      o.setBounds(100, 100, 100, 100);
      o.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              mayinTarlasi2 m2= new mayinTarlasi2();
          }   
    });
      fram.add(o);
      JButton i= new JButton("İLERİ ");
      fram.add(i);
      i.setBounds(200, 200, 100, 100);
      i.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              mayinTarlasi3 m3= new mayinTarlasi3();
          }   
    });   
      fram.setSize(318,340);
      fram.setLayout(null);
      fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
       
      
     
      fram.setVisible(true);
     
      //mayinTarlasi m= new mayinTarlasi();
    }

  
   
    
}
