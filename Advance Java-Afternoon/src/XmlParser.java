import java.io.*;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class XmlParser{

    public static boolean checkLicenseDetails( Element license1, Element license2) {
        return (license1.getAttribute("Date_Status_Effective").equals(license2.getAttribute("Date_Status_Effective")))
                && (license1.getAttribute("State_Code").equals(license1.getAttribute("State_Code")))
                && (license1.getAttribute("License_Number").equals(license2.getAttribute("License_Number")));
    }

    public static void merge(Document file1, Document file2){
        try {

            NodeList csr1 = file1.getElementsByTagName("CSR_Producer");
            NodeList csr2 = file2.getElementsByTagName("CSR_Producer");

            for(int i = 0; i <csr1.getLength(); i++) {
                Node csr1Node = csr1.item(i);
                Element csr1Element = (Element) csr1Node;
                boolean isCsrEqual = false;

                for (int j = 0; j < csr2.getLength(); j++) {
                    Node csr2Node = csr2.item(j);
                    Element csr2Element = (Element) csr2Node;

                    if (csr1Element.getAttribute("NIPR_Number").equals(csr2Element.getAttribute("NIPR_Number"))) {

                        isCsrEqual = true;
                        NodeList csr1ElementDetails = csr1Element.getChildNodes();
                        NodeList csr2ElementDetails = csr2Element.getChildNodes();

                        for (int k = 0; k < csr1ElementDetails.getLength(); k++) {
                            Node licenseDetail1 = csr1ElementDetails.item(k);
                            boolean isLicenseEqual = false;

                            if(licenseDetail1.getNodeType() == Node.ELEMENT_NODE) {
                                Element licenseDetail1Element = (Element) licenseDetail1;
                                for (int l = 0; l < csr2ElementDetails.getLength(); l++) {
                                    Node licenseDetail2 = csr2ElementDetails.item(l);
                                    if (licenseDetail2.getNodeType() == Node.ELEMENT_NODE) {
                                        Element licenseDetail2Element = (Element) licenseDetail2;
                                        if (checkLicenseDetails(licenseDetail1Element, licenseDetail2Element)) {
                                            isLicenseEqual = true;
                                            NodeList childNodes = licenseDetail2.getChildNodes();
                                            for (int m = 0; m < childNodes.getLength(); m++) {
                                                Node n = (Node) file1.importNode(childNodes.item(m),true);
                                                licenseDetail1Element.appendChild(n);
                                            }
                                        }
                                    }
                                }
                                if(!isLicenseEqual)
                                {
                                    licenseDetail1.getParentNode().removeChild(licenseDetail1);
                                }
                            }
                        }
                    }
                }
                if(!isCsrEqual)
                {
                    csr1Node.getParentNode().removeChild(csr1Node);
                }
            }
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(file1);
            StreamResult result = new StreamResult(new StringWriter());
            transformer.transform(source, result);

            Writer output = new BufferedWriter(new FileWriter("mergedXMLFile.xml"));
            String xmlOutput = result.getWriter().toString();
            output.write(xmlOutput);
            output.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkInvalidLicense(Document file)
    {
        try {
            NodeList license_list = file.getElementsByTagName("License");

            for(int i = 0; i <license_list.getLength(); i++) {
                Node license = license_list.item(i);
                Element licenseElement = (Element) license;
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String expirationDate = licenseElement.getAttribute("License_Expiration_Date");
                LocalDate licenseExpirationDate = LocalDate.parse(expirationDate, dateTimeFormatter);
                LocalDate today = LocalDate.now();
                int diff = today.compareTo(licenseExpirationDate);

                    if(diff > 0) {
                        licenseElement.getParentNode().removeChild(licenseElement);
                    }
            }

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(file);
            StreamResult result = new StreamResult(new StringWriter());
            transformer.transform(source, result);

            Writer output = new BufferedWriter(new FileWriter("invalidLicense.xml"));
            String xmlOutput = result.getWriter().toString();
            output.write(xmlOutput);
            output.close();
        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void checkValidLicense(Document file)
    {
        try {
            NodeList license_list = file.getElementsByTagName("License");

            for(int i = 0; i <license_list.getLength(); i++) {
                Node license = license_list.item(i);
                Element licenseElement = (Element) license;
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String expirationDate = licenseElement.getAttribute("License_Expiration_Date");
                LocalDate licenseExpirationDate = LocalDate.parse(expirationDate, dateTimeFormatter);
                LocalDate today = LocalDate.now();
                int diff = today.compareTo(licenseExpirationDate);


                    if(diff > 0) {
                        licenseElement.getParentNode().removeChild(licenseElement);
                    }
            }

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(file);
            StreamResult result = new StreamResult(new StringWriter());
            transformer.transform(source, result);

            Writer output = new BufferedWriter(new FileWriter("validLicense.xml"));
            String xmlOutput = result.getWriter().toString();
            output.write(xmlOutput);
            output.close();
        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String file1 = "xmlFile1.xml";
        String file2 = "xmlFile2.xml";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document1 = builder.parse(new File(file1));
            Document document2 = builder.parse(new File(file2));

            System.out.println("Merging the XML files");
            merge(document1, document2);

            System.out.println("Checking for invalid License");
            checkValidLicense(document1);

            System.out.println("Checking for valid License");
            checkInvalidLicense(document2);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}