import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URISyntaxException;

public class supportME extends JFrame implements ActionListener {

    JButton ig_btt = new JButton("Ig");
    JButton github_btt = new JButton("Github");
    ImageIcon ig_ikona = new ImageIcon("ig_btn.png");
    ImageIcon github_ikona = new ImageIcon("github_btn.png");
    JLabel label = new JLabel("SUPPORT ME BABY");
    JPanel panel = new JPanel();

    supportME(GamePanel gamePanel){
        this.setTitle("Socials");
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(300,190);

        panel.setBackground(Color.darkGray);
        panel.setSize(290,180);
        panel.setLayout(null);

        label.setFont(new Font("Console",Font.BOLD,20));
        label.setForeground(Color.red);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setBounds(47,35,200,25);

        ig_btt.addActionListener(this);
        github_btt.addActionListener(this);

        ig_btt.setIcon(ig_ikona);
        github_btt.setIcon(github_ikona);
        ig_btt.setBounds(10,90,130,50);
        github_btt.setBounds(146,90,130,50);
        ig_btt.setFocusable(false);
        github_btt.setFocusable(false);

        panel.add(ig_btt);
        panel.add(github_btt);
        panel.add(label);


        this.add(panel);
        //this.pack();
        this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ig_btt){
            try {
                Desktop.getDesktop().browse(new java.net.URI("https://www.instagram.com/kanterino0/"));
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (URISyntaxException ex) {
                ex.printStackTrace();
            }
        }
        else if(e.getSource() == github_btt){
            try {
                Desktop.getDesktop().browse(new java.net.URI("https://github.com/Kante1702"));
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (URISyntaxException ex) {
                ex.printStackTrace();
            }
        }


    }
}
