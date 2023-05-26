package androidx.camera.core.impl;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class Identifier {
    @NonNull
    public static Identifier a(@NonNull Object obj) {
        return new AutoValue_Identifier(obj);
    }

    @NonNull
    public abstract Object b();
}
