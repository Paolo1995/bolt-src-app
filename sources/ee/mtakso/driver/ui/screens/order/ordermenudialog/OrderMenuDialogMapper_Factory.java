package ee.mtakso.driver.ui.screens.order.ordermenudialog;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OrderMenuDialogMapper_Factory implements Factory<OrderMenuDialogMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final OrderMenuDialogMapper_Factory f31578a = new OrderMenuDialogMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static OrderMenuDialogMapper_Factory a() {
        return InstanceHolder.f31578a;
    }

    public static OrderMenuDialogMapper c() {
        return new OrderMenuDialogMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderMenuDialogMapper get() {
        return c();
    }
}
