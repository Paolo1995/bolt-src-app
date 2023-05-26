package com.mixpanel.android.mpmetrics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
class SelectorEvaluator {

    /* renamed from: b  reason: collision with root package name */
    private static Calendar f19343b;

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f19344a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mixpanel.android.mpmetrics.SelectorEvaluator$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19345a;

        static {
            int[] iArr = new int[PropertyType.values().length];
            f19345a = iArr;
            try {
                iArr[PropertyType.Null.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19345a[PropertyType.Datetime.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19345a[PropertyType.Boolean.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19345a[PropertyType.Number.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f19345a[PropertyType.String.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f19345a[PropertyType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f19345a[PropertyType.Object.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum PropertyType {
        Array,
        Boolean,
        Datetime,
        Null,
        Number,
        Object,
        String,
        Unknown
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SelectorEvaluator(JSONObject jSONObject) throws IllegalArgumentException {
        if (jSONObject.has("operator") && jSONObject.has("children")) {
            this.f19344a = jSONObject;
            return;
        }
        throw new IllegalArgumentException("Missing required keys: operator children");
    }

    private static boolean a(Object obj, Object obj2) {
        if (u(obj) == u(obj2)) {
            switch (AnonymousClass1.f19345a[u(obj).ordinal()]) {
                case 1:
                    return true;
                case 2:
                case 5:
                case 6:
                    return obj.equals(obj2);
                case 3:
                    return v(obj).equals(v(obj2));
                case 4:
                    return w(obj).equals(w(obj2));
                default:
                    return false;
            }
        }
        return false;
    }

    static Boolean c(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject.has("operator") && jSONObject.getString("operator").equals("and") && jSONObject.optJSONArray("children") != null && jSONObject.getJSONArray("children").length() == 2) {
            JSONArray jSONArray = jSONObject.getJSONArray("children");
            boolean z7 = false;
            if (v(l(jSONArray.getJSONObject(0), jSONObject2)).booleanValue() && v(l(jSONArray.getJSONObject(1), jSONObject2)).booleanValue()) {
                z7 = true;
            }
            return Boolean.valueOf(z7);
        }
        throw new IllegalArgumentException("Invalid node for operator: and");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a2, code lost:
        if (r0.equals("-") == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.Double d(org.json.JSONObject r18, org.json.JSONObject r19) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.SelectorEvaluator.d(org.json.JSONObject, org.json.JSONObject):java.lang.Double");
    }

    static Boolean e(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject.has("operator") && jSONObject.getString("operator").equals("boolean") && jSONObject.optJSONArray("children") != null && jSONObject.getJSONArray("children").length() == 1) {
            return v(l(jSONObject.getJSONArray("children").getJSONObject(0), jSONObject2));
        }
        throw new IllegalArgumentException("Invalid node for cast operator: boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ac, code lost:
        if (r13.equals("<=") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x010a, code lost:
        if (r13.equals("<=") == false) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.Boolean f(org.json.JSONObject r13, org.json.JSONObject r14) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 432
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.SelectorEvaluator.f(org.json.JSONObject, org.json.JSONObject):java.lang.Boolean");
    }

    static Date g(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject.has("operator") && jSONObject.getString("operator").equals("datetime") && jSONObject.optJSONArray("children") != null && jSONObject.getJSONArray("children").length() == 1) {
            Object l8 = l(jSONObject.getJSONArray("children").getJSONObject(0), jSONObject2);
            int i8 = AnonymousClass1.f19345a[u(l8).ordinal()];
            if (i8 != 2) {
                if (i8 != 4) {
                    if (i8 != 5) {
                        return null;
                    }
                    try {
                        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US).parse((String) l8);
                    } catch (ParseException unused) {
                        return null;
                    }
                }
                return new Date(w(l8).longValue());
            }
            return (Date) l8;
        }
        throw new IllegalArgumentException("Invalid node for cast operator: datetime");
    }

    static Boolean h(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        boolean z7;
        if (jSONObject.has("operator") && ((jSONObject.getString("operator").equals("defined") || jSONObject.getString("operator").equals("not defined")) && jSONObject.optJSONArray("children") != null)) {
            boolean z8 = true;
            if (jSONObject.getJSONArray("children").length() == 1) {
                if (l(jSONObject.getJSONArray("children").getJSONObject(0), jSONObject2) == null) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                if (jSONObject.getString("operator").equals("defined")) {
                    z8 = z7;
                } else if (z7) {
                    z8 = false;
                }
                return Boolean.valueOf(z8);
            }
        }
        throw new IllegalArgumentException("Invalid node for (not) defined operator");
    }

    static Boolean i(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject.has("operator") && ((jSONObject.getString("operator").equals("==") || jSONObject.getString("operator").equals("!=")) && jSONObject.optJSONArray("children") != null && jSONObject.getJSONArray("children").length() == 2)) {
            JSONArray jSONArray = jSONObject.getJSONArray("children");
            boolean z7 = false;
            Object l8 = l(jSONArray.getJSONObject(0), jSONObject2);
            Object l9 = l(jSONArray.getJSONObject(1), jSONObject2);
            Boolean bool = Boolean.FALSE;
            if (u(l8) == u(l9)) {
                if (AnonymousClass1.f19345a[u(l8).ordinal()] != 7) {
                    bool = Boolean.valueOf(a(l8, l9));
                } else {
                    JSONObject jSONObject3 = (JSONObject) l8;
                    JSONObject jSONObject4 = (JSONObject) l9;
                    if (jSONObject3.length() == jSONObject4.length()) {
                        bool = Boolean.TRUE;
                        Iterator<String> keys = jSONObject3.keys();
                        while (true) {
                            if (!keys.hasNext()) {
                                break;
                            }
                            String next = keys.next();
                            if (!a(jSONObject3.get(next), jSONObject4.opt(next))) {
                                bool = Boolean.FALSE;
                                break;
                            }
                        }
                    }
                }
            }
            if (jSONObject.getString("operator").equals("!=")) {
                if (!bool.booleanValue()) {
                    z7 = true;
                }
            } else {
                z7 = bool.booleanValue();
            }
            return Boolean.valueOf(z7);
        }
        throw new IllegalArgumentException("Invalid node for equality operator");
    }

    static Boolean j(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject.has("operator") && ((jSONObject.getString("operator").equals("in") || jSONObject.getString("operator").equals("not in")) && jSONObject.optJSONArray("children") != null && jSONObject.getJSONArray("children").length() == 2)) {
            JSONArray jSONArray = jSONObject.getJSONArray("children");
            boolean z7 = false;
            Object l8 = l(jSONArray.getJSONObject(0), jSONObject2);
            Object l9 = l(jSONArray.getJSONObject(1), jSONObject2);
            Boolean bool = Boolean.FALSE;
            String obj = l8.toString();
            int i8 = AnonymousClass1.f19345a[u(l9).ordinal()];
            if (i8 != 5) {
                if (i8 == 6) {
                    JSONArray jSONArray2 = (JSONArray) l9;
                    int i9 = 0;
                    while (true) {
                        if (i9 >= jSONArray2.length()) {
                            break;
                        } else if (obj.equals(jSONArray2.getString(i9))) {
                            bool = Boolean.TRUE;
                            break;
                        } else {
                            i9++;
                        }
                    }
                }
            } else {
                bool = Boolean.valueOf(((String) l9).contains(obj));
            }
            if (jSONObject.getString("operator").equals("in")) {
                z7 = bool.booleanValue();
            } else if (!bool.booleanValue()) {
                z7 = true;
            }
            return Boolean.valueOf(z7);
        }
        throw new IllegalArgumentException("Invalid node for operator: (not) in");
    }

    static JSONArray k(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject.has("operator") && jSONObject.getString("operator").equals("list") && jSONObject.optJSONArray("children") != null && jSONObject.getJSONArray("children").length() == 1) {
            Object l8 = l(jSONObject.getJSONArray("children").getJSONObject(0), jSONObject2);
            if (u(l8) == PropertyType.Array) {
                return (JSONArray) l8;
            }
            return null;
        }
        throw new IllegalArgumentException("Invalid node for cast operator: list");
    }

    private static Object l(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject.has("property")) {
            return o(jSONObject, jSONObject2);
        }
        return p(jSONObject, jSONObject2);
    }

    static Boolean m(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject.has("operator") && jSONObject.getString("operator").equals("not") && jSONObject.optJSONArray("children") != null && jSONObject.getJSONArray("children").length() == 1) {
            Object l8 = l(jSONObject.getJSONArray("children").getJSONObject(0), jSONObject2);
            int i8 = AnonymousClass1.f19345a[u(l8).ordinal()];
            if (i8 != 1) {
                if (i8 != 3) {
                    return null;
                }
                return Boolean.valueOf(!v(l8).booleanValue());
            }
            return Boolean.TRUE;
        }
        throw new IllegalArgumentException("Invalid node for operator: not");
    }

    static Double n(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject.has("operator") && jSONObject.getString("operator").equals("number") && jSONObject.optJSONArray("children") != null && jSONObject.getJSONArray("children").length() == 1) {
            return w(l(jSONObject.getJSONArray("children").getJSONObject(0), jSONObject2));
        }
        throw new IllegalArgumentException("Invalid node for cast operator: number");
    }

    static Object o(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject.has("property") && jSONObject.has(AppMeasurementSdk.ConditionalUserProperty.VALUE)) {
            String string = jSONObject.getString("property");
            string.hashCode();
            if (!string.equals("event")) {
                if (string.equals("literal")) {
                    if (u(jSONObject.get(AppMeasurementSdk.ConditionalUserProperty.VALUE)) == PropertyType.String && jSONObject.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE).equalsIgnoreCase("now")) {
                        return new Date();
                    }
                    Object obj = jSONObject.get(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                    if (AnonymousClass1.f19345a[u(obj).ordinal()] != 7) {
                        return obj;
                    }
                    return t((JSONObject) obj);
                }
                throw new IllegalArgumentException("Invalid operand: Invalid property type: " + jSONObject.getString("property"));
            }
            return jSONObject2.opt(jSONObject.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE));
        }
        throw new IllegalArgumentException("Missing required keys: property/value");
    }

    static Object p(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject.has("operator")) {
            String string = jSONObject.getString("operator");
            string.hashCode();
            char c8 = 65535;
            switch (string.hashCode()) {
                case -1039759982:
                    if (string.equals("not in")) {
                        c8 = 0;
                        break;
                    }
                    break;
                case -1034364087:
                    if (string.equals("number")) {
                        c8 = 1;
                        break;
                    }
                    break;
                case -891985903:
                    if (string.equals("string")) {
                        c8 = 2;
                        break;
                    }
                    break;
                case 37:
                    if (string.equals("%")) {
                        c8 = 3;
                        break;
                    }
                    break;
                case 42:
                    if (string.equals("*")) {
                        c8 = 4;
                        break;
                    }
                    break;
                case 43:
                    if (string.equals("+")) {
                        c8 = 5;
                        break;
                    }
                    break;
                case 45:
                    if (string.equals("-")) {
                        c8 = 6;
                        break;
                    }
                    break;
                case 47:
                    if (string.equals("/")) {
                        c8 = 7;
                        break;
                    }
                    break;
                case 60:
                    if (string.equals("<")) {
                        c8 = '\b';
                        break;
                    }
                    break;
                case 62:
                    if (string.equals(">")) {
                        c8 = '\t';
                        break;
                    }
                    break;
                case 1084:
                    if (string.equals("!=")) {
                        c8 = '\n';
                        break;
                    }
                    break;
                case 1921:
                    if (string.equals("<=")) {
                        c8 = 11;
                        break;
                    }
                    break;
                case 1952:
                    if (string.equals("==")) {
                        c8 = '\f';
                        break;
                    }
                    break;
                case 1983:
                    if (string.equals(">=")) {
                        c8 = '\r';
                        break;
                    }
                    break;
                case 3365:
                    if (string.equals("in")) {
                        c8 = 14;
                        break;
                    }
                    break;
                case 3555:
                    if (string.equals("or")) {
                        c8 = 15;
                        break;
                    }
                    break;
                case 96727:
                    if (string.equals("and")) {
                        c8 = 16;
                        break;
                    }
                    break;
                case 109267:
                    if (string.equals("not")) {
                        c8 = 17;
                        break;
                    }
                    break;
                case 3322014:
                    if (string.equals("list")) {
                        c8 = 18;
                        break;
                    }
                    break;
                case 64711720:
                    if (string.equals("boolean")) {
                        c8 = 19;
                        break;
                    }
                    break;
                case 1545035273:
                    if (string.equals("defined")) {
                        c8 = 20;
                        break;
                    }
                    break;
                case 1793702779:
                    if (string.equals("datetime")) {
                        c8 = 21;
                        break;
                    }
                    break;
                case 1834754492:
                    if (string.equals("not defined")) {
                        c8 = 22;
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 0:
                case 14:
                    return j(jSONObject, jSONObject2);
                case 1:
                    return n(jSONObject, jSONObject2);
                case 2:
                    return s(jSONObject, jSONObject2);
                case 3:
                case 4:
                case 6:
                case 7:
                    return d(jSONObject, jSONObject2);
                case 5:
                    return r(jSONObject, jSONObject2);
                case '\b':
                case '\t':
                case 11:
                case '\r':
                    return f(jSONObject, jSONObject2);
                case '\n':
                case '\f':
                    return i(jSONObject, jSONObject2);
                case 15:
                    return q(jSONObject, jSONObject2);
                case 16:
                    return c(jSONObject, jSONObject2);
                case 17:
                    return m(jSONObject, jSONObject2);
                case 18:
                    return k(jSONObject, jSONObject2);
                case 19:
                    return e(jSONObject, jSONObject2);
                case 20:
                case 22:
                    return h(jSONObject, jSONObject2);
                case 21:
                    return g(jSONObject, jSONObject2);
                default:
                    throw new IllegalArgumentException("Unknown operator: " + jSONObject.getString("operator"));
            }
        }
        throw new IllegalArgumentException("Missing required keys: operator");
    }

    static Boolean q(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject.has("operator") && jSONObject.getString("operator").equals("or") && jSONObject.optJSONArray("children") != null && jSONObject.getJSONArray("children").length() == 2) {
            JSONArray jSONArray = jSONObject.getJSONArray("children");
            boolean z7 = false;
            return Boolean.valueOf((v(l(jSONArray.getJSONObject(0), jSONObject2)).booleanValue() || v(l(jSONArray.getJSONObject(1), jSONObject2)).booleanValue()) ? true : true);
        }
        throw new IllegalArgumentException("Invalid node for operator: or");
    }

