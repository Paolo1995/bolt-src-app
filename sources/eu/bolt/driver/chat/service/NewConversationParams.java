package eu.bolt.driver.chat.service;

import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.OrderHandleEntity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NewConversationParams.kt */
/* loaded from: classes5.dex */
public final class NewConversationParams {

    /* renamed from: a  reason: collision with root package name */
    private final String f40471a;

    /* renamed from: b  reason: collision with root package name */
    private final long f40472b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40473c;

    /* renamed from: d  reason: collision with root package name */
    private final String f40474d;

    /* renamed from: e  reason: collision with root package name */
    private final OrderHandleEntity f40475e;

    /* renamed from: f  reason: collision with root package name */
    private final List<ChatMessageEntity> f40476f;

    public NewConversationParams(String chatId, long j8, String str, String title, OrderHandleEntity orderHandle, List<ChatMessageEntity> initialMessages) {
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(title, "title");
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(initialMessages, "initialMessages");
        this.f40471a = chatId;
        this.f40472b = j8;
        this.f40473c = str;
        this.f40474d = title;
        this.f40475e = orderHandle;
        this.f40476f = initialMessages;
    }

    public final String a() {
        return this.f40471a;
    }

    public final String b() {
        return this.f40473c;
    }

    public final List<ChatMessageEntity> c() {
        return this.f40476f;
    }

    public final OrderHandleEntity d() {
        return this.f40475e;
    }

    public final long e() {
        return this.f40472b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NewConversationParams) {
            NewConversationParams newConversationParams = (NewConversationParams) obj;
            return Intrinsics.a(this.f40471a, newConversationParams.f40471a) && this.f40472b == newConversationParams.f40472b && Intrinsics.a(this.f40473c, newConversationParams.f40473c) && Intrinsics.a(this.f40474d, newConversationParams.f40474d) && Intrinsics.a(this.f40475e, newConversationParams.f40475e) && Intrinsics.a(this.f40476f, newConversationParams.f40476f);
        }
        return false;
    }

    public final String f() {
        return this.f40474d;
    }

    public int hashCode() {
        int hashCode = ((this.f40471a.hashCode() * 31) + i0.a.a(this.f40472b)) * 31;
        String str = this.f40473c;
        return ((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f40474d.hashCode()) * 31) + this.f40475e.hashCode()) * 31) + this.f40476f.hashCode();
    }

    public String toString() {
        String str = this.f40471a;
        long j8 = this.f40472b;
        String str2 = this.f40473c;
        String str3 = this.f40474d;
        OrderHandleEntity orderHandleEntity = this.f40475e;
        List<ChatMessageEntity> list = this.f40476f;
        return "NewConversationParams(chatId=" + str + ", startTimestamp=" + j8 + ", description=" + str2 + ", title=" + str3 + ", orderHandle=" + orderHandleEntity + ", initialMessages=" + list + ")";
    }
}
