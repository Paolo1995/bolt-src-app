package eu.bolt.chat.chatcore.network.model;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClientContext.kt */
/* loaded from: classes5.dex */
public final class ClientContext {
    @SerializedName("session_id")

    /* renamed from: a  reason: collision with root package name */
    private final String f38341a;
    @SerializedName("language")

    /* renamed from: b  reason: collision with root package name */
    private final String f38342b;

    public ClientContext(String sessionId, String language) {
        Intrinsics.f(sessionId, "sessionId");
        Intrinsics.f(language, "language");
        this.f38341a = sessionId;
        this.f38342b = language;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ClientContext) {
            ClientContext clientContext = (ClientContext) obj;
            return Intrinsics.a(this.f38341a, clientContext.f38341a) && Intrinsics.a(this.f38342b, clientContext.f38342b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f38341a.hashCode() * 31) + this.f38342b.hashCode();
    }

    public String toString() {
        return "ClientContext(sessionId=" + this.f38341a + ", language=" + this.f38342b + ')';
    }
}
