package com.mixpanel.android.viewcrawler;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64OutputStream;
import android.util.DisplayMetrics;
import android.util.JsonWriter;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mixpanel.android.mpmetrics.MPConfig;
import com.mixpanel.android.mpmetrics.ResourceIds;
import com.mixpanel.android.util.MPLog;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

@TargetApi(16)
/* loaded from: classes3.dex */
class ViewSnapshot {

    /* renamed from: a  reason: collision with root package name */
    private final MPConfig f19546a;

    /* renamed from: c  reason: collision with root package name */
    private final List<PropertyDescription> f19548c;

    /* renamed from: f  reason: collision with root package name */
    private final ResourceIds f19551f;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f19550e = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private final RootViewFinder f19547b = new RootViewFinder();

    /* renamed from: d  reason: collision with root package name */
    private final ClassNameCache f19549d = new ClassNameCache(255);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class CachedBitmap {

        /* renamed from: b  reason: collision with root package name */
        private final Paint f19553b = new Paint(2);

        /* renamed from: a  reason: collision with root package name */
        private Bitmap f19552a = null;

        public synchronized void a(int i8, int i9, int i10, Bitmap bitmap) {
            Bitmap bitmap2 = this.f19552a;
            if (bitmap2 == null || bitmap2.getWidth() != i8 || this.f19552a.getHeight() != i9) {
                try {
                    this.f19552a = Bitmap.createBitmap(i8, i9, Bitmap.Config.RGB_565);
                } catch (OutOfMemoryError unused) {
                    this.f19552a = null;
                }
                Bitmap bitmap3 = this.f19552a;
                if (bitmap3 != null) {
                    bitmap3.setDensity(i10);
                }
            }
            if (this.f19552a != null) {
                new Canvas(this.f19552a).drawBitmap(bitmap, 0.0f, 0.0f, this.f19553b);
            }
        }

        public synchronized void b(Bitmap.CompressFormat compressFormat, int i8, OutputStream outputStream) throws IOException {
            Bitmap bitmap = this.f19552a;
            if (bitmap != null && bitmap.getWidth() != 0 && this.f19552a.getHeight() != 0) {
                outputStream.write(34);
                Base64OutputStream base64OutputStream = new Base64OutputStream(outputStream, 2);
                this.f19552a.compress(Bitmap.CompressFormat.PNG, 100, base64OutputStream);
                base64OutputStream.flush();
                outputStream.write(34);
            }
            outputStream.write("null".getBytes());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class ClassNameCache extends LruCache<Class<?>, String> {
        public ClassNameCache(int i8) {
            super(i8);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public String create(Class<?> cls) {
            return cls.getCanonicalName();
        }
    }

    /* loaded from: classes3.dex */
    private static class RootViewFinder implements Callable<List<RootViewInfo>> {

        /* renamed from: f  reason: collision with root package name */
        private UIThreadSet<Activity> f19554f;

        /* renamed from: j  reason: collision with root package name */
        private final int f19558j = 160;

        /* renamed from: h  reason: collision with root package name */
        private final DisplayMetrics f19556h = new DisplayMetrics();

        /* renamed from: g  reason: collision with root package name */
        private final List<RootViewInfo> f19555g = new ArrayList();

        /* renamed from: i  reason: collision with root package name */
        private final CachedBitmap f19557i = new CachedBitmap();

        /* JADX WARN: Removed duplicated region for block: B:23:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00ca  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void c(com.mixpanel.android.viewcrawler.ViewSnapshot.RootViewInfo r14) {
            /*
                Method dump skipped, instructions count: 218
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.viewcrawler.ViewSnapshot.RootViewFinder.c(com.mixpanel.android.viewcrawler.ViewSnapshot$RootViewInfo):void");
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<RootViewInfo> call() throws Exception {
            this.f19555g.clear();
            for (Activity activity : this.f19554f.b()) {
                String canonicalName = activity.getClass().getCanonicalName();
                View rootView = activity.getWindow().getDecorView().getRootView();
                activity.getWindowManager().getDefaultDisplay().getMetrics(this.f19556h);
                this.f19555g.add(new RootViewInfo(canonicalName, rootView));
            }
            int size = this.f19555g.size();
            for (int i8 = 0; i8 < size; i8++) {
                c(this.f19555g.get(i8));
            }
            return this.f19555g;
        }

        public void b(UIThreadSet<Activity> uIThreadSet) {
            this.f19554f = uIThreadSet;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class RootViewInfo {

        /* renamed from: a  reason: collision with root package name */
        public final String f19559a;

        /* renamed from: b  reason: collision with root package name */
        public final View f19560b;

        /* renamed from: c  reason: collision with root package name */
        public CachedBitmap f19561c = null;

        /* renamed from: d  reason: collision with root package name */
        public float f19562d = 1.0f;

        public RootViewInfo(String str, View view) {
            this.f19559a = str;
            this.f19560b = view;
        }
    }

    public ViewSnapshot(Context context, List<PropertyDescription> list, ResourceIds resourceIds) {
        this.f19546a = MPConfig.s(context);
        this.f19548c = list;
        this.f19551f = resourceIds;
    }

    private void a(JsonWriter jsonWriter, View view) throws IOException {
        Caller caller;
        Object a8;
        Class<?> cls = view.getClass();
        for (PropertyDescription propertyDescription : this.f19548c) {
            if (propertyDescription.f19499b.isAssignableFrom(cls) && (caller = propertyDescription.f19500c) != null && (a8 = caller.a(view)) != null) {
                if (a8 instanceof Number) {
                    jsonWriter.name(propertyDescription.f19498a).value((Number) a8);
                } else if (a8 instanceof Boolean) {
                    jsonWriter.name(propertyDescription.f19498a).value(((Boolean) a8).booleanValue());
                } else if (a8 instanceof ColorStateList) {
                    jsonWriter.name(propertyDescription.f19498a).value(Integer.valueOf(((ColorStateList) a8).getDefaultColor()));
                } else if (a8 instanceof Drawable) {
                    Drawable drawable = (Drawable) a8;
                    Rect bounds = drawable.getBounds();
                    jsonWriter.name(propertyDescription.f19498a);
                    jsonWriter.beginObject();
                    jsonWriter.name("classes");
                    jsonWriter.beginArray();
                    for (Class<?> cls2 = drawable.getClass(); cls2 != Object.class; cls2 = cls2.getSuperclass()) {
                        jsonWriter.value(cls2.getCanonicalName());
                    }
                    jsonWriter.endArray();
                    jsonWriter.name("dimensions");
                    jsonWriter.beginObject();
                    jsonWriter.name("left").value(bounds.left);
                    jsonWriter.name("right").value(bounds.right);
                    jsonWriter.name("top").value(bounds.top);
                    jsonWriter.name("bottom").value(bounds.bottom);
                    jsonWriter.endObject();
                    if (drawable instanceof ColorDrawable) {
                        jsonWriter.name("color").value(((ColorDrawable) drawable).getColor());
                    }
                    jsonWriter.endObject();
                } else {
                    jsonWriter.name(propertyDescription.f19498a).value(a8.toString());
                }
            }
        }
    }

    private void b(JsonWriter jsonWriter, View view) throws IOException {
        String a8;
        View childAt;
        if (view.getVisibility() == 4 && this.f19546a.q()) {
            return;
        }
        int id = view.getId();
        if (-1 == id) {
            a8 = null;
        } else {
            a8 = this.f19551f.a(id);
        }
        jsonWriter.beginObject();
        jsonWriter.name("hashCode").value(view.hashCode());
        jsonWriter.name(Name.MARK).value(id);
        jsonWriter.name("mp_id_name").value(a8);
        CharSequence contentDescription = view.getContentDescription();
        if (contentDescription == null) {
            jsonWriter.name("contentDescription").nullValue();
        } else {
            jsonWriter.name("contentDescription").value(contentDescription.toString());
        }
        Object tag = view.getTag();
        if (tag == null) {
            jsonWriter.name("tag").nullValue();
        } else if (tag instanceof CharSequence) {
            jsonWriter.name("tag").value(tag.toString());
        }
        jsonWriter.name("top").value(view.getTop());
        jsonWriter.name("left").value(view.getLeft());
        jsonWriter.name("width").value(view.getWidth());
        jsonWriter.name("height").value(view.getHeight());
        jsonWriter.name("scrollX").value(view.getScrollX());
        jsonWriter.name("scrollY").value(view.getScrollY());
        jsonWriter.name("visibility").value(view.getVisibility());
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        jsonWriter.name("translationX").value(translationX);
        jsonWriter.name("translationY").value(translationY);
        jsonWriter.name("classes");
        jsonWriter.beginArray();
        Class<?> cls = view.getClass();
        do {
            jsonWriter.value(this.f19549d.get(cls));
            cls = cls.getSuperclass();
            if (cls == Object.class) {
                break;
            }
        } while (cls != null);
        jsonWriter.endArray();
        a(jsonWriter, view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            int[] rules = ((RelativeLayout.LayoutParams) layoutParams).getRules();
            jsonWriter.name("layoutRules");
            jsonWriter.beginArray();
            for (int i8 : rules) {
                jsonWriter.value(i8);
            }
            jsonWriter.endArray();
        }
        jsonWriter.name("subviews");
        jsonWriter.beginArray();
        boolean z7 = view instanceof ViewGroup;
        if (z7) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                if (viewGroup.getChildAt(i9) != null) {
                    jsonWriter.value(childAt.hashCode());
                }
            }
        }
        jsonWriter.endArray();
        jsonWriter.endObject();
        if (z7) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            int childCount2 = viewGroup2.getChildCount();
            for (int i10 = 0; i10 < childCount2; i10++) {
                View childAt2 = viewGroup2.getChildAt(i10);
                if (childAt2 != null) {
                    b(jsonWriter, childAt2);
                }
            }
        }
    }

