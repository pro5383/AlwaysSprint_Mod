package org.pro5383.always_sprint.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;

@Environment(EnvType.CLIENT)
public class Always_sprintClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(this::onTick);
    }

    private void onTick(MinecraftClient client) {
        if (client.player != null && client.currentScreen == null) {
            KeyBinding.setKeyPressed(client.options.keySprint.getDefaultKey(), true);
        }
    }
}
