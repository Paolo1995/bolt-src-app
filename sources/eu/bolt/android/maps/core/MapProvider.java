package eu.bolt.android.maps.core;

import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: MapProvider.kt */
/* loaded from: classes5.dex */
public interface MapProvider {
    Fragment a(Function1<? super MapController, Unit> function1);

    View b(boolean z7, Function1<? super MapController, Unit> function1);
}
