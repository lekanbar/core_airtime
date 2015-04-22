package com.core.airtime;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import java.util.*;

import android.view.*;
import android.widget.*;

public class HistoryItemAdapter extends ArrayAdapter<AirTimeHistory> {
	int resource;
	Context context;
	
	public HistoryItemAdapter(Context _context, int _resource, List<AirTimeHistory> _items) {
		super(_context, _resource, _items);
		resource = _resource;
		context = _context;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		LinearLayout historyView;
		final int pos = position;
		AirTimeHistory item = getItem(position);
		
		String phoneString = item.getPhoneNumber(),
			   amountString = item.getAmount(),
		       dateString = item.getDateTime(),
		       currency = item.getCurrency(),
		       operator = item.getNetwork(),
		       transID = item.getTransactionID();
		
		if(convertView == null){
			historyView = new LinearLayout(getContext());
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater vi = (LayoutInflater)getContext().getSystemService(inflater);
			vi.inflate(resource, historyView, true);
		}
		else{
			historyView = (LinearLayout)convertView;
		}
		
		TextView mainView = (TextView)historyView.findViewById(R.id.rowMain);
		TextView dateView = (TextView)historyView.findViewById(R.id.rowDate);
		TextView timeView = (TextView)historyView.findViewById(R.id.rowTime);
		TextView transIDView = (TextView)historyView.findViewById(R.id.rowTransID);
		
		ImageView deleteView = (ImageView)historyView.findViewById(R.id.rowDelete);
		
		mainView.setText(operator + " " + phoneString + " [" + currency + amountString + "]");
		dateView.setText(dateString.substring(0, dateString.indexOf(' ')));
		timeView.setText(dateString.substring(dateString.indexOf(' ')));
		transIDView.setText(transID);
		
		deleteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	AlertDialog.Builder alert = new AlertDialog.Builder(((History)context));
				alert.setTitle(R.string.delTitle);
				alert.setMessage(R.string.delItem);
				alert.setPositiveButton(R.string.delete, new AlertDialog.OnClickListener(){
	
					public void onClick(DialogInterface arg0, int arg1) {
						((History)context).deleteItem(pos);
					}
				});
				alert.setNegativeButton(R.string.goback, new AlertDialog.OnClickListener(){
	
					public void onClick(DialogInterface arg0, int arg1) {
						
					}
				});
				alert.show();
            }
        });
		
		if (((History)context).isEditMode)
			deleteView.setVisibility(View.VISIBLE);
		else
			deleteView.setVisibility(View.GONE);
		
		return historyView;
	}
}
