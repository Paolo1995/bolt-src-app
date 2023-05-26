package eu.bolt.chat.chatcore.entity;

import i0.a;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatEntity.kt */
/* loaded from: classes5.dex */
public final class ChatEntity {

    /* renamed from: a  reason: collision with root package name */
    private final String f38135a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38136b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38137c;

    /* renamed from: d  reason: collision with root package name */
    private final String f38138d;

    /* renamed from: e  reason: collision with root package name */
    private final long f38139e;

    /* renamed from: f  reason: collision with root package name */
    private final OrderHandleEntity f38140f;

    public ChatEntity(String id, String str, String title, String str2, long j8, OrderHandleEntity orderHandle) {
        Intrinsics.f(id, "id");
        Intrinsics.f(title, "title");
        Intrinsics.f(orderHandle, "orderHandle");
        this.f38135a = id;
        this.f38136b = str;
        this.f38137c = title;
        this.f38138d = str2;
        this.f38139e = j8;
        this.f38140f = orderHandle;
    }

    public final String a() {
        return this.f38138d;
    }

    public final String b() {
        return this.f38135a;
    }

    public final OrderHandleEntity c() {
        return this.f38140f;
    }

    public final long d() {
        return this.f38139e;
    }

    public final String e() {
        return this.f38136b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatEntity) {
            ChatEntity chatEntity = (ChatEntity) obj;
            return Intrinsics.a(this.f38135a, chatEntity.f38135a) && Intrinsics.a(this.f38136b, chatEntity.f38136b) && Intrinsics.a(this.f38137c, chatEntity.f38137c) && Intrinsics.a(this.f38138d, chatEntity.f38138d) && this.f38139e == chatEntity.f38139e && Intrinsics.a(this.f38140f, chatEntity.f38140f);
        }
        return false;
    }

    public final String f() {
        return this.f38137c;
    }

    public int hashCode() {
        int hashCode = this.f38135a.hashCode() * 31;
        String str = this.f38136b;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f38137c.hashCode()) * 31;
        String str2 = this.f38138d;
        return ((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + a.a(this.f38139e)) * 31) + this.f38140f.hashCode();
    }

    public String toString() {
        return "ChatEntity(id=" + this.f38135a + ", thumbnail=" + this.f38136b + ", title=" + this.f38137c + ", description=" + this.f38138d + ", startDate=" + this.f38139e + ", orderHandle=" + this.f38140f + ')';
    }
}
