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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Dao.CadastroDAO;
import model.Dao.EnderecosDAO;
import model.bean.Cadastro;
import model.bean.Categorias;
import model.bean.Enderecos;

@WebServlet(urlPatterns = {"/criar", "/logar"})
@MultipartConfig
public class CadastroController extends HttpServlet {

    Cadastro usuario = new Cadastro();
    CadastroDAO usuarioDao = new CadastroDAO();

    Enderecos endereco = new Enderecos();
     EnderecosDAO enderecodao = new EnderecosDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nextPage = "/WEB-INF/jsp/cadastro.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        if (action.equals("/logar")) {
            logar(request, response);
        } else {
            processRequest(request, response);
        }
    }

    protected void logar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cadastro usuario = new Cadastro();
        Enderecos endereco = new Enderecos();
        usuario.setEmail(request.getParameter("email"));
        usuario.setSenha(request.getParameter("senha"));
        System.out.println("idusuario" + usuario.getIdUsuario());
        int idUsuario = usuarioDao.validaUser(usuario);
       
        
        PrintWriter sout = response.getWriter();
        if (usuario.getEmail().trim().isEmpty() || usuario.getSenha().trim().isEmpty()) {
            sout.println("<script type=\"text/javascript\">");
            sout.println("alert('Por favor, preencha todos os campos.');");
            sout.println("window.location.href = './Cadastro';");
            sout.println("</script>");
        } else {
            if (idUsuario > 0) {

                Cookie servilet = new Cookie("loginManter", Integer.toString(idUsuario));
                response.addCookie(servilet);

               

                if (idUsuario == 1) {
                    response.sendRedirect("./TelaADM");
                } else {
                    response.sendRedirect("./Index");
                }
            } else {
                sout.println("<script type=\"text/javascript\">");
                sout.println("alert('Por favor, faça o cadastro.');");
                sout.println("window.location.href = './Cadastro';");
                sout.println("</script>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        if (action.equals("/criar")) {
            user(request, response);
        } else {
            processRequest(request, response);
        }

    }

    protected void user(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter sout = response.getWriter();
        usuario.setNome(request.getParameter("nome"));
        usuario.setSenha(request.getParameter("senha"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setCpf(request.getParameter("cpf"));
        usuario.setTelefone(request.getParameter("telefone"));

        if (usuario.getNome().trim().equals("")
                || usuario.getSenha().trim().equals("")
                || usuario.getEmail().trim().equals("")
                || usuario.getCpf().trim().equals("")
                || usuario.getTelefone().trim().equals("")) {
            sout.println("<script type=\"text/javascript\">");
            sout.println("alert('Por favor, preencha todos os campos.');");
            sout.println("window.location.href = './Cadastro';");
            sout.println("</script>");
        } else {

            usuarioDao.createq(usuario);
            response.sendRedirect("./Cadastro");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
