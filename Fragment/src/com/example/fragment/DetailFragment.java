package com.example.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class DetailFragment extends Fragment {
public static DetailFragment newInstance(int index){
	DetailFragment f=new DetailFragment();
	Bundle bundle=new Bundle();
	bundle.putInt("index", index);
	f.setArguments(bundle);
	return f;
}
public int getShownIndex(){
	return getArguments().getInt("index", 0);
}
public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
	if(container==null){
		return null;
	}
	ScrollView scroller=new ScrollView(getActivity());
	TextView text=new TextView(getActivity());
	text.setPadding(10, 10,10, 10);
	scroller.addView(text);
	text.setText(Data.DETAIL[getShownIndex()]);
	return scroller;
}
}
