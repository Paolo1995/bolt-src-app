package eu.bolt.android.maps.google.v2;

import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import eu.bolt.android.maps.core.MapController;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.android.maps.core.plugin.PluginFactory;
import eu.bolt.android.maps.google.v2.GoogleV2MapProvider;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoogleV2MapProvider.kt */
/* loaded from: classes5.dex */
public final class GoogleV2MapProvider implements MapProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Context f36997a;

    /* renamed from: b  reason: collision with root package name */
    private final PluginFactory<GoogleMap> f36998b;

    public GoogleV2MapProvider(Context context, PluginFactory<GoogleMap> pluginFactory) {
        Intrinsics.f(context, "context");
        Intrinsics.f(pluginFactory, "pluginFactory");
        this.f36997a = context;
        this.f36998b = pluginFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function1 mapCallback, GoogleV2MapProvider this$0, final SupportMapFragment fragment, GoogleMap it) {
        Intrinsics.f(mapCallback, "$mapCallback");
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(fragment, "$fragment");
        Intrinsics.f(it, "it");
        int i8 = Build.VERSION.SDK_INT;
        if (i8 == 21 || i8 == 22) {
            it.setMaxZoomPreference(16.0f);
        }
        mapCallback.invoke(new MapController(this$0.f36998b.a(it, new Function0<View>() { // from class: eu.bolt.android.maps.google.v2.GoogleV2MapProvider$createMapFragment$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final View invoke() {
                return SupportMapFragment.this.getView();
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 mapCallback, GoogleV2MapProvider this$0, final MapView view, GoogleMap it) {
        Intrinsics.f(mapCallback, "$mapCallback");
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(view, "$view");
        Intrinsics.f(it, "it");
        mapCallback.invoke(new MapController(this$0.f36998b.a(it, new Function0<View>() { // from class: eu.bolt.android.maps.google.v2.GoogleV2MapProvider$createMapView$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final View invoke() {
                return MapView.this;
            }
        })));
    }

    @Override // eu.bolt.android.maps.core.MapProvider
    public Fragment a(final Function1<? super MapController, Unit> mapCallback) {
        Intrinsics.f(mapCallback, "mapCallback");
        final SupportMapFragment supportMapFragment = new SupportMapFragment();
        supportMapFragment.getMapAsync(new OnMapReadyCallback() { // from class: g6.a
            @Override // com.google.android.gms.maps.OnMapReadyCallback
            public final void onMapReady(GoogleMap googleMap) {
                GoogleV2MapProvider.e(Function1.this, this, supportMapFragment, googleMap);
            }
        });
        return supportMapFragment;
    }

    @Override // eu.bolt.android.maps.core.MapProvider
    public View b(boolean z7, final Function1<? super MapController, Unit> mapCallback) {
        Intrinsics.f(mapCallback, "mapCallback");
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (z7) {
            googleMapOptions.liteMode(z7);
            googleMapOptions.mapType(1);
        }
        final MapView mapView = new MapView(this.f36997a, googleMapOptions);
        mapView.setClickable(!z7);
        mapView.getMapAsync(new OnMapReadyCallback() { // from class: g6.b
            @Override // com.google.android.gms.maps.OnMapReadyCallback
            public final void onMapReady(GoogleMap googleMap) {
                GoogleV2MapProvider.f(Function1.this, this, mapView, googleMap);
            }
        });
        return new GoogleV2MapViewContainer(this.f36997a, null, 0, mapView, 6, null);
    }
}