    void c(JsonWriter jsonWriter, View view) throws IOException {
        jsonWriter.beginArray();
        b(jsonWriter, view);
        jsonWriter.endArray();
    }

    public void d(UIThreadSet<Activity> uIThreadSet, OutputStream outputStream) throws IOException {
        this.f19547b.b(uIThreadSet);
        FutureTask futureTask = new FutureTask(this.f19547b);
        this.f19550e.post(futureTask);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        List emptyList = Collections.emptyList();
        outputStreamWriter.write("[");
        try {
            emptyList = (List) futureTask.get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e8) {
            MPLog.b("MixpanelAPI.Snapshot", "Screenshot interrupted, no screenshot will be sent.", e8);
        } catch (ExecutionException e9) {
            MPLog.d("MixpanelAPI.Snapshot", "Exception thrown during screenshot attempt", e9);
        } catch (TimeoutException e10) {
            MPLog.f("MixpanelAPI.Snapshot", "Screenshot took more than 1 second to be scheduled and executed. No screenshot will be sent.", e10);
        }
        int size = emptyList.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (i8 > 0) {
                outputStreamWriter.write(",");
            }
            RootViewInfo rootViewInfo = (RootViewInfo) emptyList.get(i8);
            outputStreamWriter.write("{");
            outputStreamWriter.write("\"activity\":");
            outputStreamWriter.write(JSONObject.quote(rootViewInfo.f19559a));
            outputStreamWriter.write(",");
            outputStreamWriter.write("\"scale\":");
            outputStreamWriter.write(String.format("%s", Float.valueOf(rootViewInfo.f19562d)));
            outputStreamWriter.write(",");
            outputStreamWriter.write("\"serialized_objects\":");
            JsonWriter jsonWriter = new JsonWriter(outputStreamWriter);
            jsonWriter.beginObject();
            jsonWriter.name("rootObject").value(rootViewInfo.f19560b.hashCode());
            jsonWriter.name("objects");
            c(jsonWriter, rootViewInfo.f19560b);
            jsonWriter.endObject();
            jsonWriter.flush();
            outputStreamWriter.write(",");
            outputStreamWriter.write("\"screenshot\":");
            outputStreamWriter.flush();
            rootViewInfo.f19561c.b(Bitmap.CompressFormat.PNG, 100, outputStream);
            outputStreamWriter.write("}");
        }
        outputStreamWriter.write("]");
        outputStreamWriter.flush();
    }
}
