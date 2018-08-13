package view.mainview;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.mysql.jdbc.PreparedStatement;

import DBConnect.DBConnect;
import view.tela1.Tela1;

public class MainView {

	private JFrame frmMainview;
	private JPasswordField password;
	@SuppressWarnings("rawtypes")
	private JComboBox cbUsr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MainView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainview = new JFrame();
		frmMainview.setTitle("MainView");
		frmMainview.setBounds(500, 270, 505, 273);
		frmMainview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainview.setLocationRelativeTo(null);
		frmMainview.setVisible(true);

		iniComponents();
	}

	@SuppressWarnings("rawtypes")
	private void iniComponents() {
		JPanel panel = new JPanel();
		frmMainview.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		password = new JPasswordField();
		password.setBounds(115, 99, 227, 20);
		panel.add(password);

		cbUsr = new JComboBox();
		cbUsr.setBounds(115, 37, 227, 20);
		panel.add(cbUsr);
		password.grabFocus();

		preencheComboBox(cbUsr);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verificaLogin();
			}
		});
		btnLogar.setBounds(192, 153, 89, 23);
		panel.add(btnLogar);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void preencheComboBox(JComboBox cb) {
		try {
			DBConnect database = new DBConnect();
			String query = "select * from T_Usr";
			database.rs = database.st.executeQuery(query);
			while (database.rs.next()) {
				int idusr = database.rs.getInt("CD_Usr");
				String nick = database.rs.getString("NM_Usr");
				String pw = database.rs.getString("NR_Usr");
				cb.addItem(new ItemComboBox(idusr, nick, pw));
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e);
		}
	}
	
	@SuppressWarnings("deprecation")
	private void verificaLogin() {
		try {
			DBConnect database = new DBConnect();
			String query = "select * from T_Usr where NM_Usr = ? and NR_Usr = ?";
			
			database.pst = (PreparedStatement) database.con.prepareStatement(query);
			
			database.pst.setString(1, cbUsr.getSelectedItem().toString());
			database.pst.setString(2, password.getText());
			
			database.rs = database.pst.executeQuery();
			
			if (!database.rs.isBeforeFirst() )   
				JOptionPane.showMessageDialog(null, "Senha Inválida.");
			else {
				new Tela1();
				frmMainview.dispose();
				JOptionPane.showMessageDialog(null, "Logado!");
			}
		} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro aqui: "+e);
		}
	}
	
}
