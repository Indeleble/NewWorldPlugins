package skills.drops;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemPurityBuilder {

	ArrayList<CustomDrop>	drops;

	public ItemPurityBuilder() {

		this.drops = new ArrayList<CustomDrop>();
	}

	public void addDrop(CustomDrop drop) {
		this.drops.add(drop);
	}

	public ArrayList<ItemStack> getDrops() {

		// Array de drops que devolvera
		ArrayList<ItemStack> finalDrops = new ArrayList<ItemStack>();

		Random r = new Random();
		r.setSeed(r.nextLong());

		for (CustomDrop drop : drops) {

			if (r.nextInt(101) + 1 <= drop.getProb()) {

				for (int j = 0; j < drop.getAmount(); j++) {

					finalDrops.add(buildItem(drop.getItemStack(), drop.getMaxLevel()));
				}
				break;
			}
		}

		return finalDrops;
	}

	private ItemStack buildItem(ItemStack is, int probability) {
		ItemStack item = is.clone();
		Random r = new Random();
		r.setSeed(r.nextLong());

		int v = r.nextInt(probability + 1);
		if (v == 0)	v = 1;

		ItemMeta im = is.getItemMeta();

		ArrayList<String> lore = new ArrayList<String>();

		lore.add("Calidad: " + v);

		im.setLore(lore);

		item.setItemMeta(im);

		return item;
	}

	@SuppressWarnings("unused")
	private boolean hasPurity(ItemStack is) {

		boolean result = false;

		if (is.getItemMeta().getLore() != null) {

			ArrayList<String> lore = (ArrayList<String>) is.getItemMeta().getLore();

			for (int i = 0; i < lore.size(); i++) {

				if (lore.get(i).contains("Calidad")) {

					result = true;
					break;
				}
			}
		}
		return result;
	}

}
