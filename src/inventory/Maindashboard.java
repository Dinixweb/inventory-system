package inventory;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.beans.PropertyChangeEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Maindashboard extends Login {
String cart;
static String[] myusername = { "Dennis", "Samson" };
static String[] mypassword = { "Maxiplus@001", "Skily@009" };

	private JPanel contentPane;
	
	static JLabel sales, product, category, customer, supplier, reports, inventoryTitle;

	/**
	 * Launch the application.
	 */
	private Image saleimg = new ImageIcon(Login.class.getResource("/res/sales.png")).getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	
	private Image productimg = new ImageIcon(Login.class.getResource("/res/product.png")).getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Maindashboard frame = new Maindashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Maindashboard() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		super();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 80, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

		JPanel nameDisplay = new JPanel();
		nameDisplay.setBounds(630, 7, 142, 38);
		contentPane.add(nameDisplay);
		nameDisplay.setLayout(null);

		JLabel userName = new JLabel();

			

		userName.setFont(new Font("Serif", Font.PLAIN, 17));
		userName.setBounds(10, 7, 122, 25);
		nameDisplay.add(userName);
		userName.setText("Hi, "+userlogin);


		JPanel panel_1 = new JPanel();
		panel_1.setBounds(450, 11, -135, 48);
		contentPane.add(panel_1);

		JPanel dateDisplay = new JPanel();
		dateDisplay.setBounds(494, 8, 151, 27);
		contentPane.add(dateDisplay);
		dateDisplay.setLayout(null);
		
	
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User 5\\Documents\\Software Egineering\\Java\\icons\\home.png"));
		lblNewLabel.setBounds(13, 1, 42, 40);
		contentPane.add(lblNewLabel);
		
		JLabel dashboad = new JLabel("Dashboard");
		dashboad.setFont(new Font("Arial", Font.PLAIN, 17));
		dashboad.setBounds(41, 11, 88, 27);
		contentPane.add(dashboad);
		
		JPanel salesButton = new JPanel();
		salesButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		salesButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
			salesButton.setBackground(SystemColor.inactiveCaption);
			sales.setForeground(new Color(0, 0, 128));
			
		
			
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				salesButton.setBackground(Color.BLUE);
				sales.setForeground(Color.CYAN);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
					Sales loadSales = null;
					try {
						loadSales = new Sales();
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
						loadSales.setVisible(true);
					}
					
				});
				
				
				
			}
		});
		salesButton.setCursor( new Cursor( Cursor.HAND_CURSOR));
		salesButton.setBackground(SystemColor.inactiveCaption);
		salesButton.setBounds(127, 189, 173, 76);
		contentPane.add(salesButton);
		salesButton.setLayout(null);
		
		sales = new JLabel("Sales");
		sales.setForeground(new Color(0, 0, 128));
		sales.setFont(new Font("SansSerif", Font.PLAIN, 16));
		sales.setBounds(57, 43, 46, 14);
		salesButton.add(sales);
		
		JLabel salesLogo = new JLabel("");
		salesLogo.setVerticalAlignment(SwingConstants.BOTTOM);
		salesLogo.setBounds(57, 17, 46, 14);
		salesButton.add(salesLogo);
		salesLogo.setIcon(new ImageIcon(saleimg));
		
		JPanel productButton = new JPanel();
		productButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		productButton.setBackground(SystemColor.inactiveCaption);
		productButton.setBounds(312, 189, 173, 76);
		contentPane.add(productButton);
		productButton.setLayout(null);
		productButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		productButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
			productButton.setBackground(SystemColor.inactiveCaption);
			product.setForeground(new Color(0, 0, 128));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				productButton.setBackground(Color.BLUE);
				product.setForeground(Color.CYAN);
			}
		});
		
		product = new JLabel("Products");
		product.setForeground(new Color(0, 0, 128));
		product.setFont(new Font("SansSerif", Font.PLAIN, 16));
		product.setBounds(52, 43, 70, 14);
		productButton.add(product);
		
		JLabel productIcon = new JLabel("");
		productIcon.setBounds(58, 17, 46, 14);
		productButton.add(productIcon);
		productIcon.setIcon(new ImageIcon(productimg));
		
		JPanel categoryButton = new JPanel();
		categoryButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		categoryButton.setBackground(SystemColor.inactiveCaption);
		categoryButton.setBounds(494, 189, 173, 76);
		contentPane.add(categoryButton);
		categoryButton.setLayout(null);
		
		categoryButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
			categoryButton.setBackground(SystemColor.inactiveCaption);
			category.setForeground(new Color(0, 0, 128));
			
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				categoryButton.setBackground(Color.BLUE);
				categoryButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				category.setForeground(Color.CYAN);
				
			}
		});
		
		category = new JLabel("Categories");
		category.setForeground(new Color(0, 0, 128));
		category.setFont(new Font("SansSerif", Font.PLAIN, 16));
		category.setBounds(38, 43, 84, 14);
		categoryButton.add(category);
		
		JPanel customerButton = new JPanel();
		customerButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		customerButton.setBackground(SystemColor.inactiveCaption);
		customerButton.setBounds(127, 277, 173, 76);
		contentPane.add(customerButton);
		customerButton.setLayout(null);
		customerButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
			customerButton.setBackground(SystemColor.inactiveCaption);
			customer.setForeground(new Color(0, 0, 128));
			
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				customerButton.setBackground(Color.BLUE);
				customerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				customer.setForeground(Color.CYAN);
				
			}
		});
		
		customer = new JLabel("Customers");
		customer.setForeground(new Color(0, 0, 128));
		customer.setFont(new Font("SansSerif", Font.PLAIN, 16));
		customer.setBounds(50, 41, 89, 14);
		customerButton.add(customer);
		
		JPanel suppliesButton = new JPanel();
		suppliesButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		suppliesButton.setBackground(SystemColor.inactiveCaption);
		suppliesButton.setBounds(312, 277, 173, 76);
		contentPane.add(suppliesButton);
		suppliesButton.setLayout(null);
		suppliesButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
			suppliesButton.setBackground(SystemColor.inactiveCaption);
			supplier.setForeground(new Color(0, 0, 128));
			
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				suppliesButton.setBackground(Color.BLUE);
				suppliesButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				supplier.setForeground(Color.CYAN);
				
			}
		});
		
		supplier = new JLabel("Suppliers");
		supplier.setForeground(new Color(0, 0, 131));
		supplier.setFont(new Font("SansSerif", Font.PLAIN, 16));
		supplier.setBounds(61, 36, 74, 21);
		suppliesButton.add(supplier);
		
		JPanel salereportButton = new JPanel();
		salereportButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		salereportButton.setBackground(SystemColor.inactiveCaption);
		salereportButton.setBounds(494, 277, 173, 76);
		contentPane.add(salereportButton);
		salereportButton.setLayout(null);
		salereportButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
			salereportButton.setBackground(SystemColor.inactiveCaption);
			reports.setForeground(new Color(0, 0, 128));
			
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				salereportButton.setBackground(Color.BLUE);
				salereportButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				reports.setForeground(Color.CYAN);
				
			}
		});
		
		reports = new JLabel("Sales Report");
		reports.setForeground(new Color(0, 0, 128));
		reports.setFont(new Font("SansSerif", Font.PLAIN, 16));
		reports.setBounds(35, 43, 102, 14);
		salereportButton.add(reports);
		
		inventoryTitle = new JLabel("i - INVENRORY ");
		inventoryTitle.setForeground(new Color(0, 0, 128));
		inventoryTitle.setFont(new Font("Spooky Regime", Font.PLAIN, 25));
		inventoryTitle.setBounds(311, 110, 158, 48);
		contentPane.add(inventoryTitle);
		
		
		}
	
	DateFormat df = DateFormat.getTimeInstance(DateFormat.LONG, new Locale("us"));
	String tm = df.format(new Date());
}
