import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App extends Frame {
    public App() {
        Button b = new Button("Button");
        b.setBounds(0, 0,50,50);
        add(b);
        setSize(150,150);
        setTitle("Hola mundo GUI con Java");
        setLayout(new FlowLayout());
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
    public static void main(String[] args) throws Exception {
        new App();
    }

    
}
