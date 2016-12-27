package tulv.getxmlfromurl;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MySaxHandler extends DefaultHandler {

    boolean foundEmpNo = false;
    boolean foundEmpName = false;
    boolean foundHireDate = false;
    boolean foundSalary = false;

    public static String data="";

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        System.out.println("---------------------------");
        data+="---------------------------\n";
        data+="Start Element :" + qName+"\n";
        System.out.println("Start Element :" + qName);

        if (qName.equals("empNo")) {
            foundEmpNo = true;
        }

        if (qName.equals("empName")) {
            foundEmpName = true;
        }

        if (qName.equals("hireDate")) {
            foundHireDate = true;
        }

        if (qName.equalsIgnoreCase("salary")) {
            foundSalary = true;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        System.out.println("End Element :" + qName);
        data+="End Element :" + qName+"\n";
    }

    @Override
    public void characters(char ch[], int start, int length)
            throws SAXException {

        System.out.println("characters :");

        if (foundEmpNo) {
            System.out.println("Emp No : " + new String(ch, start, length));
            data+="Emp No : " + new String(ch, start, length)+"\n";
            foundEmpNo = false;
        }

        if (foundEmpName) {
            System.out.println("Emp Name : " + new String(ch, start, length));
            data+="Emp Name : " + new String(ch, start, length)+"\n";
            foundEmpName = false;
        }

        if (foundHireDate) {
            System.out.println("Hire Date : " + new String(ch, start, length));
            data+="Hire Date : " + new String(ch, start, length)+"\n";
            foundHireDate = false;
        }

        if (foundSalary) {
            System.out.println("Salary : " + new String(ch, start, length));
            data+="Salary : " + new String(ch, start, length)+"\n";
            foundSalary = false;
        }

    }

}