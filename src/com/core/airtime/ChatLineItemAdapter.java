package com.core.airtime;

import android.content.Context;
import android.graphics.Color;

import java.util.*;

import android.text.Html;
import android.util.TypedValue;
import android.view.*;
import android.widget.*;

public class ChatLineItemAdapter extends ArrayAdapter<ChatLine> {
	int resource;
	
	public ChatLineItemAdapter(Context _context, int _resource, List<ChatLine> _items) {
		super(_context, _resource, _items);
		resource = _resource;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		LinearLayout historyView;
		ChatLine item = getItem(position);
		
		String dateString = item.getDate();
		String nameString = item.getName();
		String msgString = item.getMessage();
		String isUser = item.getIsUser();
		
		if(convertView == null){
			historyView = new LinearLayout(getContext());
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater vi = (LayoutInflater)getContext().getSystemService(inflater);
			vi.inflate(resource, historyView, true);
		}
		else{
			historyView = (LinearLayout)convertView;
		}
		
		TextView dateView = (TextView)historyView.findViewById(R.id.rowDate);
		TextView msgView = (TextView)historyView.findViewById(R.id.row);
		
		dateView.setText(dateString);
		dateView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12.0f);
		
		if(isUser.equals("true")){
			msgView.setText(nameString + ": " + msgString);
			msgView.setTextColor(Color.BLUE);
			msgView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14.0f);
		}
		else{
			msgView.setTextColor(Color.BLACK);
			msgView.setText(Html.fromHtml("<font color=\"blue\">" + nameString + "</font>: " + msgString));
			msgView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14.0f);
		}
		
		return historyView;
	}
}
