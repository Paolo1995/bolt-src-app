package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
public abstract class q implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final String f44577f;

    /* renamed from: g  reason: collision with root package name */
    private final List<Pair<String, Serializable>> f44578g;

    /* loaded from: classes5.dex */
    public static final class a extends q {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(java.lang.String r4, java.lang.String r5, boolean r6) {
            /*
                r3 = this;
                java.lang.String r0 = "tag"
                kotlin.jvm.internal.Intrinsics.f(r4, r0)
                java.lang.String r1 = "message"
                kotlin.jvm.internal.Intrinsics.f(r5, r1)
                r2 = 3
                kotlin.Pair[] r2 = new kotlin.Pair[r2]
                kotlin.Pair r4 = kotlin.TuplesKt.a(r0, r4)
                r0 = 0
                r2[r0] = r4
                kotlin.Pair r4 = kotlin.TuplesKt.a(r1, r5)
                r5 = 1
                r2[r5] = r4
                java.lang.Boolean r4 = java.lang.Boolean.valueOf(r6)
                java.lang.String r5 = "unknown_issue"
                kotlin.Pair r4 = kotlin.TuplesKt.a(r5, r4)
                r5 = 2
                r2[r5] = r4
                java.util.List r4 = kotlin.collections.CollectionsKt.n(r2)
                java.lang.String r5 = "Client Custom Error Dialog"
                r6 = 0
                r3.<init>(r5, r4, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.q.a.<init>(java.lang.String, java.lang.String, boolean):void");
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends q {

        /* loaded from: classes5.dex */
        public enum a {
            CLOSE_BUTTON("close icon tap"),
            SWIPE_DOWN("swipe down"),
            LAST_SLIDE_TAP("last slide tap"),
            ERROR("error"),
            AUTO("auto"),
            DEEPLINK("deeplink"),
            BACK_BUTTON("back button");
            

            /* renamed from: f  reason: collision with root package name */
            private final String f44587f;

            a(String str) {
                this.f44587f = str;
            }

            public final String c() {
                return this.f44587f;
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public b(java.lang.String r3, boolean r4, eu.bolt.verification.sdk.internal.q.b.a r5, java.lang.String r6) {
            /*
                r2 = this;
                java.lang.String r0 = "storyId"
                kotlin.jvm.internal.Intrinsics.f(r3, r0)
                java.lang.String r0 = "howClosed"
                kotlin.jvm.internal.Intrinsics.f(r5, r0)
                r0 = 4
                kotlin.Pair[] r0 = new kotlin.Pair[r0]
                java.lang.String r1 = "Story id"
                kotlin.Pair r3 = kotlin.TuplesKt.a(r1, r3)
                r1 = 0
                r0[r1] = r3
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r4)
                java.lang.String r4 = "Last slide seen"
                kotlin.Pair r3 = kotlin.TuplesKt.a(r4, r3)
                r4 = 1
                r0[r4] = r3
                java.lang.String r3 = "Last slide seen id"
                kotlin.Pair r3 = kotlin.TuplesKt.a(r3, r6)
                r4 = 2
                r0[r4] = r3
                java.lang.String r3 = r5.c()
                java.lang.String r4 = "How closed"
                kotlin.Pair r3 = kotlin.TuplesKt.a(r4, r3)
                r4 = 3
                r0[r4] = r3
                java.util.List r3 = kotlin.collections.CollectionsKt.n(r0)
                java.lang.String r4 = "Story Close"
                r5 = 0
                r2.<init>(r4, r3, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.q.b.<init>(java.lang.String, boolean, eu.bolt.verification.sdk.internal.q$b$a, java.lang.String):void");
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends q {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public c(java.lang.Integer r3, java.lang.String r4, java.lang.String r5) {
            /*
                r2 = this;
                java.lang.String r0 = "message"
                kotlin.jvm.internal.Intrinsics.f(r4, r0)
                java.lang.String r0 = "displayedMessage"
                kotlin.jvm.internal.Intrinsics.f(r5, r0)
                r0 = 3
                kotlin.Pair[] r0 = new kotlin.Pair[r0]
                java.lang.String r1 = "Error code"
                kotlin.Pair r3 = kotlin.TuplesKt.a(r1, r3)
                r1 = 0
                r0[r1] = r3
                java.lang.String r3 = "Error message"
                kotlin.Pair r3 = kotlin.TuplesKt.a(r3, r4)
                r4 = 1
                r0[r4] = r3
                java.lang.String r3 = "Display message"
                kotlin.Pair r3 = kotlin.TuplesKt.a(r3, r5)
                r4 = 2
                r0[r4] = r3
                java.util.List r3 = kotlin.collections.CollectionsKt.n(r0)
                java.lang.String r4 = "Error dialog"
                r5 = 0
                r2.<init>(r4, r3, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.q.c.<init>(java.lang.Integer, java.lang.String, java.lang.String):void");
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends q {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public d(java.lang.String r3, java.lang.String r4) {
            /*
                r2 = this;
                java.lang.String r0 = "storyId"
                kotlin.jvm.internal.Intrinsics.f(r3, r0)
                java.lang.String r0 = "slideId"
                kotlin.jvm.internal.Intrinsics.f(r4, r0)
                r0 = 2
                kotlin.Pair[] r0 = new kotlin.Pair[r0]
                java.lang.String r1 = "Story id"
                kotlin.Pair r3 = kotlin.TuplesKt.a(r1, r3)
                r1 = 0
                r0[r1] = r3
                java.lang.String r3 = "Slide id"
                kotlin.Pair r3 = kotlin.TuplesKt.a(r3, r4)
                r4 = 1
                r0[r4] = r3
                java.util.List r3 = kotlin.collections.CollectionsKt.n(r0)
                java.lang.String r4 = "Story Link"
                r0 = 0
                r2.<init>(r4, r3, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.q.d.<init>(java.lang.String, java.lang.String):void");
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends q {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public e(java.lang.String r3, java.lang.String r4) {
            /*
                r2 = this;
                java.lang.String r0 = "storyId"
                kotlin.jvm.internal.Intrinsics.f(r3, r0)
                java.lang.String r0 = "slideId"
                kotlin.jvm.internal.Intrinsics.f(r4, r0)
                r0 = 2
                kotlin.Pair[] r0 = new kotlin.Pair[r0]
                java.lang.String r1 = "Story id"
                kotlin.Pair r3 = kotlin.TuplesKt.a(r1, r3)
                r1 = 0
                r0[r1] = r3
                java.lang.String r3 = "Slide id"
                kotlin.Pair r3 = kotlin.TuplesKt.a(r3, r4)
                r4 = 1
                r0[r4] = r3
                java.util.List r3 = kotlin.collections.CollectionsKt.n(r0)
                java.lang.String r4 = "Story Screenshot"
                r0 = 0
                r2.<init>(r4, r3, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.q.e.<init>(java.lang.String, java.lang.String):void");
        }
    }

    /* loaded from: classes5.dex */
    public static final class f extends q {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public f(java.lang.String r3, java.lang.String r4) {
            /*
                r2 = this;
                java.lang.String r0 = "storyId"
                kotlin.jvm.internal.Intrinsics.f(r3, r0)
                java.lang.String r0 = "slideId"
                kotlin.jvm.internal.Intrinsics.f(r4, r0)
                r0 = 2
                kotlin.Pair[] r0 = new kotlin.Pair[r0]
                java.lang.String r1 = "Story id"
                kotlin.Pair r3 = kotlin.TuplesKt.a(r1, r3)
                r1 = 0
                r0[r1] = r3
                java.lang.String r3 = "Slide id"
                kotlin.Pair r3 = kotlin.TuplesKt.a(r3, r4)
                r4 = 1
                r0[r4] = r3
                java.util.List r3 = kotlin.collections.CollectionsKt.n(r0)
                java.lang.String r4 = "Story Share"
                r0 = 0
                r2.<init>(r4, r3, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.q.f.<init>(java.lang.String, java.lang.String):void");
        }
    }

    /* loaded from: classes5.dex */
    public static final class g extends q {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public g(java.lang.String r3, java.lang.String r4) {
            /*
                r2 = this;
                java.lang.String r0 = "flowId"
                kotlin.jvm.internal.Intrinsics.f(r3, r0)
                java.lang.String r0 = "stepId"
                kotlin.jvm.internal.Intrinsics.f(r4, r0)
                r0 = 2
                kotlin.Pair[] r0 = new kotlin.Pair[r0]
                java.lang.String r1 = "flow_id"
                kotlin.Pair r3 = kotlin.TuplesKt.a(r1, r3)
                r1 = 0
                r0[r1] = r3
                java.lang.String r3 = "step_id"
                kotlin.Pair r3 = kotlin.TuplesKt.a(r3, r4)
                r4 = 1
                r0[r4] = r3
                java.util.List r3 = kotlin.collections.CollectionsKt.n(r0)
                java.lang.String r4 = "Verification Camera Access Allow Tap"
                r0 = 0
                r2.<init>(r4, r3, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.q.g.<init>(java.lang.String, java.lang.String):void");
        }
    }

    /* loaded from: classes5.dex */
    public static final class h extends q {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public h(java.lang.String r3, java.lang.String r4) {
            /*
                r2 = this;
                java.lang.String r0 = "flowId"
                kotlin.jvm.internal.Intrinsics.f(r3, r0)
                java.lang.String r0 = "stepId"
                kotlin.jvm.internal.Intrinsics.f(r4, r0)
                r0 = 2
                kotlin.Pair[] r0 = new kotlin.Pair[r0]
                java.lang.String r1 = "flow_id"
                kotlin.Pair r3 = kotlin.TuplesKt.a(r1, r3)
                r1 = 0
                r0[r1] = r3
                java.lang.String r3 = "step_id"
                kotlin.Pair r3 = kotlin.TuplesKt.a(r3, r4)
                r4 = 1
                r0[r4] = r3
                java.util.List r3 = kotlin.collections.CollectionsKt.n(r0)
                java.lang.String r4 = "Verification Camera Access Close Tap"
                r0 = 0
                r2.<init>(r4, r3, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.q.h.<init>(java.lang.String, java.lang.String):void");
        }
    }

    /* loaded from: classes5.dex */
    public static final class i extends q {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public i(java.lang.String r2, java.util.Map<java.lang.String, java.lang.String> r3) {
            /*
                r1 = this;
                java.lang.String r0 = "eventName"
                kotlin.jvm.internal.Intrinsics.f(r2, r0)
                java.lang.String r0 = "parameters"
                kotlin.jvm.internal.Intrinsics.f(r3, r0)
                java.util.List r3 = kotlin.collections.MapsKt.v(r3)
                r0 = 0
                r1.<init>(r2, r3, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.q.i.<init>(java.lang.String, java.util.Map):void");
        }
    }

    /* loaded from: classes5.dex */
    public static final class j extends q {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public j(java.lang.String r4, java.lang.String r5, java.lang.String r6) {
            /*
                r3 = this;
                java.lang.String r0 = "pageUrl"
                kotlin.jvm.internal.Intrinsics.f(r4, r0)
                java.lang.String r0 = "sourceId"
                kotlin.jvm.internal.Intrinsics.f(r5, r0)
                java.lang.String r1 = "reason"
                kotlin.jvm.internal.Intrinsics.f(r6, r1)
                r1 = 3
                kotlin.Pair[] r1 = new kotlin.Pair[r1]
                java.lang.String r2 = "url"
                kotlin.Pair r4 = kotlin.TuplesKt.a(r2, r4)
                r2 = 0
                r1[r2] = r4
                kotlin.Pair r4 = kotlin.TuplesKt.a(r0, r5)
                r5 = 1
                r1[r5] = r4
                java.lang.String r4 = "errorMessage"
                kotlin.Pair r4 = kotlin.TuplesKt.a(r4, r6)
                r5 = 2
                r1[r5] = r4
                java.util.List r4 = kotlin.collections.CollectionsKt.n(r1)
                java.lang.String r5 = "Web Page JS Error"
                r6 = 0
                r3.<init>(r5, r4, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.q.j.<init>(java.lang.String, java.lang.String, java.lang.String):void");
        }
    }

    /* loaded from: classes5.dex */
    public static final class k extends q {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public k(java.lang.String r3) {
            /*
                r2 = this;
                java.lang.String r0 = "pageUrl"
                kotlin.jvm.internal.Intrinsics.f(r3, r0)
                java.lang.String r0 = "url"
                kotlin.Pair r3 = kotlin.TuplesKt.a(r0, r3)
                java.util.List r3 = kotlin.collections.CollectionsKt.e(r3)
                java.lang.String r0 = "Web Page Loaded"
                r1 = 0
                r2.<init>(r0, r3, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.q.k.<init>(java.lang.String):void");
        }
    }

    /* loaded from: classes5.dex */
    public static final class l extends q {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public l(java.lang.String r4, java.lang.String r5) {
            /*
                r3 = this;
                java.lang.String r0 = "pageUrl"
                kotlin.jvm.internal.Intrinsics.f(r4, r0)
                java.lang.String r0 = "reason"
                kotlin.jvm.internal.Intrinsics.f(r5, r0)
                r1 = 2
                kotlin.Pair[] r1 = new kotlin.Pair[r1]
                java.lang.String r2 = "url"
                kotlin.Pair r4 = kotlin.TuplesKt.a(r2, r4)
                r2 = 0
                r1[r2] = r4
                kotlin.Pair r4 = kotlin.TuplesKt.a(r0, r5)
                r5 = 1
                r1[r5] = r4
                java.util.List r4 = kotlin.collections.CollectionsKt.n(r1)
                java.lang.String r5 = "Web Page Loading Failed"
                r0 = 0
                r3.<init>(r5, r4, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.q.l.<init>(java.lang.String, java.lang.String):void");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private q(String str, List<? extends Pair<String, ? extends Serializable>> list) {
        this.f44577f = str;
        this.f44578g = list;
    }

    public /* synthetic */ q(String str, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list);
    }

    public List<Pair<String, Serializable>> a() {
        return this.f44578g;
    }

    public String b() {
        return this.f44577f;
    }
}
