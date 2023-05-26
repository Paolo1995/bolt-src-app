package com.clevertap.android.sdk;

import android.app.Activity;
import android.location.Location;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CoreMetaData extends CleverTapMetaData {

    /* renamed from: w  reason: collision with root package name */
    private static boolean f10944w = false;

    /* renamed from: x  reason: collision with root package name */
    private static WeakReference<Activity> f10945x;

    /* renamed from: y  reason: collision with root package name */
    private static int f10946y;

    /* renamed from: z  reason: collision with root package name */
    private static int f10947z;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10960m;

    /* renamed from: p  reason: collision with root package name */
    private boolean f10963p;

    /* renamed from: a  reason: collision with root package name */
    private long f10948a = 0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f10949b = false;

    /* renamed from: c  reason: collision with root package name */
    private final Object f10950c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private String f10951d = null;

    /* renamed from: e  reason: collision with root package name */
    private int f10952e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10953f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10954g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10955h = false;

    /* renamed from: i  reason: collision with root package name */
    private int f10956i = 0;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10957j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10958k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10959l = false;

    /* renamed from: n  reason: collision with root package name */
    private int f10961n = 0;

    /* renamed from: o  reason: collision with root package name */
    private Location f10962o = null;

    /* renamed from: q  reason: collision with root package name */
    private final Object f10964q = new Object();

    /* renamed from: r  reason: collision with root package name */
    private long f10965r = 0;

    /* renamed from: s  reason: collision with root package name */
    private String f10966s = null;

    /* renamed from: t  reason: collision with root package name */
    private String f10967t = null;

    /* renamed from: u  reason: collision with root package name */
    private String f10968u = null;

    /* renamed from: v  reason: collision with root package name */
    private JSONObject f10969v = null;

    public static void F(int i8) {
        f10946y = i8;
    }

    public static void G(boolean z7) {
        f10944w = z7;
    }

    public static void L(Activity activity) {
        if (activity == null) {
            f10945x = null;
        } else if (!activity.getLocalClassName().contains("InAppNotificationActivity")) {
            f10945x = new WeakReference<>(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void R(int i8) {
        f10947z = i8;
    }

    public static int e() {
        return f10946y;
    }

    public static Activity h() {
        WeakReference<Activity> weakReference = f10945x;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static String i() {
        Activity h8 = h();
        if (h8 != null) {
            return h8.getLocalClassName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l() {
        return f10947z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void u() {
        f10946y++;
    }

    public static boolean v() {
        return f10944w;
    }

    public boolean A() {
        return this.f10955h;
    }

    public boolean B() {
        return this.f10957j;
    }

    public boolean C() {
        return this.f10959l;
    }

    public boolean D() {
        return this.f10963p;
    }

    public boolean E() {
        return this.f10960m;
    }

    public void H(long j8) {
        this.f10948a = j8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(boolean z7) {
        synchronized (this.f10950c) {
            this.f10949b = z7;
        }
    }

    public void J(boolean z7) {
        this.f10958k = z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void K(String str) {
        if (this.f10968u == null) {
            this.f10968u = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(int i8) {
        this.f10952e = i8;
    }

    public void N(boolean z7) {
        synchronized (this.f10964q) {
            this.f10953f = z7;
        }
    }

    public void O(boolean z7) {
        this.f10954g = z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(boolean z7) {
        this.f10955h = z7;
    }

    public void Q(int i8) {
        this.f10956i = i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(boolean z7) {
        this.f10957j = z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i8) {
        this.f10961n = i8;
    }

    public void U(boolean z7) {
        this.f10959l = z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void V(String str) {
        if (this.f10967t == null) {
            this.f10967t = str;
        }
    }

    public void W(boolean z7) {
        this.f10960m = z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(long j8) {
        this.f10965r = j8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void Y(String str) {
        if (this.f10966s == null) {
            this.f10966s = str;
        }
    }

    public synchronized void Z(JSONObject jSONObject) {
        if (this.f10969v == null) {
            this.f10969v = jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a() {
        this.f10968u = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b() {
        this.f10967t = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c() {
        this.f10966s = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d() {
        this.f10969v = null;
    }

    public long f() {
        return this.f10948a;
    }

    public synchronized String g() {
        return this.f10968u;
    }

    public int j() {
        return this.f10952e;
    }

    public int k() {
        return this.f10956i;
    }

    public int m() {
        return this.f10961n;
    }

    public Location n() {
        return this.f10962o;
    }

    public synchronized String o() {
        return this.f10967t;
    }

    public long p() {
        return this.f10965r;
    }

    public String q() {
        return this.f10951d;
    }

    public synchronized String r() {
        return this.f10966s;
    }

    public synchronized JSONObject s() {
        return this.f10969v;
    }

    public boolean t() {
        if (this.f10952e > 0) {
            return true;
        }
        return false;
    }

    public boolean w() {
        boolean z7;
        synchronized (this.f10950c) {
            z7 = this.f10949b;
        }
        return z7;
    }

    public boolean x() {
        return this.f10958k;
    }

    public boolean y() {
        boolean z7;
        synchronized (this.f10964q) {
            z7 = this.f10953f;
        }
        return z7;
    }

    public boolean z() {
        return this.f10954g;
    }
}
