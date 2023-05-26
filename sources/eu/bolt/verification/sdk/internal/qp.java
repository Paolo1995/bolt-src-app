package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.k7;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class qp {

    /* renamed from: a  reason: collision with root package name */
    private static final a f44690a = new a(null);

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final k7.a a(String from) {
        Intrinsics.f(from, "from");
        return Intrinsics.a(from, "close_form") ? k7.a.CLOSE_FORM : Intrinsics.a(from, "go_back") ? k7.a.GO_BACK : k7.a.NONE;
    }
}
