package guiClientes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloClientes;
import clases.Cliente;
import utilidades.Colores;
import utilidades.Validacion;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JComboBox<Cliente> cboClientes;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnModificarCliente;
	private JButton btnCancelar;

//	private static ArrayList<Cliente> clientes = ArregloClientes.getClientes();

	/**
	 * Launch the application.
	 */

	public static void abrirVentana() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarCliente frame = new ModificarCliente();
					frame.setLocationRelativeTo(null);
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
	public ModificarCliente() {

		setTitle("Modificar Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 327, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 311, 377);
		contentPane.add(panel);
		panel.setLayout(null);

		cboClientes = new JComboBox<Cliente>();
		for (int i = 0; i < ArregloClientes.getNroClientes(); i++) {
			cboClientes.addItem(ArregloClientes.getCliente(i));
		}
		System.out.println(ArregloClientes.getClientes());
		cboClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedcboClientes(e);
			}
		});
		cboClientes.setBounds(55, 70, 201, 22);
		panel.add(cboClientes);

		txtNombre = new JTextField();
		txtNombre.setBounds(155, 115, 101, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(155, 146, 101, 20);
		panel.add(txtApellido);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(155, 177, 101, 20);
		panel.add(txtDireccion);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(155, 208, 101, 20);
		panel.add(txtTelefono);

		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(155, 239, 101, 20);
		panel.add(txtDni);

		lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(55, 118, 46, 14);
		panel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(55, 149, 46, 14);
		panel.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Direccion");
		lblNewLabel_3.setBounds(55, 180, 90, 14);
		panel.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Telefono");
		lblNewLabel_4.setBounds(55, 211, 90, 14);
		panel.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("DNI");
		lblNewLabel_5.setBounds(55, 242, 90, 14);
		panel.add(lblNewLabel_5);

		btnModificarCliente = new JButton("Registrar");
		btnModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnModificarCliente(e);
			}
		});
		btnModificarCliente.setBounds(55, 288, 89, 23);
		panel.add(btnModificarCliente);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(167, 288, 89, 23);
		panel.add(btnCancelar);

		lblNewLabel = new JLabel("Modificar Cliente");
		lblNewLabel.setForeground(Colores.AZUL);
		lblNewLabel.setBounds(79, 23, 153, 20);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
	}

	protected void actionPerformedcboClientes(ActionEvent e) {
		Cliente clienteSeleccionado = (Cliente) cboClientes.getSelectedItem();
		txtNombre.setText(clienteSeleccionado.getNombres());
		txtApellido.setText(clienteSeleccionado.getApellidos());
		txtDireccion.setText(clienteSeleccionado.getDireccion());
		txtTelefono.setText(clienteSeleccionado.getTelefono());
		txtDni.setText(clienteSeleccionado.getDni());
	}

	protected void actionPerformedBtnModificarCliente(ActionEvent e) {
		validarCampos();
	}

	private void validarCampos() {
		boolean nombreValido = Validacion.validarString(txtNombre.getText());
		boolean apellidoValido = Validacion.validarString(txtApellido.getText());
		boolean telefonoValido = Validacion.validarTelefono(txtTelefono.getText());
		boolean dniValido = Validacion.validarDni(txtDni.getText());

		if (nombreValido && apellidoValido && telefonoValido && dniValido) {
			modificarCliente();
		} else {
			JOptionPane.showMessageDialog(null, "Datos incorrectos");
		}

	}

	private void modificarCliente() {
		int i = cboClientes.getSelectedIndex();
		Cliente cliente = new Cliente(txtNombre.getText(), txtApellido.getText(), txtDireccion.getText(),
				txtTelefono.getText(), txtDni.getText());
		ArregloClientes.modificarCliente(i, cliente);
		ArregloClientes.actualizarClientes();
		JOptionPane.showMessageDialog(null, "Cliente modificado");
		this.dispose();
	}
}
