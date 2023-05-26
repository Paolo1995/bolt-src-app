package eu.bolt.kalev;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: NopLogEntry.kt */
/* loaded from: classes5.dex */
public final class NopLogEntry extends LogEntry {

    /* renamed from: g  reason: collision with root package name */
    public static final NopLogEntry f41681g = new NopLogEntry();

    private NopLogEntry() {
    }

    @Override // eu.bolt.kalev.LogEntry
    public void j(String message, String severity) {
        Intrinsics.g(message, "message");
        Intrinsics.g(severity, "severity");
    }

    @Override // eu.bolt.kalev.LogEntry
    public LogEntry k(String tag) {
        Intrinsics.g(tag, "tag");
        return this;
    }

    @Override // eu.bolt.kalev.LogEntry
    public LogEntry n(String key, Object obj) {
        Intrinsics.g(key, "key");
        return this;
    }

    @Override // eu.bolt.kalev.LogEntry
    public LogEntry o(Throwable throwable) {
        Intrinsics.g(throwable, "throwable");
        return this;
    }
}
