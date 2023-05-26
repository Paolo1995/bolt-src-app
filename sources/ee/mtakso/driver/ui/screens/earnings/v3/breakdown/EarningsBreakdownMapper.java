package ee.mtakso.driver.ui.screens.earnings.v3.breakdown;

import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverContentTypeMapper;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsBreakdownMapper.kt */
/* loaded from: classes3.dex */
public final class EarningsBreakdownMapper {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f28907d = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final EarningsItemMapper f28908a;

    /* renamed from: b  reason: collision with root package name */
    private final EarningsNestedItemMapper f28909b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverContentTypeMapper f28910c;

    /* compiled from: EarningsBreakdownMapper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public EarningsBreakdownMapper(EarningsItemMapper listItemMapper, EarningsNestedItemMapper nestedListItemMapper, DriverContentTypeMapper driverContentTypeMapper) {
        Intrinsics.f(listItemMapper, "listItemMapper");
        Intrinsics.f(nestedListItemMapper, "nestedListItemMapper");
        Intrinsics.f(driverContentTypeMapper, "driverContentTypeMapper");
        this.f28908a = listItemMapper;
        this.f28909b = nestedListItemMapper;
        this.f28910c = driverContentTypeMapper;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<ee.mtakso.driver.uikit.recyclerview.ListModel> a(eu.bolt.driver.earnings.network.EarningBreakdownScreen r24) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownMapper.a(eu.bolt.driver.earnings.network.EarningBreakdownScreen):java.util.List");
    }
}
