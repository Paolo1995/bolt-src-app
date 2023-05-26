package com.mixpanel.android.viewcrawler;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.viewcrawler.Pathfinder;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(16)
/* loaded from: classes3.dex */
public abstract class ViewVisitor implements Pathfinder.Accumulator {

    /* renamed from: a  reason: collision with root package name */
    private final List<Pathfinder.PathElement> f19563a;

    /* renamed from: b  reason: collision with root package name */
    private final Pathfinder f19564b = new Pathfinder();

    /* loaded from: classes3.dex */
    public static class AddAccessibilityEventVisitor extends EventTriggeringVisitor {

        /* renamed from: f  reason: collision with root package name */
        private final int f19565f;

        /* renamed from: g  reason: collision with root package name */
        private final WeakHashMap<View, TrackingAccessibilityDelegate> f19566g;

        /* loaded from: classes3.dex */
        private class TrackingAccessibilityDelegate extends View.AccessibilityDelegate {

            /* renamed from: a  reason: collision with root package name */
            private View.AccessibilityDelegate f19567a;

            public TrackingAccessibilityDelegate(View.AccessibilityDelegate accessibilityDelegate) {
                this.f19567a = accessibilityDelegate;
            }

            public View.AccessibilityDelegate a() {
                return this.f19567a;
            }

            public void b(TrackingAccessibilityDelegate trackingAccessibilityDelegate) {
                View.AccessibilityDelegate accessibilityDelegate = this.f19567a;
                if (accessibilityDelegate == trackingAccessibilityDelegate) {
                    this.f19567a = trackingAccessibilityDelegate.a();
                } else if (accessibilityDelegate instanceof TrackingAccessibilityDelegate) {
                    ((TrackingAccessibilityDelegate) accessibilityDelegate).b(trackingAccessibilityDelegate);
                }
            }

            public boolean c(String str) {
                if (AddAccessibilityEventVisitor.this.g() == str) {
                    return true;
                }
                View.AccessibilityDelegate accessibilityDelegate = this.f19567a;
                if (accessibilityDelegate instanceof TrackingAccessibilityDelegate) {
                    return ((TrackingAccessibilityDelegate) accessibilityDelegate).c(str);
                }
                return false;
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View view, int i8) {
                if (i8 == AddAccessibilityEventVisitor.this.f19565f) {
                    AddAccessibilityEventVisitor.this.f(view);
                }
                View.AccessibilityDelegate accessibilityDelegate = this.f19567a;
                if (accessibilityDelegate != null) {
                    accessibilityDelegate.sendAccessibilityEvent(view, i8);
                }
            }
        }

        public AddAccessibilityEventVisitor(List<Pathfinder.PathElement> list, int i8, String str, OnEventListener onEventListener) {
            super(list, str, onEventListener, false);
            this.f19565f = i8;
            this.f19566g = new WeakHashMap<>();
        }

        private View.AccessibilityDelegate i(View view) {
            try {
                return (View.AccessibilityDelegate) view.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(view, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException unused) {
                return null;
            } catch (InvocationTargetException e8) {
                MPLog.l("MixpanelAPI.ViewVisitor", "getAccessibilityDelegate threw an exception when called.", e8);
                return null;
            }
        }

        @Override // com.mixpanel.android.viewcrawler.Pathfinder.Accumulator
        public void a(View view) {
            View.AccessibilityDelegate i8 = i(view);
            if ((i8 instanceof TrackingAccessibilityDelegate) && ((TrackingAccessibilityDelegate) i8).c(g())) {
                return;
            }
            TrackingAccessibilityDelegate trackingAccessibilityDelegate = new TrackingAccessibilityDelegate(i8);
            view.setAccessibilityDelegate(trackingAccessibilityDelegate);
            this.f19566g.put(view, trackingAccessibilityDelegate);
        }

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        public void b() {
            for (Map.Entry<View, TrackingAccessibilityDelegate> entry : this.f19566g.entrySet()) {
                View key = entry.getKey();
                TrackingAccessibilityDelegate value = entry.getValue();
                View.AccessibilityDelegate i8 = i(key);
                if (i8 == value) {
                    key.setAccessibilityDelegate(value.a());
                } else if (i8 instanceof TrackingAccessibilityDelegate) {
                    ((TrackingAccessibilityDelegate) i8).b(value);
                }
            }
            this.f19566g.clear();
        }

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        public /* bridge */ /* synthetic */ void e(View view) {
            super.e(view);
        }
    }

