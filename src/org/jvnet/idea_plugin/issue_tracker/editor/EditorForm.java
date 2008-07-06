package org.jvnet.idea_plugin.issue_tracker.editor;

import javax.swing.*;

/**
 * @author Kohsuke Kawaguchi
 */
public class EditorForm {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JPanel panel;
    private JPanel properties;
    private JPanel form;

    public void postInit() {
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        for(int i=0; i<10; i++) {
            JLabel label = new JLabel("test1",JLabel.LEFT);
            panel.add(label);
            panel.add(new JTextArea("long\ntext"));
        }
    }

    public JComponent getForm() {
        return form;
    }
}
