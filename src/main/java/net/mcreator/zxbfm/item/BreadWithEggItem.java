
package net.mcreator.zxbfm.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.zxbfm.itemgroup.BetterFoodItemGroup;
import net.mcreator.zxbfm.ZxbfmModElements;

@ZxbfmModElements.ModElement.Tag
public class BreadWithEggItem extends ZxbfmModElements.ModElement {
	@ObjectHolder("zxbfm:bread_with_egg")
	public static final Item block = null;
	public BreadWithEggItem(ZxbfmModElements instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(BetterFoodItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(6).saturation(0.3f).build()));
			setRegistryName("bread_with_egg");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
