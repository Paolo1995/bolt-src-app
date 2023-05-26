package com.clevertap.android.sdk.inapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.LruCache;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.utils.ImageCache;
import com.google.android.gms.common.internal.ImagesContract;
import j$.util.Spliterator;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CTInAppNotification implements Parcelable {
    public static final Parcelable.Creator<CTInAppNotification> CREATOR = new Parcelable.Creator<CTInAppNotification>() { // from class: com.clevertap.android.sdk.inapp.CTInAppNotification.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CTInAppNotification createFromParcel(Parcel parcel) {
            return new CTInAppNotification(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CTInAppNotification[] newArray(int i8) {
            return new CTInAppNotification[i8];
        }
    };
    private boolean A;
    private JSONObject B;
    private String C;
    private int D;
    private ArrayList<CTInAppNotificationMedia> E;
    private String F;
    private String G;
    private char H;
    private boolean I;
    private long J;
    private String K;
    private String L;
    private int M;
    private int N;
    private String O;
    private boolean P;
    private int Q;
    private int R;

    /* renamed from: f  reason: collision with root package name */
    CTInAppNotificationListener f11362f;

    /* renamed from: g  reason: collision with root package name */
    private String f11363g;

    /* renamed from: h  reason: collision with root package name */
    private JSONObject f11364h;

    /* renamed from: i  reason: collision with root package name */
    private String f11365i;

    /* renamed from: j  reason: collision with root package name */
    private int f11366j;

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<CTInAppNotificationButton> f11367k;

    /* renamed from: l  reason: collision with root package name */
    private String f11368l;

    /* renamed from: m  reason: collision with root package name */
    private JSONObject f11369m;

    /* renamed from: n  reason: collision with root package name */
    private String f11370n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f11371o;

    /* renamed from: p  reason: collision with root package name */
    private String f11372p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f11373q;

    /* renamed from: r  reason: collision with root package name */
    private int f11374r;

    /* renamed from: s  reason: collision with root package name */
    private int f11375s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f11376t;

    /* renamed from: u  reason: collision with root package name */
    private String f11377u;

    /* renamed from: v  reason: collision with root package name */
    private String f11378v;

    /* renamed from: w  reason: collision with root package name */
    private CTInAppType f11379w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f11380x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f11381y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f11382z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.clevertap.android.sdk.inapp.CTInAppNotification$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11383a;

        static {
            int[] iArr = new int[CTInAppType.values().length];
            f11383a = iArr;
            try {
                iArr[CTInAppType.CTInAppTypeFooter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11383a[CTInAppType.CTInAppTypeHeader.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11383a[CTInAppType.CTInAppTypeCover.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11383a[CTInAppType.CTInAppTypeHalfInterstitial.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11383a[CTInAppType.CTInAppTypeCoverImageOnly.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11383a[CTInAppType.CTInAppTypeHalfInterstitialImageOnly.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11383a[CTInAppType.CTInAppTypeInterstitialImageOnly.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    interface CTInAppNotificationListener {
        void a(CTInAppNotification cTInAppNotification);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class GifCache {

        /* renamed from: a  reason: collision with root package name */
        private static final int f11384a;

        /* renamed from: b  reason: collision with root package name */
        private static final int f11385b;

        /* renamed from: c  reason: collision with root package name */
        private static LruCache<String, byte[]> f11386c;

        static {
            int maxMemory = ((int) Runtime.getRuntime().maxMemory()) / Spliterator.IMMUTABLE;
            f11384a = maxMemory;
            f11385b = Math.max(maxMemory / 32, 5120);
        }

        private GifCache() {
        }

        static boolean b(String str, byte[] bArr) {
            if (f11386c == null) {
                return false;
            }
            if (e(str) == null) {
                synchronized (GifCache.class) {
                    int f8 = f(bArr);
                    int d8 = d();
                    Logger.n("CTInAppNotification.GifCache: gif size: " + f8 + "KB. Available mem: " + d8 + "KB.");
                    if (f8 > d()) {
                        Logger.n("CTInAppNotification.GifCache: insufficient memory to add gif: " + str);
                        return false;
                    }
                    f11386c.put(str, bArr);
                    Logger.n("CTInAppNotification.GifCache: added gif for key: " + str);
                    return true;
                }
            }
            return true;
        }

        private static void c() {
            synchronized (GifCache.class) {
                if (h()) {
                    Logger.n("CTInAppNotification.GifCache: cache is empty, removing it");
                    f11386c = null;
                }
            }
        }

        private static int d() {
            int size;
            synchronized (GifCache.class) {
                LruCache<String, byte[]> lruCache = f11386c;
                if (lruCache == null) {
                    size = 0;
                } else {
                    size = f11385b - lruCache.size();
                }
            }
            return size;
        }

        static byte[] e(String str) {
            byte[] bArr;
            synchronized (GifCache.class) {
                LruCache<String, byte[]> lruCache = f11386c;
                if (lruCache == null) {
                    bArr = null;
                } else {
                    bArr = lruCache.get(str);
                }
            }
            return bArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int f(byte[] bArr) {
            return bArr.length / Spliterator.IMMUTABLE;
        }

        static void g() {
            synchronized (GifCache.class) {
                if (f11386c == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("CTInAppNotification.GifCache: init with max device memory: ");
                    sb.append(f11384a);
                    sb.append("KB and allocated cache size: ");
                    int i8 = f11385b;
                    sb.append(i8);
                    sb.append("KB");
                    Logger.n(sb.toString());
                    f11386c = new LruCache<String, byte[]>(i8) { // from class: com.clevertap.android.sdk.inapp.CTInAppNotification.GifCache.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // android.util.LruCache
                        /* renamed from: a */
                        public int sizeOf(String str, byte[] bArr) {
                            int f8 = GifCache.f(bArr);
                            Logger.n("CTInAppNotification.GifCache: have gif of size: " + f8 + "KB for key: " + str);
                            return f8;
                        }
                    };
                }
            }
        }

        private static boolean h() {
            boolean z7;
            synchronized (GifCache.class) {
                if (f11386c.size() <= 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
            }
            return z7;
        }

        static void i(String str) {
            synchronized (GifCache.class) {
                LruCache<String, byte[]> lruCache = f11386c;
                if (lruCache == null) {
                    return;
                }
                lruCache.remove(str);
                Logger.n("CTInAppNotification.GifCache: removed gif for key: " + str);
                c();
            }
        }
    }

    private boolean Q(Bundle bundle, String str, Class<?> cls) {
        if (bundle.containsKey(str) && bundle.get(str).getClass().equals(cls)) {
            return true;
        }
        return false;
    }

    private void V(JSONObject jSONObject) {
        String str;
        String str2;
        boolean z7;
        int i8;
        int i9;
        long currentTimeMillis;
        JSONObject jSONObject2;
        int i10;
        int i11;
        int i12;
        if (!b0(d(jSONObject))) {
            this.f11372p = "Invalid JSON";
            return;
        }
        try {
            String str3 = "";
            if (!jSONObject.has("ti")) {
                str = "";
            } else {
                str = jSONObject.getString("ti");
            }
            this.f11378v = str;
            if (!jSONObject.has("wzrk_id")) {
                str2 = "";
            } else {
                str2 = jSONObject.getString("wzrk_id");
            }
            this.f11368l = str2;
            boolean z8 = true;
            int i13 = 0;
            if (jSONObject.has("efc") && jSONObject.getInt("efc") == 1) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.f11373q = z7;
            int i14 = -1;
            if (jSONObject.has("tlc")) {
                i8 = jSONObject.getInt("tlc");
            } else {
                i8 = -1;
            }
            this.N = i8;
            if (jSONObject.has("tdc")) {
                i9 = jSONObject.getInt("tdc");
            } else {
                i9 = -1;
            }
            this.M = i9;
            if (!jSONObject.has("isJsEnabled") || !jSONObject.getBoolean("isJsEnabled")) {
                z8 = false;
            }
            this.A = z8;
            if (jSONObject.has("wzrk_ttl")) {
                currentTimeMillis = jSONObject.getLong("wzrk_ttl");
            } else {
                currentTimeMillis = (System.currentTimeMillis() + 172800000) / 1000;
            }
            this.J = currentTimeMillis;
            JSONObject jSONObject3 = null;
            if (jSONObject.has("d")) {
                jSONObject2 = jSONObject.getJSONObject("d");
            } else {
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                this.f11377u = jSONObject2.getString("html");
                if (jSONObject2.has(ImagesContract.URL)) {
                    str3 = jSONObject2.getString(ImagesContract.URL);
                }
                this.f11370n = str3;
                if (jSONObject2.has("kv")) {
                    jSONObject3 = jSONObject2.getJSONObject("kv");
                }
                this.f11369m = jSONObject3;
                if (jSONObject3 == null) {
                    this.f11369m = new JSONObject();
                }
                JSONObject jSONObject4 = jSONObject.getJSONObject("w");
                if (jSONObject4 != null) {
                    this.f11371o = jSONObject4.getBoolean("dk");
                    this.I = jSONObject4.getBoolean("sc");
                    this.H = jSONObject4.getString("pos").charAt(0);
                    if (jSONObject4.has("xdp")) {
                        i10 = jSONObject4.getInt("xdp");
                    } else {
                        i10 = 0;
                    }
                    this.Q = i10;
                    if (jSONObject4.has("xp")) {
                        i11 = jSONObject4.getInt("xp");
                    } else {
                        i11 = 0;
                    }
                    this.R = i11;
                    if (jSONObject4.has("ydp")) {
                        i12 = jSONObject4.getInt("ydp");
                    } else {
                        i12 = 0;
                    }
                    this.f11374r = i12;
                    if (jSONObject4.has("yp")) {
                        i13 = jSONObject4.getInt("yp");
                    }
                    this.f11375s = i13;
                    if (jSONObject4.has("mdc")) {
                        i14 = jSONObject4.getInt("mdc");
                    }
                    this.D = i14;
                }
                if (this.f11377u != null) {
                    char c8 = this.H;
                    if (c8 == 't' && this.R == 100 && this.f11375s <= 30) {
                        this.f11379w = CTInAppType.CTInAppTypeHeaderHTML;
                    } else if (c8 == 'b' && this.R == 100 && this.f11375s <= 30) {
                        this.f11379w = CTInAppType.CTInAppTypeFooterHTML;
                    } else if (c8 == 'c' && this.R == 90 && this.f11375s == 85) {
                        this.f11379w = CTInAppType.CTInAppTypeInterstitialHTML;
                    } else if (c8 == 'c' && this.R == 100 && this.f11375s == 100) {
                        this.f11379w = CTInAppType.CTInAppTypeCoverHTML;
                    } else if (c8 == 'c' && this.R == 90 && this.f11375s == 50) {
                        this.f11379w = CTInAppType.CTInAppTypeHalfInterstitialHTML;
                    }
                }
            }
        } catch (JSONException unused) {
            this.f11372p = "Invalid JSON";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0189 A[Catch: JSONException -> 0x0234, TryCatch #0 {JSONException -> 0x0234, blocks: (B:3:0x0020, B:6:0x0028, B:8:0x002f, B:10:0x0037, B:12:0x003e, B:14:0x004f, B:18:0x0058, B:20:0x0061, B:22:0x0067, B:24:0x006f, B:25:0x0073, B:27:0x0083, B:31:0x008c, B:33:0x0094, B:35:0x009b, B:37:0x00a3, B:42:0x00ad, B:44:0x00b5, B:48:0x00be, B:50:0x00c6, B:52:0x00d3, B:54:0x00dc, B:59:0x00ea, B:61:0x00f0, B:63:0x00f7, B:65:0x00ff, B:67:0x0105, B:68:0x0107, B:70:0x010d, B:73:0x0115, B:75:0x011b, B:76:0x011f, B:78:0x0129, B:79:0x012d, B:80:0x012f, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014e, B:93:0x0159, B:94:0x015e, B:96:0x0166, B:99:0x0170, B:101:0x017c, B:102:0x0181, B:104:0x0189, B:108:0x0194, B:110:0x019a, B:112:0x01a9, B:114:0x01af, B:115:0x01b9, B:116:0x01bc, B:117:0x01c6, B:119:0x01cb, B:121:0x01d3, B:122:0x01d9, B:124:0x01df, B:126:0x01eb, B:128:0x01f1, B:130:0x01f7, B:132:0x01fd, B:133:0x0202, B:134:0x0207, B:135:0x020d, B:137:0x0213, B:139:0x021f, B:141:0x0225, B:143:0x022b, B:51:0x00cb), top: B:148:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01cb A[Catch: JSONException -> 0x0234, TryCatch #0 {JSONException -> 0x0234, blocks: (B:3:0x0020, B:6:0x0028, B:8:0x002f, B:10:0x0037, B:12:0x003e, B:14:0x004f, B:18:0x0058, B:20:0x0061, B:22:0x0067, B:24:0x006f, B:25:0x0073, B:27:0x0083, B:31:0x008c, B:33:0x0094, B:35:0x009b, B:37:0x00a3, B:42:0x00ad, B:44:0x00b5, B:48:0x00be, B:50:0x00c6, B:52:0x00d3, B:54:0x00dc, B:59:0x00ea, B:61:0x00f0, B:63:0x00f7, B:65:0x00ff, B:67:0x0105, B:68:0x0107, B:70:0x010d, B:73:0x0115, B:75:0x011b, B:76:0x011f, B:78:0x0129, B:79:0x012d, B:80:0x012f, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014e, B:93:0x0159, B:94:0x015e, B:96:0x0166, B:99:0x0170, B:101:0x017c, B:102:0x0181, B:104:0x0189, B:108:0x0194, B:110:0x019a, B:112:0x01a9, B:114:0x01af, B:115:0x01b9, B:116:0x01bc, B:117:0x01c6, B:119:0x01cb, B:121:0x01d3, B:122:0x01d9, B:124:0x01df, B:126:0x01eb, B:128:0x01f1, B:130:0x01f7, B:132:0x01fd, B:133:0x0202, B:134:0x0207, B:135:0x020d, B:137:0x0213, B:139:0x021f, B:141:0x0225, B:143:0x022b, B:51:0x00cb), top: B:148:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0207 A[Catch: JSONException -> 0x0234, TryCatch #0 {JSONException -> 0x0234, blocks: (B:3:0x0020, B:6:0x0028, B:8:0x002f, B:10:0x0037, B:12:0x003e, B:14:0x004f, B:18:0x0058, B:20:0x0061, B:22:0x0067, B:24:0x006f, B:25:0x0073, B:27:0x0083, B:31:0x008c, B:33:0x0094, B:35:0x009b, B:37:0x00a3, B:42:0x00ad, B:44:0x00b5, B:48:0x00be, B:50:0x00c6, B:52:0x00d3, B:54:0x00dc, B:59:0x00ea, B:61:0x00f0, B:63:0x00f7, B:65:0x00ff, B:67:0x0105, B:68:0x0107, B:70:0x010d, B:73:0x0115, B:75:0x011b, B:76:0x011f, B:78:0x0129, B:79:0x012d, B:80:0x012f, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014e, B:93:0x0159, B:94:0x015e, B:96:0x0166, B:99:0x0170, B:101:0x017c, B:102:0x0181, B:104:0x0189, B:108:0x0194, B:110:0x019a, B:112:0x01a9, B:114:0x01af, B:115:0x01b9, B:116:0x01bc, B:117:0x01c6, B:119:0x01cb, B:121:0x01d3, B:122:0x01d9, B:124:0x01df, B:126:0x01eb, B:128:0x01f1, B:130:0x01f7, B:132:0x01fd, B:133:0x0202, B:134:0x0207, B:135:0x020d, B:137:0x0213, B:139:0x021f, B:141:0x0225, B:143:0x022b, B:51:0x00cb), top: B:148:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c6 A[Catch: JSONException -> 0x0234, TryCatch #0 {JSONException -> 0x0234, blocks: (B:3:0x0020, B:6:0x0028, B:8:0x002f, B:10:0x0037, B:12:0x003e, B:14:0x004f, B:18:0x0058, B:20:0x0061, B:22:0x0067, B:24:0x006f, B:25:0x0073, B:27:0x0083, B:31:0x008c, B:33:0x0094, B:35:0x009b, B:37:0x00a3, B:42:0x00ad, B:44:0x00b5, B:48:0x00be, B:50:0x00c6, B:52:0x00d3, B:54:0x00dc, B:59:0x00ea, B:61:0x00f0, B:63:0x00f7, B:65:0x00ff, B:67:0x0105, B:68:0x0107, B:70:0x010d, B:73:0x0115, B:75:0x011b, B:76:0x011f, B:78:0x0129, B:79:0x012d, B:80:0x012f, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014e, B:93:0x0159, B:94:0x015e, B:96:0x0166, B:99:0x0170, B:101:0x017c, B:102:0x0181, B:104:0x0189, B:108:0x0194, B:110:0x019a, B:112:0x01a9, B:114:0x01af, B:115:0x01b9, B:116:0x01bc, B:117:0x01c6, B:119:0x01cb, B:121:0x01d3, B:122:0x01d9, B:124:0x01df, B:126:0x01eb, B:128:0x01f1, B:130:0x01f7, B:132:0x01fd, B:133:0x0202, B:134:0x0207, B:135:0x020d, B:137:0x0213, B:139:0x021f, B:141:0x0225, B:143:0x022b, B:51:0x00cb), top: B:148:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cb A[Catch: JSONException -> 0x0234, TryCatch #0 {JSONException -> 0x0234, blocks: (B:3:0x0020, B:6:0x0028, B:8:0x002f, B:10:0x0037, B:12:0x003e, B:14:0x004f, B:18:0x0058, B:20:0x0061, B:22:0x0067, B:24:0x006f, B:25:0x0073, B:27:0x0083, B:31:0x008c, B:33:0x0094, B:35:0x009b, B:37:0x00a3, B:42:0x00ad, B:44:0x00b5, B:48:0x00be, B:50:0x00c6, B:52:0x00d3, B:54:0x00dc, B:59:0x00ea, B:61:0x00f0, B:63:0x00f7, B:65:0x00ff, B:67:0x0105, B:68:0x0107, B:70:0x010d, B:73:0x0115, B:75:0x011b, B:76:0x011f, B:78:0x0129, B:79:0x012d, B:80:0x012f, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014e, B:93:0x0159, B:94:0x015e, B:96:0x0166, B:99:0x0170, B:101:0x017c, B:102:0x0181, B:104:0x0189, B:108:0x0194, B:110:0x019a, B:112:0x01a9, B:114:0x01af, B:115:0x01b9, B:116:0x01bc, B:117:0x01c6, B:119:0x01cb, B:121:0x01d3, B:122:0x01d9, B:124:0x01df, B:126:0x01eb, B:128:0x01f1, B:130:0x01f7, B:132:0x01fd, B:133:0x0202, B:134:0x0207, B:135:0x020d, B:137:0x0213, B:139:0x021f, B:141:0x0225, B:143:0x022b, B:51:0x00cb), top: B:148:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00dc A[Catch: JSONException -> 0x0234, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0234, blocks: (B:3:0x0020, B:6:0x0028, B:8:0x002f, B:10:0x0037, B:12:0x003e, B:14:0x004f, B:18:0x0058, B:20:0x0061, B:22:0x0067, B:24:0x006f, B:25:0x0073, B:27:0x0083, B:31:0x008c, B:33:0x0094, B:35:0x009b, B:37:0x00a3, B:42:0x00ad, B:44:0x00b5, B:48:0x00be, B:50:0x00c6, B:52:0x00d3, B:54:0x00dc, B:59:0x00ea, B:61:0x00f0, B:63:0x00f7, B:65:0x00ff, B:67:0x0105, B:68:0x0107, B:70:0x010d, B:73:0x0115, B:75:0x011b, B:76:0x011f, B:78:0x0129, B:79:0x012d, B:80:0x012f, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014e, B:93:0x0159, B:94:0x015e, B:96:0x0166, B:99:0x0170, B:101:0x017c, B:102:0x0181, B:104:0x0189, B:108:0x0194, B:110:0x019a, B:112:0x01a9, B:114:0x01af, B:115:0x01b9, B:116:0x01bc, B:117:0x01c6, B:119:0x01cb, B:121:0x01d3, B:122:0x01d9, B:124:0x01df, B:126:0x01eb, B:128:0x01f1, B:130:0x01f7, B:132:0x01fd, B:133:0x0202, B:134:0x0207, B:135:0x020d, B:137:0x0213, B:139:0x021f, B:141:0x0225, B:143:0x022b, B:51:0x00cb), top: B:148:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ea A[Catch: JSONException -> 0x0234, TRY_ENTER, TryCatch #0 {JSONException -> 0x0234, blocks: (B:3:0x0020, B:6:0x0028, B:8:0x002f, B:10:0x0037, B:12:0x003e, B:14:0x004f, B:18:0x0058, B:20:0x0061, B:22:0x0067, B:24:0x006f, B:25:0x0073, B:27:0x0083, B:31:0x008c, B:33:0x0094, B:35:0x009b, B:37:0x00a3, B:42:0x00ad, B:44:0x00b5, B:48:0x00be, B:50:0x00c6, B:52:0x00d3, B:54:0x00dc, B:59:0x00ea, B:61:0x00f0, B:63:0x00f7, B:65:0x00ff, B:67:0x0105, B:68:0x0107, B:70:0x010d, B:73:0x0115, B:75:0x011b, B:76:0x011f, B:78:0x0129, B:79:0x012d, B:80:0x012f, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014e, B:93:0x0159, B:94:0x015e, B:96:0x0166, B:99:0x0170, B:101:0x017c, B:102:0x0181, B:104:0x0189, B:108:0x0194, B:110:0x019a, B:112:0x01a9, B:114:0x01af, B:115:0x01b9, B:116:0x01bc, B:117:0x01c6, B:119:0x01cb, B:121:0x01d3, B:122:0x01d9, B:124:0x01df, B:126:0x01eb, B:128:0x01f1, B:130:0x01f7, B:132:0x01fd, B:133:0x0202, B:134:0x0207, B:135:0x020d, B:137:0x0213, B:139:0x021f, B:141:0x0225, B:143:0x022b, B:51:0x00cb), top: B:148:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x010d A[Catch: JSONException -> 0x0234, TryCatch #0 {JSONException -> 0x0234, blocks: (B:3:0x0020, B:6:0x0028, B:8:0x002f, B:10:0x0037, B:12:0x003e, B:14:0x004f, B:18:0x0058, B:20:0x0061, B:22:0x0067, B:24:0x006f, B:25:0x0073, B:27:0x0083, B:31:0x008c, B:33:0x0094, B:35:0x009b, B:37:0x00a3, B:42:0x00ad, B:44:0x00b5, B:48:0x00be, B:50:0x00c6, B:52:0x00d3, B:54:0x00dc, B:59:0x00ea, B:61:0x00f0, B:63:0x00f7, B:65:0x00ff, B:67:0x0105, B:68:0x0107, B:70:0x010d, B:73:0x0115, B:75:0x011b, B:76:0x011f, B:78:0x0129, B:79:0x012d, B:80:0x012f, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014e, B:93:0x0159, B:94:0x015e, B:96:0x0166, B:99:0x0170, B:101:0x017c, B:102:0x0181, B:104:0x0189, B:108:0x0194, B:110:0x019a, B:112:0x01a9, B:114:0x01af, B:115:0x01b9, B:116:0x01bc, B:117:0x01c6, B:119:0x01cb, B:121:0x01d3, B:122:0x01d9, B:124:0x01df, B:126:0x01eb, B:128:0x01f1, B:130:0x01f7, B:132:0x01fd, B:133:0x0202, B:134:0x0207, B:135:0x020d, B:137:0x0213, B:139:0x021f, B:141:0x0225, B:143:0x022b, B:51:0x00cb), top: B:148:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0115 A[Catch: JSONException -> 0x0234, TryCatch #0 {JSONException -> 0x0234, blocks: (B:3:0x0020, B:6:0x0028, B:8:0x002f, B:10:0x0037, B:12:0x003e, B:14:0x004f, B:18:0x0058, B:20:0x0061, B:22:0x0067, B:24:0x006f, B:25:0x0073, B:27:0x0083, B:31:0x008c, B:33:0x0094, B:35:0x009b, B:37:0x00a3, B:42:0x00ad, B:44:0x00b5, B:48:0x00be, B:50:0x00c6, B:52:0x00d3, B:54:0x00dc, B:59:0x00ea, B:61:0x00f0, B:63:0x00f7, B:65:0x00ff, B:67:0x0105, B:68:0x0107, B:70:0x010d, B:73:0x0115, B:75:0x011b, B:76:0x011f, B:78:0x0129, B:79:0x012d, B:80:0x012f, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014e, B:93:0x0159, B:94:0x015e, B:96:0x0166, B:99:0x0170, B:101:0x017c, B:102:0x0181, B:104:0x0189, B:108:0x0194, B:110:0x019a, B:112:0x01a9, B:114:0x01af, B:115:0x01b9, B:116:0x01bc, B:117:0x01c6, B:119:0x01cb, B:121:0x01d3, B:122:0x01d9, B:124:0x01df, B:126:0x01eb, B:128:0x01f1, B:130:0x01f7, B:132:0x01fd, B:133:0x0202, B:134:0x0207, B:135:0x020d, B:137:0x0213, B:139:0x021f, B:141:0x0225, B:143:0x022b, B:51:0x00cb), top: B:148:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0146 A[Catch: JSONException -> 0x0234, TryCatch #0 {JSONException -> 0x0234, blocks: (B:3:0x0020, B:6:0x0028, B:8:0x002f, B:10:0x0037, B:12:0x003e, B:14:0x004f, B:18:0x0058, B:20:0x0061, B:22:0x0067, B:24:0x006f, B:25:0x0073, B:27:0x0083, B:31:0x008c, B:33:0x0094, B:35:0x009b, B:37:0x00a3, B:42:0x00ad, B:44:0x00b5, B:48:0x00be, B:50:0x00c6, B:52:0x00d3, B:54:0x00dc, B:59:0x00ea, B:61:0x00f0, B:63:0x00f7, B:65:0x00ff, B:67:0x0105, B:68:0x0107, B:70:0x010d, B:73:0x0115, B:75:0x011b, B:76:0x011f, B:78:0x0129, B:79:0x012d, B:80:0x012f, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014e, B:93:0x0159, B:94:0x015e, B:96:0x0166, B:99:0x0170, B:101:0x017c, B:102:0x0181, B:104:0x0189, B:108:0x0194, B:110:0x019a, B:112:0x01a9, B:114:0x01af, B:115:0x01b9, B:116:0x01bc, B:117:0x01c6, B:119:0x01cb, B:121:0x01d3, B:122:0x01d9, B:124:0x01df, B:126:0x01eb, B:128:0x01f1, B:130:0x01f7, B:132:0x01fd, B:133:0x0202, B:134:0x0207, B:135:0x020d, B:137:0x0213, B:139:0x021f, B:141:0x0225, B:143:0x022b, B:51:0x00cb), top: B:148:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0166 A[Catch: JSONException -> 0x0234, TryCatch #0 {JSONException -> 0x0234, blocks: (B:3:0x0020, B:6:0x0028, B:8:0x002f, B:10:0x0037, B:12:0x003e, B:14:0x004f, B:18:0x0058, B:20:0x0061, B:22:0x0067, B:24:0x006f, B:25:0x0073, B:27:0x0083, B:31:0x008c, B:33:0x0094, B:35:0x009b, B:37:0x00a3, B:42:0x00ad, B:44:0x00b5, B:48:0x00be, B:50:0x00c6, B:52:0x00d3, B:54:0x00dc, B:59:0x00ea, B:61:0x00f0, B:63:0x00f7, B:65:0x00ff, B:67:0x0105, B:68:0x0107, B:70:0x010d, B:73:0x0115, B:75:0x011b, B:76:0x011f, B:78:0x0129, B:79:0x012d, B:80:0x012f, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014e, B:93:0x0159, B:94:0x015e, B:96:0x0166, B:99:0x0170, B:101:0x017c, B:102:0x0181, B:104:0x0189, B:108:0x0194, B:110:0x019a, B:112:0x01a9, B:114:0x01af, B:115:0x01b9, B:116:0x01bc, B:117:0x01c6, B:119:0x01cb, B:121:0x01d3, B:122:0x01d9, B:124:0x01df, B:126:0x01eb, B:128:0x01f1, B:130:0x01f7, B:132:0x01fd, B:133:0x0202, B:134:0x0207, B:135:0x020d, B:137:0x0213, B:139:0x021f, B:141:0x0225, B:143:0x022b, B:51:0x00cb), top: B:148:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x016d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(org.json.JSONObject r19) {
        /*
            Method dump skipped, instructions count: 608
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inapp.CTInAppNotification.a(org.json.JSONObject):void");
    }

    private void a0() {
        Iterator<CTInAppNotificationMedia> it = this.E.iterator();
        while (it.hasNext()) {
            CTInAppNotificationMedia next = it.next();
            if (next.c() != null && next.a() != null) {
                if (!next.b().equals("image/gif")) {
                    ImageCache.k(next.a(), false);
                    Logger.n("Deleted image - " + next.a());
                } else {
                    GifCache.i(next.a());
                    Logger.n("Deleted GIF - " + next.a());
                }
            }
        }
    }

    private boolean b0(Bundle bundle) {
        try {
            Bundle bundle2 = bundle.getBundle("w");
            Bundle bundle3 = bundle.getBundle("d");
            if (bundle2 == null || bundle3 == null || (!Q(bundle2, "xdp", Integer.class) && !Q(bundle2, "xp", Integer.class))) {
                return false;
            }
            if ((Q(bundle2, "ydp", Integer.class) || Q(bundle2, "yp", Integer.class)) && Q(bundle2, "dk", Boolean.class) && Q(bundle2, "sc", Boolean.class) && Q(bundle3, "html", String.class) && Q(bundle2, "pos", String.class)) {
                char charAt = bundle2.getString("pos").charAt(0);
                if (charAt != 'b' && charAt != 'c' && charAt != 'l' && charAt != 'r' && charAt != 't') {
                    return false;
                }
                return true;
            }
            return false;
        } catch (Throwable th) {
            Logger.q("Failed to parse in-app notification!", th);
            return false;
        }
    }

    private static Bundle d(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Object obj = jSONObject.get(next);
                if (obj instanceof String) {
                    bundle.putString(next, (String) obj);
                } else if (obj instanceof Character) {
                    bundle.putChar(next, ((Character) obj).charValue());
                } else if (obj instanceof Integer) {
                    bundle.putInt(next, ((Integer) obj).intValue());
                } else if (obj instanceof Float) {
                    bundle.putFloat(next, ((Float) obj).floatValue());
                } else if (obj instanceof Double) {
                    bundle.putDouble(next, ((Double) obj).doubleValue());
                } else if (obj instanceof Long) {
                    bundle.putLong(next, ((Long) obj).longValue());
                } else if (obj instanceof Boolean) {
                    bundle.putBoolean(next, ((Boolean) obj).booleanValue());
                } else if (obj instanceof JSONObject) {
                    bundle.putBundle(next, d((JSONObject) obj));
                }
            } catch (JSONException unused) {
                Logger.n("Key had unknown object. Discarding");
            }
        }
        return bundle;
    }

    public long A() {
        return this.J;
    }

    public String B() {
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String C() {
        return this.L;
    }

    public int D() {
        return this.M;
    }

    public int E() {
        return this.N;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String G() {
        return this.O;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int H() {
        return this.R;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTInAppNotification J(JSONObject jSONObject, boolean z7) {
        String str;
        this.P = z7;
        this.B = jSONObject;
        try {
            if (jSONObject.has("type")) {
                str = jSONObject.getString("type");
            } else {
                str = null;
            }
            this.O = str;
        } catch (JSONException e8) {
            this.f11372p = "Invalid JSON : " + e8.getLocalizedMessage();
        }
        if (str != null && !str.equals("custom-html")) {
            a(jSONObject);
            return this;
        }
        V(jSONObject);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean K() {
        return this.f11371o;
    }

    public boolean L() {
        return this.f11373q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean M() {
        return this.f11376t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean P() {
        return this.A;
    }

    public boolean R() {
        return this.f11380x;
    }

    public boolean S() {
        return this.f11381y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean T() {
        return this.I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean U() {
        return this.f11382z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W() {
        Iterator<CTInAppNotificationMedia> it = this.E.iterator();
        while (it.hasNext()) {
            CTInAppNotificationMedia next = it.next();
            if (next.g()) {
                GifCache.g();
                if (j(next) != null) {
                    this.f11362f.a(this);
                    return;
                } else if (next.c() != null) {
                    Logger.n("CTInAppNotification: downloading GIF :" + next.c());
                    byte[] l8 = Utils.l(next.c());
                    if (l8 != null) {
                        Logger.n("GIF Downloaded from url: " + next.c());
                        if (!GifCache.b(next.a(), l8)) {
                            this.f11372p = "Error processing GIF";
                        }
                    }
                }
            } else if (next.h()) {
                ImageCache.i();
                if (p(next) != null) {
                    this.f11362f.a(this);
                    return;
                } else if (next.c() != null) {
                    Logger.n("CTInAppNotification: downloading Image :" + next.c());
                    Bitmap k8 = Utils.k(next.c());
                    if (k8 != null) {
                        Logger.n("Image Downloaded from url: " + next.c());
                        if (!ImageCache.b(next.a(), k8)) {
                            this.f11372p = "Error processing image";
                        }
                    } else {
                        Logger.a("Image Bitmap is null");
                        this.f11372p = "Error processing image as bitmap was NULL";
                    }
                }
            } else if (next.i() || next.f()) {
                if (!this.P) {
                    this.f11372p = "InApp Video/Audio is not supported";
                }
            }
        }
        this.f11362f.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        a0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.f11365i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f11366j;
    }

    public ArrayList<CTInAppNotificationButton> f() {
        return this.f11367k;
    }

    public String g() {
        return this.f11368l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getError() {
        return this.f11372p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getHeight() {
        return this.f11374r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getWidth() {
        return this.Q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject h() {
        return this.f11369m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String i() {
        return this.f11370n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] j(CTInAppNotificationMedia cTInAppNotificationMedia) {
        return GifCache.e(cTInAppNotificationMedia.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return this.f11375s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String n() {
        return this.f11377u;
    }

    public String o() {
        return this.f11378v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap p(CTInAppNotificationMedia cTInAppNotificationMedia) {
        return ImageCache.e(cTInAppNotificationMedia.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTInAppNotificationMedia q(int i8) {
        Iterator<CTInAppNotificationMedia> it = this.E.iterator();
        while (it.hasNext()) {
            CTInAppNotificationMedia next = it.next();
            if (i8 == next.d()) {
                return next;
            }
        }
        return null;
    }

    public CTInAppType r() {
        return this.f11379w;
    }

    public JSONObject s() {
        return this.B;
    }

    public int t() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<CTInAppNotificationMedia> u() {
        return this.E;
    }

    public String v() {
        return this.F;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f11378v);
        parcel.writeString(this.f11368l);
        parcel.writeValue(this.f11379w);
        parcel.writeString(this.f11377u);
        parcel.writeByte(this.f11373q ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.I ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f11371o ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.D);
        parcel.writeInt(this.N);
        parcel.writeInt(this.M);
        parcel.writeValue(Character.valueOf(this.H));
        parcel.writeInt(this.f11374r);
        parcel.writeInt(this.f11375s);
        parcel.writeInt(this.Q);
        parcel.writeInt(this.R);
        if (this.B == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.B.toString());
        }
        parcel.writeString(this.f11372p);
        if (this.f11369m == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.f11369m.toString());
        }
        if (this.f11364h == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.f11364h.toString());
        }
        parcel.writeString(this.O);
        parcel.writeString(this.K);
        parcel.writeString(this.L);
        parcel.writeString(this.f11365i);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeTypedList(this.f11367k);
        parcel.writeTypedList(this.E);
        parcel.writeByte(this.f11376t ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f11366j);
        parcel.writeByte(this.f11382z ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f11370n);
        parcel.writeByte(this.A ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f11381y ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f11380x ? (byte) 1 : (byte) 0);
        parcel.writeString(this.C);
        parcel.writeString(this.f11363g);
        parcel.writeLong(this.J);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String x() {
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char z() {
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTInAppNotification() {
        this.f11367k = new ArrayList<>();
        this.E = new ArrayList<>();
    }

    private CTInAppNotification(Parcel parcel) {
        this.f11367k = new ArrayList<>();
        this.E = new ArrayList<>();
        try {
            this.f11378v = parcel.readString();
            this.f11368l = parcel.readString();
            this.f11379w = (CTInAppType) parcel.readValue(CTInAppType.class.getClassLoader());
            this.f11377u = parcel.readString();
            boolean z7 = true;
            this.f11373q = parcel.readByte() != 0;
            this.I = parcel.readByte() != 0;
            this.f11371o = parcel.readByte() != 0;
            this.D = parcel.readInt();
            this.N = parcel.readInt();
            this.M = parcel.readInt();
            this.H = ((Character) parcel.readValue(Character.TYPE.getClassLoader())).charValue();
            this.f11374r = parcel.readInt();
            this.f11375s = parcel.readInt();
            this.Q = parcel.readInt();
            this.R = parcel.readInt();
            JSONObject jSONObject = null;
            this.B = parcel.readByte() == 0 ? null : new JSONObject(parcel.readString());
            this.f11372p = parcel.readString();
            this.f11369m = parcel.readByte() == 0 ? null : new JSONObject(parcel.readString());
            if (parcel.readByte() != 0) {
                jSONObject = new JSONObject(parcel.readString());
            }
            this.f11364h = jSONObject;
            this.O = parcel.readString();
            this.K = parcel.readString();
            this.L = parcel.readString();
            this.f11365i = parcel.readString();
            this.F = parcel.readString();
            this.G = parcel.readString();
            try {
                this.f11367k = parcel.createTypedArrayList(CTInAppNotificationButton.CREATOR);
            } catch (Throwable unused) {
            }
            try {
                this.E = parcel.createTypedArrayList(CTInAppNotificationMedia.CREATOR);
            } catch (Throwable unused2) {
            }
            this.f11376t = parcel.readByte() != 0;
            this.f11366j = parcel.readInt();
            this.f11382z = parcel.readByte() != 0;
            this.f11370n = parcel.readString();
            this.A = parcel.readByte() != 0;
            this.f11381y = parcel.readByte() != 0;
            if (parcel.readByte() == 0) {
                z7 = false;
            }
            this.f11380x = z7;
            this.C = parcel.readString();
            this.f11363g = parcel.readString();
            this.J = parcel.readLong();
        } catch (JSONException unused3) {
        }
    }
}
