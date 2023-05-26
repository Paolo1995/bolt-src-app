package com.google.android.datatransport.runtime.util;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.google.android.datatransport.Priority;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class PriorityMapping {

    /* renamed from: a  reason: collision with root package name */
    private static SparseArray<Priority> f12367a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<Priority, Integer> f12368b;

    static {
        HashMap<Priority, Integer> hashMap = new HashMap<>();
        f12368b = hashMap;
        hashMap.put(Priority.DEFAULT, 0);
        f12368b.put(Priority.VERY_LOW, 1);
        f12368b.put(Priority.HIGHEST, 2);
        for (Priority priority : f12368b.keySet()) {
            f12367a.append(f12368b.get(priority).intValue(), priority);
        }
    }

    public static int a(@NonNull Priority priority) {
        Integer num = f12368b.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }

    @NonNull
    public static Priority b(int i8) {
        Priority priority = f12367a.get(i8);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i8);
    }
}
