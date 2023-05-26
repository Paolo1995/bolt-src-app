package com.sinch.android.rtc.internal.client.calling.PeerConnection;

import com.sinch.android.rtc.internal.client.ScheduledExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class IceRestarter {
    private static final int MAX_ICE_RESTART_COUNT = 1;
    private boolean mIsEnabled;
    private final long mNetworkAvailabilityIntervalMs;
    private final NetworkMonitor mNetworkMonitor;
    private final long mPeerConnectionAutoRecoveryIntervalMs;
    private final ScheduledExecutor mScheduledExecutor;
    private PeerConnectionInstance mTargetPc;
    private int mIceRestartCount = 0;
    private boolean mIsIceRestartPending = false;

    public IceRestarter(long j8, long j9, NetworkMonitor networkMonitor, ScheduledExecutor scheduledExecutor) {
        this.mNetworkAvailabilityIntervalMs = j8;
        this.mPeerConnectionAutoRecoveryIntervalMs = j9;
        this.mNetworkMonitor = networkMonitor;
        this.mScheduledExecutor = scheduledExecutor;
    }

    private boolean isStateValid(PeerConnectionInstance peerConnectionInstance) {
        return this.mIsEnabled && peerConnectionInstance != null && this.mTargetPc != null && peerConnectionInstance.getRemoteInstanceId().equals(this.mTargetPc.getRemoteInstanceId()) && this.mIceRestartCount < 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyIceStateFailed$0() {
        this.mScheduledExecutor.schedule(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.f0
            @Override // java.lang.Runnable
            public final void run() {
                IceRestarter.this.restartIceIfApplicable();
            }
        }, this.mPeerConnectionAutoRecoveryIntervalMs, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$restartIceIfApplicable$1() {
        int i8;
        PeerConnectionInstance peerConnectionInstance;
        if (!this.mIsIceRestartPending || (i8 = this.mIceRestartCount) >= 1 || (peerConnectionInstance = this.mTargetPc) == null) {
            return;
        }
        this.mIceRestartCount = i8 + 1;
        peerConnectionInstance.restartIce();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restartIceIfApplicable() {
        this.mScheduledExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.e0
            @Override // java.lang.Runnable
            public final void run() {
                IceRestarter.this.lambda$restartIceIfApplicable$1();
            }
        });
    }

    public void dispose() {
        this.mNetworkMonitor.dispose();
    }

    public void enable() {
        this.mIsEnabled = true;
    }

    public void notifyIceStateConnected(PeerConnectionInstance peerConnectionInstance) {
        if (isStateValid(peerConnectionInstance)) {
            this.mIsIceRestartPending = false;
        }
    }

    public void notifyIceStateFailed(PeerConnectionInstance peerConnectionInstance) {
        if (isStateValid(peerConnectionInstance)) {
            this.mIsIceRestartPending = true;
            this.mNetworkMonitor.checkConnectivity(this.mNetworkAvailabilityIntervalMs, new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.g0
                @Override // java.lang.Runnable
                public final void run() {
                    IceRestarter.this.lambda$notifyIceStateFailed$0();
                }
            }, null);
        }
    }

    public void setTarget(PeerConnectionInstance peerConnectionInstance) {
        this.mTargetPc = peerConnectionInstance;
    }
}
