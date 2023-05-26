package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.cursoradapter.widget.CursorFilter;

/* loaded from: classes.dex */
public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.CursorFilterClient {

    /* renamed from: f  reason: collision with root package name */
    protected boolean f6151f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f6152g;

    /* renamed from: h  reason: collision with root package name */
    protected Cursor f6153h;

    /* renamed from: i  reason: collision with root package name */
    protected Context f6154i;

    /* renamed from: j  reason: collision with root package name */
    protected int f6155j;

    /* renamed from: k  reason: collision with root package name */
    protected ChangeObserver f6156k;

    /* renamed from: l  reason: collision with root package name */
    protected DataSetObserver f6157l;

    /* renamed from: m  reason: collision with root package name */
    protected CursorFilter f6158m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ChangeObserver extends ContentObserver {
        ChangeObserver() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z7) {
            CursorAdapter.this.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class MyDataSetObserver extends DataSetObserver {
        MyDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.f6151f = true;
            cursorAdapter.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.f6151f = false;
            cursorAdapter.notifyDataSetInvalidated();
        }
    }

    public CursorAdapter(Context context, Cursor cursor, boolean z7) {
        int i8;
        if (z7) {
            i8 = 1;
        } else {
            i8 = 2;
        }
        e(context, cursor, i8);
    }

    public void a(Cursor cursor) {
        Cursor i8 = i(cursor);
        if (i8 != null) {
            i8.close();
        }
    }

    @Override // androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor c() {
        return this.f6153h;
    }

    public abstract CharSequence convertToString(Cursor cursor);

    public abstract void d(View view, Context context, Cursor cursor);

    void e(Context context, Cursor cursor, int i8) {
        int i9;
        boolean z7 = false;
        if ((i8 & 1) == 1) {
            i8 |= 2;
            this.f6152g = true;
        } else {
            this.f6152g = false;
        }
        if (cursor != null) {
            z7 = true;
        }
        this.f6153h = cursor;
        this.f6151f = z7;
        this.f6154i = context;
        if (z7) {
            i9 = cursor.getColumnIndexOrThrow("_id");
        } else {
            i9 = -1;
        }
        this.f6155j = i9;
        if ((i8 & 2) == 2) {
            this.f6156k = new ChangeObserver();
            this.f6157l = new MyDataSetObserver();
        } else {
            this.f6156k = null;
            this.f6157l = null;
        }
        if (z7) {
            ChangeObserver changeObserver = this.f6156k;
            if (changeObserver != null) {
                cursor.registerContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.f6157l;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View f(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (this.f6151f && (cursor = this.f6153h) != null) {
            return cursor.getCount();
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i8, View view, ViewGroup viewGroup) {
        if (this.f6151f) {
            this.f6153h.moveToPosition(i8);
            if (view == null) {
                view = f(this.f6154i, this.f6153h, viewGroup);
            }
            d(view, this.f6154i, this.f6153h);
            return view;
        }
        return null;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f6158m == null) {
            this.f6158m = new CursorFilter(this);
        }
        return this.f6158m;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i8) {
        Cursor cursor;
        if (this.f6151f && (cursor = this.f6153h) != null) {
            cursor.moveToPosition(i8);
            return this.f6153h;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i8) {
        Cursor cursor;
        if (!this.f6151f || (cursor = this.f6153h) == null || !cursor.moveToPosition(i8)) {
            return 0L;
        }
        return this.f6153h.getLong(this.f6155j);
    }

    @Override // android.widget.Adapter
    public View getView(int i8, View view, ViewGroup viewGroup) {
        if (this.f6151f) {
            if (this.f6153h.moveToPosition(i8)) {
                if (view == null) {
                    view = g(this.f6154i, this.f6153h, viewGroup);
                }
                d(view, this.f6154i, this.f6153h);
                return view;
            }
            throw new IllegalStateException("couldn't move cursor to position " + i8);
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    protected void h() {
        Cursor cursor;
        if (this.f6152g && (cursor = this.f6153h) != null && !cursor.isClosed()) {
            this.f6151f = this.f6153h.requery();
        }
    }

    public Cursor i(Cursor cursor) {
        Cursor cursor2 = this.f6153h;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            ChangeObserver changeObserver = this.f6156k;
            if (changeObserver != null) {
                cursor2.unregisterContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.f6157l;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f6153h = cursor;
        if (cursor != null) {
            ChangeObserver changeObserver2 = this.f6156k;
            if (changeObserver2 != null) {
                cursor.registerContentObserver(changeObserver2);
            }
            DataSetObserver dataSetObserver2 = this.f6157l;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f6155j = cursor.getColumnIndexOrThrow("_id");
            this.f6151f = true;
            notifyDataSetChanged();
        } else {
            this.f6155j = -1;
            this.f6151f = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
