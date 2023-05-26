package eu.bolt.chat.data;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDateTime;

/* compiled from: EndChatInfo.kt */
/* loaded from: classes5.dex */
public final class EndChatInfo {

    /* renamed from: a  reason: collision with root package name */
    private final String f38950a;

    /* renamed from: b  reason: collision with root package name */
    private final LocalDateTime f38951b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38952c;

    /* renamed from: d  reason: collision with root package name */
    private final ChatStatus f38953d;

    public EndChatInfo(String id, LocalDateTime date, String message, ChatStatus status) {
        Intrinsics.f(id, "id");
        Intrinsics.f(date, "date");
        Intrinsics.f(message, "message");
        Intrinsics.f(status, "status");
        this.f38950a = id;
        this.f38951b = date;
        this.f38952c = message;
        this.f38953d = status;
    }

    public final LocalDateTime a() {
        return this.f38951b;
    }

    public final String b() {
        return this.f38950a;
    }

    public final String c() {
        return this.f38952c;
    }

    public final ChatStatus d() {
        return this.f38953d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EndChatInfo) {
            EndChatInfo endChatInfo = (EndChatInfo) obj;
            return Intrinsics.a(this.f38950a, endChatInfo.f38950a) && Intrinsics.a(this.f38951b, endChatInfo.f38951b) && Intrinsics.a(this.f38952c, endChatInfo.f38952c) && this.f38953d == endChatInfo.f38953d;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f38950a.hashCode() * 31) + this.f38951b.hashCode()) * 31) + this.f38952c.hashCode()) * 31) + this.f38953d.hashCode();
    }

    public String toString() {
        return "EndChatInfo(id=" + this.f38950a + ", date=" + this.f38951b + ", message=" + this.f38952c + ", status=" + this.f38953d + ')';
    }
}
