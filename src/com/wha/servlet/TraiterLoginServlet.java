package com.wha.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TraiterLoginServlet
 */
@WebServlet(name = "TraiterLoginServlet", urlPatterns = { "/traiterLogin.html" })
public class TraiterLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraiterLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		out.println("<h1>Bienvenue chez Global Knowledge</h1>");
		out.println("<a href=\"login.html\">Se connecter</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String identifiant = (String) req.getParameter("login");
		String motDePasse = (String) req.getParameter("motDePasse");
		
		res.setHeader("Pragma", "No-cache");
		res.setDateHeader("Expires", 0);
		res.setHeader("Cache-Control", "no-cache");
		
		if (identifiant.equals("Mathieu") && motDePasse.equals("mathbono1")) {
			HttpSession session = req.getSession(true);
			session.setAttribute("utilisateur", identifiant);
			
			res.sendRedirect(req.getContextPath() + "/pagePrincipale.jsp");
			System.out.println("Connexion réussie, bonjour " + identifiant + " !");
		}
		else {
			res.sendRedirect(req.getContextPath() + "/erreur.html");
			System.out.println("Connexion impossible");
		}
		doGet(req, res);
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		out.println("<br>Identifiant : " + identifiant + " ; mot de passe : " + motDePasse);
	}
}
