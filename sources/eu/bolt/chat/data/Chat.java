package eu.bolt.chat.data;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Chat.kt */
/* loaded from: classes5.dex */
public final class Chat {

    /* renamed from: a  reason: collision with root package name */
    private final String f38923a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38924b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38925c;

    /* renamed from: d  reason: collision with root package name */
    private final String f38926d;

    /* renamed from: e  reason: collision with root package name */
    private final OrderHandle f38927e;

    /* renamed from: f  reason: collision with root package name */
    private final ChatStatus f38928f;

    public Chat(String id, String title, String str, String str2, OrderHandle orderHandle, ChatStatus status) {
        Intrinsics.f(id, "id");
        Intrinsics.f(title, "title");
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(status, "status");
        this.f38923a = id;
        this.f38924b = title;
        this.f38925c = str;
        this.f38926d = str2;
        this.f38927e = orderHandle;
        this.f38928f = status;
    }

    public static /* synthetic */ Chat b(Chat chat, String str, String str2, String str3, String str4, OrderHandle orderHandle, ChatStatus chatStatus, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = chat.f38923a;
        }
        if ((i8 & 2) != 0) {
            str2 = chat.f38924b;
        }
        String str5 = str2;
        if ((i8 & 4) != 0) {
            str3 = chat.f38925c;
        }
        String str6 = str3;
        if ((i8 & 8) != 0) {
            str4 = chat.f38926d;
        }
        String str7 = str4;
        if ((i8 & 16) != 0) {
            orderHandle = chat.f38927e;
        }
        OrderHandle orderHandle2 = orderHandle;
        if ((i8 & 32) != 0) {
            chatStatus = chat.f38928f;
        }
        return chat.a(str, str5, str6, str7, orderHandle2, chatStatus);
    }

    public final Chat a(String id, String title, String str, String str2, OrderHandle orderHandle, ChatStatus status) {
        Intrinsics.f(id, "id");
        Intrinsics.f(title, "title");
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(status, "status");
        return new Chat(id, title, str, str2, orderHandle, status);
    }

    public final String c() {
        return this.f38925c;
    }

    public final String d() {
        return this.f38923a;
    }

    public final OrderHandle e() {
        return this.f38927e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Chat) {
            Chat chat = (Chat) obj;
            return Intrinsics.a(this.f38923a, chat.f38923a) && Intrinsics.a(this.f38924b, chat.f38924b) && Intrinsics.a(this.f38925c, chat.f38925c) && Intrinsics.a(this.f38926d, chat.f38926d) && Intrinsics.a(this.f38927e, chat.f38927e) && this.f38928f == chat.f38928f;
        }
        return false;
    }

    public final ChatStatus f() {
        return this.f38928f;
    }

    public final String g() {
        return this.f38926d;
    }

    public final String h() {
        return this.f38924b;
    }

    public int hashCode() {
        int hashCode = ((this.f38923a.hashCode() * 31) + this.f38924b.hashCode()) * 31;
        String str = this.f38925c;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f38926d;
        return ((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f38927e.hashCode()) * 31) + this.f38928f.hashCode();
    }

    public String toString() {
        return "Chat(id=" + this.f38923a + ", title=" + this.f38924b + ", description=" + this.f38925c + ", thumbnailUrl=" + this.f38926d + ", orderHandle=" + this.f38927e + ", status=" + this.f38928f + ')';
    }
}
