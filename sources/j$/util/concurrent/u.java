package j$.util.concurrent;

import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public final /* synthetic */ class u implements BiConsumer, BiFunction, Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50248a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f50249b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f50250c;

    public /* synthetic */ u(int i8, Object obj, Object obj2) {
        this.f50248a = i8;
        this.f50249b = obj;
        this.f50250c = obj2;
    }

    public /* synthetic */ u(BiFunction biFunction, Function function) {
        this.f50248a = 2;
        this.f50250c = biFunction;
        this.f50249b = function;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        ((Consumer) this.f50249b).accept(obj);
        ((Consumer) this.f50250c).accept(obj);
    }

    @Override // j$.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f50248a) {
            case 0:
                ConcurrentMap concurrentMap = (ConcurrentMap) this.f50249b;
                BiFunction biFunction = (BiFunction) this.f50250c;
                while (!concurrentMap.replace(obj, obj2, biFunction.apply(obj, obj2)) && (obj2 = concurrentMap.get(obj)) != null) {
                }
                return;
            default:
                ((BiConsumer) this.f50249b).accept(obj, obj2);
                ((BiConsumer) this.f50250c).accept(obj, obj2);
                return;
        }
    }

    @Override // j$.util.function.BiConsumer
    public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.f50248a) {
            case 0:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            default:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
        }
    }

    @Override // j$.util.function.BiFunction
    public final /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction.CC.$default$andThen(this, function);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return ((Function) this.f50249b).apply(((BiFunction) this.f50250c).apply(obj, obj2));
    }
}
