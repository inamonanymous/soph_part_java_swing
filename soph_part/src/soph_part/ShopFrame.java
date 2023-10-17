package soph_part;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ShopFrame extends JFrame {
	private BufferedImage backgroundImage;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private User current_user;
	private Shop shop_obj;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopFrame frame = new ShopFrame(null, null);
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
	public ShopFrame(User user, Shop shop) {
		this.current_user = user;
		this.shop_obj = shop;
		ArrayList<Game> shopGamesList = shop_obj.getShopGamesLibrary();
		ArrayList<String> userGamesList = new ArrayList<>();
		
		try {
	        BufferedImage backgroundImage = ImageIO.read(new File("src/img/shops.jpg"));
	        contentPane = new MainPanel(backgroundImage);
	        contentPane = new MainPanel(backgroundImage);
	    } catch (IOException e) {
	        e.printStackTrace();
	        contentPane = new JPanel(); // Default to a regular JPanel if the image load fails
	    }
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 682, 603);
	     // Use a regular JPanel
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	    contentPane.setOpaque(false);
		
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
		
		JLabel lblNewLabel = new JLabel("Store");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 25));
		lblNewLabel.setForeground(Color.WHITE); 
		lblNewLabel.setBounds(10, 10, 169, 48);
		panel_2.add(lblNewLabel);
		
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_3.setBounds(10, 10, 91, 36);
		panel.add(btnNewButton_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 150, 319, 396);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		
		JPanel gamePanel = new JPanel();
		gamePanel.setLayout(null);
		
		int i = 0;
		for (Game game : shopGamesList) {
		    JLabel newLabel = new JLabel(game.getTitle());
		    newLabel.setBounds(10, 10 + (i * 30), 200, 25);
		    gamePanel.add(newLabel);

		    JButton buyButton = new JButton("Buy");
		    buyButton.setBounds(200, 10 + (i * 30), 80, 25);
		    gamePanel.add(buyButton);

		    final int gameIndex = i; // Capture the current game index
		    buyButton.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		            // Get the selected game from the shop
		            Game selectedGame = shop_obj.getShopGamesLibrary().get(gameIndex);

		            // Add the selected game to the user's game library
		            current_user.addGameToLibrary(selectedGame);
		            JOptionPane.showMessageDialog(null, "Bought: "+selectedGame.getTitle().toString(), "Time Complexity: O(n)!", JOptionPane.INFORMATION_MESSAGE);
		            // Remove the purchased game from the shop's game library
		            shop_obj.getShopGamesLibrary().remove(gameIndex);

		            // Refresh the display to reflect the changes (you may need to recreate the entire ShopFrame)
		            dispose();
                    new ShopFrame(current_user, shop_obj).setVisible(true);
		        }
		    });
		    
		    i++;
		}
		gamePanel.setPreferredSize(new Dimension(289, i * 30 + 30)); // Adjust the width and height
		//scrollpane for games
		JScrollPane scrollPane = new JScrollPane(gamePanel);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 53, 299, 333);
		panel_3.add(scrollPane);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Browse from Store");
		lblNewLabel_1.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 10, 299, 34);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(339, 150, 319, 396);
		panel.add(panel_3_1);
		
		for (Game game : current_user.getGamesLibrary()) {
		    userGamesList.add(game.getTitle());
		}
		
		JList<String> userGameList = new JList<>(userGamesList.toArray(new String[0]));
		JScrollPane scrollPane_1 = new JScrollPane(userGameList);
		scrollPane_1.setBounds(10, 52, 299, 334);
		panel_3_1.add(scrollPane_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("My Vault");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 10, 299, 34);
		panel_3_1.add(lblNewLabel_1_1);
	}
	
	private void handleBuyButton(Game game) {
        // Add the selected game to the user's library
        current_user.addGameToLibrary(game);
    }
	class MainPanel extends JPanel {
	    private BufferedImage backgroundImage;

	    public MainPanel(BufferedImage backgroundImage) {
	        this.backgroundImage = backgroundImage;
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        if (backgroundImage != null) {
	            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	        }
	    }
	}
}

