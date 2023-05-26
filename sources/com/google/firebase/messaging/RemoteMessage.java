package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.messaging.Constants;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
@SafeParcelable.Class(creator = "RemoteMessageCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes3.dex */
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new RemoteMessageCreator();
    @SafeParcelable.Field(id = 2)

    /* renamed from: f  reason: collision with root package name */
    Bundle f16536f;

    /* renamed from: g  reason: collision with root package name */
    private Map<String, String> f16537g;

    /* renamed from: h  reason: collision with root package name */
    private Notification f16538h;

    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* loaded from: classes3.dex */
    public static class Notification {

        /* renamed from: a  reason: collision with root package name */
        private final String f16539a;

        /* renamed from: b  reason: collision with root package name */
        private final String f16540b;

        /* renamed from: c  reason: collision with root package name */
        private final String[] f16541c;

        /* renamed from: d  reason: collision with root package name */
        private final String f16542d;

        /* renamed from: e  reason: collision with root package name */
        private final String f16543e;

        /* renamed from: f  reason: collision with root package name */
        private final String[] f16544f;

        /* renamed from: g  reason: collision with root package name */
        private final String f16545g;

        /* renamed from: h  reason: collision with root package name */
        private final String f16546h;

        /* renamed from: i  reason: collision with root package name */
        private final String f16547i;

        /* renamed from: j  reason: collision with root package name */
        private final String f16548j;

        /* renamed from: k  reason: collision with root package name */
        private final String f16549k;

        /* renamed from: l  reason: collision with root package name */
        private final String f16550l;

        /* renamed from: m  reason: collision with root package name */
        private final String f16551m;

        /* renamed from: n  reason: collision with root package name */
        private final Uri f16552n;

        /* renamed from: o  reason: collision with root package name */
        private final String f16553o;

        /* renamed from: p  reason: collision with root package name */
        private final Integer f16554p;

        /* renamed from: q  reason: collision with root package name */
        private final Integer f16555q;

        /* renamed from: r  reason: collision with root package name */
        private final Integer f16556r;

        /* renamed from: s  reason: collision with root package name */
        private final int[] f16557s;

        /* renamed from: t  reason: collision with root package name */
        private final Long f16558t;

        /* renamed from: u  reason: collision with root package name */
        private final boolean f16559u;

        /* renamed from: v  reason: collision with root package name */
        private final boolean f16560v;

        /* renamed from: w  reason: collision with root package name */
        private final boolean f16561w;

        /* renamed from: x  reason: collision with root package name */
        private final boolean f16562x;

        /* renamed from: y  reason: collision with root package name */
        private final boolean f16563y;

        /* renamed from: z  reason: collision with root package name */
        private final long[] f16564z;

        private Notification(NotificationParams notificationParams) {
            this.f16539a = notificationParams.p("gcm.n.title");
            this.f16540b = notificationParams.h("gcm.n.title");
            this.f16541c = b(notificationParams, "gcm.n.title");
            this.f16542d = notificationParams.p("gcm.n.body");
            this.f16543e = notificationParams.h("gcm.n.body");
            this.f16544f = b(notificationParams, "gcm.n.body");
            this.f16545g = notificationParams.p("gcm.n.icon");
            this.f16547i = notificationParams.o();
            this.f16548j = notificationParams.p("gcm.n.tag");
            this.f16549k = notificationParams.p("gcm.n.color");
            this.f16550l = notificationParams.p("gcm.n.click_action");
            this.f16551m = notificationParams.p("gcm.n.android_channel_id");
            this.f16552n = notificationParams.f();
            this.f16546h = notificationParams.p("gcm.n.image");
            this.f16553o = notificationParams.p("gcm.n.ticker");
            this.f16554p = notificationParams.b("gcm.n.notification_priority");
            this.f16555q = notificationParams.b("gcm.n.visibility");
            this.f16556r = notificationParams.b("gcm.n.notification_count");
            this.f16559u = notificationParams.a("gcm.n.sticky");
            this.f16560v = notificationParams.a("gcm.n.local_only");
            this.f16561w = notificationParams.a("gcm.n.default_sound");
            this.f16562x = notificationParams.a("gcm.n.default_vibrate_timings");
            this.f16563y = notificationParams.a("gcm.n.default_light_settings");
            this.f16558t = notificationParams.j("gcm.n.event_time");
            this.f16557s = notificationParams.e();
            this.f16564z = notificationParams.q();
        }

        private static String[] b(NotificationParams notificationParams, String str) {
            Object[] g8 = notificationParams.g(str);
            if (g8 == null) {
                return null;
            }
            String[] strArr = new String[g8.length];
            for (int i8 = 0; i8 < g8.length; i8++) {
                strArr[i8] = String.valueOf(g8[i8]);
            }
            return strArr;
        }

        public String a() {
            return this.f16542d;
        }

        public String c() {
            return this.f16539a;
        }
    }

    @SafeParcelable.Constructor
    public RemoteMessage(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.f16536f = bundle;
    }

    public Notification g() {
        if (this.f16538h == null && NotificationParams.t(this.f16536f)) {
            this.f16538h = new Notification(new NotificationParams(this.f16536f));
        }
        return this.f16538h;
    }

    @NonNull
    public Map<String, String> getData() {
        if (this.f16537g == null) {
            this.f16537g = Constants.MessagePayloadKeys.a(this.f16536f);
        }
        return this.f16537g;
    }

    @KeepForSdk
    public Intent l1() {
        Intent intent = new Intent();
        intent.putExtras(this.f16536f);
        return intent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i8) {
        RemoteMessageCreator.c(this, parcel, i8);
    }
}
