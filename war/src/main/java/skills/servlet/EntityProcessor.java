package skills.servlet;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

public interface EntityProcessor<T> {

    void process(HttpServletRequest request, EntityManager em, T entity);

}
