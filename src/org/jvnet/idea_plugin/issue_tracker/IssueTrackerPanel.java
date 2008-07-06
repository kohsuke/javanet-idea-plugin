package org.jvnet.idea_plugin.issue_tracker;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.actionSystem.IdeActions;
import com.intellij.util.ui.ListTableModel;
import com.intellij.util.ui.ColumnInfo;
import com.intellij.ui.table.TableView;

import javax.swing.*;
import java.awt.*;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Kohsuke Kawaguchi
 */
public class IssueTrackerPanel extends JPanel {
    public IssueTrackerPanel() {
        super(new BorderLayout());

        add(createToolBar(), BorderLayout.NORTH);

        TableView<Foo> table = new TableView<Foo>(createListTableModel());

        JScrollPane tablePane = new JScrollPane(table);
        tablePane.setWheelScrollingEnabled(true);
        add(tablePane, BorderLayout.CENTER);
    }

    private ListTableModel<Foo> createListTableModel() {
        ListTableModel<Foo> model = new ListTableModel<Foo>(
                new ColumnInfo<Foo,String>("A") {
                    public String valueOf(Foo item) {
                        return item.a;
                    }
                    public int getAdditionalWidth() { return 100; }
                },
                new ColumnInfo<Foo,String>("B") {
                    public String valueOf(Foo item) {
                        return item.b;
                    }

                    public int getWidth(JTable table) { return 30; }

                    public Comparator<Foo> getComparator() {
                        return new Comparator<Foo>() {
                            public int compare(Foo o1, Foo o2) {
                                return o1.a.compareTo(o2.a);
                            }
                        };
                    }
                }
            );

        List<Foo> list = new ArrayList<Foo>();
        list.add(new Foo("HUDSON-1","b","c"));
        list.add(new Foo("HUDSON-2","b","c"));
        list.add(new Foo("a","b","c"));

        model.setItems(list);

        return model;
    }

    private JPanel createToolBar() {
        JPanel toolBarPanel = new JPanel(new BorderLayout());
        ActionManager actionManager = ActionManager.getInstance();
        ActionGroup toolbar = (ActionGroup) actionManager.getAction(IdeActions.GROUP_FILE/*test*/);
        ActionToolbar actionToolbar = actionManager.createActionToolbar(getClass().getName(), toolbar, true);
        toolBarPanel.add(actionToolbar.getComponent(), BorderLayout.NORTH);

        return toolBarPanel;
    }
}
