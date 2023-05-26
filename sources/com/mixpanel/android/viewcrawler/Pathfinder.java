package com.mixpanel.android.viewcrawler;

import android.view.View;
import android.view.ViewGroup;
import com.mixpanel.android.util.MPLog;
import j$.util.Spliterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes3.dex */
class Pathfinder {

    /* renamed from: a  reason: collision with root package name */
    private final IntStack f19489a = new IntStack();

    /* loaded from: classes3.dex */
    public interface Accumulator {
        void a(View view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class IntStack {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f19490a = new int[Spliterator.NONNULL];

        /* renamed from: b  reason: collision with root package name */
        private int f19491b = 0;

        public int a() {
            int i8 = this.f19491b;
            this.f19491b = i8 + 1;
            this.f19490a[i8] = 0;
            return i8;
        }

        public void b() {
            int i8 = this.f19491b - 1;
            this.f19491b = i8;
            if (i8 >= 0) {
                return;
            }
            throw new ArrayIndexOutOfBoundsException(this.f19491b);
        }

        public boolean c() {
            if (this.f19490a.length == this.f19491b) {
                return true;
            }
            return false;
        }

        public void d(int i8) {
            int[] iArr = this.f19490a;
            iArr[i8] = iArr[i8] + 1;
        }

        public int e(int i8) {
            return this.f19490a[i8];
        }
    }

    /* loaded from: classes3.dex */
    public static class PathElement {

        /* renamed from: a  reason: collision with root package name */
        public final int f19492a;

        /* renamed from: b  reason: collision with root package name */
        public final String f19493b;

        /* renamed from: c  reason: collision with root package name */
        public final int f19494c;

        /* renamed from: d  reason: collision with root package name */
        public final int f19495d;

        /* renamed from: e  reason: collision with root package name */
        public final String f19496e;

        /* renamed from: f  reason: collision with root package name */
        public final String f19497f;

        public PathElement(int i8, String str, int i9, int i10, String str2, String str3) {
            this.f19492a = i8;
            this.f19493b = str;
            this.f19494c = i9;
            this.f19495d = i10;
            this.f19496e = str2;
            this.f19497f = str3;
        }

        public String toString() {
            try {
                JSONObject jSONObject = new JSONObject();
                if (this.f19492a == 1) {
                    jSONObject.put("prefix", "shortest");
                }
                String str = this.f19493b;
                if (str != null) {
                    jSONObject.put("view_class", str);
                }
                int i8 = this.f19494c;
                if (i8 > -1) {
                    jSONObject.put("index", i8);
                }
                int i9 = this.f19495d;
                if (i9 > -1) {
                    jSONObject.put(Name.MARK, i9);
                }
                String str2 = this.f19496e;
                if (str2 != null) {
                    jSONObject.put("contentDescription", str2);
                }
                String str3 = this.f19497f;
                if (str3 != null) {
                    jSONObject.put("tag", str3);
                }
                return jSONObject.toString();
            } catch (JSONException e8) {
                throw new RuntimeException("Can't serialize PathElement to String", e8);
            }
        }
    }

    private View a(PathElement pathElement, View view, int i8) {
        int e8 = this.f19489a.e(i8);
        if (e(pathElement, view)) {
            this.f19489a.d(i8);
            int i9 = pathElement.f19494c;
            if (i9 == -1 || i9 == e8) {
                return view;
            }
        }
        if (pathElement.f19492a == 1 && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View a8 = a(pathElement, viewGroup.getChildAt(i10), i8);
                if (a8 != null) {
                    return a8;
                }
            }
            return null;
        }
        return null;
    }

    private void b(View view, List<PathElement> list, Accumulator accumulator) {
        if (list.isEmpty()) {
            accumulator.a(view);
        } else if (view instanceof ViewGroup) {
            if (this.f19489a.c()) {
                MPLog.i("MixpanelAPI.PathFinder", "Path is too deep, will not match");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            PathElement pathElement = list.get(0);
            List<PathElement> subList = list.subList(1, list.size());
            int childCount = viewGroup.getChildCount();
            int a8 = this.f19489a.a();
            for (int i8 = 0; i8 < childCount; i8++) {
                View a9 = a(pathElement, viewGroup.getChildAt(i8), a8);
                if (a9 != null) {
                    b(a9, subList, accumulator);
                }
                if (pathElement.f19494c >= 0 && this.f19489a.e(a8) > pathElement.f19494c) {
                    break;
                }
            }
            this.f19489a.b();
        }
    }

    private static boolean d(Object obj, String str) {
        Class<?> cls = obj.getClass();
        while (true) {
            String canonicalName = cls.getCanonicalName();
            if (canonicalName != null && canonicalName.equals(str)) {
                return true;
            }
            if (cls == Object.class) {
                return false;
            }
            cls = cls.getSuperclass();
        }
    }

    private boolean e(PathElement pathElement, View view) {
        String str = pathElement.f19493b;
        if (str != null && !d(view, str)) {
            return false;
        }
        if (-1 != pathElement.f19495d && view.getId() != pathElement.f19495d) {
            return false;
        }
        String str2 = pathElement.f19496e;
        if (str2 != null && !str2.equals(view.getContentDescription())) {
            return false;
        }
        String str3 = pathElement.f19497f;
        if (str3 != null) {
            if (view.getTag() == null || !str3.equals(view.getTag().toString())) {
                return false;
            }
            return true;
        }
        return true;
    }

    public void c(View view, List<PathElement> list, Accumulator accumulator) {
        if (list.isEmpty()) {
            return;
        }
        if (this.f19489a.c()) {
            MPLog.k("MixpanelAPI.PathFinder", "There appears to be a concurrency issue in the pathfinding code. Path will not be matched.");
            return;
        }
        List<PathElement> subList = list.subList(1, list.size());
        View a8 = a(list.get(0), view, this.f19489a.a());
        this.f19489a.b();
        if (a8 != null) {
            b(a8, subList, accumulator);
        }
    }
}
