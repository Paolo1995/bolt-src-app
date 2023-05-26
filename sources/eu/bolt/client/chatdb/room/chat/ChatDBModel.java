package eu.bolt.client.chatdb.room.chat;

import i0.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatDBModel.kt */
/* loaded from: classes5.dex */
public final class ChatDBModel {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f39791g = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private String f39792a;

    /* renamed from: b  reason: collision with root package name */
    private String f39793b;

    /* renamed from: c  reason: collision with root package name */
    private String f39794c;

    /* renamed from: d  reason: collision with root package name */
    private String f39795d;

    /* renamed from: e  reason: collision with root package name */
    private long f39796e;

    /* renamed from: f  reason: collision with root package name */
    private OrderHandleDbModel f39797f;

    /* compiled from: ChatDBModel.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ChatDBModel(String id, String title, String str, String str2, long j8, OrderHandleDbModel orderHandle) {
        Intrinsics.f(id, "id");
        Intrinsics.f(title, "title");
        Intrinsics.f(orderHandle, "orderHandle");
        this.f39792a = id;
        this.f39793b = title;
        this.f39794c = str;
        this.f39795d = str2;
        this.f39796e = j8;
        this.f39797f = orderHandle;
    }

    public final String a() {
        return this.f39794c;
    }

    public final String b() {
        return this.f39792a;
    }

    public final OrderHandleDbModel c() {
        return this.f39797f;
    }

    public final long d() {
        return this.f39796e;
    }

    public final String e() {
        return this.f39795d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatDBModel) {
            ChatDBModel chatDBModel = (ChatDBModel) obj;
            return Intrinsics.a(this.f39792a, chatDBModel.f39792a) && Intrinsics.a(this.f39793b, chatDBModel.f39793b) && Intrinsics.a(this.f39794c, chatDBModel.f39794c) && Intrinsics.a(this.f39795d, chatDBModel.f39795d) && this.f39796e == chatDBModel.f39796e && Intrinsics.a(this.f39797f, chatDBModel.f39797f);
        }
        return false;
    }

    public final String f() {
        return this.f39793b;
    }

    public final void g(String str) {
        this.f39794c = str;
    }

    public final void h(String str) {
        Intrinsics.f(str, "<set-?>");
        this.f39792a = str;
    }

    public int hashCode() {
        int hashCode = ((this.f39792a.hashCode() * 31) + this.f39793b.hashCode()) * 31;
        String str = this.f39794c;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f39795d;
        return ((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + a.a(this.f39796e)) * 31) + this.f39797f.hashCode();
    }

    public final void i(OrderHandleDbModel orderHandleDbModel) {
        Intrinsics.f(orderHandleDbModel, "<set-?>");
        this.f39797f = orderHandleDbModel;
    }

    public final void j(long j8) {
        this.f39796e = j8;
    }

    public final void k(String str) {
        this.f39795d = str;
    }

    public final void l(String str) {
        Intrinsics.f(str, "<set-?>");
        this.f39793b = str;
    }

    public String toString() {
        return "ChatDBModel(id=" + this.f39792a + ", title=" + this.f39793b + ", description=" + this.f39794c + ", thumbnail=" + this.f39795d + ", startDate=" + this.f39796e + ", orderHandle=" + this.f39797f + ')';
    }

    public /* synthetic */ ChatDBModel(String str, String str2, String str3, String str4, long j8, OrderHandleDbModel orderHandleDbModel, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i8 & 4) != 0 ? null : str3, (i8 & 8) != 0 ? null : str4, j8, orderHandleDbModel);
    }

    public ChatDBModel() {
        this("", "", null, null, 0L, new OrderHandleDbModel(), 12, null);
    }
}
