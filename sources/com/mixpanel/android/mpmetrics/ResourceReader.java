package com.mixpanel.android.mpmetrics;

import android.R;
import android.content.Context;
import android.util.SparseArray;
import com.mixpanel.android.util.MPLog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class ResourceReader implements ResourceIds {

    /* renamed from: a  reason: collision with root package name */
    private final Context f19338a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Integer> f19339b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<String> f19340c = new SparseArray<>();

    /* loaded from: classes3.dex */
    public static class Drawables extends ResourceReader {

        /* renamed from: d  reason: collision with root package name */
        private final String f19341d;

        /* JADX INFO: Access modifiers changed from: protected */
        public Drawables(String str, Context context) {
            super(context);
            this.f19341d = str;
            f();
        }

        @Override // com.mixpanel.android.mpmetrics.ResourceReader
        protected String d(Context context) {
            return this.f19341d + ".R$drawable";
        }

        @Override // com.mixpanel.android.mpmetrics.ResourceReader
        protected Class<?> e() {
            return R.drawable.class;
        }
    }

    /* loaded from: classes3.dex */
    public static class Ids extends ResourceReader {

        /* renamed from: d  reason: collision with root package name */
        private final String f19342d;

        public Ids(String str, Context context) {
            super(context);
            this.f19342d = str;
            f();
        }

        @Override // com.mixpanel.android.mpmetrics.ResourceReader
        protected String d(Context context) {
            return this.f19342d + ".R$id";
        }

        @Override // com.mixpanel.android.mpmetrics.ResourceReader
        protected Class<?> e() {
            return R.id.class;
        }
    }

    protected ResourceReader(Context context) {
        this.f19338a = context;
    }

    private static void g(Class<?> cls, String str, Map<String, Integer> map) {
        Field[] fields;
        try {
            for (Field field : cls.getFields()) {
                if (Modifier.isStatic(field.getModifiers()) && field.getType() == Integer.TYPE) {
                    try {
                        String name = field.getName();
                        int i8 = field.getInt(null);
                        if (str != null) {
                            name = str + ":" + name;
                        }
                        map.put(name, Integer.valueOf(i8));
                    } catch (ArrayIndexOutOfBoundsException e8) {
                        MPLog.d("MixpanelAPI.RsrcReader", "Can't read built-in id name from " + cls.getName(), e8);
                    }
                }
            }
        } catch (IllegalAccessException e9) {
            MPLog.d("MixpanelAPI.RsrcReader", "Can't read built-in id names from " + cls.getName(), e9);
        }
    }

    @Override // com.mixpanel.android.mpmetrics.ResourceIds
    public String a(int i8) {
        return this.f19340c.get(i8);
    }

    @Override // com.mixpanel.android.mpmetrics.ResourceIds
    public boolean b(String str) {
        return this.f19339b.containsKey(str);
    }

    @Override // com.mixpanel.android.mpmetrics.ResourceIds
    public int c(String str) {
        return this.f19339b.get(str).intValue();
    }

    protected abstract String d(Context context);

    protected abstract Class<?> e();

    protected void f() {
        this.f19339b.clear();
        this.f19340c.clear();
        g(e(), "android", this.f19339b);
        String d8 = d(this.f19338a);
        try {
            g(Class.forName(d8), null, this.f19339b);
        } catch (ClassNotFoundException unused) {
            MPLog.k("MixpanelAPI.RsrcReader", "Can't load names for Android view ids from '" + d8 + "', ids by name will not be available in the events editor.");
            MPLog.e("MixpanelAPI.RsrcReader", "You may be missing a Resources class for your package due to your proguard configuration, or you may be using an applicationId in your build that isn't the same as the package declared in your AndroidManifest.xml file.\nIf you're using proguard, you can fix this issue by adding the following to your proguard configuration:\n\n-keep class **.R$* {\n    <fields>;\n}\n\nIf you're not using proguard, or if your proguard configuration already contains the directive above, you can add the following to your AndroidManifest.xml file to explicitly point the Mixpanel library to the appropriate library for your resources class:\n\n<meta-data android:name=\"com.mixpanel.android.MPConfig.ResourcePackageName\" android:value=\"YOUR_PACKAGE_NAME\" />\n\nwhere YOUR_PACKAGE_NAME is the same string you use for the \"package\" attribute in your <manifest> tag.");
        }
        for (Map.Entry<String, Integer> entry : this.f19339b.entrySet()) {
            this.f19340c.put(entry.getValue().intValue(), entry.getKey());
        }
    }
}
