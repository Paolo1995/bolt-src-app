package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: SavedStateHandle.kt */
/* loaded from: classes.dex */
public final class SavedStateHandle {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f6747f = new Companion(null);

    /* renamed from: g  reason: collision with root package name */
    private static final Class<? extends Object>[] f6748g = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f6749a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, SavedStateRegistry.SavedStateProvider> f6750b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Object> f6751c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, MutableStateFlow<Object>> f6752d;

    /* renamed from: e  reason: collision with root package name */
    private final SavedStateRegistry.SavedStateProvider f6753e;

    /* compiled from: SavedStateHandle.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SavedStateHandle a(Bundle bundle, Bundle bundle2) {
            boolean z7;
            if (bundle == null) {
                if (bundle2 == null) {
                    return new SavedStateHandle();
                }
                HashMap hashMap = new HashMap();
                for (String key : bundle2.keySet()) {
                    Intrinsics.e(key, "key");
                    hashMap.put(key, bundle2.get(key));
                }
                return new SavedStateHandle(hashMap);
            }
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
            if (parcelableArrayList != null && parcelableArrayList2 != null && parcelableArrayList.size() == parcelableArrayList2.size()) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int size = parcelableArrayList.size();
                for (int i8 = 0; i8 < size; i8++) {
                    Object obj = parcelableArrayList.get(i8);
                    if (obj != null) {
                        linkedHashMap.put((String) obj, parcelableArrayList2.get(i8));
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                }
                return new SavedStateHandle(linkedHashMap);
            }
            throw new IllegalStateException("Invalid bundle passed as restored state".toString());
        }

        public final boolean b(Object obj) {
            Class[] clsArr;
            if (obj == null) {
                return true;
            }
            for (Class cls : SavedStateHandle.f6748g) {
                Intrinsics.c(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }
    }

    public SavedStateHandle(Map<String, ? extends Object> initialState) {
        Intrinsics.f(initialState, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f6749a = linkedHashMap;
        this.f6750b = new LinkedHashMap();
        this.f6751c = new LinkedHashMap();
        this.f6752d = new LinkedHashMap();
        this.f6753e = new SavedStateRegistry.SavedStateProvider() { // from class: androidx.lifecycle.c
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle b() {
                Bundle e8;
                e8 = SavedStateHandle.e(SavedStateHandle.this);
                return e8;
            }
        };
        linkedHashMap.putAll(initialState);
    }

    public static final SavedStateHandle c(Bundle bundle, Bundle bundle2) {
        return f6747f.a(bundle, bundle2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle e(SavedStateHandle this$0) {
        Map s7;
        Intrinsics.f(this$0, "this$0");
        s7 = MapsKt__MapsKt.s(this$0.f6750b);
        for (Map.Entry entry : s7.entrySet()) {
            this$0.f((String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).b());
        }
        Set<String> keySet = this$0.f6749a.keySet();
        ArrayList arrayList = new ArrayList(keySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : keySet) {
            arrayList.add(str);
            arrayList2.add(this$0.f6749a.get(str));
        }
        return BundleKt.a(TuplesKt.a("keys", arrayList), TuplesKt.a("values", arrayList2));
    }

    public final SavedStateRegistry.SavedStateProvider d() {
        return this.f6753e;
    }

    public final <T> void f(String key, T t7) {
        MutableLiveData mutableLiveData;
        Intrinsics.f(key, "key");
        if (f6747f.b(t7)) {
            Object obj = this.f6751c.get(key);
            if (obj instanceof MutableLiveData) {
                mutableLiveData = (MutableLiveData) obj;
            } else {
                mutableLiveData = null;
            }
            if (mutableLiveData != null) {
                mutableLiveData.o(t7);
            } else {
                this.f6749a.put(key, t7);
            }
            MutableStateFlow<Object> mutableStateFlow = this.f6752d.get(key);
            if (mutableStateFlow != null) {
                mutableStateFlow.setValue(t7);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't put value with type ");
        Intrinsics.c(t7);
        sb.append(t7.getClass());
        sb.append(" into saved state");
        throw new IllegalArgumentException(sb.toString());
    }

    public SavedStateHandle() {
        this.f6749a = new LinkedHashMap();
        this.f6750b = new LinkedHashMap();
        this.f6751c = new LinkedHashMap();
        this.f6752d = new LinkedHashMap();
        this.f6753e = new SavedStateRegistry.SavedStateProvider() { // from class: androidx.lifecycle.c
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle b() {
                Bundle e8;
                e8 = SavedStateHandle.e(SavedStateHandle.this);
                return e8;
            }
        };
    }
}
