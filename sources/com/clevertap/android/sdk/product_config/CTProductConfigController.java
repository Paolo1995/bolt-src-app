package com.clevertap.android.sdk.product_config;

import android.content.Context;
import android.text.TextUtils;
import com.clevertap.android.sdk.BaseAnalyticsManager;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.CoreMetaData;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.OnSuccessListener;
import com.clevertap.android.sdk.utils.FileUtils;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CTProductConfigController {

    /* renamed from: d  reason: collision with root package name */
    final FileUtils f11651d;

    /* renamed from: e  reason: collision with root package name */
    private final CleverTapInstanceConfig f11652e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f11653f;

    /* renamed from: h  reason: collision with root package name */
    private final BaseAnalyticsManager f11655h;

    /* renamed from: i  reason: collision with root package name */
    private final BaseCallbackManager f11656i;

    /* renamed from: j  reason: collision with root package name */
    private final CoreMetaData f11657j;

    /* renamed from: k  reason: collision with root package name */
    private final ProductConfigSettings f11658k;

    /* renamed from: a  reason: collision with root package name */
    final Map<String, String> f11648a = DesugarCollections.synchronizedMap(new HashMap());

    /* renamed from: b  reason: collision with root package name */
    final Map<String, String> f11649b = DesugarCollections.synchronizedMap(new HashMap());

    /* renamed from: c  reason: collision with root package name */
    AtomicBoolean f11650c = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    private final AtomicBoolean f11654g = new AtomicBoolean(false);

    /* renamed from: l  reason: collision with root package name */
    private final Map<String, String> f11659l = DesugarCollections.synchronizedMap(new HashMap());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.clevertap.android.sdk.product_config.CTProductConfigController$11  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass11 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11661a;

        static {
            int[] iArr = new int[PROCESSING_STATE.values().length];
            f11661a = iArr;
            try {
                iArr[PROCESSING_STATE.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11661a[PROCESSING_STATE.FETCHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11661a[PROCESSING_STATE.ACTIVATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum PROCESSING_STATE {
        INIT,
        FETCHED,
        ACTIVATED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTProductConfigController(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, BaseAnalyticsManager baseAnalyticsManager, CoreMetaData coreMetaData, BaseCallbackManager baseCallbackManager, ProductConfigSettings productConfigSettings, FileUtils fileUtils) {
        this.f11653f = context;
        this.f11652e = cleverTapInstanceConfig;
        this.f11657j = coreMetaData;
        this.f11656i = baseCallbackManager;
        this.f11655h = baseAnalyticsManager;
        this.f11658k = productConfigSettings;
        this.f11651d = fileUtils;
        l();
    }

    private HashMap<String, String> g(JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("kv");
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                    try {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i8);
                        if (jSONObject2 != null) {
                            String string = jSONObject2.getString("n");
                            String string2 = jSONObject2.getString("v");
                            if (!TextUtils.isEmpty(string)) {
                                hashMap.put(string, string2);
                            }
                        }
                    } catch (Exception e8) {
                        e8.printStackTrace();
                        Logger n8 = this.f11652e.n();
                        String a8 = ProductConfigUtil.a(this.f11652e);
                        n8.s(a8, "ConvertServerJsonToMap failed: " + e8.getLocalizedMessage());
                    }
                }
            }
            return hashMap;
        } catch (JSONException e9) {
            e9.printStackTrace();
            Logger n9 = this.f11652e.n();
            String a9 = ProductConfigUtil.a(this.f11652e);
            n9.s(a9, "ConvertServerJsonToMap failed - " + e9.getLocalizedMessage());
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> k(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            String b8 = this.f11651d.b(str);
            Logger n8 = this.f11652e.n();
            String a8 = ProductConfigUtil.a(this.f11652e);
            n8.s(a8, "GetStoredValues reading file success:[ " + str + "]--[Content]" + b8);
            if (!TextUtils.isEmpty(b8)) {
                try {
                    JSONObject jSONObject = new JSONObject(b8);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            try {
                                String valueOf = String.valueOf(jSONObject.get(next));
                                if (!TextUtils.isEmpty(valueOf)) {
                                    hashMap.put(next, valueOf);
                                }
                            } catch (Exception e8) {
                                e8.printStackTrace();
                                Logger n9 = this.f11652e.n();
                                String a9 = ProductConfigUtil.a(this.f11652e);
                                n9.s(a9, "GetStoredValues for key " + next + " while parsing json: " + e8.getLocalizedMessage());
                            }
                        }
                    }
                } catch (Exception e9) {
                    e9.printStackTrace();
                    Logger n10 = this.f11652e.n();
                    String a10 = ProductConfigUtil.a(this.f11652e);
                    n10.s(a10, "GetStoredValues failed due to malformed json: " + e9.getLocalizedMessage());
                }
            }
            return hashMap;
        } catch (Exception e10) {
            e10.printStackTrace();
            Logger n11 = this.f11652e.n();
            String a11 = ProductConfigUtil.a(this.f11652e);
            n11.s(a11, "GetStoredValues reading file failed: " + e10.getLocalizedMessage());
            return hashMap;
        }
    }

    private void n() {
        if (this.f11656i.i() != null) {
            this.f11656i.i().a();
        }
    }

    private void q() {
        if (this.f11656i.i() != null) {
            this.f11656i.i().b();
        }
    }

    private void r() {
        if (this.f11656i.i() != null) {
            this.f11652e.n().s(this.f11652e.c(), "Product Config initialized");
            this.f11656i.i().c();
        }
    }

    private synchronized void s(JSONObject jSONObject) {
        HashMap<String, String> g8 = g(jSONObject);
        this.f11659l.clear();
        this.f11659l.putAll(g8);
        Logger n8 = this.f11652e.n();
        String a8 = ProductConfigUtil.a(this.f11652e);
        n8.s(a8, "Product Config: Fetched response:" + jSONObject);
        Integer num = null;
        try {
            num = (Integer) jSONObject.get("ts");
        } catch (Exception e8) {
            e8.printStackTrace();
            Logger n9 = this.f11652e.n();
            String a9 = ProductConfigUtil.a(this.f11652e);
            n9.s(a9, "ParseFetchedResponse failed: " + e8.getLocalizedMessage());
        }
        if (num != null) {
            this.f11658k.r(num.intValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(PROCESSING_STATE processing_state) {
        if (processing_state != null) {
            int i8 = AnonymousClass11.f11661a[processing_state.ordinal()];
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 == 3) {
                        n();
                        return;
                    }
                    return;
                }
                q();
                return;
            }
            r();
        }
    }

    public void f() {
        if (TextUtils.isEmpty(this.f11658k.g())) {
            return;
        }
        CTExecutorFactory.a(this.f11652e).a().b(new OnSuccessListener<Void>() { // from class: com.clevertap.android.sdk.product_config.CTProductConfigController.2
            @Override // com.clevertap.android.sdk.task.OnSuccessListener
            /* renamed from: a */
            public void onSuccess(Void r22) {
                CTProductConfigController.this.u(PROCESSING_STATE.ACTIVATED);
            }
        }).d("activateProductConfigs", new Callable<Void>() { // from class: com.clevertap.android.sdk.product_config.CTProductConfigController.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                synchronized (this) {
                    try {
                        HashMap hashMap = new HashMap();
                        if (!CTProductConfigController.this.f11659l.isEmpty()) {
                            hashMap.putAll(CTProductConfigController.this.f11659l);
                            CTProductConfigController.this.f11659l.clear();
                        } else {
                            CTProductConfigController cTProductConfigController = CTProductConfigController.this;
                            hashMap = cTProductConfigController.k(cTProductConfigController.h());
                        }
                        CTProductConfigController.this.f11648a.clear();
                        if (!CTProductConfigController.this.f11649b.isEmpty()) {
                            CTProductConfigController cTProductConfigController2 = CTProductConfigController.this;
                            cTProductConfigController2.f11648a.putAll(cTProductConfigController2.f11649b);
                        }
                        CTProductConfigController.this.f11648a.putAll(hashMap);
                        Logger n8 = CTProductConfigController.this.f11652e.n();
                        String a8 = ProductConfigUtil.a(CTProductConfigController.this.f11652e);
                        n8.s(a8, "Activated successfully with configs: " + CTProductConfigController.this.f11648a);
                    } catch (Exception e8) {
                        e8.printStackTrace();
                        Logger n9 = CTProductConfigController.this.f11652e.n();
                        String a9 = ProductConfigUtil.a(CTProductConfigController.this.f11652e);
                        n9.s(a9, "Activate failed: " + e8.getLocalizedMessage());
                    }
                }
                return null;
            }
        });
    }

    String h() {
        return i() + "/activated.json";
    }

    String i() {
        return "Product_Config_" + this.f11652e.c() + "_" + this.f11658k.g();
    }

    public ProductConfigSettings j() {
        return this.f11658k;
    }

    void l() {
        if (TextUtils.isEmpty(this.f11658k.g())) {
            return;
        }
        CTExecutorFactory.a(this.f11652e).a().b(new OnSuccessListener<Boolean>() { // from class: com.clevertap.android.sdk.product_config.CTProductConfigController.8
            @Override // com.clevertap.android.sdk.task.OnSuccessListener
            /* renamed from: a */
            public void onSuccess(Boolean bool) {
                CTProductConfigController.this.u(PROCESSING_STATE.INIT);
            }
        }).d("ProductConfig#initAsync", new Callable<Boolean>() { // from class: com.clevertap.android.sdk.product_config.CTProductConfigController.7
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                Boolean bool;
                synchronized (this) {
                    try {
                        try {
                            if (!CTProductConfigController.this.f11649b.isEmpty()) {
                                CTProductConfigController cTProductConfigController = CTProductConfigController.this;
                                cTProductConfigController.f11648a.putAll(cTProductConfigController.f11649b);
                            }
                            CTProductConfigController cTProductConfigController2 = CTProductConfigController.this;
                            HashMap k8 = cTProductConfigController2.k(cTProductConfigController2.h());
                            if (!k8.isEmpty()) {
                                CTProductConfigController.this.f11659l.putAll(k8);
                            }
                            Logger n8 = CTProductConfigController.this.f11652e.n();
                            String a8 = ProductConfigUtil.a(CTProductConfigController.this.f11652e);
                            n8.s(a8, "Loaded configs ready to be applied: " + CTProductConfigController.this.f11659l);
                            CTProductConfigController.this.f11658k.m(CTProductConfigController.this.f11651d);
                            CTProductConfigController.this.f11650c.set(true);
                            bool = Boolean.TRUE;
                        } catch (Exception e8) {
                            e8.printStackTrace();
                            Logger n9 = CTProductConfigController.this.f11652e.n();
                            String a9 = ProductConfigUtil.a(CTProductConfigController.this.f11652e);
                            n9.s(a9, "InitAsync failed - " + e8.getLocalizedMessage());
                            return Boolean.FALSE;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return bool;
            }
        });
    }

    public boolean m() {
        return this.f11650c.get();
    }

    public void o() {
        this.f11654g.compareAndSet(true, false);
        this.f11652e.n().s(ProductConfigUtil.a(this.f11652e), "Fetch Failed");
    }

    public void p(JSONObject jSONObject) {
        if (TextUtils.isEmpty(this.f11658k.g())) {
            return;
        }
        synchronized (this) {
            if (jSONObject != null) {
                try {
                    s(jSONObject);
                    this.f11651d.c(i(), "activated.json", new JSONObject(this.f11659l));
                    Logger n8 = this.f11652e.n();
                    String a8 = ProductConfigUtil.a(this.f11652e);
                    n8.s(a8, "Fetch file-[" + h() + "] write success: " + this.f11659l);
                    CTExecutorFactory.a(this.f11652e).b().d("sendPCFetchSuccessCallback", new Callable<Void>() { // from class: com.clevertap.android.sdk.product_config.CTProductConfigController.3
                        @Override // java.util.concurrent.Callable
                        /* renamed from: a */
                        public Void call() {
                            CTProductConfigController.this.f11652e.n().s(ProductConfigUtil.a(CTProductConfigController.this.f11652e), "Product Config: fetch Success");
                            CTProductConfigController.this.u(PROCESSING_STATE.FETCHED);
                            return null;
                        }
                    });
                    if (this.f11654g.getAndSet(false)) {
                        f();
                    }
                } catch (Exception e8) {
                    e8.printStackTrace();
                    this.f11652e.n().s(ProductConfigUtil.a(this.f11652e), "Product Config: fetch Failed");
                    u(PROCESSING_STATE.FETCHED);
                    this.f11654g.compareAndSet(true, false);
                }
            }
        }
    }

    public void t() {
        this.f11658k.o(this.f11651d);
    }

    public void v(JSONObject jSONObject) {
        this.f11658k.p(jSONObject);
    }

    public void w(String str) {
        if (!m() && !TextUtils.isEmpty(str)) {
            this.f11658k.q(str);
            l();
        }
    }
}
