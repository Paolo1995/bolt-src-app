package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.c2;
import eu.bolt.verification.sdk.internal.pm;

/* loaded from: classes5.dex */
public final class nm {
    public final c2 a(pm pmVar) {
        if (pmVar instanceof pm.c) {
            return new c2.c(((pm.c) pmVar).a());
        }
        if (pmVar instanceof pm.b) {
            pm.b bVar = (pm.b) pmVar;
            return new c2.b(bVar.a(), bVar.b());
        } else if (pmVar instanceof pm.a) {
            pm.a aVar = (pm.a) pmVar;
            return new c2.a(aVar.a(), aVar.b(), c2.a.EnumC0039a.AT_LEAST_ONE);
        } else {
            return null;
        }
    }
}
