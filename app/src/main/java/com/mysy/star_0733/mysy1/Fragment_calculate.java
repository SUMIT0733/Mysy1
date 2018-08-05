package com.mysy.star_0733.mysy1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import com.shashank.sony.fancytoastlib.FancyToast;

public class Fragment_calculate extends Fragment {

    View rootview;
    LinearLayout eng_calculator,med_calculator,dip_calculator,b_calculator;
    ImageView info;
    Spinner stream;
    int book,tution,hostel,total;
    RadioButton type;
    Spinner spinner_book,spinner_hostel;
    TextView book_amt,tution_amt,hostel_amt;
    RadioGroup radio_grp;
    RadioButton sfi;
    CardView calculate;
    TextView total_amt;
    EditText tution_fee;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_calculate,container,false);
        return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        init();
    }

    public void init() {

        info = rootview.findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FancyToast.makeText(getContext(),"Click on Gray Area to change Field",FancyToast.LENGTH_LONG,R.drawable.ic_info,false).show();
            }
        });

        eng_calculator =  rootview.findViewById(R.id.eng_calculator);
        med_calculator = rootview.findViewById(R.id.med_calculator);
        dip_calculator = rootview.findViewById(R.id.dip_calculator);
        b_calculator = rootview.findViewById(R.id.b_calculator);


        stream = rootview.findViewById(R.id.stream);

        stream.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String select = stream.getItemAtPosition(position).toString();
                if ("ENGG. / PARA-MEDIACL / D2D".equals(select)) {
                    eng_calculator.setVisibility(View.VISIBLE);
                    med_calculator.setVisibility(View.GONE);
                    dip_calculator.setVisibility(View.GONE);
                    b_calculator.setVisibility(View.GONE);


                    sfi = rootview.findViewById(R.id.sfi);
                    book_amt = rootview.findViewById(R.id.book_amt);
                    tution_amt = rootview.findViewById(R.id.tution_amt);
                    hostel_amt = rootview.findViewById(R.id.hostel_amt);

                    tution_fee = rootview.findViewById(R.id.tution_fee);
                    tution_fee.setText("");

                    spinner_hostel = rootview.findViewById(R.id.hostel_spinner);
                    spinner_hostel.setSelection(0);
                    spinner_book = rootview.findViewById(R.id.renew_spinner);
                    spinner_book.setSelection(0);

                    calculate = rootview.findViewById(R.id.calculate);
                    total_amt = rootview.findViewById(R.id.total_amt);

                    total_amt.setText(R.string.calculate);

                    book=5000;
                    hostel=12000;
                    tution=0;
                    total=0;

                    spinner_book.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (spinner_book.getSelectedItem().equals("Fresh")) {
                                book_amt.setText(R.string.eng_book);
                                book = 5000;

                            } else {
                                book_amt.setText("0");
                                book = 0;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) { }
                    });

                    spinner_hostel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (spinner_hostel.getSelectedItem().equals("Hostel(PRIVATE)") || spinner_hostel.getSelectedItem().equals("Paying Guest")) {
                                hostel_amt.setText(R.string.hostel);
                                hostel = 12000;

                            } else {
                                hostel_amt.setText("0");
                                hostel = 0;
                            }
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) { }
                    });


                    radio_grp = rootview.findViewById(R.id.radio_grp);
                    radio_grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup radioGroup, int i) {
                            int id = radioGroup.getCheckedRadioButtonId();
                            type = rootview.findViewById(id);
                            switch (type.getText().toString()) {
                                case "SFI":
                                    tution_fee.setVisibility(View.VISIBLE);
                                    tution_amt.setText(R.string.eng_fee);
                                    break;
                                case "GIA":
                                    tution_fee.setVisibility(View.GONE);
                                    tution_amt.setText("0");
                                    tution = 0;
                                    break;
                                case "TFWs":
                                    tution_fee.setVisibility(View.GONE);
                                    tution_amt.setText("0");
                                    tution = 0;
                                    break;
                            }
                        }
                    });

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int id = radio_grp.getCheckedRadioButtonId();
                            type = rootview.findViewById(id);
                            if (type.getText().toString().equals("SFI")) {
                                if (!tution_fee.getText().toString().equals("")) {
                                    int edit_tution = Integer.parseInt(tution_fee.getText().toString().trim());
                                    if ((edit_tution / 2) > 50000) {
                                        tution_amt.setText(R.string.eng_fee);
                                        tution = 50000;
                                    } else {
                                        tution_amt.setText(String.valueOf(edit_tution / 2));
                                        tution = edit_tution / 2;
                                    }
                                    total = book + hostel + tution;
                                    total_amt.setText(String.valueOf(total));
                                } else {
                                    FancyToast.makeText(getContext(),"Please Enter College Fee",FancyToast.LENGTH_LONG,FancyToast.ERROR,false).show();
                                    total_amt.setText(R.string.calculate);

                                }
                            } else {
                                total = book + hostel;
                                total_amt.setText(String.valueOf(total));
                            }
                        }
                    });

                }

                else if ("MEDICAL / DENTAL".equals(select)) {
                    eng_calculator.setVisibility(View.GONE);
                    med_calculator.setVisibility(View.VISIBLE);
                    dip_calculator.setVisibility(View.GONE);
                    b_calculator.setVisibility(View.GONE);



                    sfi = rootview.findViewById(R.id.med_sfi);
                    book_amt = rootview. findViewById(R.id.med_book_amt);
                    tution_amt = rootview.findViewById(R.id.med_tution_amt);
                    hostel_amt = rootview.findViewById(R.id.med_hostel_amt);

                    tution_fee = rootview.findViewById(R.id.med_tution_fee);
                    tution_fee.setText("");

                    spinner_hostel = rootview.findViewById(R.id.med_hostel_spinner);
                    spinner_hostel.setSelection(0);
                    spinner_book = rootview.findViewById(R.id.med_renew_spinner);

                    calculate = rootview.findViewById(R.id.med_calculate);
                    total_amt = rootview.findViewById(R.id.med_total_amt);

                    total_amt.setText(R.string.calculate);

                    book=10000;
                    hostel=12000;
                    tution=0;
                    total=0;
                    spinner_book.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (spinner_book.getSelectedItem().equals("Fresh")) {
                                book_amt.setText(R.string.med_book);
                                book = 10000;
                            } else {
                                book_amt.setText("0");
                                book = 0;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) { }
                    });

                    spinner_hostel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (spinner_hostel.getSelectedItem().equals("Hostel(PRIVATE)") || spinner_hostel.getSelectedItem().equals("Paying Guest")) {
                                hostel_amt.setText(R.string.hostel);
                                hostel = 12000;
                            } else {
                                hostel_amt.setText("0");
                                hostel = 0;
                            }
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) { }
                    });


                    radio_grp = rootview.findViewById(R.id.med_radio_grp);

                    radio_grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup radioGroup, int i) {
                            int id = radioGroup.getCheckedRadioButtonId();
                            type = rootview.findViewById(id);
                            switch (type.getText().toString()) {
                                case "SFI":
                                    tution_fee.setVisibility(View.VISIBLE);
                                    tution_amt.setText(R.string.med_fee);
                                    break;
                                case "GIA":
                                    tution_fee.setVisibility(View.GONE);
                                    tution_amt.setText("0");
                                    tution = 0;
                                    break;
                                case "TFWs":
                                    tution_fee.setVisibility(View.GONE);
                                    tution_amt.setText("0");
                                    tution = 0;
                                    break;
                            }
                        }
                    });

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int id = radio_grp.getCheckedRadioButtonId();
                            type = rootview.findViewById(id);
                            if (type.getText().toString().equals("SFI")) {
                                if (!tution_fee.getText().toString().equals("")) {
                                    int edit_tution = Integer.parseInt(tution_fee.getText().toString().trim());
                                    if ((edit_tution / 2) > 200000) {
                                        tution_amt.setText(R.string.med_fee);
                                        tution = 200000;
                                    } else {
                                        tution_amt.setText(String.valueOf(edit_tution / 2));
                                        tution = edit_tution / 2;
                                    }
                                    total = book + hostel + tution;
                                    total_amt.setText(String.valueOf(total));
                                } else {
                                    FancyToast.makeText(getContext(),"Please Enter College Fee",FancyToast.LENGTH_LONG,FancyToast.ERROR,false).show();
                                    total_amt.setText(R.string.calculate);

                                }
                            } else {
                                total = book + hostel + tution;
                                total_amt.setText(String.valueOf(total));
                            }
                        }
                    });


                } else if ("DIPLOMA".equals(select)) {
                    eng_calculator.setVisibility(View.GONE);
                    med_calculator.setVisibility(View.GONE);
                    dip_calculator.setVisibility(View.VISIBLE);
                    b_calculator.setVisibility(View.GONE);

                    sfi = rootview.findViewById(R.id.dip_sfi);
                    book_amt = rootview.findViewById(R.id.dip_book_amt);
                    tution_amt = rootview.findViewById(R.id.dip_tution_amt);
                    hostel_amt = rootview.findViewById(R.id.dip_hostel_amt);

                    tution_fee = rootview.findViewById(R.id.dip_tution_fee);
                    tution_fee.setText("");

                    spinner_hostel = rootview.findViewById(R.id.dip_hostel_spinner);
                    spinner_hostel.setSelection(0);
                    spinner_book = rootview.findViewById(R.id.dip_renew_spinner);
                    spinner_book.setSelection(0);

                    calculate = rootview.findViewById(R.id.dip_calculate);
                    total_amt = rootview.findViewById(R.id.dip_total_amt);

                    total_amt.setText(R.string.calculate);

                    book=3000;
                    hostel=12000;
                    tution=0;
                    total=0;
                    spinner_book.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (spinner_book.getSelectedItem().equals("Fresh")) {
                                book_amt.setText(R.string.dip_book);
                                book = 3000;

                            } else {
                                book_amt.setText("0");
                                book = 0;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) { }
                    });

                    spinner_hostel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (spinner_hostel.getSelectedItem().equals("Hostel(PRIVATE)") || spinner_hostel.getSelectedItem().equals("Paying Guest")) {
                                hostel_amt.setText(R.string.hostel);
                                hostel = 12000;
                            } else {
                                hostel_amt.setText("0");
                                hostel = 0;
                            }
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) { }
                    });


                    radio_grp = rootview.findViewById(R.id.dip_radio_grp);
                    radio_grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup radioGroup, int i) {
                            int id = radioGroup.getCheckedRadioButtonId();
                            type = rootview.findViewById(id);
                            switch (type.getText().toString()) {
                                case "SFI":
                                    tution_fee.setVisibility(View.VISIBLE);
                                    tution_amt.setText(R.string.dip_fee);
                                    break;
                                case "GIA":
                                    tution_fee.setVisibility(View.GONE);
                                    tution_amt.setText("0");
                                    tution = 0;
                                    break;
                                case "TFWs":
                                    tution_fee.setVisibility(View.GONE);
                                    tution_amt.setText("0");
                                    tution = 0;
                                    break;
                            }
                        }
                    });

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int id = radio_grp.getCheckedRadioButtonId();
                            type = rootview.findViewById(id);
                            if (type.getText().toString().equals("SFI")) {
                                if (!tution_fee.getText().toString().equals("")) {
                                    int edit_tution = Integer.parseInt(tution_fee.getText().toString().trim());
                                    if ((edit_tution / 2) > 25000) {
                                        tution_amt.setText(R.string.dip_fee);
                                        tution = 25000;
                                    } else {
                                        tution_amt.setText(String.valueOf(edit_tution / 2));
                                        tution = edit_tution / 2;
                                    }
                                    total = book + hostel + tution;
                                    total_amt.setText(String.valueOf(total));
                                } else {
                                    FancyToast.makeText(getContext(),"Please Enter College Fee",FancyToast.LENGTH_LONG,FancyToast.ERROR,false).show();
                                    total_amt.setText(R.string.calculate);

                                }
                            } else {
                                total = book + hostel;
                                total_amt.setText(String.valueOf(total));
                            }
                        }
                    });


                } else if ("BA/B.COM/B.Sc/BBA/BCA".equals(select)) {
                    eng_calculator.setVisibility(View.GONE);
                    med_calculator.setVisibility(View.GONE);
                    dip_calculator.setVisibility(View.GONE);
                    b_calculator.setVisibility(View.VISIBLE);

                    sfi = rootview.findViewById(R.id.b_sfi);
                    book_amt = rootview.findViewById(R.id.b_book_amt);
                    tution_amt = rootview.findViewById(R.id.b_tution_amt);
                    hostel_amt = rootview.findViewById(R.id.b_hostel_amt);

                    tution_fee = rootview.findViewById(R.id.b_tution_fee);
                    tution_fee.setText("");

                    spinner_hostel = rootview.findViewById(R.id.b_hostel_spinner);
                    spinner_hostel.setSelection(0);
                    spinner_book = rootview.findViewById(R.id.b_renew_spinner);
                    spinner_book.setSelection(0);

                    calculate = rootview.findViewById(R.id.b_calculate);
                    total_amt = rootview.findViewById(R.id.b_total_amt);

                    total_amt.setText(R.string.calculate);

                    book=0;
                    hostel=12000;
                    tution=0;
                    total=0;
                    spinner_book.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (spinner_book.getSelectedItem().equals("Fresh")) {
                                book_amt.setText("0");
                                book = 0;

                            } else {
                                book_amt.setText("0");
                                book = 0;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });

                    spinner_hostel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (spinner_hostel.getSelectedItem().equals("Hostel(PRIVATE)") || spinner_hostel.getSelectedItem().equals("Paying Guest")) {
                                hostel_amt.setText(R.string.hostel);
                                hostel = 12000;
                            } else {
                                hostel_amt.setText("0");
                                hostel = 0;
                            }
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });


                    radio_grp = rootview.findViewById(R.id.b_radio_grp);
                    radio_grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup radioGroup, int i) {
                            int id = radioGroup.getCheckedRadioButtonId();
                            type = rootview.findViewById(id);
                            switch (type.getText().toString()) {
                                case "SFI":
                                    tution_fee.setVisibility(View.VISIBLE);
                                    tution_amt.setText(R.string.b_fee);
                                    break;
                                case "GIA":
                                    tution_fee.setVisibility(View.GONE);
                                    tution_amt.setText("0");
                                    tution = 0;
                                    break;
                                case "TFWs":
                                    tution_fee.setVisibility(View.GONE);
                                    tution_amt.setText("0");
                                    tution = 0;
                                    break;
                            }
                        }
                    });

                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int id = radio_grp.getCheckedRadioButtonId();
                            type = rootview.findViewById(id);
                            if (type.getText().toString().equals("SFI")) {
                                if (!tution_fee.getText().toString().equals("")) {
                                    int edit_tution = Integer.parseInt(tution_fee.getText().toString().trim());
                                    if ((edit_tution / 2) > 10000) {
                                        tution_amt.setText(R.string.b_fee);
                                        tution = 10000;
                                    } else {
                                        tution_amt.setText(String.valueOf(edit_tution / 2));
                                        tution = edit_tution / 2;
                                    }
                                    total = book + hostel + tution;
                                    total_amt.setText(String.valueOf(total));
                                } else {
                                    FancyToast.makeText(getContext(),"Please Enter College Fee",FancyToast.LENGTH_LONG,FancyToast.ERROR,false).show();
                                    total_amt.setText(R.string.calculate);

                                }
                            } else {
                                total = book + hostel;
                                total_amt.setText(String.valueOf(total));
                            }
                        }
                    });

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }


}
