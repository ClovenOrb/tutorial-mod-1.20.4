package net.clover.tutorial.entity.client;

import net.clover.tutorial.TutorialMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer PORCUPINE =
            new EntityModelLayer(new Identifier(TutorialMod.MOD_ID, "porcupine"), "main");
}
