package eu.bolt.chat.chatcore.entity;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuickReplyEntity.kt */
/* loaded from: classes5.dex */
public final class QuickReplyEntity {

    /* renamed from: a  reason: collision with root package name */
    private final String f38180a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38181b;

    public QuickReplyEntity(String id, String text) {
        Intrinsics.f(id, "id");
        Intrinsics.f(text, "text");
        this.f38180a = id;
        this.f38181b = text;
    }

    public final String a() {
        return this.f38180a;
    }

    public final String b() {
        return this.f38181b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QuickReplyEntity) {
            QuickReplyEntity quickReplyEntity = (QuickReplyEntity) obj;
            return Intrinsics.a(this.f38180a, quickReplyEntity.f38180a) && Intrinsics.a(this.f38181b, quickReplyEntity.f38181b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f38180a.hashCode() * 31) + this.f38181b.hashCode();
    }

    public String toString() {
        return "QuickReplyEntity(id=" + this.f38180a + ", text=" + this.f38181b + ')';
    }
}
