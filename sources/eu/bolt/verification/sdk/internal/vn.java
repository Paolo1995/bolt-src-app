package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.jo;
import eu.bolt.verification.sdk.internal.qn;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class vn {

    /* renamed from: a  reason: collision with root package name */
    private final wp f45462a;

    /* renamed from: b  reason: collision with root package name */
    private final fo f45463b;

    @Inject
    public vn(wp stepMapper, fo verificationFlowStatusMapper) {
        Intrinsics.f(stepMapper, "stepMapper");
        Intrinsics.f(verificationFlowStatusMapper, "verificationFlowStatusMapper");
        this.f45462a = stepMapper;
        this.f45463b = verificationFlowStatusMapper;
    }

    public final qn a(String flowRunUuid, jo from) {
        int v7;
        Intrinsics.f(flowRunUuid, "flowRunUuid");
        Intrinsics.f(from, "from");
        if (!(from instanceof jo.b)) {
            if (from instanceof jo.a) {
                return new qn.a(this.f45463b.a(from.a()));
            }
            throw new NoWhenBranchMatchedException();
        }
        jo.b bVar = (jo.b) from;
        List<yp> d8 = bVar.b().d();
        v7 = CollectionsKt__IterablesKt.v(d8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (yp ypVar : d8) {
            arrayList.add(this.f45462a.a(ypVar));
        }
        return new qn.b(this.f45463b.a(from.a()), flowRunUuid, arrayList, bVar.b().b(), bVar.b().a() != null ? this.f45462a.a(bVar.b().a()) : null, bVar.b().c());
    }
}
