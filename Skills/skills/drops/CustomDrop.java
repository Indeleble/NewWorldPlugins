package skills.drops;

import org.bukkit.inventory.ItemStack;


public class CustomDrop {

	ItemStack itemStack;
	int maxLevel;
	int amount;
	int prob;

	public CustomDrop(ItemStack itemStack, int maxLevel, int amount, int prob) {

		this.itemStack = itemStack;
		this.maxLevel = maxLevel;
		this.amount = amount;
		this.prob = prob;

	}

	public int getProb() {
		return prob;
	}

	public void setProb(int prob) {
		this.prob = prob;
	}

	public ItemStack getItemStack() {
		return itemStack;
	}

	public void setItemStack(ItemStack itemStack) {
		this.itemStack = itemStack;
	}

	public int getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}





}
