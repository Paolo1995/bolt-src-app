package ee.mtakso.driver.ui.screens.order.v2.map;

import android.view.View;
import ee.mtakso.driver.ui.screens.order.v2.map.CompassButtonDelegate;
import eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin;
import eu.bolt.android.maps.core.plugin.driver.MapCameraPosition;
import eu.bolt.android.maps.core.plugin.driver.MapProjectionAndCamera;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompassButtonDelegate.kt */
/* loaded from: classes3.dex */
public final class CompassButtonDelegate {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f32108d = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final View f32109a;

    /* renamed from: b  reason: collision with root package name */
    private MapCameraPosition f32110b;

    /* renamed from: c  reason: collision with root package name */
    private NavigationMode f32111c;

    /* compiled from: CompassButtonDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CompassButtonDelegate(View compassButton, final DriverAppPlugin mapController) {
        Intrinsics.f(compassButton, "compassButton");
        Intrinsics.f(mapController, "mapController");
        this.f32109a = compassButton;
        mapController.r(false);
        compassButton.setOnClickListener(new View.OnClickListener() { // from class: y4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CompassButtonDelegate.b(DriverAppPlugin.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DriverAppPlugin mapController, View view) {
        Intrinsics.f(mapController, "$mapController");
        Float valueOf = Float.valueOf(0.0f);
        mapController.k(valueOf, valueOf, 500L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
        if (r3 == false) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void c() {
        /*
            r6 = this;
            eu.bolt.android.maps.core.plugin.driver.MapCameraPosition r0 = r6.f32110b
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L23
            float r3 = r0.b()
            r4 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L11
            r3 = 1
            goto L12
        L11:
            r3 = 0
        L12:
            if (r3 == 0) goto L21
            float r3 = r0.a()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L1e
            r3 = 1
            goto L1f
        L1e:
            r3 = 0
        L1f:
            if (r3 != 0) goto L23
        L21:
            r3 = 1
            goto L24
        L23:
            r3 = 0
        L24:
            ee.mtakso.driver.ui.screens.order.v2.map.NavigationMode r4 = r6.f32111c
            ee.mtakso.driver.ui.screens.order.v2.map.NavigationMode r5 = ee.mtakso.driver.ui.screens.order.v2.map.NavigationMode.FOLLOW
            if (r4 != r5) goto L2c
            r4 = 1
            goto L2d
        L2c:
            r4 = 0
        L2d:
            android.view.View r5 = r6.f32109a
            if (r3 != 0) goto L35
            if (r4 == 0) goto L34
            goto L35
        L34:
            r1 = 0
        L35:
            r3 = 2
            r4 = 0
            ee.mtakso.driver.uicore.utils.ViewExtKt.e(r5, r1, r2, r3, r4)
            if (r0 == 0) goto L45
            android.view.View r1 = r6.f32109a
            float r0 = r0.a()
            r1.setRotation(r0)
        L45:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.order.v2.map.CompassButtonDelegate.c():void");
    }

    public final void d(NavigationMode navigationMode) {
        Intrinsics.f(navigationMode, "navigationMode");
        this.f32111c = navigationMode;
        c();
    }

    public final void e(MapProjectionAndCamera projectionAndCamera) {
        Intrinsics.f(projectionAndCamera, "projectionAndCamera");
        this.f32110b = projectionAndCamera.a();
        c();
    }
}
