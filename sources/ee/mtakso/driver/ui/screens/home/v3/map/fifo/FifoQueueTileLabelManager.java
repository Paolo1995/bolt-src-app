package ee.mtakso.driver.ui.screens.home.v3.map.fifo;

import android.graphics.drawable.Drawable;
import android.view.View;
import ee.mtakso.driver.service.modules.tile.TileUtils;
import ee.mtakso.driver.ui.screens.home.v3.map.fifo.FifoQueueTileLabelState;
import ee.mtakso.driver.ui.screens.order.MarkerParamsFactory;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.image.DefaultImageCallback;
import ee.mtakso.driver.uikit.utils.image.ImageManager;
import ee.mtakso.driver.uikit.utils.image.ImageRequest;
import ee.mtakso.driver.uikit.utils.image.ImageSize;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.maps.core.Locatable;
import eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin;
import eu.bolt.android.maps.core.plugin.driver.MarkerInfo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FifoQueueTileLabelManager.kt */
/* loaded from: classes3.dex */
public final class FifoQueueTileLabelManager {

    /* renamed from: a  reason: collision with root package name */
    private final MarkerParamsFactory f30172a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverAppPlugin f30173b;

    /* renamed from: c  reason: collision with root package name */
    private final HtmlEngine f30174c;

    /* renamed from: d  reason: collision with root package name */
    private final View f30175d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, FifoQueueTileLabelState> f30176e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f30177f;

    public FifoQueueTileLabelManager(MarkerParamsFactory markerParamsFactory, DriverAppPlugin mapController, HtmlEngine htmlEngine, View view) {
        Intrinsics.f(markerParamsFactory, "markerParamsFactory");
        Intrinsics.f(mapController, "mapController");
        Intrinsics.f(htmlEngine, "htmlEngine");
        Intrinsics.f(view, "view");
        this.f30172a = markerParamsFactory;
        this.f30173b = mapController;
        this.f30174c = htmlEngine;
        this.f30175d = view;
        this.f30176e = new LinkedHashMap();
    }

