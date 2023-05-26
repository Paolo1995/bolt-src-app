package eu.bolt.verification.sdk.internal;

import android.app.Activity;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class yf implements xf {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f45748a;

    @Inject
    public yf(Activity context) {
        Intrinsics.f(context, "context");
        this.f45748a = context;
    }

    @Override // eu.bolt.verification.sdk.internal.xf
    public int d(int i8) {
        return f2.b(this.f45748a, i8);
    }
}
