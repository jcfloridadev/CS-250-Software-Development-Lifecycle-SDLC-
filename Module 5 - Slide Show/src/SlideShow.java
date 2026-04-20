/*
 * SNHU Travel - Slide Show Project
 * Developer: Justin Carlo Florida
 * Module 5 update: Revised the original destination slideshow to match
 * the Product Owner's new detox and wellness travel requirements.
 */

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/*
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/*
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(new Color(30, 30, 30)); // Changed text panel to a dark color to create a calmer wellness theme and improve readability
		
		// Adjusted bounds to properly align and span the full width of the window.
		textPane.setBounds(0, 473, 800, 60); // The original layout appeared misaligned, so this ensures a cleaner and seamless text display.
		
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Detox & Wellness Destinations SlideShow"); // Updated the window title to reflect the new detox and wellness slideshow focus
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		// Creates five slideshow cards by pairing each destination image with its matching wellness description
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblTextArea.setForeground(Color.WHITE); // Set description text to white for better contrast against the dark background
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/*
	 * Moves the slideshow and description panel to the previous destination.
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Moves the slideshow and description panel to the next destination.
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/*
	 * Returns the image path for each detox and wellness destination slide.
	 * These images were updated to match the Product Owner's new travel theme.
	 */
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){ // Tokyo slide uses a hot spring image to represent relaxation, healing, and traditional wellness
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/TokyoJapanNaturalSpring.png") + "'</body></html>";
		} else if (i==2){ // San Francisco slide highlights outdoor biking activity to promote an active and balanced wellness lifestyle
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/SanFranciscoUsa.jpg") + "'</body></html>";
		} else if (i==3){ // Paris slide highlights a yoga session near the Eiffel Tower to represent mindfulness and urban wellness
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/ParisFrance.jpg") + "'</body></html>";
		} else if (i==4){ // Alicante slide features a relaxing coastal view to emphasize beachside wellness and stress relief
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/AlicanteSpain.jpg") + "'</body></html>";
		} else if (i==5){ // El Nido slide showcases a tropical wellness retreat with nature, meditation, and spa experiences
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/ElNidoPhilippines.png") + "'</body></html>";
		}
		return image;
	}
	
	/*
	 * Returns the updated text description for each destination.
	 * The descriptions were rewritten to focus on detox, relaxation, and wellness travel.
	 * 
	 * Added padding to the text description using HTML styling to improve readability.
	 * This creates spacing on the left and right sides so the text does not appear too close to the edges.
	 */
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){
			text = "<html><body style='padding: 10px 48px;'><font size='5'>#1 Tokyo, Japan.</font> <br>Relax in traditional hot spring (onsen) baths with breathtaking views of Mount Fuji,"
					+ " offering a peaceful escape focused on relaxation, healing, and rejuvenation. (Image credit: Yamanashi Tourism Organization)</body></html>";
		} else if (i==2){
			text = "<html><body style='padding: 10px 48px;'><font size='5'>#2 San Francisco, USA.</font> <br>Enjoy refreshing outdoor activities like biking along the Golden Gate Bridge, "
					+ "combining scenic views, fresh coastal air, and an active lifestyle for a balanced wellness experience. "
					+ "(Image credit: Isango.com)</body></html>";
		} else if (i==3){
			text = "<html><body style='padding: 10px 48px;'><font size='5'>#3 Paris, France.</font> <br>Experience peaceful yoga sessions near iconic landmarks, blending mindfulness, movement,"
					+ " and scenic beauty for a rejuvenating urban wellness retreat. (Image credit: Pictoursparis, Taney Creative) </body></html>";
		} else if (i==4){
			text = "<html><body style='padding: 10px 48px;'><font size='5'>#4 Alicante, Spain.</font> <br>Unwind along the Mediterranean coast with relaxing beach views, "
					+ "fresh sea air, and tranquil surroundings that promote stress relief and overall well-being. (Image Credit: Cadence Travel) </body></html>";
		} else if (i==5){
			text = "<html><body style='padding: 10px 48px;'><font size='5'>#5 El Nido, Philippines.</font> <br>Immerse yourself in a tropical wellness retreat with beachfront relaxation, "
					+ "guided meditation, and rejuvenating spa treatments surrounded by nature. (Image credit: @thefarmatsanbenito) </body></html>";
		}
		return text;
	}
	
	/*
	 * Launches the updated slideshow application with the revised detox and wellness features.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}