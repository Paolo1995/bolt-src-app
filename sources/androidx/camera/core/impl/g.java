package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;

/* compiled from: Config.java */
/* loaded from: classes.dex */
public final /* synthetic */ class g {
    public static boolean a(@NonNull Config.OptionPriority optionPriority, @NonNull Config.OptionPriority optionPriority2) {
        Config.OptionPriority optionPriority3 = Config.OptionPriority.ALWAYS_OVERRIDE;
        if (optionPriority == optionPriority3 && optionPriority2 == optionPriority3) {
            return true;
        }
        Config.OptionPriority optionPriority4 = Config.OptionPriority.REQUIRED;
        if (optionPriority == optionPriority4 && optionPriority2 == optionPriority4) {
            return true;
        }
        return false;
    }

    @NonNull
    public static Config b(Config config, Config config2) {
        MutableOptionsBundle L;
        if (config == null && config2 == null) {
            return OptionsBundle.I();
        }
        if (config2 != null) {
            L = MutableOptionsBundle.M(config2);
        } else {
            L = MutableOptionsBundle.L();
        }
        if (config != null) {
            for (Config.Option<?> option : config.c()) {
                L.k(option, config.f(option), config.a(option));
            }
        }
        return OptionsBundle.J(L);
    }
}
