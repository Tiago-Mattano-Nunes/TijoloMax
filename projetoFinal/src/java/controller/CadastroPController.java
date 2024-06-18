/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Dao.CadastroDAO;
import model.Dao.ProdutosDAO;
import model.bean.Produtos;
import model.bean.Categorias;
import model.Dao.CatDAO;
import model.bean.Cadastro;

/**
 *
 * @author Senai
 */
@WebServlet(urlPatterns = "/criarbanco")
@MultipartConfig
public class CadastroPController extends HttpServlet {

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
        request.setAttribute("categoria", categorias );
        String nextPage = "/WEB-INF/jsp/cadastroProdutos.jsp";
        Cadastro cadastro = new Cadastro();
        CadastroDAO cadastrodao = new CadastroDAO();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loginManter")) {

                cadastro = cadastrodao.pegarPorId(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", cadastro);
            }
        }
        
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
        if (action.equals("/criarbanco")) {
            produtoAdd(request, response);
        }

    }

    protected void produtoAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Part filePart = request.getPart("imagem");
        objProduto.setNomeProdutos(request.getParameter("nome"));
        objProduto.setCategoria(Integer.parseInt(request.getParameter("categoria")));
        objProduto.setDescricao(request.getParameter("descricao"));
        InputStream inputStream = filePart.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        if (objProduto.getNomeProdutos().trim().equals("")
                || objProduto.getDescricao().trim().equals("")) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Por favor, preencha todos os campos.');");
            out.println("window.location.href = './CadastroP';");
            out.println("</script>");
        } else {
            byte[] imageBytes = outputStream.toByteArray();

            objProduto.setImagem(imageBytes);
            objProduto.setNomeProdutos(request.getParameter("nome"));
            objProduto.setCategoria(Integer.parseInt(request.getParameter("categoria")));
            objProduto.setPreco(Float.parseFloat(request.getParameter("preco")));
            objProduto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
            objProduto.setDescricao(request.getParameter("descricao"));
            objProdutoDao.create(objProduto);
            response.sendRedirect("./CadastroP");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
