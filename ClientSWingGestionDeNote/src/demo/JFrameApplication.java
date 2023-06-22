package demo;
import java.text.DecimalFormat;

import java.awt.EventQueue;
import javax.swing.table.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import api.APIClient;
import entity.Etudiant;
import entity.Matiere;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JFrameApplication extends JFrame {

	private JPanel contentPane;
	private static JTable tableEtudiant;
	private JTextField textFieldNomEtudiant;
	private JTextField textFieldRechEt;
	private JTextField textFieldNumEt;
	private JComboBox comboBoxNiveau;
	private static JTable tableMatiere;
	private JTextField textFieldLibelle;
	private JTextField textFieldCoef;
	private JTextField textFieldRechMat;
	private JTextField textFieldCodeMat;
	private JTable tableNote;
	private JTextField textFieldMoyenne;
	private JTextField textFieldAdmission;
	private JTextField textFieldNomEt;
	private JTextField textFieldLibelleM;
	private JTextField note;
	private  static JComboBox comboBoxNumEt;
	private static JComboBox comboBoxCodeMat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameApplication frame = new JFrameApplication();
					frame.setVisible(true);
					loadDataEtudiant();
					loadDataMatiere();
					loadCombobox1();
					loadCombobox();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 730, 424);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 64, 128));
		panel_4.setBounds(0, 0, 204, 387);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTION ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(45, 148, 120, 53);
		panel_4.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("des");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(78, 189, 62, 32);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NOTES");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(56, 225, 120, 53);
		panel_4.add(lblNewLabel_2);
		
		JPanel BtnEtudiant = new JPanel();
		BtnEtudiant.setBackground(new Color(192, 192, 192));
		BtnEtudiant.setBounds(230, 130, 141, 139);
		panel.add(BtnEtudiant);
		BtnEtudiant.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("ETUDIANTS");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(20, 58, 98, 22);
		BtnEtudiant.add(lblNewLabel_3);
		
		JPanel BtnMatiere = new JPanel();
		BtnMatiere.setBackground(Color.LIGHT_GRAY);
		BtnMatiere.setBounds(401, 130, 141, 139);
		panel.add(BtnMatiere);
		BtnMatiere.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("MATIERES");
		lblNewLabel_3_1.setBounds(22, 57, 98, 22);
		BtnMatiere.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JPanel BtnNote = new JPanel();
		BtnNote.setBackground(Color.LIGHT_GRAY);
		BtnNote.setBounds(563, 130, 141, 139);
		panel.add(BtnNote);
		BtnNote.setLayout(null);
		
		JLabel lblNewLabel_3_2 = new JLabel("NOTES");
		lblNewLabel_3_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_2.setBounds(41, 58, 78, 22);
		BtnNote.add(lblNewLabel_3_2);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 162, 705, 225);
		panel_1.add(scrollPane);
		
		tableEtudiant = new JTable();
		tableEtudiant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int sr= tableEtudiant.getSelectedRow();
				String nEt= tableEtudiant.getValueAt(sr,0).toString();
				String mEt= tableEtudiant.getValueAt(sr,1).toString();
				String niEt= tableEtudiant.getValueAt(sr,2).toString();
				
				textFieldNumEt.setText(nEt);
				textFieldNomEtudiant.setText(mEt);
				comboBoxNiveau.setSelectedItem(niEt);
				
				
				
				
				
			}
		});
		scrollPane.setViewportView(tableEtudiant);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "GESTION DES ETUDIANTS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_5.setBounds(10, 10, 705, 142);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Nom:");
		lblNewLabel_4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 15));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setBounds(353, 48, 52, 17);
		panel_5.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Niveau:");
		lblNewLabel_4_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_4_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(353, 75, 52, 17);
		panel_5.add(lblNewLabel_4_1);
		
		textFieldNomEtudiant = new JTextField();
		textFieldNomEtudiant.setBounds(400, 48, 162, 19);
		panel_5.add(textFieldNomEtudiant);
		textFieldNomEtudiant.setColumns(10);
		
		comboBoxNiveau = new JComboBox();
		comboBoxNiveau.setModel(new DefaultComboBoxModel(new String[] {"L1", "L2", "L3", "M1", "M2"}));
		comboBoxNiveau.setBounds(400, 74, 52, 21);
		panel_5.add(comboBoxNiveau);
		
		JButton btnAjoutEtudiant = new JButton("Ajouter");
		btnAjoutEtudiant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
                    String url = "http://localhost:6543/api/etudiant/createEtudiant";
                    String nomEt = textFieldNomEtudiant.getText();
                    String niveau = comboBoxNiveau.getSelectedItem().toString();

                    String requestBody = "{\"nomEt\": \"" +nomEt + "\", \"niveauEt\": \"" +niveau+ "\"}";
                    String response = APIClient.post(url, requestBody);
                    System.out.println("Réponse : " + response);
                    JOptionPane.showMessageDialog(null, "Ajout avec succès");
                    loadDataEtudiant();
                    // Faites quelque chose avec la réponse reçue, par exemple, mettez à jour l'interface utilisateur
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            
			}
		});
		
		btnAjoutEtudiant.setForeground(new Color(255, 255, 255));
		btnAjoutEtudiant.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnAjoutEtudiant.setBackground(new Color(0, 0, 128));
		btnAjoutEtudiant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAjoutEtudiant.setBounds(584, 21, 85, 21);
		panel_5.add(btnAjoutEtudiant);
		
		JButton btnModierEt = new JButton("Modifier");
		btnModierEt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

                
               
                int request= JOptionPane.showConfirmDialog(null,"Voulez vous vraiment modifier ", "Modification", JOptionPane.YES_NO_OPTION);
				
                if(request == JOptionPane.OK_OPTION) {
                	try {
                		int numEt= Integer.parseInt(textFieldNumEt.getText());
        				
        				String url = "http://localhost:6543/api/etudiant/updateEtudiant/"+numEt;
                        String nomEt = textFieldNomEtudiant.getText();
                        String niveau = comboBoxNiveau.getSelectedItem().toString();
                        String requestBody = "{\"nomEt\": \"" +nomEt + "\", \"niveauEt\": \"" +niveau+ "\"}";
    					
    				    APIClient.update(url, requestBody);
    				    JOptionPane.showMessageDialog(null, "Modification avec succès");
    	                loadDataEtudiant();
    				} catch (Exception ex) {
    				    ex.printStackTrace();
    				}
				}
				else {
					loadDataEtudiant();
				}

				
			}
		});
		btnModierEt.setFont(new Font("Trebuchet MS", Font.PLAIN, 8));
		btnModierEt.setForeground(new Color(255, 255, 255));
		btnModierEt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModierEt.setBackground(new Color(128, 128, 128));
		btnModierEt.setBounds(584, 48, 85, 21);
		panel_5.add(btnModierEt);
		
		JButton Et = new JButton("Suprimer");
		Et.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 
                int request= JOptionPane.showConfirmDialog(null,"Voulez vous vraiment Supprimer ", "Supression", JOptionPane.YES_NO_OPTION);
				
                if(request == JOptionPane.OK_OPTION) {
                	try {
                		int numEt= Integer.parseInt(textFieldNumEt.getText());
        				String url = "http://localhost:6543/api/etudiant/deleteEtudiant/"+numEt;
                       
    				    APIClient.delete(url);
    				    JOptionPane.showMessageDialog(null, "Suppression avec succès");
    	                loadDataEtudiant();
    				} catch (Exception ex) {
    				    ex.printStackTrace();
    				}
				}
				else {
					loadDataEtudiant();
				}

				
			}
		});
		Et.setFont(new Font("Tahoma", Font.PLAIN, 8));
		Et.setForeground(new Color(255, 255, 255));
		Et.setBackground(new Color(255, 0, 0));
		Et.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Et.setBounds(584, 75, 85, 21);
		panel_5.add(Et);
		
		textFieldRechEt = new JTextField();
		textFieldRechEt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(textFieldRechEt.getText().isEmpty()) {
					loadDataEtudiant();
				}
				else {

					char c= e.getKeyChar();
					if(Character.isLetter(c)) {
						String key=textFieldRechEt.getText();
						loadEtudiantByName(key);
					}else {
						int key=Integer.parseInt(textFieldRechEt.getText());
						loadEtudiantById(key);
					}
				}
			}
		});
		textFieldRechEt.setColumns(10);
		textFieldRechEt.setBounds(105, 113, 162, 19);
		panel_5.add(textFieldRechEt);
		
		JComboBox comboBoxNiveau_1 = new JComboBox();
		comboBoxNiveau_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ni= comboBoxNiveau_1.getSelectedItem().toString();
				if(ni.isEmpty()) {
					loadDataEtudiant();
				}
				else {
					loadEtudiantByNiveau(ni);
				}
			}
		});
		comboBoxNiveau_1.setModel(new DefaultComboBoxModel(new String[] {"", "L1", "L2", "L3", "M1", "M2"}));
		comboBoxNiveau_1.setBounds(340, 112, 52, 21);
		panel_5.add(comboBoxNiveau_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Numero:");
		lblNewLabel_4_2.setForeground(Color.BLACK);
		lblNewLabel_4_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 15));
		lblNewLabel_4_2.setBounds(353, 21, 52, 17);
		panel_5.add(lblNewLabel_4_2);
		
		textFieldNumEt = new JTextField();
		textFieldNumEt.setForeground(new Color(0, 0, 0));
		textFieldNumEt.setEnabled(false);
		textFieldNumEt.setColumns(10);
		textFieldNumEt.setBounds(400, 21, 52, 19);
		panel_5.add(textFieldNumEt);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Nom ou numero:");
		lblNewLabel_4_2_1.setForeground(Color.BLACK);
		lblNewLabel_4_2_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 15));
		lblNewLabel_4_2_1.setBounds(10, 116, 85, 17);
		panel_5.add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Niveau:");
		lblNewLabel_4_1_1.setForeground(Color.BLACK);
		lblNewLabel_4_1_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 15));
		lblNewLabel_4_1_1.setBounds(289, 116, 52, 17);
		panel_5.add(lblNewLabel_4_1_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 165, 705, 222);
		panel_2.add(scrollPane_1);
		
		tableMatiere = new JTable();
		tableMatiere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	
				int sr= tableMatiere.getSelectedRow();
				String co= tableMatiere.getValueAt(sr,0).toString();
				String l= tableMatiere.getValueAt(sr,1).toString();
				String coe= tableMatiere.getValueAt(sr,2).toString();
				
				textFieldLibelle.setText(l);
				textFieldCoef.setText(coe);
				textFieldCodeMat.setText(co);}
});
		scrollPane_1.setViewportView(tableMatiere);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 10, 705, 145);
		panel_2.add(scrollPane_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		scrollPane_2.setViewportView(panel_6);
		panel_6.setBorder(new TitledBorder(null, "GESTION des MATIERES", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Libelle: ");
		lblNewLabel_5.setBounds(355, 61, 46, 18);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_6.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Coefficient: ");
		lblNewLabel_5_1.setBounds(336, 89, 83, 18);
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_6.add(lblNewLabel_5_1);
		
		textFieldLibelle = new JTextField();
		textFieldLibelle.setBounds(410, 61, 148, 19);
		panel_6.add(textFieldLibelle);
		textFieldLibelle.setColumns(10);
		
		textFieldCoef = new JTextField();
		textFieldCoef.setColumns(10);
		textFieldCoef.setBounds(411, 90, 71, 19);
		panel_6.add(textFieldCoef);
		
		textFieldRechMat = new JTextField();
		textFieldRechMat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				if(textFieldRechMat.getText().isEmpty()) {
					loadDataMatiere();
				}
				else {

					char c= e.getKeyChar();
					if(Character.isLetter(c)) {
						String key=textFieldRechMat.getText();
						loadMatiereByName(key);
					}else {
						int key=Integer.parseInt(textFieldRechMat.getText());
						loadMatiereById(key);
					}
				}
			}
		});
		textFieldRechMat.setColumns(10);
		textFieldRechMat.setBounds(177, 106, 148, 19);
		panel_6.add(textFieldRechMat);
		
		JLabel lblNewLabel_5_2 = new JLabel("Libelle ou Code Matière: ");
		lblNewLabel_5_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_5_2.setBounds(10, 105, 157, 18);
		panel_6.add(lblNewLabel_5_2);
		
		JButton btnAjoutMat = new JButton("Ajouter");
		btnAjoutMat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
                    String url = "http://localhost:6543/api/matiere/createMatiere";
                    String libelle = textFieldLibelle.getText();
                    Double coef = Double.parseDouble(textFieldCoef.getText());

                    String requestBody = "{\"libelleMat\": \"" +libelle + "\", \"coefMat\": \"" +coef+ "\"}";
                    String response = APIClient.post(url, requestBody);
                    System.out.println("Réponse : " + response);
                    JOptionPane.showMessageDialog(null, "Ajout avec succès");
                    loadDataMatiere();
                    // Faites quelque chose avec la réponse reçue, par exemple, mettez à jour l'interface utilisateur
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
			}
		});
		btnAjoutMat.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAjoutMat.setForeground(new Color(255, 255, 255));
		btnAjoutMat.setBackground(new Color(0, 0, 128));
		btnAjoutMat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAjoutMat.setBounds(590, 23, 85, 21);
		panel_6.add(btnAjoutMat);
		
		JButton btnModifMat = new JButton("Modifier");
		btnModifMat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 int request= JOptionPane.showConfirmDialog(null,"Voulez vous vraiment modifier ", "Modification", JOptionPane.YES_NO_OPTION);
					
	                if(request == JOptionPane.OK_OPTION) {
	                	try {
	                		int num= Integer.parseInt(textFieldCodeMat.getText());
	        				
	        				String url = "http://localhost:6543/api/matiere/updateMatiere/"+ num;
	                        String libelle= textFieldLibelle.getText();
	                        Double coef  = Double.parseDouble(textFieldCoef.getText());
	                        String requestBody = "{\"libelleMat\": \"" +libelle + "\", \"coefMat\": \"" +coef+ "\"}";
	    					
	    				    APIClient.update(url, requestBody);
	    				    JOptionPane.showMessageDialog(null, "Modification avec succès");
	    				    loadDataMatiere();
	    				} catch (Exception ex) {
	    				    ex.printStackTrace();
	    				}
					}
					else {
						loadDataMatiere();
					}

			}
		});
		btnModifMat.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnModifMat.setForeground(new Color(255, 255, 255));
		btnModifMat.setBackground(new Color(192, 192, 192));
		btnModifMat.setBounds(590, 54, 85, 21);
		panel_6.add(btnModifMat);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 int request= JOptionPane.showConfirmDialog(null,"Voulez vous vraiment Supprimer ", "Supression", JOptionPane.YES_NO_OPTION);
					
	                if(request == JOptionPane.OK_OPTION) {
	                	try {
	                		int numEt= Integer.parseInt(textFieldCodeMat.getText());
	        				String url = "http://localhost:6543/api/matiere/deleteMat/"+numEt;
	                       
	    				    APIClient.delete(url);
	    				    JOptionPane.showMessageDialog(null, "Suppression avec succès");
	    				    loadDataMatiere();
	    				} catch (Exception ex) {
	    				    ex.printStackTrace();
	    				}
					}
					else {
						loadDataMatiere();
					}

					
				}
		});
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSupprimer.setForeground(new Color(255, 255, 255));
		btnSupprimer.setBackground(new Color(255, 0, 0));
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSupprimer.setBounds(590, 89, 85, 21);
		panel_6.add(btnSupprimer);
		
		JLabel lblNewLabel_5_3 = new JLabel("Code: ");
		lblNewLabel_5_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_5_3.setBounds(355, 33, 46, 18);
		panel_6.add(lblNewLabel_5_3);
		
		textFieldCodeMat = new JTextField();
		textFieldCodeMat.setEnabled(false);
		textFieldCodeMat.setColumns(10);
		textFieldCodeMat.setBounds(411, 32, 46, 19);
		panel_6.add(textFieldCodeMat);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 160, 634, 168);
		panel_3.add(scrollPane_3);
		
		tableNote = new JTable();
		scrollPane_3.setViewportView(tableNote);
		
		textFieldMoyenne = new JTextField();
		textFieldMoyenne.setBounds(553, 338, 81, 19);
		panel_3.add(textFieldMoyenne);
		textFieldMoyenne.setColumns(10);
		
		textFieldAdmission = new JTextField();
		textFieldAdmission.setColumns(10);
		textFieldAdmission.setBounds(553, 367, 81, 19);
		panel_3.add(textFieldAdmission);
		
		JLabel lblNewLabel_6 = new JLabel("Moyenne:");
		lblNewLabel_6.setBounds(447, 344, 100, 13);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("ADMISSION:");
		lblNewLabel_6_1.setBounds(432, 367, 112, 16);
		panel_3.add(lblNewLabel_6_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_7.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "GESTION des Notes", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_7.setBounds(0, 10, 715, 140);
		panel_3.add(panel_7);
		panel_7.setLayout(null);
		
		comboBoxNumEt = new JComboBox();
		comboBoxNumEt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectnumEt=  comboBoxNumEt.getSelectedItem().toString();
				
				
				if(selectnumEt.isEmpty()) {
					textFieldNomEt.setText("");
				}
				else {
					
					try {
						int numEt= Integer.parseInt(selectnumEt);
			            String url = "http://localhost:6543/api/etudiant/findByIdEt/" +numEt;
			            String responseBody = APIClient.get(url);

			            // Utiliser Jackson pour convertir la réponse JSON en une liste d'objets Etudiant
			            ObjectMapper objectMapper = new ObjectMapper();
			            Etudiant et = objectMapper.readValue(responseBody, new TypeReference<Etudiant>(){});
			            textFieldNomEt.setText(et.getNomEt());
			            // Faire le traitement avec la liste d'étudiants
			            // Faire le traitement avec la liste d'étudiants
			            
			            
			        } catch (Exception ex) {
			            ex.printStackTrace();
			            JOptionPane.showMessageDialog(null, "Erreur lors du chargement des données des étudiants.", "Erreur", JOptionPane.ERROR_MESSAGE);
			        }
			    }
					
			}
		});
		comboBoxNumEt.setBounds(422, 28, 53, 13);
		panel_7.add(comboBoxNumEt);
		
		comboBoxCodeMat = new JComboBox();
		comboBoxCodeMat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectnumMat=  comboBoxCodeMat.getSelectedItem().toString();
				
				
				if(selectnumMat.isEmpty()) {
					textFieldLibelleM.setText("");
				}
				else {
					
					try {
						int numMat= Integer.parseInt(selectnumMat);
			            String url = "http://localhost:6543/api/matiere/findByIdMat/" +numMat;
			            String responseBody = APIClient.get(url);

			            // Utiliser Jackson pour convertir la réponse JSON en une liste d'objets Etudiant
			            ObjectMapper objectMapper = new ObjectMapper();
			            Matiere mat = objectMapper.readValue(responseBody, new TypeReference<Matiere>(){});
			            textFieldLibelleM.setText(mat.getLibelleMat());
			            // Faire le traitement avec la liste d'étudiants
			            // Faire le traitement avec la liste d'étudiants
			            
			            
			        } catch (Exception ex) {
			            ex.printStackTrace();
			            JOptionPane.showMessageDialog(null, "Erreur lors du chargement des données des étudiants.", "Erreur", JOptionPane.ERROR_MESSAGE);
			        }
			    }
			
			}
		});
		comboBoxCodeMat.setBounds(422, 61, 53, 13);
		panel_7.add(comboBoxCodeMat);
		
		textFieldNomEt = new JTextField();
		textFieldNomEt.setColumns(10);
		textFieldNomEt.setBounds(483, 29, 114, 20);
		panel_7.add(textFieldNomEt);
		
		textFieldLibelleM = new JTextField();
		textFieldLibelleM.setColumns(10);
		textFieldLibelleM.setBounds(485, 62, 114, 20);
		panel_7.add(textFieldLibelleM);
		
		note = new JTextField();
		note.setColumns(10);
		note.setBounds(422, 92, 70, 20);
		panel_7.add(note);
		
		JLabel lblNewLabel_7 = new JLabel("Numerp Etudiant:");
		lblNewLabel_7.setBounds(266, 32, 156, 13);
		panel_7.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("Code Matière:");
		lblNewLabel_7_1.setBounds(278, 65, 144, 13);
		panel_7.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("Note:");
		lblNewLabel_7_1_1.setBounds(336, 95, 86, 13);
		panel_7.add(lblNewLabel_7_1_1);
		
		JButton btnAjoutNote = new JButton("Ajouter");
		btnAjoutNote.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
                    String url = "http://localhost:6543/api/note/createNote";
                    
                    int numEt= Integer.parseInt(comboBoxNumEt.getSelectedItem().toString());
                    String url1 = "http://localhost:6543/api/etudiant/findByIdEt/"+ numEt;
                    String responseBody = APIClient.get(url1);
                   
                    ObjectMapper objectMapper = new ObjectMapper();
                    Etudiant etudiant = objectMapper.readValue(responseBody, new TypeReference<Etudiant>(){});
                    
                    int numMat= Integer.parseInt(comboBoxCodeMat.getSelectedItem().toString());
                    String url2 = "http://localhost:6543/api/matiere/findByIdMat/" +numMat;
                    String responseBody2 = APIClient.get(url2);

                    Matiere mat = objectMapper.readValue(responseBody2, new TypeReference<Matiere>(){});
            
                    Double noteV = Double.parseDouble(note.getText());
                    //System.out.println(objectMapper.writeValueAsString(etudiant));

                    String requestBody = "{\"etudiant\": \"" + objectMapper.writeValueAsString(etudiant) + "\", \"matiere\": \"" +objectMapper.writeValueAsString(mat)+ "\", \"note\": \"" +noteV+ "\"}";
                    String response = APIClient.post(url, requestBody);
                    System.out.println("Réponse : " + response);
                    JOptionPane.showMessageDialog(null, "Ajout avec succès");
              
                    // Faites quelque chose avec la réponse reçue, par exemple, mettez à jour l'interface utilisateur
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
			
			}
		});
		btnAjoutNote.setForeground(new Color(255, 255, 255));
		btnAjoutNote.setBackground(new Color(0, 0, 128));
		btnAjoutNote.setBounds(620, 28, 85, 21);
		panel_7.add(btnAjoutNote);
		
		JButton btnModifNote = new JButton("Modifier");
		btnModifNote.setForeground(Color.WHITE);
		btnModifNote.setBackground(new Color(192, 192, 192));
		btnModifNote.setBounds(620, 61, 85, 21);
		panel_7.add(btnModifNote);
		
		JButton btnDeleteNote = new JButton("Supprimer");
		btnDeleteNote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteNote.setForeground(Color.WHITE);
		btnDeleteNote.setBackground(new Color(255, 0, 0));
		btnDeleteNote.setBounds(620, 91, 85, 21);
		panel_7.add(btnDeleteNote);
	}
	
	private static void loadDataEtudiant() {
        try {
            String url = "http://localhost:6543/api/etudiant/findAllEtudiant";
            String responseBody = APIClient.get(url);

            // Utiliser Jackson pour convertir la réponse JSON en une liste d'objets Etudiant
            ObjectMapper objectMapper = new ObjectMapper();
            List<Etudiant> etudiants = objectMapper.readValue(responseBody, new TypeReference<List<Etudiant>>(){});

            // Faire le traitement avec la liste d'étudiants
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("Numero Etudiant");
            df.addColumn("Nom Etudiant");
            df.addColumn("Niveau");
            
            for (Etudiant etudiant : etudiants) {
            	
                df.addRow(new Object[]{etudiant.getNumEt(), etudiant.getNomEt(), etudiant.getNiveauEt()});
            }

            tableEtudiant.setModel(df);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors du chargement des données des étudiants.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
	private static void loadCombobox1() {
	
		 try {
			 	
			 String url = "http://localhost:6543/api/etudiant/findAllEtudiant";
	            // Utiliser Jackson pour convertir la réponse JSON en une liste d'objets Etudiant
	            ObjectMapper objectMapper = new ObjectMapper();
	            

				
	            String responseBody = APIClient.get(url);

	            // Utiliser Jackson pour convertir la réponse JSON en une liste d'objets Etudiant
	           
	            List<Etudiant> etudiants = objectMapper.readValue(responseBody, new TypeReference<List<Etudiant>>(){});

	            // Faire le traitement avec la liste d'étudiants
	            comboBoxNumEt.insertItemAt("", 0);
	            comboBoxNumEt.setSelectedIndex(0);
	            for (Etudiant etudiant : etudiants) {
	            	int numEt= etudiant.getNumEt();
	            	comboBoxNumEt.addItem(numEt);
	            	
	            	       
	            }

	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Erreur lors du chargement des données des étudiants.", "Erreur", JOptionPane.ERROR_MESSAGE);
	        }
		
		
	}
	
	private static void loadCombobox() {
		
		 try {
				String url2 = "http://localhost:6543/api/matiere/findAllMatiere";
	            String responseBody2 = APIClient.get(url2);
			 	comboBoxCodeMat.insertItemAt("", 0);
	            comboBoxNumEt.setSelectedIndex(0);
			 
	            // Utiliser Jackson pour convertir la réponse JSON en une liste d'objets Etudiant
	            ObjectMapper objectMapper = new ObjectMapper();
	            List<Matiere> matieres = objectMapper.readValue(responseBody2, new TypeReference<List<Matiere>>(){});
	            
	            for (Matiere mat : matieres) {
	         
	            	int numMat= mat.getCodeMat();
	            	comboBoxCodeMat.addItem(numMat);
	             
	            }


	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Erreur lors du chargement des données des étudiants.", "Erreur", JOptionPane.ERROR_MESSAGE);
	        }
		
		
	}
	private static void loadDataMatiere() {
        try {
            String url = "http://localhost:6543/api/matiere/findAllMatiere";
            String responseBody = APIClient.get(url);

            // Utiliser Jackson pour convertir la réponse JSON en une liste d'objets Etudiant
            ObjectMapper objectMapper = new ObjectMapper();
            List<Matiere> matieres = objectMapper.readValue(responseBody, new TypeReference<List<Matiere>>(){});

            // Faire le traitement avec la liste d'étudiants
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("Code Matiere");
            df.addColumn("Libelle");
            df.addColumn("Coefficient");

            for (Matiere mat : matieres) {
            	Double number= mat.getCoefMat();
            	String c= String.format("%.0f",number);
                
             
                df.addRow(new Object[]{mat.getCodeMat(), mat.getLibelleMat(),c});
            }

            tableMatiere.setModel(df);
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors du chargement des données des étudiants.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	
	private static void loadEtudiantByName(String nom) {
        try {
        	
        	
            String url = "http://localhost:6543/api/etudiant/findByNameEt/" +nom;
            String responseBody = APIClient.get(url);

            // Utiliser Jackson pour convertir la réponse JSON en une liste d'objets Etudiant
            ObjectMapper objectMapper = new ObjectMapper();
            List<Etudiant> etudiants = objectMapper.readValue(responseBody, new TypeReference<List<Etudiant>>(){});

            // Faire le traitement avec la liste d'étudiants
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("Numero Etudiant");
            df.addColumn("Nom Etudiant");
            df.addColumn("Niveau");

            for (Etudiant etudiant : etudiants) {
                df.addRow(new Object[]{etudiant.getNumEt(), etudiant.getNomEt(), etudiant.getNiveauEt()});
            }

            tableEtudiant.setModel(df);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors du chargement des données des étudiants.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	private static void loadMatiereByName(String nom) {
        try {
        	
        	
            String url = "http://localhost:6543/api/matiere/findByLibelle/" +nom;
            String responseBody = APIClient.get(url);

            // Utiliser Jackson pour convertir la réponse JSON en une liste d'objets Etudiant
            ObjectMapper objectMapper = new ObjectMapper();
            List<Matiere> matieres = objectMapper.readValue(responseBody, new TypeReference<List<Matiere>>(){});

            // Faire le traitement avec la liste d'étudiants
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("Code Matiere");
            df.addColumn("Libelle");
            df.addColumn("Coefficient");

            for (Matiere mat : matieres) {
            	Double number= mat.getCoefMat();
            	String c= String.format("%.0f",number);
                
             
                df.addRow(new Object[]{mat.getCodeMat(), mat.getLibelleMat(),c});
            }

            tableMatiere.setModel(df);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors du chargement des données des étudiants.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	private static void loadEtudiantByNiveau(String niveau) {
        try {
        	
        	
            String url = "http://localhost:6543/api/etudiant/findByNiveauEt/" +niveau;
            String responseBody = APIClient.get(url);

            // Utiliser Jackson pour convertir la réponse JSON en une liste d'objets Etudiant
            ObjectMapper objectMapper = new ObjectMapper();
            List<Etudiant> etudiants = objectMapper.readValue(responseBody, new TypeReference<List<Etudiant>>(){});

            // Faire le traitement avec la liste d'étudiants
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("Numero Etudiant");
            df.addColumn("Nom Etudiant");
            df.addColumn("Niveau");

            for (Etudiant etudiant : etudiants) {
                df.addRow(new Object[]{etudiant.getNumEt(), etudiant.getNomEt(), etudiant.getNiveauEt()});
            }

            tableEtudiant.setModel(df);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors du chargement des données des étudiants.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	private static void loadEtudiantById(int id) {
        try {
        	
        	
            String url = "http://localhost:6543/api/etudiant/findByIdEt/" +id;
            String responseBody = APIClient.get(url);

            // Utiliser Jackson pour convertir la réponse JSON en une liste d'objets Etudiant
            ObjectMapper objectMapper = new ObjectMapper();
            Etudiant etudiant = objectMapper.readValue(responseBody, new TypeReference<Etudiant>(){});

            // Faire le traitement avec la liste d'étudiants
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("Numero Etudiant");
            df.addColumn("Nom Etudiant");
            df.addColumn("Niveau");

            
           df.addRow(new Object[]{etudiant.getNumEt(), etudiant.getNomEt(), etudiant.getNiveauEt()});

            tableEtudiant.setModel(df);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors du chargement des données des étudiants.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
	private static void loadMatiereById(int id) {
        try {
        	
        	
            String url = "http://localhost:6543/api/matiere/findByIdMat/" +id;
            String responseBody = APIClient.get(url);

            // Utiliser Jackson pour convertir la réponse JSON en une liste d'objets Etudiant
            ObjectMapper objectMapper = new ObjectMapper();
            Matiere mat = objectMapper.readValue(responseBody, new TypeReference<Matiere>(){});

            // Faire le traitement avec la liste d'étudiants
            // Faire le traitement avec la liste d'étudiants
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("Code Matiere");
            df.addColumn("Libelle");
            df.addColumn("Coefficient");

            Double number= mat.getCoefMat();
        	String c= String.format("%.0f",number);
            df.addRow(new Object[]{mat.getCodeMat(), mat.getLibelleMat(),c});
            tableMatiere.setModel(df);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors du chargement des données des étudiants.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}



