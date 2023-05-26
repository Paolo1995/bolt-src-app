package com.clevertap.android.sdk.task;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
abstract class Executable<TResult> {

    /* renamed from: a  reason: collision with root package name */
    protected final Executor f11787a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Executable(Executor executor) {
        this.f11787a = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(TResult tresult);
}
