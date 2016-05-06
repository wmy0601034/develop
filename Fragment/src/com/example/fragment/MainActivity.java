package com.example.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	
  public static class DetailActivity extends Activity{
	  protected void onCreate(Bundle savedInstanceState){
		  super.onCreate(savedInstanceState);
		  if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
			  finish();
			  return;
		  }
		  if(savedInstanceState==null){
			  DetailFragment details=new DetailFragment();
			  details.setArguments(getIntent().getExtras());
			  getFragmentManager().beginTransaction().add(R.id.detail,details).commit();
		  }
	  }
  }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		/*class ListFragment extends android.app.ListFragment {
			  boolean dualPane;
			  int curCheckPosition=0;
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
			  */

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
