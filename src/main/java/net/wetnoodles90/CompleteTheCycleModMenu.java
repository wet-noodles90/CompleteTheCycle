package net.wetnoodles90;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class CompleteTheCycleModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<Screen> getModConfigScreenFactory() {
        // load existing config if present
        Path path = Path.of("./config/complete-the-cycle/complete_the_cycle.json");
        if (Files.exists(path)) {
            try (Reader r = Files.newBufferedReader(path)) {
                JsonObject root = JsonParser.parseReader(r).getAsJsonObject();
                CompleteTheCycleClient.currentWgenValue[0] = root.has("worldgen") && root.get("worldgen").getAsBoolean();
            } catch (IOException ignored) {}
        }

        // 'parent' is the screen ModMenu was on when you clicked your mod
        return parent -> {
            ConfigBuilder builder = ConfigBuilder.create()
                    .setParentScreen(parent)
                    .setTitle(Text.translatable("title.complete-the-cycle.config"));

            // example: a “Features” category with one boolean toggle
            ConfigCategory features = builder.getOrCreateCategory(
                    Text.translatable("category.complete-the-cycle.features")
            );
            ConfigEntryBuilder entryBuilder = builder.entryBuilder();
            features.addEntry(
                    entryBuilder
                            .startBooleanToggle(
                                    Text.translatable("entry.complete-the-cycle.worldgen"),
                                    CompleteTheCycleClient.currentWgenValue[0]
                            )
                            .setDefaultValue(true)
                            .setTooltip(Text.translatable("entry.complete-the-cycle.worlgen.tooltip"))
                            .setSaveConsumer(newVal -> CompleteTheCycleClient.currentWgenValue[0] = newVal)
                            .build()
            );

            builder.setSavingRunnable(this::saveConfig);

            // build and return the finished screen
            return builder.build();
        };
    }

    private void saveConfig() {
        JsonObject root = new JsonObject();
        // store whatever values you have
        root.addProperty("worldgen", CompleteTheCycleClient.currentWgenValue[0]);

        File configdir = new File("./config/complete-the-cycle");

        if (!configdir.exists()) {
            configdir.mkdirs();
        }

        File config = new File("./config/complete-the-cycle/complete_the_cycle.json");

        if (!config.exists()) {
            try {
                config.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (Writer w = Files.newBufferedWriter(Path.of("./config/complete-the-cycle/complete_the_cycle.json"))) {
            Gson sus = new Gson();
            sus.toJson(root, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
