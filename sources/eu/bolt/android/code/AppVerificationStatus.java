package eu.bolt.android.code;

/* compiled from: AppVerifier.kt */
/* loaded from: classes5.dex */
public enum AppVerificationStatus {
    VERIFIED("verified", "Verified"),
    SIGNATURE_FAILED("signature_failed", "Signature Verification Failed"),
    PACKAGE_NAME_FAILED("package_name_failed", "Package Name Verification Failed"),
    INSTALLER_FAILED("installer_failed", "Installer Source Verification Failed"),
    DEBUGGABLE_FAILED("debuggable_failed", "Debuggable Flag Verification Failed");
    

    /* renamed from: f  reason: collision with root package name */
    private final String f36731f;

    /* renamed from: g  reason: collision with root package name */
    private final String f36732g;

    AppVerificationStatus(String str, String str2) {
        this.f36731f = str;
        this.f36732g = str2;
    }

    public final String c() {
        return this.f36732g;
    }
}
