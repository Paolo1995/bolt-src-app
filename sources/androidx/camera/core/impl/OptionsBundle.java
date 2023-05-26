package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class OptionsBundle implements Config {
    protected static final Comparator<Config.Option<?>> B;
    private static final OptionsBundle C;
    protected final TreeMap<Config.Option<?>, Map<Config.OptionPriority, Object>> A;

    static {
        Comparator<Config.Option<?>> comparator = new Comparator() { // from class: androidx.camera.core.impl.s
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int K;
                K = OptionsBundle.K((Config.Option) obj, (Config.Option) obj2);
                return K;
            }
        };
        B = comparator;
        C = new OptionsBundle(new TreeMap(comparator));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OptionsBundle(TreeMap<Config.Option<?>, Map<Config.OptionPriority, Object>> treeMap) {
        this.A = treeMap;
    }

    @NonNull
    public static OptionsBundle I() {
        return C;
    }

    @NonNull
    public static OptionsBundle J(@NonNull Config config) {
        if (OptionsBundle.class.equals(config.getClass())) {
            return (OptionsBundle) config;
        }
        TreeMap treeMap = new TreeMap(B);
        for (Config.Option<?> option : config.c()) {
            Set<Config.OptionPriority> t7 = config.t(option);
            ArrayMap arrayMap = new ArrayMap();
            for (Config.OptionPriority optionPriority : t7) {
                arrayMap.put(optionPriority, config.m(option, optionPriority));
            }
            treeMap.put(option, arrayMap);
        }
        return new OptionsBundle(treeMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int K(Config.Option option, Config.Option option2) {
        return option.c().compareTo(option2.c());
    }

    @Override // androidx.camera.core.impl.Config
    public <ValueT> ValueT a(@NonNull Config.Option<ValueT> option) {
        Map<Config.OptionPriority, Object> map = this.A.get(option);
        if (map != null) {
            return (ValueT) map.get((Config.OptionPriority) Collections.min(map.keySet()));
        }
        throw new IllegalArgumentException("Option does not exist: " + option);
    }

    @Override // androidx.camera.core.impl.Config
    public boolean b(@NonNull Config.Option<?> option) {
        return this.A.containsKey(option);
    }

    @Override // androidx.camera.core.impl.Config
    @NonNull
    public Set<Config.Option<?>> c() {
        return Collections.unmodifiableSet(this.A.keySet());
    }

    @Override // androidx.camera.core.impl.Config
    public <ValueT> ValueT e(@NonNull Config.Option<ValueT> option, ValueT valuet) {
        try {
            return (ValueT) a(option);
        } catch (IllegalArgumentException unused) {
            return valuet;
        }
    }

    @Override // androidx.camera.core.impl.Config
    @NonNull
    public Config.OptionPriority f(@NonNull Config.Option<?> option) {
        Map<Config.OptionPriority, Object> map = this.A.get(option);
        if (map != null) {
            return (Config.OptionPriority) Collections.min(map.keySet());
        }
        throw new IllegalArgumentException("Option does not exist: " + option);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x001a  */
    @Override // androidx.camera.core.impl.Config
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void l(@androidx.annotation.NonNull java.lang.String r4, @androidx.annotation.NonNull androidx.camera.core.impl.Config.OptionMatcher r5) {
        /*
            r3 = this;
            java.lang.Class<java.lang.Void> r0 = java.lang.Void.class
            androidx.camera.core.impl.Config$Option r0 = androidx.camera.core.impl.Config.Option.a(r4, r0)
            java.util.TreeMap<androidx.camera.core.impl.Config$Option<?>, java.util.Map<androidx.camera.core.impl.Config$OptionPriority, java.lang.Object>> r1 = r3.A
            java.util.SortedMap r0 = r1.tailMap(r0)
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L14:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L3d
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            androidx.camera.core.impl.Config$Option r2 = (androidx.camera.core.impl.Config.Option) r2
            java.lang.String r2 = r2.c()
            boolean r2 = r2.startsWith(r4)
            if (r2 != 0) goto L31
            goto L3d
        L31:
            java.lang.Object r1 = r1.getKey()
            androidx.camera.core.impl.Config$Option r1 = (androidx.camera.core.impl.Config.Option) r1
            boolean r1 = r5.a(r1)
            if (r1 != 0) goto L14
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.OptionsBundle.l(java.lang.String, androidx.camera.core.impl.Config$OptionMatcher):void");
    }

    @Override // androidx.camera.core.impl.Config
    public <ValueT> ValueT m(@NonNull Config.Option<ValueT> option, @NonNull Config.OptionPriority optionPriority) {
        Map<Config.OptionPriority, Object> map = this.A.get(option);
        if (map != null) {
            if (map.containsKey(optionPriority)) {
                return (ValueT) map.get(optionPriority);
            }
            throw new IllegalArgumentException("Option does not exist: " + option + " with priority=" + optionPriority);
        }
        throw new IllegalArgumentException("Option does not exist: " + option);
    }

    @Override // androidx.camera.core.impl.Config
    @NonNull
    public Set<Config.OptionPriority> t(@NonNull Config.Option<?> option) {
        Map<Config.OptionPriority, Object> map = this.A.get(option);
        if (map == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(map.keySet());
    }
}
