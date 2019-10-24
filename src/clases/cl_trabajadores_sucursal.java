/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KALEK
 */
public class cl_trabajadores_sucursal {

    cl_conectar c_conectar = new cl_conectar();
    cl_varios c_varios = new cl_varios();

    private int id_trabajador;
    private int id_sucursal;
    private int id_cliente;
    private String dni;
    private String colaborador;
    private String direccion;
    private String nro_cuenta;
    private int estado_civil;
    private String telefono;
    private String fecha_nacimiento;
    private int id_banco;
    private int sexo;

    public cl_trabajadores_sucursal() {
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getColaborador() {
        return colaborador;
    }

    public void setColaborador(String colaborador) {
        this.colaborador = colaborador;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNro_cuenta() {
        return nro_cuenta;
    }

    public void setNro_cuenta(String nro_cuenta) {
        this.nro_cuenta = nro_cuenta;
    }

    public int getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(int estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
    }
    
    public void mostrar(JTable tabla, String query) {
        DefaultTableModel modelo;
        try {
            modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            //c_conectar.conectar();
            Statement st = c_conectar.conexion();
            ResultSet rs = c_conectar.consulta(st, query);

            //La cantidad de columnas que tiene la consulta
            //Establecer como cabezeras el nombre de las colimnas
            modelo.addColumn("Id");
            modelo.addColumn("Dni");
            modelo.addColumn("Colaborador");
            modelo.addColumn("Direccion");
            modelo.addColumn("Numro Cuenta");
            modelo.addColumn("estado civil");
            modelo.addColumn("telefono");
            modelo.addColumn("Fecha nacimiento");
            modelo.addColumn("sexo");
            modelo.addColumn("LL.A.");
            modelo.addColumn("estado");

            //Creando las filas para el JTable
            while (rs.next()) {
                Object[] fila = new Object[11];
                fila[0] = rs.getInt("id_trabajador");
                fila[1] = rs.getString("dni");
                fila[2] = rs.getString("colaborador");
                fila[3] = rs.getString("direccion");
                fila[4] = rs.getString("nro_cuenta");
                int tipo_estadocivil = rs.getInt("estado_civil");
                String nombre_estadocivil = "";
                if (tipo_estadocivil == 1) {
                    nombre_estadocivil = "SOLTERO";
                } else {
                    if (tipo_estadocivil == 2) {
                        nombre_estadocivil = "CASADO";
                    } else {
                        if (tipo_estadocivil == 3) {
                            nombre_estadocivil = "DIVORCIADO";
                        } else {
                            nombre_estadocivil = "VIUDO";
                        }
                    }
                };
                fila[5] = nombre_estadocivil;
                fila[6] = rs.getString("telefono");
                fila[7] = rs.getString("fecha_nacimiento");

                int tipo_sexo = rs.getInt("sexo");
                String nombre_sexo;
                if (tipo_sexo == 1) {
                    nombre_sexo = "FEMENINO";
                } else {
                    nombre_sexo = "MASCULINO";
                }
                fila[8] = nombre_sexo;

                int tipo_estado = rs.getInt("estado");
                String nombre_estado;
                if (tipo_estado == 1) {
                    nombre_estado = "ACTIVO";
                } else {
                    nombre_estado = "NO ACTIVO";
                }
                fila[9] = rs.getInt("nro_llamadas");
                fila[10] = nombre_estado;
                modelo.addRow(fila);
            }

            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(350);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(150);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(6).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(7).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(8).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(9).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(10).setPreferredWidth(80);
            tabla.setDefaultRenderer(Object.class, new render.render_trabajadores());
        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    public boolean registrar() {
        boolean registrado = false;
        Statement st = c_conectar.conexion();
        String query = "insert into trabajadores_sucursal "
                + "Values ('" + id_trabajador + "', '" + id_sucursal + "','" + id_cliente + "','" + dni + "', '" + colaborador + "', '" + direccion + "', '" + nro_cuenta + "', '"
                + estado_civil + "','" + telefono + "', '" + fecha_nacimiento + "','" + sexo + "','" + id_banco + "',1, 0)";
        System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            registrado = true;
        }
        c_conectar.cerrar(st);
        return registrado;
    }

    public void obtener_codigo() {
        try {
            Statement st = c_conectar.conexion();
            String query = "select ifnull(max(id_trabajador) + 1, 1) as codigo "
                    + "from trabajadores_sucursal "
                    + "where id_cliente='" + id_cliente + "' and id_sucursal= '" + id_sucursal + "' ";
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                id_trabajador = rs.getInt("codigo");
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

    }

    public boolean cargar_datos() {
        boolean existe = false;
        try {
            Statement st = c_conectar.conexion();
            String query = "select * "
                    + "from trabajadores_sucursal "
                    + "where id_trabajador='" + id_trabajador + "' and id_cliente='" + id_cliente + "' and id_sucursal='" + id_sucursal + "'";
            System.out.println(query);
            ResultSet rs = c_conectar.consulta(st, query);

            if (rs.next()) {

                dni = rs.getString("dni");
                colaborador = rs.getString("colaborador");
                direccion = rs.getString("direccion");
                nro_cuenta = rs.getString("nro_cuenta");
                estado_civil = rs.getInt("estado_civil");
                telefono = rs.getString("telefono");
                fecha_nacimiento = rs.getString("fecha_nacimiento");
                sexo = rs.getInt("sexo");
                existe = true;
            } else {
                existe = false;
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

        return existe;
    }

    public boolean actualizar() {
        boolean actualizado = false;
        Statement st = c_conectar.conexion();
        String query = "update trabajadores_sucursal "
                + "set dni='" + dni + "', colaborador='" + colaborador + "', direccion='" + direccion + "', nro_cuenta='" + nro_cuenta + "',estado_civil= '"
                + estado_civil + "',telefono='" + telefono + "', fecha_nacimiento='" + fecha_nacimiento + "', sexo='" + sexo + "' "
                + "where id_trabajador='" + id_trabajador + "' and id_sucursal='" + id_sucursal + "' and id_cliente='" + id_cliente + "'";
        System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            actualizado = true;
        }
        c_conectar.cerrar(st);
        return actualizado;
    }

    public boolean eliminar() {
        boolean registrado = false;
        Statement st = c_conectar.conexion();
        String query = "delete from trabajadores_sucursal "
                + "where id_trabajador='" + id_trabajador + "'  and id_sucursal='" + id_sucursal + "' and id_cliente ='" + id_cliente + "'";
        System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            registrado = true;
        }
        c_conectar.cerrar(st);
        return registrado;
    }

    public boolean elimbaja() {
        boolean registrado = false;
        Statement st = c_conectar.conexion();
        String query = "update trabajadores_sucursal set estado = '2'"
                + "where id_trabajador='" + id_trabajador + "'  and id_sucursal='" + id_sucursal + "' and id_cliente ='" + id_cliente + "'";
        System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            registrado = true;
        }
        c_conectar.cerrar(st);
        return registrado;
    }
}
