import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class pozadieFrame extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    JMenu helpMenu = new JMenu("Help");
    JMenu exitMenu = new JMenu("Exit");
    JMenuItem helpItem = new JMenuItem("Help");
    JMenuItem exitItem = new JMenuItem("Exit");
    GamePlay gamePlay = new GamePlay();

    pozadieFrame() {
        this.setTitle("KanterinoGame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 720);
        //this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);


       // panel.setBackground(Color.GRAY);


        helpItem.addActionListener(this);
        exitItem.addActionListener(this);

        helpMenu.add(helpItem);
        exitMenu.add(exitItem);

        helpMenu.setMnemonic(KeyEvent.VK_H);
        exitMenu.setMnemonic(KeyEvent.VK_E);

        helpItem.setMnemonic(KeyEvent.VK_H);
        exitItem.setMnemonic(KeyEvent.VK_E);

        menuBar.add(helpMenu);
        menuBar.add(exitMenu);

       // this.add(panel);
        this.add(gamePlay);
        this.setJMenuBar(menuBar);
        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exitItem) {
            Timer timer = new Timer(1500, event -> {
                System.exit(0);
            });
            timer.setRepeats(false);
            timer.start();
        }

    }
}
