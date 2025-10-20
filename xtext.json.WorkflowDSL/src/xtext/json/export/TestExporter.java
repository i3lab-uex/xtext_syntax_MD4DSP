package xtext.json.export;

import java.io.IOException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;
import com.google.inject.Injector;
import xtext.json.WorkflowDSLStandaloneSetup;
import xtext.json.workflowDSL.Workflow;

/**
 * Test class to verify the custom JSON exporter works correctly
 */
public class TestExporter {
    
    public static void main(String[] args) {
        try {
            // Initialize Xtext
            Injector injector = new WorkflowDSLStandaloneSetup().createInjectorAndDoEMFRegistration();
            
            // Load a workflow file - you'll need to provide the path to your test file
            ResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
            
            // Replace this with the actual path to your workflow file
            String filePath = "/path/to/your/workflow/file.workflow";
            URI uri = URI.createFileURI(filePath);
            Resource resource = resourceSet.getResource(uri, true);
            
            if (!resource.getContents().isEmpty()) {
                Object rootElement = resource.getContents().get(0);
                if (rootElement instanceof Workflow) {
                    Workflow workflow = (Workflow) rootElement;
                    
                    // Use our custom exporter directly
                    WorkflowJsonExporter exporter = new WorkflowJsonExporter();
                    String customJson = exporter.exportToJson(workflow);
                    
                    System.out.println("=== CUSTOM EXPORTER OUTPUT ===");
                    System.out.println(customJson);
                    
                    // Compare with the service
                    WorkflowJsonExportService service = injector.getInstance(WorkflowJsonExportService.class);
                    String serviceJson = service.exportWorkflow(workflow);
                    
                    System.out.println("\n=== SERVICE OUTPUT ===");
                    System.out.println(serviceJson);
                    
                    System.out.println("\n=== ARE THEY EQUAL? ===");
                    System.out.println(customJson.equals(serviceJson));
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}