    static Object r(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject.has("operator") && jSONObject.getString("operator").equals("+") && jSONObject.optJSONArray("children") != null && jSONObject.getJSONArray("children").length() == 2) {
            JSONArray jSONArray = jSONObject.getJSONArray("children");
            Object l8 = l(jSONArray.getJSONObject(0), jSONObject2);
            Object l9 = l(jSONArray.getJSONObject(1), jSONObject2);
            PropertyType u7 = u(l8);
            PropertyType propertyType = PropertyType.Number;
            if (u7 == propertyType && u(l9) == propertyType) {
                return Double.valueOf(w(l8).doubleValue() + w(l9).doubleValue());
            }
            PropertyType u8 = u(l8);
            PropertyType propertyType2 = PropertyType.String;
            if (u8 == propertyType2 && u(l9) == propertyType2) {
                return l8 + ((String) l9);
            }
            return null;
        }
        throw new IllegalArgumentException("Invalid node for operator: +");
    }

    static String s(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject.has("operator") && jSONObject.getString("operator").equals("string") && jSONObject.optJSONArray("children") != null && jSONObject.getJSONArray("children").length() == 1) {
            Object l8 = l(jSONObject.getJSONArray("children").getJSONObject(0), jSONObject2);
            if (u(l8) == PropertyType.Datetime) {
                return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US).format((Date) l8);
            }
            if (l8 != null) {
                return l8.toString();
            }
            return null;
        }
        throw new IllegalArgumentException("Invalid node for cast operator: string");
    }

    static Date t(JSONObject jSONObject) throws JSONException {
        Calendar calendar;
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject != null && optJSONObject.has(AppMeasurementSdk.ConditionalUserProperty.VALUE) && optJSONObject.has("unit")) {
            Calendar calendar2 = f19343b;
            if (calendar2 == null) {
                calendar = Calendar.getInstance();
                calendar.setTime(new Date());
            } else {
                calendar = (Calendar) calendar2.clone();
            }
            char c8 = 65535;
            Integer valueOf = Integer.valueOf(optJSONObject.getInt(AppMeasurementSdk.ConditionalUserProperty.VALUE) * (-1));
            String string = optJSONObject.getString("unit");
            string.hashCode();
            switch (string.hashCode()) {
                case 99228:
                    if (string.equals("day")) {
                        c8 = 0;
                        break;
                    }
                    break;
                case 3208676:
                    if (string.equals("hour")) {
                        c8 = 1;
                        break;
                    }
                    break;
                case 3645428:
                    if (string.equals("week")) {
                        c8 = 2;
                        break;
                    }
                    break;
                case 104080000:
                    if (string.equals("month")) {
                        c8 = 3;
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 0:
                    calendar.add(6, valueOf.intValue());
                    break;
                case 1:
                    calendar.add(10, valueOf.intValue());
                    break;
                case 2:
                    calendar.add(6, valueOf.intValue() * 7);
                    break;
                case 3:
                    calendar.add(6, valueOf.intValue() * 30);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid unit specification for window " + optJSONObject.getString("unit"));
            }
            return calendar.getTime();
        }
        throw new IllegalArgumentException("Invalid window specification for value key " + jSONObject.toString());
    }

    static PropertyType u(Object obj) {
        if (obj != null && !obj.equals(JSONObject.NULL)) {
            if (obj instanceof String) {
                return PropertyType.String;
            }
            if (obj instanceof JSONArray) {
                return PropertyType.Array;
            }
            if (obj instanceof JSONObject) {
                return PropertyType.Object;
            }
            if (!(obj instanceof Double) && !(obj instanceof Integer) && !(obj instanceof Number)) {
                if (obj instanceof Boolean) {
                    return PropertyType.Boolean;
                }
                if (obj instanceof Date) {
                    return PropertyType.Datetime;
                }
                return PropertyType.Unknown;
            }
            return PropertyType.Number;
        }
        return PropertyType.Null;
    }

    static Boolean v(Object obj) {
        boolean z7 = true;
        switch (AnonymousClass1.f19345a[u(obj).ordinal()]) {
            case 1:
                return Boolean.FALSE;
            case 2:
                if (((Date) obj).getTime() <= 0) {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            case 3:
                return (Boolean) obj;
            case 4:
                if (w(obj).doubleValue() == 0.0d) {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            case 5:
                if (((String) obj).length() <= 0) {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            case 6:
                if (((JSONArray) obj).length() <= 0) {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            case 7:
                if (((JSONObject) obj).length() <= 0) {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            default:
                return Boolean.FALSE;
        }
    }

    static Double w(Object obj) {
        int i8 = AnonymousClass1.f19345a[u(obj).ordinal()];
        if (i8 != 2) {
            double d8 = 0.0d;
            if (i8 != 3) {
                if (i8 != 4) {
                    if (i8 != 5) {
                        return null;
                    }
                } else if (obj instanceof Double) {
                    return (Double) obj;
                } else {
                    if (obj instanceof Integer) {
                        return Double.valueOf(((Integer) obj).doubleValue());
                    }
                    if (obj instanceof Number) {
                        return Double.valueOf(((Number) obj).doubleValue());
                    }
                }
                try {
                    return Double.valueOf(Double.parseDouble((String) obj));
                } catch (NumberFormatException unused) {
                    return Double.valueOf(0.0d);
                }
            }
            if (((Boolean) obj).booleanValue()) {
                d8 = 1.0d;
            }
            return Double.valueOf(d8);
        }
        Date date = (Date) obj;
        if (date.getTime() <= 0) {
            return null;
        }
        return new Double(date.getTime());
    }

    public boolean b(JSONObject jSONObject) throws JSONException {
        return v(p(this.f19344a, jSONObject)).booleanValue();
    }
}
