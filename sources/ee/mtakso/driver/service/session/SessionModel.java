package ee.mtakso.driver.service.session;

import i0.a;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionProvider.kt */
/* loaded from: classes3.dex */
public final class SessionModel {

    /* renamed from: a  reason: collision with root package name */
    private final long f25908a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25909b;

    /* renamed from: c  reason: collision with root package name */
    private final SessionType f25910c;

    public SessionModel(long j8, String session, SessionType type) {
        Intrinsics.f(session, "session");
        Intrinsics.f(type, "type");
        this.f25908a = j8;
        this.f25909b = session;
        this.f25910c = type;
    }

    public final String a() {
        return this.f25909b;
    }

    public final long b() {
        return this.f25908a;
    }

    public final SessionType c() {
        return this.f25910c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SessionModel) {
            SessionModel sessionModel = (SessionModel) obj;
            return this.f25908a == sessionModel.f25908a && Intrinsics.a(this.f25909b, sessionModel.f25909b) && this.f25910c == sessionModel.f25910c;
        }
        return false;
    }

    public int hashCode() {
        return (((a.a(this.f25908a) * 31) + this.f25909b.hashCode()) * 31) + this.f25910c.hashCode();
    }

    public String toString() {
        long j8 = this.f25908a;
        String str = this.f25909b;
        SessionType sessionType = this.f25910c;
        return "SessionModel(timestamp=" + j8 + ", session=" + str + ", type=" + sessionType + ")";
    }
}
