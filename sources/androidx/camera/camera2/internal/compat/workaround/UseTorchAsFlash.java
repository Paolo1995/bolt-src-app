package androidx.camera.camera2.internal.compat.workaround;

import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.quirk.UseTorchAsFlashQuirk;
import androidx.camera.core.impl.Quirks;

/* loaded from: classes.dex */
public class UseTorchAsFlash {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f2909a;

    public UseTorchAsFlash(@NonNull Quirks quirks) {
        this.f2909a = quirks.a(UseTorchAsFlashQuirk.class);
    }

    public boolean a() {
        return this.f2909a;
    }
}
