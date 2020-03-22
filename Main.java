import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListModel;

public class Main {

	private JFrame frame;
	private DefaultListModel demoList;
	private JLabel lblDiccionarioCargado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		BinarySearchTree<Association<String, String>> binarySearchTree = new BinarySearchTree<>();
		
		
		demoList = new DefaultListModel();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 868, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, "name_394878115995000");
		panel.setLayout(null);
		
		JLabel lblCargarDiccionario = new JLabel("Cargar diccionario");
		lblCargarDiccionario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCargarDiccionario.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargarDiccionario.setBounds(47, 21, 204, 29);
		panel.add(lblCargarDiccionario);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 	BufferedReader reader = null;
	                try {
	                	// Lee el archivo desde el sistema
						reader = new BufferedReader(new FileReader("src/diccionario.txt"));
	                    String expresion;
	                    while ((expresion = reader.readLine()) != null) {
	                        if (expresion.charAt(0) == '(') {
	                            expresion = expresion.substring(1);
	                        }
	                        if (expresion.charAt(expresion.length() - 1) == ')') {
	                            expresion = expresion.substring(0, expresion.length() - 1);
	                        }
	                        
	                        String[] diccionario = expresion.split(",");
	                        if (diccionario.length > 1) {
	                            
	                            Association<String, String> a = new Association(diccionario[0], diccionario[1]);
	                            binarySearchTree.add(a);
	                        }
	                    }
	                } catch (IOException e) {
						e.printStackTrace();
					}
	                
	                List<Association<String, String>> list = binarySearchTree.inOrder();
	                String contenido = "";

	                for (final Association association : list) {
	                	 contenido += association.getKey() + "," + association.getValue() + "\n";
	                	 
	                }
	                
	                demoList.addElement(contenido);
	                System.out.println(contenido);
	                
	                lblDiccionarioCargado.setText("Diccionario cargado exitosamente...");
	                   
			}
	                
		});
		btnCargar.setBounds(70, 80, 119, 30);
		panel.add(btnCargar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 304, 369);
		panel.add(scrollPane);
		
		JList list = new JList(demoList);
		scrollPane.setViewportView(list);
		
		lblDiccionarioCargado = new JLabel("");
		lblDiccionarioCargado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDiccionarioCargado.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiccionarioCargado.setBounds(57, 46, 245, 29);
		panel.add(lblDiccionarioCargado);
	}
}
