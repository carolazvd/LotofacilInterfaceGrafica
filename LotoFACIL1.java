package trabalhoLp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class LotoFACIL1 extends JFrame implements ActionListener {
    private JButton btnApostarDe0a100;
    private JButton btnApostarDeATeZ;
    private JButton btnApostarParOuImpar;
    private JButton btnSair;
    private JLabel lblResultado;
    public LotoFACIL1() {
        setTitle("Lotofácil");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        
        
        getContentPane().setBackground(Color.pink);
        panel.setBackground(Color.pink);


        btnApostarDe0a100 = new JButton("Apostar de 0 a 100");
        btnApostarDe0a100.addActionListener(this);
        panel.add(btnApostarDe0a100);
        btnApostarDe0a100.setBackground(Color.pink); 
        btnApostarDe0a100.setForeground(Color.black);

        btnApostarDeATeZ = new JButton("Apostar de A à Z");
        btnApostarDeATeZ.addActionListener(this);
        panel.add(btnApostarDeATeZ);
        btnApostarDeATeZ.setBackground(Color.pink); 
        btnApostarDeATeZ.setForeground(Color.black);
        
        btnApostarParOuImpar = new JButton("Apostar em par ou ímpar");
        btnApostarParOuImpar.addActionListener(this);
        panel.add(btnApostarParOuImpar);
        btnApostarParOuImpar.setBackground(Color.pink);
        btnApostarParOuImpar.setForeground(Color.black);
        
        btnSair = new JButton("Sair");
        btnSair.addActionListener(this);
        panel.add(btnSair);
        btnSair.setBackground(Color.pink); // 
        btnSair.setForeground(Color.black);

        lblResultado = new JLabel();
        panel.add(lblResultado);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
              Random random = new Random();
            if (e.getSource() == btnApostarDe0a100) {
                int numeroAposta = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Digite um número de 0 a 100: "));
                int numeroSorteado = random.nextInt(101);

                if (numeroAposta == numeroSorteado) {
                    lblResultado.setText("Você ganhou R$ 1.000,00 reais.");
                } else {
                    lblResultado.setText("Que pena! O número sorteado foi: " + numeroSorteado);
                }
            } else if (e.getSource() == btnApostarDeATeZ) {
                char letraAposta = Character.toUpperCase(javax.swing.JOptionPane.showInputDialog("Digite uma letra de A à Z: ").charAt(0));
                char letraPremiada = (char) (random.nextInt(26) + 'A');

                if (letraAposta == letraPremiada) {
                    lblResultado.setText("Você ganhou R$ 500,00 reais.");
                } else {
                    lblResultado.setText("Que pena! A letra sorteada foi: " + letraPremiada);
                }
            } else if (e.getSource() == btnApostarParOuImpar) {
                int numero = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Digite um número: "));

                if (numero % 2 == 0) {
                    lblResultado.setText("Você ganhou R$ 100,00 reais.");
                } else {
                    lblResultado.setText("Que pena! O número digitado é ímpar e a premiação foi para números pares.");
                }
            } else if (e.getSource() == btnSair) {
                System.exit(0);
            }
        }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LotoFACIL1 lotoFACIL1 = new LotoFACIL1();
                lotoFACIL1.setVisible(true);
            }
        });
    }
}
