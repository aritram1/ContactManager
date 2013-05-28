package com.contact.contactmanager;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabWidget;

public class MainActivity extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_page);
        
        ListView list = (ListView)findViewById(R.layout.splash_page);
        
        ArrayList<String> accountNames = new ArrayList<String>();
        for(Account a : AccountManager.get(this).getAccounts()){
        	accountNames.add(a.name);
        }
        if(accountNames.size() > 0){
        	myadapter m = new myadapter(this, R.layout.account_entry, accountNames);
        	list.setAdapter(m);
        }
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private class myadapter extends ArrayAdapter<String>{

		public myadapter(Context context, int textViewResourceId, List<String> objects) {
			super(context, textViewResourceId, objects);			
		}
		
    	
    }

    
}

