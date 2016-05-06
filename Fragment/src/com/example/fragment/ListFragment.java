package com.example.fragment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFragment extends android.app.ListFragment {
  boolean dualPane;
  int curCheckPosition=0;
  @Override
  public void onActivityCreated(Bundle savedInStanceState){
	  super.onActivityCreated(savedInStanceState);
	  setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_checked,Data.TITLES));
	  View detailFrame=getActivity().findViewById(R.id.detail);
	  dualPane=detailFrame!=null&&detailFrame.getVisibility()==View.VISIBLE;
	  if(savedInStanceState!=null){
		  curCheckPosition=savedInStanceState.getInt("curCheck",0);
	  }
	  if(dualPane){
		  getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		  showDetails(curCheckPosition);
	  }
  }
  @Override
  public void onSaveInstanceState(Bundle outState){
	  super.onSaveInstanceState(outState);
	  outState.putInt("curChoice", curCheckPosition);
  }
  @Override
  public void onListItemClick(ListView l,View v,int position,long id){
	  showDetails(position);
  }
  public void showDetails(int index){
	  curCheckPosition=index;
	  if(dualPane){
		  getListView().setItemChecked(index, true);
		  DetailFragment details=(DetailFragment)getFragmentManager().findFragmentById(R.id.detail);
		  if(details==null||details.getShownIndex()!=index){
			  details=DetailFragment.newInstance(index);
			  FragmentTransaction ft=getFragmentManager().beginTransaction();
			  ft.replace(R.id.detail,details);
			  ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			  ft.commit();
		  }else{
			  Intent intent=new Intent();
			  intent.putExtra("index", index);
			  startActivity(intent);
		  }
	  }
  }
}
