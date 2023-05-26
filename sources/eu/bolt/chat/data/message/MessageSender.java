package eu.bolt.chat.data.message;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessageSender.kt */
/* loaded from: classes5.dex */
public final class MessageSender {

    /* renamed from: a  reason: collision with root package name */
    private final String f38996a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38997b;

    public MessageSender(String id, String name) {
        Intrinsics.f(id, "id");
        Intrinsics.f(name, "name");
        this.f38996a = id;
        this.f38997b = name;
    }

    public final String a() {
        return this.f38996a;
    }

    public final String b() {
        return this.f38997b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MessageSender) {
            MessageSender messageSender = (MessageSender) obj;
            return Intrinsics.a(this.f38996a, messageSender.f38996a) && Intrinsics.a(this.f38997b, messageSender.f38997b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f38996a.hashCode() * 31) + this.f38997b.hashCode();
    }

    public String toString() {
        return "MessageSender(id=" + this.f38996a + ", name=" + this.f38997b + ')';
    }
}
