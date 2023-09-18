package com.java.concurrent.forkjoin;

import java.util.ArrayList;
import java.util.List;

public class ItemFactory {

	static List<Item> getItems(int numberOfItem){
		List<Item> items = new ArrayList<>();
		for(int i =0; i<numberOfItem; i++) {
			Item item = new Item(i, "item no"+i, 20);
			items.add(item);
		}
		return items;
	}
}
