package org.jvnet.idea_plugin.issue_tracker;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowAnchor;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * @author Kohsuke Kawaguchi
 */
public class IssueTrackerToolWindow extends AbstractProjectComponentImpl {
    private final Project project;
    /**
     * Handle to {@link ToolWindow} that we created.
     */
    private ToolWindow toolWindow;

    public IssueTrackerToolWindow(Project project) {
        this.project = project;
    }

    // despites @NonNls marker, this seems to be used as the window title
    @NonNls
    @NotNull
    public String getComponentName() {
        return "java.net";
    }

    public void projectOpened() {
        ToolWindowManager toolWindowManager = ToolWindowManager.getInstance(project);
        toolWindow = toolWindowManager.registerToolWindow(getClass().getName(), false, ToolWindowAnchor.BOTTOM);

        // this didn't work
        toolWindow.setTitle("java.net issues");
        toolWindow.setIcon(Icons.ICON);
        toolWindow.getComponent().add(new IssueTrackerPanel());
    }

    public void projectClosed() {
        ToolWindowManager toolWindowManager = ToolWindowManager.getInstance(project);
        toolWindowManager.unregisterToolWindow(getClass().getName());
    }

    public static IssueTrackerToolWindow get(AnActionEvent e) {
        Project p = e.getData(DataKeys.PROJECT);
        return p.getComponent(IssueTrackerToolWindow.class);
    }
}
