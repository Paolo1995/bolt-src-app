package com.mixpanel.android.viewcrawler;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mixpanel.android.mpmetrics.ResourceIds;
import com.mixpanel.android.util.ImageStore;
import com.mixpanel.android.util.JSONUtils;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.MPPair;
import com.mixpanel.android.viewcrawler.Pathfinder;
import com.mixpanel.android.viewcrawler.ViewVisitor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes3.dex */
class EditProtocol {

    /* renamed from: e  reason: collision with root package name */
    private static final Class<?>[] f19450e = new Class[0];

    /* renamed from: f  reason: collision with root package name */
    private static final List<Pathfinder.PathElement> f19451f = Collections.emptyList();

    /* renamed from: a  reason: collision with root package name */
    private final Context f19452a;

    /* renamed from: b  reason: collision with root package name */
    private final ResourceIds f19453b;

    /* renamed from: c  reason: collision with root package name */
    private final ImageStore f19454c;

    /* renamed from: d  reason: collision with root package name */
    private final ViewVisitor.OnLayoutErrorListener f19455d;

    /* loaded from: classes3.dex */
    public static class BadInstructionsException extends Exception {
        public BadInstructionsException(String str) {
            super(str);
        }

        public BadInstructionsException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: classes3.dex */
    public static class CantGetEditAssetsException extends Exception {
        public CantGetEditAssetsException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: classes3.dex */
    public static class Edit {

        /* renamed from: a  reason: collision with root package name */
        public final ViewVisitor f19456a;

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f19457b;

        private Edit(ViewVisitor viewVisitor, List<String> list) {
            this.f19456a = viewVisitor;
            this.f19457b = list;
        }
    }

    /* loaded from: classes3.dex */
    public static class InapplicableInstructionsException extends BadInstructionsException {
        public InapplicableInstructionsException(String str) {
            super(str);
        }
    }

    public EditProtocol(Context context, ResourceIds resourceIds, ImageStore imageStore, ViewVisitor.OnLayoutErrorListener onLayoutErrorListener) {
        this.f19452a = context;
        this.f19453b = resourceIds;
        this.f19454c = imageStore;
        this.f19455d = onLayoutErrorListener;
    }

    private Object a(Object obj, String str, List<String> list) throws BadInstructionsException, CantGetEditAssetsException {
        try {
            if ("java.lang.CharSequence".equals(str)) {
                return obj;
            }
            if (!"boolean".equals(str) && !"java.lang.Boolean".equals(str)) {
                if (!"int".equals(str) && !"java.lang.Integer".equals(str)) {
                    if (!"float".equals(str) && !"java.lang.Float".equals(str)) {
                        if ("android.graphics.drawable.Drawable".equals(str)) {
                            return b((JSONObject) obj, list);
                        }
                        if ("android.graphics.drawable.BitmapDrawable".equals(str)) {
                            return b((JSONObject) obj, list);
                        }
                        if ("android.graphics.drawable.ColorDrawable".equals(str)) {
                            return new ColorDrawable(((Number) obj).intValue());
                        }
                        throw new BadInstructionsException("Don't know how to interpret type " + str + " (arg was " + obj + ")");
                    }
                    return Float.valueOf(((Number) obj).floatValue());
                }
                return Integer.valueOf(((Number) obj).intValue());
            }
            return obj;
        } catch (ClassCastException unused) {
            throw new BadInstructionsException("Couldn't interpret <" + obj + "> as " + str);
        }
    }

    private Drawable b(JSONObject jSONObject, List<String> list) throws BadInstructionsException, CantGetEditAssetsException {
        int i8;
        int i9;
        int i10;
        int i11;
        try {
            if (!jSONObject.isNull(ImagesContract.URL)) {
                String string = jSONObject.getString(ImagesContract.URL);
                boolean z7 = false;
                if (jSONObject.isNull("dimensions")) {
                    i11 = 0;
                    i8 = 0;
                    i9 = 0;
                    i10 = 0;
                } else {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("dimensions");
                    int i12 = jSONObject2.getInt("left");
                    i8 = jSONObject2.getInt("right");
                    i9 = jSONObject2.getInt("top");
                    i10 = jSONObject2.getInt("bottom");
                    i11 = i12;
                    z7 = true;
                }
                try {
                    Bitmap f8 = this.f19454c.f(string);
                    list.add(string);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(Resources.getSystem(), f8);
                    if (z7) {
                        bitmapDrawable.setBounds(i11, i9, i8, i10);
                    }
                    return bitmapDrawable;
                } catch (ImageStore.CantGetImageException e8) {
                    throw new CantGetEditAssetsException(e8.getMessage(), e8.getCause());
                }
            }
            throw new BadInstructionsException("Can't construct a BitmapDrawable with a null url");
        } catch (JSONException e9) {
            throw new BadInstructionsException("Couldn't read drawable description", e9);
        }
    }

