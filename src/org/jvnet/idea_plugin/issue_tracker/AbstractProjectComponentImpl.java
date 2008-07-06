package org.jvnet.idea_plugin.issue_tracker;

import com.intellij.openapi.components.ProjectComponent;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * @author Kohsuke Kawaguchi
 */
public abstract class AbstractProjectComponentImpl implements ProjectComponent {
    @NonNls
    @NotNull
    public String getComponentName() {
        return getClass().getName();
    }

    public void projectOpened() {
    }

    public void projectClosed() {
    }

    public void initComponent() {
    }

    public void disposeComponent() {
    }
}
