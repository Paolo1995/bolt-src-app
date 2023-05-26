package eu.bolt.verification.sdk.internal;

import eu.bolt.logger.Logger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public abstract class ac {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy f42019a;

    /* loaded from: classes5.dex */
    public static final class a extends ac {

        /* renamed from: b  reason: collision with root package name */
        public static final a f42020b;

        /* renamed from: c  reason: collision with root package name */
        private static final String f42021c;

        /* renamed from: d  reason: collision with root package name */
        private static final Logger f42022d;

        /* renamed from: e  reason: collision with root package name */
        private static final Logger f42023e;

        /* renamed from: f  reason: collision with root package name */
        private static final Logger f42024f;

        /* renamed from: g  reason: collision with root package name */
        private static final Logger f42025g;

        /* renamed from: h  reason: collision with root package name */
        private static final Logger f42026h;

        /* renamed from: i  reason: collision with root package name */
        private static final Logger f42027i;

        /* renamed from: j  reason: collision with root package name */
        private static final Logger f42028j;

        /* renamed from: k  reason: collision with root package name */
        private static final Logger f42029k;

        /* renamed from: l  reason: collision with root package name */
        private static final Logger f42030l;

        /* renamed from: m  reason: collision with root package name */
        private static final Logger f42031m;

        /* renamed from: n  reason: collision with root package name */
        private static final Logger f42032n;

        /* renamed from: o  reason: collision with root package name */
        private static final Logger f42033o;

        /* renamed from: p  reason: collision with root package name */
        private static final Logger f42034p;

        /* renamed from: q  reason: collision with root package name */
        private static final Logger f42035q;

        /* renamed from: r  reason: collision with root package name */
        private static final Logger f42036r;

        /* renamed from: s  reason: collision with root package name */
        private static final Logger f42037s;

        /* renamed from: t  reason: collision with root package name */
        private static final Logger f42038t;

        /* renamed from: u  reason: collision with root package name */
        private static final Logger f42039u;

        /* renamed from: v  reason: collision with root package name */
        private static final Logger f42040v;

        /* renamed from: w  reason: collision with root package name */
        private static final Logger f42041w;

        /* renamed from: x  reason: collision with root package name */
        private static final Logger f42042x;

        /* renamed from: y  reason: collision with root package name */
        private static final Logger f42043y;

        /* renamed from: z  reason: collision with root package name */
        private static final Logger f42044z;

        static {
            a aVar = new a();
            f42020b = aVar;
            f42021c = "Core";
            f42022d = aVar.a("Location");
            f42023e = aVar.a("Targeting");
            f42024f = aVar.a("Push");
            f42025g = aVar.a("Serialization");
            f42026h = aVar.a("HMS");
            f42027i = aVar.a("Translation");
            f42028j = aVar.a("Firebase");
            f42029k = aVar.a("Analytics");
            f42030l = aVar.a("Survey");
            f42031m = aVar.a("UpdateApp");
            f42032n = aVar.a("AppRating");
            f42033o = aVar.a("Map");
            f42034p = aVar.a("LoggedIn");
            f42035q = aVar.a("Design");
            f42036r = aVar.a("Storages");
            f42037s = aVar.a("Camera");
            f42038t = aVar.a("Splash");
            f42039u = aVar.a("PerformanceTracing");
            f42040v = aVar.a("SideMenu");
            f42041w = aVar.a("Monitor");
            f42042x = aVar.a("Keyboard");
            f42043y = aVar.a("AppMemory");
            f42044z = aVar.a("ServiceDesk");
        }

        private a() {
            super(null);
        }

        @Override // eu.bolt.verification.sdk.internal.ac
        public String b() {
            return f42021c;
        }

        public final Logger c() {
            return f42029k;
        }

        public final Logger d() {
            return f42037s;
        }

        public final Logger e() {
            return f42035q;
        }

        public final Logger f() {
            return f42042x;
        }

        public final Logger g() {
            return f42036r;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends ac {

        /* renamed from: b  reason: collision with root package name */
        public static final b f42045b;

        /* renamed from: c  reason: collision with root package name */
        private static final String f42046c;

        /* renamed from: d  reason: collision with root package name */
        private static final Logger f42047d;

        /* renamed from: e  reason: collision with root package name */
        private static final Logger f42048e;

        /* renamed from: f  reason: collision with root package name */
        private static final Logger f42049f;

        /* renamed from: g  reason: collision with root package name */
        private static final Logger f42050g;

        /* renamed from: h  reason: collision with root package name */
        private static final Logger f42051h;

        /* renamed from: i  reason: collision with root package name */
        private static final Logger f42052i;

        /* renamed from: j  reason: collision with root package name */
        private static final Logger f42053j;

        /* renamed from: k  reason: collision with root package name */
        private static final Logger f42054k;

        /* renamed from: l  reason: collision with root package name */
        private static final Logger f42055l;

        /* renamed from: m  reason: collision with root package name */
        private static final Logger f42056m;

        /* renamed from: n  reason: collision with root package name */
        private static final Logger f42057n;

        /* renamed from: o  reason: collision with root package name */
        private static final Logger f42058o;

        /* renamed from: p  reason: collision with root package name */
        private static final Logger f42059p;

        /* renamed from: q  reason: collision with root package name */
        private static final Logger f42060q;

        /* renamed from: r  reason: collision with root package name */
        private static final Logger f42061r;

        /* renamed from: s  reason: collision with root package name */
        private static final Logger f42062s;

        /* renamed from: t  reason: collision with root package name */
        private static final Logger f42063t;

        /* renamed from: u  reason: collision with root package name */
        private static final Logger f42064u;

        /* renamed from: v  reason: collision with root package name */
        private static final Logger f42065v;

        static {
            b bVar = new b();
            f42045b = bVar;
            f42046c = "Services";
            f42047d = bVar.a("DynamicFeature");
            f42048e = bVar.a("Permission");
            f42049f = bVar.a("RideHistory");
            f42050g = bVar.a("InAppMessage");
            f42051h = bVar.a("Payments");
            f42052i = bVar.a("ExpenseCode");
            f42053j = bVar.a("DynamicModal");
            f42054k = bVar.a("StaticContent");
            f42055l = bVar.a("Profile");
            f42056m = bVar.a("Work Profile");
            f42057n = bVar.a("Auth");
            f42058o = bVar.a("Deeplinks");
            f42059p = bVar.a("Verification");
            f42060q = bVar.a("Campaigns");
            f42061r = bVar.a("Workers");
            f42062s = bVar.a("Other");
            f42063t = bVar.a("Subscriptions");
            f42064u = bVar.a("BugReporting");
            f42065v = bVar.a("Webview");
        }

        private b() {
            super(null);
        }

        @Override // eu.bolt.verification.sdk.internal.ac
        public String b() {
            return f42046c;
        }

        public final Logger c() {
            return f42048e;
        }

        public final Logger d() {
            return f42059p;
        }

        public final Logger e() {
            return f42065v;
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends Lambda implements Function0<zb> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final zb invoke() {
            return new zb(ac.this.b());
        }
    }

    private ac() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new c());
        this.f42019a = b8;
    }

    public /* synthetic */ ac(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final Logger a(String tag) {
        Intrinsics.f(tag, "tag");
        return new tq(b(), tag);
    }

    public abstract String b();
}
