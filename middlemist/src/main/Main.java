package main;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import interaction.DialogPanel;
import item.InventoryMenu;

import item.InventoryMenu;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);

		GamePanel gamePanel = new GamePanel();
		GamePanel.setGamePanel(gamePanel);
		frame.setContentPane(gamePanel);

		frame.pack();
		frame.setLocationRelativeTo(null);
		
		PausePanel pausePanel = new PausePanel();
		PausePanel.setPause(pausePanel);
		InventoryMenu inventoryMenu = new InventoryMenu();
		InventoryMenu.setInv(inventoryMenu);
		DialogPanel dialogPanel = new DialogPanel();
		DialogPanel.setDialog(dialogPanel);
		frame.add(pausePanel);
		frame.add(inventoryMenu);
		frame.add(dialogPanel, "South");
		pausePanel.setVisible(false);
		inventoryMenu.setVisible(false);

		frame.add(pausePanel);
		frame.add(inventoryMenu);
		pausePanel.setVisible(false);
		inventoryMenu.setVisible(false);
		
		frame.setLocationRelativeTo(null);
		frame.setTitle("middlemist");
		frame.setVisible(true);
		BufferedImage icon = null;
		try {
			icon = ImageIO.read(new File(userDir + "/.middlemist/res/ui/icon.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		frame.setIconImage(icon);

		gamePanel.startGameThread();
	}
}
