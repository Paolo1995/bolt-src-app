package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.chatcore.user.MqttInfoProvider;
import eu.bolt.chat.data.ChatCredentials;
import eu.bolt.chat.network.CredentialsProvider;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatCredentialsProvider.kt */
/* loaded from: classes5.dex */
public final class ChatCredentialsProvider implements CredentialsProvider {

    /* renamed from: a  reason: collision with root package name */
    private final MqttInfoProvider f37892a;

    public ChatCredentialsProvider(MqttInfoProvider mqttInfoProvider) {
        Intrinsics.f(mqttInfoProvider, "mqttInfoProvider");
        this.f37892a = mqttInfoProvider;
    }

    @Override // eu.bolt.chat.network.CredentialsProvider
    public ChatCredentials a() {
        boolean z7;
        String p8 = this.f37892a.p();
        if (p8.length() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return new ChatCredentials.Bearer(this.f37892a.h());
        }
        return new ChatCredentials.Basic(p8, this.f37892a.h());
    }
}
