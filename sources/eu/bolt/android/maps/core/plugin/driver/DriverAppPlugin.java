package eu.bolt.android.maps.core.plugin.driver;

import android.graphics.PointF;
import android.view.View;
import eu.bolt.android.maps.core.Locatable;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: DriverAppPlugin.kt */
/* loaded from: classes5.dex */
public interface DriverAppPlugin {
    void A(MapType mapType);

    void B(List<IconMapPoint> list);

    void a(int i8);

    void b(int i8);

    void c();

    void d(Locatable locatable, double d8, int i8);

    void e(List<? extends Locatable> list, long j8, float f8);

    MarkerInfo f(int i8, Locatable locatable, double d8, long j8);

    CircleInfo g(Locatable locatable, double d8, double d9, int i8, int i9);

    MarkerInfo h(MarkerParams markerParams);

    MarkerInfo i(int i8, Locatable locatable, double d8, int i9);

    void j(int i8, int i9);

    void k(Float f8, Float f9, long j8);

    int l(List<? extends Locatable> list, double d8, int i8, int i9);

    void m(int i8);

    void n(int i8);

    void o(MapStyle mapStyle);

    MarkerInfo p(int i8, Locatable locatable, double d8, int i9);

    void q(int i8, float f8);

    void r(boolean z7);

    int s(TileSource tileSource, float f8);

    void setTrafficEnabled(boolean z7);

    MarkerInfo t(View view, Locatable locatable, double d8, PointF pointF);

    void u(int i8);

    int v(List<? extends Locatable> list, double d8, int i8);

    void w(Function1<? super MapProjectionAndCamera, Unit> function1);

    void x(Function1<? super MarkerInfo, Unit> function1);

    void y(Function1<? super Locatable, Unit> function1);

    CircleInfo z(int i8, Locatable locatable, double d8);
}
