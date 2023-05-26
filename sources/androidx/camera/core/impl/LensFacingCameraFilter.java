package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class LensFacingCameraFilter implements CameraFilter {

    /* renamed from: b  reason: collision with root package name */
    private int f3661b;

    public LensFacingCameraFilter(int i8) {
        this.f3661b = i8;
    }

    @Override // androidx.camera.core.CameraFilter
    public /* synthetic */ Identifier a() {
        return androidx.camera.core.d.a(this);
    }

    @Override // androidx.camera.core.CameraFilter
    @NonNull
    public List<CameraInfo> b(@NonNull List<CameraInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (CameraInfo cameraInfo : list) {
            Preconditions.b(cameraInfo instanceof CameraInfoInternal, "The camera info doesn't contain internal implementation.");
            Integer c8 = ((CameraInfoInternal) cameraInfo).c();
            if (c8 != null && c8.intValue() == this.f3661b) {
                arrayList.add(cameraInfo);
            }
        }
        return arrayList;
    }

    public int c() {
        return this.f3661b;
    }
}
