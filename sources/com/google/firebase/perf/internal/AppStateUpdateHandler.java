package com.google.firebase.perf.internal;

import androidx.annotation.NonNull;
import com.google.firebase.perf.internal.AppStateMonitor;
import com.google.firebase.perf.v1.ApplicationProcessState;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public abstract class AppStateUpdateHandler implements AppStateMonitor.AppStateCallback {
    private AppStateMonitor mAppStateMonitor;
    private boolean mIsRegisteredForAppState;
    private ApplicationProcessState mState;
    private WeakReference<AppStateMonitor.AppStateCallback> mWeakRef;

    /* JADX INFO: Access modifiers changed from: protected */
    public AppStateUpdateHandler() {
        this(AppStateMonitor.b());
    }

    public ApplicationProcessState getAppState() {
        return this.mState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void incrementTsnsCount(int i8) {
        this.mAppStateMonitor.f(i8);
    }

    @Override // com.google.firebase.perf.internal.AppStateMonitor.AppStateCallback
    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        ApplicationProcessState applicationProcessState2 = this.mState;
        ApplicationProcessState applicationProcessState3 = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        if (applicationProcessState2 == applicationProcessState3) {
            this.mState = applicationProcessState;
        } else if (applicationProcessState2 != applicationProcessState && applicationProcessState != applicationProcessState3) {
            this.mState = ApplicationProcessState.FOREGROUND_BACKGROUND;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerForAppState() {
        if (this.mIsRegisteredForAppState) {
            return;
        }
        this.mState = this.mAppStateMonitor.a();
        this.mAppStateMonitor.j(this.mWeakRef);
        this.mIsRegisteredForAppState = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unregisterForAppState() {
        if (!this.mIsRegisteredForAppState) {
            return;
        }
        this.mAppStateMonitor.m(this.mWeakRef);
        this.mIsRegisteredForAppState = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AppStateUpdateHandler(@NonNull AppStateMonitor appStateMonitor) {
        this.mState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.mIsRegisteredForAppState = false;
        this.mAppStateMonitor = appStateMonitor;
        this.mWeakRef = new WeakReference<>(this);
    }
}
