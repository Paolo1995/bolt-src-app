package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;

/* loaded from: classes.dex */
class CursorFilter extends Filter {

    /* renamed from: a  reason: collision with root package name */
    CursorFilterClient f6161a;

    /* loaded from: classes.dex */
    interface CursorFilterClient {
        void a(Cursor cursor);

        Cursor b(CharSequence charSequence);

        Cursor c();

        CharSequence convertToString(Cursor cursor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CursorFilter(CursorFilterClient cursorFilterClient) {
        this.f6161a = cursorFilterClient;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f6161a.convertToString((Cursor) obj);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor b8 = this.f6161a.b(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (b8 != null) {
            filterResults.count = b8.getCount();
            filterResults.values = b8;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor c8 = this.f6161a.c();
        Object obj = filterResults.values;
        if (obj != null && obj != c8) {
            this.f6161a.a((Cursor) obj);
        }
    }
}
