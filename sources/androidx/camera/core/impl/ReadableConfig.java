package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import java.util.Set;

/* loaded from: classes.dex */
public interface ReadableConfig extends Config {
    @Override // androidx.camera.core.impl.Config
    <ValueT> ValueT a(@NonNull Config.Option<ValueT> option);

    @Override // androidx.camera.core.impl.Config
    boolean b(@NonNull Config.Option<?> option);

    @Override // androidx.camera.core.impl.Config
    @NonNull
    Set<Config.Option<?>> c();

    @NonNull
    Config d();

    @Override // androidx.camera.core.impl.Config
    <ValueT> ValueT e(@NonNull Config.Option<ValueT> option, ValueT valuet);

    @Override // androidx.camera.core.impl.Config
    @NonNull
    Config.OptionPriority f(@NonNull Config.Option<?> option);
}
