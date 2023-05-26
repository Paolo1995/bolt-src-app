package ee.mtakso.driver.onboarding;

import ee.mtakso.driver.onboarding.steps.OnBoardingStep;
import ee.mtakso.driver.param.DriverProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnBoardingManager.kt */
/* loaded from: classes3.dex */
public final class OnBoardingManager {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f23029a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<OnBoardingStep.Type, OnBoardingStep> f23030b;

    /* renamed from: c  reason: collision with root package name */
    private final List<OnBoardingStep> f23031c;

    /* renamed from: d  reason: collision with root package name */
    private final List<OnBoardingStep> f23032d;

    @Inject
    public OnBoardingManager(DriverProvider driverProvider, Map<OnBoardingStep.Type, OnBoardingStep> steps) {
        boolean z7;
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(steps, "steps");
        this.f23029a = driverProvider;
        this.f23030b = steps;
        Collection<OnBoardingStep> values = steps.values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = values.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((OnBoardingStep) next).c() == OnBoardingStep.Severity.MANDATORY) {
                arrayList.add(next);
            }
        }
        this.f23031c = arrayList;
        Collection<OnBoardingStep> values2 = this.f23030b.values();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : values2) {
            if (((OnBoardingStep) obj).c() == OnBoardingStep.Severity.OPTIONAL) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                arrayList2.add(obj);
            }
        }
        this.f23032d = arrayList2;
    }

    public final OnBoardingStep a(OnBoardingStep.Type type) {
        Intrinsics.f(type, "type");
        OnBoardingStep onBoardingStep = this.f23030b.get(type);
        if (onBoardingStep != null) {
            return onBoardingStep;
        }
        throw new IllegalStateException("Cannot find " + type + ". Probably it was not added to OnBoardingModule");
    }

    public final List<OnBoardingStep> b() {
        List v02;
        v02 = CollectionsKt___CollectionsKt.v0(this.f23030b.values(), new Comparator() { // from class: ee.mtakso.driver.onboarding.OnBoardingManager$getAvailableSteps$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t7, T t8) {
                int a8;
                a8 = ComparisonsKt__ComparisonsKt.a(Integer.valueOf(((OnBoardingStep) t7).f().c()), Integer.valueOf(((OnBoardingStep) t8).f().c()));
                return a8;
            }
        });
        ArrayList arrayList = new ArrayList();
        for (Object obj : v02) {
            if (((OnBoardingStep) obj).h()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final boolean c() {
        boolean z7;
        boolean z8;
        List<OnBoardingStep> list = this.f23031c;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (OnBoardingStep onBoardingStep : list) {
                if (onBoardingStep.h()) {
                    z7 = true;
                    break;
                }
            }
        }
        z7 = false;
        if (z7) {
            return true;
        }
        List<OnBoardingStep> list2 = this.f23032d;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            for (OnBoardingStep onBoardingStep2 : list2) {
                if (onBoardingStep2.h()) {
                    z8 = true;
                    break;
                }
            }
        }
        z8 = false;
        if (!this.f23029a.t().D().a() && z8) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        List<OnBoardingStep> list = this.f23032d;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (OnBoardingStep onBoardingStep : list) {
            if (onBoardingStep.h()) {
                return true;
            }
        }
        return false;
    }

    public final boolean e() {
        List<OnBoardingStep> list = this.f23031c;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (OnBoardingStep onBoardingStep : list) {
            if (onBoardingStep.h()) {
                return true;
            }
        }
        return false;
    }
}
