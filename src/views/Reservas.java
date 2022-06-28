package views;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import jdbc.model.Reserva;
import jdc.controller.ReservasController;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.text.Format;
import java.util.Calendar;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;



@SuppressWarnings("serial")
public class Reservas extends JFrame {

	private JPanel contentPane;
	private JTextField Valor;
	private JDateChooser FechaE;
	private JDateChooser FechaS;
	private JComboBox<Format> FormaPago;
	private ReservasController reservasController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservas frame = new Reservas();
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
	public Reservas() {
		super("Reserva");
		this.reservasController = new ReservasController();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Reservas.class.getResource("/imagens/calendario.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 540);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245,245,245));
		panel.setBounds(0, 0, 900, 502);
		contentPane.add(panel);
		panel.setLayout(null);
		
		FechaE = new JDateChooser();
		FechaE.setDateFormatString("yyyy-MM-dd");
		FechaE.setBounds(88, 166, 235, 33);
		panel.add(FechaE);
		
		JLabel lblNewLabel_1 = new JLabel("Data de Check In");
		lblNewLabel_1.setBounds(88, 142, 133, 14);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Data de Check Out");
		lblNewLabel_1_1.setBounds(88, 210, 133, 14);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_1);
		
		FechaS = new JDateChooser();
		FechaS.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				calcularValor(FechaE,FechaS);
			}
		});
		FechaS.setDateFormatString("yyyy-MM-dd");
		FechaS.setBounds(88, 234, 235, 33);
		FechaS.getCalendarButton().setBackground(Color.WHITE);
		panel.add(FechaS);

		
		
		Valor = new JTextField();
		Valor.setFont(new Font("Arial Black", Font.BOLD, 15));
		Valor.setBounds(88, 303, 235, 33);
		Valor.setEnabled(false);
		panel.add(Valor);
		Valor.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Valor da Reserva");
		lblNewLabel_1_1_1.setBounds(88, 278, 133, 14);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_1_1);
		
		FormaPago = new JComboBox();
		FormaPago.setBounds(88, 373, 235, 33);
		FormaPago.setFont(new Font("Arial", Font.PLAIN, 14));
		FormaPago.setModel(new DefaultComboBoxModel(new String[] {"Cartão de Crédito", "Cartão de Débito", "Boleto"}));
		panel.add(FormaPago);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Forma de pagamento");
		lblNewLabel_1_1_1_1.setBounds(88, 347, 151, 24);
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("Sistema de Reservas");
		lblNewLabel_4.setBounds(108, 93, 199, 42);
		lblNewLabel_4.setForeground(new Color(65, 105, 225));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(lblNewLabel_4);
		
		JButton btnReservar = new JButton("Continuar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();

			}
		});
		btnReservar.setForeground(Color.WHITE);
		btnReservar.setBounds(190, 436, 133, 33);
		btnReservar.setIcon(new ImageIcon(Reservas.class.getResource("/imagens/calendario.png")));
		btnReservar.setBackground(new Color(65,105,225));
		btnReservar.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(btnReservar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(399, 0, 491, 502);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, -16, 500, 539);
		panel_1.add(lblNewLabel);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(Reservas.class.getResource("/imagens/reservas-img-2.png")));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Reservas.class.getResource("/imagens/Ha-100px.png")));
		lblNewLabel_2.setBounds(15, 6, 104, 107);
		panel.add(lblNewLabel_2);
	}

	
	private void salvar() {		
	if (FechaE.getDate() != null && FechaS.getDate() != null) {		
		String fechaE = ((JTextField)FechaE.getDateEditor().getUiComponent()).getText();
		String fechaS = ((JTextField)FechaS.getDateEditor().getUiComponent()).getText();			
		Reserva reserva = new Reserva(java.sql.Date.valueOf(fechaE), java.sql.Date.valueOf(fechaS), Valor.getText(), FormaPago.getSelectedItem().toString());
		this.reservasController.salvar(reserva);
		JOptionPane.showMessageDialog(this, "Salvado Exitosamente");
	} else {
		JOptionPane.showMessageDialog(this, "Por favor preencha todos os campos.");
	}			
  }
	private void calcularValor(JDateChooser fechaE,JDateChooser fechaS) {		
		if(fechaE.getDate() != null && fechaS.getDate() !=null) {
			Calendar inicio = fechaE.getCalendar();
			Calendar fin = fechaS.getCalendar();
			int dias = -1;
			int diaria = 180;
			int valor;
			
			while(inicio.before(fin)||inicio.equals(fin)) {
				dias++;
				inicio.add(Calendar.DATE,1);
			}
			valor = dias * diaria;
			Valor.setText("" + valor);
		}
	}
}
