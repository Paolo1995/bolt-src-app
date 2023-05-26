package androidx.camera.core.internal;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;

/* loaded from: classes.dex */
public interface TargetConfig<T> extends ReadableConfig {
    @NonNull

    /* renamed from: w  reason: collision with root package name */
    public static final Config.Option<String> f3910w = Config.Option.a("camerax.core.target.name", String.class);
    @NonNull

    /* renamed from: x  reason: collision with root package name */
    public static final Config.Option<Class<?>> f3911x = Config.Option.a("camerax.core.target.class", Class.class);

    String r(String str);
}
