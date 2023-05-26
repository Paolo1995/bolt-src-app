package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import eu.bolt.client.design.button.DesignButton;
import eu.bolt.verification.sdk.internal.aa;
import eu.bolt.verification.sdk.internal.b1;
import eu.bolt.verification.sdk.internal.d1;
import eu.bolt.verification.sdk.internal.em;
import eu.bolt.verification.sdk.internal.jl;
import eu.bolt.verification.sdk.internal.ll;
import eu.bolt.verification.sdk.internal.o9;
import eu.bolt.verification.sdk.internal.r1;
import eu.bolt.verification.sdk.internal.w7;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class x7 {

    /* renamed from: d  reason: collision with root package name */
    public static final b f45627d = new b(null);

    /* renamed from: a  reason: collision with root package name */
    private final mn f45628a;

    /* renamed from: b  reason: collision with root package name */
    private final d1 f45629b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f45630c;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<ob> f45631a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, em> f45632b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends ob> layouts, Map<String, ? extends em> userInputs) {
            Intrinsics.f(layouts, "layouts");
            Intrinsics.f(userInputs, "userInputs");
            this.f45631a = layouts;
            this.f45632b = userInputs;
        }

        public final List<ob> a() {
            return this.f45631a;
        }

        public final Map<String, em> b() {
            return this.f45632b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f45631a, aVar.f45631a) && Intrinsics.a(this.f45632b, aVar.f45632b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f45631a.hashCode() * 31) + this.f45632b.hashCode();
        }

        public String toString() {
            List<ob> list = this.f45631a;
            Map<String, em> map = this.f45632b;
            return "Args(layouts=" + list + ", userInputs=" + map + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f45633a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f45634b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f45635c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ int[] f45636d;

        static {
            int[] iArr = new int[fl.values().length];
            try {
                iArr[fl.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[fl.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f45633a = iArr;
            int[] iArr2 = new int[o9.a.values().length];
            try {
                iArr2[o9.a.FILL_WIDTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[o9.a.FILL_HEIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[o9.a.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            f45634b = iArr2;
            int[] iArr3 = new int[jl.a.values().length];
            try {
                iArr3[jl.a.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[jl.a.NUMBERS.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            f45635c = iArr3;
            int[] iArr4 = new int[b1.b.values().length];
            try {
                iArr4[b1.b.PRIMARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr4[b1.b.SECONDARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr4[b1.b.DANGER.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr4[b1.b.TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            f45636d = iArr4;
        }
    }

    @Inject
    public x7(mn fileProvider, d1 buttonEnabledChecker, Context context) {
        Intrinsics.f(fileProvider, "fileProvider");
        Intrinsics.f(buttonEnabledChecker, "buttonEnabledChecker");
        Intrinsics.f(context, "context");
        this.f45628a = fileProvider;
        this.f45629b = buttonEnabledChecker;
        this.f45630c = context;
    }

    private final DesignButton.b a(b1.b bVar) {
        int i8 = c.f45636d[bVar.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4) {
                        return DesignButton.b.Text;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return DesignButton.b.Danger;
            }
            return DesignButton.b.Secondary;
        }
        return DesignButton.b.Primary;
    }

    private final aa b(String str, Map<String, ? extends em> map) {
        em emVar = map.get(str);
        if (emVar instanceof em.b) {
            h2 a8 = h2.f43225j.a(((em.b) emVar).a());
            Integer valueOf = a8 != null ? Integer.valueOf(a8.f()) : null;
            if (valueOf != null) {
                return new aa.e(valueOf.intValue(), new aa.f(24.0f, 24.0f), null, 4, null);
            }
        }
        return null;
    }

    private final w7.c c(k2 k2Var, Map<String, ? extends em> map) {
        return new w7.c(k2Var.a(), b(k2Var.a(), map), l(k2Var.a(), map), k2Var);
    }

    private final w7.d d(r3 r3Var, Map<String, ? extends em> map) {
        String a8 = r3Var.a();
        Long b8 = r3Var.b();
        em emVar = map.get(r3Var.a());
        em.c cVar = emVar instanceof em.c ? (em.c) emVar : null;
        return new w7.d(a8, b8, cVar != null ? Long.valueOf(cVar.a()) : null);
    }

    private final w7.e e(b1 b1Var, Map<String, ? extends em> map) {
        return new w7.e(b1Var.a(), ll.f44093f.c(b1Var.c()), this.f45629b.a(new d1.a(b1Var, map)), a(b1Var.d()), b1Var);
    }

    private final w7.h f(be beVar) {
        String a8 = beVar.a();
        ll.b bVar = new ll.b(beVar.g());
        String e8 = beVar.e();
        aa.g gVar = e8 != null ? new aa.g(e8, null, new aa.f(20.0f, 20.0f), null, null, null, null, 122, null) : null;
        w7.i iVar = c.f45633a[beVar.f().ordinal()] != 1 ? w7.i.CENTER : w7.i.START;
        List<cm> h8 = beVar.h();
        Integer d8 = beVar.d();
        return new w7.h(a8, bVar, gVar, iVar, h8, d8 != null ? d8.intValue() : 16);
    }

    private final w7.j g(jl jlVar, Map<String, ? extends em> map) {
        w7.j.a aVar;
        String a8 = jlVar.a();
        String b8 = jlVar.b();
        int i8 = c.f45635c[jlVar.c().ordinal()];
        if (i8 == 1) {
            aVar = w7.j.a.TEXT;
        } else if (i8 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            aVar = w7.j.a.NUMBERS;
        }
        em emVar = map.get(jlVar.a());
        em.f fVar = emVar instanceof em.f ? (em.f) emVar : null;
        return new w7.j(a8, b8, aVar, fVar != null ? fVar.a() : null);
    }

    private final w7 h(o9 o9Var) {
        ImageView.ScaleType scaleType;
        float f8;
        float f9;
        int i8 = c.f45634b[o9Var.b().ordinal()];
        if (i8 == 1) {
            scaleType = ImageView.ScaleType.CENTER_CROP;
        } else if (i8 == 2) {
            scaleType = ImageView.ScaleType.CENTER_INSIDE;
        } else if (i8 != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        o9.b c8 = o9Var.c();
        if (c8 instanceof o9.b.C0081b) {
            return new w7.f(o9Var.a(), new aa.g(((o9.b.C0081b) o9Var.c()).a(), null, null, null, null, null, null, 126, null), scaleType);
        }
        if (c8 instanceof o9.b.a) {
            String a8 = o9Var.a();
            DisplayMetrics displayMetrics = this.f45630c.getResources().getDisplayMetrics();
            gh a9 = ((o9.b.a) o9Var.c()).b().a();
            float b8 = a9.b() / a9.a();
            if (b8 >= 1.0f) {
                f8 = (displayMetrics.widthPixels / displayMetrics.density) - (2 * 24.0f);
                f9 = f8 / b8;
            } else {
                f8 = (float) ((displayMetrics.widthPixels / displayMetrics.density) * 0.75d);
                f9 = f8 * b8;
            }
            String uri = Uri.fromFile(this.f45628a.b(((o9.b.a) o9Var.c()).a())).toString();
            Intrinsics.e(uri, "fromFile(fileProvider.cr…urce.fieldId)).toString()");
            return new w7.g(a8, new aa.g(uri, null, new aa.f(f9, f8), null, null, null, null, 122, null), scaleType, ((o9.b.a) o9Var.c()).b());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final List<w7> i(ob obVar, Map<String, ? extends em> map) {
        List<w7> k8;
        w7 e8;
        List<w7> e9;
        if (obVar instanceof be) {
            e8 = f((be) obVar);
        } else if (obVar instanceof o9) {
            e8 = h((o9) obVar);
        } else if (obVar instanceof jl) {
            e8 = g((jl) obVar, map);
        } else if (obVar instanceof r3) {
            e8 = d((r3) obVar, map);
        } else if (obVar instanceof r1) {
            return j((r1) obVar, map);
        } else {
            if (obVar instanceof k2) {
                e8 = c((k2) obVar, map);
            } else if (!(obVar instanceof b1)) {
                t3.f(new IllegalArgumentException("Unsupported layout element: " + obVar), null, null, 6, null);
                Unit unit = Unit.f50853a;
                k8 = CollectionsKt__CollectionsKt.k();
                return k8;
            } else {
                e8 = e((b1) obVar, map);
            }
        }
        e9 = CollectionsKt__CollectionsJVMKt.e(e8);
        return e9;
    }

    private final List<w7.a> j(r1 r1Var, Map<String, ? extends em> map) {
        int v7;
        List<String> b8;
        List<r1.a> d8 = r1Var.d();
        v7 = CollectionsKt__IterablesKt.v(d8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (r1.a aVar : d8) {
            String a8 = r1Var.a();
            ll.b bVar = new ll.b(aVar.d());
            String c8 = aVar.c();
            ll.b bVar2 = c8 != null ? new ll.b(c8) : null;
            String a9 = aVar.a();
            aa.g gVar = a9 != null ? new aa.g(a9, null, new aa.f(20.0f, 20.0f), null, null, null, null, 122, null) : null;
            ud udVar = new ud(r1Var.a(), aVar.b(), r1Var.c());
            em emVar = map.get(r1Var.a());
            em.a aVar2 = emVar instanceof em.a ? (em.a) emVar : null;
            arrayList.add(new w7.a(a8, bVar, bVar2, gVar, (aVar2 == null || (b8 = aVar2.b()) == null) ? false : b8.contains(aVar.b()), udVar));
        }
        return arrayList;
    }

    private final ll l(String str, Map<String, ? extends em> map) {
        h2 a8;
        String e8;
        ll.d e9;
        em emVar = map.get(str);
        return (!(emVar instanceof em.b) || (a8 = h2.f43225j.a(((em.b) emVar).a())) == null || (e8 = a8.e()) == null || (e9 = il.e(e8)) == null) ? ll.f44093f.c("") : e9;
    }

    public final List<w7> k(a from) {
        Intrinsics.f(from, "from");
        List<ob> a8 = from.a();
        ArrayList arrayList = new ArrayList();
        for (ob obVar : a8) {
            CollectionsKt__MutableCollectionsKt.A(arrayList, i(obVar, from.b()));
        }
        return arrayList;
    }
}
