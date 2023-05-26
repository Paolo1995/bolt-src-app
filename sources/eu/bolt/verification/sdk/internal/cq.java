package eu.bolt.verification.sdk.internal;

import android.content.Context;
import eu.bolt.verification.R$string;
import eu.bolt.verification.sdk.internal.kp;
import eu.bolt.verification.sdk.internal.sm;
import eu.bolt.verification.sdk.internal.td;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class cq {

    /* renamed from: a  reason: collision with root package name */
    private final Context f42540a;

    /* renamed from: b  reason: collision with root package name */
    private final rd f42541b;

    @Inject
    public cq(Context context, rd openWebViewMapper) {
        Intrinsics.f(context, "context");
        Intrinsics.f(openWebViewMapper, "openWebViewMapper");
        this.f42540a = context;
        this.f42541b = openWebViewMapper;
    }

    public final kp a(sm.j.c from) {
        ArrayList arrayList;
        int v7;
        Intrinsics.f(from, "from");
        rd rdVar = this.f42541b;
        String f8 = from.f();
        String e8 = from.e();
        if (e8 == null) {
            e8 = this.f42540a.getString(R$string.support_get_help_title);
            Intrinsics.e(e8, "context.getString(R.string.support_get_help_title)");
        }
        td.a a8 = rdVar.a(f8, e8, from.b(), Boolean.valueOf(from.c()));
        List<sm.j.a> a9 = from.a();
        if (a9 != null) {
            v7 = CollectionsKt__IterablesKt.v(a9, 10);
            arrayList = new ArrayList(v7);
            for (sm.j.a aVar : a9) {
                arrayList.add(new kp.a(aVar.b(), aVar.a()));
            }
        } else {
            arrayList = null;
        }
        return new kp(a8, arrayList, from.d() != null ? new kp.b(from.d().b(), from.d().a()) : null);
    }
}
