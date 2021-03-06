package skills.servlet;

import skills.beans.Classifications;
import skills.beans.Profile;
import skills.db.PersonDao;
import skills.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * See the servlet mapping in web.xml
 */
@WebServlet("/profile")
public final class ProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final EntityProcessor<Person> doPostProcessor =
            new UpdatePersonProfile();

    private final PersonDao dao = new PersonDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        handle(request, response, null);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        handle(request, response, doPostProcessor);
    }

    private void handle(HttpServletRequest request,
                        HttpServletResponse response,
                        EntityProcessor<Person> processor)
            throws ServletException, IOException {

        final String login = request.getUserPrincipal().getName();

        final EntityManager em = getEntityManager(request);
        try {
            final Person person;
            final EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                person = dao.getPerson(login, em);
                if (processor != null) {
                    processor.process(request, em, person);
                }
                transaction.commit();

            } catch (PersistenceException e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                throw e;
            }

            response.getOutputStream();


            request.setAttribute("profile", new Profile(person));
            request.setAttribute("classifications", new Classifications(em));

            getServletContext().getRequestDispatcher("/profile.jspx")
                    .forward(request, response);

        } finally {
            em.close();
        }
    }

    private static EntityManager getEntityManager(HttpServletRequest request) {
        final EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext()
                .getAttribute("emf");

        return emf.createEntityManager();
    }

}
