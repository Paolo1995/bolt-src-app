package com.sinch.android.rtc.internal.client.calling.PeerConnection;

import java.util.concurrent.ScheduledExecutorService;
import org.webrtc.EglBase;

/* loaded from: classes3.dex */
public interface PeerConnectionFactoryProvider {
    void dispose();

    EglBase getEglRootContext();

    ScheduledExecutorService getExecutor();

    PeerConnectionFactoryWrapper getFactoryWrapper();
}
