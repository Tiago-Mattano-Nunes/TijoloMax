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
import model.DAO.CadastroDAO;
import model.DAO.CarrinhoDAO;
import model.DAO.CatDAO;
import model.DAO.EnderecosDAO;
import model.bean.Cadastro;
import model.bean.Carrinho;
import model.bean.Categorias;
import model.bean.Enderecos;

@WebServlet(urlPatterns = {"/calcular", "/deletarCarrinho"})
@MultipartConfig
public class CarrinhoController extends HttpServlet {

    Enderecos objProduto = new Enderecos();
    EnderecosDAO objProdutoDao = new EnderecosDAO();

    Carrinho produto = new Carrinho();
    CarrinhoDAO produtoDao = new CarrinhoDAO();

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

        //verifica se está logado recupera as informacoes do usuario
        //verifica se tem um cookie chamado loginManter
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loginManter")) {

                cadastro = cadastrodao.pegarPorId(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", cadastro);//passa as informações do usuario
            }
        }

        //único do usuário
        int idUsuario = 0;
        for (Cookie cookie : cookies) {
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

        if (idUsuario != -1) {
            // Listar o que esta a baixo pelo id so usuario
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
        if (cadastro == null || cadastro.getIdUsuario() <= 0) {
            PrintWriter sout = response.getWriter();
            sout.println("<script type=\"text/javascript\">");
            sout.println("alert('Por favor, faça o cadastro.');");
            sout.println("window.location.href = './Cadastro';");
            sout.println("</script>");
        } else {

            //encaminha a requisição para a paina jsp especificada
            String action = request.getServletPath();
            String url = "/WEB-INF/jsp/carrinho.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     *
     *
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
        if (action.equals("/calcular")) {
            user(request, response);
        } else if (action.equals("/deletarCarrinho")) {
            deletar(request, response);//lida com a requisicao
        } else {
            processRequest(request, response);
        }

    }

    protected void user(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter sout = response.getWriter();
        objProduto.setRua(request.getParameter("rua"));
        objProduto.setNumero(request.getParameter("numero"));
        objProduto.setCidade(request.getParameter("cidade"));
        objProduto.setCep(request.getParameter("cep"));
        objProduto.setEstado(request.getParameter("estado"));
        objProduto.setComplemento(request.getParameter("complemento"));
        objProduto.setIdUsuario(Integer.parseInt(request.getParameter("id")));
        
        

        objProdutoDao.create(objProduto);

        response.sendRedirect("./Agradecimento");

    }

    //lida com a exclusao
    //preocessa a requisicao post
    protected void deletar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action"); //recebe o parametro action, valor delete

        if (action != null && action.equals("delete")) {
            response.sendRedirect("./Carrinho");

            int idCarrinho = Integer.parseInt(request.getParameter("idCarinho"));
            CarrinhoDAO carrinho = new CarrinhoDAO();

            carrinho.deletar(idCarrinho);

        }
    }

   
}
