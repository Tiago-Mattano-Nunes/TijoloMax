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
import model.DAO.CadastroDAO;
import model.DAO.CarrinhoDAO;
import model.DAO.CatDAO;
import model.bean.Cadastro;
import model.bean.Carrinho;
import model.bean.Categorias;


/**
 *
 * @author arlin
 */
public class PagamentoController extends HttpServlet {

    Carrinho produto = new Carrinho();
    CarrinhoDAO produtoDao = new CarrinhoDAO();

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CatDAO categoria = new CatDAO();
        List<Categorias> categorias = categoria.leia();
        request.setAttribute("categoria", categorias);

        Cookie[] cookies3 = request.getCookies();
        int idUsuario = 0; 
        for (Cookie cookie : cookies3) {
            if (cookie.getName().equals("loginManter")) {
                String cookieValue = cookie.getValue();
                try {
                    idUsuario = Integer.parseInt(cookieValue);
                } catch (NumberFormatException e) {
                  
                    e.printStackTrace();
                }
                break; 
            }
        }

        // Verifica se o idUsuario foi definido 
        if (idUsuario != -1) {
            
            CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
            List<Carrinho> carrinhos = carrinhoDAO.listar(idUsuario);
            request.setAttribute("carrinhos", carrinhos);
            float totalPreco = produtoDao.calcular(idUsuario);
            request.setAttribute("totalPreco", totalPreco);
        } else {
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Faça login .');");
            out.println("</script>");
        }

        Cadastro cadastro = new Cadastro();
        CadastroDAO cadastrodao = new CadastroDAO();

        //verifica se está logado recupera as informacoes do usuario
        //verifica se tem um cookie chamado loginManter
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loginManter")) {

                cadastro = cadastrodao.pegarPorId(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", cadastro);
            }
        }

       
        String action = request.getServletPath();
        String nextPage = "/WEB-INF/jsp/pagamento.jsp";
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
