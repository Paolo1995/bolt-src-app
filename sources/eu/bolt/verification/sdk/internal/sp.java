package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.an;
import eu.bolt.verification.sdk.internal.l6;
import eu.bolt.verification.sdk.internal.ll;
import eu.bolt.verification.sdk.internal.m6;
import eu.bolt.verification.sdk.internal.nh;
import eu.bolt.verification.sdk.internal.p9;
import eu.bolt.verification.sdk.internal.yp;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class sp {

    /* renamed from: a  reason: collision with root package name */
    public static final a f45055a = new a(null);

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final l1 a(an.a aVar) {
        hh hhVar;
        gh ghVar;
        Float a8 = aVar.a();
        boolean z7 = aVar instanceof an.a.b;
        if (z7) {
            hhVar = hh.RECTANGLE;
        } else if (!(aVar instanceof an.a.C0030a)) {
            throw new NoWhenBranchMatchedException();
        } else {
            hhVar = hh.OVAL;
        }
        if (z7) {
            an.a.b bVar = (an.a.b) aVar;
            ghVar = new gh(bVar.d().b(), bVar.d().a());
        } else if (!(aVar instanceof an.a.C0030a)) {
            throw new NoWhenBranchMatchedException();
        } else {
            an.a.C0030a c0030a = (an.a.C0030a) aVar;
            ghVar = new gh(c0030a.d().b(), c0030a.d().a());
        }
        return new l1(a8, hhVar, ghVar);
    }

    private final x6 c(an.b bVar) {
        ll.a aVar = ll.f44093f;
        return new x6(null, null, false, aVar.c(bVar.d()), u4.f45317s, aVar.c(bVar.b()), null, null, new j6(aVar.c(bVar.c()), l6.b.f44014f, m6.a.f44156g), new j6(aVar.c(bVar.a()), l6.a.f44013f, m6.b.f44157g), null, null, new z6("camera_permission", null, 2, null), null, 11459, null);
    }

    private final n1 d(yp.a aVar) {
        String b8 = aVar.g().b();
        return (!Intrinsics.a(b8, "dark") && Intrinsics.a(b8, "light")) ? n1.LIGHT : n1.DARK;
    }

    private final p9 e(an.a aVar) {
        String c8;
        String b8 = aVar.b();
        if (Intrinsics.a(b8, "image")) {
            String c9 = aVar.c();
            if (c9 != null) {
                return new p9.a(c9, null, null, null, false, 30, null);
            }
            return null;
        } else if (!Intrinsics.a(b8, "lottie") || (c8 = aVar.c()) == null) {
            return null;
        } else {
            return new p9.b(c8, null, false, false, 14, null);
        }
    }

    private final q1 f(yp.a aVar) {
        String a8 = aVar.g().a();
        if (Intrinsics.a(a8, "back")) {
            return q1.BACK;
        }
        Intrinsics.a(a8, "front");
        return q1.FRONT;
    }

    public final nh.a b(yp.a from) {
        Intrinsics.f(from, "from");
        return new nh.a(from.g().c(), from.g().f(), c(from.g().e()), a(from.g().d()), e(from.g().d()), f(from), d(from));
    }
}
