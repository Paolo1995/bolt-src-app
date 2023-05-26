package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Identifier;
import java.util.List;

/* loaded from: classes.dex */
public interface CameraFilter {

    /* renamed from: a  reason: collision with root package name */
    public static final Identifier f3051a = Identifier.a(new Object());

    @NonNull
    Identifier a();

    @NonNull
    List<CameraInfo> b(@NonNull List<CameraInfo> list);
}
