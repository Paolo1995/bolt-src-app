package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
public abstract class u implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final String f45238f;

    /* renamed from: g  reason: collision with root package name */
    private final List<Pair<String, Serializable>> f45239g;

    /* loaded from: classes5.dex */
    public static final class a extends u {
        public a() {
            super("Select Country Code", null, 2, null);
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends u {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public b(java.lang.String r3) {
            /*
                r2 = this;
                java.lang.String r0 = "storyId"
                kotlin.jvm.internal.Intrinsics.f(r3, r0)
                java.lang.String r0 = "Story id"
                kotlin.Pair r3 = kotlin.TuplesKt.a(r0, r3)
                java.util.List r3 = kotlin.collections.CollectionsKt.e(r3)
                java.lang.String r0 = "Story"
                r1 = 0
                r2.<init>(r0, r3, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.u.b.<init>(java.lang.String):void");
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends u {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public c(java.lang.String r3, java.lang.String r4) {
            /*
                r2 = this;
                java.lang.String r0 = "flowId"
                kotlin.jvm.internal.Intrinsics.f(r3, r0)
                java.lang.String r0 = "stepId"
                kotlin.jvm.internal.Intrinsics.f(r4, r0)
                r0 = 2
                kotlin.Pair[] r0 = new kotlin.Pair[r0]
                java.lang.String r1 = "step_id"
                kotlin.Pair r4 = kotlin.TuplesKt.a(r1, r4)
                r1 = 0
                r0[r1] = r4
                java.lang.String r4 = "flow_uuid"
                kotlin.Pair r3 = kotlin.TuplesKt.a(r4, r3)
                r4 = 1
                r0[r4] = r3
                java.util.List r3 = kotlin.collections.CollectionsKt.n(r0)
                java.lang.String r4 = "Verification Camera Access"
                r0 = 0
                r2.<init>(r4, r3, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.u.c.<init>(java.lang.String, java.lang.String):void");
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends u {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public d(java.lang.String r2, java.util.Map<java.lang.String, java.lang.String> r3) {
            /*
                r1 = this;
                java.lang.String r0 = "screenName"
                kotlin.jvm.internal.Intrinsics.f(r2, r0)
                java.lang.String r0 = "parameters"
                kotlin.jvm.internal.Intrinsics.f(r3, r0)
                java.util.List r3 = kotlin.collections.MapsKt.v(r3)
                r0 = 0
                r1.<init>(r2, r3, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.u.d.<init>(java.lang.String, java.util.Map):void");
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends u {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public e(java.lang.String r3) {
            /*
                r2 = this;
                java.lang.String r0 = "url"
                kotlin.Pair r3 = kotlin.TuplesKt.a(r0, r3)
                java.util.List r3 = kotlin.collections.CollectionsKt.e(r3)
                java.lang.String r0 = "Web View"
                r1 = 0
                r2.<init>(r0, r3, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.u.e.<init>(java.lang.String):void");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private u(String str, List<? extends Pair<String, ? extends Serializable>> list) {
        this.f45238f = str;
        this.f45239g = list;
    }

    public /* synthetic */ u(String str, List list, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i8 & 2) != 0 ? CollectionsKt__CollectionsKt.k() : list, null);
    }

    public /* synthetic */ u(String str, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list);
    }

    public final List<Pair<String, Serializable>> a() {
        return this.f45239g;
    }

    public final String b() {
        return this.f45238f;
    }
}
