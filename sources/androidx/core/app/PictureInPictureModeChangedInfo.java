package androidx.core.app;

import android.content.res.Configuration;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class PictureInPictureModeChangedInfo {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f5658a;

    /* renamed from: b  reason: collision with root package name */
    private final Configuration f5659b;

    public PictureInPictureModeChangedInfo(boolean z7) {
        this.f5658a = z7;
        this.f5659b = null;
    }

    public boolean a() {
        return this.f5658a;
    }

    public PictureInPictureModeChangedInfo(boolean z7, @NonNull Configuration configuration) {
        this.f5658a = z7;
        this.f5659b = configuration;
    }
}
