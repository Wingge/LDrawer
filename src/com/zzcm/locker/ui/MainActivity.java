package com.zzcm.locker.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zzcm.locker.R;
import com.zzcm.locker.ui.base.BaseActivity;
import com.zzcm.locker.ui.drawer.ActionBarDrawerToggle;
import com.zzcm.locker.ui.drawer.DrawerArrowDrawable;
import com.zzcm.locker.ui.util.SDKUtil;


public class MainActivity extends BaseActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerArrowDrawable drawerArrow;
    private boolean drawerArrowColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mDrawerList = (ListView) findViewById(R.id.navdrawer);


        drawerArrow = new DrawerArrowDrawable(this) {
            @Override
            public boolean isLayoutRtl() {
                return false;
            }
        };
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
        		drawerArrow, R.string.drawer_open,
            R.string.drawer_close) {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP) 
            public void onDrawerClosed(View view) {
            	toolbar.setBackgroundColor(getResources().getColor(R.color.actionbar_color));
//            	toolbar.setBackgroundDrawable(getResources().getDrawable(R.color.actionbar_color));
            	if(SDKUtil.IS_L){
            		getWindow().setStatusBarColor(getResources().getColor(R.color.actionbar_color));
            	}
                super.onDrawerClosed(view);
                ActivityCompat.invalidateOptionsMenu(MainActivity.this);
            }

            @TargetApi(Build.VERSION_CODES.LOLLIPOP) 
            public void onDrawerOpened(View drawerView) {
            	toolbar.setBackgroundColor(getResources().getColor(R.color.actionbar_color2));
            	if(SDKUtil.IS_L){
            		getWindow().setStatusBarColor(getResources().getColor(R.color.actionbar_color2));
            	}
//            	toolbar.setBackgroundDrawable(getResources().getDrawable(R.color.actionbar_color2));
                super.onDrawerOpened(drawerView);
                ActivityCompat.invalidateOptionsMenu(MainActivity.this);
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();


        String[] values = new String[]{
            "Stop Animation (Back icon)",
            "Stop Animation (Home icon)",
            "Start Animation",
            "Change Color",
            "GitHub Page",
            "Share",
            "Rate"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            R.layout.left_drawer_item, android.R.id.text1, values);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        mDrawerToggle.setAnimateEnabled(false);
                        drawerArrow.setProgress(1f);
                        break;
                    case 1:
                        mDrawerToggle.setAnimateEnabled(false);
                        drawerArrow.setProgress(0f);
                        break;
                    case 2:
                        mDrawerToggle.setAnimateEnabled(true);
                        mDrawerToggle.syncState();
                        break;
                    case 3:
                        if (drawerArrowColor) {
                            drawerArrowColor = false;
                            drawerArrow.setColor(getResources().getColor(R.color.ldrawer_color));
//                            drawerArrow.setColor(R.color.ldrawer_color);
                        } else {
                            drawerArrowColor = true;
                            drawerArrow.setColor(getResources().getColor(R.color.drawer_arrow_second_color));
//                            drawerArrow.setColor(R.color.drawer_arrow_second_color);
                        }
                        mDrawerToggle.syncState();
                        break;
                    case 4:
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/IkiMuhendis/LDrawer"));
                        startActivity(browserIntent);
                        break;
                    case 5:
                        Intent share = new Intent(Intent.ACTION_SEND);
                        share.setType("text/plain");
                        share.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        share.putExtra(Intent.EXTRA_SUBJECT,
                            getString(R.string.app_name));
                        share.putExtra(Intent.EXTRA_TEXT, getString(R.string.app_description) + "\n" +
                            "GitHub Page :  https://github.com/IkiMuhendis/LDrawer\n" +
                            "Sample App : https://play.google.com/store/apps/details?id=" +
                            getPackageName());
                        startActivity(Intent.createChooser(share,
                            getString(R.string.app_name)));
                        break;
                    case 6:
                        String appUrl = "https://play.google.com/store/apps/details?id=" + getPackageName();
                        Intent rateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(appUrl));
                        startActivity(rateIntent);
                        break;
                }

            }
        });
    }
    
    DrawerLayout drawer;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP) 
    private void initView(){
        setActionBarIcon(R.drawable.ic_drawer);
//        GridView gridView = (GridView) findViewById(R.id.gridView);
//        gridView.setAdapter(new GridViewAdapter());
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String url = (String) view.getTag();
//                DetailActivity.launch(HomeActivity.this, view.findViewById(R.id.image), url);
//            }
//        });
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.setDrawerShadow(R.drawable.drawer_shadow, Gravity.START);
    	if(SDKUtil.IS_L){
    		getWindow().setStatusBarColor(getResources().getColor(R.color.actionbar_color));
    	}
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	FragmentManager fragmentManager = getSupportFragmentManager();
    	Fragment fragment = null;
        switch (item.getItemId()) {
		case android.R.id.home:
			if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
				mDrawerLayout.closeDrawer(mDrawerList);
			} else {
				mDrawerLayout.openDrawer(mDrawerList);
			}
			fragment = new WidgetFrament();
			break;
		case R.id.action_settings:
			fragment = new WidgetFrament2();
//			Bundle args = new Bundle();
//			fragment.setArguments(args);
			break;

		default:
			fragment = new WidgetFrament();
			break;
		}
        
        fragmentManager.beginTransaction()
        .replace(R.id.content_frame, fragment)
        .commit();
        
        return super.onOptionsItemSelected(item);
    }

    @Override protected int getLayoutResource() {
        return R.layout.app_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
