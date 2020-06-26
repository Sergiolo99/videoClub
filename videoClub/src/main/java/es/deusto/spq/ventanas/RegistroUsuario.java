package es.deusto.spq.ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import es.deusto.spq.controller.Controller;
import es.deusto.spq.data.Usuario;

public class RegistroUsuario extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel nombre = new JLabel();
	private JLabel apellido = new JLabel();
	private JLabel email = new JLabel();
	private JLabel usuario = new JLabel();
	private JLabel contrasenya = new JLabel();
	private JLabel fondo = new JLabel();
	
	private JTextField Tnombre = new JTextField();
	private JTextField Tapellido= new JTextField();
	private JTextField Temail= new JTextField();
	private JTextField Tusuario= new JTextField();
	private JPasswordField Tcontrasenya= new JPasswordField();
	private JPasswordField Tcontrasenya2= new JPasswordField();
	
	private JButton aceptar = new JButton();
	private JButton atras = new JButton();
	
	public RegistroUsuario(Controller controller) {
		
	contentPane = new JPanel();	
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("VideoClub");
	lblNewLabel.setForeground(Color.BLACK);
	lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 54));
	lblNewLabel.setBounds(80, 26, 309, 42);
	contentPane.add(lblNewLabel);
	
	nombre.setText("Nombre:");
	nombre.setBounds(60, 130, 130, 20);
	nombre.setOpaque(true);
	contentPane.add(nombre, BorderLayout.SOUTH);
	
	apellido.setText("Apellido:");
	apellido.setBounds(60, 155, 130, 20);
	apellido.setOpaque(true);
	contentPane.add(apellido, BorderLayout.SOUTH);
	
	email.setText("Email:");
	email.setBounds(60, 180, 130, 20);
	email.setOpaque(true);
	contentPane.add(email, BorderLayout.SOUTH);
	
	usuario.setText("Usuario:");
	usuario.setBounds(60, 205, 130, 20);
	usuario.setOpaque(true);
	contentPane.add(usuario, BorderLayout.SOUTH);
	
	contrasenya.setText("Contrasenya:");
	contrasenya.setBounds(60, 230, 130, 20);
	contrasenya.setOpaque(true);
	contentPane.add(contrasenya, BorderLayout.SOUTH);
	
	contrasenya.setText("Comprobar contrasenya:");
	contrasenya.setBounds(60, 255, 130, 20);
	contrasenya.setOpaque(true);
	contentPane.add(contrasenya, BorderLayout.SOUTH);
	
	Tnombre.setBounds(195, 130, 150, 20);
	contentPane.add(Tnombre);
	
	Tapellido.setBounds(195, 155, 150, 20);
	contentPane.add(Tapellido);
	
	Temail.setBounds(195, 180, 150, 20);
	contentPane.add(Temail);
	
	Tusuario.setBounds(195, 205, 150, 20);
	contentPane.add(Tusuario);
	
	Tcontrasenya.setBounds(195, 230, 150, 20);
	contentPane.add(Tcontrasenya);
	
	Tcontrasenya2.setBounds(195, 255, 150, 20);
	contentPane.add(Tcontrasenya2);
	
		
	aceptar.setBackground(SystemColor.inactiveCaptionBorder);
	aceptar.setText("Aceptar");
	aceptar.setBounds(200, 288, 130, 23);
	aceptar.setBackground(new Color(0, 102, 204));
	contentPane.add(aceptar);	
		
	atras.setBackground(SystemColor.inactiveCaptionBorder);
	atras.setText("Atrás");
	atras.setBounds(63, 288, 130, 23);
	contentPane.add(atras);
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(431, 394);
	setTitle("Registro de usuario");
	
	aceptar.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String contrasenya1 = new String(Tcontrasenya.getPassword());
			String vacio = new String("");
			String email = "^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$";
			//boolean correcto = false;
			boolean error = false;
			if(Tnombre.getText() == vacio) {
				JOptionPane.showMessageDialog(null,"Escribe un nombre");
				error=true;
				RegistroUsuario.this.repaint();
			}
			else if(Tapellido.getText() == vacio) {
				JOptionPane.showMessageDialog(null,"Escribe un apellido");
				error=true;
				RegistroUsuario.this.repaint();
			}
			else if(!Pattern.matches(Temail.getText(), email)) {
				JOptionPane.showMessageDialog(null,"Escribe adecuadamente el email");
				error=true;
				RegistroUsuario.this.repaint();
			}
			else if(Tusuario.getText() == vacio) {
				JOptionPane.showMessageDialog(null,"Escribe un usuario");
				error=true;
				RegistroUsuario.this.repaint();
			}
			else if(contrasenya1.equals("")) {
				JOptionPane.showMessageDialog(null,"Escribe una contrasenya");
				error=true;
				RegistroUsuario.this.repaint();
			}
			else if(Tcontrasenya.getPassword() != Tcontrasenya2.getPassword() ) {
				JOptionPane.showMessageDialog(null,"Las contrasenyas no coinciden");
				error=true;
				RegistroUsuario.this.repaint();
			}else if (!error){
				
				controller.registrarUsuario(Usuario.getId(), Tnombre.getText(), Tapellido.getText(), Temail.getText(), Tusuario.getText(), contrasenya1);
				JOptionPane.showMessageDialog(null, "Usuario registrado correctamente"); 
				//RegistroUsuario.this.dispose();        
			        
			}
			
			
			
		}
		
		
		
	});


		
	
	
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
