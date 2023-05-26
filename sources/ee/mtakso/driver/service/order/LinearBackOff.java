package ee.mtakso.driver.service.order;

import eu.bolt.driver.core.util.BackOffCalculator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* compiled from: LinearBackOff.kt */
/* loaded from: classes3.dex */
public final class LinearBackOff implements BackOffCalculator {

    /* renamed from: a  reason: collision with root package name */
    private int f25376a;

    @Override // eu.bolt.driver.core.util.BackOffCalculator
    public long a(Throwable thr) {
        Intrinsics.f(thr, "thr");
        long h8 = Random.f51030f.h(0L, 1000L);
        int i8 = this.f25376a + 1;
        this.f25376a = i8;
        return (i8 * 1000) + h8;
    }
}
