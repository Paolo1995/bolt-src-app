package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class MutableOptionsBundle extends OptionsBundle implements MutableConfig {
    @NonNull
    private static final Config.OptionPriority D = Config.OptionPriority.OPTIONAL;

    private MutableOptionsBundle(TreeMap<Config.Option<?>, Map<Config.OptionPriority, Object>> treeMap) {
        super(treeMap);
    }

    @NonNull
    public static MutableOptionsBundle L() {
        return new MutableOptionsBundle(new TreeMap(OptionsBundle.B));
    }

    @NonNull
    public static MutableOptionsBundle M(@NonNull Config config) {
        TreeMap treeMap = new TreeMap(OptionsBundle.B);
        for (Config.Option<?> option : config.c()) {
            Set<Config.OptionPriority> t7 = config.t(option);
            ArrayMap arrayMap = new ArrayMap();
            for (Config.OptionPriority optionPriority : t7) {
                arrayMap.put(optionPriority, config.m(option, optionPriority));
            }
            treeMap.put(option, arrayMap);
        }
        return new MutableOptionsBundle(treeMap);
    }

    public <ValueT> ValueT N(@NonNull Config.Option<ValueT> option) {
        return (ValueT) this.A.remove(option);
    }

    @Override // androidx.camera.core.impl.MutableConfig
    public <ValueT> void k(@NonNull Config.Option<ValueT> option, @NonNull Config.OptionPriority optionPriority, ValueT valuet) {
        Map<Config.OptionPriority, Object> map = this.A.get(option);
        if (map == null) {
            ArrayMap arrayMap = new ArrayMap();
            this.A.put(option, arrayMap);
            arrayMap.put(optionPriority, valuet);
            return;
        }
        Config.OptionPriority optionPriority2 = (Config.OptionPriority) Collections.min(map.keySet());
        if (!Objects.equals(map.get(optionPriority2), valuet) && g.a(optionPriority2, optionPriority)) {
            throw new IllegalArgumentException("Option values conflicts: " + option.c() + ", existing value (" + optionPriority2 + ")=" + map.get(optionPriority2) + ", conflicting (" + optionPriority + ")=" + valuet);
        }
        map.put(optionPriority, valuet);
    }

    @Override // androidx.camera.core.impl.MutableConfig
    public <ValueT> void o(@NonNull Config.Option<ValueT> option, ValueT valuet) {
        k(option, D, valuet);
    }
}
