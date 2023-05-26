package eu.bolt.chat.data.message;

import eu.bolt.chat.data.message.UserMessage;
import j$.util.Spliterator;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDateTime;

/* compiled from: UserTextMessage.kt */
/* loaded from: classes5.dex */
public final class UserTextMessage implements UserMessage, ChatMessage {

    /* renamed from: a  reason: collision with root package name */
    private final String f39023a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39024b;

    /* renamed from: c  reason: collision with root package name */
    private final LocalDateTime f39025c;

    /* renamed from: d  reason: collision with root package name */
    private final MessageStatus f39026d;

    /* renamed from: e  reason: collision with root package name */
    private final String f39027e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f39028f;

    /* renamed from: g  reason: collision with root package name */
    private final MessageSender f39029g;

    /* renamed from: h  reason: collision with root package name */
    private final String f39030h;

    /* renamed from: i  reason: collision with root package name */
    private final TranslationInfo f39031i;

    public UserTextMessage(String id, String chatId, LocalDateTime date, MessageStatus status, String text, boolean z7, MessageSender sender, String str, TranslationInfo translationInfo) {
        Intrinsics.f(id, "id");
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(date, "date");
        Intrinsics.f(status, "status");
        Intrinsics.f(text, "text");
        Intrinsics.f(sender, "sender");
        this.f39023a = id;
        this.f39024b = chatId;
        this.f39025c = date;
        this.f39026d = status;
        this.f39027e = text;
        this.f39028f = z7;
        this.f39029g = sender;
        this.f39030h = str;
        this.f39031i = translationInfo;
    }

    public static /* synthetic */ UserTextMessage h(UserTextMessage userTextMessage, String str, String str2, LocalDateTime localDateTime, MessageStatus messageStatus, String str3, boolean z7, MessageSender messageSender, String str4, TranslationInfo translationInfo, int i8, Object obj) {
        return userTextMessage.g((i8 & 1) != 0 ? userTextMessage.getId() : str, (i8 & 2) != 0 ? userTextMessage.d() : str2, (i8 & 4) != 0 ? userTextMessage.b() : localDateTime, (i8 & 8) != 0 ? userTextMessage.getStatus() : messageStatus, (i8 & 16) != 0 ? userTextMessage.j() : str3, (i8 & 32) != 0 ? userTextMessage.e() : z7, (i8 & 64) != 0 ? userTextMessage.i() : messageSender, (i8 & 128) != 0 ? userTextMessage.f39030h : str4, (i8 & Spliterator.NONNULL) != 0 ? userTextMessage.f39031i : translationInfo);
    }

    @Override // eu.bolt.chat.data.message.ChatMessage
    public LocalDateTime b() {
        return this.f39025c;
    }

    @Override // eu.bolt.chat.data.message.UserMessage
    public boolean c() {
        return UserMessage.DefaultImpls.a(this);
    }

    @Override // eu.bolt.chat.data.message.IdentifiableChatMessage
    public String d() {
        return this.f39024b;
    }

    @Override // eu.bolt.chat.data.message.UserMessage
    public boolean e() {
        return this.f39028f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserTextMessage) {
            UserTextMessage userTextMessage = (UserTextMessage) obj;
            return Intrinsics.a(getId(), userTextMessage.getId()) && Intrinsics.a(d(), userTextMessage.d()) && Intrinsics.a(b(), userTextMessage.b()) && getStatus() == userTextMessage.getStatus() && Intrinsics.a(j(), userTextMessage.j()) && e() == userTextMessage.e() && Intrinsics.a(i(), userTextMessage.i()) && Intrinsics.a(this.f39030h, userTextMessage.f39030h) && Intrinsics.a(this.f39031i, userTextMessage.f39031i);
        }
        return false;
    }

    public final UserTextMessage g(String id, String chatId, LocalDateTime date, MessageStatus status, String text, boolean z7, MessageSender sender, String str, TranslationInfo translationInfo) {
        Intrinsics.f(id, "id");
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(date, "date");
        Intrinsics.f(status, "status");
        Intrinsics.f(text, "text");
        Intrinsics.f(sender, "sender");
        return new UserTextMessage(id, chatId, date, status, text, z7, sender, str, translationInfo);
    }

    @Override // eu.bolt.chat.data.message.IdentifiableChatMessage
    public String getId() {
        return this.f39023a;
    }

    @Override // eu.bolt.chat.data.message.ChatMessage
    public MessageStatus getStatus() {
        return this.f39026d;
    }

    public int hashCode() {
        int hashCode = ((((((((getId().hashCode() * 31) + d().hashCode()) * 31) + b().hashCode()) * 31) + getStatus().hashCode()) * 31) + j().hashCode()) * 31;
        boolean e8 = e();
        int i8 = e8;
        if (e8) {
            i8 = 1;
        }
        int hashCode2 = (((hashCode + i8) * 31) + i().hashCode()) * 31;
        String str = this.f39030h;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        TranslationInfo translationInfo = this.f39031i;
        return hashCode3 + (translationInfo != null ? translationInfo.hashCode() : 0);
    }

    public MessageSender i() {
        return this.f39029g;
    }

    public String j() {
        return this.f39027e;
    }

    public final TranslationInfo k() {
        return this.f39031i;
    }

    @Override // eu.bolt.chat.data.message.UserMessage, eu.bolt.chat.data.message.ChatMessage
    /* renamed from: l */
    public UserTextMessage a(MessageStatus newStatus) {
        Intrinsics.f(newStatus, "newStatus");
        return h(this, null, null, null, newStatus, null, false, null, null, null, 503, null);
    }

    public String toString() {
        return "UserTextMessage(id=" + getId() + ", chatId=" + d() + ", date=" + b() + ", status=" + getStatus() + ", text=" + j() + ", isOutgoing=" + e() + ", sender=" + i() + ", detectedLanguage=" + this.f39030h + ", translation=" + this.f39031i + ')';
    }
}
