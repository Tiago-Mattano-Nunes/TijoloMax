/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Dao.CadastroDAO;
import model.Dao.EnderecosDAO;
import model.bean.Cadastro;
import model.bean.Enderecos;

/**
 *
 * @author arlin
 */
public class CartaoDebitoController extends HttpServlet {

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

        Cadastro cadastro = new Cadastro();
        CadastroDAO cadastrodao = new CadastroDAO();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loginManter")) {

                cadastro = cadastrodao.pegarPorId(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", cadastro);
            }
        }
        
        int idUsuario = -1; // Valor padrão, caso não seja possível extrair o ID do usuário do cookie
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loginManter")) {
                String cookieValue = cookie.getValue();
                try {
                    idUsuario = Integer.parseInt(cookieValue);
                } catch (NumberFormatException e) {
                    // Em caso de falha na conversão, o idUsuario permanecerá como -1
                    e.printStackTrace(); // ou outro tratamento de erro, se desejado
                }
                break; // Encerra o loop assim que encontrar o cookie desejado
            }
        }

        // Verifica se o idUsuario foi definido com sucesso
        if (idUsuario != -1) {
            // Use o idUsuario para listar o carrinho
           

            EnderecosDAO enderecosdao = new EnderecosDAO();
            List<Enderecos> endereco = enderecosdao.listarEndereco(idUsuario);
            request.setAttribute("enderecos", endereco);

          
        } else {
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Faça login .');");
            out.println("</script>");
        }

        String nextPage = "/WEB-INF/jsp/cartaoDebito.jsp";
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
        processRequest(request, response);
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
