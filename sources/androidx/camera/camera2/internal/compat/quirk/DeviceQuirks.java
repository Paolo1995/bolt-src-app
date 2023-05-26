package androidx.camera.camera2.internal.compat.quirk;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.Quirks;

/* loaded from: classes.dex */
public class DeviceQuirks {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private static final Quirks f2862a = new Quirks(DeviceQuirksLoader.a());

    private DeviceQuirks() {
    }

    public static <T extends Quirk> T a(@NonNull Class<T> cls) {
        return (T) f2862a.b(cls);
    }

    @NonNull
    public static Quirks b() {
        return f2862a;
    }
}
