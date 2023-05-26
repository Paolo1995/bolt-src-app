package io.ktor.client.plugins.logging;

/* compiled from: LogLevel.kt */
/* loaded from: classes5.dex */
public enum LogLevel {
    ALL(true, true, true),
    HEADERS(true, true, false),
    BODY(true, false, true),
    INFO(true, false, false),
    NONE(false, false, false);
    

    /* renamed from: f  reason: collision with root package name */
    private final boolean f46523f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f46524g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f46525h;

    LogLevel(boolean z7, boolean z8, boolean z9) {
        this.f46523f = z7;
        this.f46524g = z8;
        this.f46525h = z9;
    }

    public final boolean c() {
        return this.f46525h;
    }

    public final boolean e() {
        return this.f46524g;
    }

    public final boolean f() {
        return this.f46523f;
    }
}
