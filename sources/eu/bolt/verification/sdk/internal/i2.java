package eu.bolt.verification.sdk.internal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes5.dex */
public final class i2 {

    /* renamed from: b  reason: collision with root package name */
    private static final a f43443b = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final boolean f43444a;

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b extends Lambda implements Function1<j2, Boolean> {

        /* renamed from: f  reason: collision with root package name */
        public static final b f43445f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final Boolean invoke(j2 it) {
            Intrinsics.f(it, "it");
            return Boolean.valueOf(it.b().e().length() > 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends Lambda implements Function1<j2, List<? extends sb>> {

        /* renamed from: f  reason: collision with root package name */
        public static final c f43446f = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final List<sb> invoke(j2 country) {
            List<sb> n8;
            Intrinsics.f(country, "country");
            n8 = CollectionsKt__CollectionsKt.n(country, x5.f45610b);
            return n8;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t7, T t8) {
            int a8;
            a8 = ComparisonsKt__ComparisonsKt.a(((j2) t7).b().e(), ((j2) t8).b().e());
            return a8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class e extends Lambda implements Function1<j2, List<? extends sb>> {

        /* renamed from: f  reason: collision with root package name */
        public static final e f43447f = new e();

        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final List<sb> invoke(j2 country) {
            List<sb> n8;
            Intrinsics.f(country, "country");
            n8 = CollectionsKt__CollectionsKt.n(country, x5.f45610b);
            return n8;
        }
    }

    public i2(boolean z7) {
        this.f43444a = z7;
    }

    private final j2 a(h2 h2Var) {
        String e8 = h2Var.e();
        String c8 = h2Var.c();
        return new j2(h2Var, e8, "+" + c8, h2Var.f());
    }

    private final List<sb> b(List<j2> list) {
        Sequence O;
        Sequence n8;
        SortedMap e8;
        Sequence O2;
        Sequence A;
        Sequence q8;
        List e9;
        List p02;
        List S;
        O = CollectionsKt___CollectionsKt.O(list);
        n8 = SequencesKt___SequencesKt.n(O, b.f43445f);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : n8) {
            Character valueOf = Character.valueOf(((j2) obj).b().e().charAt(0));
            Object obj2 = linkedHashMap.get(valueOf);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(valueOf, obj2);
            }
            ((List) obj2).add(obj);
        }
        e8 = MapsKt__MapsJVMKt.e(linkedHashMap);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : e8.entrySet()) {
            fa faVar = new fa(String.valueOf(entry.getKey()));
            Object value = entry.getValue();
            Intrinsics.e(value, "section.value");
            O2 = CollectionsKt___CollectionsKt.O((Iterable) value);
            A = SequencesKt___SequencesKt.A(O2, new d());
            q8 = SequencesKt___SequencesKt.q(A, c.f43446f);
            e9 = CollectionsKt__CollectionsJVMKt.e(faVar);
            p02 = CollectionsKt___CollectionsKt.p0(e9, q8);
            S = CollectionsKt___CollectionsKt.S(p02, 1);
            CollectionsKt__MutableCollectionsKt.A(arrayList, S);
        }
        return arrayList;
    }

    private final List<sb> c(List<j2> list) {
        Sequence O;
        Sequence q8;
        List D;
        List<sb> S;
        O = CollectionsKt___CollectionsKt.O(list);
        q8 = SequencesKt___SequencesKt.q(O, e.f43447f);
        D = SequencesKt___SequencesKt.D(q8);
        S = CollectionsKt___CollectionsKt.S(D, 1);
        return S;
    }

    private final List<j2> d(List<? extends h2> list) {
        String[] h8;
        ArrayList arrayList = new ArrayList();
        for (h2 h2Var : list) {
            for (String str : h2Var.h()) {
                arrayList.add(new j2(h2Var, h2Var.e(), "+" + str, h2Var.f()));
            }
        }
        return arrayList;
    }

    public final List<sb> e(List<? extends h2> from) {
        List<j2> arrayList;
        int v7;
        Intrinsics.f(from, "from");
        if (this.f43444a) {
            arrayList = d(from);
        } else {
            v7 = CollectionsKt__IterablesKt.v(from, 10);
            arrayList = new ArrayList<>(v7);
            for (h2 h2Var : from) {
                arrayList.add(a(h2Var));
            }
        }
        return from.size() >= 10 ? b(arrayList) : c(arrayList);
    }
}
