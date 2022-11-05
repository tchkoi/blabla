package ge.ufc.webservices.ws;

import ge.ufc.webservices.db.DatabaseManager;
import ge.ufc.webservices.db.ServiceADao;
import ge.ufc.webservices.db.ServiceADaoImpl;
import ge.ufc.webservices.exception.DatabaseException;
import ge.ufc.webservices.exception.InternalErrorException;
import ge.ufc.webservices.exception.UserNotFoundException;
import ge.ufc.webservices.model.User;
import ge.ufc.webservices.model.response.CheckResponse;

import javax.ws.rs.core.Response;
import java.sql.Connection;

public class ServiceAImpl implements ServiceA{

    @Override
    public Response check(int userId) {
        Connection connection = null;
        try {
//            logger.info("Opening database connection");
            connection = DatabaseManager.getDatabaseConnection();

            ServiceADao serviceADao = new ServiceADaoImpl(connection);
//            logger.info("Getting movie from the database, imdbId: {}", imdbId);
            User user = serviceADao.getUser(userId);
//            logger.trace("Movie got from the database: {}", movie);

            return Response.status(Response.Status.OK).entity(new CheckResponse(user.getFirstName(), user.getLastName(), user.getBalance())).build();
        } catch (UserNotFoundException e) {
//            logger.warn(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (DatabaseException e) {
//            logger.error("Database exception", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } finally {
            DatabaseManager.close(connection);
        }
    }
}
