package ee.mtakso.driver.navigation;

import ee.mtakso.driver.network.client.driver.navigation.DynamicNavigationOption;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DynamicNavigationMapper.kt */
/* loaded from: classes3.dex */
public final class DynamicNavigationMapper {
    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption b(ee.mtakso.driver.network.client.driver.navigation.DynamicNavigationOption.Native r8) {
        /*
            r7 = this;
            ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption r6 = new ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption
            java.lang.String r1 = r8.b()
            eu.bolt.driver.earnings.network.DriverImage r0 = r8.a()
            boolean r2 = r0 instanceof eu.bolt.driver.earnings.network.DriverImage.Normal
            r3 = 0
            if (r2 == 0) goto L1f
            eu.bolt.driver.earnings.network.DriverImage r0 = r8.a()
            eu.bolt.driver.earnings.network.DriverImage$Normal r0 = (eu.bolt.driver.earnings.network.DriverImage.Normal) r0
            eu.bolt.driver.earnings.network.DriverImage$Url r0 = r0.b()
            java.lang.String r0 = r0.a()
        L1d:
            r2 = r0
            goto L33
        L1f:
            boolean r0 = r0 instanceof eu.bolt.driver.earnings.network.DriverImage.Tintable
            if (r0 == 0) goto L32
            eu.bolt.driver.earnings.network.DriverImage r0 = r8.a()
            eu.bolt.driver.earnings.network.DriverImage$Tintable r0 = (eu.bolt.driver.earnings.network.DriverImage.Tintable) r0
            eu.bolt.driver.earnings.network.DriverImage$Url r0 = r0.a()
            java.lang.String r0 = r0.a()
            goto L1d
        L32:
            r2 = r3
        L33:
            eu.bolt.driver.earnings.network.DriverImage r0 = r8.a()
            boolean r4 = r0 instanceof eu.bolt.driver.earnings.network.DriverImage.Normal
            if (r4 == 0) goto L4c
            eu.bolt.driver.earnings.network.DriverImage r0 = r8.a()
            eu.bolt.driver.earnings.network.DriverImage$Normal r0 = (eu.bolt.driver.earnings.network.DriverImage.Normal) r0
            eu.bolt.driver.earnings.network.DriverImage$Url r0 = r0.a()
            if (r0 == 0) goto L5f
            java.lang.String r0 = r0.a()
            goto L5e
        L4c:
            boolean r0 = r0 instanceof eu.bolt.driver.earnings.network.DriverImage.Tintable
            if (r0 == 0) goto L5f
            eu.bolt.driver.earnings.network.DriverImage r0 = r8.a()
            eu.bolt.driver.earnings.network.DriverImage$Tintable r0 = (eu.bolt.driver.earnings.network.DriverImage.Tintable) r0
            eu.bolt.driver.earnings.network.DriverImage$Url r0 = r0.a()
            java.lang.String r0 = r0.a()
        L5e:
            r3 = r0
        L5f:
            boolean r4 = r8.c()
            r5 = 0
            r0 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.navigation.DynamicNavigationMapper.b(ee.mtakso.driver.network.client.driver.navigation.DynamicNavigationOption$Native):ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption c(ee.mtakso.driver.network.client.driver.navigation.DynamicNavigationOption.ThirdParty r17) {
        /*
            r16 = this;
            ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption r6 = new ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption
            java.lang.String r1 = r17.d()
            eu.bolt.driver.earnings.network.DriverImage r0 = r17.a()
            boolean r2 = r0 instanceof eu.bolt.driver.earnings.network.DriverImage.Normal
            r3 = 0
            if (r2 == 0) goto L1f
            eu.bolt.driver.earnings.network.DriverImage r0 = r17.a()
            eu.bolt.driver.earnings.network.DriverImage$Normal r0 = (eu.bolt.driver.earnings.network.DriverImage.Normal) r0
            eu.bolt.driver.earnings.network.DriverImage$Url r0 = r0.b()
            java.lang.String r0 = r0.a()
        L1d:
            r2 = r0
            goto L33
        L1f:
            boolean r0 = r0 instanceof eu.bolt.driver.earnings.network.DriverImage.Tintable
            if (r0 == 0) goto L32
            eu.bolt.driver.earnings.network.DriverImage r0 = r17.a()
            eu.bolt.driver.earnings.network.DriverImage$Tintable r0 = (eu.bolt.driver.earnings.network.DriverImage.Tintable) r0
            eu.bolt.driver.earnings.network.DriverImage$Url r0 = r0.a()
            java.lang.String r0 = r0.a()
            goto L1d
        L32:
            r2 = r3
        L33:
            eu.bolt.driver.earnings.network.DriverImage r0 = r17.a()
            boolean r4 = r0 instanceof eu.bolt.driver.earnings.network.DriverImage.Normal
            if (r4 == 0) goto L4c
            eu.bolt.driver.earnings.network.DriverImage r0 = r17.a()
            eu.bolt.driver.earnings.network.DriverImage$Normal r0 = (eu.bolt.driver.earnings.network.DriverImage.Normal) r0
            eu.bolt.driver.earnings.network.DriverImage$Url r0 = r0.a()
            if (r0 == 0) goto L60
            java.lang.String r0 = r0.a()
            goto L5e
        L4c:
            boolean r0 = r0 instanceof eu.bolt.driver.earnings.network.DriverImage.Tintable
            if (r0 == 0) goto L60
            eu.bolt.driver.earnings.network.DriverImage r0 = r17.a()
            eu.bolt.driver.earnings.network.DriverImage$Tintable r0 = (eu.bolt.driver.earnings.network.DriverImage.Tintable) r0
            eu.bolt.driver.earnings.network.DriverImage$Url r0 = r0.a()
            java.lang.String r0 = r0.a()
        L5e:
            r4 = r0
            goto L61
        L60:
            r4 = r3
        L61:
            boolean r5 = r17.f()
            ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption$IntentDataHolder r15 = new ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption$IntentDataHolder
            java.lang.String r8 = r17.e()
            java.lang.String r9 = r17.g()
            java.lang.Long r10 = r17.c()
            ee.mtakso.driver.network.client.driver.navigation.DynamicNavigationOption$ThirdParty$Intent r0 = r17.b()
            if (r0 == 0) goto L7f
            java.lang.String r0 = r0.a()
            r11 = r0
            goto L80
        L7f:
            r11 = r3
        L80:
            ee.mtakso.driver.network.client.driver.navigation.DynamicNavigationOption$ThirdParty$Intent r0 = r17.b()
            if (r0 == 0) goto L8c
            java.lang.String r0 = r0.c()
            r12 = r0
            goto L8d
        L8c:
            r12 = r3
        L8d:
            ee.mtakso.driver.network.client.driver.navigation.DynamicNavigationOption$ThirdParty$Intent r0 = r17.b()
            if (r0 == 0) goto L99
            java.lang.String r0 = r0.d()
            r13 = r0
            goto L9a
        L99:
            r13 = r3
        L9a:
            ee.mtakso.driver.network.client.driver.navigation.DynamicNavigationOption$ThirdParty$Intent r0 = r17.b()
            if (r0 == 0) goto La4
            java.util.Map r3 = r0.b()
        La4:
            r14 = r3
            r7 = r15
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            r0 = r6
            r3 = r4
            r4 = r5
            r5 = r15
            r0.<init>(r1, r2, r3, r4, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.navigation.DynamicNavigationMapper.c(ee.mtakso.driver.network.client.driver.navigation.DynamicNavigationOption$ThirdParty):ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption");
    }

    public final List<NavigationOption> a(List<? extends DynamicNavigationOption> dynamicNavigations) {
        int v7;
        Object obj;
        Intrinsics.f(dynamicNavigations, "dynamicNavigations");
        ArrayList arrayList = new ArrayList();
        v7 = CollectionsKt__IterablesKt.v(dynamicNavigations, 10);
        ArrayList arrayList2 = new ArrayList(v7);
        for (DynamicNavigationOption dynamicNavigationOption : dynamicNavigations) {
            if (dynamicNavigationOption instanceof DynamicNavigationOption.Native) {
                obj = Boolean.valueOf(arrayList.add(b((DynamicNavigationOption.Native) dynamicNavigationOption)));
            } else if (dynamicNavigationOption instanceof DynamicNavigationOption.ThirdParty) {
                obj = Boolean.valueOf(arrayList.add(c((DynamicNavigationOption.ThirdParty) dynamicNavigationOption)));
            } else if (dynamicNavigationOption instanceof DynamicNavigationOption.Unknown) {
                obj = Unit.f50853a;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            arrayList2.add(obj);
        }
        return arrayList;
    }
}
