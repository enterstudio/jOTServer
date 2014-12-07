package org.jotserver.ot.model.chat;

import java.util.LinkedList;

import org.jotserver.ot.model.creature.Creature;

public class ChannelEventMappings {
	
	private LinkedList<ChatChannelSayHandler> mappings;
	
	public ChannelEventMappings() {
		mappings = new LinkedList<ChatChannelSayHandler>();
	}
	
	public void addHandler(ChatChannelSayHandler handler) {
		mappings.add(handler);
	}
	
	public boolean onSay(Creature creature, SpeakType type, String message) {
		for(ChatChannelSayHandler handler : mappings) {
			if(!handler.onSay(creature, type, message)) {
				return false;
			}
		}
		return true;
	}
	
}
