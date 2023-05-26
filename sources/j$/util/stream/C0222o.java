package j$.util.stream;

import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.BiConsumer;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: j$.util.stream.o  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0222o implements Consumer, Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50626a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f50627b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f50628c;

    public /* synthetic */ C0222o(int i8, Object obj, Object obj2) {
        this.f50626a = i8;
        this.f50627b = obj;
        this.f50628c = obj2;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f50626a) {
            case 0:
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f50627b;
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f50628c;
                if (obj == null) {
                    atomicBoolean.set(true);
                    return;
                } else {
                    concurrentHashMap.putIfAbsent(obj, Boolean.TRUE);
                    return;
                }
            case 5:
                ((BiConsumer) this.f50627b).accept(this.f50628c, obj);
                return;
            default:
                ((C0175c3) this.f50627b).h((Consumer) this.f50628c, obj);
                return;
        }
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f50626a) {
            case 0:
                return Consumer.CC.$default$andThen(this, consumer);
            case 5:
                return Consumer.CC.$default$andThen(this, consumer);
            default:
                return Consumer.CC.$default$andThen(this, consumer);
        }
    }

    @Override // j$.util.function.Supplier
    public final Object get() {
        switch (this.f50626a) {
            case 1:
                return new C0227p0((j$.util.function.N) this.f50628c, (EnumC0242t0) this.f50627b);
            case 2:
                return new C0223o0((Predicate) this.f50628c, (EnumC0242t0) this.f50627b);
            case 3:
                return new C0234r0((j$.util.function.r) this.f50628c, (EnumC0242t0) this.f50627b);
            default:
                return new C0231q0((j$.util.function.k0) this.f50628c, (EnumC0242t0) this.f50627b);
        }
    }
}
