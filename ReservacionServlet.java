package org.example;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ReservacionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los datos del formulario
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String fecha = request.getParameter("fecha");
        int personas = Integer.parseInt(request.getParameter("personas"));

        // Guardar los datos en la base de datos
        Connection con = null;
        PreparedStatement ps = null;
        try {
            // Establecer la conexión con la base de datos
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurante", "usuariodecadauno", "lacontraseñadecadauno");

            // Preparar la consulta SQL
            String sql = "INSERT INTO reservaciones (nombre, email, fecha, personas) VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, email);
            ps.setString(3, fecha);
            ps.setInt(4, personas);

            // Ejecutar la consulta
            ps.executeUpdate();

            // Redirigir a una página de éxito
            response.sendRedirect("exito.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar el error, redirigir a una página de error, etc.
        } finally {
            // Cerrar la conexión y los recursos
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
