package ee.mtakso.driver.ui.screens.order.v2.map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.components.views.TopSnackBar;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TopNotificationsDelegate.kt */
/* loaded from: classes3.dex */
public final class TopNotificationsDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final Context f32159a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewGroup f32160b;

    public TopNotificationsDelegate(Context context, ViewGroup root) {
        Intrinsics.f(context, "context");
        Intrinsics.f(root, "root");
        this.f32159a = context;
        this.f32160b = root;
    }

    private final TopSnackBar a(NotificationModel notificationModel) {
        boolean z7;
        View view = LayoutInflater.from(this.f32159a).inflate(R.layout.view_popup_notification, this.f32160b, false);
        ((TextView) view.findViewById(R.id.cc)).setText(notificationModel.h());
        ((TextView) view.findViewById(R.id.f19830k7)).setText(notificationModel.e());
        if (notificationModel.d() != null) {
            ((ImageView) view.findViewById(R.id.Q5)).setImageResource(notificationModel.d().intValue());
        }
        if (notificationModel.a() != null) {
            ((ImageView) view.findViewById(R.id.Q5)).setBackgroundResource(notificationModel.a().intValue());
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.Q5);
        Intrinsics.e(imageView, "view.icon");
        if (notificationModel.d() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(imageView, z7, 0, 2, null);
        TopSnackBar.Companion companion = TopSnackBar.G;
        ViewGroup viewGroup = this.f32160b;
        int c8 = notificationModel.c();
        boolean b8 = notificationModel.b();
        boolean g8 = notificationModel.g();
        Function0<Unit> f8 = notificationModel.f();
        Intrinsics.e(view, "view");
        TopSnackBar b9 = companion.b(viewGroup, view, b8, g8, c8, f8);
        b9.e0();
        return b9;
    }

    public final TopSnackBar b(NotificationModel notification) {
        Intrinsics.f(notification, "notification");
        return a(notification);
    }
}
