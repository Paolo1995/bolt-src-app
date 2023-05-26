package eu.bolt.verification.sdk.internal;

import eu.bolt.android.rib.BaseRibInteractor;
import eu.bolt.android.rib.dynamic.controller.DynamicStateController;
import eu.bolt.android.rib.dynamic.controller.DynamicStateController1Arg;
import eu.bolt.android.rib.dynamic.controller.DynamicStateControllerNoArgs;
import eu.bolt.client.updateapp.rib.UpdateAppRibListener;
import eu.bolt.verification.sdk.internal.gi;
import eu.bolt.verification.sdk.internal.xi;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class yi extends BaseRibInteractor<bj> implements gi, nj, UpdateAppRibListener {

    /* renamed from: n  reason: collision with root package name */
    private final xi f45759n;

    /* renamed from: o  reason: collision with root package name */
    private final aj f45760o;

    /* renamed from: p  reason: collision with root package name */
    private final String f45761p;

    @Inject
    public yi(xi args, aj ribListener) {
        Intrinsics.f(args, "args");
        Intrinsics.f(ribListener, "ribListener");
        this.f45759n = args;
        this.f45760o = ribListener;
        this.f45761p = "StoryFlowRibInteractor";
    }

    @Override // eu.bolt.coroutines.base.BaseScopeOwner
    public String D() {
        return this.f45761p;
    }

    @Override // eu.bolt.verification.sdk.internal.gi
    public void a() {
        DynamicStateController.g(((bj) L()).h1(), false, 1, null);
        this.f45760o.b();
    }

    @Override // eu.bolt.verification.sdk.internal.gi
    public void b() {
        DynamicStateController.g(((bj) L()).h1(), false, 1, null);
        DynamicStateControllerNoArgs.k(((bj) L()).j1(), false, 1, null);
    }

    @Override // eu.bolt.verification.sdk.internal.gi
    public void c() {
        DynamicStateController.g(((bj) L()).h1(), false, 1, null);
        this.f45760o.b();
    }

    @Override // eu.bolt.verification.sdk.internal.gi
    public void c(String str) {
        gi.a.a(this, str);
    }

    @Override // eu.bolt.verification.sdk.internal.nj
    public void e() {
        DynamicStateController.g(((bj) L()).f1(), false, 1, null);
        DynamicStateControllerNoArgs.k(((bj) L()).j1(), false, 1, null);
    }

    @Override // eu.bolt.verification.sdk.internal.nj
    public void g() {
        DynamicStateController.g(((bj) L()).f1(), false, 1, null);
        this.f45760o.b();
    }

    @Override // eu.bolt.android.rib.RibInteractor, eu.bolt.android.rib.RibLifecycleSubject
    public void s() {
        DynamicStateController1Arg f12;
        super.s();
        xi xiVar = this.f45759n;
        if (xiVar instanceof xi.b) {
            f12 = ((bj) L()).h1();
        } else if (!(xiVar instanceof xi.a)) {
            return;
        } else {
            f12 = ((bj) L()).f1();
        }
        DynamicStateController1Arg.k(f12, this.f45759n, false, 2, null);
    }
}
