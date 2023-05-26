package eu.bolt.android.maps.core.container;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import eu.bolt.android.maps.core.SafeTouchMapWrapper;
import eu.bolt.android.maps.core.plugin.driver.MapStyle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapViewContainer.kt */
/* loaded from: classes5.dex */
public abstract class MapViewContainer extends SafeTouchMapWrapper {

    /* renamed from: f  reason: collision with root package name */
    private final MapPlaceholderHelper f36957f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapViewContainer(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f36957f = new MapPlaceholderHelper(this);
    }

    private static /* synthetic */ void getMapContainerHelper$annotations() {
    }

    public final void a() {
        this.f36957f.f();
    }

    public abstract void b(Bundle bundle);

    public final void c(MapStyle mapStyle) {
        Intrinsics.f(mapStyle, "mapStyle");
        this.f36957f.h(mapStyle);
    }
}
