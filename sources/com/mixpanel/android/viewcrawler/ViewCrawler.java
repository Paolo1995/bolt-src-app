package com.mixpanel.android.viewcrawler;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.JsonWriter;
import android.util.Pair;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mixpanel.android.mpmetrics.MPConfig;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.mpmetrics.OnMixpanelTweaksUpdatedListener;
import com.mixpanel.android.mpmetrics.ResourceReader;
import com.mixpanel.android.mpmetrics.SuperPropertyUpdate;
import com.mixpanel.android.mpmetrics.Tweaks;
import com.mixpanel.android.util.ImageStore;
import com.mixpanel.android.util.JSONUtils;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.MPPair;
import com.mixpanel.android.viewcrawler.EditProtocol;
import com.mixpanel.android.viewcrawler.EditorConnection;
import com.mixpanel.android.viewcrawler.FlipGesture;
import com.mixpanel.android.viewcrawler.ViewVisitor;
import com.sinch.android.rtc.internal.client.DeviceInformation;
import com.sinch.android.rtc.internal.client.calling.DefaultCallController;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

@TargetApi(16)
/* loaded from: classes3.dex */
public class ViewCrawler implements UpdatesFromMixpanel, TrackingDebug, ViewVisitor.OnLayoutErrorListener {

    /* renamed from: a  reason: collision with root package name */
    private final MPConfig f19503a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f19504b;

    /* renamed from: c  reason: collision with root package name */
    private final MixpanelAPI f19505c;

    /* renamed from: d  reason: collision with root package name */
    private final DynamicEventTracker f19506d;

    /* renamed from: f  reason: collision with root package name */
    private final Tweaks f19508f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, String> f19509g;

    /* renamed from: h  reason: collision with root package name */
    private final ViewCrawlerHandler f19510h;

    /* renamed from: e  reason: collision with root package name */
    private final EditState f19507e = new EditState();

    /* renamed from: i  reason: collision with root package name */
    private final float f19511i = Resources.getSystem().getDisplayMetrics().scaledDensity;

