package org.jaccept.gui;

import javax.swing.*;
import java.awt.*;

public class DisappearingListRenderer
    extends JLabel
    implements ListCellRenderer {

    public Component getListCellRendererComponent(
        JList list,
        Object value,
        int index,
        boolean isSelected,
        boolean cellHasFocus) {
        String s = value.toString();
        setText(s);
        setBackground(list.getBackground());
        if (index < list.getModel().getSize()-2)
            setForeground(Color.LIGHT_GRAY );
        else if (index < list.getModel().getSize()-1)
            setForeground( Color.GRAY );
        else
            setForeground(list.getForeground() );
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);
        return this;
    }
}
