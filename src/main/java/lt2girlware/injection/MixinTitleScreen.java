package lt2girlware.injection;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.ConfirmScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Util;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import lt2girlware.Lt2Girlware;
import lt2girlware.gui.misc.DialogScreen;
import lt2girlware.gui.mainmenu.MainMenuScreen;
import lt2girlware.utility.render.TextureStorage;
import lt2girlware.core.manager.client.ModuleManager;
import lt2girlware.features.modules.client.ClientSettings;

import java.net.URI;

import static lt2girlware.features.modules.Module.mc;
import static lt2girlware.features.modules.client.ClientSettings.isRu;

@Mixin(TitleScreen.class)
public class MixinTitleScreen extends Screen {
    protected MixinTitleScreen(Text title) {
        super(title);
    }

    @Inject(method = "init", at = @At("RETURN"))
    public void postInitHook(CallbackInfo ci) {
        if (ClientSettings.customMainMenu.getValue() && !MainMenuScreen.getInstance().confirm && ModuleManager.clickGui.getBind().getKey() != -1) {
            mc.setScreen(MainMenuScreen.getInstance());
        }
        if (ModuleManager.clickGui.getBind().getKey() == -1) {
            DialogScreen dialogScreen2 = new DialogScreen(
                    TextureStorage.cutie,
                    isRu() ? "Спасибо что скачали Lt2Girlware!" : "Thank you for downloading Lt2Girlware!",
                    isRu() ? "Меню с функциями клиента открывается на клавишу - P" : "Menu with client modules is opened with the key - P",
                    isRu() ? "Зайти в майн" : "Join on minecraft",
                    isRu() ? "Закрыть майн" : "Close minecraft",
                    () -> {
                        ModuleManager.clickGui.setBind(InputUtil.fromTranslationKey("key.keyboard.p").getCode(), false, false);
                        mc.setScreen(MainMenuScreen.getInstance());
                    },
                    () -> {
                        ModuleManager.clickGui.setBind(InputUtil.fromTranslationKey("key.keyboard.p").getCode(), false, false);
                        mc.stop();
                    }
            );
            DialogScreen dialogScreen1 = new DialogScreen(
                    TextureStorage.questionPic,
                    "Hello!",
                    "What's your language?",
                    "Русский",
                    "English",
                    () -> {
                        ClientSettings.language.setValue(ClientSettings.Language.RU);
                        mc.setScreen(dialogScreen2);
                    },
                    () -> {
                        ClientSettings.language.setValue(ClientSettings.Language.ENG);
                        mc.setScreen(dialogScreen2);
                    }
            );
            mc.setScreen(dialogScreen1);
        }

        if (Lt2Girlware.isOutdated && !FabricLoader.getInstance().isDevelopmentEnvironment()) {
            mc.setScreen(new ConfirmScreen(
                    confirm -> {
                        if (confirm) Util.getOperatingSystem().open(URI.create("https://github.com/Pan4ur/Lt2Girlware-Recode/releases/download/latest/thunderhack-1.7.jar/"));
                        else mc.stop();
                    },
                    Text.of(Formatting.RED + "You are using an outdated version of Lt2Girlware Recode"), Text.of("Please update to the latest release"), Text.of("Download"), Text.of("Quit Game")));
        }
    }
}
