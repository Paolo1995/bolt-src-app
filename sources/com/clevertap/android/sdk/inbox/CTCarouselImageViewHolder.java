package com.clevertap.android.sdk.inbox;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.clevertap.android.sdk.R$drawable;
import com.clevertap.android.sdk.R$id;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CTCarouselImageViewHolder extends CTInboxBaseMessageViewHolder {
    private final ImageView J;
    private final TextView K;
    private final RelativeLayout L;
    private final CTCarouselViewPager M;
    private final LinearLayout N;

    /* loaded from: classes.dex */
    class CarouselPageChangeListener implements ViewPager.OnPageChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private final Context f11465a;

        /* renamed from: b  reason: collision with root package name */
        private final ImageView[] f11466b;

        /* renamed from: c  reason: collision with root package name */
        private final CTInboxMessage f11467c;

        /* renamed from: d  reason: collision with root package name */
        private final CTCarouselImageViewHolder f11468d;

        CarouselPageChangeListener(Context context, CTCarouselImageViewHolder cTCarouselImageViewHolder, ImageView[] imageViewArr, CTInboxMessage cTInboxMessage) {
            this.f11465a = context;
            this.f11468d = cTCarouselImageViewHolder;
            this.f11466b = imageViewArr;
            this.f11467c = cTInboxMessage;
            imageViewArr[0].setImageDrawable(ResourcesCompat.f(context.getResources(), R$drawable.ct_selected_dot, null));
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void a(int i8, float f8, int i9) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void c(int i8) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void d(int i8) {
            for (ImageView imageView : this.f11466b) {
                imageView.setImageDrawable(ResourcesCompat.f(this.f11465a.getResources(), R$drawable.ct_unselected_dot, null));
            }
            this.f11466b[i8].setImageDrawable(ResourcesCompat.f(this.f11465a.getResources(), R$drawable.ct_selected_dot, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTCarouselImageViewHolder(@NonNull View view) {
        super(view);
        this.M = (CTCarouselViewPager) view.findViewById(R$id.image_carousel_viewpager);
        this.N = (LinearLayout) view.findViewById(R$id.sliderDots);
        this.K = (TextView) view.findViewById(R$id.carousel_timestamp);
        this.J = (ImageView) view.findViewById(R$id.carousel_read_circle);
        this.L = (RelativeLayout) view.findViewById(R$id.body_linear_layout);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.clevertap.android.sdk.inbox.CTInboxBaseMessageViewHolder
    public void R(CTInboxMessage cTInboxMessage, final CTInboxListViewFragment cTInboxListViewFragment, final int i8) {
        super.R(cTInboxMessage, cTInboxListViewFragment, i8);
        final CTInboxListViewFragment U = U();
        Context applicationContext = cTInboxListViewFragment.getActivity().getApplicationContext();
        CTInboxMessageContent cTInboxMessageContent = cTInboxMessage.f().get(0);
        this.K.setVisibility(0);
        if (cTInboxMessage.o()) {
            this.J.setVisibility(8);
        } else {
            this.J.setVisibility(0);
        }
        this.K.setText(Q(cTInboxMessage.d()));
        this.K.setTextColor(Color.parseColor(cTInboxMessageContent.s()));
        this.L.setBackgroundColor(Color.parseColor(cTInboxMessage.a()));
        this.M.setAdapter(new CTCarouselViewPagerAdapter(applicationContext, cTInboxListViewFragment, cTInboxMessage, (LinearLayout.LayoutParams) this.M.getLayoutParams(), i8));
        int size = cTInboxMessage.f().size();
        if (this.N.getChildCount() > 0) {
            this.N.removeAllViews();
        }
        ImageView[] imageViewArr = new ImageView[size];
        Z(imageViewArr, size, applicationContext, this.N);
        imageViewArr[0].setImageDrawable(ResourcesCompat.f(applicationContext.getResources(), R$drawable.ct_selected_dot, null));
        this.M.c(new CarouselPageChangeListener(cTInboxListViewFragment.getActivity().getApplicationContext(), this, imageViewArr, cTInboxMessage));
        this.L.setOnClickListener(new CTInboxButtonClickListener(i8, cTInboxMessage, (String) null, U, this.M));
        new Handler().postDelayed(new Runnable() { // from class: com.clevertap.android.sdk.inbox.CTCarouselImageViewHolder.1
            @Override // java.lang.Runnable
            public void run() {
                FragmentActivity activity = cTInboxListViewFragment.getActivity();
                if (activity == null) {
                    return;
                }
                activity.runOnUiThread(new Runnable() { // from class: com.clevertap.android.sdk.inbox.CTCarouselImageViewHolder.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1;
                        CTInboxListViewFragment cTInboxListViewFragment2;
                        if (CTCarouselImageViewHolder.this.J.getVisibility() == 0 && (cTInboxListViewFragment2 = U) != null) {
                            cTInboxListViewFragment2.E(null, i8);
                        }
                        CTCarouselImageViewHolder.this.J.setVisibility(8);
                    }
                });
            }
        }, 2000L);
    }
}
