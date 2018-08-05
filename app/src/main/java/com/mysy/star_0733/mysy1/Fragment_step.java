package com.mysy.star_0733.mysy1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.shashank.sony.fancytoastlib.FancyToast;
import com.squareup.picasso.Picasso;

public class Fragment_step extends Fragment {
    ImageView info;
    View rootview;
    TextView head_8_topic_1,head_8_topic_2,head_8_topic_3,head_8_topic_4,head_8_topic_5,head_8_topic_6,head_8_topic_7,head_8_topic_8,head_8_topic_9,head_8_topic_10;
    ImageView img_head_8_topic_1,img_head_8_topic_2,img_head_8_topic_3,img_head_8_topic_4,img_head_8_topic_5,img_head_8_topic_6,img_head_8_topic_8,img_head_8_topic_10;
    LinearLayout img_head_8_topic_9;

    TextView help_center_1,help_center_2,help_center_3,help_center_4;
    boolean flag1=true,flag2=true,flag3=true,flag4=true,flag5=true,flag6=true,flag8=true,flag9=true;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_step,container,false);
        return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        DialogFragment dia = new Step_dialog();
        dia.setCancelable(true);
        dia.show(ft,"dialog");
        info = rootview.findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), "Click on Gray Area to change Field", Toast.LENGTH_SHORT).show();
                FancyToast.makeText(getContext(),"Click on Step no. to open the Image",FancyToast.LENGTH_LONG,R.drawable.ic_info_step,false).show();
            }
        });

        head_8_topic_1 = rootview.findViewById(R.id.head_8_topic_1);
        img_head_8_topic_1 = rootview.findViewById(R.id.img_head_8_topic_1);
        head_8_topic_2 = rootview.findViewById(R.id.head_8_topic_2);
        img_head_8_topic_2 = rootview.findViewById(R.id.img_head_8_topic_2);
        head_8_topic_3 = rootview.findViewById(R.id.head_8_topic_3);
        img_head_8_topic_3 = rootview.findViewById(R.id.img_head_8_topic_3);
        head_8_topic_4 = rootview.findViewById(R.id.head_8_topic_4);
        img_head_8_topic_4 = rootview.findViewById(R.id.img_head_8_topic_4);
        head_8_topic_5 = rootview.findViewById(R.id.head_8_topic_5);
        img_head_8_topic_5 = rootview.findViewById(R.id.img_head_8_topic_5);
        head_8_topic_6 = rootview.findViewById(R.id.head_8_topic_6);
        img_head_8_topic_6 = rootview.findViewById(R.id.img_head_8_topic_6);
        head_8_topic_8 = rootview.findViewById(R.id.head_8_topic_8);
        img_head_8_topic_8 = rootview.findViewById(R.id.img_head_8_topic_8);
        head_8_topic_9 = rootview.findViewById(R.id.head_8_topic_9);
        img_head_8_topic_9 = rootview.findViewById(R.id.img_head_8_topic_9);
        head_8_topic_10 = rootview.findViewById(R.id.head_8_topic_10);
        img_head_8_topic_10 = rootview.findViewById(R.id.img_head_8_topic_10);


        Picasso.with(getContext()).load(R.drawable.home_page).into(img_head_8_topic_1);
        Picasso.with(getContext()).load(R.drawable.registration).into(img_head_8_topic_2);
        Picasso.with(getContext()).load(R.drawable.f_t_reg).into(img_head_8_topic_3);
        Picasso.with(getContext()).load(R.drawable.login).into(img_head_8_topic_4);
        Picasso.with(getContext()).load(R.drawable.hostel).into(img_head_8_topic_5);
        Picasso.with(getContext()).load(R.drawable.upload).into(img_head_8_topic_6);
        Picasso.with(getContext()).load(R.drawable.lock1).into(img_head_8_topic_8);

        head_8_topic_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_head_8_topic_1.setVisibility(View.GONE);

                if(flag1)
                {
                    img_head_8_topic_1.setVisibility(View.VISIBLE);
                    flag1=false;
                }
                else {
                    img_head_8_topic_1.setVisibility(View.GONE);
                    flag1=true;
                }
            }
        });
        head_8_topic_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_head_8_topic_2.setVisibility(View.GONE);
                if(flag2)
                {
                    img_head_8_topic_2.setVisibility(View.VISIBLE);
                    flag2=false;
                }
                else {
                    img_head_8_topic_2.setVisibility(View.GONE);
                    flag2=true;
                }
            }
        });
        head_8_topic_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_head_8_topic_3.setVisibility(View.GONE);
                if(flag3)
                {
                    img_head_8_topic_3.setVisibility(View.VISIBLE);
                    flag3=false;
                }
                else {
                    img_head_8_topic_3.setVisibility(View.GONE);
                    flag3=true;
                }
            }
        });
        head_8_topic_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_head_8_topic_4.setVisibility(View.GONE);
                if(flag4)
                {
                    img_head_8_topic_4.setVisibility(View.VISIBLE);
                    flag4=false;
                }
                else {
                    img_head_8_topic_4.setVisibility(View.GONE);
                    flag4=true;
                }
            }
        });
        head_8_topic_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_head_8_topic_5.setVisibility(View.GONE);
                if(flag5)
                {
                    img_head_8_topic_5.setVisibility(View.VISIBLE);
                    flag5=false;
                }
                else {
                    img_head_8_topic_5.setVisibility(View.GONE);
                    flag5=true;
                }
            }
        });
        head_8_topic_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_head_8_topic_6.setVisibility(View.GONE);
                if(flag6)
                {
                    img_head_8_topic_6.setVisibility(View.VISIBLE);
                    flag6=false;
                }
                else {
                    img_head_8_topic_6.setVisibility(View.GONE);
                    flag6=true;
                }
            }
        });
        head_8_topic_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_head_8_topic_8.setVisibility(View.GONE);
                if(flag8)
                {
                    img_head_8_topic_8.setVisibility(View.VISIBLE);
                    flag8=false;
                }
                else {
                    img_head_8_topic_8.setVisibility(View.GONE);
                    flag8=true;
                }
            }
        });
        head_8_topic_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_head_8_topic_9.setVisibility(View.GONE);
                if(flag9)
                {
                    img_head_8_topic_9.setVisibility(View.VISIBLE);
                    flag9=false;
                }
                else {
                    img_head_8_topic_9.setVisibility(View.GONE);
                    flag9=true;
                }
            }
        });

        help_center_1 = rootview.findViewById(R.id.help_center_1);
        help_center_1.setText(Html.fromHtml("\u25aa\u00a0\u00a0 List of Help Centers for Higher Education (BA, BCom, B.Sc, BBA, BCA etc) \u00a0\u00a0(\u00a0\u00a0<a href=\"#\" style=\"color:\"#000\";>CLICK HERE</a>\u00a0\u00a0)"));
        help_center_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://mysy.guj.nic.in/Noticeboard/MYSY_HC_HIGHER_310817.pdf"));
                startActivity(intent);
            }
        });

        help_center_2 = rootview.findViewById(R.id.help_center_2);
        help_center_2.setText(Html.fromHtml("\u25aa\u00a0\u00a0 List of Help Centers for Medical, Dental, Paramedical, Ayurvedic, Nursing etc. Courses \u00a0\u00a0(\u00a0\u00a0<a href=\"#\" style=\"color:\"#000\";>CLICK HERE</a>\u00a0\u00a0)"));
        help_center_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://mysy.guj.nic.in/Noticeboard/MYSY_HC_MEDICAL_310817.pdf"));
                startActivity(intent);
            }
        });

        help_center_3 = rootview.findViewById(R.id.help_center_3);
        help_center_3.setText(Html.fromHtml("\u25aa\u00a0\u00a0 List of Help Centers for Engineering, Pharmacy and Architecture etc. Courses\u00a0\u00a0(\u00a0\u00a0<a href=\"#\" style=\"color:\"#000\";>CLICK HERE</a>\u00a0\u00a0)"));
        help_center_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://mysy.guj.nic.in/Noticeboard/MYSY_HC_TECH_310817.pdf"));
                startActivity(intent);
            }
        });

        help_center_4 = rootview.findViewById(R.id.help_center_4);
        help_center_4.setText(Html.fromHtml("\u25aa\u00a0\u00a0 List of Help Centers for Agriculture, Veterinary, Animal Husbandary and Fisheries etc. courses. \u00a0\u00a0(\u00a0\u00a0<a href=\"#\" style=\"color:\"#000\";>CLICK HERE</a>\u00a0\u00a0)"));
        help_center_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://mysy.guj.nic.in/Noticeboard/MYSY_HC_AGRI_310817.pdf"));
                startActivity(intent);
            }
        });

    }
}
