package inventory;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.MessageFormat;

import javax.swing.border.MatteBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.BevelBorder;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;

public class Sales extends JFrame {

	private JPanel contentPane, displayInner;

	String pName;
	int pQTY;
	double pAmount;
	double pEach;

	String[] paymentMethod = { "Cash", "Card", "Coupon" };

	// Object[][] salesList={};

	DefaultTableModel model = new DefaultTableModel();
	Object[] salesTbl = { "Name", "QTY", "Each", "Amount" };

	private JTextField subTotalOut;
	private JTextField vatOut;
	private JTextField gTotalOut;
	private JTextField amoutPaidBox;
	private JTextField balanceBox;
	private JTable tableDisplay;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sales frame = new Sales();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public Sales() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 100, 800, 500);
		setTitle("i Inventory:Sales");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

		JPanel panel = new JPanel();
		panel.setBounds(764, 11, -90, 77);
		contentPane.add(panel);

		JPanel productHolderOuter = new JPanel();
		productHolderOuter.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		productHolderOuter.setBackground(new Color(30, 144, 255));
		productHolderOuter.setBounds(324, 11, 450, 439);
		contentPane.add(productHolderOuter);
		productHolderOuter.setLayout(null);

		JPanel inputMoney = new JPanel();
		inputMoney.setBackground(new Color(30, 144, 255));
		inputMoney.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		inputMoney.setBounds(10, 327, 228, 101);
		productHolderOuter.add(inputMoney);
		inputMoney.setLayout(null);

		JLabel CashPaid = new JLabel("Amount");
		CashPaid.setFont(new Font("Tahoma", Font.BOLD, 13));
		CashPaid.setBounds(10, 42, 66, 14);
		inputMoney.add(CashPaid);

		JLabel payMethod = new JLabel("Pay Method");
		payMethod.setFont(new Font("Tahoma", Font.BOLD, 13));
		payMethod.setBounds(10, 11, 87, 14);
		inputMoney.add(payMethod);

		JLabel balanceR = new JLabel("Balance");
		balanceR.setFont(new Font("Tahoma", Font.BOLD, 13));
		balanceR.setBounds(10, 77, 87, 14);
		inputMoney.add(balanceR);

		comboBox = new JComboBox(paymentMethod);
		comboBox.setBounds(107, 8, 111, 28);
		inputMoney.add(comboBox);

		amoutPaidBox = new JTextField();
		amoutPaidBox.setColumns(10);
		amoutPaidBox.setBounds(107, 40, 111, 25);
		inputMoney.add(amoutPaidBox);

		balanceBox = new JTextField();
		balanceBox.setColumns(10);
		balanceBox.setBounds(107, 70, 111, 25);
		inputMoney.add(balanceBox);

		JPanel userInput = new JPanel();
		userInput.setBackground(new Color(30, 144, 255));
		userInput.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		userInput.setBounds(246, 11, 194, 305);
		productHolderOuter.add(userInput);
		userInput.setLayout(null);

		JButton one = new JButton("1");
		one.setForeground(new Color(255, 255, 240));
		one.setBackground(new Color(0, 0, 128));
		one.setFont(new Font("Tahoma", Font.BOLD, 15));
		one.setBounds(10, 196, 50, 50);
		userInput.add(one);
		one.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String valueEntered = amoutPaidBox.getText();
				if (valueEntered == "") {
					amoutPaidBox.setText(one.getText());
				} else {
					valueEntered = amoutPaidBox.getText() + one.getText();
					amoutPaidBox.setText(valueEntered);

				}

			}

		});

		JButton three = new JButton("3");
		three.setForeground(new Color(255, 255, 240));
		three.setBackground(new Color(0, 0, 128));
		three.setFont(new Font("Tahoma", Font.BOLD, 15));
		three.setBounds(134, 195, 50, 50);
		userInput.add(three);
		three.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String valueEntered = amoutPaidBox.getText();
				if (valueEntered == "") {
					amoutPaidBox.setText(three.getText());
				} else {
					valueEntered = amoutPaidBox.getText() + three.getText();
					amoutPaidBox.setText(valueEntered);

				}

			}

		});

		JButton two = new JButton("2");
		two.setForeground(new Color(255, 255, 240));
		two.setBackground(new Color(0, 0, 128));
		two.setFont(new Font("Tahoma", Font.BOLD, 15));
		two.setBounds(73, 196, 50, 50);
		userInput.add(two);
		two.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String valueEntered = amoutPaidBox.getText();
				if (valueEntered == "") {
					amoutPaidBox.setText(two.getText());
				} else {
					valueEntered = amoutPaidBox.getText() + two.getText();
					amoutPaidBox.setText(valueEntered);

				}

			}

		});

		JButton six = new JButton("6");
		six.setForeground(new Color(255, 255, 240));
		six.setBackground(new Color(0, 0, 128));
		six.setFont(new Font("Tahoma", Font.BOLD, 15));
		six.setBounds(134, 134, 50, 50);
		userInput.add(six);
		six.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String valueEntered = amoutPaidBox.getText();
				if (valueEntered == "") {
					amoutPaidBox.setText(six.getText());
				} else {
					valueEntered = amoutPaidBox.getText() + six.getText();
					amoutPaidBox.setText(valueEntered);

				}

			}

		});

		JButton five = new JButton("5");
		five.setForeground(new Color(255, 255, 240));
		five.setBackground(new Color(0, 0, 128));
		five.setFont(new Font("Tahoma", Font.BOLD, 15));
		five.setBounds(73, 135, 50, 50);
		userInput.add(five);
		five.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String valueEntered = amoutPaidBox.getText();
				if (valueEntered == "") {
					amoutPaidBox.setText(five.getText());
				} else {
					valueEntered = amoutPaidBox.getText() + five.getText();
					amoutPaidBox.setText(valueEntered);

				}

			}

		});

		JButton four = new JButton("4");
		four.setForeground(new Color(255, 255, 240));
		four.setBackground(new Color(0, 0, 128));
		four.setFont(new Font("Tahoma", Font.BOLD, 15));
		four.setBounds(10, 135, 50, 50);
		userInput.add(four);
		four.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String valueEntered = amoutPaidBox.getText();
				if (valueEntered == "") {
					amoutPaidBox.setText(four.getText());
				} else {
					valueEntered = amoutPaidBox.getText() + four.getText();
					amoutPaidBox.setText(valueEntered);

				}

			}

		});

		JButton nine = new JButton("9");
		nine.setForeground(new Color(255, 255, 240));
		nine.setBackground(new Color(0, 0, 128));
		nine.setFont(new Font("Tahoma", Font.BOLD, 15));
		nine.setBounds(134, 72, 50, 50);
		userInput.add(nine);
		nine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String valueEntered = amoutPaidBox.getText();
				if (valueEntered == "") {
					amoutPaidBox.setText(nine.getText());
				} else {
					valueEntered = amoutPaidBox.getText() + nine.getText();
					amoutPaidBox.setText(valueEntered);

				}

			}

		});

		JButton eight = new JButton("8");
		eight.setForeground(new Color(255, 255, 240));
		eight.setBackground(new Color(0, 0, 128));
		eight.setFont(new Font("Tahoma", Font.BOLD, 15));
		eight.setBounds(73, 73, 50, 50);
		userInput.add(eight);
		eight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String valueEntered = amoutPaidBox.getText();
				if (valueEntered == "") {
					amoutPaidBox.setText(eight.getText());
				} else {
					valueEntered = amoutPaidBox.getText() + eight.getText();
					amoutPaidBox.setText(valueEntered);

				}

			}

		});

		JButton seven = new JButton("7");
		seven.setForeground(new Color(255, 255, 240));
		seven.setBackground(new Color(0, 0, 128));
		seven.setFont(new Font("Tahoma", Font.BOLD, 15));
		seven.setBounds(10, 73, 50, 50);
		userInput.add(seven);
		seven.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String valueEntered = amoutPaidBox.getText();
				if (valueEntered == "") {
					amoutPaidBox.setText(seven.getText());
				} else {
					valueEntered = amoutPaidBox.getText() + seven.getText();
					amoutPaidBox.setText(valueEntered);

				}

			}

		});

		JButton trippleZero = new JButton("000");
		trippleZero.setForeground(new Color(255, 255, 240));
		trippleZero.setBackground(new Color(0, 0, 128));
		trippleZero.setFont(new Font("Tahoma", Font.BOLD, 15));
		trippleZero.setBounds(73, 11, 111, 50);
		userInput.add(trippleZero);
		trippleZero.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String valueEntered = amoutPaidBox.getText();
				if (valueEntered == "") {
					amoutPaidBox.setText(trippleZero.getText());
				} else {
					valueEntered = amoutPaidBox.getText() + trippleZero.getText();
					amoutPaidBox.setText(valueEntered);

				}

			}

		});

		JButton zero = new JButton("0");
		zero.setForeground(new Color(255, 255, 240));
		zero.setBackground(new Color(0, 0, 128));
		zero.setFont(new Font("Tahoma", Font.BOLD, 15));
		zero.setBounds(10, 11, 50, 50);
		userInput.add(zero);
		zero.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String valueEntered = amoutPaidBox.getText();
				if (valueEntered == "") {
					amoutPaidBox.setText(zero.getText());
				} else {
					valueEntered = amoutPaidBox.getText() + zero.getText();
					amoutPaidBox.setText(valueEntered);

				}

			}

		});

		JButton btnC = new JButton("C");
		btnC.setForeground(new Color(255, 255, 240));
		btnC.setBackground(new Color(0, 0, 128));
		btnC.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnC.setBounds(10, 255, 174, 39);
		userInput.add(btnC);
		btnC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				amoutPaidBox.setText("");
				balanceBox.setText("");

			}

		});

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3_1.setBackground(new Color(30, 144, 255));
		panel_3_1.setBounds(248, 327, 192, 101);
		productHolderOuter.add(panel_3_1);
		panel_3_1.setLayout(null);

		JButton btnPay = new JButton("Pay");
		btnPay.setForeground(Color.WHITE);
		btnPay.setBackground(Color.DARK_GRAY);
		btnPay.setBounds(10, 11, 82, 32);
		panel_3_1.add(btnPay);
		btnPay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				balanceAfterPayment();
			}

		});

		JButton btnPrint = new JButton("Print");
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setBackground(Color.DARK_GRAY);
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat("Plot 6171, Lugbe Abuja \n i-Inventory Management");
				MessageFormat footer = new MessageFormat("Sub Total: " + subTotalOut.getText() + "\n" + "VAT: "
						+ vatOut.getText() + "\n" + "Grand Total: " + gTotalOut.getText());

				try {
					tableDisplay.print(JTable.PrintMode.NORMAL, header, footer);

				} catch (java.awt.print.PrinterException f) {
					System.err.format("No Printer Found", f.getMessage());
				}
			}
		});
		btnPrint.setBounds(100, 11, 82, 32);
		panel_3_1.add(btnPrint);

		JFrame frame;
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFrame frame = new JFrame();
				if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit", "warning",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {

					System.exit(0);
				}

			}
		});
		btnExit.setBounds(100, 54, 82, 32);
		panel_3_1.add(btnExit);

		JButton btnRemove = new JButton("Remove");
		btnRemove.setForeground(Color.WHITE);
		btnRemove.setBackground(Color.DARK_GRAY);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteItem();
			}
		});
		btnRemove.setBounds(10, 54, 82, 32);
		panel_3_1.add(btnRemove);

		JPanel productContainer = new JPanel();
		productContainer.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		productContainer.setBackground(new Color(30, 144, 255));
		productContainer.setBounds(10, 11, 228, 304);
		productHolderOuter.add(productContainer);

		JButton btnProduct = new JButton("Fried Rice");
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 500;

				model.addRow(new Object[] { "Fried Rice", "1", itemPrice, itemPrice });

				orderCost();

			}
		});
		btnProduct.setBounds(15, 11, 94, 38);
		productContainer.add(btnProduct);

		JButton btnJollofrice = new JButton("Jollof Rice");
		btnJollofrice.setBounds(116, 11, 94, 38);
		productContainer.add(btnJollofrice);
		btnJollofrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 500;

				model.addRow(new Object[] { "Jollof Rice", "1", itemPrice, itemPrice });

				orderCost();

			}
		});

		JButton Chicken = new JButton("Chicken");
		Chicken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 700;

				model.addRow(new Object[] { "Chicken", "1", itemPrice, itemPrice });

				orderCost();

			}
		});
		Chicken.setBounds(15, 57, 94, 34);
		productContainer.add(Chicken);

		JButton Fish = new JButton("Fish");
		Fish.setBounds(116, 57, 94, 34);
		productContainer.add(Fish);
		Fish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 600;

				model.addRow(new Object[] { "Fish", "1", itemPrice, itemPrice });

				orderCost();

			}
		});

		JButton Assorted = new JButton("Assorted");
		Assorted.setBounds(16, 99, 94, 34);
		productContainer.add(Assorted);
		Assorted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 1000;

				model.addRow(new Object[] { "Assorted", "1", itemPrice, itemPrice });

				orderCost();

			}
		});

		JButton PoundedYam = new JButton("Pounded Yam");
		PoundedYam.setBounds(117, 99, 94, 34);
		productContainer.add(PoundedYam);
		PoundedYam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 600;

				model.addRow(new Object[] { "Pounded Yam", "1", itemPrice, itemPrice });

				orderCost();

			}
		});

		JButton Semo = new JButton("Semo");
		Semo.setBounds(16, 142, 94, 34);
		productContainer.add(Semo);
		Semo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 400;

				model.addRow(new Object[] { "Semo", "1", itemPrice, itemPrice });

				orderCost();

			}
		});

		JButton Amala = new JButton("Amala");
		Amala.setBounds(117, 142, 94, 34);
		productContainer.add(Amala);
		Amala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 500;

				model.addRow(new Object[] { "Amala", "1", itemPrice, itemPrice });

				orderCost();

			}
		});

		JButton Eba = new JButton("Eba");
		Eba.setBounds(16, 182, 94, 34);
		productContainer.add(Eba);
		Eba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 400;

				model.addRow(new Object[] { "Eba", "1", itemPrice, itemPrice });

				orderCost();

			}
		});

		JButton Wheat = new JButton("Wheat");
		Wheat.setBounds(117, 182, 94, 34);
		productContainer.add(Wheat);
		Wheat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 500;

				model.addRow(new Object[] { "Wheat", "1", itemPrice, itemPrice });

				orderCost();

			}
		});

		JButton Egusi = new JButton("Egusi");
		Egusi.setBounds(117, 223, 94, 34);
		productContainer.add(Egusi);
		Egusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 400;

				model.addRow(new Object[] { "Egusi", "1", itemPrice, itemPrice });

				orderCost();

			}
		});

		JButton WhiteSoup = new JButton("White Soup");
		WhiteSoup.setBounds(117, 262, 94, 34);
		productContainer.add(WhiteSoup);
		WhiteSoup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 800;

				model.addRow(new Object[] { "White Soup", "1", itemPrice, itemPrice });

				orderCost();

			}
		});

		JButton Oha = new JButton("Oha");
		Oha.setBounds(117, 302, 94, 34);
		productContainer.add(Oha);
		Oha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 500;

				model.addRow(new Object[] { "Oha", "1", itemPrice, itemPrice });

				orderCost();

			}
		});

		JButton Affang = new JButton("Affang");
		Affang.setBounds(16, 223, 94, 34);
		productContainer.add(Affang);
		Affang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 600;

				model.addRow(new Object[] { "Affang", "1", itemPrice, itemPrice });

				orderCost();

			}
		});

		JButton Okro = new JButton("Okro");
		Okro.setBounds(16, 262, 94, 34);
		productContainer.add(Okro);
		Okro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 400;

				model.addRow(new Object[] { "Okro", "1", itemPrice, itemPrice });

				orderCost();

			}
		});
		productContainer.add(Okro);

		JButton Merinda = new JButton("Merinda");
		Merinda.setBounds(16, 302, 94, 34);
		productContainer.add(Merinda);
		Merinda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 150;

				model.addRow(new Object[] { "Merinda", "1", itemPrice, itemPrice });

				orderCost();

			}
		});

		JButton Pepsi = new JButton("Pepsi");
		productContainer.add(Pepsi);
		Pepsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 150;

				model.addRow(new Object[] { "Pepsi", "1", itemPrice, itemPrice });

				orderCost();

			}
		});

		JButton Monster = new JButton("Monster");
		productContainer.add(Monster);
		Monster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 300;

				model.addRow(new Object[] { "Monster", "1", itemPrice, itemPrice });

				orderCost();

			}
		});

		JButton Water = new JButton("Water");
		productContainer.add(Water);
		Water.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 150;

				model.addRow(new Object[] { "Water", "1", itemPrice, itemPrice });

				orderCost();

			}
		});

		JButton Sprite50 = new JButton("Sprite 50Cl");
		productContainer.add(Sprite50);
		Sprite50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 200;

				model.addRow(new Object[] { "Sprite 50CL", "1", itemPrice, itemPrice });

				orderCost();

			}
		});

		JButton Fanta50 = new JButton("Fanta 50CL");
		productContainer.add(Fanta50);
		Fanta50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 200;

				model.addRow(new Object[] { "Fanta 50CL", "1", itemPrice, itemPrice });

				orderCost();

			}
		});

		JButton Coke50 = new JButton("50CL Coke");
		productContainer.add(Coke50);
		Coke50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double itemPrice = 200;

				model.addRow(new Object[] { "Coke 50CL", "1", itemPrice, itemPrice });

				orderCost();

			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(30, 144, 255));
		panel_2.setBounds(310, 11, 16, 439);
		contentPane.add(panel_2);

		JPanel displayOuter = new JPanel();
		displayOuter.setBounds(10, 11, 301, 439);
		contentPane.add(displayOuter);
		displayOuter.setLayout(null);

		displayInner = new JPanel();
		displayInner.setBounds(10, 42, 281, 289);
		displayOuter.add(displayInner);
		displayInner.setLayout(null);
		displayInner.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 281, 289);
		displayInner.add(scrollPane_1);

		tableDisplay = new JTable();
		scrollPane_1.setViewportView(tableDisplay);
		tableDisplay.setModel(model);
		model.setColumnIdentifiers(salesTbl);
		;

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 205));
		panel_1.setBounds(233, 11, 58, 28);
		displayOuter.add(panel_1);
		panel_1.setLayout(null);

		JLabel addItem = new JLabel("Add");
		addItem.setForeground(new Color(255, 255, 224));
		addItem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addItem.setBounds(16, 7, 26, 14);
		panel_1.add(addItem);

		JLabel subTotal = new JLabel("Sub Total");
		subTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		subTotal.setBounds(10, 342, 66, 14);
		displayOuter.add(subTotal);

		JLabel VAT = new JLabel("VAT");
		VAT.setFont(new Font("Tahoma", Font.BOLD, 13));
		VAT.setBounds(10, 373, 66, 14);
		displayOuter.add(VAT);

		JLabel Gtotal = new JLabel("Grand Total");
		Gtotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		Gtotal.setBounds(10, 408, 87, 14);
		displayOuter.add(Gtotal);

		subTotalOut = new JTextField();
		subTotalOut.setBounds(99, 340, 152, 28);
		displayOuter.add(subTotalOut);
		subTotalOut.setColumns(10);

		vatOut = new JTextField();
		vatOut.setColumns(10);
		vatOut.setBounds(99, 373, 152, 28);
		displayOuter.add(vatOut);

		gTotalOut = new JTextField();
		gTotalOut.setColumns(10);
		gTotalOut.setBounds(99, 405, 152, 28);
		displayOuter.add(gTotalOut);

	}

	// we need a method to help us take care of our logic
	public void orderCost() {

		double sum = 0;
		int i;
		// this loop will check table and the return the total number of items in the
		// row
		for (i = 0; i < tableDisplay.getRowCount(); i++) {

			// here we set the sum to add whatever is the in table column at index of 3
			// index of 3 will return the amount on each row
			sum = sum + Double.parseDouble(tableDisplay.getValueAt(i, 3).toString());
		}
		subTotalOut.setText(Double.toString(sum));

		// Setting Sub total
		double sTotal = Double.parseDouble(subTotalOut.getText());

		// Calculating VAT
		double tTax = (sTotal * 7.5) / 100;

		// Displaying Vat
		String displayTax = String.format("%.2f", tTax);
		vatOut.setText(displayTax);

		// Displaying subtotal
		String displaySubTotal = String.format("%.2f", sTotal);
		subTotalOut.setText(displaySubTotal);

		// Displaying Grand Total
		String displayGrandTotal = String.format("%.2f", sTotal + tTax);
		gTotalOut.setText(displayGrandTotal);

	}

	public void balanceAfterPayment() {

		double cashEntered = Double.parseDouble(amoutPaidBox.getText());
		double totalAmount = Double.parseDouble(gTotalOut.getText());
		double balance = cashEntered - totalAmount;
		String balanceOut = String.format("%.2f", balance);

		if (totalAmount <= cashEntered) {
			balanceBox.setText(balanceOut);
			balanceBox.setBackground(Color.GREEN);
		} else if (totalAmount > cashEntered) {

			balanceBox.setText("error");
			balanceBox.setBackground(Color.red);

		}

	}

	public void deleteItem() {
		DefaultTableModel removeModel = (DefaultTableModel) tableDisplay.getModel();
		int deleteItem = tableDisplay.getSelectedRow();
		if (deleteItem >= 0) {
			removeModel.removeRow(deleteItem);
		}
		orderCost();
		if (comboBox.getSelectedItem().equals("Cash")) {
			balanceAfterPayment();
		} else {
			balanceBox.setText("");
			amoutPaidBox.setText("");
		}
	}
}
