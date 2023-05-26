package androidx.transition;

import android.util.SparseArray;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class TransitionValuesMaps {

    /* renamed from: a  reason: collision with root package name */
    final ArrayMap<View, TransitionValues> f7878a = new ArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    final SparseArray<View> f7879b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    final LongSparseArray<View> f7880c = new LongSparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    final ArrayMap<String, View> f7881d = new ArrayMap<>();
}