    /* renamed from: j  reason: collision with root package name */
    private final Set<OnMixpanelTweaksUpdatedListener> f19512j = Collections.newSetFromMap(new ConcurrentHashMap());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class Editor implements EditorConnection.Editor {
        private Editor() {
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.Editor
        public void a(JSONObject jSONObject) {
            Message obtainMessage = ViewCrawler.this.f19510h.obtainMessage(2);
            obtainMessage.obj = jSONObject;
            ViewCrawler.this.f19510h.sendMessage(obtainMessage);
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.Editor
        public void b() {
            ViewCrawler.this.f19510h.sendMessage(ViewCrawler.this.f19510h.obtainMessage(8));
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.Editor
        public void c(JSONObject jSONObject) {
            Message obtainMessage = ViewCrawler.this.f19510h.obtainMessage(3);
            obtainMessage.obj = jSONObject;
            ViewCrawler.this.f19510h.sendMessage(obtainMessage);
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.Editor
        public void d(JSONObject jSONObject) {
            Message obtainMessage = ViewCrawler.this.f19510h.obtainMessage(11);
            obtainMessage.obj = jSONObject;
            ViewCrawler.this.f19510h.sendMessage(obtainMessage);
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.Editor
        public void e() {
            ViewCrawler.this.f19510h.sendMessage(ViewCrawler.this.f19510h.obtainMessage(4));
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.Editor
        public void f(JSONObject jSONObject) {
            Message obtainMessage = ViewCrawler.this.f19510h.obtainMessage(6);
            obtainMessage.obj = jSONObject;
            ViewCrawler.this.f19510h.sendMessage(obtainMessage);
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.Editor
        public void g(JSONObject jSONObject) {
            Message obtainMessage = ViewCrawler.this.f19510h.obtainMessage(10);
            obtainMessage.obj = jSONObject;
            ViewCrawler.this.f19510h.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class EmulatorConnector implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private volatile boolean f19515f = true;

        public EmulatorConnector() {
        }

        public void a() {
            this.f19515f = false;
            ViewCrawler.this.f19510h.post(this);
        }

        public void b() {
            this.f19515f = true;
            ViewCrawler.this.f19510h.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f19515f) {
                ViewCrawler.this.f19510h.sendMessage(ViewCrawler.this.f19510h.obtainMessage(1));
            }
            ViewCrawler.this.f19510h.postDelayed(this, DefaultCallController.ICE_SERVERS_VALID_WINDOW_MS);
        }
    }

    /* loaded from: classes3.dex */
    private class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks, FlipGesture.OnFlipGestureListener {

        /* renamed from: f  reason: collision with root package name */
        private final FlipGesture f19517f = new FlipGesture(this);

        /* renamed from: g  reason: collision with root package name */
        private final EmulatorConnector f19518g;

        public LifecycleCallbacks() {
            this.f19518g = new EmulatorConnector();
        }

        private void b(Activity activity) {
            if (c() && !ViewCrawler.this.f19503a.g()) {
                this.f19518g.a();
            } else if (!ViewCrawler.this.f19503a.i()) {
                SensorManager sensorManager = (SensorManager) activity.getSystemService("sensor");
                sensorManager.registerListener(this.f19517f, sensorManager.getDefaultSensor(1), 3);
            }
        }

        private boolean c() {
            String str = Build.HARDWARE;
            if (!str.toLowerCase().equals("goldfish") && !str.toLowerCase().equals("ranchu")) {
                return false;
            }
            String str2 = Build.BRAND;
            if ((!str2.toLowerCase().startsWith("generic") && !str2.toLowerCase().equals("android") && !str2.toLowerCase().equals("google")) || !Build.DEVICE.toLowerCase().startsWith("generic") || !Build.PRODUCT.toLowerCase().contains("sdk") || !Build.MODEL.toLowerCase(Locale.US).contains("sdk")) {
                return false;
            }
            return true;
        }

        private void d(Activity activity) {
            if (c() && !ViewCrawler.this.f19503a.g()) {
                this.f19518g.b();
            } else if (!ViewCrawler.this.f19503a.i()) {
                ((SensorManager) activity.getSystemService("sensor")).unregisterListener(this.f19517f);
            }
        }

        @Override // com.mixpanel.android.viewcrawler.FlipGesture.OnFlipGestureListener
        public void a() {
            ViewCrawler.this.f19505c.U("$ab_gesture3");
            ViewCrawler.this.f19510h.sendMessage(ViewCrawler.this.f19510h.obtainMessage(1));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            ViewCrawler.this.f19507e.i(activity);
            d(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            b(activity);
            ViewCrawler.this.f19507e.e(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class VariantChange {

        /* renamed from: a  reason: collision with root package name */
        public final String f19520a;

        /* renamed from: b  reason: collision with root package name */
        public final String f19521b;

        /* renamed from: c  reason: collision with root package name */
        public final JSONObject f19522c;

        /* renamed from: d  reason: collision with root package name */
        public final MPPair<Integer, Integer> f19523d;

        public VariantChange(String str, String str2, JSONObject jSONObject, MPPair<Integer, Integer> mPPair) {
            this.f19520a = str;
            this.f19521b = str2;
            this.f19522c = jSONObject;
            this.f19523d = mPPair;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof VariantChange) || obj.hashCode() != hashCode()) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f19520a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class VariantTweak {

        /* renamed from: a  reason: collision with root package name */
        public final String f19524a;

        /* renamed from: b  reason: collision with root package name */
        public final JSONObject f19525b;

        /* renamed from: c  reason: collision with root package name */
        public final MPPair<Integer, Integer> f19526c;

        public VariantTweak(String str, JSONObject jSONObject, MPPair<Integer, Integer> mPPair) {
            this.f19524a = str;
            this.f19525b = jSONObject;
            this.f19526c = mPPair;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof VariantTweak) || obj.hashCode() != hashCode()) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f19524a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class ViewCrawlerHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private EditorConnection f19527a;

        /* renamed from: b  reason: collision with root package name */
        private ViewSnapshot f19528b;

        /* renamed from: c  reason: collision with root package name */
        private final String f19529c;

        /* renamed from: d  reason: collision with root package name */
        private final Lock f19530d;

        /* renamed from: e  reason: collision with root package name */
        private final EditProtocol f19531e;

        /* renamed from: f  reason: collision with root package name */
        private final ImageStore f19532f;

        /* renamed from: g  reason: collision with root package name */
        private final Map<String, MPPair<String, JSONObject>> f19533g;

        /* renamed from: h  reason: collision with root package name */
        private final Map<String, MPPair<String, Object>> f19534h;

        /* renamed from: i  reason: collision with root package name */
        private final List<String> f19535i;

        /* renamed from: j  reason: collision with root package name */
        private final Map<String, MPPair<String, JSONObject>> f19536j;

        /* renamed from: k  reason: collision with root package name */
        private final Set<VariantChange> f19537k;

        /* renamed from: l  reason: collision with root package name */
        private final Set<VariantTweak> f19538l;

        /* renamed from: m  reason: collision with root package name */
        private final Set<MPPair<Integer, Integer>> f19539m;

        /* renamed from: n  reason: collision with root package name */
        private final Set<MPPair<String, JSONObject>> f19540n;

        /* renamed from: o  reason: collision with root package name */
        private final Set<MPPair<String, JSONObject>> f19541o;

        /* renamed from: p  reason: collision with root package name */
        private final Set<MPPair<Integer, Integer>> f19542p;

        public ViewCrawlerHandler(Context context, String str, Looper looper, ViewVisitor.OnLayoutErrorListener onLayoutErrorListener) {
            super(looper);
            this.f19529c = str;
            this.f19528b = null;
            String B = ViewCrawler.this.f19503a.B();
            ResourceReader.Ids ids = new ResourceReader.Ids(B == null ? context.getPackageName() : B, context);
            ImageStore imageStore = new ImageStore(context, "ViewCrawler");
            this.f19532f = imageStore;
            this.f19531e = new EditProtocol(context, ids, imageStore, onLayoutErrorListener);
            this.f19541o = new HashSet();
            this.f19533g = new HashMap();
            this.f19534h = new HashMap();
            this.f19535i = new ArrayList();
            this.f19536j = new HashMap();
            this.f19537k = new HashSet();
            this.f19538l = new HashSet();
            this.f19539m = new HashSet();
            this.f19540n = new HashSet();
            this.f19542p = new HashSet();
            ReentrantLock reentrantLock = new ReentrantLock();
            this.f19530d = reentrantLock;
            reentrantLock.lock();
        }

        private void a() {
            List arrayList;
            ArrayList arrayList2 = new ArrayList();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (VariantChange variantChange : this.f19537k) {
                try {
                    arrayList2.add(new MPPair(variantChange.f19521b, this.f19531e.c(variantChange.f19522c).f19456a));
                    if (!this.f19542p.contains(variantChange.f19523d)) {
                        hashSet.add(variantChange.f19523d);
                    }
                } catch (EditProtocol.CantGetEditAssetsException e8) {
                    MPLog.j("MixpanelAPI.ViewCrawler", "Can't load assets for an edit, won't apply the change now", e8);
                } catch (EditProtocol.InapplicableInstructionsException e9) {
                    MPLog.e("MixpanelAPI.ViewCrawler", e9.getMessage());
                } catch (EditProtocol.BadInstructionsException e10) {
                    MPLog.d("MixpanelAPI.ViewCrawler", "Bad persistent change request cannot be applied.", e10);
                }
            }
            for (VariantTweak variantTweak : this.f19538l) {
                try {
                    MPPair<String, Object> h8 = this.f19531e.h(variantTweak.f19525b);
                    if (this.f19542p.contains(variantTweak.f19526c)) {
                        if (ViewCrawler.this.f19508f.e((String) ((Pair) h8).first, ((Pair) h8).second)) {
                            hashSet2.add(((Pair) h8).first);
                        }
                    } else {
                        hashSet.add(variantTweak.f19526c);
                        hashSet2.add(((Pair) h8).first);
                    }
                    if (ViewCrawler.this.f19508f.c().containsKey(((Pair) h8).first)) {
                        ViewCrawler.this.f19508f.f((String) ((Pair) h8).first, ((Pair) h8).second);
                    } else {
                        ViewCrawler.this.f19508f.b((String) ((Pair) h8).first, Tweaks.TweakValue.b(variantTweak.f19525b));
                    }
                } catch (EditProtocol.BadInstructionsException e11) {
                    MPLog.d("MixpanelAPI.ViewCrawler", "Bad editor tweak cannot be applied.", e11);
                }
            }
            if (this.f19538l.size() == 0) {
                for (Map.Entry<String, Tweaks.TweakValue> entry : ViewCrawler.this.f19508f.d().entrySet()) {
                    Tweaks.TweakValue value = entry.getValue();
                    String key = entry.getKey();
                    if (ViewCrawler.this.f19508f.e(key, value.i())) {
                        ViewCrawler.this.f19508f.f(key, value.i());
                        hashSet2.add(key);
                    }
                }
            }
            for (MPPair<String, JSONObject> mPPair : this.f19533g.values()) {
                try {
                    EditProtocol.Edit c8 = this.f19531e.c((JSONObject) ((Pair) mPPair).second);
                    arrayList2.add(new MPPair(((Pair) mPPair).first, c8.f19456a));
                    this.f19535i.addAll(c8.f19457b);
                } catch (EditProtocol.InapplicableInstructionsException e12) {
                    MPLog.e("MixpanelAPI.ViewCrawler", e12.getMessage());
                } catch (EditProtocol.BadInstructionsException e13) {
                    MPLog.d("MixpanelAPI.ViewCrawler", "Bad editor change request cannot be applied.", e13);
                } catch (EditProtocol.CantGetEditAssetsException e14) {
                    MPLog.j("MixpanelAPI.ViewCrawler", "Can't load assets for an edit, won't apply the change now", e14);
                }
            }
            for (MPPair<String, Object> mPPair2 : this.f19534h.values()) {
                if (ViewCrawler.this.f19508f.e((String) ((Pair) mPPair2).first, ((Pair) mPPair2).second)) {
                    hashSet2.add(((Pair) mPPair2).first);
                }
                ViewCrawler.this.f19508f.f((String) ((Pair) mPPair2).first, ((Pair) mPPair2).second);
            }
            if (this.f19536j.size() == 0 && this.f19541o.size() == 0) {
                for (MPPair<String, JSONObject> mPPair3 : this.f19540n) {
                    try {
                        arrayList2.add(new MPPair(((Pair) mPPair3).first, this.f19531e.d((JSONObject) ((Pair) mPPair3).second, ViewCrawler.this.f19506d)));
                    } catch (EditProtocol.InapplicableInstructionsException e15) {
                        MPLog.e("MixpanelAPI.ViewCrawler", e15.getMessage());
                    } catch (EditProtocol.BadInstructionsException e16) {
                        MPLog.d("MixpanelAPI.ViewCrawler", "Bad persistent event binding cannot be applied.", e16);
                    }
                }
            }
            for (MPPair<String, JSONObject> mPPair4 : this.f19536j.values()) {
                try {
                    arrayList2.add(new MPPair(((Pair) mPPair4).first, this.f19531e.d((JSONObject) ((Pair) mPPair4).second, ViewCrawler.this.f19506d)));
                } catch (EditProtocol.InapplicableInstructionsException e17) {
                    MPLog.e("MixpanelAPI.ViewCrawler", e17.getMessage());
                } catch (EditProtocol.BadInstructionsException e18) {
                    MPLog.d("MixpanelAPI.ViewCrawler", "Bad editor event binding cannot be applied.", e18);
                }
            }
            HashMap hashMap = new HashMap();
            int size = arrayList2.size();
            for (int i8 = 0; i8 < size; i8++) {
                MPPair mPPair5 = (MPPair) arrayList2.get(i8);
                if (hashMap.containsKey(((Pair) mPPair5).first)) {
                    arrayList = (List) hashMap.get(((Pair) mPPair5).first);
                } else {
                    arrayList = new ArrayList();
                    hashMap.put(((Pair) mPPair5).first, arrayList);
                }
                arrayList.add(((Pair) mPPair5).second);
            }
            ViewCrawler.this.f19507e.j(hashMap);
            for (MPPair<Integer, Integer> mPPair6 : this.f19539m) {
                if (!this.f19542p.contains(mPPair6)) {
                    hashSet.add(mPPair6);
                }
            }
            this.f19542p.addAll(hashSet);
            u(hashSet);
            this.f19539m.clear();
            if (hashSet2.size() > 0) {
                for (OnMixpanelTweaksUpdatedListener onMixpanelTweaksUpdatedListener : ViewCrawler.this.f19512j) {
                    onMixpanelTweaksUpdatedListener.a(hashSet2);
                }
            }
        }

        private void b() {
            MPLog.i("MixpanelAPI.ViewCrawler", "connecting to editor");
            EditorConnection editorConnection = this.f19527a;
            if (editorConnection != null && editorConnection.g()) {
                MPLog.i("MixpanelAPI.ViewCrawler", "There is already a valid connection to an events editor.");
                return;
            }
            SSLSocketFactory C = ViewCrawler.this.f19503a.C();
            if (C == null) {
                MPLog.i("MixpanelAPI.ViewCrawler", "SSL is not available on this device, no connection will be attempted to the events editor.");
                return;
            }
            String str = MPConfig.s(ViewCrawler.this.f19504b).l() + this.f19529c;
            try {
                this.f19527a = new EditorConnection(new URI(str), new Editor(), C.createSocket());
            } catch (EditorConnection.EditorConnectionException e8) {
                MPLog.d("MixpanelAPI.ViewCrawler", "Error connecting to URI " + str, e8);
            } catch (IOException e9) {
                MPLog.f("MixpanelAPI.ViewCrawler", "Can't create SSL Socket to connect to editor service", e9);
            } catch (URISyntaxException e10) {
                MPLog.d("MixpanelAPI.ViewCrawler", "Error parsing URI " + str + " for editor websocket", e10);
            }
        }

        private SharedPreferences c() {
            return ViewCrawler.this.f19504b.getSharedPreferences("mixpanel.viewcrawler.changes" + this.f19529c, 0);
        }

        private void d(JSONObject jSONObject) {
            try {
                JSONArray jSONArray = jSONObject.getJSONObject("payload").getJSONArray("actions");
                for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                    this.f19533g.remove(jSONArray.getString(i8));
                }
            } catch (JSONException e8) {
                MPLog.d("MixpanelAPI.ViewCrawler", "Bad clear request received", e8);
            }
            a();
        }

        private void e(JSONObject jSONObject) {
            try {
                JSONArray jSONArray = jSONObject.getJSONObject("payload").getJSONArray("events");
                int length = jSONArray.length();
                this.f19536j.clear();
                if (!this.f19540n.isEmpty() && this.f19541o.isEmpty()) {
                    this.f19541o.addAll(this.f19540n);
                    for (MPPair<String, JSONObject> mPPair : this.f19540n) {
                        try {
                            this.f19536j.put(((JSONObject) ((Pair) mPPair).second).get("path").toString(), mPPair);
                        } catch (JSONException e8) {
                            e8.printStackTrace();
                        }
                    }
                    this.f19540n.clear();
                }
                for (int i8 = 0; i8 < length; i8++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i8);
                        this.f19536j.put(jSONObject2.get("path").toString(), new MPPair<>(JSONUtils.a(jSONObject2, "target_activity"), jSONObject2));
                    } catch (JSONException e9) {
                        MPLog.d("MixpanelAPI.ViewCrawler", "Bad event binding received from editor in " + jSONArray.toString(), e9);
                    }
                }
                a();
            } catch (JSONException e10) {
                MPLog.d("MixpanelAPI.ViewCrawler", "Bad event bindings received", e10);
            }
        }

        private void f(JSONObject jSONObject) {
            try {
                JSONArray jSONArray = jSONObject.getJSONObject("payload").getJSONArray("actions");
                for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i8);
                    String a8 = JSONUtils.a(jSONObject2, "target_activity");
                    this.f19533g.put(jSONObject2.getString("name"), new MPPair<>(a8, jSONObject2));
                }
                a();
            } catch (JSONException e8) {
                MPLog.d("MixpanelAPI.ViewCrawler", "Bad change request received", e8);
            }
        }

        private void g() {
            this.f19533g.clear();
            this.f19536j.clear();
            this.f19534h.clear();
            this.f19540n.addAll(this.f19541o);
            this.f19541o.clear();
            this.f19528b = null;
            MPLog.i("MixpanelAPI.ViewCrawler", "Editor closed- freeing snapshot");
            a();
            for (String str : this.f19535i) {
                this.f19532f.c(str);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void h(JSONObject jSONObject) {
            try {
                JSONArray jSONArray = jSONObject.getJSONObject("payload").getJSONArray("tweaks");
                int length = jSONArray.length();
                for (int i8 = 0; i8 < length; i8++) {
                    MPPair<String, Object> h8 = this.f19531e.h(jSONArray.getJSONObject(i8));
                    this.f19534h.put(((Pair) h8).first, h8);
                }
            } catch (EditProtocol.BadInstructionsException e8) {
                MPLog.d("MixpanelAPI.ViewCrawler", "Bad tweaks received", e8);
            } catch (JSONException e9) {
                MPLog.d("MixpanelAPI.ViewCrawler", "Bad tweaks received", e9);
            }
            a();
        }

        private void i(JSONArray jSONArray) {
            SharedPreferences.Editor edit = c().edit();
            edit.putString("mixpanel.viewcrawler.bindings", jSONArray.toString());
            edit.apply();
            k(jSONArray.toString());
            a();
        }

        private void j(JSONArray jSONArray) {
            n(jSONArray);
            m(jSONArray.toString(), true);
            a();
        }

        private void k(String str) {
            if (str != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    this.f19540n.clear();
                    for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i8);
                        this.f19540n.add(new MPPair<>(JSONUtils.a(jSONObject, "target_activity"), jSONObject));
                    }
                } catch (JSONException e8) {
                    MPLog.f("MixpanelAPI.ViewCrawler", "JSON error when loading event bindings, clearing persistent memory", e8);
                    SharedPreferences.Editor edit = c().edit();
                    edit.remove("mixpanel.viewcrawler.bindings");
                    edit.apply();
                }
            }
        }

        private void l() {
            SharedPreferences c8 = c();
            String string = c8.getString("mixpanel.viewcrawler.changes", null);
            String string2 = c8.getString("mixpanel.viewcrawler.bindings", null);
            this.f19537k.clear();
            this.f19538l.clear();
            this.f19542p.clear();
            m(string, false);
            this.f19540n.clear();
            k(string2);
            a();
        }

        private void m(String str, boolean z7) {
            if (str != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    int length = jSONArray.length();
                    for (int i8 = 0; i8 < length; i8++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i8);
                        MPPair<Integer, Integer> mPPair = new MPPair<>(Integer.valueOf(jSONObject.getInt("experiment_id")), Integer.valueOf(jSONObject.getInt(Name.MARK)));
                        JSONArray jSONArray2 = jSONObject.getJSONArray("actions");
                        int length2 = jSONArray2.length();
                        for (int i9 = 0; i9 < length2; i9++) {
                            JSONObject jSONObject2 = jSONArray2.getJSONObject(i9);
                            this.f19537k.add(new VariantChange(jSONObject2.getString("name"), JSONUtils.a(jSONObject2, "target_activity"), jSONObject2, mPPair));
                        }
                        JSONArray jSONArray3 = jSONObject.getJSONArray("tweaks");
                        int length3 = jSONArray3.length();
                        for (int i10 = 0; i10 < length3; i10++) {
                            JSONObject jSONObject3 = jSONArray3.getJSONObject(i10);
                            this.f19538l.add(new VariantTweak(jSONObject3.getString("name"), jSONObject3, mPPair));
                        }
                        if (!z7) {
                            this.f19542p.add(mPPair);
                        }
                        if (length3 == 0 && length2 == 0) {
                            this.f19539m.add(mPPair);
                        }
                    }
                } catch (JSONException e8) {
                    MPLog.f("MixpanelAPI.ViewCrawler", "JSON error when loading ab tests / tweaks, clearing persistent memory", e8);
                    SharedPreferences.Editor edit = c().edit();
                    edit.remove("mixpanel.viewcrawler.changes");
                    edit.apply();
                }
            }
        }

        private void n(JSONArray jSONArray) {
            SharedPreferences.Editor edit = c().edit();
            edit.putString("mixpanel.viewcrawler.changes", jSONArray.toString());
            edit.apply();
        }

        private void o() {
            EditorConnection editorConnection = this.f19527a;
            if (editorConnection != null && editorConnection.g() && this.f19527a.f()) {
                JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(this.f19527a.e()));
                try {
                    try {
                        try {
                            jsonWriter.beginObject();
                            jsonWriter.name("type").value("device_info_response");
                            jsonWriter.name("payload").beginObject();
                            jsonWriter.name("device_type").value(DeviceInformation.osName);
                            JsonWriter name = jsonWriter.name("device_name");
                            name.value(Build.BRAND + "/" + Build.MODEL);
                            jsonWriter.name("scaled_density").value((double) ViewCrawler.this.f19511i);
                            for (Map.Entry entry : ViewCrawler.this.f19509g.entrySet()) {
                                jsonWriter.name((String) entry.getKey()).value((String) entry.getValue());
                            }
                            Map<String, Tweaks.TweakValue> c8 = ViewCrawler.this.f19508f.c();
                            jsonWriter.name("tweaks").beginArray();
                            for (Map.Entry<String, Tweaks.TweakValue> entry2 : c8.entrySet()) {
                                Tweaks.TweakValue value = entry2.getValue();
                                jsonWriter.beginObject();
                                jsonWriter.name("name").value(entry2.getKey());
                                jsonWriter.name("minimum").value(value.f());
                                jsonWriter.name("maximum").value(value.e());
                                int i8 = value.f19382a;
                                if (i8 != 1) {
                                    if (i8 != 2) {
                                        if (i8 != 3) {
                                            if (i8 != 4) {
                                                MPLog.m("MixpanelAPI.ViewCrawler", "Unrecognized Tweak Type " + value.f19382a + " encountered.");
                                            } else {
                                                jsonWriter.name("type").value("string");
                                                jsonWriter.name(AppMeasurementSdk.ConditionalUserProperty.VALUE).value(value.h());
                                                jsonWriter.name("default").value((String) value.d());
                                            }
                                        } else {
                                            jsonWriter.name("type").value("number");
                                            jsonWriter.name("encoding").value("l");
                                            jsonWriter.name(AppMeasurementSdk.ConditionalUserProperty.VALUE).value(value.g().longValue());
                                            jsonWriter.name("default").value(((Number) value.d()).longValue());
                                        }
                                    } else {
                                        jsonWriter.name("type").value("number");
                                        jsonWriter.name("encoding").value("d");
                                        jsonWriter.name(AppMeasurementSdk.ConditionalUserProperty.VALUE).value(value.g().doubleValue());
                                        jsonWriter.name("default").value(((Number) value.d()).doubleValue());
                                    }
                                } else {
                                    jsonWriter.name("type").value("boolean");
                                    jsonWriter.name(AppMeasurementSdk.ConditionalUserProperty.VALUE).value(value.c().booleanValue());
                                    jsonWriter.name("default").value(((Boolean) value.d()).booleanValue());
                                }
                                jsonWriter.endObject();
                            }
                            jsonWriter.endArray();
                            jsonWriter.endObject();
                            jsonWriter.endObject();
                            jsonWriter.close();
                        } catch (IOException e8) {
                            MPLog.d("MixpanelAPI.ViewCrawler", "Can't write device_info to server", e8);
                            jsonWriter.close();
                        }
                    } catch (Throwable th) {
                        try {
                            jsonWriter.close();
                        } catch (IOException e9) {
                            MPLog.d("MixpanelAPI.ViewCrawler", "Can't close websocket writer", e9);
                        }
                        throw th;
                    }
                } catch (IOException e10) {
                    MPLog.d("MixpanelAPI.ViewCrawler", "Can't close websocket writer", e10);
                }
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:24:0x0059
            	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1234)
            	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1018)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
            */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005a -> B:26:0x005d). Please submit an issue!!! */
        private void p(java.lang.String r5) {
            /*
                r4 = this;
                java.lang.String r0 = "Could not close output writer to editor"
                java.lang.String r1 = "MixpanelAPI.ViewCrawler"
                com.mixpanel.android.viewcrawler.EditorConnection r2 = r4.f19527a
                if (r2 == 0) goto L67
                boolean r2 = r2.g()
                if (r2 == 0) goto L67
                com.mixpanel.android.viewcrawler.EditorConnection r2 = r4.f19527a
                boolean r2 = r2.f()
                if (r2 != 0) goto L17
                goto L67
            L17:
                org.json.JSONObject r2 = new org.json.JSONObject
                r2.<init>()
                java.lang.String r3 = "error_message"
                r2.put(r3, r5)     // Catch: org.json.JSONException -> L22
                goto L28
            L22:
                r5 = move-exception
                java.lang.String r3 = "Apparently impossible JSONException"
                com.mixpanel.android.util.MPLog.d(r1, r3, r5)
            L28:
                java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter
                com.mixpanel.android.viewcrawler.EditorConnection r3 = r4.f19527a
                java.io.BufferedOutputStream r3 = r3.e()
                r5.<init>(r3)
                java.lang.String r3 = "{\"type\": \"error\", "
                r5.write(r3)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
                java.lang.String r3 = "\"payload\": "
                r5.write(r3)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
                r5.write(r2)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
                java.lang.String r2 = "}"
                r5.write(r2)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
                r5.close()     // Catch: java.io.IOException -> L59
                goto L5d
            L4d:
                r2 = move-exception
                goto L5e
            L4f:
                r2 = move-exception
                java.lang.String r3 = "Can't write error message to editor"
                com.mixpanel.android.util.MPLog.d(r1, r3, r2)     // Catch: java.lang.Throwable -> L4d
                r5.close()     // Catch: java.io.IOException -> L59
                goto L5d
            L59:
                r5 = move-exception
                com.mixpanel.android.util.MPLog.d(r1, r0, r5)
            L5d:
                return
            L5e:
                r5.close()     // Catch: java.io.IOException -> L62
                goto L66
            L62:
                r5 = move-exception
                com.mixpanel.android.util.MPLog.d(r1, r0, r5)
            L66:
                throw r2
            L67:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.viewcrawler.ViewCrawler.ViewCrawlerHandler.p(java.lang.String):void");
        }

        private void q(ViewVisitor.LayoutErrorMessage layoutErrorMessage) {
            EditorConnection editorConnection = this.f19527a;
            if (editorConnection != null && editorConnection.g() && this.f19527a.f()) {
                JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(this.f19527a.e()));
                try {
                    try {
                        try {
                            jsonWriter.beginObject();
                            jsonWriter.name("type").value("layout_error");
                            jsonWriter.name("exception_type").value(layoutErrorMessage.a());
                            jsonWriter.name("cid").value(layoutErrorMessage.b());
                            jsonWriter.endObject();
                            jsonWriter.close();
                        } catch (IOException e8) {
                            MPLog.d("MixpanelAPI.ViewCrawler", "Can't write track_message to server", e8);
                            jsonWriter.close();
                        }
                    } catch (Throwable th) {
                        try {
                            jsonWriter.close();
                        } catch (IOException e9) {
                            MPLog.d("MixpanelAPI.ViewCrawler", "Can't close writer.", e9);
                        }
                        throw th;
                    }
                } catch (IOException e10) {
                    MPLog.d("MixpanelAPI.ViewCrawler", "Can't close writer.", e10);
                }
            }
        }

        private void r(String str) {
            EditorConnection editorConnection = this.f19527a;
            if (editorConnection != null && editorConnection.g() && this.f19527a.f()) {
                JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(this.f19527a.e()));
                try {
                    try {
                        try {
                            jsonWriter.beginObject();
                            jsonWriter.name("type").value("track_message");
                            jsonWriter.name("payload");
                            jsonWriter.beginObject();
                            jsonWriter.name("event_name").value(str);
                            jsonWriter.endObject();
                            jsonWriter.endObject();
                            jsonWriter.flush();
                            jsonWriter.close();
                        } catch (IOException e8) {
                            MPLog.d("MixpanelAPI.ViewCrawler", "Can't write track_message to server", e8);
                            jsonWriter.close();
                        }
                    } catch (Throwable th) {
                        try {
                            jsonWriter.close();
                        } catch (IOException e9) {
                            MPLog.d("MixpanelAPI.ViewCrawler", "Can't close writer.", e9);
                        }
                        throw th;
                    }
                } catch (IOException e10) {
                    MPLog.d("MixpanelAPI.ViewCrawler", "Can't close writer.", e10);
                }
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:20:0x0088
            	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1234)
            	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1018)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
            */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0089 -> B:22:0x008c). Please submit an issue!!! */
        private void s(org.json.JSONObject r9) {
            /*
                r8 = this;
                java.lang.String r0 = "}"
                java.lang.String r1 = "Can't close writer."
                java.lang.String r2 = "MixpanelAPI.ViewCrawler"
                long r3 = java.lang.System.currentTimeMillis()
                java.lang.String r5 = "payload"
                org.json.JSONObject r9 = r9.getJSONObject(r5)     // Catch: com.mixpanel.android.viewcrawler.EditProtocol.BadInstructionsException -> L96 org.json.JSONException -> La4
                java.lang.String r5 = "config"
                boolean r5 = r9.has(r5)     // Catch: com.mixpanel.android.viewcrawler.EditProtocol.BadInstructionsException -> L96 org.json.JSONException -> La4
                if (r5 == 0) goto L25
                com.mixpanel.android.viewcrawler.EditProtocol r5 = r8.f19531e     // Catch: com.mixpanel.android.viewcrawler.EditProtocol.BadInstructionsException -> L96 org.json.JSONException -> La4
                com.mixpanel.android.viewcrawler.ViewSnapshot r9 = r5.g(r9)     // Catch: com.mixpanel.android.viewcrawler.EditProtocol.BadInstructionsException -> L96 org.json.JSONException -> La4
                r8.f19528b = r9     // Catch: com.mixpanel.android.viewcrawler.EditProtocol.BadInstructionsException -> L96 org.json.JSONException -> La4
                java.lang.String r9 = "Initializing snapshot with configuration"
                com.mixpanel.android.util.MPLog.i(r2, r9)     // Catch: com.mixpanel.android.viewcrawler.EditProtocol.BadInstructionsException -> L96 org.json.JSONException -> La4
            L25:
                com.mixpanel.android.viewcrawler.ViewSnapshot r9 = r8.f19528b
                if (r9 != 0) goto L34
                java.lang.String r9 = "No snapshot configuration (or a malformed snapshot configuration) was sent."
                r8.p(r9)
                java.lang.String r9 = "Mixpanel editor is misconfigured, sent a snapshot request without a valid configuration."
                com.mixpanel.android.util.MPLog.k(r2, r9)
                return
            L34:
                com.mixpanel.android.viewcrawler.EditorConnection r9 = r8.f19527a
                java.io.BufferedOutputStream r9 = r9.e()
                java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter
                r5.<init>(r9)
                java.lang.String r6 = "{"
                r5.write(r6)     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7e
                java.lang.String r6 = "\"type\": \"snapshot_response\","
                r5.write(r6)     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7e
                java.lang.String r6 = "\"payload\": {"
                r5.write(r6)     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7e
                java.lang.String r6 = "\"activities\":"
                r5.write(r6)     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7e
                r5.flush()     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7e
                com.mixpanel.android.viewcrawler.ViewSnapshot r6 = r8.f19528b     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7e
                com.mixpanel.android.viewcrawler.ViewCrawler r7 = com.mixpanel.android.viewcrawler.ViewCrawler.this     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7e
                com.mixpanel.android.viewcrawler.EditState r7 = com.mixpanel.android.viewcrawler.ViewCrawler.k(r7)     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7e
                r6.d(r7, r9)     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7e
                long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7e
                long r6 = r6 - r3
                java.lang.String r9 = ",\"snapshot_time_millis\": "
                r5.write(r9)     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7e
                java.lang.String r9 = java.lang.Long.toString(r6)     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7e
                r5.write(r9)     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7e
                r5.write(r0)     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7e
                r5.write(r0)     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7e
                r5.close()     // Catch: java.io.IOException -> L88
                goto L8c
            L7c:
                r9 = move-exception
                goto L8d
            L7e:
                r9 = move-exception
                java.lang.String r0 = "Can't write snapshot request to server"
                com.mixpanel.android.util.MPLog.d(r2, r0, r9)     // Catch: java.lang.Throwable -> L7c
                r5.close()     // Catch: java.io.IOException -> L88
                goto L8c
            L88:
                r9 = move-exception
                com.mixpanel.android.util.MPLog.d(r2, r1, r9)
            L8c:
                return
            L8d:
                r5.close()     // Catch: java.io.IOException -> L91
                goto L95
            L91:
                r0 = move-exception
                com.mixpanel.android.util.MPLog.d(r2, r1, r0)
            L95:
                throw r9
            L96:
                r9 = move-exception
                java.lang.String r0 = "Editor sent malformed message with snapshot request"
                com.mixpanel.android.util.MPLog.d(r2, r0, r9)
                java.lang.String r9 = r9.getMessage()
                r8.p(r9)
                return
            La4:
                r9 = move-exception
                java.lang.String r0 = "Payload with snapshot config required with snapshot request"
                com.mixpanel.android.util.MPLog.d(r2, r0, r9)
                r8.p(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.viewcrawler.ViewCrawler.ViewCrawlerHandler.s(org.json.JSONObject):void");
        }

        private void u(Set<MPPair<Integer, Integer>> set) {
            if (set != null && set.size() > 0) {
                final JSONObject jSONObject = new JSONObject();
                try {
                    for (MPPair<Integer, Integer> mPPair : set) {
                        int intValue = ((Integer) ((Pair) mPPair).first).intValue();
                        int intValue2 = ((Integer) ((Pair) mPPair).second).intValue();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("$experiment_id", intValue);
                        jSONObject2.put("$variant_id", intValue2);
                        jSONObject.put(Integer.toString(intValue), intValue2);
                        ViewCrawler.this.f19505c.C().d("$experiments", jSONObject);
                        ViewCrawler.this.f19505c.a0(new SuperPropertyUpdate() { // from class: com.mixpanel.android.viewcrawler.ViewCrawler.ViewCrawlerHandler.1
                            @Override // com.mixpanel.android.mpmetrics.SuperPropertyUpdate
                            public JSONObject a(JSONObject jSONObject3) {
                                try {
                                    jSONObject3.put("$experiments", jSONObject);
                                } catch (JSONException e8) {
                                    MPLog.n("MixpanelAPI.ViewCrawler", "Can't write $experiments super property", e8);
                                }
                                return jSONObject3;
                            }
                        });
                        ViewCrawler.this.f19505c.V("$experiment_started", jSONObject2);
                    }
                } catch (JSONException e8) {
                    MPLog.n("MixpanelAPI.ViewCrawler", "Could not build JSON for reporting experiment start", e8);
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.f19530d.lock();
            try {
                switch (message.what) {
                    case 0:
                        l();
                        break;
                    case 1:
                        b();
                        break;
                    case 2:
                        s((JSONObject) message.obj);
                        break;
                    case 3:
                        f((JSONObject) message.obj);
                        break;
                    case 4:
                        o();
                        break;
                    case 5:
                        i((JSONArray) message.obj);
                        break;
                    case 6:
                        e((JSONObject) message.obj);
                        break;
                    case 7:
                        r((String) message.obj);
                        break;
                    case 8:
                        g();
                        break;
                    case 9:
                        j((JSONArray) message.obj);
                        break;
                    case 10:
                        d((JSONObject) message.obj);
                        break;
                    case 11:
                        h((JSONObject) message.obj);
                        break;
                    case 12:
                        q((ViewVisitor.LayoutErrorMessage) message.obj);
                        break;
                    case 13:
                        n((JSONArray) message.obj);
                        break;
                }
            } finally {
                this.f19530d.unlock();
            }
        }

        public void t() {
            this.f19530d.unlock();
        }
    }

    public ViewCrawler(Context context, String str, MixpanelAPI mixpanelAPI, Tweaks tweaks) {
        this.f19503a = MPConfig.s(context);
        this.f19504b = context;
        this.f19508f = tweaks;
        this.f19509g = mixpanelAPI.x();
        HandlerThread handlerThread = new HandlerThread(ViewCrawler.class.getCanonicalName());
        handlerThread.setPriority(10);
        handlerThread.start();
        ViewCrawlerHandler viewCrawlerHandler = new ViewCrawlerHandler(context, str, handlerThread.getLooper(), this);
        this.f19510h = viewCrawlerHandler;
        this.f19506d = new DynamicEventTracker(mixpanelAPI, viewCrawlerHandler);
        this.f19505c = mixpanelAPI;
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new LifecycleCallbacks());
        tweaks.a(new Tweaks.OnTweakDeclaredListener() { // from class: com.mixpanel.android.viewcrawler.ViewCrawler.1
        });
    }

    @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
    public void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            Message obtainMessage = this.f19510h.obtainMessage(5);
            obtainMessage.obj = jSONArray;
            this.f19510h.sendMessage(obtainMessage);
        }
    }

    @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
    public void b() {
        ViewCrawlerHandler viewCrawlerHandler = this.f19510h;
        viewCrawlerHandler.sendMessage(viewCrawlerHandler.obtainMessage(0));
    }

    @Override // com.mixpanel.android.viewcrawler.ViewVisitor.OnLayoutErrorListener
    public void c(ViewVisitor.LayoutErrorMessage layoutErrorMessage) {
        Message obtainMessage = this.f19510h.obtainMessage();
        obtainMessage.what = 12;
        obtainMessage.obj = layoutErrorMessage;
        this.f19510h.sendMessage(obtainMessage);
    }

    @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
    public void d(JSONArray jSONArray) {
        if (jSONArray != null) {
            Message obtainMessage = this.f19510h.obtainMessage(9);
            obtainMessage.obj = jSONArray;
            this.f19510h.sendMessage(obtainMessage);
        }
    }

    @Override // com.mixpanel.android.viewcrawler.TrackingDebug
    public void e(String str) {
        Message obtainMessage = this.f19510h.obtainMessage();
        obtainMessage.what = 7;
        obtainMessage.obj = str;
        this.f19510h.sendMessage(obtainMessage);
    }

    @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
    public void f(JSONArray jSONArray) {
        if (jSONArray != null) {
            Message obtainMessage = this.f19510h.obtainMessage(13);
            obtainMessage.obj = jSONArray;
            this.f19510h.sendMessage(obtainMessage);
        }
    }

    @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
    public void g() {
        this.f19510h.t();
        b();
    }
}
