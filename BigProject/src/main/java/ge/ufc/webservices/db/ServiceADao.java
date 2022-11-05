package ge.ufc.webservices.db;

import ge.ufc.webservices.exception.DatabaseException;
import ge.ufc.webservices.exception.UserNotFoundException;
import ge.ufc.webservices.model.User;

public interface ServiceADao {

    User getUser(int userId) throws UserNotFoundException, DatabaseException;
}
