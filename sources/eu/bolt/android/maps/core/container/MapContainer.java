package eu.bolt.android.maps.core.container;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import eu.bolt.android.maps.core.SafeTouchMapWrapper;
import eu.bolt.android.maps.core.plugin.driver.MapStyle;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapContainer.kt */
/* loaded from: classes5.dex */
public final class MapContainer extends SafeTouchMapWrapper {

    /* renamed from: f  reason: collision with root package name */
    private final MapPlaceholderHelper f36951f;

    /* renamed from: g  reason: collision with root package name */
    private long f36952g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MapContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    public /* synthetic */ MapContainer(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    public final void a() {
        this.f36951f.f();
    }

    public final long b() {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.f36952g);
    }

    public final void c(MapStyle mapStyle) {
        Intrinsics.f(mapStyle, "mapStyle");
        this.f36951f.h(mapStyle);
    }

    @Override // eu.bolt.android.maps.core.SafeTouchMapWrapper, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        Intrinsics.f(event, "event");
        if (event.getAction() == 2 || event.getAction() == 0 || event.getAction() == 5) {
            this.f36952g = System.currentTimeMillis();
        }
        return super.dispatchTouchEvent(event);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapContainer(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f36951f = new MapPlaceholderHelper(this);
        this.f36952g = -1L;
        if (isInEditMode()) {
            c(MapStyle.DARK);
        }
    }
}
