package com.clevertap.android.sdk.task;

import com.clevertap.android.sdk.CleverTapInstanceConfig;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class SuccessExecutable<TResult> extends Executable<TResult> {

    /* renamed from: b  reason: collision with root package name */
    private final OnSuccessListener<TResult> f11798b;

    /* JADX INFO: Access modifiers changed from: protected */
    public SuccessExecutable(Executor executor, OnSuccessListener<TResult> onSuccessListener, CleverTapInstanceConfig cleverTapInstanceConfig) {
        super(executor);
        this.f11798b = onSuccessListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.clevertap.android.sdk.task.Executable
    public void a(final TResult tresult) {
        this.f11787a.execute(new Runnable() { // from class: com.clevertap.android.sdk.task.SuccessExecutable.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                SuccessExecutable.this.f11798b.onSuccess(tresult);
            }
        });
    }
}
