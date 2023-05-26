package eu.bolt.android.audio_recording_engine.engine;

/* compiled from: DirectoryType.kt */
/* loaded from: classes5.dex */
public enum DirectoryType {
    ENCRYPTED_DIR("encrypt_dir"),
    DECRYPTED_DIR("decrypt_dir");
    

    /* renamed from: f  reason: collision with root package name */
    private final String f36666f;

    DirectoryType(String str) {
        this.f36666f = str;
    }

    public final String c() {
        return this.f36666f;
    }
}
