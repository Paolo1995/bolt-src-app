package android.graphics;

import android.annotation.NonNull;

/* loaded from: classes.dex */
public /* synthetic */ class ColorSpace {

    /* loaded from: classes.dex */
    public final /* synthetic */ class Named extends Enum {
        static {
            throw new NoClassDefFoundError();
        }
    }

    static {
        throw new NoClassDefFoundError();
    }

    @NonNull
    public static native /* synthetic */ ColorSpace get(@NonNull Named named);

    public abstract /* synthetic */ boolean isWideGamut();
}
