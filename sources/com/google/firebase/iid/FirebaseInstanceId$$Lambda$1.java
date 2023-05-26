package com.google.firebase.iid;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class FirebaseInstanceId$$Lambda$1 implements Executor {

    /* renamed from: f  reason: collision with root package name */
    static final Executor f16293f = new FirebaseInstanceId$$Lambda$1();

    private FirebaseInstanceId$$Lambda$1() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