    private final void d(FifoQueueTileLabelState.Pending pending) {
        final FifoQueueTileLabel a8 = pending.a();
        this.f30176e.put(a8.a(), new FifoQueueTileLabelState.Drawing(a8));
        String c8 = a8.c();
        final Locatable d8 = TileUtils.f25352a.d(a8.g(), a8.h(), a8.e(), a8.f());
        final CharSequence a9 = this.f30174c.a(a8.d());
        final Integer b8 = a8.b();
        if (c8 == null) {
            f(this, a8.a(), d8, a9, b8, null, 16, null);
        } else {
            ImageManager.Companion.b(ImageManager.f36075b, null, 1, null).b(new ImageRequest(c8, new ImageSize(Dimens.c(24), Dimens.c(24)), null, null, 12, null), this.f30175d, new DefaultImageCallback<View>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.fifo.FifoQueueTileLabelManager$drawLabel$1
                @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
                /* renamed from: e */
                public void b(View view, Drawable drawable, Exception exc) {
                    Intrinsics.f(view, "view");
                    FifoQueueTileLabelManager.f(FifoQueueTileLabelManager.this, a8.a(), d8, a9, b8, null, 16, null);
                }

                @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
                /* renamed from: f */
                public void d(View view, Drawable drawable) {
                    DefaultImageCallback.DefaultImpls.a(this, view, drawable);
                }

                @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
                /* renamed from: g */
                public void a(View view, Drawable drawable) {
                    Intrinsics.f(view, "view");
                    Intrinsics.f(drawable, "drawable");
                    FifoQueueTileLabelManager.this.e(a8.a(), d8, a9, b8, drawable);
                }

                @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
                /* renamed from: h */
                public void c(View view, Drawable drawable) {
                    DefaultImageCallback.DefaultImpls.b(this, view, drawable);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(String str, Locatable locatable, CharSequence charSequence, Integer num, Drawable drawable) {
        FifoQueueTileLabelState fifoQueueTileLabelState = this.f30176e.get(str);
        if (fifoQueueTileLabelState == null || !(fifoQueueTileLabelState instanceof FifoQueueTileLabelState.Drawing)) {
            return;
        }
        this.f30176e.put(str, new FifoQueueTileLabelState.Drawn(fifoQueueTileLabelState.a(), this.f30173b.h(this.f30172a.f(locatable, charSequence, drawable, num))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(FifoQueueTileLabelManager fifoQueueTileLabelManager, String str, Locatable locatable, CharSequence charSequence, Integer num, Drawable drawable, int i8, Object obj) {
        if ((i8 & 16) != 0) {
            drawable = null;
        }
        fifoQueueTileLabelManager.e(str, locatable, charSequence, num, drawable);
    }

    private final void g() {
        for (String str : this.f30176e.keySet()) {
            FifoQueueTileLabelState fifoQueueTileLabelState = this.f30176e.get(str);
            if (fifoQueueTileLabelState instanceof FifoQueueTileLabelState.Drawn) {
                FifoQueueTileLabelState.Drawn drawn = (FifoQueueTileLabelState.Drawn) fifoQueueTileLabelState;
                this.f30173b.n(drawn.b().a());
                this.f30176e.put(str, new FifoQueueTileLabelState.Pending(drawn.a()));
            } else if (fifoQueueTileLabelState instanceof FifoQueueTileLabelState.Drawing) {
                this.f30176e.put(str, new FifoQueueTileLabelState.Pending(((FifoQueueTileLabelState.Drawing) fifoQueueTileLabelState).a()));
            }
        }
    }

    private final void j() {
        for (String str : this.f30176e.keySet()) {
            FifoQueueTileLabelState fifoQueueTileLabelState = this.f30176e.get(str);
            if (fifoQueueTileLabelState instanceof FifoQueueTileLabelState.Pending) {
                d((FifoQueueTileLabelState.Pending) fifoQueueTileLabelState);
            }
        }
    }

    public final void b(FifoQueueTileLabel label) {
        Intrinsics.f(label, "label");
        if (this.f30176e.containsKey(label.a())) {
            return;
        }
        this.f30176e.put(label.a(), new FifoQueueTileLabelState.Pending(label));
        if (this.f30177f) {
            j();
        }
    }

    public final void c() {
        FifoQueueTileLabelState.Drawn drawn;
        MarkerInfo b8;
        for (FifoQueueTileLabelState fifoQueueTileLabelState : this.f30176e.values()) {
            if (fifoQueueTileLabelState instanceof FifoQueueTileLabelState.Drawn) {
                drawn = (FifoQueueTileLabelState.Drawn) fifoQueueTileLabelState;
            } else {
                drawn = null;
            }
            if (drawn != null && (b8 = drawn.b()) != null) {
                this.f30173b.n(b8.a());
            }
        }
        this.f30176e.clear();
    }

    public final void h(MarkerInfo markerInfo, Function1<? super FifoQueueTileLabel, Unit> onLabelClick) {
        Object obj;
        FifoQueueTileLabelState.Drawn drawn;
        Intrinsics.f(markerInfo, "markerInfo");
        Intrinsics.f(onLabelClick, "onLabelClick");
        Iterator<T> it = this.f30176e.values().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            FifoQueueTileLabelState fifoQueueTileLabelState = (FifoQueueTileLabelState) next;
            if (fifoQueueTileLabelState instanceof FifoQueueTileLabelState.Drawn) {
                drawn = (FifoQueueTileLabelState.Drawn) fifoQueueTileLabelState;
            } else {
                drawn = null;
            }
            if (drawn != null) {
                obj = drawn.b();
            }
            if (Intrinsics.a(obj, markerInfo)) {
                obj = next;
                break;
            }
        }
        FifoQueueTileLabelState fifoQueueTileLabelState2 = (FifoQueueTileLabelState) obj;
        if (fifoQueueTileLabelState2 == null) {
            return;
        }
        onLabelClick.invoke(fifoQueueTileLabelState2.a());
    }

    public final void i(boolean z7) {
        this.f30177f = z7;
        if (z7) {
            j();
        } else {
            g();
        }
    }
}
