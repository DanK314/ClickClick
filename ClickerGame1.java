//ClickClick
//Clicker Game
//Made By DanK314
//1.0 V

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClickerGame1 {
    public static void main(String[] args) {
        ClickerWindow window = new ClickerWindow();
    }
}
class ClickerWindow extends JFrame {
    int score = 0;
    int level = 1;
    int autoWork = 0;
    Color BackGroundColor = new Color(151, 188, 252);
    Color ButtonColor = new Color(252, 178, 109);
    Color TextColor = new Color(0,0,0);
    public ClickerWindow() {
        super("ClickClick");
        setTitle("ClickClick");
        setSize(512,512);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel BackPanel = new JPanel();
        BackPanel.setBackground(BackGroundColor);
        BackPanel.setOpaque(true);
        setBackground(BackGroundColor);

        Container contentPane = getContentPane();
        contentPane.setBackground(BackGroundColor);

        JLabel Header = MakeLabel("ClickClick", 40, "Arial", 0, 0);
        JLabel Level = MakeLabel("Lv.1", 30, "Arial", 0, 100);
        JLabel AutoWork = MakeLabel("Auto Lv.0",30, "Arial", 0, 150);
        JLabel Score = MakeLabel("Score : 0", 20, "Arial", 0, 200);
        
        JButton ClickButton = MakeButton("Click!!", 300, 100, "Arial", 30, 0, 350);
        ClickButton.setBackground(ButtonColor);
        ClickButton.setForeground(TextColor);
        ClickButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				score = score + level; 
				Score.setText("Score : " + score);
                Score.setBounds(Score.getX(), Score.getY(), Score.getPreferredSize().width, Score.getPreferredSize().height);
                
                revalidate();
                repaint();
            }
        });
        
        JButton ClickerUpgrade = MakeButton("Clicker Upgrade", 150, 100, "Arial", 15, -75, 250);
        ClickerUpgrade.setBackground(ButtonColor);
        ClickerUpgrade.setForeground(TextColor);
        ClickerUpgrade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if(score >= 100*level) {
                    score = score - (100*level);
                    ++level;
                    
                    Level.setText("Lv." + level);
                    Level.setBounds(Level.getX(), Level.getY(), Level.getPreferredSize().width, Level.getPreferredSize().height);
                    Score.setText("Score : " + score);
                    Score.setBounds(Score.getX(), Score.getY(), Score.getPreferredSize().width, Score.getPreferredSize().height);
                }

                revalidate();
                repaint();
            }
        });

        JButton AutoUpgrade = MakeButton("Auto Upgrade", 150, 100, "Arial", 15, 75, 250);
        AutoUpgrade.setBackground(ButtonColor);
        AutoUpgrade.setForeground(TextColor);
        AutoUpgrade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if(score >= 100*(autoWork+1)) {
                    score = score - (100*(autoWork+1));
                    ++autoWork;
                    
                    AutoWork.setText("Auto Lv." + autoWork);
                    AutoWork.setBounds(AutoWork.getX(), AutoWork.getY(), AutoWork.getPreferredSize().width, AutoWork.getPreferredSize().height);
                }

                revalidate();
                repaint();
            }
        });
        Timer AutoWorkingSystem = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                score = score + autoWork; 
				Score.setText("Score : " + score);
                Score.setBounds(Score.getX(), Score.getY(), Score.getPreferredSize().width, Score.getPreferredSize().height);
                
                revalidate();
                repaint();
            }
        });

        setLayout(null);
        add(BackPanel);
        add(Header);
        add(Level);
        add(Score);
        add(AutoWork);
        add(ClickButton);
        add(ClickerUpgrade);
        add(AutoUpgrade);
        AutoWorkingSystem.start();
        repaint();

        setVisible(true);
    }
    public JLabel MakeLabel(String text, int size, String font, int lx, int ly){
        JLabel Label = new JLabel(text, SwingConstants.CENTER);
        Label.setFont(new Font(font, Font.PLAIN, size));

        Dimension labelSize = Label.getPreferredSize();
        int labelWidth = labelSize.width;
        int labelHeight = labelSize.height;

        int x = (getWidth() - labelWidth) / 2 + lx;
        int y = ly;

        Label.setBounds(x, y, labelWidth, labelHeight);

        return Label;
    }
    public JButton MakeButton(String text, int sizeX, int sizeY, String font, int fontSize, int bx, int by){
        JButton button = new JButton(text);
        button.setFont(new Font(font, Font.PLAIN, fontSize));
        int x = (getWidth() - sizeX) / 2 + bx;
        int y = by;
        button.setBounds(x,y, sizeX,sizeY);
        
        return button;
    }
}