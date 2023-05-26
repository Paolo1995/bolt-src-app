package eu.bolt.chat.data.message;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDateTime;

/* compiled from: ServiceTextMessage.kt */
/* loaded from: classes5.dex */
public final class ServiceTextMessage implements ServiceMessage, ChatMessage {

    /* renamed from: a  reason: collision with root package name */
    private final String f39011a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39012b;

    /* renamed from: c  reason: collision with root package name */
    private final LocalDateTime f39013c;

    /* renamed from: d  reason: collision with root package name */
    private final MessageStatus f39014d;

    /* renamed from: e  reason: collision with root package name */
    private final String f39015e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f39016f;

    /* renamed from: g  reason: collision with root package name */
    private final MessageImportance f39017g;

    public ServiceTextMessage(String id, String chatId, LocalDateTime date, MessageStatus status, String text, boolean z7) {
        Intrinsics.f(id, "id");
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(date, "date");
        Intrinsics.f(status, "status");
        Intrinsics.f(text, "text");
        this.f39011a = id;
        this.f39012b = chatId;
        this.f39013c = date;
        this.f39014d = status;
        this.f39015e = text;
        this.f39016f = z7;
        this.f39017g = MessageImportance.MEDIUM;
    }

    public static /* synthetic */ ServiceTextMessage h(ServiceTextMessage serviceTextMessage, String str, String str2, LocalDateTime localDateTime, MessageStatus messageStatus, String str3, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = serviceTextMessage.getId();
        }
        if ((i8 & 2) != 0) {
            str2 = serviceTextMessage.d();
        }
        String str4 = str2;
        if ((i8 & 4) != 0) {
            localDateTime = serviceTextMessage.b();
        }
        LocalDateTime localDateTime2 = localDateTime;
        if ((i8 & 8) != 0) {
            messageStatus = serviceTextMessage.getStatus();
        }
        MessageStatus messageStatus2 = messageStatus;
        if ((i8 & 16) != 0) {
            str3 = serviceTextMessage.i();
        }
        String str5 = str3;
        if ((i8 & 32) != 0) {
            z7 = serviceTextMessage.f();
        }
        return serviceTextMessage.g(str, str4, localDateTime2, messageStatus2, str5, z7);
    }

    @Override // eu.bolt.chat.data.message.ChatMessage
    public LocalDateTime b() {
        return this.f39013c;
    }

    @Override // eu.bolt.chat.data.message.IdentifiableChatMessage
    public String d() {
        return this.f39012b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ServiceTextMessage) {
            ServiceTextMessage serviceTextMessage = (ServiceTextMessage) obj;
            return Intrinsics.a(getId(), serviceTextMessage.getId()) && Intrinsics.a(d(), serviceTextMessage.d()) && Intrinsics.a(b(), serviceTextMessage.b()) && getStatus() == serviceTextMessage.getStatus() && Intrinsics.a(i(), serviceTextMessage.i()) && f() == serviceTextMessage.f();
        }
        return false;
    }

    @Override // eu.bolt.chat.data.message.ServiceMessage
    public boolean f() {
        return this.f39016f;
    }

    public final ServiceTextMessage g(String id, String chatId, LocalDateTime date, MessageStatus status, String text, boolean z7) {
        Intrinsics.f(id, "id");
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(date, "date");
        Intrinsics.f(status, "status");
        Intrinsics.f(text, "text");
        return new ServiceTextMessage(id, chatId, date, status, text, z7);
    }

    @Override // eu.bolt.chat.data.message.IdentifiableChatMessage
    public String getId() {
        return this.f39011a;
    }

    @Override // eu.bolt.chat.data.message.ChatMessage
    public MessageStatus getStatus() {
        return this.f39014d;
    }

    public int hashCode() {
        int hashCode = ((((((((getId().hashCode() * 31) + d().hashCode()) * 31) + b().hashCode()) * 31) + getStatus().hashCode()) * 31) + i().hashCode()) * 31;
        boolean f8 = f();
        int i8 = f8;
        if (f8) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String i() {
        return this.f39015e;
    }

    @Override // eu.bolt.chat.data.message.ChatMessage
    /* renamed from: j */
    public ServiceTextMessage a(MessageStatus newStatus) {
        Intrinsics.f(newStatus, "newStatus");
        return h(this, null, null, null, newStatus, null, false, 55, null);
    }

    public String toString() {
        return "ServiceTextMessage(id=" + getId() + ", chatId=" + d() + ", date=" + b() + ", status=" + getStatus() + ", text=" + i() + ", isSilent=" + f() + ')';
    }
}
