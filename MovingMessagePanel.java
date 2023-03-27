import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.TextEvent;
public class MovingMessagePanel extends JPanel implements ItemListener,ActionListener,MouseMotionListener,MouseListener{

    JFrame main = new JFrame();
    JPanel center = new JPanel();
    JPanel north = new JPanel();
    JPanel west = new JPanel();
    JPanel south = new JPanel();
    JPanel east = new JPanel();
    Color textColor = Color.BLACK;
    Color bgColorset = Color.WHITE;
    JLabel nside = new JLabel("Message to be displayed");
    JTextField tf = new JTextField();
    JLabel bgcolor = new JLabel("Background Color");
    JCheckBox white = new JCheckBox("White");
    JCheckBox black = new JCheckBox("Black");
    JRadioButton radiobutton = new JRadioButton("Use Mouse");
    JButton left = new JButton("Left");
    JButton right = new JButton("Right");
    JButton up = new JButton("Up");
    JButton down = new JButton("Down");
    int x = 0;
    int y = 100;
    String message  ="";
    //Action events
    

    MovingMessagePanel(){
        // this.setLayout(new BorderLayout());
        north.setLayout(new BorderLayout());
        north.add(nside,BorderLayout.WEST);
        north.add(tf,BorderLayout.CENTER);
        west.setLayout(new GridLayout(3,1));
        west.add(bgcolor);
        west.add(white);
        west.add(black);
        east.setLayout(new BorderLayout());
        east.add(radiobutton,BorderLayout.CENTER);
        south.add(left);
        south.add(right);
        south.add(up);
        south.add(down);
        main.add(this,BorderLayout.CENTER);
        main.add(west,BorderLayout.WEST);
        main.add(north,BorderLayout.NORTH);
        main.add(east,BorderLayout.EAST);
        main.add(south,BorderLayout.SOUTH);

        tf.addActionListener(this);
        white.addItemListener(this);
        black.addItemListener(this);
        // radiobutton.addActionListener(this);
        left.addActionListener(this);
        right.addActionListener(this);
        up.addActionListener(this);
        down.addActionListener(this);
        
        main.setVisible(true);
        main.setSize(800,400);
        // main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setLocationRelativeTo(null);
        addMouseMotionListener(this);
        
    }

    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        setBackground(bgColorset);
        Font myfond = new Font("SanSerif",Font.BOLD,32);
        g.setFont(myfond);
        g.setColor(textColor);
        g.drawString(message, x,y);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == tf){
            message = e.getActionCommand();
            
        }
       
        if (e.getSource() == left){
            x = x-5;
        }
        if (e.getSource() == right){
            x = x+5;
        }
        if (e.getSource() == up){
            y= y-5;
        }
        if (e.getSource() == down){
            y = y+5;
        }
        
        
       
        

        repaint();
    }
    public void mouseDragged(MouseEvent e) {
        if (radiobutton.isSelected()){
            x = e.getX();
            y = e.getY();
            
        }
        repaint();
        
    }
    public  void itemStateChanged(ItemEvent e){
        if (e.getSource() == white &&e.getStateChange() ==1 ){
            bgColorset = Color.WHITE;
            textColor  = Color.PINK;
            black.setSelected(false);
        }
        if (e.getSource() == black && e.getStateChange() ==1){
            bgColorset = Color.BLACK;
            textColor = Color.PINK;
            white.setSelected(false);
        }
        repaint();
    }
   
   

    
    public static void main(String[] args) {
        MovingMessagePanel test = new MovingMessagePanel();
        
    }

   
    

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseMoved'");
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }

    
}