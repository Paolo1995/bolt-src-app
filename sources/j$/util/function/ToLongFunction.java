package j$.util.function;

/* loaded from: classes2.dex */
public interface ToLongFunction<T> {

    /* loaded from: classes2.dex */
    public final /* synthetic */ class VivifiedWrapper implements ToLongFunction {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ java.util.function.ToLongFunction f50303a;

        private /* synthetic */ VivifiedWrapper(java.util.function.ToLongFunction toLongFunction) {
            this.f50303a = toLongFunction;
        }

        public static /* synthetic */ ToLongFunction convert(java.util.function.ToLongFunction toLongFunction) {
            if (toLongFunction == null) {
                return null;
            }
            return toLongFunction instanceof J0 ? ((J0) toLongFunction).f50292a : new VivifiedWrapper(toLongFunction);
        }

        @Override // j$.util.function.ToLongFunction
        public final /* synthetic */ long applyAsLong(Object obj) {
            return this.f50303a.applyAsLong(obj);
        }
    }

    long applyAsLong(Object obj);
}
