package org.jvnet.idea_plugin.issue_tracker.editor;

import com.intellij.ui.JScrollPane2;

import javax.swing.*;
import javax.swing.border.BevelBorder;

/**
 * @author Kohsuke Kawaguchi
 */
public class EditorForm {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JPanel panel;
    private JPanel properties;
    private JPanel form;

    private JScrollPane outerMost;

    /**
     * IntelliJ chokes when I try to place certain components,
     * so this is a work around to manually create them.
     */
    public void postInit() {
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        for(int i=0; i<10; i++) {
            JLabel label = new JLabel("test1",JLabel.LEFT);
            panel.add(label);

            JTextArea text = new JTextArea("long\ntext");
            text.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
            panel.add(text);
        }

        outerMost = new JScrollPane(form,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        outerMost.setBorder(BorderFactory.createEmptyBorder());
    }

    public JComponent getForm() {
        return outerMost;
    }
}
