package org.jvnet.idea_plugin.issue_tracker;

import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Task.Backgroundable;
import com.intellij.openapi.project.Project;

/**
 * @author Kohsuke Kawaguchi
 */
public class Foo {
    public String a,b,c;

    public Foo(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
