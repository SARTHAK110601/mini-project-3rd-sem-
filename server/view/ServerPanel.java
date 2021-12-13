package server.view;

//import intf.MessageInterface;
import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//import server.conn.Server;
//import javax.swing.border.*;

public class ServerPanel extends JFrame{ //implements ActionListener, MessageInterface{
    
    
    private int width = 550;                        //window width
    private int height = 600;                       //window height
    
    private JPanel mainPanel;
    private JPanel centerPanel;                     //background panel settings
    private JPanel bottomPanel;                     //send,connect,start,text feild settings
    
    private JTextArea outputMessages;
    private JScrollPane scrollMessages;
    private JTextField inputMessage;
    private JButton sendMessageBtn;
    private JButton startServerBtn;
    
    public ServerPanel(){
        super("Server Panel");
        
        mainPanel = new JPanel(null);
        mainPanel.setBackground(Color.white);
        
        
        centerPanel = new JPanel(null);
        centerPanel.setBackground(Color.white); //upper background color
        centerPanel.setBounds(0, 0, width, height - 100); //defining window each side width and height
        
        
        bottomPanel = new JPanel(null);
        bottomPanel.setBackground(Color.white); //bottom background color
        bottomPanel.setBounds(0, centerPanel.getHeight(), width, 100); //defining window each side width and height
        //centerPanel.getHeight()-copies the height of the center panel
        
        outputMessages = new JTextArea();//creates a text area which displays the messages sent by the server 
        outputMessages.setBackground(Color.decode("#DD80DD")); //background color
        outputMessages.setForeground(Color.white); //text color
        scrollMessages = new JScrollPane(outputMessages); //provides a scroll view to the panel     
        scrollMessages.setBounds(5, 5, centerPanel.getWidth() - 20, centerPanel.getHeight() - 20); //dimentions of the panel
        centerPanel.add(scrollMessages); //method used to add line 55
        
        inputMessage = new JTextField();
        //creates a text field where the messages are typed inn
        //  inputMessage.setForeground(Color.white); //text color
        inputMessage.setBounds(10, 10, 450, 30);
        inputMessage.setBackground(Color.decode("#DD80DD")); //background color
        inputMessage.setSize(300, 30);//size of text feild
        bottomPanel.add(inputMessage);//method which adds the inputmessage to the bottom panel
        
        sendMessageBtn = new JButton("Send");//creates send button
        sendMessageBtn.setBackground(Color.decode("#B200B2"));//background color
        sendMessageBtn.setForeground(Color.WHITE); //text color
        sendMessageBtn.setBounds(inputMessage.getWidth() + 15, 10, 100, 30);//sets the position of the button
        //sendMessageBtn.addActionListener(this);
        bottomPanel.add(sendMessageBtn);//method for send button
        
        
        startServerBtn = new JButton("Start");//creates server start button
        startServerBtn.setBackground(Color.decode("#B200B2"));//background color
        startServerBtn.setForeground(Color.WHITE);//text color
        startServerBtn.setBounds(inputMessage.getWidth() + 120, 10, 100, 30);//sets the position of the button
        //startServerBtn.addActionListener(this);
        bottomPanel.add(startServerBtn);
        
        mainPanel.add(centerPanel);// method whch adds centerpanel to the mainpanel
        mainPanel.add(bottomPanel);// method whch adds bottompanel to the mainpanel
        
        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setVisible(true);
    }
    
    public static void main(String args[]){
        new ServerPanel();
    }
}

   /* @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startServerBtn){
            try {
                Server.getInstance().startServer(this);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        
        if(e.getSource() == sendMessageBtn){
            try {
                Server.getInstance().sendMessage(inputMessage.getText());
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

   
    public void onMessageReceived(String message) {
        outputMessages.append("Client: " + message + "\n");
    }
}*/