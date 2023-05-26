package eu.bolt.chat.data.message;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDateTime;

/* compiled from: EndingServiceMessage.kt */
/* loaded from: classes5.dex */
public final class EndingServiceMessage implements ServiceMessage, ChatMessage {

    /* renamed from: a  reason: collision with root package name */
    private final String f38978a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38979b;

    /* renamed from: c  reason: collision with root package name */
    private final LocalDateTime f38980c;

    /* renamed from: d  reason: collision with root package name */
    private final MessageStatus f38981d;

    /* renamed from: e  reason: collision with root package name */
    private final MessageImportance f38982e;

    /* renamed from: f  reason: collision with root package name */
    private final String f38983f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f38984g;

    public EndingServiceMessage(String id, String chatId, LocalDateTime date, MessageStatus status, MessageImportance importance, String text) {
        Intrinsics.f(id, "id");
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(date, "date");
        Intrinsics.f(status, "status");
        Intrinsics.f(importance, "importance");
        Intrinsics.f(text, "text");
        this.f38978a = id;
        this.f38979b = chatId;
        this.f38980c = date;
        this.f38981d = status;
        this.f38982e = importance;
        this.f38983f = text;
        this.f38984g = true;
    }

    public static /* synthetic */ EndingServiceMessage h(EndingServiceMessage endingServiceMessage, String str, String str2, LocalDateTime localDateTime, MessageStatus messageStatus, MessageImportance messageImportance, String str3, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = endingServiceMessage.getId();
        }
        if ((i8 & 2) != 0) {
            str2 = endingServiceMessage.d();
        }
        String str4 = str2;
        if ((i8 & 4) != 0) {
            localDateTime = endingServiceMessage.b();
        }
        LocalDateTime localDateTime2 = localDateTime;
        if ((i8 & 8) != 0) {
            messageStatus = endingServiceMessage.getStatus();
        }
        MessageStatus messageStatus2 = messageStatus;
        if ((i8 & 16) != 0) {
            messageImportance = endingServiceMessage.i();
        }
        MessageImportance messageImportance2 = messageImportance;
        if ((i8 & 32) != 0) {
            str3 = endingServiceMessage.j();
        }
        return endingServiceMessage.g(str, str4, localDateTime2, messageStatus2, messageImportance2, str3);
    }

    @Override // eu.bolt.chat.data.message.ChatMessage
    public LocalDateTime b() {
        return this.f38980c;
    }

    @Override // eu.bolt.chat.data.message.IdentifiableChatMessage
    public String d() {
        return this.f38979b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EndingServiceMessage) {
            EndingServiceMessage endingServiceMessage = (EndingServiceMessage) obj;
            return Intrinsics.a(getId(), endingServiceMessage.getId()) && Intrinsics.a(d(), endingServiceMessage.d()) && Intrinsics.a(b(), endingServiceMessage.b()) && getStatus() == endingServiceMessage.getStatus() && i() == endingServiceMessage.i() && Intrinsics.a(j(), endingServiceMessage.j());
        }
        return false;
    }

    @Override // eu.bolt.chat.data.message.ServiceMessage
    public boolean f() {
        return this.f38984g;
    }

    public final EndingServiceMessage g(String id, String chatId, LocalDateTime date, MessageStatus status, MessageImportance importance, String text) {
        Intrinsics.f(id, "id");
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(date, "date");
        Intrinsics.f(status, "status");
        Intrinsics.f(importance, "importance");
        Intrinsics.f(text, "text");
        return new EndingServiceMessage(id, chatId, date, status, importance, text);
    }

    @Override // eu.bolt.chat.data.message.IdentifiableChatMessage
    public String getId() {
        return this.f38978a;
    }

    @Override // eu.bolt.chat.data.message.ChatMessage
    public MessageStatus getStatus() {
        return this.f38981d;
    }

    public int hashCode() {
        return (((((((((getId().hashCode() * 31) + d().hashCode()) * 31) + b().hashCode()) * 31) + getStatus().hashCode()) * 31) + i().hashCode()) * 31) + j().hashCode();
    }

    public MessageImportance i() {
        return this.f38982e;
    }

    public String j() {
        return this.f38983f;
    }

    @Override // eu.bolt.chat.data.message.ChatMessage
    /* renamed from: k */
    public EndingServiceMessage a(MessageStatus newStatus) {
        Intrinsics.f(newStatus, "newStatus");
        return h(this, null, null, null, newStatus, null, null, 55, null);
    }

    public String toString() {
        return "EndingServiceMessage(id=" + getId() + ", chatId=" + d() + ", date=" + b() + ", status=" + getStatus() + ", importance=" + i() + ", text=" + j() + ')';
    }
}
