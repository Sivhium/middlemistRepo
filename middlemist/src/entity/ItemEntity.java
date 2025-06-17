package entity;

import item.InventoryMenu;
import item.Item;
import main.GamePanel;

public class ItemEntity extends Entity {
	
	public Item itemPickup;

	public ItemEntity(String name, int x, int y, Item item) {
		super(name, x, y);
		this.entCollide.canCollide = false;
		itemPickup = item;
		spriteSheet = item.icon;
		entCollide.canCollide = false;
	}
	
	public void itemUpdate() {
		if (entCollide.intersectsWith(GamePanel.player.entCollide)) {
			GamePanel.player.inventory.add(itemPickup);
			GamePanel.entLoader.removeEntity(this);
			InventoryMenu.im.updateInventory();
	public static void itemUpdate(ItemEntity itemEnt) {
		if (itemEnt.entCollide.intersectsWith(GamePanel.player.entCollide)) {
			GamePanel.player.inventory.add(itemEnt.itemPickup);
			GamePanel.entLoader.unloadEntity(itemEnt);
		}
	}

}
