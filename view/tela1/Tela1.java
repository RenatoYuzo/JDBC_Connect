package view.tela1;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Button;
import javax.swing.JComboBox;

public class Tela1 extends JFrame {
	
	JFrame frame = new JFrame("Tela1");

	/**
	 * Create the frame.
	 */
	public Tela1() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(600, 300, 660, 403);
		//frame.setSize(777, 514);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setLocation(275, 221);
		frame.getContentPane().add(btnFechar);
		btnFechar.setSize(101, 23);
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(btnFechar, BorderLayout.CENTER);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(219, 72, 197, 20);
		frame.getContentPane().add(comboBox);
		
		buildMenuBar();
	}
	
	private void buildMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnMenulist = new JMenu("MenuList");
		menuBar.add(mnMenulist);
		
		JMenuItem mntmAbreOutroJframe = new JMenuItem("Abre outro JFrame");
		mntmAbreOutroJframe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Tela1();
				
				frame.dispose();
			}
		});
		mnMenulist.add(mntmAbreOutroJframe);
		
		JMenuItem mntmHelloWorld = new JMenuItem("Hello World!");
		mntmHelloWorld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Hello World!");
				System.out.println("Hello World!");
			}
		});
		mnMenulist.add(mntmHelloWorld);
		
		JMenu mnSair = new JMenu("Sair");
		mnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		menuBar.add(mnSair);
		
	}
}
