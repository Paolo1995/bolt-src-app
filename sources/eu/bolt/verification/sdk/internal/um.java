package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.b1;
import eu.bolt.verification.sdk.internal.ro;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class um {

    /* renamed from: b  reason: collision with root package name */
    public static final a f45394b = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final qm f45395a;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public um(qm actionMapper) {
        Intrinsics.f(actionMapper, "actionMapper");
        this.f45395a = actionMapper;
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
        int v7;
        Intrinsics.f(from, "from");
        String a8 = from.a();
        String b8 = from.b().b();
        b1.b a9 = a(from.b().c());
        List<sm> a10 = from.b().a();
        v7 = CollectionsKt__IterablesKt.v(a10, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (sm smVar : a10) {
            arrayList.add(this.f45395a.a(smVar));
        }
        return new b1(a8, b8, a9, arrayList);
    }
}
