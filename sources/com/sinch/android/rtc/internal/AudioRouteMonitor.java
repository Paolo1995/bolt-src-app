package com.sinch.android.rtc.internal;

import android.media.AudioDeviceInfo;
import android.os.Build;
import java.util.Locale;
import org.webrtc.audio.WebRtcAudioRecord;
import org.webrtc.audio.WebRtcAudioTrack;

/* loaded from: classes3.dex */
public class AudioRouteMonitor implements AudioRoutingListener {
    public static String RoutedDeviceAddressPropertyName = "routedDeviceAddress";
    public static String RoutedDeviceIsSinkPropertyName = "routedDeviceIsSink";
    public static String RoutedDeviceIsSourcePropertyName = "routedDeviceIsSource";
    public static String RoutedDeviceProductNamePropertyName = "routedDeviceProductName";
    public static String RoutedDeviceTypePropertyName = "routedDeviceType";
    private static final String TAG = "AudioRouteMonitor";
    private AudioRouteMonitorListener mAudioRouteMonitorListener;
    private String mLastReportedRoutedSink = null;
    private String mLastReportedRoutedSource = null;

    /* loaded from: classes3.dex */
    public interface AudioRouteMonitorListener {
        void onAudioRoutingChanged(String str);
    }

    private String buildPropertyOutput(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        return String.format(Locale.US, "%s: %s", str, str2);
    }

    private String buildRoutedDeviceDescription(AudioDeviceInfo audioDeviceInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(buildPropertyOutput(RoutedDeviceIsSourcePropertyName, String.valueOf(audioDeviceInfo.isSource())));
        sb.append("\n");
        sb.append(buildPropertyOutput(RoutedDeviceIsSinkPropertyName, String.valueOf(audioDeviceInfo.isSink())));
        sb.append("\n");
        sb.append(buildPropertyOutput(RoutedDeviceAddressPropertyName, Build.VERSION.SDK_INT >= 28 ? audioDeviceInfo.getAddress() : ""));
        sb.append("\n");
        sb.append(buildPropertyOutput(RoutedDeviceTypePropertyName, rawTypeToName(audioDeviceInfo.getType())));
        sb.append("\n");
        sb.append(buildPropertyOutput(RoutedDeviceProductNamePropertyName, String.valueOf(audioDeviceInfo.getProductName())));
        return sb.toString();
    }

    private boolean shouldIgnoreNewRoutedDeviceInfo(AudioDeviceInfo audioDeviceInfo, String str) {
        return (audioDeviceInfo.isSink() && str.equals(this.mLastReportedRoutedSink)) || (audioDeviceInfo.isSource() && str.equals(this.mLastReportedRoutedSource));
    }

    public void attachToWebRtcAudioTracks() {
        WebRtcAudioTrack.SetAudioRoutingListener(this);
        WebRtcAudioRecord.SetAudioRoutingListener(this);
    }

    public void detachFromWebRtcAudioTracks() {
        WebRtcAudioTrack.SetAudioRoutingListener(null);
        WebRtcAudioRecord.SetAudioRoutingListener(null);
    }

    @Override // com.sinch.android.rtc.internal.AudioRoutingListener
    public void onNewRoutedDevice(AudioDeviceInfo audioDeviceInfo) {
        if (audioDeviceInfo == null) {
            return;
        }
        String buildRoutedDeviceDescription = buildRoutedDeviceDescription(audioDeviceInfo);
        if (shouldIgnoreNewRoutedDeviceInfo(audioDeviceInfo, buildRoutedDeviceDescription)) {
            return;
        }
        AudioRouteMonitorListener audioRouteMonitorListener = this.mAudioRouteMonitorListener;
        if (audioRouteMonitorListener != null) {
            audioRouteMonitorListener.onAudioRoutingChanged(buildRoutedDeviceDescription);
        }
        this.mLastReportedRoutedSink = audioDeviceInfo.isSink() ? buildRoutedDeviceDescription : this.mLastReportedRoutedSink;
        if (!audioDeviceInfo.isSource()) {
            buildRoutedDeviceDescription = this.mLastReportedRoutedSource;
        }
        this.mLastReportedRoutedSource = buildRoutedDeviceDescription;
    }

    public String rawTypeToName(int i8) {
        switch (i8) {
            case 0:
                return "TYPE_UNKNOWN";
            case 1:
                return "TYPE_BUILTIN_EARPIECE";
            case 2:
                return "TYPE_BUILTIN_SPEAKER";
            case 3:
                return "TYPE_WIRED_HEADSET";
            case 4:
                return "TYPE_WIRED_HEADPHONES";
            case 5:
                return "TYPE_LINE_ANALOG";
            case 6:
                return "TYPE_LINE_DIGITAL";
            case 7:
                return "TYPE_BLUETOOTH_SCO";
            case 8:
                return "TYPE_BLUETOOTH_A2DP";
            case 9:
                return "TYPE_HDMI";
            case 10:
                return "TYPE_HDMI_ARC";
            case 11:
                return "TYPE_USB_DEVICE";
            case 12:
                return "TYPE_USB_ACCESSORY";
            case 13:
                return "TYPE_DOCK";
            case 14:
                return "TYPE_FM";
            case 15:
                return "TYPE_BUILTIN_MIC";
            case 16:
                return "TYPE_FM_TUNER";
            case 17:
                return "TYPE_TV_TUNER";
            case 18:
                return "TYPE_TELEPHONY";
            case 19:
                return "TYPE_AUX_LINE";
            case 20:
                return "TYPE_IP";
            case 21:
                return "TYPE_BUS";
            case 22:
                return "TYPE_USB_HEADSET";
            case 23:
                return "TYPE_HEARING_AID";
            case 24:
                return "TYPE_BUILTIN_SPEAKER_SAFE";
            case 25:
                return "TYPE_REMOTE_SUBMIX";
            case 26:
                return "TYPE_BLE_HEADSET";
            case 27:
                return "TYPE_BLE_SPEAKER";
            case 28:
            default:
                return "Unknown type with raw value " + i8;
            case 29:
                return "TYPE_HDMI_EARC";
            case 30:
                return "TYPE_BLE_BROADCAST";
        }
    }

    public void setAudioRouteMonitorListener(AudioRouteMonitorListener audioRouteMonitorListener) {
        this.mAudioRouteMonitorListener = audioRouteMonitorListener;
    }
}
