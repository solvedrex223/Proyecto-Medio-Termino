package proyecto;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerListModel;

public class Main extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Empleado[] emp = new Empleado [1];
	int cont = 1;
	JPanel grid = new JPanel ();
	JLabel numEmp = new JLabel ("Numero de empleados:"),
		   nombre = new JLabel ("Nombre: "),
		   apellidoP = new JLabel ("Apellido Paterno: "),
		   apellidoM = new JLabel ("Apellido Materno: "),
		   anio = new JLabel ("Año: "),
		   fechaNacimiento = new JLabel ("Fecha de nacimiento: "),
		   mes = new JLabel ("Mes: "),
		   dia = new JLabel ("Dia: "),
		   direccion = new JLabel ("Direccion: "),
		   rfc = new JLabel ("RFC: "),
		   departamento = new JLabel ("Departamento: "),
		   puesto = new JLabel ("Puesto: "),
		   empty = new JLabel (),
		   empty1 = new JLabel (),
		   empty2 = new JLabel (),
		   empty3 = new JLabel ();
	JButton bTam = new JButton ("Aceptar"),
			bNombre = new JButton ("Aceptar"),
			bApellidoP = new JButton ("Aceptar"),
			bApellidoM = new JButton ("Aceptar"),
			aEmpleado = new JButton ("Añadir Empleado"),
			borrEmpleado = new JButton ("Borrar Empleado"),
			modEmpleado = new JButton ("Buscar Empleado"),
			bNacimiento = new JButton ("Aceptar"),
			bDireccion = new JButton ("Aceptar"),
			bRFC = new JButton ("Aceptar"),
			bDepartamento = new JButton ("Aceptar"),
			bPuesto = new JButton ("Aceptar");
	JTextArea lim = new JTextArea (),
			  tNombre = new JTextArea (),
			  tApellidoP = new JTextArea (),
			  tApellidoM = new JTextArea (),
			  tDireccion = new JTextArea (),
			  tRFC = new JTextArea (),
			  tPuesto = new JTextArea ();
	String sNombre = "",
		   sApellidoP = "",
		   sApellidoM = "";
	String [] meses = {"1","2","3","4","5","6","7","8","9","10","11","12"},
			anios,
			dias,
			departementos = {};
	SpinnerListModel slMeses = new SpinnerListModel (meses),
					 slDias,
					 slAnios,
					 slDepartamentos;
	JSpinner sDia,
	 sMes = new JSpinner (slMeses),
	 sAnio,
	 sDepartamentos;

	Main (){
		super();
		this.printAnios();
		slDias = new SpinnerListModel (dias);
		slAnios = new SpinnerListModel (anios);
		sDia = new JSpinner (slDias);
		sAnio = new JSpinner (slAnios);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		grid.setLayout(new GridLayout (10,3));
		
		bTam.addActionListener(this);
		bNombre.addActionListener(this);
		bApellidoP.addActionListener(this);
		bApellidoM.addActionListener(this);
		borrEmpleado.addActionListener(this);
		aEmpleado.addActionListener(this);
		bDireccion.addActionListener(this);
		bRFC.addActionListener(this);
		bDepartamento.addActionListener(this);
		bPuesto.addActionListener(this);
		
		
		grid.add(numEmp);
		grid.add(lim);
		grid.add(bTam);
		grid.add(aEmpleado);
		grid.add(borrEmpleado);
		grid.add(modEmpleado);
		grid.add(nombre);
		grid.add(tNombre);
		grid.add(bNombre);
		grid.add(apellidoP);
		grid.add(tApellidoP);
		grid.add(bApellidoP);
		grid.add(apellidoM);
		grid.add(tApellidoM);
		grid.add(bApellidoM);
		grid.add(fechaNacimiento);
		grid.add(empty);
		grid.add(empty1);
		grid.add(dia);
		grid.add(sDia);
		grid.add(empty2);
		grid.add(mes);
		grid.add(sMes);
		grid.add(empty3);
		grid.add(anio);
		grid.add(sAnio);
		grid.add(bNacimiento);
		grid.add(rfc);
		grid.add(tRFC);
		grid.add(bRFC);
		grid.add(direccion);
		grid.add(tDireccion);
		grid.add(bDireccion);
		
		aEmpleado.setVisible(false);
		borrEmpleado.setVisible(false);
		modEmpleado.setVisible(false);
		nombre.setVisible(false);
		tNombre.setVisible(false);
		bNombre.setVisible(false);
		apellidoP.setVisible(false);
		tApellidoP.setVisible(false);
		bApellidoP.setVisible(false);
		apellidoM.setVisible(false);
		tApellidoM.setVisible(false);
		bApellidoM.setVisible(false);
		fechaNacimiento.setVisible(false);
		dia.setVisible(false);
		sDia.setVisible(false);
		mes.setVisible(false);
		sMes.setVisible(false);
		anio.setVisible(false);
		sAnio.setVisible(false);
		bNacimiento.setVisible(false);
		
		this.add(grid);
		this.pack();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bTam) {
			if (lim.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Favor de completar la información", "Error", JOptionPane.INFORMATION_MESSAGE);;
			}
			else {
				emp = new Empleado [(int)Float.parseFloat(lim.getText())];
				aEmpleado.setVisible(true);
				borrEmpleado.setVisible(true);
				modEmpleado.setVisible(true);
				lim.setVisible(false);
				numEmp.setVisible(false);
				bTam.setVisible(false);
			}
		}
		if(e.getSource() == aEmpleado) {
			aEmpleado.setVisible(false);
			borrEmpleado.setVisible(false);
			modEmpleado.setVisible(false);
			nombre.setVisible(true);
			tNombre.setVisible(true);
			bNombre.setVisible(true);
		}
		if (e.getSource() == bNombre) {
			sNombre = tNombre.getText();
			nombre.setVisible(false);
			tNombre.setVisible(false);
			bNombre.setVisible(false);
			apellidoP.setVisible(true);
			tApellidoP.setVisible(true);
			bApellidoP.setVisible(true);
		}
		if (e.getSource() == bApellidoP) {
			sApellidoP = tApellidoP.getText();
			apellidoP.setVisible(false);
			tApellidoP.setVisible(false);
			bApellidoP.setVisible(false);
			apellidoM.setVisible(true);
			tApellidoM.setVisible(true);
			bApellidoM.setVisible(true);
		}
		if (e.getSource() == bApellidoM) {
			sApellidoM = tApellidoM.getText();
			apellidoM.setVisible(false);
			tApellidoM.setVisible(false);
			bApellidoM.setVisible(false);
			fechaNacimiento.setVisible(true);
			dia.setVisible(true);
			sDia.setVisible(true);
			mes.setVisible(true);
			sMes.setVisible(true);
			anio.setVisible(true);
			sAnio.setVisible(true);
			bNacimiento.setVisible(true);
		}
		if (e.getSource() == bNacimiento) {
			
		}
		
	}
	
	private void printAnios () {
		int cant = 2018 - 1930;
		anios = new String [cant];
		dias = new String [31];
		for (int i = 0;i < cant; i++) {
			 anios [i] = String.valueOf(i + 1930);
		}
		
		for (int i = 1;i < 32; i++) {
			dias [i-1] = String.valueOf(i);
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}

	
}
