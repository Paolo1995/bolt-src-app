package ee.mtakso.driver.service.order;

import eu.bolt.driver.core.util.BackOffCalculator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* compiled from: ActiveOrderBackOff.kt */
/* loaded from: classes3.dex */
public final class ActiveOrderBackOff implements BackOffCalculator {

    /* renamed from: a  reason: collision with root package name */
    private int f25375a;

    @Override // eu.bolt.driver.core.util.BackOffCalculator
    public long a(Throwable thr) {
        boolean z7;
        int i8;
        Intrinsics.f(thr, "thr");
        long h8 = Random.f51030f.h(0L, 1000L);
        int i9 = this.f25375a;
        boolean z8 = true;
        if (i9 >= 0 && i9 < 3) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            i8 = i9 + 1;
        } else {
            if ((3 > i9 || i9 >= 49) ? false : false) {
                i8 = i9 * 2;
            } else {
                i8 = 96;
            }
        }
        this.f25375a = i8;
        return (i8 * 1000) + h8;
    }
}
