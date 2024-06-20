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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Dao.CadastroDAO;
import model.Dao.CatDAO;
import model.Dao.ProdutosDAO;
import model.bean.Cadastro;
import model.bean.Categorias;
import model.bean.Produtos;

/**
 *
 * @author Senai
 */
@WebServlet(name = "CategoriaController", urlPatterns = {"/Categoria"})
public class CategoriaController extends HttpServlet {

    Produtos objProduto = new Produtos();
    ProdutosDAO objProdutoDao = new ProdutosDAO();

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

        CatDAO categoria = new CatDAO();
        List<Categorias> categorias = categoria.leia();
        request.setAttribute("categoria", categorias);

        Cadastro cadastro = new Cadastro();
        CadastroDAO cadastrodao = new CadastroDAO();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loginManter")) {

                cadastro = cadastrodao.pegarPorId(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", cadastro);
            }
        }

        ProdutosDAO produto = new ProdutosDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        List<Produtos> produtos = produto.ler3(id);
        request.setAttribute("produtos", produtos);
        String url = "/WEB-INF/jsp/categoriaPassar.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
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
