import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame{

    private JPanel MainPanel;
    private JLabel N;
    private JTextField Nfeild;
    private JLabel BufferSIze;
    private JTextField Bfeild;
    private JTextField OutFeild;
    private JButton start;
    private JLabel LargestPrimeLabel;
    private JLabel LargestPrime;
    private JLabel NumberOfPrimeNumbersLabel;
    private JLabel Time;
    private JLabel PrimeCount;
    private JLabel TimeresultLabel;
    private JLabel OutPut;


    public GUI() {
        MainPanel.setBackground(Color.gray);
        MainPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));
        LargestPrime.setFont(new Font("Verdana", Font.BOLD, 14));
        Time.setFont(new Font("Verdana", Font.BOLD, 14));
        PrimeCount.setFont(new Font("Verdana", Font.BOLD, 14));
        N.setFont(new Font("Verdana", Font.BOLD, 14));
        BufferSIze.setFont(new Font("Verdana", Font.BOLD, 14));
        OutPut.setFont(new Font("Verdana", Font.BOLD, 14));
        N.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        BufferSIze.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        OutPut.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        LargestPrimeLabel.setFont(new Font("Verdana", Font.BOLD, 14));
        NumberOfPrimeNumbersLabel.setFont(new Font("Verdana", Font.BOLD, 14));
        TimeresultLabel.setFont(new Font("Verdana", Font.BOLD, 14));
        LargestPrimeLabel.setForeground(Color.CYAN);
        NumberOfPrimeNumbersLabel.setForeground(Color.CYAN);
        TimeresultLabel.setForeground(Color.CYAN);
        start.setBackground(Color.CYAN);
        start.setFont(new Font("Verdana", Font.BOLD, 14));
        start.setMargin(new Insets(5, 5, 5, 5));
        Nfeild.setFont(new Font("Verdana", Font.BOLD, 14));
        Bfeild.setFont(new Font("Verdana", Font.BOLD, 14));
        OutFeild.setFont(new Font("Verdana", Font.BOLD, 14));
        setContentPane(MainPanel);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle("GetPrimes");
        JFrame.setDefaultLookAndFeelDecorated(true);
        setSize(500, 550);
        setVisible(true);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                int n = Integer.parseInt(Nfeild.getText());
                int size = Integer.parseInt(Bfeild.getText());
                String fileName = OutFeild.getText();
                long start = System.currentTimeMillis();
                Buffer b = new Buffer(size);
                Producer p = new Producer(b, n);
                Consumer c = new Consumer(b, fileName);
                Thread t1 = new Thread(p);
                Thread t2 = new Thread(c);
                t1.start();
                t2.start();
                try {
                    t2.join();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                long end = System.currentTimeMillis();
                long elapsedTime = end - start;

                LargestPrimeLabel.setText(Integer.toString(Consumer.largest));
                NumberOfPrimeNumbersLabel.setText((Integer.toString(Producer.counter)));
                TimeresultLabel.setText(elapsedTime + " ms");
            }

        });
    }


}