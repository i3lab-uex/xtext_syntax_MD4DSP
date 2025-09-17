package xtext.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class ExportToXmiHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        ISelection selection = HandlerUtil.getCurrentSelection(event);

        if (selection instanceof IStructuredSelection) {
            IStructuredSelection structuredSelection = (IStructuredSelection) selection;
            Object firstElement = structuredSelection.getFirstElement();

            if (firstElement instanceof IFile) {
                IFile file = (IFile) firstElement;

                if ("mm_m4ds".equals(file.getFileExtension())) {
                    try {
                        exportToXmi(file);
                        MessageDialog.openInformation(
                            HandlerUtil.getActiveShell(event),
                            "Export Successful",
                            "File exported to XMI successfully: " +
                            file.getName().replace(".mm_m4ds", ".xmi")
                        );
                    } catch (Exception e) {
                        MessageDialog.openError(
                            HandlerUtil.getActiveShell(event),
                            "Export Error",
                            "Failed to export to XMI: " + e.getMessage()
                        );
                    }
                }
            }
        }
        return null;
    }

    private void exportToXmi(IFile file) throws Exception {
        // Create resource set
        ResourceSet resourceSet = new ResourceSetImpl();

        // Register XMI resource factory
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
            .put("xmi", new XMIResourceFactoryImpl());

        // Load the MM_M4DS file
        URI sourceUri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
        Resource sourceResource = resourceSet.getResource(sourceUri, true);

        // Create XMI file URI
        IPath targetPath = file.getFullPath().removeFileExtension().addFileExtension("xmi");
        URI targetUri = URI.createPlatformResourceURI(targetPath.toString(), true);

        // Create XMI resource and copy content
        Resource targetResource = resourceSet.createResource(targetUri);
        targetResource.getContents().addAll(sourceResource.getContents());

        // Save XMI file
        targetResource.save(null);

        // Refresh workspace
        file.getParent().refreshLocal(IResource.DEPTH_ONE, null);
    }
}
