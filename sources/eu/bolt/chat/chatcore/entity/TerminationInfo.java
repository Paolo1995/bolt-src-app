package eu.bolt.chat.chatcore.entity;

import i0.a;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TerminationInfo.kt */
/* loaded from: classes5.dex */
public final class TerminationInfo {

    /* renamed from: a  reason: collision with root package name */
    private final String f38182a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38183b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38184c;

    /* renamed from: d  reason: collision with root package name */
    private final String f38185d;

    /* renamed from: e  reason: collision with root package name */
    private final long f38186e;

    public TerminationInfo(String id, String chatId, String message, String status, long j8) {
        Intrinsics.f(id, "id");
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(message, "message");
        Intrinsics.f(status, "status");
        this.f38182a = id;
        this.f38183b = chatId;
        this.f38184c = message;
        this.f38185d = status;
        this.f38186e = j8;
    }

    public final String a() {
        return this.f38183b;
    }

    public final long b() {
        return this.f38186e;
    }

    public final String c() {
        return this.f38182a;
    }

    public final String d() {
        return this.f38184c;
    }

    public final String e() {
        return this.f38185d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TerminationInfo) {
            TerminationInfo terminationInfo = (TerminationInfo) obj;
            return Intrinsics.a(this.f38182a, terminationInfo.f38182a) && Intrinsics.a(this.f38183b, terminationInfo.f38183b) && Intrinsics.a(this.f38184c, terminationInfo.f38184c) && Intrinsics.a(this.f38185d, terminationInfo.f38185d) && this.f38186e == terminationInfo.f38186e;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f38182a.hashCode() * 31) + this.f38183b.hashCode()) * 31) + this.f38184c.hashCode()) * 31) + this.f38185d.hashCode()) * 31) + a.a(this.f38186e);
    }

    public String toString() {
        return "TerminationInfo(id=" + this.f38182a + ", chatId=" + this.f38183b + ", message=" + this.f38184c + ", status=" + this.f38185d + ", date=" + this.f38186e + ')';
    }
}
