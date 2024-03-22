package rest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/guardarPersona")
public class GuardarPersonaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String fecha = request.getParameter("fecha");
        int personas = Integer.parseInt(request.getParameter("personas"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurante", "root", "FrankyBelita");
            PreparedStatement stmt = con.prepareStatement("INSERT INTO reservaciones (nombre, email, fecha, personas) VALUES (?, ?, ?, ?)");
            stmt.setString(1, nombre);
            stmt.setString(2, email);
            stmt.setString(3, fecha);
            stmt.setInt(4, personas);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("index.html");
    }
}