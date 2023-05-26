package dagger.internal;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes3.dex */
public final class DaggerCollections {
    private static final int MAX_POWER_OF_TWO = 1073741824;

    private DaggerCollections() {
    }

    private static int calculateInitialCapacity(int i8) {
        return i8 < 3 ? i8 + 1 : i8 < 1073741824 ? (int) ((i8 / 0.75f) + 1.0f) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static boolean hasDuplicates(List<?> list) {
        if (list.size() < 2) {
            return false;
        }
        if (list.size() == new HashSet(list).size()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> HashSet<T> newHashSetWithExpectedSize(int i8) {
        return new HashSet<>(calculateInitialCapacity(i8));
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int i8) {
        return new LinkedHashMap<>(calculateInitialCapacity(i8));
    }

    public static <T> List<T> presizedList(int i8) {
        if (i8 == 0) {
            return Collections.emptyList();
        }
        return new ArrayList(i8);
    }
}
