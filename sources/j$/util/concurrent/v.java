package j$.util.concurrent;

import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.Function;

/* loaded from: classes2.dex */
public interface v extends Map {
    @Override // j$.util.Map
    Object computeIfAbsent(Object obj, Function function);

    @Override // j$.util.Map
    void forEach(BiConsumer biConsumer);
}
