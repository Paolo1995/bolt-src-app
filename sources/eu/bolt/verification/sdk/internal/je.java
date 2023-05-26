package eu.bolt.verification.sdk.internal;

/* loaded from: classes5.dex */
public enum je {
    LOCATION_PRECISE("android.permission.ACCESS_FINE_LOCATION"),
    LOCATION_APPROXIMATE("android.permission.ACCESS_COARSE_LOCATION"),
    CAMERA("android.permission.CAMERA"),
    RECORD_AUDIO("android.permission.RECORD_AUDIO"),
    MODIFY_AUDIO_SETTING("android.permission.MODIFY_AUDIO_SETTINGS"),
    BLUETOOTH_SCAN("android.permission.BLUETOOTH_SCAN"),
    BLUETOOTH_CONNECT("android.permission.BLUETOOTH_CONNECT"),
    POST_NOTIFICAITONS("android.permission.POST_NOTIFICATIONS");
    

    /* renamed from: f  reason: collision with root package name */
    private final String f43700f;

    je(String str) {
        this.f43700f = str;
    }

    public final String c() {
        return this.f43700f;
    }
}
