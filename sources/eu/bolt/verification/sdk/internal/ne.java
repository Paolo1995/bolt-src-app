package eu.bolt.verification.sdk.internal;

import android.annotation.TargetApi;
import android.content.Context;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

@TargetApi(23)
/* loaded from: classes5.dex */
public final class ne implements ke {

    /* renamed from: a  reason: collision with root package name */
    private final Context f44325a;

    @Inject
    public ne(Context context) {
        Intrinsics.f(context, "context");
        this.f44325a = context;
    }

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
        int checkSelfPermission;
        Intrinsics.f(permission, "permission");
        checkSelfPermission = this.f44325a.checkSelfPermission(permission.c());
        return checkSelfPermission == 0;
    }
}
