package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.jk;
import eu.bolt.verification.sdk.internal.tj;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class vj {

    /* renamed from: a  reason: collision with root package name */
    private final mi f45455a;

    @Inject
    public vj(mi dimensionMapper) {
        Intrinsics.f(dimensionMapper, "dimensionMapper");
        this.f45455a = dimensionMapper;
    }

    public final tj a(jk.e eVar) {
        jk.h a8;
        oi a9 = (eVar == null || (a8 = eVar.a()) == null) ? null : this.f45455a.a(a8);
        String b8 = eVar != null ? eVar.b() : null;
        if (Intrinsics.a(b8, "image")) {
            return new tj.a(eVar.c(), a9);
        }
        if (Intrinsics.a(b8, "lottie")) {
            return new tj.b(eVar.c(), a9);
        }
        if (b8 == null) {
            return null;
        }
        t3.c("Unknown asset type in story slide: " + eVar, null, 2, null);
        return null;
    }
}
