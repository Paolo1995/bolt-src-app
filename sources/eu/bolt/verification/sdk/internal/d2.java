package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.c2;
import eu.bolt.verification.sdk.internal.em;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* loaded from: classes5.dex */
public final class d2 {

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final c2 f42576a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, em> f42577b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(c2 condition, Map<String, ? extends em> userInputs) {
            Intrinsics.f(condition, "condition");
            Intrinsics.f(userInputs, "userInputs");
            this.f42576a = condition;
            this.f42577b = userInputs;
        }

        public final c2 a() {
            return this.f42576a;
        }

        public final Map<String, em> b() {
            return this.f42577b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f42576a, aVar.f42576a) && Intrinsics.a(this.f42577b, aVar.f42577b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f42576a.hashCode() * 31) + this.f42577b.hashCode();
        }

        public String toString() {
            c2 c2Var = this.f42576a;
            Map<String, em> map = this.f42577b;
            return "Args(condition=" + c2Var + ", userInputs=" + map + ")";
        }
    }

    /* loaded from: classes5.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f42578a;

        static {
            int[] iArr = new int[c2.a.EnumC0039a.values().length];
            try {
                iArr[c2.a.EnumC0039a.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[c2.a.EnumC0039a.AT_LEAST_ONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f42578a = iArr;
        }
    }

    private final boolean a(c2.a aVar, Map<String, ? extends em> map) {
        em emVar = map.get(aVar.a());
        em.a aVar2 = emVar instanceof em.a ? (em.a) emVar : null;
        if (aVar2 != null) {
            int i8 = b.f42578a[aVar.b().ordinal()];
            if (i8 == 1) {
                return aVar2.b().containsAll(aVar.c());
            }
            if (i8 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            List<String> b8 = aVar2.b();
            if (!(b8 instanceof Collection) || !b8.isEmpty()) {
                for (String str : b8) {
                    if (aVar.c().contains(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final boolean c(String str, String str2, Map<String, ? extends em> map) {
        em emVar = map.get(str);
        em.f fVar = emVar instanceof em.f ? (em.f) emVar : null;
        if (fVar != null) {
            return new Regex(str2).f(fVar.a());
        }
        return false;
    }

    private final boolean d(String str, Map<String, ? extends em> map) {
        return map.containsKey(str);
    }

    public final boolean b(a args) {
        Intrinsics.f(args, "args");
        c2 a8 = args.a();
        if (a8 instanceof c2.c) {
            return d(((c2.c) args.a()).a(), args.b());
        }
        if (a8 instanceof c2.b) {
            return c(((c2.b) args.a()).a(), ((c2.b) args.a()).b(), args.b());
        }
        if (a8 instanceof c2.a) {
            return a((c2.a) args.a(), args.b());
        }
        throw new NoWhenBranchMatchedException();
    }
}
