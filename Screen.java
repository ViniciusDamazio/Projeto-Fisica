package com.unespar.projetodefisica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Screen extends JFrame {
    
    JTextField num1;
    JTextField num2;
    JTextField num3;
    JTextField resultadoVoo;
    JTextField resultadoAltura;
    
    
    public Screen() {
       
       setUndecorated(true);
       setSize(430, 400);
       setTitle("Calculadora");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setResizable(false); 
       setLocationRelativeTo(null); 
       
       setLayout(null);
       
       getContentPane().setBackground(new Color(19, 40, 43));
       
        JPanel titleBar = new JPanel();
        titleBar.setLayout(null);
        titleBar.setBackground(new Color(40, 40, 40));
        titleBar.setBounds(0, 0, 430, 30);

        JLabel title = new JLabel("  Calculadora");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 14));
        title.setBounds(10, 0, 200, 30);

        JButton close = new JButton("×");
        close.setBounds(380, 0, 50, 30);
        close.setFont(new Font("Arial", Font.PLAIN, 24));
        close.setForeground(Color.WHITE);
        close.setBackground(Color.RED);
        close.setFocusPainted(false);
        close.setBorderPainted(false);
        close.addActionListener(e -> System.exit(0));

        titleBar.add(title);
        titleBar.add(close);
    
        add(titleBar);
       
       JButton Button = new JButton("Reset");
       Button.setBounds(170, 330, 80, 30);
       Button.setFont(new Font("Arial", Font.BOLD, 17));
       Button.setForeground(new Color(19, 40, 43));
       Button.setBackground(new Color(224, 210, 3));
       
       JButton Button2 = new JButton("Calcular");
       Button2.setBounds(290, 100, 100, 30);
       Button2.setFont(new Font("Arial", Font.BOLD, 17));
       Button2.setForeground(new Color(19, 40, 43));
       Button2.setBackground(new Color(224, 210, 3));
       
       add(Button);
       add(Button2);
       
       Button.addActionListener(this::teste);
       Button2.addActionListener(this::testeDois);
       
       num1 = new JTextField();
       num1.setBounds(200, 60, 70, 30);
       num1.setFont(new Font("Arial", Font.BOLD, 14));
       
       add(num1);
       
       JLabel jLabel1 = new JLabel("Velocidade inicial (km/h):");
       jLabel1.setBounds(12, 53, 180, 50);
       jLabel1.setFont(new Font("Arial", Font.BOLD, 14));
       jLabel1.setForeground(Color.WHITE);
       
       add(jLabel1);
       
       num2 = new JTextField();
       num2.setBounds(200, 100, 70, 30);
       num2.setFont(new Font("Arial", Font.BOLD, 14));
         
       add(num2);
       
       JLabel jLabel2 = new JLabel("Ângulo (graus):");
       jLabel2.setBounds(12, 93, 170, 50);
       jLabel2.setFont(new Font("Arial", Font.BOLD, 14));
       jLabel2.setForeground(Color.WHITE);
       
       add(jLabel2);
       
       num3 = new JTextField();
       num3.setBounds(200, 140, 70, 30);
       num3.setFont(new Font("Arial", Font.BOLD, 14));
       
       add(num3);
       
       JLabel jLabel3 = new JLabel(" Distância (m):");
       jLabel3.setBounds(12, 133, 170, 50);
       jLabel3.setFont(new Font("Arial", Font.BOLD, 14));
       jLabel3.setForeground(Color.WHITE);
       
       add(jLabel3);
       
       resultadoVoo = new JTextField(" Tempo de voo (s): ");
       resultadoVoo.setBounds(60, 210, 300, 30);
       resultadoVoo.setFont(new Font("Arial", Font.BOLD, 14));
       resultadoVoo.setEditable(false);
       resultadoVoo.setBackground(new Color(19, 40, 43)); 
       resultadoVoo.setForeground(Color.WHITE); 
       
       add(resultadoVoo); 
       
       resultadoAltura = new JTextField(" Altura de lançamento (m): ");
       resultadoAltura.setBounds(60, 270, 300, 30);
       resultadoAltura.setFont(new Font("Arial", Font.BOLD, 14));
       resultadoAltura.setEditable(false);
       resultadoAltura.setBackground(new Color(19, 40, 43)); 
       resultadoAltura.setForeground(Color.WHITE); 
       
       add(resultadoAltura);
       
    }
        
    private void teste(ActionEvent actionEvent) {
        num1.setText(" ");
        num2.setText(" ");
        num3.setText(" ");
        resultadoVoo.setText(" Tempo de voo (s): ");
        resultadoAltura.setText(" Altura de lançamento (m): ");
       
    }

    private void testeDois(ActionEvent actionEvent) {
        
        try {
        
        double velocidade = Double.parseDouble(num1.getText());
        double angulo = Double.parseDouble(num2.getText());
        double distancia = Double.parseDouble(num3.getText());
        
        if(velocidade <= 0 || angulo <= 0 || distancia <= 0){
            JOptionPane.showMessageDialog(null, "Os números devem ser positivos e diferentes de zero!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        else {
            double tempo = distancia / ((velocidade / 3.6) * Math.cos(Math.toRadians(angulo)));        
                resultadoVoo.setText("Tempo de voo (s): " + String.format("%.1f", tempo));
                
            double lancamento = (((velocidade / 3.6) * tempo * (Math.sin(Math.toRadians(angulo))) + (9.8 * Math.pow(tempo, 2)) / 2));
                resultadoAltura.setText("Altura de lançamento (m): " + String.format("%.1f", lancamento));
        }
}       catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Insira números válidos", "Erro de entrada", JOptionPane.ERROR_MESSAGE);
}
}
}