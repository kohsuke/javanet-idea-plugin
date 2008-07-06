package org.jvnet.idea_plugin.issue_tracker.editor;

import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorState;
import com.intellij.openapi.fileEditor.FileEditorStateLevel;
import com.intellij.openapi.fileEditor.FileEditorLocation;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.codeHighlighting.BackgroundEditorHighlighter;
import com.intellij.ide.structureView.StructureViewBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NonNls;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.util.Map;
import java.util.HashMap;

/**
 * @author Kohsuke Kawaguchi
 */
public class IssueEditor extends JPanel implements FileEditor {
    private final Map userData = new HashMap();

    public IssueEditor(Project project, VirtualFile file) {
        add(new JButton("test"));
    }

    @NotNull
    public JComponent getComponent() {
        return this;
    }

    @Nullable
    public JComponent getPreferredFocusedComponent() {
        return this;
    }

    @NonNls
    @NotNull
    public String getName() {
        return "getName-"+this.toString();
    }

    @NotNull
    public FileEditorState getState(@NotNull FileEditorStateLevel level) {
        return FileEditorState.INSTANCE;
    }

    public void setState(@NotNull FileEditorState state) {
    }

    public boolean isModified() {
        // TODO
        return false;
    }

    public boolean isValid() {
        return true;
    }

    public void selectNotify() {
    }

    public void deselectNotify() {
    }

    public void addPropertyChangeListener(@NotNull PropertyChangeListener listener) {
    }

    public void removePropertyChangeListener(@NotNull PropertyChangeListener listener) {
    }

    @Nullable
    public BackgroundEditorHighlighter getBackgroundHighlighter() {
        return null;
    }

    @Nullable
    public FileEditorLocation getCurrentLocation() {
        // JetBrains really need to document what all these things mean
        return null;
    }

    @Nullable
    public StructureViewBuilder getStructureViewBuilder() {
        // TODO: perhaps list up comments?
        return null;
    }

    public <T> T getUserData(Key<T> key) {
        return (T)userData.get(key);
    }

    public <T> void putUserData(Key<T> key, T value) {
        userData.put(key,value);
    }

    public void dispose() {
    }
}
