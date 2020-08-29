package com.raftmc.core.events;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class ListenerManager {

	ArrayList<EventListener> listeners;
	
	public ListenerManager() {
		
		listeners = new ArrayList<EventListener>();
		
	}
	
	public void registerListener(EventListener listener) {
		
		if(!listeners.contains(listener)) {
			
			listeners.add(listener);
			
		}
		
	}
	
	public void unregisterListener(EventListener listener) {
		
		listeners.remove(listener);
		
	}
	
	public void fireEvent(Event event) {
		
		for(EventListener listener : listeners) {
				try {
					listener.getClass().getMethod("onEvent", event.getClass()).invoke(listener, event);
				} catch (NoSuchMethodException e) {
					
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
		}
		
	}
	
}
