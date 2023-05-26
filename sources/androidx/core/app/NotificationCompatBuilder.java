package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5630a;

    /* renamed from: b  reason: collision with root package name */
    private final Notification.Builder f5631b;

    /* renamed from: c  reason: collision with root package name */
    private final NotificationCompat.Builder f5632c;

    /* renamed from: d  reason: collision with root package name */
    private RemoteViews f5633d;

    /* renamed from: e  reason: collision with root package name */
    private RemoteViews f5634e;

    /* renamed from: f  reason: collision with root package name */
    private final List<Bundle> f5635f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f5636g = new Bundle();

    /* renamed from: h  reason: collision with root package name */
    private int f5637h;

    /* renamed from: i  reason: collision with root package name */
    private RemoteViews f5638i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotificationCompatBuilder(NotificationCompat.Builder builder) {
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        List<String> list;
        int i8;
        Notification.Builder badgeIconType;
        Notification.Builder settingsText;
        Notification.Builder shortcutId;
        Notification.Builder timeoutAfter;
        Icon icon;
        this.f5632c = builder;
        this.f5630a = builder.f5589a;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f5631b = new Notification.Builder(builder.f5589a, builder.K);
        } else {
            this.f5631b = new Notification.Builder(builder.f5589a);
        }
        Notification notification = builder.R;
        Notification.Builder lights = this.f5631b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.f5597i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        if ((notification.flags & 2) != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        Notification.Builder ongoing = lights.setOngoing(z7);
        if ((notification.flags & 8) != 0) {
            z8 = true;
        } else {
            z8 = false;
        }
        Notification.Builder onlyAlertOnce = ongoing.setOnlyAlertOnce(z8);
        if ((notification.flags & 16) != 0) {
            z9 = true;
        } else {
            z9 = false;
        }
        Notification.Builder deleteIntent = onlyAlertOnce.setAutoCancel(z9).setDefaults(notification.defaults).setContentTitle(builder.f5593e).setContentText(builder.f5594f).setContentInfo(builder.f5599k).setContentIntent(builder.f5595g).setDeleteIntent(notification.deleteIntent);
        PendingIntent pendingIntent = builder.f5596h;
        if ((notification.flags & 128) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        deleteIntent.setFullScreenIntent(pendingIntent, z10).setLargeIcon(builder.f5598j).setNumber(builder.f5600l).setProgress(builder.f5608t, builder.f5609u, builder.f5610v);
        this.f5631b.setSubText(builder.f5605q).setUsesChronometer(builder.f5603o).setPriority(builder.f5601m);
        Iterator<NotificationCompat.Action> it = builder.f5590b.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        Bundle bundle = builder.D;
        if (bundle != null) {
            this.f5636g.putAll(bundle);
        }
        int i9 = Build.VERSION.SDK_INT;
        this.f5633d = builder.H;
        this.f5634e = builder.I;
        this.f5631b.setShowWhen(builder.f5602n);
        this.f5631b.setLocalOnly(builder.f5614z).setGroup(builder.f5611w).setGroupSummary(builder.f5612x).setSortKey(builder.f5613y);
        this.f5637h = builder.O;
        this.f5631b.setCategory(builder.C).setColor(builder.E).setVisibility(builder.F).setPublicVersion(builder.G).setSound(notification.sound, notification.audioAttributes);
        if (i9 < 28) {
            list = e(g(builder.f5591c), builder.U);
        } else {
            list = builder.U;
        }
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                this.f5631b.addPerson(str);
            }
        }
        this.f5638i = builder.J;
        if (builder.f5592d.size() > 0) {
            Bundle bundle2 = builder.d().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i10 = 0; i10 < builder.f5592d.size(); i10++) {
                bundle4.putBundle(Integer.toString(i10), NotificationCompatJellybean.a(builder.f5592d.get(i10)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            builder.d().putBundle("android.car.EXTENSIONS", bundle2);
            this.f5636g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23 && (icon = builder.T) != null) {
            this.f5631b.setSmallIcon(icon);
        }
        if (i11 >= 24) {
            this.f5631b.setExtras(builder.D).setRemoteInputHistory(builder.f5607s);
            RemoteViews remoteViews = builder.H;
            if (remoteViews != null) {
                this.f5631b.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = builder.I;
            if (remoteViews2 != null) {
                this.f5631b.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = builder.J;
            if (remoteViews3 != null) {
                this.f5631b.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i11 >= 26) {
            badgeIconType = this.f5631b.setBadgeIconType(builder.L);
            settingsText = badgeIconType.setSettingsText(builder.f5606r);
            shortcutId = settingsText.setShortcutId(builder.M);
            timeoutAfter = shortcutId.setTimeoutAfter(builder.N);
            timeoutAfter.setGroupAlertBehavior(builder.O);
            if (builder.B) {
                this.f5631b.setColorized(builder.A);
            }
            if (!TextUtils.isEmpty(builder.K)) {
                this.f5631b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i11 >= 28) {
            Iterator<Person> it2 = builder.f5591c.iterator();
            while (it2.hasNext()) {
                this.f5631b.addPerson(it2.next().h());
            }
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 29) {
            this.f5631b.setAllowSystemGeneratedContextualActions(builder.Q);
            this.f5631b.setBubbleMetadata(NotificationCompat.BubbleMetadata.a(null));
        }
        if (i12 >= 31 && (i8 = builder.P) != 0) {
            this.f5631b.setForegroundServiceBehavior(i8);
        }
        if (builder.S) {
            if (this.f5632c.f5612x) {
                this.f5637h = 2;
            } else {
                this.f5637h = 1;
            }
            this.f5631b.setVibrate(null);
            this.f5631b.setSound(null);
            int i13 = notification.defaults & (-2) & (-3);
            notification.defaults = i13;
            this.f5631b.setDefaults(i13);
            if (i12 >= 26) {
                if (TextUtils.isEmpty(this.f5632c.f5611w)) {
                    this.f5631b.setGroup("silent");
                }
                this.f5631b.setGroupAlertBehavior(this.f5637h);
            }
        }
    }

    private void b(NotificationCompat.Action action) {
        Notification.Action.Builder builder;
        int i8;
        Bundle bundle;
        Icon icon;
        int i9 = Build.VERSION.SDK_INT;
        IconCompat d8 = action.d();
        if (i9 >= 23) {
            if (d8 != null) {
                icon = d8.r();
            } else {
                icon = null;
            }
            builder = new Notification.Action.Builder(icon, action.h(), action.a());
        } else {
            if (d8 != null) {
                i8 = d8.j();
            } else {
                i8 = 0;
            }
            builder = new Notification.Action.Builder(i8, action.h(), action.a());
        }
        if (action.e() != null) {
            for (android.app.RemoteInput remoteInput : RemoteInput.b(action.e())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        if (action.c() != null) {
            bundle = new Bundle(action.c());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.b());
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 24) {
            builder.setAllowGeneratedReplies(action.b());
        }
        bundle.putInt("android.support.action.semanticAction", action.f());
        if (i10 >= 28) {
            builder.setSemanticAction(action.f());
        }
        if (i10 >= 29) {
            builder.setContextual(action.j());
        }
        if (i10 >= 31) {
            builder.setAuthenticationRequired(action.i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", action.g());
        builder.addExtras(bundle);
        this.f5631b.addAction(builder.build());
    }

    private static List<String> e(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        ArraySet arraySet = new ArraySet(list.size() + list2.size());
        arraySet.addAll(list);
        arraySet.addAll(list2);
        return new ArrayList(arraySet);
    }

    private static List<String> g(List<Person> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Person person : list) {
            arrayList.add(person.g());
        }
        return arrayList;
    }

    private void h(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults = notification.defaults & (-2) & (-3);
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public Notification.Builder a() {
        return this.f5631b;
    }

    public Notification c() {
        RemoteViews remoteViews;
        Bundle a8;
        RemoteViews f8;
        RemoteViews d8;
        NotificationCompat.Style style = this.f5632c.f5604p;
        if (style != null) {
            style.b(this);
        }
        if (style != null) {
            remoteViews = style.e(this);
        } else {
            remoteViews = null;
        }
        Notification d9 = d();
        if (remoteViews != null) {
            d9.contentView = remoteViews;
        } else {
            RemoteViews remoteViews2 = this.f5632c.H;
            if (remoteViews2 != null) {
                d9.contentView = remoteViews2;
            }
        }
        if (style != null && (d8 = style.d(this)) != null) {
            d9.bigContentView = d8;
        }
        if (style != null && (f8 = this.f5632c.f5604p.f(this)) != null) {
            d9.headsUpContentView = f8;
        }
        if (style != null && (a8 = NotificationCompat.a(d9)) != null) {
            style.a(a8);
        }
        return d9;
    }

    protected Notification d() {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 26) {
            return this.f5631b.build();
        }
        if (i8 >= 24) {
            Notification build = this.f5631b.build();
            if (this.f5637h != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && this.f5637h == 2) {
                    h(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f5637h == 1) {
                    h(build);
                }
            }
            return build;
        }
        this.f5631b.setExtras(this.f5636g);
        Notification build2 = this.f5631b.build();
        RemoteViews remoteViews = this.f5633d;
        if (remoteViews != null) {
            build2.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.f5634e;
        if (remoteViews2 != null) {
            build2.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.f5638i;
        if (remoteViews3 != null) {
            build2.headsUpContentView = remoteViews3;
        }
        if (this.f5637h != 0) {
            if (build2.getGroup() != null && (build2.flags & 512) != 0 && this.f5637h == 2) {
                h(build2);
            }
            if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.f5637h == 1) {
                h(build2);
            }
        }
        return build2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context f() {
        return this.f5630a;
    }
}
