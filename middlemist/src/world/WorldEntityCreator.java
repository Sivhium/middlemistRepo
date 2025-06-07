package world;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import entity.Entity;
import main.GamePanel;

public class WorldEntityCreator {
	
	public static final int NULL_ID = -1;
	
	public static GamePanel gp;
	public static File entMap;
	public static BufferedReader reader;
	
	public static void setGamePanel(GamePanel gp) {
		WorldEntityCreator.gp = gp;
	}
	
	public static void setEntMap(String filePath) {
		entMap = new File(filePath);
	}
	
	public static void run() {
		try {
			reader = new BufferedReader(new FileReader(entMap));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Integer entX, entY, entID;
		String text = reader.toString();
		String[] positions = text.split(" ");
		for (String pos : positions) {
			String[] vals = pos.split(".");
			entX = Integer.parseInt(vals[0]);
			entY = Integer.parseInt(vals[1]);
			entID = Integer.parseInt(vals[2]);
			if (entX != null && entY != null && entID != null) {
				createEnt(entX, entY, entID);
			}
			else {
				entX = 0;
				entY = 0;
				entID = NULL_ID;
				createEnt(entX, entY, entID);
			}
		}
	}
	
	private static void createEnt(int x, int y, int id) {
		switch (id) {
		case -1:
			Entity nullEnt = new Entity("null", x, y);
			gp.entLoader.unloadEntity(nullEnt);
			break;
		case 0:
			Entity voidEnt = new Entity("void", x, y);
			gp.entLoader.loadEntity(voidEnt);
		}
	}
}
