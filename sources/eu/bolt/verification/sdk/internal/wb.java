package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.vb;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class wb implements vb {

    /* renamed from: a  reason: collision with root package name */
    private final f6<vb.a> f45540a;

    @Inject
    public wb(ke permissionHelper, xg rxSchedulers) {
        Intrinsics.f(permissionHelper, "permissionHelper");
        Intrinsics.f(rxSchedulers, "rxSchedulers");
        this.f45540a = new f6<>(rxSchedulers.d(), new vb.a(permissionHelper.b(), permissionHelper.c()));
    }

    private final void b(vb.a aVar) {
        this.f45540a.b(aVar);
    }

    @Override // eu.bolt.verification.sdk.internal.vb
    public void a() {
        b(new vb.a(false, false));
    }

    @Override // eu.bolt.verification.sdk.internal.vb
    public void f(boolean z7) {
        b(new vb.a(true, z7));
    }
}
