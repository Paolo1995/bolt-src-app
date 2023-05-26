package ee.mtakso.driver.network.client.contact;

import ee.mtakso.driver.network.client.contact.ContactConfiguration;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactConfiguration.kt */
/* loaded from: classes3.dex */
public final class ChatConfiguration extends ContactConfiguration {

    /* renamed from: b  reason: collision with root package name */
    private final boolean f21758b;

    /* renamed from: c  reason: collision with root package name */
    private final ContactConfiguration.Type f21759c;

    public /* synthetic */ ChatConfiguration(boolean z7, ContactConfiguration.Type type, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(z7, (i8 & 2) != 0 ? ContactConfiguration.Type.CHAT : type);
    }

    @Override // ee.mtakso.driver.network.client.contact.ContactConfiguration
    public ContactConfiguration.Type a() {
        return this.f21759c;
    }

    public final boolean b() {
        return this.f21758b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatConfiguration) {
            ChatConfiguration chatConfiguration = (ChatConfiguration) obj;
            return this.f21758b == chatConfiguration.f21758b && a() == chatConfiguration.a();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        boolean z7 = this.f21758b;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return (i8 * 31) + a().hashCode();
    }

    public String toString() {
        boolean z7 = this.f21758b;
        ContactConfiguration.Type a8 = a();
        return "ChatConfiguration(eagerConnect=" + z7 + ", type=" + a8 + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatConfiguration(boolean z7, ContactConfiguration.Type type) {
        super(null);
        Intrinsics.f(type, "type");
        this.f21758b = z7;
        this.f21759c = type;
    }
}
