package com.sinch.android.rtc.internal.client.calling.PeerConnection;

import android.content.Context;
import com.sinch.android.rtc.internal.client.ScheduledExecutor;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class NetworkMonitor implements NetworkReachabilityListener {
    private int mIncrementalId = 0;
    private boolean mIsNetworkAvailable;
    private final NetworkReachability mNetworkReachability;
    private final Map<Integer, Runnable> mOnNetworkAvailableCallbacks;
    private final ScheduledExecutor mScheduledExecutor;

    public NetworkMonitor(Context context, ScheduledExecutor scheduledExecutor) {
        NetworkReachability networkReachability = new NetworkReachability(this, context);
        this.mNetworkReachability = networkReachability;
        this.mIsNetworkAvailable = false;
        this.mScheduledExecutor = scheduledExecutor;
        this.mOnNetworkAvailableCallbacks = DesugarCollections.synchronizedMap(new HashMap());
        networkReachability.enableReachabilityNotifications();
    }

    private int generateId() {
        int i8 = this.mIncrementalId;
        this.mIncrementalId = i8 + 1;
        return i8;
    }

    private void invokePendingCallbacks() {
        ArrayList arrayList = new ArrayList(this.mOnNetworkAvailableCallbacks.values());
        this.mOnNetworkAvailableCallbacks.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Runnable runnable = (Runnable) it.next();
            if (runnable != null) {
                this.mScheduledExecutor.execute(runnable);
            }
        }
    }

    private boolean isRequestAlreadyFulfilled(int i8) {
        return this.mOnNetworkAvailableCallbacks.get(Integer.valueOf(i8)) == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkConnectivity$0(int i8, Runnable runnable) {
        if (isRequestAlreadyFulfilled(i8)) {
            return;
        }
        this.mOnNetworkAvailableCallbacks.remove(Integer.valueOf(i8));
        if (runnable != null) {
            this.mScheduledExecutor.execute(runnable);
        }
    }

    public void checkConnectivity(long j8, Runnable runnable, final Runnable runnable2) {
        if (this.mIsNetworkAvailable) {
            if (runnable != null) {
                this.mScheduledExecutor.execute(runnable);
                return;
            }
            return;
        }
        final int generateId = generateId();
        this.mOnNetworkAvailableCallbacks.put(Integer.valueOf(generateId), runnable);
        this.mScheduledExecutor.schedule(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.h0
            @Override // java.lang.Runnable
            public final void run() {
                NetworkMonitor.this.lambda$checkConnectivity$0(generateId, runnable2);
            }
        }, j8, TimeUnit.MILLISECONDS);
    }

    public void dispose() {
        this.mNetworkReachability.dispose();
    }

    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.NetworkReachabilityListener
    public void reachabilityDidChange(boolean z7) {
        this.mIsNetworkAvailable = z7;
        if (z7) {
            invokePendingCallbacks();
        }
    }
}
