package eu.bolt.chat.network.data;

import eu.bolt.chat.data.AuthenticatedUser;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatConfig.kt */
/* loaded from: classes5.dex */
public final class ChatConfig {

    /* renamed from: a  reason: collision with root package name */
    private final String f39145a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39146b;

    /* renamed from: c  reason: collision with root package name */
    private final QoS f39147c;

    /* renamed from: d  reason: collision with root package name */
    private final QoS f39148d;

    /* renamed from: e  reason: collision with root package name */
    private final AuthenticatedUser f39149e;

    public ChatConfig(String incomingTopic, String outgoingTopic, QoS incomingQoS, QoS outgoingQoS, AuthenticatedUser authenticatedUser) {
        Intrinsics.f(incomingTopic, "incomingTopic");
        Intrinsics.f(outgoingTopic, "outgoingTopic");
        Intrinsics.f(incomingQoS, "incomingQoS");
        Intrinsics.f(outgoingQoS, "outgoingQoS");
        Intrinsics.f(authenticatedUser, "authenticatedUser");
        this.f39145a = incomingTopic;
        this.f39146b = outgoingTopic;
        this.f39147c = incomingQoS;
        this.f39148d = outgoingQoS;
        this.f39149e = authenticatedUser;
    }

    public final AuthenticatedUser a() {
        return this.f39149e;
    }

    public final QoS b() {
        return this.f39147c;
    }

    public final String c() {
        return this.f39145a;
    }

    public final QoS d() {
        return this.f39148d;
    }

    public final String e() {
        return this.f39146b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatConfig) {
            ChatConfig chatConfig = (ChatConfig) obj;
            return Intrinsics.a(this.f39145a, chatConfig.f39145a) && Intrinsics.a(this.f39146b, chatConfig.f39146b) && this.f39147c == chatConfig.f39147c && this.f39148d == chatConfig.f39148d && Intrinsics.a(this.f39149e, chatConfig.f39149e);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f39145a.hashCode() * 31) + this.f39146b.hashCode()) * 31) + this.f39147c.hashCode()) * 31) + this.f39148d.hashCode()) * 31) + this.f39149e.hashCode();
    }

    public String toString() {
        return "ChatConfig(incomingTopic=" + this.f39145a + ", outgoingTopic=" + this.f39146b + ", incomingQoS=" + this.f39147c + ", outgoingQoS=" + this.f39148d + ", authenticatedUser=" + this.f39149e + ')';
    }
}
