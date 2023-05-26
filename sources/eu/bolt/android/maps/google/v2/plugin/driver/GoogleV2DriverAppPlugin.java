package eu.bolt.android.maps.google.v2.plugin.driver;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import eu.bolt.android.maps.core.GeoUtils;
import eu.bolt.android.maps.core.Locatable;
import eu.bolt.android.maps.core.MapPoint;
import eu.bolt.android.maps.core.ScreenBounds;
import eu.bolt.android.maps.core.animation.LinearPointEvaluator;
import eu.bolt.android.maps.core.animation.PointAnimator;
import eu.bolt.android.maps.core.plugin.driver.CircleInfo;
import eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin;
import eu.bolt.android.maps.core.plugin.driver.IconMapPoint;
import eu.bolt.android.maps.core.plugin.driver.MapCameraPosition;
import eu.bolt.android.maps.core.plugin.driver.MapProjection;
import eu.bolt.android.maps.core.plugin.driver.MapProjectionAndCamera;
import eu.bolt.android.maps.core.plugin.driver.MapStyle;
import eu.bolt.android.maps.core.plugin.driver.MapType;
import eu.bolt.android.maps.core.plugin.driver.MarkerInfo;
import eu.bolt.android.maps.core.plugin.driver.MarkerParams;
import eu.bolt.android.maps.core.plugin.driver.TileSource;
import eu.bolt.android.maps.google.v2.R$raw;
import eu.bolt.android.maps.google.v2.plugin.driver.GoogleV2DriverAppPlugin;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* compiled from: GoogleV2DriverAppPlugin.kt */
/* loaded from: classes5.dex */
public final class GoogleV2DriverAppPlugin implements DriverAppPlugin {

    /* renamed from: a  reason: collision with root package name */
    private final Context f37003a;

    /* renamed from: b  reason: collision with root package name */
    private final GoogleMap f37004b;

    /* renamed from: c  reason: collision with root package name */
    private final Function0<View> f37005c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Integer, Marker> f37006d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Integer, Circle> f37007e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Integer, Polyline> f37008f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<Integer, GroundOverlay> f37009g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<Integer, TileOverlay> f37010h;

    /* renamed from: i  reason: collision with root package name */
    private final Map<Integer, Polygon> f37011i;

    /* renamed from: j  reason: collision with root package name */
    private final AtomicInteger f37012j;

    /* renamed from: k  reason: collision with root package name */
    private ScreenBounds f37013k;

    /* renamed from: l  reason: collision with root package name */
    private final PointAnimator f37014l;

