package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.qn;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class oq {

    /* renamed from: a  reason: collision with root package name */
    private final wp f44480a;

    /* renamed from: b  reason: collision with root package name */
    private final fo f44481b;

    @Inject
    public oq(wp stepMapper, fo verificationFlowStatusMapper) {
        Intrinsics.f(stepMapper, "stepMapper");
        Intrinsics.f(verificationFlowStatusMapper, "verificationFlowStatusMapper");
        this.f44480a = stepMapper;
        this.f44481b = verificationFlowStatusMapper;
    }

    public final qn.b a(String flowRunUuid, nq from) {
        int v7;
        Intrinsics.f(flowRunUuid, "flowRunUuid");
        Intrinsics.f(from, "from");
        List<yp> e8 = from.e();
        v7 = CollectionsKt__IterablesKt.v(e8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (yp ypVar : e8) {
            arrayList.add(this.f44480a.a(ypVar));
        }
        return new qn.b(this.f44481b.a(from.d()), flowRunUuid, arrayList, from.b(), from.a() != null ? this.f44480a.a(from.a()) : null, from.c());
    }
}
