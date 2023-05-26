package com.sinch.android.rtc.internal.client.calling.PeerConnection;

import android.content.Context;
import org.webrtc.NetworkChangeDetector;
import org.webrtc.NetworkMonitor;

/* loaded from: classes3.dex */
public class NetworkReachability implements NetworkMonitor.NetworkObserver {
    private final Context mContext;
    private final NetworkReachabilityListener mListener;

    public NetworkReachability(NetworkReachabilityListener networkReachabilityListener, Context context) {
        this.mContext = context;
        this.mListener = networkReachabilityListener;
    }

    private void notifyDelegate(boolean z7) {
        NetworkReachabilityListener networkReachabilityListener = this.mListener;
        if (networkReachabilityListener != null) {
            networkReachabilityListener.reachabilityDidChange(z7);
        }
    }

    public void dispose() {
        org.webrtc.NetworkMonitor.getInstance().removeObserver(this);
        org.webrtc.NetworkMonitor.getInstance().stopMonitoring();
    }

    public void enableReachabilityNotifications() {
        org.webrtc.NetworkMonitor.getInstance().startMonitoring(this.mContext);
        org.webrtc.NetworkMonitor.getInstance().addObserver(this);
    }

    @Override // org.webrtc.NetworkMonitor.NetworkObserver
    public void onConnectionTypeChanged(NetworkChangeDetector.ConnectionType connectionType) {
        notifyDelegate(connectionType != NetworkChangeDetector.ConnectionType.CONNECTION_NONE);
    }
}
