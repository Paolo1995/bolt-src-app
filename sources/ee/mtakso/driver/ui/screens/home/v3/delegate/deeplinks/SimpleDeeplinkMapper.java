package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.home.v3.HomeContainerRoutingCommand;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public class SimpleDeeplinkMapper<T extends DeeplinkCall> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<? extends Fragment> f29963a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f29964b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<DeeplinkCall, Boolean> f29965c;

    /* renamed from: d  reason: collision with root package name */
    private final Function1<T, Bundle> f29966d;

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleDeeplinkMapper(Class<? extends Fragment> fragmentClass, boolean z7, Function1<? super DeeplinkCall, Boolean> canHandle, Function1<? super T, Bundle> bundleFactory) {
        Intrinsics.f(fragmentClass, "fragmentClass");
        Intrinsics.f(canHandle, "canHandle");
        Intrinsics.f(bundleFactory, "bundleFactory");
        this.f29963a = fragmentClass;
        this.f29964b = z7;
        this.f29965c = canHandle;
        this.f29966d = bundleFactory;
    }

    public RoutingCommand.ActivityClass a(T deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        if (!this.f29965c.invoke(deeplink).booleanValue()) {
            return null;
        }
        return SimpleActivity.Companion.f(SimpleActivity.f27004l, this.f29963a, this.f29966d.invoke(deeplink), this.f29964b, 0, 8, null);
    }

    public HomeContainerRoutingCommand b(T deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        if (!this.f29965c.invoke(deeplink).booleanValue()) {
            return null;
        }
        RoutingState routingState = new RoutingState(SimpleActivity.class, null, 2, null);
        Class<? extends Fragment> cls = this.f29963a;
        Bundle invoke = this.f29966d.invoke(deeplink);
        if (invoke == null) {
            invoke = new Bundle();
        }
        return new HomeContainerRoutingCommand(new RoutingCommand.FragmentClass(routingState, cls, invoke));
    }

    public /* synthetic */ SimpleDeeplinkMapper(Class cls, boolean z7, Function1 function1, Function1 function12, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, (i8 & 2) != 0 ? false : z7, (i8 & 4) != 0 ? new Function1<DeeplinkCall, Boolean>() { // from class: ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.SimpleDeeplinkMapper.1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(DeeplinkCall it) {
                Intrinsics.f(it, "it");
                return Boolean.TRUE;
            }
        } : function1, (i8 & 8) != 0 ? new Function1() { // from class: ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.SimpleDeeplinkMapper.2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Void invoke(T it) {
                Intrinsics.f(it, "it");
                return null;
            }
        } : function12);
    }
}
