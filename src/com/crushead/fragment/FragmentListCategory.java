package com.crushead.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.crushead.R;
import com.crushead.list.Adapter;
import com.crushead.list.DataItem;
import com.crushead.utils.Constant;
import com.crushead.utils.DrawableProvider;

public class FragmentListCategory extends ListFragment{

	private Callbacks mCallbacks = sCallbacks;
	public static Context context;
	public static ArrayList<DataItem> LIST = new ArrayList<DataItem>();
	public static Map<String, DataItem> LIST_HASHMAP = new HashMap<String, DataItem>();
	List<DataItem> list;
    DrawableProvider mProvider;
    
	/** Auto Llama */
	public interface Callbacks {
		public void onItemSelected(String id);
	}

	private static Callbacks sCallbacks = new Callbacks() {
		@Override
		public void onItemSelected(String id) {
		}
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActivity().getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.main));
		getActivity().getActionBar().setTitle("Categoria");		
		mProvider = new DrawableProvider(getActivity());
		FragmentListCategory.LIST.clear();
		FragmentListCategory.LIST_HASHMAP.clear();		
		addEntry(new DataItem("Animales", mProvider.getRect("A", Color.rgb(3, 169, 244)) , DrawableProvider.SAMPLE_RECT, Constant.ANIMALES));
		addEntry(new DataItem("Frutas y Verduras", mProvider.getRect("F", Color.rgb(139, 195, 74)) , DrawableProvider.SAMPLE_RECT, Constant.FRUTAS));
		addEntry(new DataItem("Dibujos Geométricos", mProvider.getRect("D", Color.rgb(233, 30, 99)) , DrawableProvider.SAMPLE_RECT, Constant.FIGURAS));
		addEntry(new DataItem("Cosas del Hogar", mProvider.getRect("C", Color.rgb(156, 39, 176)) , DrawableProvider.SAMPLE_RECT, Constant.ARTICULOS));
		addEntry(new DataItem("Paises", mProvider.getRect("P", Color.rgb(0, 188, 212)) , DrawableProvider.SAMPLE_RECT, Constant.PAISES));		
		setListAdapter(new Adapter(getActivity(), FragmentListCategory.LIST));
		
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		// Las actividades que contengan este fragmento deben implementar este callback
		if (!(activity instanceof Callbacks)) {
			throw new IllegalStateException("Error: La actividad debe implementar el callback del fragmento");
		}
		
		mCallbacks = (Callbacks) activity;
		
	}

	@Override
	public void onDetach() {
		super.onDetach();
		// Resetear los callbacks activos a los vacíos.
		mCallbacks = sCallbacks;
	}

	@Override
	public void onListItemClick(ListView listView, View view, int position, long id) {
		super.onListItemClick(listView, view, position, id);		
		mCallbacks.onItemSelected(FragmentListCategory.LIST.get(position).id);
	}
	
	private static void addEntry(DataItem entrada) {
		LIST.add(entrada);
		LIST_HASHMAP.put(entrada.id, entrada);
	}
	
}//end Class