    private PropertyDescription f(Class<?> cls, JSONObject jSONObject) throws BadInstructionsException {
        Caller caller;
        try {
            String string = jSONObject.getString("name");
            String str = null;
            if (jSONObject.has("get")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("get");
                caller = new Caller(cls, jSONObject2.getString("selector"), f19450e, Class.forName(jSONObject2.getJSONObject("result").getString("type")));
            } else {
                caller = null;
            }
            if (jSONObject.has("set")) {
                str = jSONObject.getJSONObject("set").getString("selector");
            }
            return new PropertyDescription(string, cls, caller, str);
        } catch (ClassNotFoundException e8) {
            throw new BadInstructionsException("Can't read property JSON, relevant arg/return class not found", e8);
        } catch (NoSuchMethodException e9) {
            throw new BadInstructionsException("Can't create property reader", e9);
        } catch (JSONException e10) {
            throw new BadInstructionsException("Can't read property JSON", e10);
        }
    }

    private Integer i(int i8, String str, ResourceIds resourceIds) {
        int i9;
        if (str != null) {
            if (resourceIds.b(str)) {
                i9 = resourceIds.c(str);
            } else {
                MPLog.k("MixpanelAPI.EProtocol", "Path element contains an id name not known to the system. No views will be matched.\nMake sure that you're not stripping your packages R class out with proguard.\nid name was \"" + str + "\"");
                return null;
            }
        } else {
            i9 = -1;
        }
        if (-1 != i9 && -1 != i8 && i9 != i8) {
            MPLog.c("MixpanelAPI.EProtocol", "Path contains both a named and an explicit id, and they don't match. No views will be matched.");
            return null;
        } else if (-1 != i9) {
            return Integer.valueOf(i9);
        } else {
            return Integer.valueOf(i8);
        }
    }

    public Edit c(JSONObject jSONObject) throws BadInstructionsException, CantGetEditAssetsException {
        ViewVisitor layoutUpdateVisitor;
        Integer i8;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            List<Pathfinder.PathElement> e8 = e(jSONObject.getJSONArray("path"), this.f19453b);
            if (e8.size() != 0) {
                if (jSONObject.getString("change_type").equals("property")) {
                    String string = jSONObject.getJSONObject("property").getString("classname");
                    if (string != null) {
                        try {
                            PropertyDescription f8 = f(Class.forName(string), jSONObject.getJSONObject("property"));
                            JSONArray jSONArray = jSONObject.getJSONArray("args");
                            Object[] objArr = new Object[jSONArray.length()];
                            for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                                JSONArray jSONArray2 = jSONArray.getJSONArray(i9);
                                objArr[i9] = a(jSONArray2.get(0), jSONArray2.getString(1), arrayList);
                            }
                            Caller a8 = f8.a(objArr);
                            if (a8 != null) {
                                layoutUpdateVisitor = new ViewVisitor.PropertySetVisitor(e8, a8, f8.f19500c);
                            } else {
                                throw new BadInstructionsException("Can't update a read-only property " + f8.f19498a + " (add a mutator to make this work)");
                            }
                        } catch (ClassNotFoundException e9) {
                            throw new BadInstructionsException("Can't find class for visit path: " + str, e9);
                        }
                    } else {
                        throw new BadInstructionsException("Can't bind an edit property without a target class");
                    }
                } else if (jSONObject.getString("change_type").equals("layout")) {
                    JSONArray jSONArray3 = jSONObject.getJSONArray("args");
                    ArrayList arrayList2 = new ArrayList();
                    int length = jSONArray3.length();
                    for (int i10 = 0; i10 < length; i10++) {
                        JSONObject optJSONObject = jSONArray3.optJSONObject(i10);
                        String string2 = optJSONObject.getString("view_id_name");
                        String string3 = optJSONObject.getString("anchor_id_name");
                        Integer i11 = i(-1, string2, this.f19453b);
                        if (string3.equals("0")) {
                            i8 = 0;
                        } else if (string3.equals("-1")) {
                            i8 = -1;
                        } else {
                            i8 = i(-1, string3, this.f19453b);
                        }
                        if (i11 != null && i8 != null) {
                            arrayList2.add(new ViewVisitor.LayoutRule(i11.intValue(), optJSONObject.getInt("verb"), i8.intValue()));
                        }
                        MPLog.k("MixpanelAPI.EProtocol", "View (" + string2 + ") or anchor (" + string3 + ") not found.");
                    }
                    layoutUpdateVisitor = new ViewVisitor.LayoutUpdateVisitor(e8, arrayList2, jSONObject.getString("name"), this.f19455d);
                } else {
                    throw new BadInstructionsException("Can't figure out the edit type");
                }
                return new Edit(layoutUpdateVisitor, arrayList);
            }
            throw new InapplicableInstructionsException("Edit will not be bound to any element in the UI.");
        } catch (NoSuchMethodException e10) {
            throw new BadInstructionsException("Can't create property mutator", e10);
        } catch (JSONException e11) {
            throw new BadInstructionsException("Can't interpret instructions due to JSONException", e11);
        }
    }

