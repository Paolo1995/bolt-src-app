package eu.bolt.chat.client;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidChatPushPayload.kt */
/* loaded from: classes5.dex */
public final class AndroidChatPushPayload implements ChatPushPayload {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f38530a;

    public AndroidChatPushPayload(Map<String, String> payload) {
        Intrinsics.f(payload, "payload");
        this.f38530a = payload;
    }

    @Override // eu.bolt.chat.client.ChatPushPayload
    public String getBody() {
        return this.f38530a.get("chat");
    }

    @Override // eu.bolt.chat.client.ChatPushPayload
    public String getDomain() {
        return this.f38530a.get("domain");
    }
}
