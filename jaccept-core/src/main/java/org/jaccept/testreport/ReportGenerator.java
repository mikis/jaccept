package org.jaccept.testreport;

import java.io.File;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.jaccept.TestEventListener;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class ReportGenerator implements TestEventListener {
    private static final String STYLE_PATH = "org/jaccept/testreport/testreport.xsl";
    private final Logger log = Logger.getLogger(ReportGenerator.class.getName());
    
    private static InputStream styleSheet = null;
    private static boolean specMode = false;
    private static final boolean debug = true;
    private static int step = 0;
    
    private Document doc;
    private Element testprojects;
    private Element currentProject;
    private Element currentSuite;
    private Element currentCase;
    private Element currentTest;
    private Element currentStep;
    private Element currentElement;
    
    public ReportGenerator() {
        String specString = System.getProperty("dk.mikis.specMode");
        if (specString != null && specString.equals("true")) {
            specMode = true;
        }
        initStylesheet();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.newDocument();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e.getMessage());
        }
        testprojects = doc.createElement("testprojects");
        doc.appendChild(testprojects);
    }
    
    private void initStylesheet() {
        try {
            styleSheet = ClassLoader.getSystemClassLoader().getResourceAsStream(STYLE_PATH);
        } catch (Exception e) {
            throw new RuntimeException("Couldn't read " + e.getMessage());
        }
        if (styleSheet == null) log.fatal("Unable to find style sheet "+STYLE_PATH);
    }
    
    public void projectStarted(String name) {
        currentProject = simpleAppend(testprojects, "project", name);
        currentElement = currentProject;
        currentSuite = currentCase = currentTest = currentStep = null;
    }
    public void suiteStarted(String name) {
        currentSuite = simpleAppend(currentProject, "suite", name);
        currentElement = currentSuite;
        currentCase = currentTest = currentStep = null;
    }    
    public void caseStarted(String name) {
        currentCase = simpleAppend(currentSuite, "case", name);
        currentElement = currentCase;
        currentTest = currentStep = null;
    }
    public void testStarted(String name) {
        currentTest = simpleAppend(currentCase, "test", name);
        currentElement = currentTest;
        currentStep = null;
        step = 0;
    }
    public void testEnded() {}
    public void testFailed(String message) {
        if (currentStep != null) {
            currentStep.setAttribute("outcome","&divide;");
        }
        currentElement = currentTest;
        simpleAppend(currentElement, "failure", message);
    }
    public void testError(String message) {
        if (currentStep != null) {
            currentStep.setAttribute("outcome","&divide;");
        }
        currentElement = currentTest;
        simpleAppend(currentElement, "error", message);
    }
    
    public void stepStarted(String stimuli, String expectedResult) {
        currentStep = simpleAppend(currentTest, "step", "");
        currentStep.setAttribute("outcome","&#8730;");
        textAppend(currentStep, "number", "" + ++step);
        textAppend(currentStep, "stimuli", stimuli);
        textAppend(currentStep, "expectedResult", expectedResult);
        currentElement = currentStep;
    } 
    public void stepEnded() {}
    
    public void description(String description) {
        check("Description");
        simpleAppend(currentElement, "def", description);
    }
    
    public void reference(String reference) {
        check("Reference");
        simpleAppend(currentElement, "ref", reference);
    }
    
    
    
    public void generateAllProtocols() {
        generateProtocol(null);
    }
    
    public void generateProtocol(String project) {
        if (debug) System.out.println("Generating test reports .... ");
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(styleSheet));
            transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setParameter("specMode", String.valueOf(specMode));
            
            NodeList projects = doc.getFirstChild().getChildNodes();
            String name;
            
            for(int i = 0; i < projects.getLength(); i++) {
                name = ((Element) projects.item(i)).getAttribute("name");
                if (project != null && ! name.equals(project))
                    continue;
                File file = new File(name + ".html");
                if (debug) System.out.println("Generating project at : " + file.getAbsoluteFile() );
                Source source = new DOMSource(projects.item(i));
                Result result = new StreamResult(file);
                transformer.transform(source, result);
                System.out.println("Generated project: " + name);
            }
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
    
    private Element simpleAppend(Element parent, String kind, String name) {
        if (parent == null) {
            throw new IllegalStateException
            ("Exception in Projects: " +
                    "No parent in hierarchy for " + kind);
        }
        Element child = doc.createElement(kind);
        if (name != null && !name.equals("")) child.setAttribute("name", name);
        parent.appendChild(child);
        return child;
    }
    
    private Element textAppend(Element parent, String kind, String text) {
        Element element = simpleAppend(parent, kind, "");
        element.appendChild(doc.createTextNode(text));
        return element;
    }
    
    private void check(String kind) {
        if ( currentElement == null || currentElement == currentStep) {
            throw new IllegalStateException
            (kind + " can only be added to a project, a suite, a case or a test");
        }
    }
    
    public void addStimuli(String stimuli) {
        // TODO Auto-generated method stub
        
    }
    
    public void addResult(String result) {
        // TODO Auto-generated method stub
        
    }
}
