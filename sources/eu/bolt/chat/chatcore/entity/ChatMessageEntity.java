package eu.bolt.chat.chatcore.entity;

import i0.a;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMessageEntity.kt */
/* loaded from: classes5.dex */
public final class ChatMessageEntity {

    /* renamed from: o  reason: collision with root package name */
    public static final Companion f38144o = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f38145a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38146b;

    /* renamed from: c  reason: collision with root package name */
    private final ChatMessageType f38147c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Object> f38148d;

    /* renamed from: e  reason: collision with root package name */
    private final String f38149e;

    /* renamed from: f  reason: collision with root package name */
    private final String f38150f;

    /* renamed from: g  reason: collision with root package name */
    private final String f38151g;

    /* renamed from: h  reason: collision with root package name */
    private final String f38152h;

    /* renamed from: i  reason: collision with root package name */
    private final long f38153i;

    /* renamed from: j  reason: collision with root package name */
    private final ChatMessageStatus f38154j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f38155k;

    /* renamed from: l  reason: collision with root package name */
    private final int f38156l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f38157m;

    /* renamed from: n  reason: collision with root package name */
    private final ChatMessageTranslation f38158n;

    /* compiled from: ChatMessageEntity.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ChatMessageEntity(String id, String chatId, ChatMessageType type, List<Object> attachments, String str, String str2, String senderId, String senderName, long j8, ChatMessageStatus status, boolean z7, int i8, boolean z8, ChatMessageTranslation chatMessageTranslation) {
        Intrinsics.f(id, "id");
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(type, "type");
        Intrinsics.f(attachments, "attachments");
        Intrinsics.f(senderId, "senderId");
        Intrinsics.f(senderName, "senderName");
        Intrinsics.f(status, "status");
        this.f38145a = id;
        this.f38146b = chatId;
        this.f38147c = type;
        this.f38148d = attachments;
        this.f38149e = str;
        this.f38150f = str2;
        this.f38151g = senderId;
        this.f38152h = senderName;
        this.f38153i = j8;
        this.f38154j = status;
        this.f38155k = z7;
        this.f38156l = i8;
        this.f38157m = z8;
        this.f38158n = chatMessageTranslation;
    }

    public final boolean a() {
        if (this.f38156l > 0) {
            return true;
        }
        return false;
    }

    public final String b() {
        return this.f38146b;
    }

    public final long c() {
        return this.f38153i;
    }

    public final String d() {
        return this.f38145a;
    }

    public final String e() {
        return this.f38150f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatMessageEntity) {
            ChatMessageEntity chatMessageEntity = (ChatMessageEntity) obj;
            return Intrinsics.a(this.f38145a, chatMessageEntity.f38145a) && Intrinsics.a(this.f38146b, chatMessageEntity.f38146b) && this.f38147c == chatMessageEntity.f38147c && Intrinsics.a(this.f38148d, chatMessageEntity.f38148d) && Intrinsics.a(this.f38149e, chatMessageEntity.f38149e) && Intrinsics.a(this.f38150f, chatMessageEntity.f38150f) && Intrinsics.a(this.f38151g, chatMessageEntity.f38151g) && Intrinsics.a(this.f38152h, chatMessageEntity.f38152h) && this.f38153i == chatMessageEntity.f38153i && Intrinsics.a(this.f38154j, chatMessageEntity.f38154j) && this.f38155k == chatMessageEntity.f38155k && this.f38156l == chatMessageEntity.f38156l && this.f38157m == chatMessageEntity.f38157m && Intrinsics.a(this.f38158n, chatMessageEntity.f38158n);
        }
        return false;
    }

    public final int f() {
        return this.f38156l;
    }

    public final String g() {
        return this.f38151g;
    }

    public final String h() {
        return this.f38152h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.f38145a.hashCode() * 31) + this.f38146b.hashCode()) * 31) + this.f38147c.hashCode()) * 31) + this.f38148d.hashCode()) * 31;
        String str = this.f38149e;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f38150f;
        int hashCode3 = (((((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f38151g.hashCode()) * 31) + this.f38152h.hashCode()) * 31) + a.a(this.f38153i)) * 31) + this.f38154j.hashCode()) * 31;
        boolean z7 = this.f38155k;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (((hashCode3 + i8) * 31) + this.f38156l) * 31;
        boolean z8 = this.f38157m;
        int i10 = (i9 + (z8 ? 1 : z8 ? 1 : 0)) * 31;
        ChatMessageTranslation chatMessageTranslation = this.f38158n;
        return i10 + (chatMessageTranslation != null ? chatMessageTranslation.hashCode() : 0);
    }

    public final ChatMessageStatus i() {
        return this.f38154j;
    }

    public final String j() {
        return this.f38149e;
    }

    public final String k() {
        String b8;
        ChatMessageTranslation chatMessageTranslation = this.f38158n;
        if (chatMessageTranslation == null || (b8 = chatMessageTranslation.b()) == null) {
            return this.f38149e;
        }
        return b8;
    }

    public final ChatMessageTranslation l() {
        return this.f38158n;
    }

    public final ChatMessageType m() {
        return this.f38147c;
    }

    public final boolean n() {
        return this.f38155k;
    }

    public final boolean o() {
        return this.f38157m;
    }

    public String toString() {
        return "ChatMessageEntity(id=" + this.f38145a + ", chatId=" + this.f38146b + ", type=" + this.f38147c + ", attachments=" + this.f38148d + ", text=" + this.f38149e + ", quickReplyId=" + this.f38150f + ", senderId=" + this.f38151g + ", senderName=" + this.f38152h + ", date=" + this.f38153i + ", status=" + this.f38154j + ", isMyMessage=" + this.f38155k + ", resendCounter=" + this.f38156l + ", isSilent=" + this.f38157m + ", translation=" + this.f38158n + ')';
    }

    public /* synthetic */ ChatMessageEntity(String str, String str2, ChatMessageType chatMessageType, List list, String str3, String str4, String str5, String str6, long j8, ChatMessageStatus chatMessageStatus, boolean z7, int i8, boolean z8, ChatMessageTranslation chatMessageTranslation, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, chatMessageType, list, str3, (i9 & 32) != 0 ? null : str4, str5, str6, j8, chatMessageStatus, z7, i8, (i9 & 4096) != 0 ? false : z8, chatMessageTranslation);
    }
}
