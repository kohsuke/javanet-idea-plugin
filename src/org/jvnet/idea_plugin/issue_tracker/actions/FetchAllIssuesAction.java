package org.jvnet.idea_plugin.issue_tracker.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Task.Backgroundable;

/**
 * @author Kohsuke Kawaguchi
 */
public class FetchAllIssuesAction extends AnAction {
    public void actionPerformed(AnActionEvent e) {
        new Backgroundable(e.getData(DataKeys.PROJECT),"Fetching issues",true) {
            public void run(final ProgressIndicator indicator) {
                try {
                    // the setFraction invocation has to happen after the modal dialog is created,
                    // so as a work around we do this initialization in the UI thread.
                    // this is probably a bug in IDEA.
                    ApplicationManager.getApplication().invokeLater(new Runnable() {
                        public void run() {
                            indicator.setIndeterminate(true);
                            indicator.setFraction(100);
                        }
                    });

                    System.out.println("started work: "+indicator);
                    for( int i=0; i<5; i++ ) {
                        Thread.sleep(1000);
                    }
                    System.out.println("end work");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            public boolean shouldStartInBackground() {
                return false;
            }
        }.queue();

    }
}
