package kotlin.io;

import androidx.fragment.app.FragmentTransaction;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;

/* compiled from: ReadWrite.kt */
/* loaded from: classes5.dex */
public final class TextStreamsKt {
    public static final long a(Reader reader, Writer out, int i8) {
        Intrinsics.f(reader, "<this>");
        Intrinsics.f(out, "out");
        char[] cArr = new char[i8];
        int read = reader.read(cArr);
        long j8 = 0;
        while (read >= 0) {
            out.write(cArr, 0, read);
            j8 += read;
            read = reader.read(cArr);
        }
        return j8;
    }

    public static /* synthetic */ long b(Reader reader, Writer writer, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = FragmentTransaction.TRANSIT_EXIT_MASK;
        }
        return a(reader, writer, i8);
    }

    public static final void c(Reader reader, Function1<? super String, Unit> action) {
        BufferedReader bufferedReader;
        Intrinsics.f(reader, "<this>");
        Intrinsics.f(action, "action");
        if (reader instanceof BufferedReader) {
            bufferedReader = (BufferedReader) reader;
        } else {
            bufferedReader = new BufferedReader(reader, FragmentTransaction.TRANSIT_EXIT_MASK);
        }
        try {
            for (String str : d(bufferedReader)) {
                action.invoke(str);
            }
            Unit unit = Unit.f50853a;
            CloseableKt.a(bufferedReader, null);
        } finally {
        }
    }

    public static final Sequence<String> d(BufferedReader bufferedReader) {
        Sequence<String> d8;
        Intrinsics.f(bufferedReader, "<this>");
        d8 = SequencesKt__SequencesKt.d(new LinesSequence(bufferedReader));
        return d8;
    }

    public static final List<String> e(Reader reader) {
        Intrinsics.f(reader, "<this>");
        final ArrayList arrayList = new ArrayList();
        c(reader, new Function1<String, Unit>() { // from class: kotlin.io.TextStreamsKt$readLines$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(String it) {
                Intrinsics.f(it, "it");
                arrayList.add(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        });
        return arrayList;
    }

    public static final String f(Reader reader) {
        Intrinsics.f(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        b(reader, stringWriter, 0, 2, null);
        String stringWriter2 = stringWriter.toString();
        Intrinsics.e(stringWriter2, "buffer.toString()");
        return stringWriter2;
    }
}
