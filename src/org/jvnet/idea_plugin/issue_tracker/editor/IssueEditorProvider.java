package org.jvnet.idea_plugin.issue_tracker.editor;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.fileEditor.FileEditorProvider;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorState;
import com.intellij.openapi.fileEditor.FileEditorPolicy;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jdom.Element;
import org.jvnet.idea_plugin.issue_tracker.vfs.MemoryVirtualFile;

/**
 * Hooks up the issue editor to IDEA.
 *
 * @author Kohsuke Kawaguchi
 */
public class IssueEditorProvider implements ApplicationComponent, FileEditorProvider {
    @NonNls
    @NotNull
    public String getComponentName() {
        return getClass().getName();
    }

    public void initComponent() {
    }

    public void disposeComponent() {
    }

    public boolean accept(@NotNull Project project, @NotNull VirtualFile file) {
        return file instanceof MemoryVirtualFile;
    }

    @NotNull
    public FileEditor createEditor(@NotNull Project project, @NotNull VirtualFile file) {
        return new IssueEditor(project,file);
    }

    public void disposeEditor(@NotNull FileEditor editor) {
    }

    @NotNull
    public FileEditorState readState(@NotNull Element sourceElement, @NotNull Project project, @NotNull VirtualFile file) {
        return FileEditorState.INSTANCE;
    }

    public void writeState(@NotNull FileEditorState state, @NotNull Project project, @NotNull Element targetElement) {
    }

    @NotNull
    @NonNls
    public String getEditorTypeId() {
        return getComponentName();
    }

    @NotNull
    public FileEditorPolicy getPolicy() {
        return FileEditorPolicy.HIDE_DEFAULT_EDITOR;
    }
}
