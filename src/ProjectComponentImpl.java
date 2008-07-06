import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jvnet.idea_plugin.issue_tracker.IssueTrackerToolWindow;
import org.jvnet.idea_plugin.issue_tracker.AbstractProjectComponentImpl;

/**
 * @author Kohsuke Kawaguchi
 */
public class ProjectComponentImpl extends AbstractProjectComponentImpl {
    private final Project project;

    public ProjectComponentImpl(Project project) {
        this.project = project;
    }
}
