package com.mixpanel.android.mpmetrics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mixpanel.android.util.MPLog;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Tweaks {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentMap<String, TweakValue> f19378a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap<String, TweakValue> f19379b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentMap<String, TweakValue> f19380c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    private final List<OnTweakDeclaredListener> f19381d = new ArrayList();

    /* loaded from: classes3.dex */
    public interface OnTweakDeclaredListener {
    }

    /* loaded from: classes3.dex */
    public static class TweakValue {

        /* renamed from: a  reason: collision with root package name */
        public final int f19382a;

        /* renamed from: b  reason: collision with root package name */
        private final Object f19383b;

        /* renamed from: c  reason: collision with root package name */
        private final Object f19384c;

        /* renamed from: d  reason: collision with root package name */
        private final Number f19385d;

        /* renamed from: e  reason: collision with root package name */
        private final Number f19386e;

        /* renamed from: f  reason: collision with root package name */
        private final String f19387f;

        private TweakValue(int i8, Object obj, Number number, Number number2, Object obj2, String str) {
            Object obj3;
            Long l8 = obj2;
            this.f19382a = i8;
            this.f19387f = str;
            this.f19385d = number;
            this.f19386e = number2;
            if (number != null && number2 != null) {
                if (!j(obj)) {
                    obj3 = Long.valueOf(Math.min(Math.max(((Number) obj).longValue(), number.longValue()), number2.longValue()));
                    MPLog.k("MixpanelAPI.Tweaks", "Attempt to define a tweak \"" + str + "\" with default value " + obj3 + " out of its bounds [" + number + ", " + number2 + "]Tweak \"" + str + "\" new default value: " + obj3 + ".");
                } else {
                    obj3 = obj;
                }
                if (!j(l8)) {
                    Long valueOf = Long.valueOf(Math.min(Math.max(((Number) l8).longValue(), number.longValue()), number2.longValue()));
                    MPLog.k("MixpanelAPI.Tweaks", "Attempt to define a tweak \"" + str + "\" with value " + obj3 + " out of its bounds [" + number + ", " + number2 + "]Tweak \"" + str + "\" new value: " + valueOf + ".");
                    l8 = valueOf;
                }
            } else {
                obj3 = obj;
            }
            this.f19384c = obj3;
            this.f19383b = l8;
        }

        public static TweakValue b(JSONObject jSONObject) {
            String string;
            String string2;
            Object string3;
            Number number;
            Number number2;
            Object obj;
            int i8;
            Object valueOf;
            int i9;
            Object valueOf2;
            Number number3;
            Number valueOf3;
            try {
                string = jSONObject.getString("name");
                string2 = jSONObject.getString("type");
            } catch (JSONException unused) {
            }
            if ("number".equals(string2)) {
                String string4 = jSONObject.getString("encoding");
                if ("d".equals(string4)) {
                    i9 = 2;
                    valueOf = Double.valueOf(jSONObject.getDouble(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                    valueOf2 = Double.valueOf(jSONObject.getDouble("default"));
                    if (!jSONObject.isNull("minimum")) {
                        number3 = Double.valueOf(jSONObject.getDouble("minimum"));
                    } else {
                        number3 = null;
                    }
                    if (!jSONObject.isNull("maximum")) {
                        valueOf3 = Double.valueOf(jSONObject.getDouble("maximum"));
                        number2 = valueOf3;
                        obj = valueOf;
                        number = number3;
                        string3 = valueOf2;
                        i8 = i9;
                    }
                    valueOf3 = null;
                    number2 = valueOf3;
                    obj = valueOf;
                    number = number3;
                    string3 = valueOf2;
                    i8 = i9;
                } else if (!"l".equals(string4)) {
                    return null;
                } else {
                    valueOf = Long.valueOf(jSONObject.getLong(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                    i9 = 3;
                    valueOf2 = Long.valueOf(jSONObject.getLong("default"));
                    if (!jSONObject.isNull("minimum")) {
                        number3 = Long.valueOf(jSONObject.getLong("minimum"));
                    } else {
                        number3 = null;
                    }
                    if (!jSONObject.isNull("maximum")) {
                        valueOf3 = Long.valueOf(jSONObject.getLong("maximum"));
                        number2 = valueOf3;
                        obj = valueOf;
                        number = number3;
                        string3 = valueOf2;
                        i8 = i9;
                    }
                    valueOf3 = null;
                    number2 = valueOf3;
                    obj = valueOf;
                    number = number3;
                    string3 = valueOf2;
                    i8 = i9;
                }
                return null;
            } else if ("boolean".equals(string2)) {
                Object valueOf4 = Boolean.valueOf(jSONObject.getBoolean(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                string3 = Boolean.valueOf(jSONObject.getBoolean("default"));
                number = null;
                number2 = null;
                obj = valueOf4;
                i8 = 1;
            } else {
                if ("string".equals(string2)) {
                    Object string5 = jSONObject.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                    string3 = jSONObject.getString("default");
                    number = null;
                    number2 = null;
                    obj = string5;
                    i8 = 4;
                }
                return null;
            }
            return new TweakValue(i8, string3, number, number2, obj, string);
        }

        private boolean j(Object obj) {
            try {
                Number number = (Number) obj;
                if (Math.min(Math.max(number.longValue(), this.f19385d.longValue()), this.f19386e.longValue()) != this.f19385d.longValue()) {
                    if (Math.min(Math.max(number.longValue(), this.f19385d.longValue()), this.f19386e.longValue()) == this.f19386e.longValue()) {
                        return false;
                    }
                    return true;
                }
                return false;
            } catch (ClassCastException unused) {
                return true;
            }
        }

        public Boolean c() {
            Boolean bool = Boolean.FALSE;
            Object obj = this.f19384c;
            if (obj != null) {
                try {
                    bool = (Boolean) obj;
                } catch (ClassCastException unused) {
                }
            }
            Object obj2 = this.f19383b;
            if (obj2 != null) {
                try {
                    return (Boolean) obj2;
                } catch (ClassCastException unused2) {
                    return bool;
                }
            }
            return bool;
        }

        public Object d() {
            return this.f19384c;
        }

        public Number e() {
            return this.f19386e;
        }

        public Number f() {
            return this.f19385d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Number] */
        public Number g() {
            int i8 = 0;
            Object obj = this.f19384c;
            if (obj != null) {
                try {
                    i8 = (Number) obj;
                } catch (ClassCastException unused) {
                }
            }
            Object obj2 = this.f19383b;
            if (obj2 != null) {
                try {
                    return (Number) obj2;
                } catch (ClassCastException unused2) {
                    return i8;
                }
            }
            return i8;
        }

        public String h() {
            String str;
            try {
                str = (String) this.f19384c;
            } catch (ClassCastException unused) {
                str = null;
            }
            try {
                return (String) this.f19383b;
            } catch (ClassCastException unused2) {
                return str;
            }
        }

        public Object i() {
            return this.f19383b;
        }

        public TweakValue k(Object obj) {
            return new TweakValue(this.f19382a, this.f19384c, this.f19385d, this.f19386e, obj, this.f19387f);
        }
    }

    public synchronized void a(OnTweakDeclaredListener onTweakDeclaredListener) {
        if (onTweakDeclaredListener != null) {
            this.f19381d.add(onTweakDeclaredListener);
        } else {
            throw new NullPointerException("listener cannot be null");
        }
    }

    public void b(String str, TweakValue tweakValue) {
        if (str != null && tweakValue != null) {
            this.f19380c.put(str, tweakValue);
        }
    }

    public synchronized Map<String, TweakValue> c() {
        return new HashMap(this.f19378a);
    }

    public synchronized Map<String, TweakValue> d() {
        return new HashMap(this.f19379b);
    }

    public synchronized boolean e(String str, Object obj) {
        if (!this.f19378a.containsKey(str)) {
            return false;
        }
        return !this.f19378a.get(str).f19383b.equals(obj);
    }

    public synchronized void f(String str, Object obj) {
        if (!this.f19378a.containsKey(str)) {
            MPLog.k("MixpanelAPI.Tweaks", "Attempt to set a tweak \"" + str + "\" which has never been defined.");
            return;
        }
        this.f19378a.put(str, this.f19378a.get(str).k(obj));
    }
}
