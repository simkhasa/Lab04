import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    // attributes
    JPanel mainPanel, iconPanel, displayPanel, controlPanel;
    JButton getFortuneButton, quitButton;
    JLabel titleLabel;
    ImageIcon icon;
    JTextArea displayArea;
    JScrollPane scroller;

    ArrayList<String> fortunes = new ArrayList<String>();
    int oldFortune = -1;
    int newFortune = 0;
    Random FortuneGenerator = new Random();

    Toolkit tookit;
    Dimension screenSize;
    int screenHeight;
    int screenWidth;



    // constructor
    public FortuneTellerFrame() {

        createFortunes();

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        createIconPanel();
        mainPanel.add(iconPanel, BorderLayout.NORTH);

        createDisplayPanel();
        mainPanel.add(displayPanel, BorderLayout.CENTER);

        controlPanel();
        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // get screen dimensions
        tookit = Toolkit.getDefaultToolkit();
        screenSize = tookit.getScreenSize();
        screenHeight = screenSize.height;
        screenWidth = screenSize.width;

        //center frame in screen
        setSize(screenWidth*3/4, screenHeight*3/4);
        setLocation((screenWidth-getWidth())/2, (screenHeight-getHeight())/2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //methods
    private void createIconPanel() {
        iconPanel = new JPanel();
        icon = new ImageIcon("src//FortuneTeller.jpg");
        titleLabel = new JLabel("The Fortune Teller", icon, JLabel.CENTER);
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
        // align the text and the icon
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);

        iconPanel.add(titleLabel);
    }


    public void createDisplayPanel() {
        displayPanel = new JPanel();
        displayArea = new JTextArea(16, 50);
        displayArea.setFont(new Font("times new roman", Font.PLAIN, 12));
        displayArea.setEditable(false);

        scroller = new JScrollPane(displayArea);
        displayPanel.add(scroller);
    }

    public void controlPanel() {
        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 2));
        controlPanel.setBorder(new EmptyBorder(10, 50, 30, 50));

        getFortuneButton = new JButton("Get Fortune");
        getFortuneButton.setFont(new Font("Arial", Font.BOLD, 18));
        getFortuneButton.setMargin(new Insets(10, 20, 20, 20));
        getFortuneButton.addActionListener((ActionEvent e) -> {
            do {
                newFortune = FortuneGenerator.nextInt(fortunes.size());
            } while (newFortune == oldFortune);
            displayArea.append(fortunes.get(newFortune) + "\n");
            oldFortune = newFortune;
        });

        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Arial", Font.BOLD, 18));
        quitButton.setMargin(new Insets(10, 20, 10, 20));
        quitButton.addActionListener((ActionEvent ae) -> System.exit(0));

        controlPanel.add(getFortuneButton);
        controlPanel.add(quitButton);
    }

    private void createFortunes() {
        fortunes.add("Good things come to those who wait, but you might have to wait a bit longer than expected.");
        fortunes.add("Your future is bright.");
        fortunes.add("Someone will soon tell you a secret, but it will only lead to confusion and more questions.");
        fortunes.add("A new opportunity will come your way, disguised as hard work.");
        fortunes.add("A major decision is on the horizon; flip a coin and hope for the best!");
        fortunes.add("Your lucky number is 4.");
        fortunes.add("A new friend will come into your life.");
        fortunes.add("You will have a great day.");
        fortunes.add("Your future will be filled with happiness, and a lot of pizza.");
        fortunes.add("Your life will be filled with love, and a few awkward moments.");
        fortunes.add("Sending you good vibes and positive energy—good luck on all your endeavors.");
        fortunes.add("You will find money on the road.");
    }
}