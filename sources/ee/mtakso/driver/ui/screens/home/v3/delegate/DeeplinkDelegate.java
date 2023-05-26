package ee.mtakso.driver.ui.screens.home.v3.delegate;

import android.net.Uri;
import ee.mtakso.driver.deeplink.DeepLinkManager;
import ee.mtakso.driver.deeplink.DeepLinkParser;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.di.authorised.AuthorisedComponent;
import ee.mtakso.driver.service.deeplinks.ExecutableDeeplinkManager;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.DeeplinkRoutingCommand;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeeplinkDelegate.kt */
/* loaded from: classes3.dex */
public final class DeeplinkDelegate {

    /* renamed from: a */
    private final DeepLinkParser f29868a;

    /* renamed from: b */
    private final DeepLinkManager f29869b;

    /* renamed from: c */
    private final CompositeUrlLauncher f29870c;

    /* renamed from: d */
    private final RoutingManager f29871d;

    @Inject
    public DeeplinkDelegate(DeepLinkParser deepLinkParser, DeepLinkManager deepLinkManager, CompositeUrlLauncher urlLauncher, RoutingManager routingManager) {
        Intrinsics.f(deepLinkParser, "deepLinkParser");
        Intrinsics.f(deepLinkManager, "deepLinkManager");
        Intrinsics.f(urlLauncher, "urlLauncher");
        Intrinsics.f(routingManager, "routingManager");
        this.f29868a = deepLinkParser;
        this.f29869b = deepLinkManager;
        this.f29870c = urlLauncher;
        this.f29871d = routingManager;
    }

    private final ExecutableDeeplinkManager c() {
        AuthorisedComponent Z1 = Injector.f20166d.b().Z1();
        if (Z1 != null) {
            return Z1.y();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(DeeplinkDelegate deeplinkDelegate, String str, Function1 function1, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            function1 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate$handleDeeplink$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(String it) {
                    CompositeUrlLauncher compositeUrlLauncher;
                    Intrinsics.f(it, "it");
                    compositeUrlLauncher = DeeplinkDelegate.this.f29870c;
                    compositeUrlLauncher.a(it);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                    b(str2);
                    return Unit.f50853a;
                }
            };
        }
        deeplinkDelegate.e(str, function1);
    }

    public final void b(DeeplinkCall deeplinkCall) {
        Intrinsics.f(deeplinkCall, "deeplinkCall");
        ExecutableDeeplinkManager c8 = c();
        boolean z7 = false;
        if (c8 != null && c8.c(deeplinkCall)) {
            z7 = true;
        }
        if (!z7) {
            this.f29871d.b(new DeeplinkRoutingCommand(deeplinkCall), true);
        }
    }

    public final void d(String uri) {
        Intrinsics.f(uri, "uri");
        f(this, uri, null, 2, null);
    }

    public final void e(String uri, Function1<? super String, Unit> fallbackLauncher) {
        Unit unit;
        Intrinsics.f(uri, "uri");
        Intrinsics.f(fallbackLauncher, "fallbackLauncher");
        DeepLinkParser deepLinkParser = this.f29868a;
        Uri parse = Uri.parse(uri);
        Intrinsics.e(parse, "parse(uri)");
        DeeplinkCall b8 = deepLinkParser.b(parse);
        if (b8 != null) {
            b(b8);
            unit = Unit.f50853a;
        } else {
            unit = null;
        }
        if (unit == null) {
            fallbackLauncher.invoke(uri);
        }
    }

    public final boolean g(boolean z7) {
        List<DeeplinkCall> d8 = this.f29869b.d();
        ArrayList<DeeplinkCall> arrayList = new ArrayList();
        Iterator<T> it = d8.iterator();
        while (true) {
            boolean z8 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            DeeplinkCall deeplinkCall = (DeeplinkCall) next;
            if (!z7 && !deeplinkCall.a()) {
                z8 = false;
            }
            if (z8) {
                arrayList.add(next);
            }
        }
        for (DeeplinkCall deeplinkCall2 : arrayList) {
            b(deeplinkCall2);
        }
        return !arrayList.isEmpty();
    }
}
