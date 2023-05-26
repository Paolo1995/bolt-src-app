package eu.bolt.verification.sdk.internal;

import dagger.Reusable;
import eu.bolt.verification.sdk.internal.aa;
import eu.bolt.verification.sdk.internal.p9;

@Reusable
/* loaded from: classes5.dex */
public final class y9 implements x9 {
    public aa.f a(p9.c cVar) {
        return null;
    }

    @Override // eu.bolt.verification.sdk.internal.x9
    public aa j(p9 p9Var) {
        aa cVar;
        if (p9Var instanceof p9.a) {
            p9.a aVar = (p9.a) p9Var;
            String c8 = aVar.c();
            aVar.b();
            cVar = new aa.g(c8, null, a(null), null, null, null, Boolean.valueOf(aVar.a()), 58, null);
        } else if (!(p9Var instanceof p9.b)) {
            return null;
        } else {
            p9.b bVar = (p9.b) p9Var;
            String d8 = bVar.d();
            bVar.c();
            cVar = new aa.c(d8, a(null), null, bVar.b(), bVar.a(), 4, null);
        }
        return cVar;
    }
}
