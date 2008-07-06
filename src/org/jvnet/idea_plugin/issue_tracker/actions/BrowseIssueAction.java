package org.jvnet.idea_plugin.issue_tracker.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.ide.BrowserUtil;
import org.jvnet.idea_plugin.issue_tracker.IssueTrackerToolWindow;

/**
 * Opens an issue in the browser.
 * 
 * @author Kohsuke Kawaguchi
 */
public class BrowseIssueAction extends AnAction {
    public void actionPerformed(AnActionEvent event) {
        IssueTrackerToolWindow tw = IssueTrackerToolWindow.get(event);
        if (tw != null) {
            BrowserUtil.launchBrowser("http://www.java.net/");
        }
    }
}
