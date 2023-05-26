package ee.mtakso.driver.log.applog;

/* compiled from: ApploggerSeverity.kt */
/* loaded from: classes3.dex */
public enum ApploggerSeverity {
    CRITICAL("critical"),
    ERROR("error"),
    WARNING("warning"),
    NOTICE("notice"),
    INFO("info"),
    DEBUG("debug"),
    TRACE("trace");
    

    /* renamed from: f  reason: collision with root package name */
    private final String f21070f;

    ApploggerSeverity(String str) {
        this.f21070f = str;
    }

    public final String c() {
        return this.f21070f;
    }
}
