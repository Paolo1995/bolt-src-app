package ee.mtakso.driver.ui.screens.order.v2.order;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.route_sharing.RouteSharing;
import ee.mtakso.driver.network.client.route_sharing.RouteSharingClient;
import eu.bolt.driver.core.ui.translation.TranslatedResources;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RouteSharingInteractor.kt */
/* loaded from: classes3.dex */
public final class RouteSharingInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final RouteSharingClient f32322a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f32323b;

    /* renamed from: c  reason: collision with root package name */
    private final TranslatedResources f32324c;

    @Inject
    public RouteSharingInteractor(RouteSharingClient routeSharingClient, Context context) {
        Intrinsics.f(routeSharingClient, "routeSharingClient");
        Intrinsics.f(context, "context");
        this.f32322a = routeSharingClient;
        this.f32323b = context;
        Resources resources = context.getResources();
        Intrinsics.e(resources, "context.resources");
        this.f32324c = new TranslatedResources(resources);
    }

    public final Single<RouteSharing> a(long j8, long j9) {
        return this.f32322a.b(j8, j9);
    }

    public final void b(String url) {
        Intrinsics.f(url, "url");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", this.f32324c.getString(R.string.share_ride_details_message, url));
        intent.setType("text/plain");
        Intent createChooser = Intent.createChooser(intent, this.f32324c.getString(R.string.share_ride_details));
        createChooser.setFlags(268435456);
        this.f32323b.startActivity(createChooser);
    }
}
