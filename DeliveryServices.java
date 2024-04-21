package event.manager.ms3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author sadaf
 */
public class DeliveryServices extends JFrame {
    private JPanel mainPanel;
    private JPanel scene1;
    private JPanel scene2;
    private JPanel scene3;
    private JPanel scene4;

    public DeliveryServices() {
        
        setTitle("Scene Switcher");
        
        mainPanel = new JPanel(new CardLayout());

      
        scene1 = createScene("Scene 1", "Switch to Scene 2", "Scene2");
        scene2 = createScene("Scene 2", "Switch to Scene 3", "Scene3");
        scene3 = createScene("Scene 3", "Switch to Scene 4", "Scene4");
        scene4 = createScene("Scene 4", "Switch to Scene 1", "Scene1");

        
        mainPanel.add(scene1, "Scene1");
        mainPanel.add(scene2, "Scene2");
        mainPanel.add(scene3, "Scene3");
        mainPanel.add(scene4, "Scene4");

        
        add(mainPanel);

        
        setVisible(true);
    }

  
    private JPanel createScene(String labelText, String buttonText, String nextSceneKey) {
        JPanel panel = new JPanel(new BorderLayout());

       
        JLabel label = new JLabel(labelText, SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

       
        JButton switchButton = new JButton(buttonText);
        panel.add(switchButton, BorderLayout.SOUTH);

       
        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the specified scene using CardLayout
                CardLayout layout = (CardLayout) mainPanel.getLayout();
                layout.show(mainPanel, nextSceneKey);
            }
        });

        return panel;
    }

    
    public static void main(String[] args) {
        new DeliveryServices();
    }
}