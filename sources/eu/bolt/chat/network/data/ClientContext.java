package eu.bolt.chat.network.data;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: OutgoingChatEvent.kt */
@Serializable
/* loaded from: classes5.dex */
public final class ClientContext {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f39182a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39183b;

    /* compiled from: OutgoingChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ClientContext> serializer() {
            return ClientContext$$serializer.f39184a;
        }
    }

    public /* synthetic */ ClientContext(int i8, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i8 & 3)) {
            PluginExceptionsKt.a(i8, 3, ClientContext$$serializer.f39184a.a());
        }
        this.f39182a = str;
        this.f39183b = str2;
    }

    public static final void a(ClientContext self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        output.y(serialDesc, 0, self.f39182a);
        output.y(serialDesc, 1, self.f39183b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ClientContext) {
            ClientContext clientContext = (ClientContext) obj;
            return Intrinsics.a(this.f39182a, clientContext.f39182a) && Intrinsics.a(this.f39183b, clientContext.f39183b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f39182a.hashCode() * 31) + this.f39183b.hashCode();
    }

    public String toString() {
        return "ClientContext(language=" + this.f39182a + ", sessionId=" + this.f39183b + ')';
    }

    public ClientContext(String language, String sessionId) {
        Intrinsics.f(language, "language");
        Intrinsics.f(sessionId, "sessionId");
        this.f39182a = language;
        this.f39183b = sessionId;
    }
}
