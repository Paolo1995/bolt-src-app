package eu.bolt.chat.chatcore.entity;

/* compiled from: TerminationInfoStatus.kt */
/* loaded from: classes5.dex */
public enum TerminationInfoStatus {
    FINISHED("finished"),
    CANCELLED("aborted"),
    UNKNOWN("unknown");
    

    /* renamed from: f  reason: collision with root package name */
    private final String f38191f;

    TerminationInfoStatus(String str) {
        this.f38191f = str;
    }

    public final String c() {
        return this.f38191f;
    }
}
