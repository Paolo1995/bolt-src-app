package j$.util.function;

/* loaded from: classes2.dex */
public interface BiConsumer<T, U> {

    /* renamed from: j$.util.function.BiConsumer$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC<T, U> {
        public static BiConsumer $default$andThen(BiConsumer biConsumer, BiConsumer biConsumer2) {
            biConsumer2.getClass();
            return new j$.util.concurrent.u(1, biConsumer, biConsumer2);
        }
    }

    /* loaded from: classes2.dex */
    public final /* synthetic */ class VivifiedWrapper implements BiConsumer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ java.util.function.BiConsumer f50270a;

        private /* synthetic */ VivifiedWrapper(java.util.function.BiConsumer biConsumer) {
            this.f50270a = biConsumer;
        }

        public static /* synthetic */ BiConsumer convert(java.util.function.BiConsumer biConsumer) {
            if (biConsumer == null) {
                return null;
            }
            return biConsumer instanceof Wrapper ? BiConsumer.this : new VivifiedWrapper(biConsumer);
        }

        @Override // j$.util.function.BiConsumer
        public final /* synthetic */ void accept(Object obj, Object obj2) {
            this.f50270a.accept(obj, obj2);
        }

        @Override // j$.util.function.BiConsumer
        public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
            return convert(this.f50270a.andThen(Wrapper.convert(biConsumer)));
        }
    }

    /* loaded from: classes2.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.BiConsumer {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.BiConsumer convert(BiConsumer biConsumer) {
            if (biConsumer == null) {
                return null;
            }
            return biConsumer instanceof VivifiedWrapper ? ((VivifiedWrapper) biConsumer).f50270a : new Wrapper();
        }

        @Override // java.util.function.BiConsumer
        public final /* synthetic */ void accept(Object obj, Object obj2) {
            BiConsumer.this.accept(obj, obj2);
        }

        @Override // java.util.function.BiConsumer
        public final /* synthetic */ java.util.function.BiConsumer andThen(java.util.function.BiConsumer biConsumer) {
            return convert(BiConsumer.this.andThen(VivifiedWrapper.convert(biConsumer)));
        }
    }

    void accept(T t7, U u7);

    BiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> biConsumer);
}
