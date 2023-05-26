package ee.mtakso.driver.ui.screens.order.v2.order;

import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScreenState.kt */
/* loaded from: classes3.dex */
public final class ChatButtonInfo {

    /* renamed from: a  reason: collision with root package name */
    private final int f32196a;

    /* renamed from: b  reason: collision with root package name */
    private final ChatMessageEntity f32197b;

    /* renamed from: c  reason: collision with root package name */
    private final String f32198c;

    /* renamed from: d  reason: collision with root package name */
    private final String f32199d;

    /* renamed from: e  reason: collision with root package name */
    private final String f32200e;

    public ChatButtonInfo(int i8, ChatMessageEntity chatMessageEntity, String chatId, String title, String str) {
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(title, "title");
        this.f32196a = i8;
        this.f32197b = chatMessageEntity;
        this.f32198c = chatId;
        this.f32199d = title;
        this.f32200e = str;
    }

    public final ChatMessageEntity a() {
        return this.f32197b;
    }

    public final int b() {
        return this.f32196a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatButtonInfo) {
            ChatButtonInfo chatButtonInfo = (ChatButtonInfo) obj;
            return this.f32196a == chatButtonInfo.f32196a && Intrinsics.a(this.f32197b, chatButtonInfo.f32197b) && Intrinsics.a(this.f32198c, chatButtonInfo.f32198c) && Intrinsics.a(this.f32199d, chatButtonInfo.f32199d) && Intrinsics.a(this.f32200e, chatButtonInfo.f32200e);
        }
        return false;
    }

    public int hashCode() {
        int i8 = this.f32196a * 31;
        ChatMessageEntity chatMessageEntity = this.f32197b;
        int hashCode = (((((i8 + (chatMessageEntity == null ? 0 : chatMessageEntity.hashCode())) * 31) + this.f32198c.hashCode()) * 31) + this.f32199d.hashCode()) * 31;
        String str = this.f32200e;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        int i8 = this.f32196a;
        ChatMessageEntity chatMessageEntity = this.f32197b;
        String str = this.f32198c;
        String str2 = this.f32199d;
        String str3 = this.f32200e;
        return "ChatButtonInfo(messagesCount=" + i8 + ", lastMessage=" + chatMessageEntity + ", chatId=" + str + ", title=" + str2 + ", description=" + str3 + ")";
    }
}
