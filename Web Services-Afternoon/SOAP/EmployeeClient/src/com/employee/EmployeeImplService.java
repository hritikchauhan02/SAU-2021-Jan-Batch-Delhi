
package com.employee;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "EmployeeImplService", targetNamespace = "http://employee.com", wsdlLocation = "http://localhost:8080/EmployeeService/services/EmployeeImpl?wsdl")
public class EmployeeImplService
    extends Service
{

    private final static URL EMPLOYEEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException EMPLOYEEIMPLSERVICE_EXCEPTION;
    private final static QName EMPLOYEEIMPLSERVICE_QNAME = new QName("http://employee.com", "EmployeeImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/EmployeeService/services/EmployeeImpl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        EMPLOYEEIMPLSERVICE_WSDL_LOCATION = url;
        EMPLOYEEIMPLSERVICE_EXCEPTION = e;
    }

    public EmployeeImplService() {
        super(__getWsdlLocation(), EMPLOYEEIMPLSERVICE_QNAME);
    }

    public EmployeeImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), EMPLOYEEIMPLSERVICE_QNAME, features);
    }

    public EmployeeImplService(URL wsdlLocation) {
        super(wsdlLocation, EMPLOYEEIMPLSERVICE_QNAME);
    }

    public EmployeeImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, EMPLOYEEIMPLSERVICE_QNAME, features);
    }

    public EmployeeImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EmployeeImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns EmployeeImpl
     */
    @WebEndpoint(name = "EmployeeImpl")
    public EmployeeImpl getEmployeeImpl() {
        return super.getPort(new QName("http://employee.com", "EmployeeImpl"), EmployeeImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EmployeeImpl
     */
    @WebEndpoint(name = "EmployeeImpl")
    public EmployeeImpl getEmployeeImpl(WebServiceFeature... features) {
        return super.getPort(new QName("http://employee.com", "EmployeeImpl"), EmployeeImpl.class, features);
    }

    private static URL __getWsdlLocation() {
        if (EMPLOYEEIMPLSERVICE_EXCEPTION!= null) {
            throw EMPLOYEEIMPLSERVICE_EXCEPTION;
        }
        return EMPLOYEEIMPLSERVICE_WSDL_LOCATION;
    }

}
