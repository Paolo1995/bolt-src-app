package com.google.firebase.messaging;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class WithinAppServiceBinder$$Lambda$0 implements Executor {

    /* renamed from: f  reason: collision with root package name */
    static final Executor f16631f = new WithinAppServiceBinder$$Lambda$0();

    private WithinAppServiceBinder$$Lambda$0() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
