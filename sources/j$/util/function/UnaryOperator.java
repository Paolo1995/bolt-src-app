package j$.util.function;

import j$.util.function.Function;

/* loaded from: classes2.dex */
public interface UnaryOperator<T> extends Function<T, T> {

    /* loaded from: classes2.dex */
    public final /* synthetic */ class VivifiedWrapper implements UnaryOperator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ java.util.function.UnaryOperator f50304a;

        private /* synthetic */ VivifiedWrapper(java.util.function.UnaryOperator unaryOperator) {
            this.f50304a = unaryOperator;
        }

        public static /* synthetic */ UnaryOperator convert(java.util.function.UnaryOperator unaryOperator) {
            if (unaryOperator == null) {
                return null;
            }
            return new VivifiedWrapper(unaryOperator);
        }

        @Override // j$.util.function.Function
        public final /* synthetic */ Function andThen(Function function) {
            return Function.VivifiedWrapper.convert(this.f50304a.andThen(C.a(function)));
        }

        @Override // j$.util.function.Function
        public final /* synthetic */ Object apply(Object obj) {
            return this.f50304a.apply(obj);
        }

        @Override // j$.util.function.Function
        public final /* synthetic */ Function compose(Function function) {
            return Function.VivifiedWrapper.convert(this.f50304a.compose(C.a(function)));
        }
    }
}
