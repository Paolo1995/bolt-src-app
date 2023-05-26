package com.sinch.android.rtc;

import com.sinch.android.rtc.internal.ExternalPushListener;
import com.sinch.android.rtc.internal.SinchClientPrivate;
import com.sinch.android.rtc.internal.client.calling.DefaultCallController;

/* loaded from: classes3.dex */
public class Internals {
    public static void addExternalPushListener(SinchClient sinchClient, ExternalPushListener externalPushListener) {
        if (sinchClient == null || sinchClient.getCallController() == null) {
            return;
        }
        ((DefaultCallController) sinchClient.getCallController()).addExternalPushListener(externalPushListener);
    }

    public static void disableSupportActiveConnection(SinchClient sinchClient) {
        if (sinchClient != null) {
            ((SinchClientPrivate) sinchClient).setSupportActiveConnection(false);
        }
    }

    public static void enableSupportActiveConnection(SinchClient sinchClient) {
        if (sinchClient != null) {
            ((SinchClientPrivate) sinchClient).setSupportActiveConnection(true);
        }
    }

    public static void relayPlainPushPayload(String str, SinchClient sinchClient) {
        if (sinchClient != null) {
            ((SinchClientPrivate) sinchClient).relayPlainPushPayload(str);
        }
    }

    public static void startListeningOnActiveConnection(SinchClient sinchClient) {
        if (sinchClient != null) {
            ((SinchClientPrivate) sinchClient).startListeningOnActiveConnection();
        }
    }

    public static void stopListeningOnActiveConnection(SinchClient sinchClient) {
        if (sinchClient != null) {
            ((SinchClientPrivate) sinchClient).stopListeningOnActiveConnection();
        }
    }

    public static void terminateForcefully(SinchClient sinchClient) {
        if (sinchClient != null) {
            ((SinchClientPrivate) sinchClient).terminateForcefully();
        }
    }

    public static void useAllIceCandidates(SinchClient sinchClient) {
        if (sinchClient != null) {
            ((SinchClientPrivate) sinchClient).setUseRelayCandidatesOnly(false);
        }
    }

    public static void useRelayIceCandidatesOnly(SinchClient sinchClient) {
        if (sinchClient != null) {
            ((SinchClientPrivate) sinchClient).setUseRelayCandidatesOnly(true);
        }
    }
}
