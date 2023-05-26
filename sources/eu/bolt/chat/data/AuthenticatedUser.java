package eu.bolt.chat.data;

import eu.bolt.chat.data.message.MessageSender;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthenticatedUser.kt */
/* loaded from: classes5.dex */
public final class AuthenticatedUser {

    /* renamed from: a  reason: collision with root package name */
    private final String f38920a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38921b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38922c;

    public AuthenticatedUser(String type, String id, String name) {
        Intrinsics.f(type, "type");
        Intrinsics.f(id, "id");
        Intrinsics.f(name, "name");
        this.f38920a = type;
        this.f38921b = id;
        this.f38922c = name;
    }

    public final MessageSender a() {
        return new MessageSender(this.f38920a + ':' + this.f38921b, this.f38922c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AuthenticatedUser) {
            AuthenticatedUser authenticatedUser = (AuthenticatedUser) obj;
            return Intrinsics.a(this.f38920a, authenticatedUser.f38920a) && Intrinsics.a(this.f38921b, authenticatedUser.f38921b) && Intrinsics.a(this.f38922c, authenticatedUser.f38922c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f38920a.hashCode() * 31) + this.f38921b.hashCode()) * 31) + this.f38922c.hashCode();
    }

    public String toString() {
        return "AuthenticatedUser(type=" + this.f38920a + ", id=" + this.f38921b + ", name=" + this.f38922c + ')';
    }
}
