import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameFrame extends JFrame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitMenuItem) {
            System.exit(0);
        }
        if(e.getSource() == supportMeMenuItem){
            gamePanel.pauseGame();
            supportME SUPME = new supportME(gamePanel);
            SUPME.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            SUPME.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    gamePanel.resumeGame();
                }
            });
        }

    }

    GamePanel gamePanel = new GamePanel();
    ImageIcon ikona = new ImageIcon("ikona_fucker.png");
    JMenuBar menuBar = new JMenuBar();
    JMenu clickMeMenu = new JMenu("Click Me");
    JMenuItem exitMenuItem = new JMenuItem("Exit");
    JMenuItem supportMeMenuItem = new JMenuItem("support Me");
    GameFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setTitle("Kanteho_PONG");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.green);
        this.setIconImage(ikona.getImage());
        exitMenuItem.addActionListener(this);
        supportMeMenuItem.addActionListener(this);

        exitMenuItem.setMnemonic(KeyEvent.VK_E);
        supportMeMenuItem.setMnemonic(KeyEvent.VK_S);

        clickMeMenu.add(supportMeMenuItem);
        clickMeMenu.add(exitMenuItem);

        menuBar.add(clickMeMenu);

        this.setJMenuBar(menuBar);
        this.add(gamePanel);
        this.pack();
        this.setVisible(true);





    }
}
