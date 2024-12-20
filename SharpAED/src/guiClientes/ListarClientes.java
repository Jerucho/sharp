package guiClientes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloClientes;
import clases.Cliente;
import utilidades.Colores;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class ListarClientes extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnListar;
	private JLabel lblNewLabel;
	
	
	
	/**
	 * Launch the application.
	 */

	public static void abrirVentana() {
		try {
			ListarClientes dialog = new ListarClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarClientes() {
		setTitle("Listar Clientes");
		setBounds(100, 100, 584, 379);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 108, 548, 205);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		model = new DefaultTableModel();
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("DNI");
		model.addColumn("Telefono");
		model.addColumn("Email");
		table.setModel(model);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnListar(e);
			}
		});
		btnListar.setBounds(10, 61, 89, 23);
		contentPanel.add(btnListar);
		
		lblNewLabel = new JLabel("Listar Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(Colores.AZUL);
		lblNewLabel.setBounds(10, 28, 177, 22);
		contentPanel.add(lblNewLabel);
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		listarClientes();
	}

	private void listarClientes() {
        // TODO Auto-generated method stub
		System.out.println(ArregloClientes.getClientes());
		ArrayList<Cliente> clientes = ArregloClientes.getClientes();
		model.setRowCount(0);
		for (Cliente cliente : clientes) {
            String[] row = {cliente.getNombres(), cliente.getApellidos(), cliente.getDni(), cliente.getTelefono(), cliente.getDireccion()};
            model.addRow (row);
		}
		
	}
}
