package com.example.acer.panda;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter (Context context){
        this.context = context;
    }


    public int[] slide_images = {
        R.drawable.sukarno_icon,
        R.drawable.hatta_icon,
        R.drawable.jendsudirman_icon
    };

    public String[] slide_headings = {
            "Ir. Soekarno",
            "Mohammad Hatta",
            "Jenderal Sudirman"
    };

    public String[] slide_descs = {
            "Soekarno merupakan presiden pertama di Indonesia yang lahir di Surabaya pada tanggal 6 Juni tahun 1901. " +
                    "Beliau mendapa sebutan sebagai bapak proklamator kemerdekaan Indonesia yang diselenggarakan pada tanggal 17 Agustus 1945.",
            "Bung Hatta adalah seorang wakil presiden Ir. Sukarno yang lahir pada tanggal 12 Agustus 1902 tepatnya di kota Bukittinggi. " +
                    "Bersama Bung Karno, Mohammad Hatta mendapat gelar sebagai Pahlawan Proklamator.",
            "Jenderal Sudirman adalah panglima tentara pertama Republik Indonesia dengan jabatan Jenderal Besar TNI " +
                    "Anumerta Sudirman yang lahir di Purbalingga provinsi Jawa tengah pada tanggal 24 Januari di tahun 1916."
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
