package eu.bolt.client.chatdb.room.terminalmessage;

import i0.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TerminalMessageDBModel.kt */
/* loaded from: classes5.dex */
public final class TerminalMessageDBModel {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f39901f = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private String f39902a;

    /* renamed from: b  reason: collision with root package name */
    private String f39903b;

    /* renamed from: c  reason: collision with root package name */
    private String f39904c;

    /* renamed from: d  reason: collision with root package name */
    private String f39905d;

    /* renamed from: e  reason: collision with root package name */
    private long f39906e;

    /* compiled from: TerminalMessageDBModel.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TerminalMessageDBModel(String id, String chatId, String message, String status, long j8) {
        Intrinsics.f(id, "id");
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(message, "message");
        Intrinsics.f(status, "status");
        this.f39902a = id;
        this.f39903b = chatId;
        this.f39904c = message;
        this.f39905d = status;
        this.f39906e = j8;
    }

    public final String a() {
        return this.f39903b;
    }

    public final long b() {
        return this.f39906e;
    }

    public final String c() {
        return this.f39902a;
    }

    public final String d() {
        return this.f39904c;
    }

    public final String e() {
        return this.f39905d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TerminalMessageDBModel) {
            TerminalMessageDBModel terminalMessageDBModel = (TerminalMessageDBModel) obj;
            return Intrinsics.a(this.f39902a, terminalMessageDBModel.f39902a) && Intrinsics.a(this.f39903b, terminalMessageDBModel.f39903b) && Intrinsics.a(this.f39904c, terminalMessageDBModel.f39904c) && Intrinsics.a(this.f39905d, terminalMessageDBModel.f39905d) && this.f39906e == terminalMessageDBModel.f39906e;
        }
        return false;
    }

    public final void f(String str) {
        Intrinsics.f(str, "<set-?>");
        this.f39903b = str;
    }

    public final void g(long j8) {
        this.f39906e = j8;
    }

    public final void h(String str) {
        Intrinsics.f(str, "<set-?>");
        this.f39902a = str;
    }

    public int hashCode() {
        return (((((((this.f39902a.hashCode() * 31) + this.f39903b.hashCode()) * 31) + this.f39904c.hashCode()) * 31) + this.f39905d.hashCode()) * 31) + a.a(this.f39906e);
    }

    public final void i(String str) {
        Intrinsics.f(str, "<set-?>");
        this.f39904c = str;
    }

    public final void j(String str) {
        Intrinsics.f(str, "<set-?>");
        this.f39905d = str;
    }

    public String toString() {
        return "TerminalMessageDBModel(id=" + this.f39902a + ", chatId=" + this.f39903b + ", message=" + this.f39904c + ", status=" + this.f39905d + ", date=" + this.f39906e + ')';
    }

    public /* synthetic */ TerminalMessageDBModel(String str, String str2, String str3, String str4, long j8, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? "" : str, (i8 & 2) != 0 ? "" : str2, (i8 & 4) != 0 ? "" : str3, (i8 & 8) == 0 ? str4 : "", (i8 & 16) != 0 ? 0L : j8);
    }

    public TerminalMessageDBModel() {
        this("", null, null, null, 0L, 30, null);
    }
}
