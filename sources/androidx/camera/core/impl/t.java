package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import java.util.Set;

/* compiled from: ReadableConfig.java */
/* loaded from: classes.dex */
public final /* synthetic */ class t {
    public static boolean a(ReadableConfig readableConfig, @NonNull Config.Option option) {
        return readableConfig.d().b(option);
    }

    public static void b(ReadableConfig readableConfig, @NonNull String str, @NonNull Config.OptionMatcher optionMatcher) {
        readableConfig.d().l(str, optionMatcher);
    }

    @NonNull
    public static Config.OptionPriority c(ReadableConfig readableConfig, @NonNull Config.Option option) {
        return readableConfig.d().f(option);
    }

    @NonNull
    public static Set d(ReadableConfig readableConfig, @NonNull Config.Option option) {
        return readableConfig.d().t(option);
    }

    @NonNull
    public static Set e(ReadableConfig readableConfig) {
        return readableConfig.d().c();
    }

    public static Object f(ReadableConfig readableConfig, @NonNull Config.Option option) {
        return readableConfig.d().a(option);
    }

    public static Object g(ReadableConfig readableConfig, @NonNull Config.Option option, Object obj) {
        return readableConfig.d().e(option, obj);
    }

    public static Object h(ReadableConfig readableConfig, @NonNull Config.Option option, @NonNull Config.OptionPriority optionPriority) {
        return readableConfig.d().m(option, optionPriority);
    }
}
