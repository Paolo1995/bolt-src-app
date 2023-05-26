package eu.bolt.chat.chatcore.entity.connection;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatConnectionEntity.kt */
/* loaded from: classes5.dex */
public final class ChatConnectionEntity implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final String f38194f;

    /* renamed from: g  reason: collision with root package name */
    private final int f38195g;

    /* renamed from: h  reason: collision with root package name */
    private final String f38196h;

    /* renamed from: i  reason: collision with root package name */
    private final String f38197i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f38198j;

    public ChatConnectionEntity(String host, int i8, String address, String queryParams, boolean z7) {
        Intrinsics.f(host, "host");
        Intrinsics.f(address, "address");
        Intrinsics.f(queryParams, "queryParams");
        this.f38194f = host;
        this.f38195g = i8;
        this.f38196h = address;
        this.f38197i = queryParams;
        this.f38198j = z7;
    }

    public final String a() {
        return this.f38196h;
    }

    public final String b() {
        return this.f38194f;
    }

    public final int c() {
        return this.f38195g;
    }

    public final String d() {
        return this.f38197i;
    }

    public final boolean e() {
        return this.f38198j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatConnectionEntity) {
            ChatConnectionEntity chatConnectionEntity = (ChatConnectionEntity) obj;
            return Intrinsics.a(this.f38194f, chatConnectionEntity.f38194f) && this.f38195g == chatConnectionEntity.f38195g && Intrinsics.a(this.f38196h, chatConnectionEntity.f38196h) && Intrinsics.a(this.f38197i, chatConnectionEntity.f38197i) && this.f38198j == chatConnectionEntity.f38198j;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.f38194f.hashCode() * 31) + this.f38195g) * 31) + this.f38196h.hashCode()) * 31) + this.f38197i.hashCode()) * 31;
        boolean z7 = this.f38198j;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        return "ChatConnectionEntity(host=" + this.f38194f + ", port=" + this.f38195g + ", address=" + this.f38196h + ", queryParams=" + this.f38197i + ", useSsl=" + this.f38198j + ')';
    }
}
