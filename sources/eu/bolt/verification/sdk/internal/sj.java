package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.bk;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* loaded from: classes5.dex */
public abstract class sj {

    /* renamed from: a  reason: collision with root package name */
    private final String f44981a;

    /* renamed from: b  reason: collision with root package name */
    private final int f44982b;

    /* renamed from: c  reason: collision with root package name */
    private final yj f44983c;

    /* renamed from: d  reason: collision with root package name */
    private final Long f44984d;

    /* loaded from: classes5.dex */
    public static final class a extends sj {

        /* renamed from: e  reason: collision with root package name */
        private final String f44985e;

        /* renamed from: f  reason: collision with root package name */
        private final bk f44986f;

        /* renamed from: eu.bolt.verification.sdk.internal.sj$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        static final class C0090a extends Lambda implements Function1<bk.b, Boolean> {

            /* renamed from: f  reason: collision with root package name */
            public static final C0090a f44987f = new C0090a();

            C0090a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(bk.b it) {
                Intrinsics.f(it, "it");
                return Boolean.valueOf(it instanceof bk.b.a);
            }
        }

        /* loaded from: classes5.dex */
        static final class b extends Lambda implements Function1<bk.b, tj> {

            /* renamed from: f  reason: collision with root package name */
            public static final b f44988f = new b();

            b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final tj invoke(bk.b it) {
                Intrinsics.f(it, "it");
                return ((bk.b.a) it).b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String id, int i8, yj yjVar, Long l8, String str, bk content) {
            super(id, i8, yjVar, l8, null);
            Intrinsics.f(id, "id");
            Intrinsics.f(content, "content");
            this.f44985e = str;
            this.f44986f = content;
        }

        @Override // eu.bolt.verification.sdk.internal.sj
        public List<tj> f() {
            Sequence O;
            ArrayList arrayList = new ArrayList();
            O = CollectionsKt___CollectionsKt.O(this.f44986f.b());
            for (tj tjVar : SequencesKt.v(SequencesKt.n(O, C0090a.f44987f), b.f44988f)) {
                arrayList.add(tjVar);
            }
            return arrayList;
        }

        public final bk g() {
            return this.f44986f;
        }

        public final String h() {
            return this.f44985e;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        tj a();
    }

    /* loaded from: classes5.dex */
    public static final class c extends sj implements b {

        /* renamed from: e  reason: collision with root package name */
        private final Integer f44989e;

        /* renamed from: f  reason: collision with root package name */
        private final String f44990f;

        /* renamed from: g  reason: collision with root package name */
        private final String f44991g;

        /* renamed from: h  reason: collision with root package name */
        private final String f44992h;

        /* renamed from: i  reason: collision with root package name */
        private final String f44993i;

        /* renamed from: j  reason: collision with root package name */
        private final tj f44994j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String id, int i8, Integer num, yj yjVar, Long l8, String str, String str2, String str3, String str4, tj tjVar) {
            super(id, i8, yjVar, l8, null);
            Intrinsics.f(id, "id");
            this.f44989e = num;
            this.f44990f = str;
            this.f44991g = str2;
            this.f44992h = str3;
            this.f44993i = str4;
            this.f44994j = tjVar;
        }

        @Override // eu.bolt.verification.sdk.internal.sj.b
        public tj a() {
            return this.f44994j;
        }

        @Override // eu.bolt.verification.sdk.internal.sj
        public List<tj> f() {
            List<tj> o8;
            o8 = CollectionsKt__CollectionsKt.o(a());
            return o8;
        }

        public final String g() {
            return this.f44992h;
        }

        public final String h() {
            return this.f44993i;
        }

        public final Integer i() {
            return this.f44989e;
        }

        public final String j() {
            return this.f44990f;
        }

        public final String k() {
            return this.f44991g;
        }
    }

    private sj(String str, int i8, yj yjVar, Long l8) {
        this.f44981a = str;
        this.f44982b = i8;
        this.f44983c = yjVar;
        this.f44984d = l8;
    }

    public /* synthetic */ sj(String str, int i8, yj yjVar, Long l8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i8, yjVar, l8);
    }

    public final Long b() {
        return this.f44984d;
    }

    public final int c() {
        return this.f44982b;
    }

    public final yj d() {
        return this.f44983c;
    }

    public final String e() {
        return this.f44981a;
    }

    public abstract List<tj> f();
}
