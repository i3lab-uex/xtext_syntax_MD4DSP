package xtext.json.export;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import xtext.json.WorkflowDSLStandaloneSetup;
import xtext.json.workflowDSL.Workflow;

/**
 * Utility class for easily exporting WorkflowDSL files to JSON format
 */
public class WorkflowJsonExportUtil {
    
    private static Injector injector;
    
    static {
        // Initialize the Xtext standalone setup
        injector = new WorkflowDSLStandaloneSetup().createInjectorAndDoEMFRegistration();
    }
    
    /**
     * Exports a WorkflowDSL file to JSON string using our CUSTOM exporter
     */
    public static String exportFileToJson(String workflowFilePath) throws IOException {
        ResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
        URI uri = URI.createFileURI(workflowFilePath);
        Resource resource = resourceSet.getResource(uri, true);
        
        // Use our CUSTOM exporter directly - bypass any automatic serialization
        if (!resource.getContents().isEmpty()) {
            Object rootElement = resource.getContents().get(0);
            if (rootElement instanceof Workflow) {
                WorkflowJsonExporter customExporter = new WorkflowJsonExporter();
                return customExporter.exportToJson((Workflow) rootElement);
            }
        }
        throw new IllegalArgumentException("Resource must contain a valid Workflow model");
    }
    
    /**
     * Exports a WorkflowDSL file to JSON and saves it to a file
     */
    public static void exportFileToJsonFile(String workflowFilePath, String outputJsonPath) throws IOException {
        String json = exportFileToJson(workflowFilePath);
        
        try (FileWriter writer = new FileWriter(outputJsonPath)) {
            writer.write(json);
        }
    }
    
    /**
     * Exports a Workflow model to JSON string using our CUSTOM exporter
     */
    public static String exportWorkflowToJson(Workflow workflow) {
        // Use our CUSTOM exporter directly - bypass any automatic serialization
        WorkflowJsonExporter customExporter = new WorkflowJsonExporter();
        return customExporter.exportToJson(workflow);
    }
    
    /**
     * Exports a Workflow model to JSON and saves it to a file
     */
    public static void exportWorkflowToJsonFile(Workflow workflow, String outputJsonPath) throws IOException {
        String json = exportWorkflowToJson(workflow);
        
        try (FileWriter writer = new FileWriter(outputJsonPath)) {
            writer.write(json);
        }
    }
}