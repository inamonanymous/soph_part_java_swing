package soph_part;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class AchievementsFrame extends JFrame {
	private BufferedImage backgroundImage;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private User user_obj; // Add a field to store the user object
    private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AchievementsFrame frame = new AchievementsFrame(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AchievementsFrame(User user) {
		this.user_obj = user;
        try {
            backgroundImage = ImageIO.read(new File("src/img/achievements.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 682, 603);
        contentPane = new AchievementsMainPanel(); // Use the new AchievementsMainPanel instead of a regular JPanel
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 668, 556);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setOpaque(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 668, 140);
		panel.add(panel_1);
		panel_1.setOpaque(false);
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(224, 24, 189, 68);
		panel_2.setOpaque(false);
		panel_1.add(panel_2);
		
		
		JLabel lblNewLabel = new JLabel("Milestones");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK); 
		lblNewLabel.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 10, 169, 48);
		panel_2.add(lblNewLabel);
		
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.setBounds(10, 10, 91, 36);
		panel.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JPanel panel_7_1_1 = new JPanel();
		panel_7_1_1.setLayout(null);
		panel_7_1_1.setBounds(0, 134, 668, 422);
		panel.add(panel_7_1_1);
		panel_7_1_1.setOpaque(false);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 35, 648, 364);
		panel_7_1_1.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setOpaque(false);
		
		scrollPane = new JScrollPane();
	    scrollPane.setBounds(10, 10, 628, 341);
	    panel_3.add(scrollPane);
	    
	    JLabel lblNewLabel_2_1_1 = new JLabel("My Achievements");
	    lblNewLabel_2_1_1.setForeground(Color.BLACK); 
	    lblNewLabel_2_1_1.setBounds(226, 10, 185, 29);
	    panel_7_1_1.add(lblNewLabel_2_1_1);
	    lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_2_1_1.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 18));
		
		updateAchievements();
	}

	public void updateAchievements() {
	    // Create a panel to hold the game levels
	    JPanel gameLevelsPanel = new JPanel();
	    gameLevelsPanel.setLayout(null);

	    // Get the user's game library
	    Stack<Game> userGameLibrary = this.user_obj.getGamesLibrary();

	    int i = 1;
	    for (Game game : userGameLibrary) {
	    	// Get the level of the game
	        int level = game.getLevel();
	        String title = game.getTitle();
	        // Create a label to display the level
	        JLabel levelLabel = new JLabel(i+". ("+title+") -> Level: " + level);
	        levelLabel.setBounds(10, 10 + (i-1) * 30, 500, 25);
	        gameLevelsPanel.add(levelLabel);

	        i++;
	    }

	    gameLevelsPanel.setPreferredSize(new Dimension(628, (i-1) * 30 + 30)); // Adjust the width and height

	    // Remove the old content from the scroll pane
	    scrollPane.getViewport().removeAll();
	    scrollPane.setRowHeaderView(gameLevelsPanel);

	    // Repaint the scroll pane to update the view
	    scrollPane.revalidate();
	    scrollPane.repaint();
	}
	class AchievementsMainPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }	
}
