package eu.bolt.client.chatdb.room.message;

import eu.bolt.client.chatdb.room.message.translation.TranslationDBModel;
import i0.a;
import j$.util.Spliterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessageDBModel.kt */
/* loaded from: classes5.dex */
public final class MessageDBModel {

    /* renamed from: n  reason: collision with root package name */
    public static final Companion f39822n = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private String f39823a;

    /* renamed from: b  reason: collision with root package name */
    private String f39824b;

    /* renamed from: c  reason: collision with root package name */
    private int f39825c;

    /* renamed from: d  reason: collision with root package name */
    private String f39826d;

    /* renamed from: e  reason: collision with root package name */
    private String f39827e;

    /* renamed from: f  reason: collision with root package name */
    private String f39828f;

    /* renamed from: g  reason: collision with root package name */
    private String f39829g;

    /* renamed from: h  reason: collision with root package name */
    private String f39830h;

    /* renamed from: i  reason: collision with root package name */
    private long f39831i;

    /* renamed from: j  reason: collision with root package name */
    private MessageStatusDBModel f39832j;

    /* renamed from: k  reason: collision with root package name */
    private int f39833k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f39834l;

    /* renamed from: m  reason: collision with root package name */
    private TranslationDBModel f39835m;

    /* compiled from: MessageDBModel.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MessageDBModel(String id, String chatId, int i8, String str, String str2, String senderId, String senderName, String quickReplyId, long j8, MessageStatusDBModel status, int i9, boolean z7, TranslationDBModel translationDBModel) {
        Intrinsics.f(id, "id");
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(senderId, "senderId");
        Intrinsics.f(senderName, "senderName");
        Intrinsics.f(quickReplyId, "quickReplyId");
        Intrinsics.f(status, "status");
        this.f39823a = id;
        this.f39824b = chatId;
        this.f39825c = i8;
        this.f39826d = str;
        this.f39827e = str2;
        this.f39828f = senderId;
        this.f39829g = senderName;
        this.f39830h = quickReplyId;
        this.f39831i = j8;
        this.f39832j = status;
        this.f39833k = i9;
        this.f39834l = z7;
        this.f39835m = translationDBModel;
    }

    public final void A(TranslationDBModel translationDBModel) {
        this.f39835m = translationDBModel;
    }

    public final void B(int i8) {
        this.f39825c = i8;
    }

    public final MessageDBModel a(String id, String chatId, int i8, String str, String str2, String senderId, String senderName, String quickReplyId, long j8, MessageStatusDBModel status, int i9, boolean z7, TranslationDBModel translationDBModel) {
        Intrinsics.f(id, "id");
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(senderId, "senderId");
        Intrinsics.f(senderName, "senderName");
        Intrinsics.f(quickReplyId, "quickReplyId");
        Intrinsics.f(status, "status");
        return new MessageDBModel(id, chatId, i8, str, str2, senderId, senderName, quickReplyId, j8, status, i9, z7, translationDBModel);
    }

    public final String c() {
        return this.f39826d;
    }

    public final String d() {
        return this.f39824b;
    }

    public final long e() {
        return this.f39831i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MessageDBModel) {
            MessageDBModel messageDBModel = (MessageDBModel) obj;
            return Intrinsics.a(this.f39823a, messageDBModel.f39823a) && Intrinsics.a(this.f39824b, messageDBModel.f39824b) && this.f39825c == messageDBModel.f39825c && Intrinsics.a(this.f39826d, messageDBModel.f39826d) && Intrinsics.a(this.f39827e, messageDBModel.f39827e) && Intrinsics.a(this.f39828f, messageDBModel.f39828f) && Intrinsics.a(this.f39829g, messageDBModel.f39829g) && Intrinsics.a(this.f39830h, messageDBModel.f39830h) && this.f39831i == messageDBModel.f39831i && this.f39832j == messageDBModel.f39832j && this.f39833k == messageDBModel.f39833k && this.f39834l == messageDBModel.f39834l && Intrinsics.a(this.f39835m, messageDBModel.f39835m);
        }
        return false;
    }

    public final String f() {
        return this.f39823a;
    }

    public final String g() {
        return this.f39830h;
    }

    public final int h() {
        return this.f39833k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.f39823a.hashCode() * 31) + this.f39824b.hashCode()) * 31) + this.f39825c) * 31;
        String str = this.f39826d;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f39827e;
        int hashCode3 = (((((((((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f39828f.hashCode()) * 31) + this.f39829g.hashCode()) * 31) + this.f39830h.hashCode()) * 31) + a.a(this.f39831i)) * 31) + this.f39832j.hashCode()) * 31) + this.f39833k) * 31;
        boolean z7 = this.f39834l;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode3 + i8) * 31;
        TranslationDBModel translationDBModel = this.f39835m;
        return i9 + (translationDBModel != null ? translationDBModel.hashCode() : 0);
    }

    public final String i() {
        return this.f39828f;
    }

    public final String j() {
        return this.f39829g;
    }

    public final MessageStatusDBModel k() {
        return this.f39832j;
    }

    public final String l() {
        return this.f39827e;
    }

    public final TranslationDBModel m() {
        return this.f39835m;
    }

    public final int n() {
        return this.f39825c;
    }

    public final boolean o() {
        return this.f39834l;
    }

    public final void p(String str) {
        this.f39826d = str;
    }

    public final void q(String str) {
        Intrinsics.f(str, "<set-?>");
        this.f39824b = str;
    }

    public final void r(long j8) {
        this.f39831i = j8;
    }

    public final void s(String str) {
        Intrinsics.f(str, "<set-?>");
        this.f39823a = str;
    }

    public final void t(String str) {
        Intrinsics.f(str, "<set-?>");
        this.f39830h = str;
    }

    public String toString() {
        return "MessageDBModel(id=" + this.f39823a + ", chatId=" + this.f39824b + ", type=" + this.f39825c + ", attachmentsId=" + this.f39826d + ", text=" + this.f39827e + ", senderId=" + this.f39828f + ", senderName=" + this.f39829g + ", quickReplyId=" + this.f39830h + ", date=" + this.f39831i + ", status=" + this.f39832j + ", resendCounter=" + this.f39833k + ", isSilent=" + this.f39834l + ", translation=" + this.f39835m + ')';
    }

    public final void u(int i8) {
        this.f39833k = i8;
    }

    public final void v(String str) {
        Intrinsics.f(str, "<set-?>");
        this.f39828f = str;
    }

    public final void w(String str) {
        Intrinsics.f(str, "<set-?>");
        this.f39829g = str;
    }

    public final void x(boolean z7) {
        this.f39834l = z7;
    }

    public final void y(MessageStatusDBModel messageStatusDBModel) {
        Intrinsics.f(messageStatusDBModel, "<set-?>");
        this.f39832j = messageStatusDBModel;
    }

    public final void z(String str) {
        this.f39827e = str;
    }

    public /* synthetic */ MessageDBModel(String str, String str2, int i8, String str3, String str4, String str5, String str6, String str7, long j8, MessageStatusDBModel messageStatusDBModel, int i9, boolean z7, TranslationDBModel translationDBModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? "" : str, str2, (i10 & 4) != 0 ? 1 : i8, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? "" : str5, (i10 & 64) != 0 ? "" : str6, (i10 & 128) != 0 ? "" : str7, (i10 & Spliterator.NONNULL) != 0 ? 0L : j8, (i10 & 512) != 0 ? MessageStatusDBModel.SENDING : messageStatusDBModel, (i10 & Spliterator.IMMUTABLE) != 0 ? 15 : i9, (i10 & 2048) != 0 ? false : z7, (i10 & 4096) != 0 ? null : translationDBModel);
    }

    public MessageDBModel() {
        this("", "", 0, null, null, null, null, null, 0L, null, 0, false, null, 8188, null);
    }
}
