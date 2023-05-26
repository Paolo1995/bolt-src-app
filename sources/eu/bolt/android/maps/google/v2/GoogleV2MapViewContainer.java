package eu.bolt.android.maps.google.v2;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.gms.maps.MapView;
import eu.bolt.android.maps.core.container.MapViewContainer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoogleV2MapViewContainer.kt */
/* loaded from: classes5.dex */
public final class GoogleV2MapViewContainer extends MapViewContainer {

    /* renamed from: g  reason: collision with root package name */
    private final MapView f37001g;

    public /* synthetic */ GoogleV2MapViewContainer(Context context, AttributeSet attributeSet, int i8, MapView mapView, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8, mapView);
    }

    @Override // eu.bolt.android.maps.core.container.MapViewContainer
    public void b(Bundle bundle) {
        this.f37001g.onCreate(bundle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleV2MapViewContainer(Context context, AttributeSet attributeSet, int i8, MapView mapView) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        Intrinsics.f(mapView, "mapView");
        this.f37001g = mapView;
        addView(mapView, new FrameLayout.LayoutParams(-1, -1));
    }
}
