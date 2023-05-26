package eu.bolt.driver.chat.ui.notification;

import i0.a;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationMessage.kt */
/* loaded from: classes5.dex */
public final class NotificationMessage {

    /* renamed from: a  reason: collision with root package name */
    private final String f40583a;

    /* renamed from: b  reason: collision with root package name */
    private final long f40584b;

    public NotificationMessage(String text, long j8) {
        Intrinsics.f(text, "text");
        this.f40583a = text;
        this.f40584b = j8;
    }

    public final String a() {
        return this.f40583a;
    }

    public final long b() {
        return this.f40584b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NotificationMessage) {
            NotificationMessage notificationMessage = (NotificationMessage) obj;
            return Intrinsics.a(this.f40583a, notificationMessage.f40583a) && this.f40584b == notificationMessage.f40584b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f40583a.hashCode() * 31) + a.a(this.f40584b);
    }

    public String toString() {
        String str = this.f40583a;
        long j8 = this.f40584b;
        return "NotificationMessage(text=" + str + ", timestamp=" + j8 + ")";
    }
}
