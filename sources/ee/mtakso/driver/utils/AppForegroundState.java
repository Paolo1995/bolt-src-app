package ee.mtakso.driver.utils;

/* compiled from: BackgroundManager.kt */
/* loaded from: classes5.dex */
public enum AppForegroundState {
    FOREGROUND("foreground"),
    BACKGROUND("background");
    

    /* renamed from: f  reason: collision with root package name */
    private final String f36275f;

    AppForegroundState(String str) {
        this.f36275f = str;
    }

    public final String c() {
        return this.f36275f;
    }
}
