package main;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Dungeon Crawler");

        GamePanel gamePanel = new GamePanel ();
        window.add(gamePanel);

//DEFINE - window size
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

//START - game in window
        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
}
