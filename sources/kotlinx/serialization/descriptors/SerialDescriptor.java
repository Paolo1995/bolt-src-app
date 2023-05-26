package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* compiled from: SerialDescriptor.kt */
/* loaded from: classes5.dex */
public interface SerialDescriptor {

    /* compiled from: SerialDescriptor.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static List<Annotation> a(SerialDescriptor serialDescriptor) {
            return CollectionsKt.k();
        }

        public static boolean b(SerialDescriptor serialDescriptor) {
            return false;
        }

        public static boolean c(SerialDescriptor serialDescriptor) {
            return false;
        }
    }

    boolean b();

    int c(String str);

    SerialKind d();

    int e();

    String f(int i8);

    List<Annotation> g(int i8);

    List<Annotation> getAnnotations();

    SerialDescriptor h(int i8);

    String i();

    boolean isInline();

    boolean j(int i8);
}
