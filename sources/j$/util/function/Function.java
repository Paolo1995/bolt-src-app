package j$.util.function;

/* loaded from: classes2.dex */
public interface Function<T, R> {

    /* renamed from: j$.util.function.Function$-CC */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC<T, R> {
        public static Function $default$andThen(Function function, Function function2) {
            function2.getClass();
            return new B(function, function2, 0);
        }

        public static Function $default$compose(Function function, Function function2) {
            function2.getClass();
            return new B(function, function2, 1);
        }
    }

    /* loaded from: classes2.dex */
    public final /* synthetic */ class VivifiedWrapper implements Function {

        /* renamed from: a */
        final /* synthetic */ java.util.function.Function f50283a;

        private /* synthetic */ VivifiedWrapper(java.util.function.Function function) {
            this.f50283a = function;
        }

        public static /* synthetic */ Function convert(java.util.function.Function function) {
            if (function == null) {
                return null;
            }
            return function instanceof C ? ((C) function).f50274a : new VivifiedWrapper(function);
        }

        @Override // j$.util.function.Function
        public final /* synthetic */ Function andThen(Function function) {
            return convert(this.f50283a.andThen(C.a(function)));
        }

        @Override // j$.util.function.Function
        public final /* synthetic */ Object apply(Object obj) {
            return this.f50283a.apply(obj);
        }

        @Override // j$.util.function.Function
        public final /* synthetic */ Function compose(Function function) {
            return convert(this.f50283a.compose(C.a(function)));
        }
    }

    <V> Function<T, V> andThen(Function<? super R, ? extends V> function);

    R apply(T t7);

    <V> Function<V, R> compose(Function<? super V, ? extends T> function);
}
