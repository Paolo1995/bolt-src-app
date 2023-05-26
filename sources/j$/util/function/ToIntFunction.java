package j$.util.function;

/* loaded from: classes2.dex */
public interface ToIntFunction<T> {

    /* loaded from: classes2.dex */
    public final /* synthetic */ class VivifiedWrapper implements ToIntFunction {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ java.util.function.ToIntFunction f50302a;

        private /* synthetic */ VivifiedWrapper(java.util.function.ToIntFunction toIntFunction) {
            this.f50302a = toIntFunction;
        }

        public static /* synthetic */ ToIntFunction convert(java.util.function.ToIntFunction toIntFunction) {
            if (toIntFunction == null) {
                return null;
            }
            return toIntFunction instanceof I0 ? ((I0) toIntFunction).f50290a : new VivifiedWrapper(toIntFunction);
        }

        @Override // j$.util.function.ToIntFunction
        public final /* synthetic */ int applyAsInt(Object obj) {
            return this.f50302a.applyAsInt(obj);
        }
    }

    int applyAsInt(T t7);
}
