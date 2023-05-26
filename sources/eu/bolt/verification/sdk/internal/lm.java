package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.b1;
import eu.bolt.verification.sdk.internal.d;
import eu.bolt.verification.sdk.internal.ro;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class lm {

    /* renamed from: a  reason: collision with root package name */
    public static final a f44098a = new a(null);

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final b1.b a(String str) {
        int hashCode = str.hashCode();
        if (hashCode != -1339091421) {
            if (hashCode != -817598092) {
                if (hashCode == -314765822) {
                    str.equals("primary");
                } else if (hashCode == 3556653 && str.equals("text")) {
                    return b1.b.TEXT;
                }
            } else if (str.equals("secondary")) {
                return b1.b.SECONDARY;
            }
        } else if (str.equals("danger")) {
            return b1.b.DANGER;
        }
        return b1.b.PRIMARY;
    }

    public final b1 b(ro.a from) {
        List e8;
        Intrinsics.f(from, "from");
        String a8 = from.a();
        String b8 = from.b().b();
        b1.b a9 = a(from.b().c());
        e8 = CollectionsKt__CollectionsJVMKt.e(new b1.a(d.a.f42547f, null));
        return new b1(a8, b8, a9, e8);
    }
}
