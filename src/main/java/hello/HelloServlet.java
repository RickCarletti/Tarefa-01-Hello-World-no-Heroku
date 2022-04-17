/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viter
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPostAndGet(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPostAndGet(request, response);
    }

    protected void doPostAndGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String zt = request.getParameter("zt");
        ZoneId teste2;
        if(request.getParameter("zt") == null){
            teste2 = ZoneId.of("Etc/GMT+3");
        }else{
            teste2 = ZoneId.of(zt);
        }
        
        LocalDateTime agr = LocalDateTime.now(teste2);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        String teste = agr.format(formatter);
        String tempoAtual = agr.format(formatter2);

        int hora = Integer.valueOf(teste);

        int tipo;
        if (hora >= 6 && hora < 12) {
            tipo = 1;
        } else if (hora >= 12 && hora <= 18) {
            tipo = 2;
        } else {
            tipo = 3;
        }
        String msg = "";
        String lang = request.getParameter("lang");
        String sex;
        if(request.getParameter("sex") == null){
            sex = "";
        }else{
            sex = request.getParameter("sex");
        }
        if (lang == null) {
            lang = "pt";
        }
        switch (lang) {
            case "pt":
                switch (tipo) {
                    case 1:
                        msg = msg + "Bom dia, ";
                        break;
                    case 2:
                        msg = msg + "Boa tarde, ";
                        break;
                    case 3:
                        msg = msg + "Boa noite, ";
                        break;
                }
                switch (sex) {
                    case "m":
                        msg = msg + "Sr.";
                        break;
                    case "f":
                        msg = msg + "Sra.";
                        break;
                    default:
                        msg = msg + "";
                        break;
                }
                break;
            case "en":
                switch (tipo) {
                    case 1:
                        msg = msg + "Good morning, ";
                        break;
                    case 2:
                        msg = msg + "Good afternoon, ";
                        break;
                    case 3:
                        msg = msg + "Good night, ";
                        break;
                }
                switch (sex) {
                    case "m":
                        msg = msg + "Mr.";
                        break;
                    case "f":
                        msg = msg + "Mrs.";
                        break;
                    default:
                        msg = msg + "";
                        break;
                }
                break;
            case "fr":
                switch (tipo) {
                    case 1:
                        msg = msg + "Bonjour, ";
                        break;
                    case 2:
                        msg = msg + "Bonsoir, ";
                        break;
                    case 3:
                        msg = msg + "Bonne nuit, ";
                        break;
                }
                switch (sex) {
                    case "m":
                        msg = msg + "M.";
                        break;
                    case "f":
                        msg = msg + "Mme.";
                        break;
                    default:
                        msg = msg + "";
                        break;
                }
                break;
            case "de":
                switch (tipo) {
                    case 1:
                        msg = msg + "Guten Morgen, ";
                        break;
                    case 2:
                        msg = msg + "Guten Tag, ";
                        break;
                    case 3:
                        msg = msg + "Gute Nacht, ";
                        break;
                }
                switch (sex) {
                    case "m":
                        msg = msg + "Herr. ";
                        break;
                    case "f":
                        msg = msg + "Frau.";
                        break;
                    default:
                        msg = msg + "";
                        break;
                }
                break;
            case "es":
                switch (tipo) {
                    case 1:
                        msg = msg + "Buen día, ";
                        break;
                    case 2:
                        msg = msg + "Buenas tardes, ";
                        break;
                    case 3:
                        msg = msg + "Buenas noches, ";
                        break;
                }
                switch (sex) {
                    case "m":
                        msg = msg + "Sr.";
                        break;
                    case "f":
                        msg = msg + "Sra.";
                        break;
                    default:
                        msg = msg + "";
                        break;
                }
                break;
            case "it":
                switch (tipo) {
                    case 1:
                        msg = msg + "Buongiorno, ";
                        break;
                    case 2:
                        msg = msg + "Buon pomeriggio, ";
                        break;
                    case 3:
                        msg = msg + "Buona Notte, ";
                        break;
                }
                switch (sex) {
                    case "m":
                        msg = msg + "Mr.";
                        break;
                    case "f":
                        msg = msg + "Mrs.";
                        break;
                    default:
                        msg = msg + "";
                        break;
                }
                break;
        }

        String nome = request.getParameter("nome");

        if (nome == null) {
            nome = "Fulano";
        }

        msg = msg + nome + "! - "+tempoAtual;

        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
