package ita.servlet;

import ita.daoIMPL.DajOglas_daoIMPL;
import ita.daoIMPL.GetImage_daoIMPL;
import ita.daoIMPL.SetUp_daoIMPL;
import ita.domain.Slika;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

@WebServlet
public class ShowImage extends HttpServlet {

    @Autowired
    SessionFactory sessionFactory;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        try {
            Session s = GetImage_daoIMPL.sessionFactory.getCurrentSession();
            Transaction t = s.beginTransaction();
            Query q = s.createQuery("from Slika where id=" + id);

            Slika slika = (Slika) q.list().get(0);

            response.setContentType(getServletContext().getMimeType("Ivan"));
            response.getOutputStream().write(slika.getSadrzaj());
            response.getOutputStream().close();
            t.commit();

        } catch (Exception ex) {
            Logger.getLogger(ShowImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
