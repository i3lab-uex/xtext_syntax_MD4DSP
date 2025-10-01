package xtext.json.export;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import xtext.json.workflowDSL.Workflow;

/**
 * Service for exporting WorkflowDSL resources to JSON format
 */
@Singleton
public class WorkflowJsonExportService {
    
    /**
     * Exports a WorkflowDSL resource to JSON string using our CUSTOM exporter
     */
    public String exportResource(Resource resource) {
        if (resource instanceof XtextResource && !resource.getContents().isEmpty()) {
            Object rootElement = resource.getContents().get(0);
            if (rootElement instanceof Workflow) {
                // Use our CUSTOM exporter directly - bypass any automatic serialization
                WorkflowJsonExporter customExporter = new WorkflowJsonExporter();
                return customExporter.exportToJson((Workflow) rootElement);
            }
        }
        throw new IllegalArgumentException("Resource must contain a valid Workflow model");
    }
    
    /**
     * Exports a Workflow model directly to JSON string using our CUSTOM exporter
     */
    public String exportWorkflow(Workflow workflow) {
        // Use our CUSTOM exporter directly - bypass any automatic serialization
        WorkflowJsonExporter customExporter = new WorkflowJsonExporter();
        return customExporter.exportToJson(workflow);
    }
}