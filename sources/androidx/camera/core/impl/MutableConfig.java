package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;

/* loaded from: classes.dex */
public interface MutableConfig extends Config {
    <ValueT> void k(@NonNull Config.Option<ValueT> option, @NonNull Config.OptionPriority optionPriority, ValueT valuet);

    <ValueT> void o(@NonNull Config.Option<ValueT> option, ValueT valuet);
}
