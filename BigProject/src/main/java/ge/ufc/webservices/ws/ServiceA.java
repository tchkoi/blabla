package ge.ufc.webservices.ws;

import ge.ufc.webservices.exception.InternalErrorException;
import ge.ufc.webservices.exception.UserNotFoundException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.ws.rs.core.Response;

@WebService(name = "ServiceA", serviceName = "ServiceA")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface ServiceA {

    @WebMethod(operationName = "check")
    @WebResult(name = "checkResult")
    Response check(@WebParam(name = "userId") int userId) throws UserNotFoundException, InternalErrorException;


}