package soph_part;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.Component;

public class GamesFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_game_title;
	private JTextField txt_game_title_delete_search;
	private JList<String> games_list_all_obj;
	private User current_user;
	private BufferedImage backgroundImage;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GamesFrame frame = new GamesFrame(null);
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
	public GamesFrame(User user) {
		 try {
	            backgroundImage = ImageIO.read(new File("src/img/games.jpg"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
		 this.current_user= user;//create user instance outside the button
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 682, 603);
	    contentPane = new MainPanel();  // Use the new MainPanel instead of a regular JPanel
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
	    panel.setBounds(0, 10, 668, 140);
	    contentPane.add(panel);
	    panel.setLayout(null);
	    panel.setOpaque(false);

	    JPanel panel_2 = new JPanel();
	    panel_2.setBounds(224, 24, 189, 68);
	    panel.add(panel_2);
	    panel_2.setLayout(null);
	    panel_2.setOpaque(false);

	    JLabel lblNewLabel = new JLabel("Game Vault");
	    lblNewLabel.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 25));
	    lblNewLabel.setForeground(Color.WHITE); 
	    lblNewLabel.setBounds(10, 10, 169, 48);
	    // Center the label horizontally
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
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
		panel_3.setBounds(0, 160, 668, 396);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setOpaque(false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 638, 376);
		panel_3.add(tabbedPane);
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Add Game", null, panel_7, null);
		tabbedPane.setEnabledAt(0, true);
		panel_7.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 52, 335, 119);
		panel_7.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Game Title");
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Perpetua", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 10, 105, 29);
		panel_4.add(lblNewLabel_1);
		
		txt_game_title = new JTextField();
		txt_game_title.setBounds(10, 46, 194, 29);
		panel_4.add(txt_game_title);
		txt_game_title.setColumns(10);
		
		JButton btn_add_game = new JButton("Add to Vault");
		
		btn_add_game.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gameTitle = txt_game_title.getText();
				Game game_obj = new Game(gameTitle);
				JOptionPane.showMessageDialog(null, "Added: "+gameTitle, "Time Complexity: O(1)", JOptionPane.INFORMATION_MESSAGE);
				current_user.addGameToLibrary(game_obj);
				System.out.print(current_user.getGamesLibrary());
				updateGamesInVault(current_user.getGamesLibrary());
			}
		});
		btn_add_game.setBounds(10, 85, 123, 21);
		panel_4.add(btn_add_game);
		
		JPanel panel_5 = new JPanel();
		panel_5.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_5.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		panel_5.setBounds(222, 10, 170, 32);
		panel_7.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New Game Entry");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(0, 0, 170, 29);
		panel_5.add(lblNewLabel_2);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setLayout(null);
		tabbedPane.addTab("Delete Game", null, panel_7_1, null);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBounds(10, 52, 297, 119);
		panel_7_1.add(panel_4_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Search Game Title");
		lblNewLabel_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Perpetua", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 10, 111, 29);
		panel_4_1.add(lblNewLabel_1_1);
		
		txt_game_title_delete_search = new JTextField();
		txt_game_title_delete_search.setColumns(10);
		txt_game_title_delete_search.setBounds(10, 46, 194, 29);
		panel_4_1.add(txt_game_title_delete_search);
		
		JButton btn_delete_game_search = new JButton("Unvault");
		btn_delete_game_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String game_title = txt_game_title_delete_search.getText();
				Stack<Game> games_list = current_user.getGamesLibrary();
				Iterator<Game> iterator = games_list.iterator();
				
				while (iterator.hasNext()) {
					Game game = iterator.next();
					if (game.getTitle().equals(game_title)) {
						JOptionPane.showMessageDialog(null, "Removed: "+game.getTitle().toString(), "Time Complexity: O(n)!", JOptionPane.WARNING_MESSAGE);
		                iterator.remove();
		            }
				}
				updateGamesInVault(games_list);
			}
		});
		btn_delete_game_search.setBounds(10, 85, 119, 24);
		panel_4_1.add(btn_delete_game_search);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panel_5_1.setAlignmentY(0.0f);
		panel_5_1.setAlignmentX(0.0f);
		panel_5_1.setBounds(222, 10, 170, 32);
		panel_7_1.add(panel_5_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Delete Game Entry");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(0, 0, 170, 29);
		panel_5_1.add(lblNewLabel_2_1);
		
		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setLayout(null);
		panel_4_1_1.setBounds(326, 52, 297, 119);
		panel_7_1.add(panel_4_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Remove Previous Game");
		lblNewLabel_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("Perpetua", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(10, 10, 144, 29);
		panel_4_1_1.add(lblNewLabel_1_1_1);
		
		JButton btn_delete_game = new JButton("Unvault");
		btn_delete_game.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stack<Game> game_list = current_user.getGamesLibrary();
				if(!game_list.isEmpty()) {
					Game removedGame = game_list.pop();
					JOptionPane.showMessageDialog(null, "Removed: "+removedGame.getTitle().toString(), "Time Complexity: O(1)!", JOptionPane.WARNING_MESSAGE);
					updateGamesInVault(game_list);
					}
			}
		});
		btn_delete_game.setBounds(10, 46, 194, 29);
		panel_4_1_1.add(btn_delete_game);
		
		JPanel panel_7_1_1 = new JPanel();
		panel_7_1_1.setLayout(null);
		tabbedPane.addTab("Games in the Vault", null, panel_7_1_1, null);
		
		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setLayout(null);
		panel_5_1_1.setAlignmentY(0.0f);
		panel_5_1_1.setAlignmentX(0.0f);
		panel_5_1_1.setBounds(222, 10, 170, 32);
		panel_7_1_1.add(panel_5_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Explore Games");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(0, 0, 170, 29);
		panel_5_1_1.add(lblNewLabel_2_1_1);
		
		
		games_list_all_obj = new JList<>(); //list of games by the user
		JScrollPane scrollPane = new JScrollPane(games_list_all_obj);
		scrollPane.setBounds(10, 52, 613, 287);
		panel_7_1_1.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		int centerX = (panel.getWidth() - panel_1.getWidth()) / 2;
        int centerY = (panel.getHeight() - panel_1.getHeight()) / 2;

        
        panel_1.setBounds(centerX, centerY, 200, 100);
		
		
	}

	
	public void updateGamesInVault(Stack<Game> games) {
        DefaultListModel<String> gameListModel = new DefaultListModel<>();
        for (Game game : games) {
            gameListModel.addElement(game.getTitle());
        }
        games_list_all_obj.setModel(gameListModel);
    }
	class MainPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
	}
}
