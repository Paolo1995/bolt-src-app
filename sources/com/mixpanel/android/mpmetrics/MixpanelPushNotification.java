package com.mixpanel.android.mpmetrics;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import com.mixpanel.android.mpmetrics.MixpanelNotificationData;
import com.mixpanel.android.mpmetrics.ResourceReader;
import com.mixpanel.android.util.ImageStore;
import com.mixpanel.android.util.MPLog;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.jctools.util.Pow2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes3.dex */
public class MixpanelPushNotification {

    /* renamed from: a  reason: collision with root package name */
    private final String f19309a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f19310b;

    /* renamed from: c  reason: collision with root package name */
    private Context f19311c;

    /* renamed from: d  reason: collision with root package name */
    private ResourceIds f19312d;

    /* renamed from: e  reason: collision with root package name */
    private Notification.Builder f19313e;

    /* renamed from: f  reason: collision with root package name */
    private long f19314f;

    /* renamed from: g  reason: collision with root package name */
    private MixpanelNotificationData f19315g;

    /* renamed from: h  reason: collision with root package name */
    private int f19316h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f19317i;

    public MixpanelPushNotification(Context context) {
        this(context, new Notification.Builder(context), System.currentTimeMillis());
    }

    private Date H(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
            if (str.equals("yyyy-MM-dd'T'HH:mm:ss'Z'")) {
                simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
            }
            return simpleDateFormat.parse(str2);
        } catch (ParseException unused) {
            return null;
        }
    }

    protected void A() {
        if (this.f19315g.f() != null && this.f19315g.f().startsWith("http")) {
            try {
                Bitmap l8 = l(this.f19315g.f());
                if (l8 == null) {
                    K(this.f19315g.j());
                } else {
                    J(l8);
                }
                return;
            } catch (Exception unused) {
                K(this.f19315g.j());
                return;
            }
        }
        K(this.f19315g.j());
    }

    protected void B() {
        if (this.f19315g.i() != null) {
            if (this.f19312d.b(this.f19315g.i())) {
                this.f19313e.setLargeIcon(k(this.f19312d.c(this.f19315g.i())));
            } else if (this.f19315g.i().startsWith("http")) {
                Bitmap l8 = l(this.f19315g.i());
                if (l8 != null) {
                    this.f19313e.setLargeIcon(l8);
                }
            } else {
                MPLog.a("MixpanelAPI.MixpanelPushNotification", "large icon data was sent but did match a resource name or a valid url: " + this.f19315g.i());
            }
        }
    }

    protected void C() {
        if (this.f19315g.a() > 0) {
            this.f19313e.setNumber(this.f19315g.a());
        }
    }

    protected void D() {
        if (this.f19315g.s() != -1) {
            this.f19313e.setSmallIcon(this.f19315g.s());
        } else {
            this.f19313e.setSmallIcon(this.f19315g.h());
        }
    }

    protected void E() {
        if (this.f19315g.m() != null) {
            this.f19313e.setSubText(this.f19315g.m());
        }
    }

    protected void F() {
        this.f19313e.setShowWhen(true);
        if (this.f19315g.p() == null) {
            this.f19313e.setWhen(this.f19314f);
            return;
        }
        Date H = H("yyyy-MM-dd'T'HH:mm:ssz", this.f19315g.p());
        if (H == null) {
            H = H("yyyy-MM-dd'T'HH:mm:ss'Z'", this.f19315g.p());
        }
        if (H == null) {
            H = H("yyyy-MM-dd'T'HH:mm:ss", this.f19315g.p());
        }
        if (H == null) {
            MPLog.a("MixpanelAPI.MixpanelPushNotification", "Unable to parse date string into datetime: " + this.f19315g.p());
            return;
        }
        this.f19313e.setWhen(H.getTime());
    }

    protected void G() {
        this.f19313e.setVisibility(this.f19315g.r());
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x00ed, code lost:
        if (r4 < 0) goto L83;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0149 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void I(android.content.Intent r26) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MixpanelPushNotification.I(android.content.Intent):void");
    }

    protected void J(Bitmap bitmap) {
        this.f19313e.setStyle(new Notification.BigPictureStyle().bigPicture(bitmap));
    }

    protected void K(String str) {
        this.f19313e.setStyle(new Notification.BigTextStyle().bigText(str));
    }

    protected void L() {
        String c8 = this.f19315g.c();
        String k8 = this.f19315g.k();
        String g8 = this.f19315g.g();
        if (c8 != null && k8 != null) {
            MixpanelAPI.X(this.f19311c, Integer.valueOf(c8), Integer.valueOf(k8), m(), g8, "$push_notification_received", new JSONObject());
            MixpanelAPI B = MixpanelAPI.B(this.f19311c, g8);
            if (B != null && B.I()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("message_type", "push");
                } catch (JSONException unused) {
                }
                MixpanelAPI.X(this.f19311c, Integer.valueOf(c8), Integer.valueOf(k8), m(), g8, "$campaign_received", jSONObject);
            }
        }
    }

    protected Bundle a(MixpanelNotificationData.PushTapAction pushTapAction) {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("mp_tap_target", "notification");
        bundle.putCharSequence("mp_tap_action_type", pushTapAction.a().toString());
        bundle.putCharSequence("mp_tap_action_uri", pushTapAction.b());
        bundle.putCharSequence("mp_message_id", this.f19315g.k());
        bundle.putCharSequence("mp_campaign_id", this.f19315g.c());
        bundle.putInt("mp_notification_id", this.f19316h);
        bundle.putBoolean("mp_is_sticky", this.f19315g.u());
        bundle.putCharSequence("mp_tag", this.f19315g.n());
        bundle.putCharSequence("mp_canonical_notification_id", m());
        bundle.putCharSequence("mp", this.f19315g.g());
        return bundle;
    }

    protected Bundle b(MixpanelNotificationData.PushTapAction pushTapAction, String str, CharSequence charSequence) {
        Bundle a8 = a(pushTapAction);
        a8.putCharSequence("mp_tap_target", "button");
        a8.putCharSequence("mp_button_id", str);
        a8.putCharSequence("mp_button_label", charSequence);
        return a8;
    }

    protected List<MixpanelNotificationData.MixpanelNotificationButtonData> c(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i8);
                    String string = jSONObject.getString("lbl");
                    MixpanelNotificationData.PushTapAction e8 = e(jSONObject.getString("ontap"));
                    String string2 = jSONObject.getString(Name.MARK);
                    if (e8 != null && string != null && string2 != null) {
                        arrayList.add(new MixpanelNotificationData.MixpanelNotificationButtonData(string, e8, string2));
                    }
                    MPLog.a("MixpanelAPI.MixpanelPushNotification", "Null button data received. No buttons will be rendered.");
                }
            } catch (JSONException e9) {
                MPLog.d("MixpanelAPI.MixpanelPushNotification", "Exception parsing buttons payload", e9);
            }
        }
        return arrayList;
    }

    protected void d() {
        String o8;
        PendingIntent activity = PendingIntent.getActivity(this.f19311c, this.f19310b, u(this.f19315g.l()), 268435456);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f19311c, 0, r(), 0);
        Notification.Builder contentText = this.f19313e.setContentTitle(this.f19315g.q()).setContentText(this.f19315g.j());
        if (this.f19315g.o() == null) {
            o8 = this.f19315g.j();
        } else {
            o8 = this.f19315g.o();
        }
        contentText.setTicker(o8).setContentIntent(activity).setDeleteIntent(broadcast);
        D();
        B();
        A();
        z();
        x();
        y();
        C();
        F();
        G();
        E();
    }

    protected MixpanelNotificationData.PushTapAction e(String str) {
        MixpanelNotificationData.PushTapAction pushTapAction;
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            MixpanelNotificationData.PushTapActionType pushTapActionType = MixpanelNotificationData.PushTapActionType.HOMESCREEN;
            if (!string.equals(pushTapActionType.toString())) {
                pushTapAction = new MixpanelNotificationData.PushTapAction(MixpanelNotificationData.PushTapActionType.a(string), jSONObject.getString("uri"));
            } else {
                pushTapAction = new MixpanelNotificationData.PushTapAction(MixpanelNotificationData.PushTapActionType.a(string));
            }
            if (pushTapAction.a().toString().equals(MixpanelNotificationData.PushTapActionType.ERROR.toString())) {
                this.f19317i = true;
                return new MixpanelNotificationData.PushTapAction(pushTapActionType);
            }
            return pushTapAction;
        } catch (JSONException unused) {
            MPLog.a("MixpanelAPI.MixpanelPushNotification", "Exception occurred while parsing ontap");
            return null;
        }
    }

    protected MixpanelNotificationData.PushTapAction f(String str) {
        if (str != null) {
            return new MixpanelNotificationData.PushTapAction(MixpanelNotificationData.PushTapActionType.URL_IN_BROWSER, str);
        }
        return null;
    }

    @TargetApi(20)
    protected Notification.Action g(CharSequence charSequence, MixpanelNotificationData.PushTapAction pushTapAction, String str, int i8) {
        return new Notification.Action.Builder(0, charSequence, h(pushTapAction, str, charSequence, i8)).build();
    }

    protected PendingIntent h(MixpanelNotificationData.PushTapAction pushTapAction, String str, CharSequence charSequence, int i8) {
        return PendingIntent.getActivity(this.f19311c, this.f19310b + i8, v(pushTapAction, str, charSequence), 268435456);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Notification i(Intent intent) {
        I(intent);
        MixpanelNotificationData mixpanelNotificationData = this.f19315g;
        if (mixpanelNotificationData == null) {
            return null;
        }
        if (mixpanelNotificationData.t()) {
            MPLog.a("MixpanelAPI.MixpanelPushNotification", "Notification will not be shown because 'mp_silent = true'");
            return null;
        } else if (this.f19315g.j() == null) {
            MPLog.a("MixpanelAPI.MixpanelPushNotification", "Notification will not be shown because 'mp_message' was null");
            return null;
        } else if (this.f19315g.j().equals("")) {
            MPLog.a("MixpanelAPI.MixpanelPushNotification", "Notification will not be shown because 'mp_message' was empty");
            return null;
        } else {
            d();
            Notification build = this.f19313e.build();
            if (!this.f19315g.u()) {
                build.flags |= 16;
            }
            return build;
        }
    }

    protected ApplicationInfo j() {
        try {
            return this.f19311c.getPackageManager().getApplicationInfo(this.f19311c.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    Bitmap k(int i8) {
        return BitmapFactory.decodeResource(this.f19311c.getResources(), i8);
    }

    Bitmap l(String str) {
        try {
            return new ImageStore(this.f19311c, "MixpanelPushNotification").f(str);
        } catch (ImageStore.CantGetImageException unused) {
            return null;
        }
    }

    protected String m() {
        if (this.f19315g.n() != null) {
            return this.f19315g.n();
        }
        return Integer.toString(this.f19316h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MixpanelNotificationData n() {
        return this.f19315g;
    }

    protected int o() {
        ApplicationInfo j8 = j();
        if (j8 != null) {
            return j8.icon;
        }
        return 17301651;
    }

    protected MixpanelNotificationData.PushTapAction p() {
        return new MixpanelNotificationData.PushTapAction(MixpanelNotificationData.PushTapActionType.HOMESCREEN);
    }

    protected CharSequence q() {
        ApplicationInfo j8 = j();
        if (j8 != null) {
            return this.f19311c.getPackageManager().getApplicationLabel(j8);
        }
        return "A message for you";
    }

    protected Intent r() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("mp_message_id", this.f19315g.k());
        bundle.putCharSequence("mp_campaign_id", this.f19315g.c());
        bundle.putCharSequence("mp_canonical_notification_id", m());
        bundle.putCharSequence("mp", this.f19315g.g());
        return new Intent().setAction("com.mixpanel.push_notification_dismissed").setClass(this.f19311c, MixpanelPushNotificationDismissedReceiver.class).putExtras(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int s() {
        return this.f19316h;
    }

    ResourceIds t(Context context) {
        String B = MPConfig.s(context).B();
        if (B == null) {
            B = context.getPackageName();
        }
        return new ResourceReader.Drawables(B, context);
    }

    protected Intent u(MixpanelNotificationData.PushTapAction pushTapAction) {
        return new Intent().setAction("com.mixpanel.push_notification_tap").setClass(this.f19311c, MixpanelNotificationRouteActivity.class).putExtras(a(pushTapAction)).setFlags(Pow2.MAX_POW2);
    }

    protected Intent v(MixpanelNotificationData.PushTapAction pushTapAction, String str, CharSequence charSequence) {
        return new Intent().setClass(this.f19311c, MixpanelNotificationRouteActivity.class).putExtras(b(pushTapAction, str, charSequence)).setFlags(Pow2.MAX_POW2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean w() {
        if (this.f19315g != null && !this.f19317i) {
            return true;
        }
        return false;
    }

    protected void x() {
        int i8 = 0;
        while (i8 < this.f19315g.b().size()) {
            MixpanelNotificationData.MixpanelNotificationButtonData mixpanelNotificationButtonData = this.f19315g.b().get(i8);
            i8++;
            this.f19313e.addAction(g(mixpanelNotificationButtonData.b(), mixpanelNotificationButtonData.c(), mixpanelNotificationButtonData.a(), i8));
        }
    }

    protected void y() {
        String d8;
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) this.f19311c.getSystemService("notification");
            if (this.f19315g.d() == null) {
                d8 = MPConfig.s(this.f19311c).v();
            } else {
                d8 = this.f19315g.d();
            }
            notificationManager.createNotificationChannel(new NotificationChannel(d8, MPConfig.s(this.f19311c).x(), 3));
            this.f19313e.setChannelId(d8);
            return;
        }
        this.f19313e.setDefaults(MPConfig.s(this.f19311c).y());
    }

    protected void z() {
        if (this.f19315g.e() != -1) {
            this.f19313e.setColor(this.f19315g.e());
        }
    }

    public MixpanelPushNotification(Context context, Notification.Builder builder, long j8) {
        this.f19309a = "MixpanelAPI.MixpanelPushNotification";
        this.f19317i = false;
        this.f19311c = context;
        this.f19313e = builder;
        this.f19312d = t(context);
        this.f19314f = j8;
        int i8 = (int) j8;
        this.f19310b = i8;
        this.f19316h = i8;
    }
}
