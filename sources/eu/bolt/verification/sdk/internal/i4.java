package eu.bolt.verification.sdk.internal;

import j$.util.Spliterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class i4 {

    /* renamed from: i  reason: collision with root package name */
    public static final a f43468i = new a(null);

    /* renamed from: j  reason: collision with root package name */
    private static final b.a f43469j = b.a.f43479b;

    /* renamed from: a  reason: collision with root package name */
    private final aa f43470a;

    /* renamed from: b  reason: collision with root package name */
    private final f f43471b;

    /* renamed from: c  reason: collision with root package name */
    private final Integer f43472c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f43473d;

    /* renamed from: e  reason: collision with root package name */
    private final String f43474e;

    /* renamed from: f  reason: collision with root package name */
    private final b f43475f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f43476g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f43477h;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f43478a;

        /* loaded from: classes5.dex */
        public static final class a extends b {

            /* renamed from: b  reason: collision with root package name */
            public static final a f43479b = new a();

            private a() {
                super(1, null);
            }
        }

        private b(int i8) {
            this.f43478a = i8;
        }

        public /* synthetic */ b(int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(i8);
        }

        public final int a() {
            return this.f43478a;
        }
    }

    public i4() {
        this(null, null, null, null, null, null, null, null, null, false, false, 2047, null);
    }

    public i4(b2 b2Var, b2 b2Var2, aa aaVar, f fVar, b2 b2Var3, Integer num, Object obj, String str, b priority, boolean z7, boolean z8) {
        Intrinsics.f(priority, "priority");
        this.f43470a = aaVar;
        this.f43471b = fVar;
        this.f43472c = num;
        this.f43473d = obj;
        this.f43474e = str;
        this.f43475f = priority;
        this.f43476g = z7;
        this.f43477h = z8;
    }

    public /* synthetic */ i4(b2 b2Var, b2 b2Var2, aa aaVar, f fVar, b2 b2Var3, Integer num, Object obj, String str, b bVar, boolean z7, boolean z8, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? null : b2Var, (i8 & 2) != 0 ? null : b2Var2, (i8 & 4) != 0 ? null : aaVar, (i8 & 8) != 0 ? null : fVar, (i8 & 16) != 0 ? null : b2Var3, (i8 & 32) != 0 ? null : num, (i8 & 64) != 0 ? null : obj, (i8 & 128) == 0 ? str : null, (i8 & Spliterator.NONNULL) != 0 ? f43469j : bVar, (i8 & 512) != 0 ? true : z7, (i8 & Spliterator.IMMUTABLE) != 0 ? false : z8);
    }

    public final f a() {
        return this.f43471b;
    }

    public final b2 b() {
        return null;
    }

    public final Integer c() {
        return this.f43472c;
    }

    public final b2 d() {
        return null;
    }

    public final boolean e() {
        return this.f43477h;
    }

    public final aa f() {
        return this.f43470a;
    }

    public final Object g() {
        return this.f43473d;
    }

    public final b h() {
        return this.f43475f;
    }

    public final b2 i() {
        return null;
    }

    public final boolean j() {
        return this.f43476g;
    }
}
