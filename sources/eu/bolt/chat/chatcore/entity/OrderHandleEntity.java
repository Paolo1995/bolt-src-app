package eu.bolt.chat.chatcore.entity;

import i0.a;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderHandleEntity.kt */
/* loaded from: classes5.dex */
public final class OrderHandleEntity {

    /* renamed from: a  reason: collision with root package name */
    private final long f38177a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38178b;

    /* renamed from: c  reason: collision with root package name */
    private final Long f38179c;

    public OrderHandleEntity(long j8, String str, Long l8) {
        this.f38177a = j8;
        this.f38178b = str;
        this.f38179c = l8;
    }

    public final Long a() {
        return this.f38179c;
    }

    public final long b() {
        return this.f38177a;
    }

    public final String c() {
        return this.f38178b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderHandleEntity) {
            OrderHandleEntity orderHandleEntity = (OrderHandleEntity) obj;
            return this.f38177a == orderHandleEntity.f38177a && Intrinsics.a(this.f38178b, orderHandleEntity.f38178b) && Intrinsics.a(this.f38179c, orderHandleEntity.f38179c);
        }
        return false;
    }

    public int hashCode() {
        int a8 = a.a(this.f38177a) * 31;
        String str = this.f38178b;
        int hashCode = (a8 + (str == null ? 0 : str.hashCode())) * 31;
        Long l8 = this.f38179c;
        return hashCode + (l8 != null ? l8.hashCode() : 0);
    }

    public String toString() {
        return "OrderHandleEntity(orderId=" + this.f38177a + ", orderSystem=" + this.f38178b + ", cityId=" + this.f38179c + ')';
    }
}
