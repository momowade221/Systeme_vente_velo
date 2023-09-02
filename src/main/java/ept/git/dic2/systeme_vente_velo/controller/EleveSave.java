package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.model.Eleve;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SaveEleve", urlPatterns = "/SaveEleve")
public class EleveSave extends HttpServlet {
   @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       response.setContentType("text/html");

       // Hello
       PrintWriter out = response.getWriter();
       System.out.println("Traitement du formulaire ");
        String prenom  = request.getParameter("prenom");
        String nom  = request.getParameter("nom");
       String poids  = request.getParameter("poids");

       System.out.println("prenom");
       System.out.println("nom");
       System.out.println("poids ");

       Eleve eleve = new Eleve();
       eleve.setPrenom(prenom);
       eleve.setNom(nom);
       eleve.setPoids(Double.parseDouble((poids)));
        out.println(eleve);

       System.out.println(eleve);
       // request.getgetRequestDispatcher permet de d'inclure le contenu d'une ressource (page ou servlet) ou de la redirection
        // include : copie le contenu et le met dans la page de réponse
       //request.getRequestDispatcher("/WEB-INF/ok.html").forward(request,response);
        }

}
