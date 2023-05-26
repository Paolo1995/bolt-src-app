package eu.bolt.verification.sdk.internal;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class le implements ke {
    @Override // eu.bolt.verification.sdk.internal.ke
    public boolean a() {
        return c(je.CAMERA);
    }

    @Override // eu.bolt.verification.sdk.internal.ke
    public boolean b() {
        return c(je.LOCATION_APPROXIMATE);
    }

    @Override // eu.bolt.verification.sdk.internal.ke
    public boolean c() {
        return c(je.LOCATION_PRECISE);
    }

    public boolean c(je permission) {
        Intrinsics.f(permission, "permission");
        return true;
    }
}
