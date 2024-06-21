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
import model.Dao.CarrinhoDAO;
import model.Dao.CatDAO;
import model.Dao.ProdutosDAO;
import model.bean.Cadastro;
import model.bean.Carrinho;
import model.bean.Categorias;
import model.bean.Produtos;

@WebServlet(urlPatterns = "/enviarFormulario")
@MultipartConfig
public class PUnicoController extends HttpServlet {

    Carrinho produto = new Carrinho();
    CarrinhoDAO produtoDao = new CarrinhoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CatDAO categoria = new CatDAO();
        List<Categorias> categorias = categoria.leia();
        request.setAttribute("categoria", categorias);

        ProdutosDAO produto = new ProdutosDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        List<Produtos> produtos = produto.ler2(id);
        request.setAttribute("produtos", produtos);
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
            CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
            List<Carrinho> carrinhos = carrinhoDAO.listar(idUsuario);
            request.setAttribute("carrinho", carrinhos);
            
        } else {
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Faça login.');");
            out.println("</script>");
        }

        if (cadastro == null || cadastro.getIdUsuario() <= 0) {
            PrintWriter sout = response.getWriter();
            sout.println("<script type=\"text/javascript\">");
            sout.println("alert('Por favor, faça o cadastro.');");
            sout.println("window.location.href = './Cadastro';");
            sout.println("</script>");
        } else {
            String action = request.getServletPath();
            String url = "/WEB-INF/jsp/pUnico.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
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
        if (action.equals("/enviarFormulario")) {
            carrinho(request, response);
        } else {
            processRequest(request, response);
        }

    }

    protected void carrinho(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            Part filePart = request.getPart("imagem");
            InputStream inputStream = filePart.getInputStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("loginManter")) {
                    request.setAttribute("abacate", cookie.getValue());
                    byte[] imageBytes = outputStream.toByteArray();
                    produto.setNomeCarrinho(request.getParameter("nome"));
                    produto.setPrecoCarrinho(Float.parseFloat(request.getParameter("preco")));
                    produto.setDescricaoCarrinho(request.getParameter("descricao"));
                    produto.setImagemCarrinho(imageBytes);
                    produto.setQuantidadeCarrinho(Integer.parseInt(request.getParameter("quantidade")));
                    produto.setIdProdutos(Integer.parseInt(request.getParameter("idProduto")));
                    produto.setIdUsuario(Integer.parseInt(cookie.getValue()));
                    produtoDao.criar(produto);
                    System.out.println(cookie.getValue());
                }
            }
        } catch (Exception e) {
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
