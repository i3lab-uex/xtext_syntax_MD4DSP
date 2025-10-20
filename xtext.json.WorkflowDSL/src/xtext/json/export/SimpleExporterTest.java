package xtext.json.export;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import xtext.json.WorkflowDSLStandaloneSetup;
import xtext.json.workflowDSL.Workflow;

/**
 * Simple test to verify our custom JSON exporter works
 */
public class SimpleExporterTest {
    
    public static void main(String[] args) {
        try {
            // Sample workflow DSL content
            String workflowContent = 
                "workflow \"Student Data Pipeline\" {\n" +
                "    source data = read_csv(\"/data/students.csv\")\n" +
                "    \n" +
                "    clean = filter_rows { missing(Equipment, include) }\n" +
                "    numeric = to_numeric(Age, Grade) |> clean\n" +
                "}";
            
            // Initialize Xtext
            Injector injector = new WorkflowDSLStandaloneSetup().createInjectorAndDoEMFRegistration();
            ResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
            
            // Create resource from string content using ByteArrayInputStream
            Resource resource = resourceSet.createResource(URI.createURI("test.workflow"));
            ByteArrayInputStream inputStream = new ByteArrayInputStream(workflowContent.getBytes());
            resource.load(inputStream, null);
            
            if (!resource.getContents().isEmpty()) {
                Object rootElement = resource.getContents().get(0);
                if (rootElement instanceof Workflow) {
                    Workflow workflow = (Workflow) rootElement;
                    
                    // Use our custom exporter directly
                    WorkflowJsonExporter exporter = new WorkflowJsonExporter();
                    String json = exporter.exportToJson(workflow);
                    
                    System.out.println("=== CUSTOM EXPORTER OUTPUT ===");
                    System.out.println(json);
                } else {
                    System.out.println("Root element is not a Workflow: " + rootElement.getClass());
                }
            } else {
                System.out.println("Resource is empty");
                System.out.println("Errors: " + resource.getErrors());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}