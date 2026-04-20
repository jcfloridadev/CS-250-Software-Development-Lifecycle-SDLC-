import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class TopFiveDestinationList {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	TopDestinationListFrame topDestinationListFrame = new TopDestinationListFrame();
                topDestinationListFrame.setTitle("Top 5 Destination List");
                topDestinationListFrame.setVisible(true);
            }
        });
    }
}


class TopDestinationListFrame extends JFrame {
    private DefaultListModel listModel;

    public TopDestinationListFrame() {
        super("Top Five Destination List");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1600, 1000);

        listModel = new DefaultListModel();


        addDestinationNameAndPicture("1. Tokyo, Japan – A vibrant city blending modern life with traditional culture. (Image credit: Yan Caradec, Wikimedia Commons)",new ImageIcon(getClass().getResource("/resources/Yamanashi_Japan.jpeg")));
        addDestinationNameAndPicture("2. San Francisco, USA - Famous for the Golden Gate Bridge and scenic coastal views. (Image credit: Frank Schulenburg, Wikimedia Commons)", new ImageIcon(getClass().getResource("/resources/SanFrancisco_USA.jpg")));
        addDestinationNameAndPicture("3. Paris, France - Known for its iconic Eiffel Tower and romantic atmosphere. (Image credit: Taxiarchos228, Wikimedia Commons)", new ImageIcon(getClass().getResource("/resources/Paris_France.jpg")));
        addDestinationNameAndPicture("4. Madrid, Spain - A lively city rich in history, art, and culture. (Image credit: Fernando Pascullo, Wikimedia Commons)", new ImageIcon(getClass().getResource("/resources/Madrid_Spain.jpg")));
        addDestinationNameAndPicture("5. El Nido, Philippines - A tropical paradise with crystal-blue waters, fine-white sand and limestone cliffs. (Image credit: Vyacheslav Argenberg, Wikimedia Commons)", new ImageIcon(getClass().getResource("/resources/ElNido_Philippines.jpg")));
        
        JList list = new JList(listModel);
        list.setBackground(Color.BLACK);
        list.setForeground(Color.WHITE);
        list.setFixedCellHeight(200);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);
        list.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(list);

        TextAndIconListCellRenderer renderer = new TextAndIconListCellRenderer(10);

        list.setCellRenderer(renderer);

        JLabel nameLabel = new JLabel("Developer: Justin Carlo Florida");
        getContentPane().add(nameLabel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void addDestinationNameAndPicture(String text, Icon icon) {
        TextAndIcon tai = new TextAndIcon(text, icon);
        listModel.addElement(tai);
    }
}


class TextAndIcon {
    private String text;
    private Icon icon;

    public TextAndIcon(String text, Icon icon) {
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}


class TextAndIconListCellRenderer extends JLabel implements ListCellRenderer {
    private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);

    private Border insideBorder;

    public TextAndIconListCellRenderer() {
        this(0, 0, 0, 0);
    }

    public TextAndIconListCellRenderer(int padding) {
        this(padding, padding, padding, padding);
    }

    public TextAndIconListCellRenderer(int topPadding, int rightPadding, int bottomPadding, int leftPadding) {
        insideBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list, Object value,
    int index, boolean isSelected, boolean hasFocus) {
        // The object from the combo box model MUST be a TextAndIcon.
        TextAndIcon tai = (TextAndIcon) value;

        // Sets text and icon on 'this' JLabel.
        setText(tai.getText());
        setIcon(tai.getIcon());

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        Border outsideBorder;

        if (hasFocus) {
            outsideBorder = UIManager.getBorder("List.focusCellHighlightBorder");
        } else {
            outsideBorder = NO_FOCUS_BORDER;
        }

        setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        setComponentOrientation(list.getComponentOrientation());
        setEnabled(list.isEnabled());
        setFont(list.getFont());

        return this;
    }

    // The following methods are overridden to be empty for performance
    // reasons. If you want to understand better why, please read:
    //
    // http://java.sun.com/javase/6/docs/api/javax/swing/DefaultListCellRenderer.html#override

    public void validate() {}
    public void invalidate() {}
    public void repaint() {}
    public void revalidate() {}
    public void repaint(long tm, int x, int y, int width, int height) {}
    public void repaint(Rectangle r) {}
}