    /* loaded from: classes3.dex */
    public static class AddTextChangeListener extends EventTriggeringVisitor {

        /* renamed from: f  reason: collision with root package name */
        private final Map<TextView, TextWatcher> f19569f;

        /* loaded from: classes3.dex */
        private class TrackingTextWatcher implements TextWatcher {

            /* renamed from: f  reason: collision with root package name */
            private final View f19570f;

            public TrackingTextWatcher(View view) {
                this.f19570f = view;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                AddTextChangeListener.this.f(this.f19570f);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
            }
        }

        public AddTextChangeListener(List<Pathfinder.PathElement> list, String str, OnEventListener onEventListener) {
            super(list, str, onEventListener, true);
            this.f19569f = new HashMap();
        }

        @Override // com.mixpanel.android.viewcrawler.Pathfinder.Accumulator
        public void a(View view) {
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                TrackingTextWatcher trackingTextWatcher = new TrackingTextWatcher(textView);
                TextWatcher textWatcher = this.f19569f.get(textView);
                if (textWatcher != null) {
                    textView.removeTextChangedListener(textWatcher);
                }
                textView.addTextChangedListener(trackingTextWatcher);
                this.f19569f.put(textView, trackingTextWatcher);
            }
        }

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        public void b() {
            for (Map.Entry<TextView, TextWatcher> entry : this.f19569f.entrySet()) {
                entry.getKey().removeTextChangedListener(entry.getValue());
            }
            this.f19569f.clear();
        }

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        public /* bridge */ /* synthetic */ void e(View view) {
            super.e(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class CycleDetector {
        private CycleDetector() {
        }

        private boolean a(TreeMap<View, List<View>> treeMap, View view, List<View> list) {
            if (list.contains(view)) {
                return false;
            }
            if (treeMap.containsKey(view)) {
                List<View> remove = treeMap.remove(view);
                list.add(view);
                int size = remove.size();
                for (int i8 = 0; i8 < size; i8++) {
                    if (!a(treeMap, remove.get(i8), list)) {
                        return false;
                    }
                }
                list.remove(view);
                return true;
            }
            return true;
        }

        public boolean b(TreeMap<View, List<View>> treeMap) {
            ArrayList arrayList = new ArrayList();
            while (!treeMap.isEmpty()) {
                if (!a(treeMap, treeMap.firstKey(), arrayList)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static abstract class EventTriggeringVisitor extends ViewVisitor {

        /* renamed from: c  reason: collision with root package name */
        private final OnEventListener f19572c;

        /* renamed from: d  reason: collision with root package name */
        private final String f19573d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f19574e;

        public EventTriggeringVisitor(List<Pathfinder.PathElement> list, String str, OnEventListener onEventListener, boolean z7) {
            super(list);
            this.f19572c = onEventListener;
            this.f19573d = str;
            this.f19574e = z7;
        }

        protected void f(View view) {
            this.f19572c.a(view, this.f19573d, this.f19574e);
        }

        protected String g() {
            return this.f19573d;
        }
    }

    /* loaded from: classes3.dex */
    public static class LayoutErrorMessage {

        /* renamed from: a  reason: collision with root package name */
        private final String f19575a;

        /* renamed from: b  reason: collision with root package name */
        private final String f19576b;

        public LayoutErrorMessage(String str, String str2) {
            this.f19575a = str;
            this.f19576b = str2;
        }

        public String a() {
            return this.f19575a;
        }

        public String b() {
            return this.f19576b;
        }
    }

    /* loaded from: classes3.dex */
    public static class LayoutRule {

        /* renamed from: a  reason: collision with root package name */
        public final int f19577a;

        /* renamed from: b  reason: collision with root package name */
        public final int f19578b;

        /* renamed from: c  reason: collision with root package name */
        public final int f19579c;

        public LayoutRule(int i8, int i9, int i10) {
            this.f19577a = i8;
            this.f19578b = i9;
            this.f19579c = i10;
        }
    }

    /* loaded from: classes3.dex */
    public static class LayoutUpdateVisitor extends ViewVisitor {

        /* renamed from: i  reason: collision with root package name */
        private static final Set<Integer> f19580i = new HashSet(Arrays.asList(0, 1, 5, 7));

        /* renamed from: j  reason: collision with root package name */
        private static final Set<Integer> f19581j = new HashSet(Arrays.asList(2, 3, 4, 6, 8));

        /* renamed from: c  reason: collision with root package name */
        private final WeakHashMap<View, int[]> f19582c;

        /* renamed from: d  reason: collision with root package name */
        private final List<LayoutRule> f19583d;

        /* renamed from: e  reason: collision with root package name */
        private final String f19584e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f19585f;

        /* renamed from: g  reason: collision with root package name */
        private final OnLayoutErrorListener f19586g;

        /* renamed from: h  reason: collision with root package name */
        private final CycleDetector f19587h;

        public LayoutUpdateVisitor(List<Pathfinder.PathElement> list, List<LayoutRule> list2, String str, OnLayoutErrorListener onLayoutErrorListener) {
            super(list);
            this.f19582c = new WeakHashMap<>();
            this.f19583d = list2;
            this.f19584e = str;
            this.f19585f = true;
            this.f19586g = onLayoutErrorListener;
            this.f19587h = new CycleDetector();
        }

        private boolean f(Set<Integer> set, SparseArray<View> sparseArray) {
            TreeMap<View, List<View>> treeMap = new TreeMap<>(new Comparator<View>() { // from class: com.mixpanel.android.viewcrawler.ViewVisitor.LayoutUpdateVisitor.1
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(View view, View view2) {
                    if (view == view2) {
                        return 0;
                    }
                    if (view == null) {
                        return -1;
                    }
                    if (view2 == null) {
                        return 1;
                    }
                    return view2.hashCode() - view.hashCode();
                }
            });
            int size = sparseArray.size();
            for (int i8 = 0; i8 < size; i8++) {
                View valueAt = sparseArray.valueAt(i8);
                int[] rules = ((RelativeLayout.LayoutParams) valueAt.getLayoutParams()).getRules();
                ArrayList arrayList = new ArrayList();
                for (Integer num : set) {
                    int i9 = rules[num.intValue()];
                    if (i9 > 0 && i9 != valueAt.getId()) {
                        arrayList.add(sparseArray.get(i9));
                    }
                }
                treeMap.put(valueAt, arrayList);
            }
            return this.f19587h.b(treeMap);
        }

        @Override // com.mixpanel.android.viewcrawler.Pathfinder.Accumulator
        public void a(View view) {
            ViewGroup viewGroup = (ViewGroup) view;
            SparseArray<View> sparseArray = new SparseArray<>();
            int childCount = viewGroup.getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = viewGroup.getChildAt(i8);
                int id = childAt.getId();
                if (id > 0) {
                    sparseArray.put(id, childAt);
                }
            }
            int size = this.f19583d.size();
            for (int i9 = 0; i9 < size; i9++) {
                LayoutRule layoutRule = this.f19583d.get(i9);
                View view2 = sparseArray.get(layoutRule.f19577a);
                if (view2 != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
                    int[] iArr = (int[]) layoutParams.getRules().clone();
                    if (iArr[layoutRule.f19578b] != layoutRule.f19579c) {
                        if (!this.f19582c.containsKey(view2)) {
                            this.f19582c.put(view2, iArr);
                        }
                        layoutParams.addRule(layoutRule.f19578b, layoutRule.f19579c);
                        Set<Integer> set = f19580i;
                        if (!set.contains(Integer.valueOf(layoutRule.f19578b))) {
                            set = f19581j;
                            if (!set.contains(Integer.valueOf(layoutRule.f19578b))) {
                                set = null;
                            }
                        }
                        if (set != null && !f(set, sparseArray)) {
                            b();
                            this.f19586g.c(new LayoutErrorMessage("circular_dependency", this.f19584e));
                            return;
                        }
                        view2.setLayoutParams(layoutParams);
                    } else {
                        continue;
                    }
                }
            }
        }

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        public void b() {
            Iterator<Map.Entry<View, int[]>> it = this.f19582c.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<View, int[]> next = it.next();
                    View key = next.getKey();
                    int[] value = next.getValue();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) key.getLayoutParams();
                    for (int i8 = 0; i8 < value.length; i8++) {
                        layoutParams.addRule(i8, value[i8]);
                    }
                    key.setLayoutParams(layoutParams);
                } else {
                    this.f19585f = false;
                    return;
                }
            }
        }

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        public void e(View view) {
            if (this.f19585f) {
                d().c(view, c(), this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface OnEventListener {
        void a(View view, String str, boolean z7);
    }

    /* loaded from: classes3.dex */
    public interface OnLayoutErrorListener {
        void c(LayoutErrorMessage layoutErrorMessage);
    }

    /* loaded from: classes3.dex */
    public static class PropertySetVisitor extends ViewVisitor {

        /* renamed from: c  reason: collision with root package name */
        private final Caller f19589c;

        /* renamed from: d  reason: collision with root package name */
        private final Caller f19590d;

        /* renamed from: e  reason: collision with root package name */
        private final WeakHashMap<View, Object> f19591e;

        /* renamed from: f  reason: collision with root package name */
        private final Object[] f19592f;

        public PropertySetVisitor(List<Pathfinder.PathElement> list, Caller caller, Caller caller2) {
            super(list);
            this.f19589c = caller;
            this.f19590d = caller2;
            this.f19592f = new Object[1];
            this.f19591e = new WeakHashMap<>();
        }

        @Override // com.mixpanel.android.viewcrawler.Pathfinder.Accumulator
        public void a(View view) {
            if (this.f19590d != null) {
                Object[] e8 = this.f19589c.e();
                if (1 == e8.length) {
                    Object obj = e8[0];
                    Object a8 = this.f19590d.a(view);
                    if (obj == a8) {
                        return;
                    }
                    if (obj != null) {
                        if ((obj instanceof Bitmap) && (a8 instanceof Bitmap)) {
                            if (((Bitmap) obj).sameAs((Bitmap) a8)) {
                                return;
                            }
                        } else if ((obj instanceof BitmapDrawable) && (a8 instanceof BitmapDrawable)) {
                            Bitmap bitmap = ((BitmapDrawable) obj).getBitmap();
                            Bitmap bitmap2 = ((BitmapDrawable) a8).getBitmap();
                            if (bitmap != null && bitmap.sameAs(bitmap2)) {
                                return;
                            }
                        } else if (obj.equals(a8)) {
                            return;
                        }
                    }
                    if (!(a8 instanceof Bitmap) && !(a8 instanceof BitmapDrawable) && !this.f19591e.containsKey(view)) {
                        Object[] objArr = this.f19592f;
                        objArr[0] = a8;
                        if (this.f19589c.c(objArr)) {
                            this.f19591e.put(view, a8);
                        } else {
                            this.f19591e.put(view, null);
                        }
                    }
                }
            }
            this.f19589c.a(view);
        }

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        public void b() {
            for (Map.Entry<View, Object> entry : this.f19591e.entrySet()) {
                View key = entry.getKey();
                Object value = entry.getValue();
                if (value != null) {
                    Object[] objArr = this.f19592f;
                    objArr[0] = value;
                    this.f19589c.b(key, objArr);
                }
            }
        }

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        public /* bridge */ /* synthetic */ void e(View view) {
            super.e(view);
        }
    }

    /* loaded from: classes3.dex */
    public static class ViewDetectorVisitor extends EventTriggeringVisitor {

        /* renamed from: f  reason: collision with root package name */
        private boolean f19593f;

        public ViewDetectorVisitor(List<Pathfinder.PathElement> list, String str, OnEventListener onEventListener) {
            super(list, str, onEventListener, false);
            this.f19593f = false;
        }

        @Override // com.mixpanel.android.viewcrawler.Pathfinder.Accumulator
        public void a(View view) {
            boolean z7;
            if (view != null && !this.f19593f) {
                f(view);
            }
            if (view != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.f19593f = z7;
        }

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        public void b() {
        }

        @Override // com.mixpanel.android.viewcrawler.ViewVisitor
        public /* bridge */ /* synthetic */ void e(View view) {
            super.e(view);
        }
    }

    protected ViewVisitor(List<Pathfinder.PathElement> list) {
        this.f19563a = list;
    }

    public abstract void b();

    protected List<Pathfinder.PathElement> c() {
        return this.f19563a;
    }

    protected Pathfinder d() {
        return this.f19564b;
    }

    public void e(View view) {
        this.f19564b.c(view, this.f19563a, this);
    }
}