    public ViewVisitor d(JSONObject jSONObject, ViewVisitor.OnEventListener onEventListener) throws BadInstructionsException {
        try {
            String string = jSONObject.getString("event_name");
            String string2 = jSONObject.getString("event_type");
            List<Pathfinder.PathElement> e8 = e(jSONObject.getJSONArray("path"), this.f19453b);
            if (e8.size() != 0) {
                if ("click".equals(string2)) {
                    return new ViewVisitor.AddAccessibilityEventVisitor(e8, 1, string, onEventListener);
                }
                if ("selected".equals(string2)) {
                    return new ViewVisitor.AddAccessibilityEventVisitor(e8, 4, string, onEventListener);
                }
                if ("text_changed".equals(string2)) {
                    return new ViewVisitor.AddTextChangeListener(e8, string, onEventListener);
                }
                if ("detected".equals(string2)) {
                    return new ViewVisitor.ViewDetectorVisitor(e8, string, onEventListener);
                }
                throw new BadInstructionsException("Mixpanel can't track event type \"" + string2 + "\"");
            }
            throw new InapplicableInstructionsException("event '" + string + "' will not be bound to any element in the UI.");
        } catch (JSONException e9) {
            throw new BadInstructionsException("Can't interpret instructions due to JSONException", e9);
        }
    }

    List<Pathfinder.PathElement> e(JSONArray jSONArray, ResourceIds resourceIds) throws JSONException {
        int i8;
        ArrayList arrayList = new ArrayList();
        for (int i9 = 0; i9 < jSONArray.length(); i9++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i9);
            String a8 = JSONUtils.a(jSONObject, "prefix");
            String a9 = JSONUtils.a(jSONObject, "view_class");
            int optInt = jSONObject.optInt("index", -1);
            String a10 = JSONUtils.a(jSONObject, "contentDescription");
            int optInt2 = jSONObject.optInt(Name.MARK, -1);
            String a11 = JSONUtils.a(jSONObject, "mp_id_name");
            String a12 = JSONUtils.a(jSONObject, "tag");
            if ("shortest".equals(a8)) {
                i8 = 1;
            } else if (a8 == null) {
                i8 = 0;
            } else {
                MPLog.k("MixpanelAPI.EProtocol", "Unrecognized prefix type \"" + a8 + "\". No views will be matched");
                return f19451f;
            }
            Integer i10 = i(optInt2, a11, resourceIds);
            if (i10 == null) {
                return f19451f;
            }
            arrayList.add(new Pathfinder.PathElement(i8, a9, optInt, i10.intValue(), a10, a12));
        }
        return arrayList;
    }

    public ViewSnapshot g(JSONObject jSONObject) throws BadInstructionsException {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONObject("config").getJSONArray("classes");
            for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i8);
                Class<?> cls = Class.forName(jSONObject2.getString("name"));
                JSONArray jSONArray2 = jSONObject2.getJSONArray("properties");
                for (int i9 = 0; i9 < jSONArray2.length(); i9++) {
                    arrayList.add(f(cls, jSONArray2.getJSONObject(i9)));
                }
            }
            return new ViewSnapshot(this.f19452a, arrayList, this.f19453b);
        } catch (ClassNotFoundException e8) {
            throw new BadInstructionsException("Can't resolve types for snapshot configuration", e8);
        } catch (JSONException e9) {
            throw new BadInstructionsException("Can't read snapshot configuration", e9);
        }
    }

    public MPPair<String, Object> h(JSONObject jSONObject) throws BadInstructionsException {
        Object string;
        try {
            String string2 = jSONObject.getString("name");
            String string3 = jSONObject.getString("type");
            if ("number".equals(string3)) {
                String string4 = jSONObject.getString("encoding");
                if ("d".equals(string4)) {
                    string = Double.valueOf(jSONObject.getDouble(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                } else if ("l".equals(string4)) {
                    string = Long.valueOf(jSONObject.getLong(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                } else {
                    throw new BadInstructionsException("number must have encoding of type \"l\" for long or \"d\" for double in: " + jSONObject);
                }
            } else if ("boolean".equals(string3)) {
                string = Boolean.valueOf(jSONObject.getBoolean(AppMeasurementSdk.ConditionalUserProperty.VALUE));
            } else if ("string".equals(string3)) {
                string = jSONObject.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
            } else {
                throw new BadInstructionsException("Unrecognized tweak type " + string3 + " in: " + jSONObject);
            }
            return new MPPair<>(string2, string);
        } catch (JSONException e8) {
            throw new BadInstructionsException("Can't read tweak update", e8);
        }
    }
}
