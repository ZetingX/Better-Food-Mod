
package net.mcreator.zxbfm.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.zxbfm.procedures.BrokenEggFoodEatenProcedure;
import net.mcreator.zxbfm.itemgroup.BetterFoodItemGroup;
import net.mcreator.zxbfm.ZxbfmModElements;

import java.util.Map;
import java.util.HashMap;

@ZxbfmModElements.ModElement.Tag
public class BrokenEggItem extends ZxbfmModElements.ModElement {
	@ObjectHolder("zxbfm:broken_egg")
	public static final Item block = null;
	public BrokenEggItem(ZxbfmModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(BetterFoodItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(1).saturation(0.3f).build()));
			setRegistryName("broken_egg");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				BrokenEggFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
