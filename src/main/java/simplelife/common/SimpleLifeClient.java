package simplelife.common;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import simplelife.common.gui.WorktableScreen;

@Environment(EnvType.CLIENT)
public class SimpleLifeClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(SimpleLife.WORKTABLE_SCREEN_HANDLER, WorktableScreen::new);
    }

}
