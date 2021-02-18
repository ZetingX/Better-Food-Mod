package net.mcreator.zxbfm.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.zxbfm.ZxbfmModElements;

import java.util.Map;

@ZxbfmModElements.ModElement.Tag
public class FriedSlimeFoodEatenProcedure extends ZxbfmModElements.ModElement {
	public FriedSlimeFoodEatenProcedure(ZxbfmModElements instance) {
		super(instance, 24);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure FriedSlimeFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 100, (int) 4));
	}
}
