package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.PersistedInstallationEntry;

/* loaded from: classes3.dex */
class GetAuthTokenListener implements StateListener {

    /* renamed from: a  reason: collision with root package name */
    private final Utils f16374a;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource<InstallationTokenResult> f16375b;

    public GetAuthTokenListener(Utils utils, TaskCompletionSource<InstallationTokenResult> taskCompletionSource) {
        this.f16374a = utils;
        this.f16375b = taskCompletionSource;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean a(Exception exc) {
        this.f16375b.trySetException(exc);
        return true;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean b(PersistedInstallationEntry persistedInstallationEntry) {
        if (persistedInstallationEntry.k() && !this.f16374a.f(persistedInstallationEntry)) {
            this.f16375b.setResult(InstallationTokenResult.a().b(persistedInstallationEntry.b()).d(persistedInstallationEntry.c()).c(persistedInstallationEntry.h()).a());
            return true;
        }
        return false;
    }
}
