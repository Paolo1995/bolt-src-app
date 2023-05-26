package j$.util.function;

/* loaded from: classes2.dex */
public interface Consumer<T> {

    /* renamed from: j$.util.function.Consumer$-CC */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC<T> {
        public static Consumer $default$andThen(Consumer consumer, Consumer consumer2) {
            consumer2.getClass();
            return new j$.util.concurrent.u(3, consumer, consumer2);
        }
    }

    /* loaded from: classes2.dex */
    public final /* synthetic */ class VivifiedWrapper implements Consumer {

        /* renamed from: a */
        final /* synthetic */ java.util.function.Consumer f50275a;

        private /* synthetic */ VivifiedWrapper(java.util.function.Consumer consumer) {
            this.f50275a = consumer;
        }

        public static /* synthetic */ Consumer convert(java.util.function.Consumer consumer) {
            if (consumer == null) {
                return null;
            }
            return consumer instanceof C0122e ? ((C0122e) consumer).f50317a : new VivifiedWrapper(consumer);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ void accept(Object obj) {
            this.f50275a.accept(obj);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ Consumer andThen(Consumer consumer) {
            return convert(this.f50275a.andThen(C0122e.a(consumer)));
        }
    }

    void accept(T t7);

    Consumer<T> andThen(Consumer<? super T> consumer);
}
