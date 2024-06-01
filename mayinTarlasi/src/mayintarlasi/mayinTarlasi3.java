/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mayintarlasi;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author 06bey
 */
public class mayinTarlasi3 implements MouseListener{

    JFrame frame;
    btn[][] board=new btn[20][10];
    int openc;
    public mayinTarlasi3(){
    frame=new JFrame("MAYIN TARLASI");
    frame.setSize(1400,800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(10,20));
    
    for(int row=0;row<board.length;row++){
        for(int col=0;col<board[0].length;col++){
            btn b=new btn(row,col);
            frame.add(b);
            b.addMouseListener(this);
            board[row][col]=b;
        }
    }
    generateMine();
    updateCount();
   // print();
    frame.setVisible(true);
    }
    public void print(){
        for(int row=0;row<board.length;row++){
        for(int col=0;col<board[0].length;col++){
            if(board[row][col].isMine()){
                board[row][col].setIcon(new ImageIcon("C:/User/06bey/Downloads/mayin.png"));
            }else{
                board[row][col].setText(board[row][col].getCount()+"");
            }
        }
       } 
    }
    public void open(int r, int c){
        if(r<0||r>=board.length||c<0||c>=board[0].length||board[r][c].getText().length()>0 || board[r][c].isEnabled()==false){
            return;
        }else if(board[r][c].getCount() != 0){
            board[r][c].setText(board[r][c].getCount()+"");
            board[r][c].setEnabled(false);
            openc++;
        }else{
            openc++;
            board[r][c].setEnabled(false);
            open(r-1,c);
            open(r+1,c);
            open(r,c-1);
            open(r,c+1);
        }
    }
    public void updateCount(){
         for(int row=0;row<board.length;row++){
        for(int col=0;col<board[0].length;col++){
           if(board[row][col].isMine()){
               counting(row,col);
           }
        }
       }
    }
    public void counting(int row, int col){
        for(int i=row-1;i<=row+1;i++){
           for(int k=col-1;k<=col+1;k++){
               try{
               int val=board[i][k].getCount();
               board[i][k].setCount(++val);
               }catch(Exception e){
               
               }
           } 
        }
    }
    public void generateMine(){
        int i=0;
        while(i<50){
            int randRow=(int)(Math.random()*board.length);
            int randCol=(int)(Math.random()*board[0].length);
            while(board[randRow][randCol].isMine()){//eğer ürettiği yerde mayın varsa tekrar sayı ürettiriyoruz.
                randRow=(int)(Math.random()*board.length);
                randCol=(int)(Math.random()*board[0].length);
            }
            board[randRow][randCol].setMine(true);
            i++;
        }          
    }
   
    @Override
    public void mouseClicked(MouseEvent e) {
        btn b=(btn)e.getComponent();
        if(e.getButton()==1){
            if(b.isMine()){
                JOptionPane.showMessageDialog(frame,"Mayına Bastınız oyun bitti! ", "Mayına Bastınız", 0);
                print();
           }
            else{
                open(b.getRow(),b.getCol());
                if(openc==((board.length*board[0].length)- 50)){
                  JOptionPane.showMessageDialog(frame,"KAZANDIN :)  ", "TEBRİKLER!", 0);  
                  print();
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
