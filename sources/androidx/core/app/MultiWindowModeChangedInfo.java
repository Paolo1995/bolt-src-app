package androidx.core.app;

import android.content.res.Configuration;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class MultiWindowModeChangedInfo {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f5569a;

    /* renamed from: b  reason: collision with root package name */
    private final Configuration f5570b;

    public MultiWindowModeChangedInfo(boolean z7) {
        this.f5569a = z7;
        this.f5570b = null;
    }

    public boolean a() {
        return this.f5569a;
    }

    public MultiWindowModeChangedInfo(boolean z7, @NonNull Configuration configuration) {
        this.f5569a = z7;
        this.f5570b = configuration;
    }
}
