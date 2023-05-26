package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class ListViewCompat {

    /* loaded from: classes.dex */
    static class Api19Impl {
        private Api19Impl() {
        }

        static boolean a(ListView listView, int i8) {
            return listView.canScrollList(i8);
        }

        static void b(ListView listView, int i8) {
            listView.scrollListBy(i8);
        }
    }

    private ListViewCompat() {
    }

    public static void a(@NonNull ListView listView, int i8) {
        Api19Impl.b(listView, i8);
    }
}
