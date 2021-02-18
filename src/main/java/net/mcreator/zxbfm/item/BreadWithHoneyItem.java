
package net.mcreator.zxbfm.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.zxbfm.ZxbfmModElements;

@ZxbfmModElements.ModElement.Tag
public class BreadWithHoneyItem extends ZxbfmModElements.ModElement {
	@ObjectHolder("zxbfm:bread_with_honey")
	public static final Item block = null;
	public BreadWithHoneyItem(ZxbfmModElements instance) {
		super(instance, 45);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(7).saturation(0.3f).build()));
			setRegistryName("bread_with_honey");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
