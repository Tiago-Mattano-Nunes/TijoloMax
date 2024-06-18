/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Dao.CategoriasDAO;
import model.bean.Categorias;

@WebServlet(urlPatterns = "/cadastrocat")
@MultipartConfig
public class CadastroCatController extends HttpServlet {

    Categorias categorias = new Categorias();
    CategoriasDAO categoriasDAO = new CategoriasDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nextPage = "/WEB-INF/jsp/cadastroCat.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
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
        processRequest(request, response);
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
        String action = request.getServletPath();
        if (action.equals("/cadastrocat")) {
            user(request, response);
        } else {
            processRequest(request, response);
        }

    }
 protected void user(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter sout = response.getWriter();
        categorias.setNome(request.getParameter("nome"));
        
        if (categorias.getNome().trim().equals("")) {
            sout.println("<script type=\"text/javascript\">");
            sout.println("alert('Por favor, preencha todos os campos.');");
            sout.println("window.location.href = './CadastroCat';");
            sout.println("</script>");
        } else {
         
            categoriasDAO.cat(categorias);
            response.sendRedirect("./CadastroP");
        }

    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
