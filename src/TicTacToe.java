import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel text_field = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    TicTacToe() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.getContentPane().setBackground(new Color(0,15,33));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text_field.setBackground(new Color(25,26,27));
        text_field.setForeground(new Color(25,255,0));
        text_field.setFont(new Font("verdana", Font.BOLD,55 ));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("Tic - Tac - Toe");
        text_field.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,600,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(0,0,0));

        for(int i=0;i<9;i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("forte", Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(text_field);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

        @Override
        public void actionPerformed(ActionEvent e){

            for(int i=0; i<9; i++){
                if(e.getSource()==buttons[i] && buttons[i].getText()==""){
                    if(player1_turn){
                            buttons[i].setForeground(new Color(10,178,135));
                            buttons[i].setText("X");
                            player1_turn=false;
                            text_field.setText("It is O's turn");
                            check();
                    }
                    else {
                        buttons[i].setForeground(new Color(7,81,250));
                        buttons[i].setText("O");
                        player1_turn=true;
                        text_field.setText("It is X's turn");
                        check();
                    }
                }
            }
        }

        public void firstTurn() {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (random.nextBoolean()) {
                player1_turn = true;
                text_field.setText("It is X's turn");
            } else {
                player1_turn = false;
                text_field.setText("It is O's turn");
            }
        }

        public void check() {

            //checking for a tie
            boolean tie = true;
            for (int i = 0; i < 9; i++) {
                if (buttons[i].getText()==("")) {
                    tie = false;
                    break;
                }
            }

            if (tie) {
                tie();
            }

        //checking for X's winning conditions
            if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")) {
                Xwins(0,1,2);
            }
            if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")) {
                Xwins(3,4,5);
            }
            if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")) {
                Xwins(6,7,8);
            }
            if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")) {
                Xwins(0,3,6);
            }
            if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")) {
                Xwins(1,4,7);
            }
            if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")) {
                Xwins(2,5,8);
            }
            if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")) {
                Xwins(0,4,8);
            }
            if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")) {
                Xwins(2,4,6);
            }

            //checking for O's winning conditions
            if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")) {
                Owins(0,1,2);
            }
            if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")) {
                Owins(3,4,5);
            }
            if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")) {
                Owins(6,7,8);
            }
            if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")) {
                Owins(0,3,6);
            }
            if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")) {
                Owins(1,4,7);
            }
            if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")) {
                Owins(2,5,8);
            }
            if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")) {
                Owins(0,4,8);
            }
            if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")) {
                Owins(2,4,6);
            }

        }

    public void Xwins(int a,int b,int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        text_field.setText("X wins!");
    }

    public void Owins(int a,int b,int c) {
        buttons[a].setBackground(Color.blue);
        buttons[b].setBackground(Color.blue);
        buttons[c].setBackground(Color.blue);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        text_field.setText("O Wins!");
    }

    public void tie() {

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        text_field.setText("It's a tie!");
    }

}