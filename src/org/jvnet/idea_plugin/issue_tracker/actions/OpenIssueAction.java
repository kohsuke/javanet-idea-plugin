package org.jvnet.idea_plugin.issue_tracker.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.vfs.VirtualFile;
import org.jvnet.idea_plugin.issue_tracker.vfs.MemoryVirtualFile;
import org.jvnet.idea_plugin.issue_tracker.IssueTrackerToolWindow;

/**
 * @author Kohsuke Kawaguchi
 */
public class OpenIssueAction extends AnAction {
	public void actionPerformed(AnActionEvent event) {
        IssueTrackerToolWindow tw = IssueTrackerToolWindow.get(event);
        FileEditorManager manager =
                FileEditorManager.getInstance(event.getData(DataKeys.PROJECT));

        String fileName = "HUDSON-1";

        VirtualFile vf = null;
        for (VirtualFile f : manager.getOpenFiles()) {
            if (f.getName().equals(fileName) && (f instanceof MemoryVirtualFile)) {
                vf = f;
                break;
            }
        }

		if (vf == null) {
            vf = new MemoryVirtualFile(fileName);
        }
        
        // either opens a new editor, or focuses the already open one
		manager.openFile(vf, true);
    }
}
