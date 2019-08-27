package com.eduardoquiros.bl.dao.cliente;

import com.eduardoquiros.accesodatos.Conector;
import com.eduardoquiros.bl.dao.pais.MySqlPaisDao;
import com.eduardoquiros.bl.dao.pais.Pais;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class MySqlClienteDao implements IClienteDao {
	private MySqlPaisDao paisDao;
	@Override
	public void insertar(String nombre, String apellido1, String apellido2, String cedula,String contrasenna, String email, String direccion,
	                     Pais nacionalidad, LocalDate fechaNacimiento) throws Exception {
		Conector.getConector().ejecutarSql("insert into clientes(nombre,apellido1,apellido2,cedula,passwd,email,direccion," +
				"nacionalidad,fecha_nacimiento,edad values('"+nombre+"','"+apellido1+"','"+apellido2+"','"+cedula+"','"+
				contrasenna+"','"+
				email+"','"+direccion+"','"+nacionalidad.getCodigo()+"',"+fechaNacimiento+","+
				Period.between(fechaNacimiento,LocalDate.now()).getYears() +");");
	}
	
	@Override
	public ArrayList<Cliente> getUsuarios() throws Exception {
		ArrayList<Cliente> clientes = new ArrayList<>();
		ResultSet rs = Conector.getConector().ejecutarQuery("select nombre,apellido1,apellido2,cedula,email,direccion," +
				"nacionalidad,fecha_nacimiento,edad from clientes");
		while (rs.next()) {
			clientes.add(new Cliente(rs.getString("nombre"),rs.getString("apellido1"),
					rs.getString("apellido2"),rs.getString("cedula"),rs.getString("email"),
					rs.getString("passwd"),
					rs.getString("direccion"),paisDao.buscarPorCodigo(rs.getString("nacionalidad")),
					LocalDate.parse(rs.getString("fecha_nacimiento")),rs.getInt("edad")));
		}
		return clientes;
	}
	
	@Override
	public void eliminar(String codigo) throws Exception {
	Conector.getConector().ejecutarSql("delete from clientes where cedula='"+codigo+"';");
	}
	
	@Override
	public void modificar(String nombre, String apellido1, String apellido2, String cedula, String email,String contrasenna,
	                      String direccion,
	                      Pais nacionalidad, LocalDate fechaNacimiento) throws Exception {
		Conector.getConector().ejecutarSql("update clientes set nombre='"+nombre+"',apellido1='"+apellido1+"',apellido2='"+
				apellido2+"',email='"+email+"',direccion='"+direccion+"',nacionalidad='"+nacionalidad.getCodigo()+"',fecha_nacimiento='"+
				fechaNacimiento+"',passwd='"+contrasenna+"'");
	}
	
	@Override
	public Cliente buscarPorCodigo(String codigo) throws Exception {
		Cliente tmpCliente = new Cliente();
		ResultSet rs = Conector.getConector().ejecutarQuery("select nombre,apellido1,apellido2,cedula,email,direccion,nacionalidad" +
				",fecha_nacimiento,edad from clientes where cedula="+codigo+";");
		while (rs.next()) {
			tmpCliente.setNombre(rs.getString("nombre"));
			tmpCliente.setApellido1(rs.getString("apellido1"));
			tmpCliente.setApellido2(rs.getString("apellido2"));
			tmpCliente.setCedula(rs.getString("cedula"));
			tmpCliente.setEmail(rs.getString("email"));
			tmpCliente.setContrasenna(rs.getString("passwd"));
			tmpCliente.setDireccion(rs.getString("direccion"));
			tmpCliente.setNacionalidad(paisDao.buscarPorCodigo(rs.getString("nacionalidad")));
			tmpCliente.setFechaNacimiento(LocalDate.parse(rs.getString("nacionalidad")));
			tmpCliente.setEdad(rs.getInt("edad"));
		}
		return tmpCliente;
	}
}