    /* compiled from: GoogleV2DriverAppPlugin.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37015a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f37016b;

        static {
            int[] iArr = new int[MapStyle.values().length];
            try {
                iArr[MapStyle.LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MapStyle.DARK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f37015a = iArr;
            int[] iArr2 = new int[MapType.values().length];
            try {
                iArr2[MapType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[MapType.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            f37016b = iArr2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GoogleV2DriverAppPlugin(Context context, GoogleMap map, Function0<? extends View> viewProvider) {
        Intrinsics.f(context, "context");
        Intrinsics.f(map, "map");
        Intrinsics.f(viewProvider, "viewProvider");
        this.f37003a = context;
        this.f37004b = map;
        this.f37005c = viewProvider;
        this.f37006d = new LinkedHashMap();
        this.f37007e = new LinkedHashMap();
        this.f37008f = new LinkedHashMap();
        this.f37009g = new LinkedHashMap();
        this.f37010h = new LinkedHashMap();
        this.f37011i = new LinkedHashMap();
        this.f37012j = new AtomicInteger();
        this.f37013k = new ScreenBounds(0, 0, 0, 0, 15, null);
        this.f37014l = new PointAnimator(new LinearPointEvaluator());
        map.setBuildingsEnabled(false);
        map.getUiSettings().setMapToolbarEnabled(false);
    }

    private final BitmapDescriptor K(MarkerParams markerParams) {
        Bitmap d8 = markerParams.d();
        Integer f8 = markerParams.f();
        if (d8 != null) {
            BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(d8);
            Intrinsics.e(fromBitmap, "fromBitmap(bitmap)");
            return fromBitmap;
        } else if (f8 != null) {
            BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(f8.intValue());
            Intrinsics.e(fromResource, "fromResource(resId)");
            return fromResource;
        } else {
            throw new IllegalArgumentException("Marker params are invalid: bitmap and icon res id are missing");
        }
    }

    private final CameraUpdate L(Context context, LatLngBounds latLngBounds, float f8) {
        CameraUpdate newLatLngBounds = CameraUpdateFactory.newLatLngBounds(latLngBounds, (int) TypedValue.applyDimension(1, f8, context.getResources().getDisplayMetrics()));
        Intrinsics.e(newLatLngBounds, "newLatLngBounds(bounds, paddingPx)");
        return newLatLngBounds;
    }

    private final CameraUpdate M(Context context, List<? extends Locatable> list, float f8) {
        LatLngBounds.Builder builder = LatLngBounds.builder();
        Intrinsics.e(builder, "builder()");
        for (Locatable locatable : list) {
            builder.include(new LatLng(locatable.a(), locatable.b()));
        }
        LatLngBounds build = builder.build();
        Intrinsics.e(build, "builder.build()");
        return L(context, build, f8);
    }

    private final int N(BitmapDescriptor bitmapDescriptor, LatLng latLng, float f8, PointF pointF, float f9, boolean z7) {
        int incrementAndGet = this.f37012j.incrementAndGet();
        Marker addMarker = this.f37004b.addMarker(new MarkerOptions().icon(bitmapDescriptor).anchor(pointF.x, pointF.y).rotation(f8).position(latLng).flat(z7).zIndex(f9));
        if (addMarker != null) {
            addMarker.setTag(Integer.valueOf(incrementAndGet));
        }
        this.f37006d.put(Integer.valueOf(incrementAndGet), addMarker);
        return incrementAndGet;
    }

    static /* synthetic */ int O(GoogleV2DriverAppPlugin googleV2DriverAppPlugin, BitmapDescriptor bitmapDescriptor, LatLng latLng, float f8, PointF pointF, float f9, boolean z7, int i8, Object obj) {
        boolean z8;
        if ((i8 & 8) != 0) {
            pointF = new PointF(0.5f, 0.5f);
        }
        PointF pointF2 = pointF;
        if ((i8 & 32) != 0) {
            z8 = true;
        } else {
            z8 = z7;
        }
        return googleV2DriverAppPlugin.N(bitmapDescriptor, latLng, f8, pointF2, f9, z8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean P(Marker it) {
        Intrinsics.f(it, "it");
        return true;
    }

    private final Locatable Q(LatLng latLng) {
        return new MapPoint(latLng.latitude, latLng.longitude);
    }

    private final MapCameraPosition R() {
        LatLng latLng = this.f37004b.getCameraPosition().target;
        Intrinsics.e(latLng, "map.cameraPosition.target");
        return new MapCameraPosition(Q(latLng), this.f37004b.getCameraPosition().zoom, this.f37004b.getCameraPosition().bearing, this.f37004b.getCameraPosition().tilt);
    }

    private final MapProjection S() {
        LatLng latLng = this.f37004b.getProjection().getVisibleRegion().farLeft;
        Intrinsics.e(latLng, "map.projection.visibleRegion.farLeft");
        Locatable Q = Q(latLng);
        LatLng latLng2 = this.f37004b.getProjection().getVisibleRegion().farRight;
        Intrinsics.e(latLng2, "map.projection.visibleRegion.farRight");
        Locatable Q2 = Q(latLng2);
        LatLng latLng3 = this.f37004b.getProjection().getVisibleRegion().nearLeft;
        Intrinsics.e(latLng3, "map.projection.visibleRegion.nearLeft");
        Locatable Q3 = Q(latLng3);
        LatLng latLng4 = this.f37004b.getProjection().getVisibleRegion().nearRight;
        Intrinsics.e(latLng4, "map.projection.visibleRegion.nearRight");
        return new MapProjection(Q, Q2, Q3, Q(latLng4), this.f37004b.getCameraPosition().zoom);
    }

    private final MapProjectionAndCamera T() {
        return new MapProjectionAndCamera(S(), R());
    }

    private final Bitmap U(int i8) {
        Drawable drawable = ContextCompat.getDrawable(this.f37003a, i8);
        if (drawable != null) {
            Intrinsics.e(drawable, "checkNotNull(ContextComp…Drawable(context, resId))");
            Canvas canvas = new Canvas();
            Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            canvas.setBitmap(bitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            Intrinsics.e(bitmap, "bitmap");
            return bitmap;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final Bitmap V(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmap));
        Intrinsics.e(bitmap, "bitmap");
        return bitmap;
    }

    private final boolean W() {
        LatLngBounds latLngBounds = this.f37004b.getProjection().getVisibleRegion().latLngBounds;
        Intrinsics.e(latLngBounds, "map.projection.visibleRegion.latLngBounds");
        return !Intrinsics.a(latLngBounds.northeast, latLngBounds.southwest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(Function1 listener, LatLng it) {
        Intrinsics.f(listener, "$listener");
        Intrinsics.f(it, "it");
        listener.invoke(new MapPoint(it.latitude, it.longitude));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Y(Function1 listener, Marker marker) {
        Integer num;
        Intrinsics.f(listener, "$listener");
        Intrinsics.f(marker, "marker");
        Object tag = marker.getTag();
        if (tag instanceof Integer) {
            num = (Integer) tag;
        } else {
            num = null;
        }
        if (num != null) {
            listener.invoke(new MarkerInfo(num.intValue(), new MapPoint(marker.getPosition().latitude, marker.getPosition().longitude), marker.getRotation()));
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(Function1 listener, GoogleV2DriverAppPlugin this$0) {
        Intrinsics.f(listener, "$listener");
        Intrinsics.f(this$0, "this$0");
        listener.invoke(this$0.T());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(Function1 listener, GoogleV2DriverAppPlugin this$0) {
        Intrinsics.f(listener, "$listener");
        Intrinsics.f(this$0, "this$0");
        listener.invoke(this$0.T());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(Function1 listener, GoogleV2DriverAppPlugin this$0, int i8) {
        Intrinsics.f(listener, "$listener");
        Intrinsics.f(this$0, "this$0");
        listener.invoke(this$0.T());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(Function1 listener, GoogleV2DriverAppPlugin this$0) {
        Intrinsics.f(listener, "$listener");
        Intrinsics.f(this$0, "this$0");
        listener.invoke(this$0.T());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LatLng d0(Locatable locatable) {
        return new LatLng(locatable.a(), locatable.b());
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public void A(MapType type) {
        Intrinsics.f(type, "type");
        GoogleMap googleMap = this.f37004b;
        int i8 = WhenMappings.f37016b[type.ordinal()];
        int i9 = 1;
        if (i8 != 1) {
            if (i8 != 2) {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            i9 = 0;
        }
        googleMap.setMapType(i9);
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public void B(List<IconMapPoint> points) {
        Intrinsics.f(points, "points");
        for (IconMapPoint iconMapPoint : points) {
            i(iconMapPoint.a(), iconMapPoint.b(), 0.0d, 0);
        }
        LatLngBounds.Builder builder = LatLngBounds.builder();
        Intrinsics.e(builder, "builder()");
        for (IconMapPoint iconMapPoint2 : points) {
            builder.include(d0(iconMapPoint2.b()));
        }
        if (W()) {
            LatLngBounds build = builder.build();
            Intrinsics.e(build, "builder.build()");
            this.f37004b.moveCamera(L(this.f37003a, build, 24.0f));
        }
        this.f37004b.setMaxZoomPreference(17.0f);
        this.f37004b.setMyLocationEnabled(false);
        this.f37004b.getUiSettings().setMapToolbarEnabled(false);
        this.f37004b.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() { // from class: h6.g
            @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
            public final boolean onMarkerClick(Marker marker) {
                boolean P;
                P = GoogleV2DriverAppPlugin.P(marker);
                return P;
            }
        });
        this.f37004b.setBuildingsEnabled(false);
        this.f37004b.setIndoorEnabled(false);
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public void a(int i8) {
        Polyline remove = this.f37008f.remove(Integer.valueOf(i8));
        if (remove != null) {
            remove.remove();
        }
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public void b(int i8) {
        Circle remove = this.f37007e.remove(Integer.valueOf(i8));
        if (remove != null) {
            remove.remove();
        }
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public void c() {
        this.f37004b.getUiSettings().setAllGesturesEnabled(false);
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public void d(Locatable target, double d8, int i8) {
        int i9;
        Intrinsics.f(target, "target");
        if (!W()) {
            return;
        }
        View invoke = this.f37005c.invoke();
        int i10 = 0;
        if (invoke != null) {
            i9 = invoke.getWidth();
        } else {
            i9 = 0;
        }
        int d9 = (i9 - this.f37013k.d()) - this.f37013k.e();
        View invoke2 = this.f37005c.invoke();
        if (invoke2 != null) {
            i10 = invoke2.getHeight();
        }
        int f8 = ((i10 - this.f37013k.f()) - this.f37013k.c()) - i8;
        if (f8 > 0) {
            Point point = new Point(d9 / 2, f8);
            LatLng latLng = this.f37004b.getCameraPosition().target;
            Intrinsics.e(latLng, "map.cameraPosition.target");
            LatLng fromScreenLocation = this.f37004b.getProjection().fromScreenLocation(point);
            Intrinsics.e(fromScreenLocation, "map.projection.fromScreenLocation(driverPoint)");
            GeoUtils geoUtils = GeoUtils.f36938a;
            target = geoUtils.g(target, geoUtils.e(latLng.latitude, latLng.longitude, fromScreenLocation.latitude, fromScreenLocation.longitude), d8);
        }
        CameraPosition.Builder builder = CameraPosition.builder();
        Intrinsics.e(builder, "builder()");
        builder.bearing((float) d8);
        builder.target(d0(target));
        builder.tilt(55.0f);
        builder.zoom(18.0f);
        this.f37004b.animateCamera(CameraUpdateFactory.newCameraPosition(builder.build()), 400, null);
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public void e(List<? extends Locatable> points, long j8, float f8) {
        Intrinsics.f(points, "points");
        if (points.isEmpty() || !W()) {
            return;
        }
        CameraUpdate M = M(this.f37003a, points, f8);
        if (j8 == 0) {
            this.f37004b.moveCamera(M);
        } else {
            this.f37004b.animateCamera(M, (int) j8, null);
        }
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public MarkerInfo f(int i8, Locatable newPosition, double d8, long j8) {
        Intrinsics.f(newPosition, "newPosition");
        final Marker marker = this.f37006d.get(Integer.valueOf(i8));
        if (marker == null) {
            return null;
        }
        marker.setRotation((float) d8);
        LatLng latLng = new LatLng(newPosition.a(), newPosition.b());
        if (j8 == 0) {
            marker.setPosition(latLng);
        } else {
            PointAnimator pointAnimator = this.f37014l;
            LatLng position = marker.getPosition();
            Intrinsics.e(position, "marker.position");
            pointAnimator.b(Q(position), newPosition, j8, new Function1<Locatable, Unit>() { // from class: eu.bolt.android.maps.google.v2.plugin.driver.GoogleV2DriverAppPlugin$updateMarker$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void b(Locatable it) {
                    LatLng d02;
                    Intrinsics.f(it, "it");
                    Marker marker2 = Marker.this;
                    d02 = this.d0(it);
                    marker2.setPosition(d02);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Locatable locatable) {
                    b(locatable);
                    return Unit.f50853a;
                }
            });
        }
        return new MarkerInfo(i8, newPosition, d8);
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public CircleInfo g(Locatable center, double d8, double d9, int i8, int i9) {
        Intrinsics.f(center, "center");
        int incrementAndGet = this.f37012j.incrementAndGet();
        Circle addCircle = this.f37004b.addCircle(new CircleOptions().center(new LatLng(center.a(), center.b())).radius(d8).strokeColor(i8).fillColor(i9).strokeWidth((float) d9));
        Intrinsics.e(addCircle, "map.addCircle(\n         …idth.toFloat())\n        )");
        this.f37007e.put(Integer.valueOf(incrementAndGet), addCircle);
        return new CircleInfo(incrementAndGet, center, d8);
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public MarkerInfo h(MarkerParams params) {
        Intrinsics.f(params, "params");
        return new MarkerInfo(N(K(params), new LatLng(params.g().a(), params.g().b()), params.h(), params.c(), params.i(), params.e()), params.g(), params.h());
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public MarkerInfo i(int i8, Locatable point, double d8, int i9) {
        Intrinsics.f(point, "point");
        BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(U(i8));
        Intrinsics.e(fromBitmap, "fromBitmap(bitmap)");
        return new MarkerInfo(O(this, fromBitmap, new LatLng(point.a(), point.b()), (float) d8, null, i9, false, 40, null), point, d8);
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public void j(int i8, int i9) {
        int i10;
        if (Build.VERSION.SDK_INT <= 22) {
            int max = Math.max(i8, i9);
            this.f37013k = ScreenBounds.b(this.f37013k, 0, max, 0, max, 5, null);
        } else {
            this.f37013k = ScreenBounds.b(this.f37013k, 0, i8, 0, i9, 5, null);
        }
        View invoke = this.f37005c.invoke();
        if (invoke != null) {
            i10 = invoke.getMeasuredHeight();
        } else {
            i10 = -1;
        }
        if (i8 + i9 > i10) {
            this.f37013k = ScreenBounds.b(this.f37013k, 0, 0, 0, 0, 5, null);
        }
        this.f37004b.setPadding(this.f37013k.d(), this.f37013k.f(), this.f37013k.e(), this.f37013k.c());
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public void k(Float f8, Float f9, long j8) {
        CameraPosition.Builder builder = CameraPosition.builder(this.f37004b.getCameraPosition());
        if (f8 != null) {
            builder.tilt(f8.floatValue());
        }
        if (f9 != null) {
            builder.bearing(f9.floatValue());
        }
        CameraPosition build = builder.build();
        Intrinsics.e(build, "builder(map.cameraPositi…   }\n            .build()");
        CameraUpdate newCameraPosition = CameraUpdateFactory.newCameraPosition(build);
        Intrinsics.e(newCameraPosition, "newCameraPosition(newCameraPosition)");
        if (j8 == 0) {
            this.f37004b.moveCamera(newCameraPosition);
        } else {
            this.f37004b.animateCamera(newCameraPosition, (int) j8, null);
        }
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public int l(List<? extends Locatable> points, double d8, int i8, int i9) {
        int v7;
        Intrinsics.f(points, "points");
        v7 = CollectionsKt__IterablesKt.v(points, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (Locatable locatable : points) {
            arrayList.add(d0(locatable));
        }
        int incrementAndGet = this.f37012j.incrementAndGet();
        Map<Integer, Polygon> map = this.f37011i;
        Integer valueOf = Integer.valueOf(incrementAndGet);
        Polygon addPolygon = this.f37004b.addPolygon(new PolygonOptions().addAll(arrayList).strokeWidth((float) d8).fillColor(i9).strokeColor(i8));
        Intrinsics.e(addPolygon, "map.addPolygon(PolygonOp…or(strokeColor)\n        )");
        map.put(valueOf, addPolygon);
        return incrementAndGet;
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public void m(int i8) {
        Polygon remove = this.f37011i.remove(Integer.valueOf(i8));
        if (remove != null) {
            remove.remove();
        }
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public void n(int i8) {
        Marker remove = this.f37006d.remove(Integer.valueOf(i8));
        if (remove != null) {
            remove.remove();
        }
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public void o(MapStyle style) {
        MapStyleOptions mapStyleOptions;
        Intrinsics.f(style, "style");
        int i8 = WhenMappings.f37015a[style.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                mapStyleOptions = MapStyleOptions.loadRawResourceStyle(this.f37003a, R$raw.dark_map);
                Intrinsics.e(mapStyleOptions, "loadRawResourceStyle(context, R.raw.dark_map)");
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            mapStyleOptions = new MapStyleOptions(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        this.f37004b.setMapStyle(mapStyleOptions);
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public MarkerInfo p(int i8, Locatable point, double d8, int i9) {
        Intrinsics.f(point, "point");
        BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(i8);
        Intrinsics.e(fromResource, "fromResource(resId)");
        return new MarkerInfo(O(this, fromResource, new LatLng(point.a(), point.b()), (float) d8, null, i9, false, 40, null), point, d8);
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public void q(int i8, float f8) {
        TileOverlay tileOverlay = this.f37010h.get(Integer.valueOf(i8));
        if (tileOverlay != null) {
            tileOverlay.setTransparency(f8);
        }
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public void r(boolean z7) {
        this.f37004b.getUiSettings().setCompassEnabled(z7);
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public int s(TileSource source, float f8) {
        Intrinsics.f(source, "source");
        int incrementAndGet = this.f37012j.incrementAndGet();
        TileOverlayOptions zIndex = new TileOverlayOptions().tileProvider(new GoogleTileProvider(source)).zIndex(f8);
        Intrinsics.e(zIndex, "TileOverlayOptions().til…eProvider).zIndex(zIndex)");
        TileOverlay addTileOverlay = this.f37004b.addTileOverlay(zIndex);
        this.f37010h.put(Integer.valueOf(incrementAndGet), addTileOverlay);
        return incrementAndGet;
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public void setTrafficEnabled(boolean z7) {
        this.f37004b.setTrafficEnabled(z7);
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public MarkerInfo t(View view, Locatable point, double d8, PointF anchor) {
        Intrinsics.f(view, "view");
        Intrinsics.f(point, "point");
        Intrinsics.f(anchor, "anchor");
        BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(V(view));
        Intrinsics.e(fromBitmap, "fromBitmap(bitmap)");
        return new MarkerInfo(O(this, fromBitmap, new LatLng(point.a(), point.b()), (float) d8, anchor, 0.0f, false, 32, null), point, d8);
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public void u(int i8) {
        TileOverlay remove = this.f37010h.remove(Integer.valueOf(i8));
        if (remove != null) {
            remove.remove();
        }
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public int v(List<? extends Locatable> points, double d8, int i8) {
        int v7;
        Intrinsics.f(points, "points");
        if (points.isEmpty()) {
            return -1;
        }
        int incrementAndGet = this.f37012j.incrementAndGet();
        v7 = CollectionsKt__IterablesKt.v(points, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (Locatable locatable : points) {
            arrayList.add(d0(locatable));
        }
        Map<Integer, Polyline> map = this.f37008f;
        Integer valueOf = Integer.valueOf(incrementAndGet);
        Polyline addPolyline = this.f37004b.addPolyline(new PolylineOptions().addAll(arrayList).width((float) d8).color(i8));
        Intrinsics.e(addPolyline, "map.addPolyline(Polyline…  .color(color)\n        )");
        map.put(valueOf, addPolyline);
        return incrementAndGet;
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public void w(final Function1<? super MapProjectionAndCamera, Unit> listener) {
        Intrinsics.f(listener, "listener");
        this.f37004b.setOnCameraMoveStartedListener(new GoogleMap.OnCameraMoveStartedListener() { // from class: h6.a
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener
            public final void onCameraMoveStarted(int i8) {
                GoogleV2DriverAppPlugin.b0(Function1.this, this, i8);
            }
        });
        this.f37004b.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() { // from class: h6.b
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveListener
            public final void onCameraMove() {
                GoogleV2DriverAppPlugin.c0(Function1.this, this);
            }
        });
        this.f37004b.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() { // from class: h6.c
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraIdleListener
            public final void onCameraIdle() {
                GoogleV2DriverAppPlugin.Z(Function1.this, this);
            }
        });
        this.f37004b.setOnCameraMoveCanceledListener(new GoogleMap.OnCameraMoveCanceledListener() { // from class: h6.d
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveCanceledListener
            public final void onCameraMoveCanceled() {
                GoogleV2DriverAppPlugin.a0(Function1.this, this);
            }
        });
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public void x(final Function1<? super MarkerInfo, Unit> listener) {
        Intrinsics.f(listener, "listener");
        this.f37004b.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() { // from class: h6.f
            @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
            public final boolean onMarkerClick(Marker marker) {
                boolean Y;
                Y = GoogleV2DriverAppPlugin.Y(Function1.this, marker);
                return Y;
            }
        });
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public void y(final Function1<? super Locatable, Unit> listener) {
        Intrinsics.f(listener, "listener");
        this.f37004b.setOnMapClickListener(new GoogleMap.OnMapClickListener() { // from class: h6.e
            @Override // com.google.android.gms.maps.GoogleMap.OnMapClickListener
            public final void onMapClick(LatLng latLng) {
                GoogleV2DriverAppPlugin.X(Function1.this, latLng);
            }
        });
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin
    public CircleInfo z(int i8, Locatable newCenter, double d8) {
        Intrinsics.f(newCenter, "newCenter");
        Circle circle = this.f37007e.get(Integer.valueOf(i8));
        if (circle == null) {
            return null;
        }
        circle.setCenter(new LatLng(newCenter.a(), newCenter.b()));
        circle.setRadius(d8);
        return new CircleInfo(i8, newCenter, d8);
    }
}
